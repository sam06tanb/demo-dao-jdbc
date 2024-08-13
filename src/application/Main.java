package application;
import application.data.ConnectionJDBC;
import db.DB;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Department o = new Department(1, "Books");

        Seller seller = new Seller(21, "Bob", "Bob@gmail.com", new Date(), 3000.0, o);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println(o);
        System.out.println(seller);

        ConnectionJDBC connectionJDBC = new ConnectionJDBC();

        Connection conn = null;

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
            DB.closeConnection();
        }
    }
}
