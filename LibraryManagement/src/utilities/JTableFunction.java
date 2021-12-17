/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

/**
 *
 * @author Admin
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.regex.PatternSyntaxException;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.database.Connect;

/**
 *
 * @author Admin
 */
public class JTableFunction {
    //Load data from database to table
    public void LoadData(JTable tb, String sql) {
        DefaultTableModel dtm = (DefaultTableModel)tb.getModel();
        dtm.setNumRows(0);
        Connection conn = Connect.GetConnect();
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            Vector vt;
            
            while(rs.next()) {
                vt = new Vector();
                for (int i = 1; i <= tb.getColumnCount(); i++) {
                    vt.add(rs.getString(i));
                }
                
                dtm.addRow(vt);
            }
            
            if(dtm.getRowCount()==0){
                vt=new Vector();
                for(int i=1;i<=dtm.getColumnCount();i++){
                    if(i==dtm.getColumnCount()/2){
                        vt.add("(Trống)");
                    }
                    else vt.add("");
                    }
                dtm.addRow(vt);
            }
            
            tb.setModel(dtm);
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("lỗi kết nối database đến bảng ");
            e.printStackTrace();
        }
    }
    public void LoadData(JTable tb, String sql, boolean haveDayInWeek) {
        DefaultTableModel dtm = (DefaultTableModel)tb.getModel();
        dtm.setNumRows(0);
        
        Connection conn = Connect.GetConnect();
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            Vector vt;
            
            while(rs.next()) {
                vt = new Vector();
                for (int i = 1; i <= tb.getColumnCount(); i++) {
                    if (i == 4) vt.add(Integer.toString(Integer.parseInt(rs.getString(i).trim()) + 1));
                    else vt.add(rs.getString(i));
                }
                
                dtm.addRow(vt);
            }
            
            if(dtm.getRowCount()==0){
                vt=new Vector();
                for(int i=1;i<=dtm.getColumnCount();i++){
                    if(i==dtm.getColumnCount()/2){
                        vt.add("(Trống)");
                    }
                    else vt.add("");
                    }
                dtm.addRow(vt);
            }
            
            tb.setModel(dtm);
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("lỗi kết nối database đến bảng");
        }
    }
    
    public String selectRow(JTable tb, int numRow) {
        try {
            return tb.getValueAt(tb.getSelectedRow(), numRow).toString();
        } catch (NullPointerException e) {
            return null;
        }
    }
    
    
    //Sort
    public void Sort(JTable tb ,int xepTheoCot,int kieuXep)// xepTheo: cột cần xếp, kieuXep: 0=tăng hoặc 1=giảm
    {
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tb.getModel());
        tb.setRowSorter(sorter);

        ArrayList <RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();
        if(kieuXep==0){
            sortKeys.add(new RowSorter.SortKey(xepTheoCot, SortOrder.ASCENDING));
        }
        else if(kieuXep==1){
            sortKeys.add(new RowSorter.SortKey(xepTheoCot, SortOrder.DESCENDING));
        }
        sorter.setSortKeys(sortKeys); 
    }  
    
    // Lọc tất cả các hàng có dữ liệu ở cột cotLoc là str
    public void Search(JTable tb, String str, int cotLoc){
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(((DefaultTableModel) tb.getModel())); 
        tb.setRowSorter(sorter);
        try {
            if(cotLoc > -1){//nếu cột lọc -1 thì lọc tất cả các cột xem cột nào = str
                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + str, cotLoc));
            }else {
                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + str));
            }
        } 
        catch(PatternSyntaxException pse) {
            System.out.println("Bad regex pattern");
        }
    }
    
    public long SumColumn (JTable tb, int column)
    {
        long sum = 0;
        
        try {
            for (int row = 0; row < tb.getRowCount(); row ++) 
            {
                if (tb.getValueAt(row, column).toString().isEmpty()) return 0;
                sum += Integer.parseInt(tb.getValueAt(row, column).toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return sum;
    }
}
