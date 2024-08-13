package model.dao;

import model.dao.impl.SellerDaoJDBC;

import java.sql.Connection;

public class DaoFactory {

    public static SellerDao createSellerDao(Connection conn) {
        return new SellerDaoJDBC(conn);
    }
}
