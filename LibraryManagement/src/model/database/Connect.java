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

/**
 *
 * @author Admin
 */
public class Connect {
    public static Connection GetConnect(){
        Connection conn = null;
        String url ="jdbc:sqlserver://;databaseName=QLTHUVIEN";
        String user = "sa";
        String password = "123";
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
}
