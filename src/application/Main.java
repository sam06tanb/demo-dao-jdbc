package application;
import application.data.ConnectionJDBC;
import db.DB;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;
import java.sql.Connection;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) {

        ConnectionJDBC connectionJDBC = new ConnectionJDBC();
        Connection conn;

        try {
            conn = connectionJDBC.getConnection();

            SellerDao sellerDao = DaoFactory.createSellerDao(conn);
            Seller seller = sellerDao.findById(3);
            System.out.println(seller);

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
