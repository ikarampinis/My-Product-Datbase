package com.example.model;

import java.io.FileWriter;
import java.sql.*;

public class ProductCheck {
    public boolean EnterDatabase(String barcode,String name,String color,String description){
        
        Connection conn = null;
        Statement stat = null;
        int check=0;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopdb", "root", "mysql");
            stat = conn.createStatement();
            check = stat.executeUpdate("insert into product values ("+Integer.parseInt(barcode)+",'"+name+"','"+color+"','"+description+"')");
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        if(check==0){
            return false;
        }
        else{
            return true;
        }
    }
}
