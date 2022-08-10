
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
class Search {
    String driver="com.mysql.jdbc.Driver";
    String url="jdbc:mysql://localhost:3306/registerdb";
    Statement st;

    List TicketSearch(String id) {
        connectToDb();
        String sql="SELECT * FROM ticket WHERE ticketID LIKE '%"+id+"%'";
        List tlist = new ArrayList();
        try {
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                tlist.add(rs.getString("ticketId"));
                tlist.add(rs.getString("username"));
                tlist.add(rs.getString("contacts"));
                tlist.add(rs.getString("date"));
                tlist.add(rs.getString("FromTo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tlist;
    }

    private void connectToDb() {
        
        
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,"root","");
            st= con.createStatement();
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    List FlightSearch(String id) {
        connectToDb();
        String sql="SELECT * FROM flighttbl WHERE flightid LIKE '%"+id+"%'";
        List flist = new ArrayList();
        try {
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                flist.add(rs.getString("flightid"));
                flist.add(rs.getString("flightname"));
                flist.add(rs.getString("fromCity"));
                flist.add(rs.getString("toCity"));
                flist.add(rs.getString("date"));
                flist.add(rs.getString("time"));
                flist.add(rs.getString("airportName"));
                flist.add(rs.getString("Description"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flist;
    }

    List AdminSearch(String id) {
        connectToDb();
        String sql="SELECT * FROM admintbl WHERE adminId LIKE '%"+id+"%'";
        List flist = new ArrayList();
        try {
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                flist.add(rs.getString("adminId"));
                flist.add(rs.getString("adminName"));
                flist.add(rs.getString("email"));
                flist.add(rs.getString("contact"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flist;
    }

   

    List user(String emailadd) {
        connectToDb();
        String sql="SELECT * FROM admintbl WHERE mail LIKE '%"+emailadd+"%'";
        List flist = new ArrayList();
        try {
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                flist.add(rs.getString("username"));
                flist.add(rs.getString("mail"));
                flist.add(rs.getString("password"));
                flist.add(rs.getString("comfirmpassword"));
                flist.add(rs.getString("comfirmpassword"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flist;
    }

    
    
    
}
