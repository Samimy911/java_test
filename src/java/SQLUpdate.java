/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java;

/**
 *
 * @author Samson
 */


import java.sql.*;

public class SQLUpdate {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionUrl = "jdbc:mysql://localhost/mydatabase?user=root&password=";
            Connection con = DriverManager.getConnection(connectionUrl);
            System.out.println("Connection Established!");

            Statement stmt = con.createStatement();

            // SQL update command
            String strSQL = "UPDATE employs SET location = 'Kigali' WHERE Identification = '1'";
            int rowsEffected = stmt.executeUpdate(strSQL);
            System.out.println(rowsEffected + " rows effected");

            stmt.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        } catch (ClassNotFoundException cE) {
            System.out.println("Class Not Found Exception: " + cE.toString());
        }
    }
}