
package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData; // use JDBC standard metadata

public class JDBCpreparedstmt {

    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/mladec";
        String user = "root";
        String pass = "root@39";

        // Use the modern MySQL driver class
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Try-with-resources for safe closing (does not change core logic)
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            String sql1 = "insert into book1 values (?, ?, ?)";
            String sql2 = "update book1 set b_name = ? where b_id = ?";
            String sql3 = "select * from book1";

            try (PreparedStatement pst1 = con.prepareStatement(sql1);
                 PreparedStatement pst2 = con.prepareStatement(sql2);
                 PreparedStatement pst3 = con.prepareStatement(sql3)) {

                // INSERT: (b_id, b_name, price)
                pst1.setInt(1, 3);
                pst1.setString(2, "Python");
                pst1.setInt(3, 100);

                // UPDATE: set name = React where id = 3
                pst2.setString(1, "React"); // correct parameter index for b_name
                pst2.setInt(2, 3);          // correct parameter index for b_id

                // Add to batch and execute (same logic, separate batches)
                pst1.addBatch();
                pst2.addBatch();

                pst1.executeBatch();
                pst2.executeBatch();

                // Query results
                try (ResultSet rs = pst3.executeQuery()) {
                    while (rs.next()) {
                        System.out.println("Id: " + rs.getInt(1) +
                                " Name: " + rs.getString(2) +
                                " Price: " + rs.getInt(3));

                        // Metadata (kept inside loop to preserve your flow)
                        ResultSetMetaData rsd = rs.getMetaData();
                        System.out.println(rsd.getColumnCount());
                        System.out.println(rsd.getColumnClassName(1));
                        System.out.println(rsd.getColumnName(1));
                    }
                }
            }
        }
    }
}
