package Sistema.repository;

import Sistema.conn.ConnectionFactory;
import Sistema.dominio.PessoaFisica;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@Log4j2
public class BancoRepository {
    public static void InsertCliente(String name, String cpf) {
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
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private static PreparedStatement insertCliente(Connection conn, String name, String cpf) throws SQLException {
        String sql = "INSERT INTO `Banco_do_serasa`.`Cliente` (`name`, `cpf`, `saldo`) VALUES(?, ?, ?);";
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
}
