package Sistema.dominio;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Banco {
    private PessoaFisica clientes;
    private double saldo;
    private double receita;
    private double gastos;
    public void cadastraCliente(String name, String cpf) {
        String sql = "INSERT INTO Banco_do_serasa.Cliente (cpf, name, saldo) VALUES('111.555.000-08', 'joao marco', 0);";

    }
    public void adicionaSaldo(double valor) {

    }
}
