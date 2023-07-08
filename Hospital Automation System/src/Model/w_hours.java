/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Helper.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author furka
 */
public class w_hours {

    private int id;
    private int doctor_id;
    private String doctor_name;
    private String w_date;
    private String status;

    public w_hours() {
    }
    

    public w_hours(int id, int doctor_id, String doctor_name, String w_date, String status) {
        this.id = id;
        this.doctor_id = doctor_id;
        this.doctor_name = doctor_name;
        this.w_date = w_date;
        this.status = status;
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

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getW_date() {
        return w_date;
    }

    public void setW_date(String w_date) {
        this.w_date = w_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
