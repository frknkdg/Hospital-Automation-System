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
public class Salary {

    private int id;
    private String salary;
    private String doctor_name;

    DbConnection conn = new DbConnection();
    Connection con = conn.conDb();

    Statement st = null;
    ResultSet rs = null;

    public Salary(int id, String salary, String clinic_name) {
        this.id = id;
        this.salary = salary;
        this.doctor_name = clinic_name;
    }

    public Salary() {
    }

    public ArrayList<Salary> getlist() throws SQLException {
        ArrayList<Salary> list = new ArrayList<>();
        Salary obj;
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT doctor_name, salary FROM salary");
            while (rs.next()) {
                obj = new Salary();
                obj.setDoctor_name(rs.getString("doctor_name"));
                obj.setSalary(rs.getString("salary"));
                list.add(obj);
            }
        } catch (SQLException e) {
        }

        return list;
    }

    public boolean addSalary(String doctor_name, String salary1) throws SQLException {
        String query = "INSERT INTO salary (doctor_name, salary) VALUES (?, ?)";

        boolean key = false;
        int count = 0;

        try {
            PreparedStatement checkStatement = con.prepareStatement("SELECT * FROM salary WHERE doctor_name = ?");
            checkStatement.setString(1, doctor_name);
            ResultSet countResult = checkStatement.executeQuery();
            if (countResult.next()) {
                PreparedStatement chStmt = con.prepareStatement("UPDATE salary SET salary = ? WHERE doctor_name = ?");
                chStmt.setString(1, salary1);
                chStmt.setString(2, doctor_name);
                chStmt.executeUpdate();

            }
            else {
                PreparedStatement insertStatement = con.prepareStatement(query);
                insertStatement.setString(1, doctor_name);
                insertStatement.setString(2, salary1);
                insertStatement.executeUpdate();
            } 
            key = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return key;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String clinic_name) {
        this.doctor_name = clinic_name;
    }
}
