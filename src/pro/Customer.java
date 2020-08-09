/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author vamsi
 */
public class Customer {
    String username;
    String phoneno;
    float balance;
    String ontrip;
    String userid;
    String email;
    String pass;
    
    Customer(String username,String phoneno,float balance,String ontrip,String userid,String email,String pass){
        this.username=username;
        this.phoneno=phoneno;
        this.balance=balance;
        this.userid=userid;
        this.ontrip=ontrip;
        this.email=email;
        this.pass=pass;
        
    }
    
    public float addbalance(float a){
        balance=balance+a;
        try {       
        //System.out.println(fa);
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = (Connection) 
                        DriverManager.getConnection("jdbc:mysql://localhost:3306/customer","root","hello@123");
        Statement stmt = con.createStatement();
        stmt.execute("UPDATE customerid SET Balance ="+balance+" where Userid='"+userid+"'");                                               
        stmt.close();
        con.close();      
        }
        catch (Exception e){
             System.out.println(e);
        }

        return balance;
    }
    
    public Driver confirmbook(String vehnum,String dname,String phone,float rat,String loc,String trp){
        Driver d= new Driver(vehnum,dname,phone,rat,loc,trp);
        trp="1";  
        return d;
        
    }
    
    public float payamount(String q,String cut) throws ClassNotFoundException, SQLException{
         {  
            float m=Float.parseFloat(cut);
            balance=balance-m;
            String s="Select * from driver";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = (Connection)
            DriverManager.getConnection("jdbc:mysql://localhost:3306/customer","root","hello@123");
            Statement stmt = con.createStatement();
            stmt.execute("UPDATE driver SET ontrip ='"+'0'+"' where vehiclenumber='"+q+"'");
            stmt.execute("UPDATE customerid SET Balance ="+balance+" where Userid='"+userid+"'"); 
            stmt.execute("UPDATE customerid SET OnTrip ='"+'0'+"' where Userid='"+userid+"'");
            ontrip="0";
            stmt.close();
            con.close();      
            }
         return balance;

        }
            
            
            
    }
    

