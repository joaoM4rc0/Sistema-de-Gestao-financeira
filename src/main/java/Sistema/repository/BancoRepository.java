package Sistema.repository;

import Sistema.conn.ConnectionFactory;
import Sistema.dominio.Banco;
import Sistema.dominio.ClienteCadastrado;
import Sistema.dominio.PessoaFisica;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Log4j2
public class BancoRepository {
    public static void InsertCliente(String name, String cpf) {
        // esse metodo vai inserir ao banco de dados um cliente, com seu nome e o seu cpf
        // dps irei fazer a verificação do cpf
        validaCpf(cpf);
        try(Connection conn = ConnectionFactory.connectionFactory();
            PreparedStatement ps = insertCliente(conn, name, cpf)) {
            ps.execute();
            log.info("salvando cliente no banco de dados....");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void updateSaldo(double value, int id) {
        try(Connection conn = ConnectionFactory.connectionFactory();
            PreparedStatement ps = UpdateValue(conn, value, id)) {
            int rowsAfectted = ps.executeUpdate();
            if (rowsAfectted == 0) throw new IllegalArgumentException("esse id nao existe");
            log.info("Saldo atualizado para o ID {}: Valor={}", id, value);
        } catch (SQLException e) {
            log.info("erro ao atualizar o saldo do cliente");
            throw new RuntimeException(e);
        }
    }
    public static Optional<ClienteCadastrado> findById(int id) {
        try(Connection conn = ConnectionFactory.connectionFactory();
            PreparedStatement ps = preaparedfindById(conn, id);
            ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                ClienteCadastrado clienteCadastrado = ClienteCadastrado.builder()
                        .name(rs.getString("name"))
                        .id(rs.getInt("id"))
                        .build();
                return Optional.of(clienteCadastrado);
            }else {
                log.warn("nenhum cliente encontrado com o ID {}", id);
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private static PreparedStatement preaparedfindById(Connection conn, int id) throws SQLException {
        String sql = "SELECT * FROM Banco_do_serasa.Cliente WHERE id like ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        //cria um PreparedStatement com a consulta SQL fornecida.
        ps.setInt(1, id);
        return ps;
    }

    private static PreparedStatement insertCliente(Connection conn, String name, String cpf) throws SQLException {
        String sql = "INSERT INTO `Banco_do_serasa`.`Cliente` (`name`, `cpf`, `saldo`) VALUES(?, ?, ?);";
        // eu tenho que adicionar um valor no saldo para o banco de daods
        // mas eu deixei ele como '0' ou seja sem saldo
        // porque eu fiz um metodo update para valor
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, cpf);
        ps.setInt(3, 0);
        return ps;
    }
    private static PreparedStatement UpdateValue(Connection conn, double valor, int id) throws SQLException {
        String sql = "UPDATE `Banco_do_serasa`.`Cliente` SET saldo= ? WHERE id=(?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setDouble(1, valor);
        ps.setInt(2, id);
        return ps;
    }
    private static boolean validaCpf(String cpf) {
        cpf = cpf.replaceAll("[^1-9]", "");

        if(cpf.length() < 11 || cpf.matches("(\\d)\\1{10}")) {
            return false;
        }
        //A expressão regular (\\d)\\1{10} verifica se todos os dígitos são iguais (por exemplo, 111.111.111-11).
        int soma=0;
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)* (10 -1));
        }
        int primeiroDigito = 11 - (soma % 11);
        if (primeiroDigito > 9) {
            primeiroDigito = 0;
        }
        // Calcula o segundo dígito verificador
        int segundoDigito = (soma % 11);
        if(segundoDigito > 9 ) {
            segundoDigito = 0;
        }
        //    O primeiro dígito verificador é calculado multiplicando
        //    cada um dos 9 primeiros dígitos por um peso decrescente (de 10 a 2) e somando os resultados.
        //    O segundo dígito verificador é calculado de forma semelhante mas inclui o primeiro dígito verificador no cálculo.
        // Verifica se os dígitos calculados são iguais aos dígitos do CPF*
        return Character.getNumericValue(cpf.charAt(9)) == primeiroDigito && Character.getNumericValue(cpf.charAt(10)) == segundoDigito;
        //Exemplos de CPFs Válidos e Inválidos:
        //    Válidos:
        //
        //        123.456.789-09
        //
        //        529.982.247-25
        //
        //        111.444.777-35
        //    Inválidos:

        //        123.456.789-00 (dígitos verificadores incorretos)
        //
        //        111.111.111-11 (sequência repetida)
        //
        //        123 (tamanho incorreto)
    }

}
