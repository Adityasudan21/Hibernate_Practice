package com.BasePack.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBTest {
    public static Connection conn=null;
    public void createconnection() throws Exception{
        String url="jdbc:postgresql://localhost:5432/DB";
        String username="postgres";
        String password="root";
        conn= DriverManager.getConnection(url,username,password);
        System.out.println("Connection Established");
    }
    public void closeconnection() throws Exception{
        conn.close();
        System.out.println("Connection with JDBC is closed");
    }
}
