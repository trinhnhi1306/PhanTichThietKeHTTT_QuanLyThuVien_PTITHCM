/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.librarian;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.Connection;
import model.database.Connect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;

/**
 *
 * @author Admin
 */
public class ExtendCard {
    public static void main(String[] args) throws SQLException {
        ExtendByMonth ("4", 1);
    }
    public static boolean ExtendByMonth (String username, int month) throws SQLException
    {
        String expirationDate;
        String amountMoney;
        String query1 = "EXEC SP_GetExpirationDate " + username;
        String query2 = "EXEC SP_GetAmountMoneyByMonth " + month;
        
        Connection conn = Connect.GetConnect();
        //get the expiration month of that user
        PreparedStatement ps = conn.prepareStatement(query1);
        ResultSet rs =ps.executeQuery();
        rs.next();
        expirationDate = rs.getString(1);
        System.out.println("1");
        
        //caculate the Amount of money
        ps = conn.prepareStatement(query2);
        rs =ps.executeQuery();
        rs.next();
        amountMoney = rs.getString(1);
        System.out.println("2");
        
        if (username == "" || amountMoney == "") 
        {
            System.out.println("null");
            return false;
        }
        
        //create a extension of that user
        String query3 = "EXEC SP_AddExtension " + amountMoney + ", '" + expirationDate + "', " + username + ", null";
        CallableStatement stmt = conn.prepareCall(query3);
        System.out.println(query3);
        stmt.execute();
        
        rs.close();
        ps.close();
        conn.close();
        return true;
    }
}
