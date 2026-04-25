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

public class InsertSelect {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionUrl = "jdbc:mysql://localhost/mydatabase?user=root&password=";
            Connection con = DriverManager.getConnection(connectionUrl);
            System.out.println("Connection Established!");

            Statement stmt = con.createStatement();

            // SQL insert command
            String insertSQL = "INSERT INTO employs (firstname, lastname, location) "
                             + "VALUES ('Bob', 'Kabibi', 'Kigali')";
            int rowsInserted = stmt.executeUpdate(insertSQL);
            System.out.println(rowsInserted + " row(s) inserted");

            // SQL select command
            String selectSQL = "SELECT * FROM employs";
            ResultSet rs = stmt.executeQuery(selectSQL);

            System.out.println("\n--- Employee List ---");
            while (rs.next()) {
                System.out.println(
                    rs.getString("firstname") + " | " +
                    rs.getString("lastname")  + " | " +
                    rs.getString("location")
                );
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        } catch (ClassNotFoundException cE) {
            System.out.println("Class Not Found Exception: " + cE.toString());
        }
    }
}