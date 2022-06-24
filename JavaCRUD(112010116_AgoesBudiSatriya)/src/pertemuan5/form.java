/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pertemuan5;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


        
public class form extends javax.swing.JFrame {
    Connection con = connectDb.conSql();
    public Statement st;
    public ResultSet rs;
    public void showDb(){
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM mahasiswa");
            DefaultTableModel tm =  new DefaultTableModel();
            tm.addColumn("NIM");
            tm.addColumn("NAMA");
            tm.addColumn("GENDER");
            tm.addColumn("KELAS");
            tm.addColumn("SEMESTER");
            
            while(rs.next()){
                Object[] data = {
                    rs.getString("NIM"),
                    rs.getString("NAMA"),
                    rs.getString("GENDER"),
                    rs.getString("KELAS"),
                    rs.getString("SEMESTER")
                };
                tm.addRow(data);
                tblData.setModel(tm);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    public void clear(){
        fieldNim.setText("");
        fieldNama.setText("");
        fieldKelas.setText("");
        fieldSemester.setText("");
        btnInsert.setText("INSERT");
        fieldNim.setEditable(true);
    }
    public void inputDb(){
        try {
            st = con.createStatement();
            
            if(fieldNim.getText().equals("") || 
                    fieldNama.getText().equals("") || 
                    fieldKelas.getText().equals("") || 
                    fieldSemester.getText().equals("")){
                JOptionPane.showMessageDialog(null, "INPUT ALL DATA FIRST !", "DATA VALIDATION",JOptionPane.INFORMATION_MESSAGE);
                }
            if(btnInsert.getText() == "INSERT"){
                String sql = "SELECT * FROM mahasiswa WHERE NIM = '" + fieldNim.getText() + "'";
                rs = st.executeQuery(sql);
                if(rs.next()){
                    JOptionPane.showMessageDialog(null, "NIM ALREADY AVAIBLE !", "DATA VALIDATION",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    String insert = "INSERT INTO mahasiswa VALUES ('" + fieldNim.getText() + "','" + fieldNama.getText() + "','" + cbGender.getSelectedItem().toString() + "','" + fieldKelas.getText() + "','" + fieldSemester.getText() + "')";
                    st.executeUpdate(insert);
                    JOptionPane.showMessageDialog(null, "INSERT DATA SUCCESS !", "DATA INSERT",JOptionPane.INFORMATION_MESSAGE);
                    clear();
                    showDb();
                }
            }
            else if(btnInsert.getText() == "UPDATE"){
                    String sql = "UPDATE mahasiswa SET nama = '" + fieldNama.getText() + "', GENDER = '" + cbGender.getSelectedItem().toString() + "', KELAS = '" + fieldKelas.getText() + "', SEMESTER = '" + fieldSemester.getText() + "' WHERE NIM = '" + fieldNim.getText() + "'";
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "UPDATE DATA SUCCESS !", "DATA UPDATE",JOptionPane.INFORMATION_MESSAGE);
                    clear();
                    showDb();
            } 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } 
    }
    public void delete(){
        if(fieldNim.getText().equals("")){
            JOptionPane.showMessageDialog(null, "ENTER NIM YOU WANT TO REMOVE !", "DATA VALIDATION",JOptionPane.INFORMATION_MESSAGE);
        }else{
            int question = JOptionPane.showConfirmDialog(null, "THIS DATA WILL BE REMOVED ?","CONFIRMATION",JOptionPane.INFORMATION_MESSAGE);
            if(question == 0){
                try {
                    st = con.createStatement();
                    String sql = "DELETE FROM mahasiswa WHERE NIM = '" + fieldNim.getText()+ "'";
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "DELETE DATA SUCCESS !", "DATA DELETE",JOptionPane.INFORMATION_MESSAGE);
                    showDb();
                    clear();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        }
    }
    public form() {
        initComponents();
        showDb();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fieldNim = new javax.swing.JTextField();
        fieldNama = new javax.swing.JTextField();
        fieldKelas = new javax.swing.JTextField();
        fieldSemester = new javax.swing.JTextField();
        cbGender = new javax.swing.JComboBox<>();
        btnInsert = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JAVA CRUD");

        jLabel1.setText("NIM");

        jLabel2.setText("NAMA");

        jLabel3.setText("GENDER");

        jLabel4.setText("KELAS");

        jLabel5.setText("SEMESTER");

        cbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "L", "P" }));

        btnInsert.setText("INSERT");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClear.setText("CLEAR");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "NIM", "NAMA", "GENDER", "KELAS", "SEMESTER"
            }
        ));
        tblData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblData);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnInsert)
                                .addGap(18, 18, 18)
                                .addComponent(btnDelete)
                                .addGap(18, 18, 18)
                                .addComponent(btnClear))
                            .addComponent(fieldNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNim, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(fieldSemester, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addComponent(fieldKelas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {fieldNama, fieldNim});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fieldNim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(fieldNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(fieldKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(fieldSemester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsert)
                    .addComponent(btnDelete)
                    .addComponent(btnClear))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        inputDb();
    }//GEN-LAST:event_btnInsertActionPerformed

    private void tblDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDataMouseClicked
        fieldNim.setText(tblData.getValueAt(tblData.getSelectedRow(), 0).toString());
        fieldNama.setText(tblData.getValueAt(tblData.getSelectedRow(), 1).toString());
        cbGender.setSelectedItem(tblData.getValueAt(tblData.getSelectedRow(), 2).toString());
        fieldKelas.setText(tblData.getValueAt(tblData.getSelectedRow(), 3).toString());
        fieldSemester.setText(tblData.getValueAt(tblData.getSelectedRow(), 4).toString());
        
        fieldNim.setEditable(false);
        btnInsert.setText("UPDATE");
    }//GEN-LAST:event_tblDataMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        delete();
    }//GEN-LAST:event_btnDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JComboBox<String> cbGender;
    private javax.swing.JTextField fieldKelas;
    private javax.swing.JTextField fieldNama;
    private javax.swing.JTextField fieldNim;
    private javax.swing.JTextField fieldSemester;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblData;
    // End of variables declaration//GEN-END:variables
}
