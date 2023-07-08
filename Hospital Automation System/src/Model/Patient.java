/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Helper.DbConnection;
import Helper.Helper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author furka
 */
public class Patient extends User {

    DbConnection conn = new DbConnection();
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement prs = null;
    Connection con = conn.conDb();

    public Patient() {
    }

    public Patient(int id, String tcno, String name, String password, String type) {
        super(id, tcno, name, password, type);

    }

    public boolean register(String name, String tcno, String password) {
        boolean duplicate = false;

        String query = "INSERT INTO user" + "(name, tcno, password,type) VALUES (?, ?, ?,?)";
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM user WHERE tcno = '" + tcno + "'");
            while (rs.next()) {
                duplicate = true;
                Helper.showMsg("There is another record for this tcno!");
                break;
            }
            if (!duplicate) {
                prs = con.prepareStatement(query);
                prs.setString(1, name);
                prs.setString(2, tcno);
                prs.setString(3, password);
                prs.setString(4, "patient");

                prs.executeUpdate();

                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public boolean addAppoinment(int doctor_id, String doctor_name, int patient_id, String patient_name, String apmnt_date) {
        int key = 0;

        String query = "INSERT INTO appointment" + "(doctor_id, doctor_name, patient_id,patient_name,apmnt_date) VALUES (?, ?, ?, ?, ?)";
        try {
            st = con.createStatement();
            prs = con.prepareStatement(query);
            prs.setInt(1, doctor_id);
            prs.setString(2, doctor_name);
            prs.setInt(3, patient_id);
            prs.setString(4, patient_name);
            prs.setString(5, apmnt_date);

            prs.executeUpdate();

            key = 1;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        if (key == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean updateWhourStatus(int doctor_id, String w_date) {
        int key = 0;

        String query = "UPDATE w_hours SET status = ? WHERE doctor_id = ? AND w_date = ?";
        try {
            st = con.createStatement();
            prs = con.prepareStatement(query);

            prs.setString(1, "p");
            prs.setInt(2, doctor_id);
            prs.setString(3, w_date);

            prs.executeUpdate();

            key = 1;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        if (key == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteAppointment(int id) throws SQLException {
        String appointmentQuery = "DELETE FROM appointment WHERE id = ?";
        String wHoursQuery = "UPDATE w_hours SET status = 'a' WHERE id = ?";

        try {
            // Appointment deletion
            prs = con.prepareStatement(appointmentQuery);
            prs.setInt(1, id);
            prs.executeUpdate();
            prs.close();

            // Status update process in w_hours table
            prs = con.prepareStatement(wHoursQuery);
            prs.setInt(1, id);
            prs.executeUpdate();
            prs.close();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
