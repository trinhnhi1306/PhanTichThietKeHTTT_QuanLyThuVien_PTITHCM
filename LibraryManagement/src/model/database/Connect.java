/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class Connect {
    
    private Connection con;
    private Statement stmt;
    
    public static Connection GetConnect(){
        Connection conn = null;
        String url ="jdbc:sqlserver://;databaseName=QLTHUVIEN";
        String user = "sa";
        String password = "123456";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println("connect error: "+e);
        }
        return conn;
    }
    
    public static ResultSet CallStatement (String sql) throws SQLException
    {
        Connection conn = Connect.GetConnect();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs =ps.executeQuery();
        rs.next();
        ps.close();
        conn.close();
        return rs;
    }
    
    public Connect() {
        try 
        {
            con = GetConnect();
            stmt = con.createStatement();
        } catch (Exception e) {
        }
    }
    
     public int Update(String str) {
        try 
        {
            int i = stmt.executeUpdate(str);
            return i;
        } catch (Exception e) {
            return -1;
        }
    }

    public ResultSet Query(String str) {
        try 
        {
            ResultSet rs = stmt.executeQuery(str);
            return rs;
        } catch (Exception e) {
            return null;
        }
    }
}
