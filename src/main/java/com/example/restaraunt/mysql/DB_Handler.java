package com.example.restaraunt.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DB_Handler extends Configurations {
    Connection dbConnection;

    public Connection getDbConnection()
        throws ClassNotFoundException, SQLException {
        String connecrionString = "jbdc:mysql//" + dbHost + ":"
                + dbPort + "/" + dbName;

        Class.forName("com.mysql.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connecrionString,
                dbUser, dbPass);

        return dbConnection;
    }


}
