package application;
import application.data.ConnectionJDBC;
import db.DB;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
public class Main {
    public static void main(String[] args) {
        ConnectionJDBC connectionJDBC = new ConnectionJDBC();

        Connection conn = null;
        Statement st = null;

        try {
            conn = connectionJDBC.getConnection();






        }
        catch (SQLException e) {
            e.getMessage();
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
