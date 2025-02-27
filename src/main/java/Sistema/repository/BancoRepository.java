package Sistema.repository;

import Sistema.conn.ConnectionFactory;
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
    private static PreparedStatement insertCliente(Connection conn, String name, String cpf) throws SQLException {
        String sql = "INSERT INTO `devdojo_maratona`.`producer` (`name`, `cpf`, `saldo`) VALUES(?, ?, ?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, String.format("%%%s%%", name));
        ps.setString(2, String.format("%%%s%%", cpf));
        ps.setInt(3, 0);
        return ps;
    }
}
