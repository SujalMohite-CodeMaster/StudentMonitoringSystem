package sms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {

    Connection c;
    Statement s;

    conn(){
        String username = "root";
        String password = "sujal3105";
        String url = "jdbc:mysql://localhost:3306/studmonsys";

        try{
            c = DriverManager.getConnection(url,username,password);
            s = c.createStatement();

            System.out.println("connection successfull");
        }catch (Exception e){
            System.out.println(e);
            System.out.println("connection failed ");
        }
    }
    public static void main(String[] args) {
        new conn();
    }
}
