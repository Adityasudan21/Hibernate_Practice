package com.BasePack.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.BasePack.JDBC.DBTest.conn;

public class JDBC_Queries {

    public void create() throws SQLException {

        String createsql = "CREATE TABLE employees ("
                + "id SERIAL PRIMARY KEY, "
                + "name VARCHAR(100) NOT NULL, "
                + "age INT NOT NULL )";

        Statement stmt = conn.createStatement();
        stmt.executeUpdate(createsql);

        System.out.println("Table created successfully");
        stmt.close();
    }
    public void read() throws SQLException {
        // Step 3: Execute SELECT query
        String readsql = "SELECT * FROM employees";

        // Step 2: Create Statement
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(readsql);

        // Step 4: Iterate through rows
        System.out.println("ID | Name | Age");
        System.out.println("----------------");

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");

            System.out.println(id + " | " + name + " | " + age);
        }

        // Step 5: Close resources
        rs.close();
        stmt.close();
    }
    public void update() throws SQLException {

        String udaptesql = "ALTER TABLE employees "
                + "ADD COLUMN salary NUMERIC(10,2)";

        Statement stmt = conn.createStatement();
        //
        stmt.executeUpdate(udaptesql);

        System.out.println("Column 'salary' added successfully");

        // Step 4: Close resources
        stmt.close();
    }
    public void delete(int id) throws SQLException {
        String deletesql = "DELETE FROM employees WHERE id = " + id;

        Statement stmt = conn.createStatement();

        int rowsAffected = stmt.executeUpdate(deletesql);

        if (rowsAffected > 0) {
            System.out.println("Record deleted successfully");
        } else {
            System.out.println("No record found with given ID");
        }

        stmt.close();
    }
    public void insert(int id,String name,int age) throws SQLException {
        String insertsql = "INSERT INTO employees (id, name, age) VALUES ("
                + id + ", '"
                + name + "', "
                + age + ")";

        Statement stmt = conn.createStatement();
        stmt.executeUpdate(insertsql);

        System.out.println("Record inserted successfully");

        stmt.close();
    }
}
