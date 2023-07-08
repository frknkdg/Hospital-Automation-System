/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Helper.DbConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author furkan
 */
public class ExpertDoctor extends User {

    DbConnection conn = new DbConnection();
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement prs = null;
    Connection con = conn.conDb();

    public ExpertDoctor(int id, String tcno, String name, String password, String type) {
        super(id, tcno, name, password, type);
    }

    public ExpertDoctor(int id, String name) {
        super(id, name);
    }

    public ExpertDoctor() {
    }

    public ArrayList<User> getDoctorList() throws SQLException {
        ArrayList<User> list = new ArrayList<>();
        User obj;
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM user WHERE type = 'doctor'");
            while (rs.next()) {
                obj = new User(rs.getInt("id"), rs.getString("tcno"), rs.getString("name"),
                        rs.getString("password"), rs.getString("type"));
                list.add(obj);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public ArrayList<User> getClinicDoctorList(int clinic_id) throws SQLException {
        ArrayList<User> list = new ArrayList<>();
        User obj;
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT u.id, u.tcno, u.type, u.name, u.password FROM employee e LEFT JOIN user u ON e.user_id= u.id WHERE clinic_id = " + clinic_id);
            while (rs.next()) {
                obj = new User(rs.getInt("u.id"), rs.getString("u.tcno"), rs.getString("u.name"),
                        rs.getString("u.password"), rs.getString("u.type"));
                list.add(obj);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public boolean addDoctor(String tcno, String password, String name) throws SQLException {
        String query = "INSERT INTO user " + "(tcno,password,name,type) VALUES" + "(?,?,?,?)";

        boolean key = false;
        try {
            st = con.createStatement();
            prs = con.prepareStatement(query);
            prs.setString(1, tcno);
            prs.setString(2, password);
            prs.setString(3, name);
            prs.setString(4, "doctor");
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

    public boolean deleteDoctor(int id) throws SQLException {
        String query = "DELETE FROM user WHERE id = ?";
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

    public boolean updateDoctor(int id, String tcno, String password, String name) throws SQLException {
        String query = "UPDATE user SET name = ?, tcno=?, password=? WHERE id =?";
        boolean key = false;
        try {
            st = con.createStatement();
            prs = con.prepareStatement(query);
            prs.setString(1, name);
            prs.setString(2, tcno);
            prs.setString(3, password);
            prs.setInt(4, id);
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

    public boolean addEmployee(int userId, int clinicId) throws SQLException {
        String query = "INSERT INTO employee (clinic_id, user_id) VALUES (?, ?)";

        boolean key = false;
        int count = 0;

        try {
            PreparedStatement checkStatement = con.prepareStatement("SELECT COUNT(*) FROM employee WHERE clinic_id = ? AND user_id = ?");
            checkStatement.setInt(1, clinicId);
            checkStatement.setInt(2, userId);
            ResultSet countResult = checkStatement.executeQuery();
            if (countResult.next()) {
                count = countResult.getInt(1);
            }
            if (count == 0) {
                PreparedStatement insertStatement = con.prepareStatement(query);
                insertStatement.setInt(1, clinicId);
                insertStatement.setInt(2, userId);
                insertStatement.executeUpdate();
            }
            key = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return key;
    }

}


