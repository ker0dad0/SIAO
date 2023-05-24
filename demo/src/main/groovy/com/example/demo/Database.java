package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author
 */
public class Database {

    public static Connection connectDb(){

        try{

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/siao", "root", "");
            return connect;
        }catch(Exception e){e.printStackTrace();}
        return null;
    }

}
