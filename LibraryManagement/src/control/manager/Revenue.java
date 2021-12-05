/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.manager;
import java.sql.Connection;
import model.database.Connect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class Revenue {
    public static Revenue Instance = new Revenue();
    
    public long CalculateTotalRevenue ()
    {
        String query = "select * from Get_TotalRevenueFromExtend";
        long result;
        
        Connection conn = Connect.GetConnect();
        PreparedStatement ps;
        ResultSet rs;
        
        try {
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            rs.next();
            result = rs.getLong(1);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lấy doanh thu thất bại, hãy thử lại sau", "Lỗi truy vấn", JOptionPane.WARNING_MESSAGE);
            System.out.println("something wrong in view Get_TotalRevenueFromExtend" + e.getMessage());
            return -1;
        }
        
        return result;
    }
    
    public long CalculateTotalRevenue (int month, int year)
    {
        String query = "EXEC SP_GetAllRevenueInMonth " + month + ", " + year;
        long result = 0;
        
        Connection conn = Connect.GetConnect();
        PreparedStatement ps;
        ResultSet rs;
        
        try {
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next())
                result += rs.getLong(5);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lấy doanh thu thất bại, hãy thử lại sau", "Lỗi truy vấn", JOptionPane.WARNING_MESSAGE);
            System.out.println("something wrong in view Get_TotalRevenueFromExtend" + e.getMessage());
            return -1;
        }
        
        return result;
    }
}
