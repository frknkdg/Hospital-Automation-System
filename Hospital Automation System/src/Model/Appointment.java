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

/**
 *
 * @author furka
 */
public class Appointment {

    private int id;
    private int doctor_id;
    private int patient_id;
    private String doctor_name;
    private String patient_name;
    private String apmnt_date;

    DbConnection conn = new DbConnection();
    Connection con = conn.conDb();

    PreparedStatement prs = null;
    Statement st = null;
    ResultSet rs = null;

    public Appointment(int id, int doctor_id, int patient_id, String doctor_name, String patient_name, String apmnt_date) {
        this.id = id;
        this.doctor_id = doctor_id;
        this.patient_id = patient_id;
        this.doctor_name = doctor_name;
        this.patient_name = patient_name;
        this.apmnt_date = apmnt_date;
    }

    public Appointment() {
    }

    public ArrayList<Appointment> getPatientlist(int patient_id) throws SQLException {
        ArrayList<Appointment> list = new ArrayList<>();
        Appointment obj;
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM appointment WHERE patient_id = " + patient_id);
            while (rs.next()) {
                obj = new Appointment();
                obj.setId(rs.getInt("id"));
                obj.setDoctor_id(rs.getInt("doctor_id"));
                obj.setDoctor_name(rs.getString("doctor_name"));
                obj.setPatient_id(rs.getInt("patient_id"));
                obj.setPatient_name(rs.getString("patient_name"));
                obj.setApmnt_date(rs.getString("apmnt_date"));
                list.add(obj);

               
            }
        } catch (SQLException e) {
        }

        return list;
    }
    
     public ArrayList<Appointment> getDoctorlist(int doctor_id) throws SQLException {
        ArrayList<Appointment> list = new ArrayList<>();
        Appointment obj;
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM appointment WHERE doctor_id = " + doctor_id);
            while (rs.next()) {
                obj = new Appointment();
                obj.setId(rs.getInt("id"));
                obj.setDoctor_id(rs.getInt("doctor_id"));
                obj.setDoctor_name(rs.getString("doctor_name"));
                obj.setPatient_id(rs.getInt("patient_id"));
                obj.setPatient_name(rs.getString("patient_name"));
                obj.setApmnt_date(rs.getString("apmnt_date"));
                list.add(obj);

               
            }
        } catch (SQLException e) {
        }

        return list;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getApmnt_date() {
        return apmnt_date;
    }

    public void setApmnt_date(String apmnt_date) {
        this.apmnt_date = apmnt_date;
    }

}
