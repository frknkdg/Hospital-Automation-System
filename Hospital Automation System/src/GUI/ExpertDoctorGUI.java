/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Model.ExpertDoctor;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import Helper.*;
import Model.Clinic;
import Model.Doctor;
import Model.Salary;
import Model.User;
import java.awt.List;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableColumn;

/**
 *
 * @author furkan
 */
public class ExpertDoctorGUI extends javax.swing.JFrame {

    private DefaultTableModel clinicModel = null;
    private DefaultTableModel doctorModel = null;
    private DefaultTableModel listModel = null;
    private DefaultTableModel employeeModel = null;
    private DefaultTableModel showDoctorModel = null;
    private DefaultTableModel salaryModel = null;

    private Object[] doctorData = null;
    private Object[] clinicData = null;
    private Object[] listData = null;
    private Object[] employeeData = null;
    private Object[] salaryData = null;

    static ExpertDoctor expertDoctor = new ExpertDoctor();
    private Clinic clinic = new Clinic();
    private Salary salary = new Salary();

    DbConnection conn = new DbConnection();
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement prs = null;
    Connection con = conn.conDb();

    /**
     * Creates new form ExperDoctorGUI
     */
    public ExpertDoctorGUI(ExpertDoctor expertDoctor) throws SQLException {
        initComponents();
        jLabel1.setText("Wellcome, dear " + expertDoctor.getName());

        // ---------------------List Model ----------------------------
        listModel = new DefaultTableModel();
        doctor_list.setModel(listModel);
        listModel.setColumnIdentifiers(new Object[]{"ID", "Name"});
        listData = new Object[2];

        for (int i = 0; i < expertDoctor.getDoctorList().size(); i++) {
            listData[0] = expertDoctor.getDoctorList().get(i).getId();
            listData[1] = expertDoctor.getDoctorList().get(i).getName();
            listModel.addRow(listData);
        }

        // -----------------  Doctor Model ----------------------------
        doctorModel = new DefaultTableModel();
        table_doctor.setModel(doctorModel);
        doctorModel.setColumnIdentifiers(new Object[]{"ID", "Name", "T.C. No", "Password"});
        doctorData = new Object[4];

        for (int i = 0; i < expertDoctor.getDoctorList().size(); i++) {
            doctorData[0] = expertDoctor.getDoctorList().get(i).getId();
            doctorData[1] = expertDoctor.getDoctorList().get(i).getName();
            doctorData[2] = expertDoctor.getDoctorList().get(i).getTcno();
            doctorData[3] = expertDoctor.getDoctorList().get(i).getPassword();
            doctorModel.addRow(doctorData);

        }

        // ----------------- clinic Model -----------------------------
        clinicModel = new DefaultTableModel();
        table_clinic.setModel(clinicModel);
        clinicModel.setColumnIdentifiers(new String[]{"ID", "Clinic Name"});
        clinicData = new Object[2];

        for (int i = 0; i < clinic.getlist().size(); i++) {
            clinicData[0] = clinic.getlist().get(i).getId();
            clinicData[1] = clinic.getlist().get(i).getName();
            clinicModel.addRow(clinicData);
        }

        // -------------- Employee Model -------------------------------
        employeeModel = new DefaultTableModel();
        table_employee.setModel(employeeModel);
        employeeModel.setColumnIdentifiers(new Object[]{"Doctor ID", "Doctor Name"});

        // ------------ Show Clinic Model ------------------------------
        showDoctorModel = new DefaultTableModel();
        table_showdDoctor.setModel(showDoctorModel);
        showDoctorModel.setColumnIdentifiers(new Object[]{"ID", "Clinic Name"});
        TableColumn column = table_showdDoctor.getColumnModel().getColumn(0);
        column.setPreferredWidth(15);

        for (int i = 0; i < expertDoctor.getDoctorList().size(); i++) {
            clinicData[0] = expertDoctor.getDoctorList().get(i).getId();
            clinicData[1] = expertDoctor.getDoctorList().get(i).getName();
            showDoctorModel.addRow(clinicData);
        }

        // -------------- Salary Model --------------------------------- 
        salaryModel = new DefaultTableModel();
        table_salary.setModel(salaryModel);
        salaryModel.setColumnIdentifiers(new Object[]{"Doctor Name", "Salary"});
        TableColumn column1 = table_salary.getColumnModel().getColumn(0);
        column1.setPreferredWidth(25);
        salaryData = new Object[3];

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_addName = new javax.swing.JTextField();
        txt_addTcno = new javax.swing.JTextField();
        txt_addPass = new javax.swing.JPasswordField();
        scrollDoctor = new javax.swing.JScrollPane();
        table_doctor = new javax.swing.JTable();
        btn_doctorAdd = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txt_doctorId = new javax.swing.JTextField();
        btn_doctorDelete = new javax.swing.JButton();
        kGradientPanel3 = new keeptoo.KGradientPanel();
        scroll_clinic = new javax.swing.JScrollPane();
        table_clinic = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_employee = new javax.swing.JTable();
        btn_add = new javax.swing.JButton();
        txt_clinicName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btn_addEmployee = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        doctor_list = new javax.swing.JTable();
        select_clinic = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        kGradientPanel4 = new keeptoo.KGradientPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_showdDoctor = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_salary = new javax.swing.JTable();
        txt_salary = new javax.swing.JTextField();
        btn_addSalary = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        kGradientPanel1.setForeground(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setkEndColor(new java.awt.Color(0, 204, 204));
        kGradientPanel1.setkStartColor(new java.awt.Color(204, 0, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Wellcome, dear ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("EXIT");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jTabbedPane1.setBackground(new java.awt.Color(204, 0, 204));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));

        kGradientPanel2.setkEndColor(new java.awt.Color(0, 204, 204));
        kGradientPanel2.setkStartColor(new java.awt.Color(204, 0, 204));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Name Surname");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("T.C.No");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Password");

        table_doctor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scrollDoctor.setViewportView(table_doctor);
        table_doctor.getAccessibleContext().setAccessibleName("");
        table_doctor.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent e){
                try{
                    txt_doctorId.setText(table_doctor.getValueAt(table_doctor.getSelectedRow(),0).toString());
                }catch(Exception ex){
                }

            }
        });

        table_doctor.getModel().addTableModelListener(new TableModelListener(){
            public void tableChanged(TableModelEvent e){
                if(e.getType()== TableModelEvent.UPDATE){
                    int selectId = Integer.parseInt(table_doctor.getValueAt(table_doctor.getSelectedRow(),0).toString());
                    String selectName =table_doctor.getValueAt(table_doctor.getSelectedRow(),1).toString();
                    String selectTcno=table_doctor.getValueAt(table_doctor.getSelectedRow(),2).toString();
                    String SelectPass=table_doctor.getValueAt(table_doctor.getSelectedRow(),3).toString();
                    try{
                        expertDoctor.updateDoctor(selectId, selectTcno, SelectPass, selectName);
                    }catch(SQLException e1){
                        e1.printStackTrace();

                    }
                }
            }
        }
    );

    btn_doctorAdd.setBackground(new java.awt.Color(0, 204, 204));
    btn_doctorAdd.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
    btn_doctorAdd.setText("Add");
    btn_doctorAdd.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_doctorAddActionPerformed(evt);
        }
    });

    jLabel6.setBackground(new java.awt.Color(255, 255, 255));
    jLabel6.setForeground(new java.awt.Color(255, 255, 255));
    jLabel6.setText("Doctor ID");

    btn_doctorDelete.setBackground(new java.awt.Color(0, 204, 204));
    btn_doctorDelete.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
    btn_doctorDelete.setText("Delete");
    btn_doctorDelete.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_doctorDeleteActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
    kGradientPanel2.setLayout(kGradientPanel2Layout);
    kGradientPanel2Layout.setHorizontalGroup(
        kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
            .addContainerGap(26, Short.MAX_VALUE)
            .addComponent(scrollDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                .addComponent(txt_addName)
                .addComponent(txt_addTcno)
                .addComponent(txt_addPass)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_doctorId)
                .addComponent(btn_doctorDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_doctorAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap())
    );
    kGradientPanel2Layout.setVerticalGroup(
        kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(kGradientPanel2Layout.createSequentialGroup()
                    .addComponent(scrollDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18))
                .addGroup(kGradientPanel2Layout.createSequentialGroup()
                    .addComponent(jLabel3)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txt_addName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel4)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txt_addTcno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel5)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txt_addPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(24, 24, 24)
                    .addComponent(btn_doctorAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel6)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txt_doctorId, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(btn_doctorDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(12, 12, 12))))
    );

    jTabbedPane1.addTab("Doctor Management", kGradientPanel2);

    kGradientPanel3.setkEndColor(new java.awt.Color(0, 204, 204));
    kGradientPanel3.setkStartColor(new java.awt.Color(204, 0, 204));

    clinicMenu = new JPopupMenu();
    JMenuItem updateMenu = new JMenuItem("update");
    JMenuItem deleteMenu = new JMenuItem("delete");
    clinicMenu.add(updateMenu);
    clinicMenu.add(deleteMenu);
    updateMenu.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            int selId=Integer.parseInt(table_clinic.getValueAt(table_clinic.getSelectedRow(),0).toString());
            Clinic selectedClinic = clinic.getFetch(selId);
            UpdateClinicGUI updateGUI = new UpdateClinicGUI(selectedClinic);
            updateGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            updateGUI.setVisible(true);
            updateGUI.addWindowListener(new WindowAdapter(){
                public void windowClosed(WindowEvent e){
                    try{
                        updateClinicModel();
                    }catch(SQLException e1){
                        e1.printStackTrace();
                    }
                }
            });

        }
    });

    table_clinic.setComponentPopupMenu(clinicMenu);
    table_clinic.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        },
        new String [] {
            "Title 1", "Title 2", "Title 3", "Title 4"
        }
    ));
    deleteMenu.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            if(Helper.confirm("sure")){
                int selId=Integer.parseInt(table_clinic.getValueAt(table_clinic.getSelectedRow(),0).toString());
                try{
                    if(clinic.deleteClinic(selId)){
                        Helper.showMsg("success");
                        updateClinicModel();
                    }else{
                        Helper.showMsg("error");
                    }
                }catch(SQLException e2){
                    e2.printStackTrace();
                }
            }
        }
    });
    table_clinic.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mousePressed(java.awt.event.MouseEvent evt) {
            table_clinicMousePressed(evt);
        }
    });
    scroll_clinic.setViewportView(table_clinic);

    table_employee.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        },
        new String [] {
            "Title 1", "Title 2", "Title 3", "Title 4"
        }
    ));
    jScrollPane1.setViewportView(table_employee);

    btn_add.setText("Add");
    btn_add.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_addActionPerformed(evt);
        }
    });

    jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
    jLabel7.setForeground(new java.awt.Color(255, 255, 255));
    jLabel7.setText("Clinic's name");

    btn_addEmployee.setText("add");
    btn_addEmployee.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_addEmployeeActionPerformed(evt);
        }
    });

    doctor_list.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        },
        new String [] {
            "Title 1", "Title 2", "Title 3", "Title 4"
        }
    ));
    jScrollPane2.setViewportView(doctor_list);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    select_clinic.setText("Select");
    select_clinic.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            select_clinicActionPerformed(evt);
        }
    });

    jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
    jLabel8.setForeground(new java.awt.Color(255, 255, 255));
    jLabel8.setText("Clinic");

    jLabel9.setForeground(new java.awt.Color(204, 255, 255));
    jLabel9.setText("-------------------------------------");

    jLabel11.setForeground(new java.awt.Color(204, 255, 255));
    jLabel11.setText("-------------------------------------");

    javax.swing.GroupLayout kGradientPanel3Layout = new javax.swing.GroupLayout(kGradientPanel3);
    kGradientPanel3.setLayout(kGradientPanel3Layout);
    kGradientPanel3Layout.setHorizontalGroup(
        kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(kGradientPanel3Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(scroll_clinic, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_clinicName)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_addEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(select_clinic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );
    kGradientPanel3Layout.setVerticalGroup(
        kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(kGradientPanel3Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(scroll_clinic, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGroup(kGradientPanel3Layout.createSequentialGroup()
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txt_clinicName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(btn_add)
                    .addGap(27, 27, 27)
                    .addComponent(jLabel9)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel8)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(select_clinic)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel11)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(btn_addEmployee)))
            .addContainerGap())
    );

    jTabbedPane1.addTab("Clinics", kGradientPanel3);

    kGradientPanel4.setkEndColor(new java.awt.Color(0, 204, 204));
    kGradientPanel4.setkStartColor(new java.awt.Color(204, 0, 204));

    table_showdDoctor.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        },
        new String [] {
            "Title 1", "Title 2", "Title 3", "Title 4"
        }
    ));
    table_showdDoctor.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            table_showdDoctorMouseClicked(evt);
        }
    });
    jScrollPane3.setViewportView(table_showdDoctor);

    table_salary.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        },
        new String [] {
            "Title 1", "Title 2", "Title 3", "Title 4"
        }
    ));
    jScrollPane4.setViewportView(table_salary);

    btn_addSalary.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
    btn_addSalary.setText("Add Salary");
    btn_addSalary.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_addSalaryActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout kGradientPanel4Layout = new javax.swing.GroupLayout(kGradientPanel4);
    kGradientPanel4.setLayout(kGradientPanel4Layout);
    kGradientPanel4Layout.setHorizontalGroup(
        kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(kGradientPanel4Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addGroup(kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(txt_salary)
                .addComponent(btn_addSalary, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
            .addGap(18, 18, 18)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );
    kGradientPanel4Layout.setVerticalGroup(
        kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(kGradientPanel4Layout.createSequentialGroup()
            .addGroup(kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(kGradientPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane4)
                        .addComponent(jScrollPane3)))
                .addGroup(kGradientPanel4Layout.createSequentialGroup()
                    .addGap(140, 140, 140)
                    .addComponent(txt_salary, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(btn_addSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jTabbedPane1.addTab("Salary", kGradientPanel4);

    javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
    kGradientPanel1.setLayout(kGradientPanel1Layout);
    kGradientPanel1Layout.setHorizontalGroup(
        kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(kGradientPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jTabbedPane1))
                .addGroup(kGradientPanel1Layout.createSequentialGroup()
                    .addGap(17, 17, 17)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2)))
            .addContainerGap())
    );
    kGradientPanel1Layout.setVerticalGroup(
        kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(kGradientPanel1Layout.createSequentialGroup()
            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(kGradientPanel1Layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(kGradientPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(18, 18, 18)
            .addComponent(jTabbedPane1)
            .addGap(14, 14, 14))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_doctorAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_doctorAddActionPerformed

        if (txt_addName.getText().length() == 0 || txt_addPass.getText().length() == 0 || txt_addTcno.getText().length() == 0) {
            Helper.showMsg("fill");
        } else {
            try {
                boolean control = expertDoctor.addDoctor(txt_addTcno.getText(), txt_addPass.getText(), txt_addName.getText());
                if (control) {
                    Helper.showMsg("succes");
                    txt_addTcno.setText(null);
                    txt_addPass.setText(null);
                    txt_addName.setText(null);
                    updateDoctorModel();

                    // Doktorları dosyaya yazma işlemi
                    writeDoctorsToFile();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void writeDoctorsToFile() throws SQLException {
        ArrayList<User> doctorList;

        doctorList = expertDoctor.getDoctorList(); // Doktor listesini alın

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("doktorlar.txt"))) {
            for (User doctor : doctorList) {
                String doctorInfo = doctor.getName() + ", " + doctor.getTcno() + ", " + doctor.getPassword();
                writer.write(doctorInfo);
                writer.newLine(); // Her bir doktorun bilgisi için yeni satır ekle
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*if (txt_addName.getText().length() == 0 || txt_addPass.getText().length() == 0 || txt_addTcno.getText().length() == 0) {
            Helper.showMsg("fill");
        } else {
            try {
                boolean control = expertDoctor.addDoctor(txt_addTcno.getText(), txt_addPass.getText(), txt_addName.getText());
                if (control) {
                    Helper.showMsg("succes");
                    txt_addTcno.setText(null);
                    txt_addPass.setText(null);
                    txt_addName.setText(null);
                    updateDoctorModel();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }*/

    }//GEN-LAST:event_btn_doctorAddActionPerformed

    private void btn_doctorDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_doctorDeleteActionPerformed
        // TODO add your handling code here:
        if (txt_doctorId.getText().length() == 0) {
            Helper.showMsg("Please, select a valid doctor!");
        } else {
            if (Helper.confirm("sure")) {
                int selectedId = Integer.parseInt(txt_doctorId.getText());
                try {
                    boolean ctrl = expertDoctor.deleteDoctor(selectedId);
                    if (ctrl) {
                        Helper.showMsg("success");
                        txt_doctorId.setText(null);
                        updateDoctorModel();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_btn_doctorDeleteActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        LoginGUI login = new LoginGUI();
        this.dispose();
        login.setVisible(true);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:,
        if (txt_clinicName.getText().length() == 0) {
            Helper.showMsg("fill");
        } else {
            try {
                if (clinic.addClinic(txt_clinicName.getText())) {
                    Helper.showMsg("success");
                    txt_clinicName.setText(null);
                    updateClinicModel();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void table_clinicMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_clinicMousePressed
        // TODO add your handling code here:
        Point point = evt.getPoint();
        int selectedRow = table_clinic.rowAtPoint(point);
        table_clinic.setRowSelectionInterval(selectedRow, selectedRow);
    }//GEN-LAST:event_table_clinicMousePressed

    private void btn_addEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addEmployeeActionPerformed
        // TODO add your handling code here:
        int selRow = table_clinic.getSelectedRow();
        if (selRow >= 0) {
            String selClinic = table_clinic.getModel().getValueAt(selRow, 0) + "";
            int selClinicId = Integer.parseInt(selClinic);

            int selDocRow = doctor_list.getSelectedRow();
            String selDoc = doctor_list.getModel().getValueAt(selDocRow, 0) + "";
            int SelDocId = Integer.parseInt(selDoc);
            try {

                boolean ctrl = expertDoctor.addEmployee(SelDocId, selClinicId);

                if (ctrl) {
                    Helper.showMsg("success");
                    DefaultTableModel clearModel = (DefaultTableModel) table_employee.getModel();
                    clearModel.setRowCount(0);
                    for (int i = 0; i < expertDoctor.getClinicDoctorList(selClinicId).size(); i++) {
                        employeeData = new Object[2];
                        employeeData[0] = expertDoctor.getClinicDoctorList(selClinicId).get(i).getId();
                        employeeData[1] = expertDoctor.getClinicDoctorList(selClinicId).get(i).getName();
                        employeeModel.addRow(employeeData);
                    }
                } else {
                    Helper.showMsg("error");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            Helper.showMsg("Please choose a clinic!");
        }
    }//GEN-LAST:event_btn_addEmployeeActionPerformed

    private void select_clinicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_select_clinicActionPerformed
        // TODO add your handling code here:
        int selRow = table_clinic.getSelectedRow();
        if (selRow >= 0) {
            String selClinic = table_clinic.getModel().getValueAt(selRow, 0) + "";
            int selClinicId = Integer.parseInt(selClinic);
            DefaultTableModel clearModel = (DefaultTableModel) table_employee.getModel();
            clearModel.setRowCount(0);
            try {
                for (int i = 0; i < expertDoctor.getClinicDoctorList(selClinicId).size(); i++) {
                    employeeData = new Object[2];
                    employeeData[0] = expertDoctor.getClinicDoctorList(selClinicId).get(i).getId();
                    employeeData[1] = expertDoctor.getClinicDoctorList(selClinicId).get(i).getName();
                    employeeModel.addRow(employeeData);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            Helper.showMsg("Please choose a clinic!");
        }

    }//GEN-LAST:event_select_clinicActionPerformed

    private void btn_addSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addSalaryActionPerformed
        int selRow = table_showdDoctor.getSelectedRow();
        String txtSalary = txt_salary.getText();

        if (selRow >= 0) {
            String selDoctor = table_showdDoctor.getModel().getValueAt(selRow, 1) + "";
            try {
                boolean ctrl = salary.addSalary(selDoctor, txtSalary);

                if (ctrl) {
                    Helper.showMsg("success");
                    DefaultTableModel clearModel = (DefaultTableModel) table_salary.getModel();
                    clearModel.setRowCount(0);
                    for (int i = 0; i < salary.getlist().size(); i++) {
                        salaryData[0] = salary.getlist().get(i).getDoctor_name();
                        salaryData[1] = salary.getlist().get(i).getSalary();
                        salaryModel.addRow(salaryData);
                    }

                } else {
                    Helper.showMsg("error");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            Helper.showMsg("Please choose a clinic!");
        }


    }//GEN-LAST:event_btn_addSalaryActionPerformed

    private void table_showdDoctorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_showdDoctorMouseClicked
        int selRow = table_showdDoctor.getSelectedRow();
        String selClinic = table_showdDoctor.getModel().getValueAt(selRow, 1) + "";
        DefaultTableModel clearModel = (DefaultTableModel) table_salary.getModel();
        clearModel.setRowCount(0);
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM salary WHERE doctor_name ='" + selClinic + "'");
            while (rs.next()) {
                Vector vector = new Vector();
                vector.add(rs.getString("doctor_name"));
                vector.add(rs.getString("salary"));
                clearModel.addRow(vector);
            }
        } catch (SQLException e) {
        }
    }//GEN-LAST:event_table_showdDoctorMouseClicked

    public void updateDoctorModel() throws SQLException {
        DefaultTableModel clearModel = (DefaultTableModel) table_doctor.getModel();
        clearModel.setRowCount(0);
        for (int i = 0; i < expertDoctor.getDoctorList().size(); i++) {
            doctorData[0] = expertDoctor.getDoctorList().get(i).getId();
            doctorData[1] = expertDoctor.getDoctorList().get(i).getName();
            doctorData[2] = expertDoctor.getDoctorList().get(i).getTcno();
            doctorData[3] = expertDoctor.getDoctorList().get(i).getPassword();
            doctorModel.addRow(doctorData);

        }
    }

    public void updateClinicModel() throws SQLException {
        DefaultTableModel clearModel = (DefaultTableModel) table_clinic.getModel();
        clearModel.setRowCount(0);

        for (int i = 0; i < clinic.getlist().size(); i++) {
            clinicData[0] = clinic.getlist().get(i).getId();
            clinicData[1] = clinic.getlist().get(i).getName();
            clinicModel.addRow(clinicData);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ExpertDoctorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExpertDoctorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExpertDoctorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExpertDoctorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ExpertDoctorGUI(expertDoctor).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ExpertDoctorGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_addEmployee;
    private javax.swing.JButton btn_addSalary;
    private javax.swing.JButton btn_doctorAdd;
    private javax.swing.JButton btn_doctorDelete;
    private javax.swing.JTable doctor_list;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private keeptoo.KGradientPanel kGradientPanel3;
    private keeptoo.KGradientPanel kGradientPanel4;
    private javax.swing.JScrollPane scrollDoctor;
    private javax.swing.JScrollPane scroll_clinic;
    private javax.swing.JButton select_clinic;
    private javax.swing.JTable table_clinic;
    private javax.swing.JPopupMenu clinicMenu;
    private javax.swing.JTable table_doctor;
    private javax.swing.JTable table_employee;
    private javax.swing.JTable table_salary;
    private javax.swing.JTable table_showdDoctor;
    private javax.swing.JTextField txt_addName;
    private javax.swing.JPasswordField txt_addPass;
    private javax.swing.JTextField txt_addTcno;
    private javax.swing.JTextField txt_clinicName;
    private javax.swing.JTextField txt_doctorId;
    private javax.swing.JTextField txt_salary;
    // End of variables declaration//GEN-END:variables
}
