package com.example.restaraunt.mysql;

import java.sql.*;


public class DB_Handler extends Configurations {
    Connection dbConnection;

    public Connection getDbConnection()
        throws ClassNotFoundException, SQLException {
        String connecrionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName;

       // Class.forName("com.mysql.cj.jbdc.Driver"); //com.mysql.cj.jdbc.Driver maybe
        dbConnection = DriverManager.getConnection(connecrionString,
                dbUser, dbPass);

        return dbConnection;
    }

    public void registrationUsers (User user) {
        String insert = "INSERT INTO " + Constants.USER_TABLE + "(" +
                Constants.USER_NAME + "," + Constants.USER_SURNAME + "," + Constants.USER_BITHD + "," +
                Constants.USER_PASSWORD + ")" +
                "VALUES(?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getBithd());
            preparedStatement.setString(4, user.getPassword());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }

    }

  //  public ResultSet getUser( user)

}
