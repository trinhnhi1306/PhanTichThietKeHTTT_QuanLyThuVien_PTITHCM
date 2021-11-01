/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.librarian;

import java.sql.Connection;
import model.database.Connect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
import javax.swing.JOptionPane;
import java.lang.String;

/**
 *
 * @author Admin
 */
public class ExtendCard {
    public static ExtendCard Instance = new ExtendCard();
    
    public boolean ExtendByMonth (String username, int month)
    {
        String expirationDate;
        String amountMoney;
        String query1 = "EXEC SP_GetExpirationDate " + username;
        String query2 = "EXEC SP_GetAmountMoneyByMonth " + month;
        
        Connection conn = Connect.GetConnect();
        PreparedStatement ps;
        ResultSet rs;
        //get the expiration month of that user
        try {
            ps = conn.prepareStatement(query1);
            rs =ps.executeQuery();
            rs.next();
            expirationDate = rs.getString(1);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hãy kiểm tra lại tài khoản", "Lỗi username", JOptionPane.WARNING_MESSAGE);
            System.out.println("Username not correct" + e.getMessage());
            return false;
        }
        
        //caculate the Amount of money
        try {
            ps = conn.prepareStatement(query2);
            rs =ps.executeQuery();
            rs.next();
            amountMoney = rs.getString(1);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hãy kiểm tra lại số lượng tháng", "Lỗi tháng", JOptionPane.WARNING_MESSAGE);
            System.out.println("month amount not correct" + e.getMessage());
            return false;
        }
        
        
//        if (username == "" || amountMoney == "") 
//        {
//            System.out.println("null");
//            return false;
//        }
        
        //create a extension of that user
        try {
            String query3 = "EXEC SP_AddExtension " + amountMoney + ", '" + expirationDate + "', " + username + ", null";
            CallableStatement stmt = conn.prepareCall(query3);
            stmt.execute();
            stmt.close();
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hãy thử lại sau một lúc", "Gia hạn thất bại", JOptionPane.WARNING_MESSAGE);
            System.out.println("something wrong in insert period" + e.getMessage());
            return false;
        }
        return true;
    }
}
