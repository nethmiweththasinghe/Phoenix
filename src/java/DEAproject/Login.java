/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DEAproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Misaki
 */
class Login {
    String driver="com.mysql.jdbc.Driver";
    String url="jdbc:mysql://localhost:3306/registerdb";
    Statement st;

    void userLogin(String uname, String mail, String pwd, String cpwd, int phoneno) {
        connectToDb();
        String sql= "INSERT INTO registertbl VALUES('"+uname+"','"+mail+"','"+pwd+"','"+cpwd+"',"+phoneno+")";
        
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void connectToDb() {
        
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,"root","");
            st = con.createStatement();
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    List checkuser(String uname) {
        List clist=new ArrayList();
        connectToDb();
        String sql="SELECT * FROM registertbl WHERE email LIKE%'"+uname+"'%";
        
        try {
            ResultSet rs= st.executeQuery(sql);
            while (rs.next()){
                clist.add(rs.getInt("username"));
                clist.add(rs.getInt("mail"));
                clist.add(rs.getInt("password"));
                clist.add(rs.getInt("comfirmpassword"));
                clist.add(rs.getInt("phoneno"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clist;
        
    }

    void staffLogin(String uname, String mail, String pwd, String cpwd, int phoneno) {
        connectToDb();
         String sql= "INSERT INTO stafftbl VALUES('"+uname+"','"+mail+"','"+pwd+"','"+cpwd+"',"+phoneno+")";
        
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    List checkstaff(String uname) {
        
        connectToDb();
        String sql="SELECT * FROM stafftbl WHERE username LIKE%'"+uname+"'%";
        List slist=new ArrayList();
        try {
            ResultSet rs= st.executeQuery(sql);
            while (rs.next()){
                slist.add(rs.getInt("username"));
                slist.add(rs.getInt("mail"));
                slist.add(rs.getInt("password"));
                slist.add(rs.getInt("confirmpassword"));
                slist.add(rs.getInt("phoneno"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
    }
        return slist;
    }

    void flightAdding(String fno, String fname, String fromcity, String tocity, String date, String time, String airport, String description) {
        connectToDb();
        String sql= "INSERT INTO flighttbl VALUES('"+fno+"','"+fname+"','"+fromcity+"','"+tocity+"','"+date+"','"+time+"','"+airport+"','"+description+"')";
        
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void addbooking(String id,String uname, String contact,String date, String city ) {
        connectToDb();
         String sql= "INSERT INTO ticket VALUES('"+id+"','"+uname+"','"+contact+"','"+date+"','"+city+"')";
        
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
