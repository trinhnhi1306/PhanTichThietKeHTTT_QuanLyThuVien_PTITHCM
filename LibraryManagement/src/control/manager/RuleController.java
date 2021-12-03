/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control.manager;

import control.librarian.BookLoan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.database.Connect;
import model.database.Rule;

/**
 *
 * @author TRINH
 */
public class RuleController {
    
    public int insertRule(Rule rule) {
        
        try (
            Connection con = Connect.GetConnect();
            PreparedStatement rs = con.prepareStatement("INSERT INTO [RULE] VALUES(?, ?, ?, ?, ?)")) {
            rs.setInt(1, rule.getSoNgayMuonToiDa());
            rs.setInt(2, rule.getSoSachMuonToiDa());
            rs.setInt(3, rule.getTienPhatQuaHan());
            rs.setInt(4, rule.getTienPhatHongMat());
            rs.setString(5, rule.getNgayThayDoi());
            rs.executeUpdate();
            rs.close();
            con.close();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(BookLoan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public Rule searchRule(String date) {
        String query = "select top 1 * from [rule] where date_start <= ? order by rule_id desc";
        Rule rule = null;
        try {
            Connection con = Connect.GetConnect();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, date);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                rule = new Rule(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6));
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rule;
    }
}
