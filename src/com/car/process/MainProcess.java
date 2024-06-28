package com.car.process;

import com.car.SQLManager;

import java.sql.Connection;

public class MainProcess {

    private static SQLManager db = new SQLManager();

    public void execute() {
        String dbURL = "jdbc:mysql://localhost:3306/dbVehicles";
        String user = System.getenv("DB_USER");
        String pwd = System.getenv("DB_PASSWORD");

        Connection con = db.initSQL(dbURL, user, pwd);
        System.out.println("after connection to db");

        db.listOfTable(con, "dbVehicles");
    }
}
