package com.smalleats;


import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnectionTest {
    private static final String DRIVER ="com.mysql.jdbc.Driver";
    private static final String URL="jdbc:mysql://127.0.0.1:3308/smalleatsDB";
    private static final String USER ="root";
    private static final String PASSWORD ="[root]";

    @Test
    public void testConnetion() throws Exception{
        Class.forName(DRIVER);
        try (Connection connection = DriverManager.getConnection(URL,USER,PASSWORD)){
            System.out.println(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
