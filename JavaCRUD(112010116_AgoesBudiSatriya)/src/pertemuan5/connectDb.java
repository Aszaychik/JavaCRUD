/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuan5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class connectDb {
    public static Connection conSql(){
    try{
        String url = "jdbc:mysql://localhost:3306/praktikumpbo";
        Connection con = DriverManager.getConnection(url,"root","");
        return con;
    } catch(SQLException e){
        JOptionPane.showMessageDialog(null, e);
        return null;
    }
    }
}
