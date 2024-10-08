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
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        ConnectionJDBC connectionJDBC = new ConnectionJDBC();
        Connection conn;

        Scanner sc = new Scanner(System.in);

        try {
            conn = connectionJDBC.getConnection();

            SellerDao sellerDao = DaoFactory.createSellerDao(conn);


            System.out.println("=== TEST 1: seller findById =====");
            Seller seller = sellerDao.findById(3);
            System.out.println(seller);

            System.out.println("\n=== TEST 2: seller findByDepartment =====");
            Department department = new Department(2, null);
            List<Seller> list = sellerDao.findByDepartment(department);
            for (Seller obj : list) {
                System.out.println(obj);
            }

            System.out.println("\n=== TEST 3: seller findAll =====");
            list = sellerDao.findAll();
            for (Seller obj : list) {
                System.out.println(obj);
            }

            System.out.println("\n=== TEST 4: seller insert =====");
            Seller newSeller = new Seller(null, "Bryan", "Bryan@gmail.com", new Date(), 5000.0, department);
            sellerDao.insert(newSeller);
            System.out.println("Inserted! New id = " + newSeller.getId());

            System.out.println("\n=== TEST 5: seller update =====");
            seller = sellerDao.findById(1);
            seller.setName("Martha Wayne");
            sellerDao.update(seller);
            System.out.println("Update completed");

            System.out.println("\n=== TEST 6: seller delete =====");
            System.out.println("Enter id for delete test: ");
            int id = sc.nextInt();
            sellerDao.deleteById(id);
            System.out.println("Delete completed");

            sc.close();
        }
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        finally {
            DB.closeConnection();
        }
    }
}


