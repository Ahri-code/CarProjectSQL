package com.car;

import java.sql.*;

public class SQLManager {

    public Connection initSQL(String url, String user, String pwd) {

    String driver ="com.mysql.cj.jdbc.Driver";
    Connection con = null;

        try {

            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pwd);

        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found :" + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e ) {
            System.out.println("SQL error :" + e.getMessage());
            e.printStackTrace();
        }

        return con;
    }

    public void listOfTable(Connection con, String dbName) {

        try {
            DatabaseMetaData dbMD = con.getMetaData();
            ResultSet res = dbMD.getTables(dbName, null, null, null);

            while(res.next()) {
                System.out.println("Table name:" + res.getString("TABLE_NAME"));
            }
        } catch (SQLException e) {
            System.out.println("SQL error :" + e.getMessage());
            e.printStackTrace();
        }
    }

}
