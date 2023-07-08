/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Helper.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author furkan
 */
public class Doctor extends User {

    DbConnection conn = new DbConnection();
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement prs = null;
    Connection con = conn.conDb();
    

    public Doctor() {
        super();
    }

    public Doctor(int id, String tcno, String name, String password, String type) {
        super(id, tcno, name, password, type);
    }
    
    public boolean addW_hour(int doctor_id, String doctor_name, String w_date) {
    int key = 0;
    int count = 0;

    String query = "INSERT INTO w_hours (doctor_id, doctor_name, w_date) VALUES (?, ?, ?)";
    try {
        PreparedStatement checkStatement = con.prepareStatement("SELECT COUNT(*) FROM w_hours WHERE status='a' AND doctor_id=? AND w_date=?");
        checkStatement.setInt(1, doctor_id);
        checkStatement.setString(2, w_date);
        ResultSet countResult = checkStatement.executeQuery();
        if (countResult.next()) {
            count = countResult.getInt(1);
        }
       if (count == 0 && doctor_name != null && !doctor_name.isEmpty()) {
  
            PreparedStatement insertStatement = con.prepareStatement(query);
            insertStatement.setInt(1, doctor_id);
            insertStatement.setString(2, doctor_name);
            insertStatement.setString(3, w_date);
            insertStatement.executeUpdate();
            key = 1;
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return key == 1;
}
    
    public ArrayList<w_hours> getWhourList(int doctor_id) throws SQLException {
        ArrayList<w_hours> list = new ArrayList<>();
        w_hours obj;
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM w_hours WHERE status ='a' AND doctor_id = " + doctor_id);
            while (rs.next()) {
                obj = new w_hours();
                 obj.setId(rs.getInt("id"));
                            obj.setDoctor_id(rs.getInt("doctor_id"));
                            obj.setDoctor_name(rs.getString("doctor_name"));
                            obj.setStatus(rs.getString("status"));
                            obj.setW_date(rs.getString("w_date"));
                
                list.add(obj);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
      public boolean deleteWhour(int id) throws SQLException {
        String query = "DELETE FROM w_hours WHERE id = ?";
        boolean key = false;
        try {
            st = con.createStatement();
            prs = con.prepareStatement(query);
            prs.setInt(1, id);
            prs.executeUpdate();

            key = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (key) {
            return true;
        } else {
            return false;
        }

    }
 
}
