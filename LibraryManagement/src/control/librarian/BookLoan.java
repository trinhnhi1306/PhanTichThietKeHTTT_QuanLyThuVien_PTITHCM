/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control.librarian;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.database.Connect;
import model.database.Reader;
import model.database.Rule;

/**
 *
 * @author TRINH
 */
public class BookLoan {
    
    public void loadReader(DefaultTableModel model){
        
        model.setNumRows(0);
        Connection ketNoi= Connect.GetConnect();
        Vector vt;
        try {
            PreparedStatement ps = ketNoi.prepareStatement("select a.username,a.Full_Name,a.gender,a.date_of_birth,address.specific_address + ' - ' + ward.ward_name  + ' - ' + district.district_name + ' - ' + province.province_name as diachi,a.phone_number,a.email,a.registered_date from account a\n" +
                                                                "inner join address\n" +
                                                                "on address.address_id = a.address_id\n" +
                                                                "left join ward\n" +
                                                                "on address.ward_id = ward.ward_id\n" +
                                                                "left join district\n" +
                                                                "on ward.district_id = district.district_id\n" +
                                                                "left join province\n" +
                                                                "on district.province_id = province.province_id where a.role_id = 1 and a.status = 1");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                vt = new Vector();
                vt.add(rs.getString(1));
                vt.add(rs.getString(2));
                vt.add(rs.getString(3));
                vt.add(rs.getDate(4));
                vt.add(rs.getString(5));
                vt.add(rs.getString(6));
                vt.add(rs.getString(7));
                vt.add(rs.getString(8));
                model.addRow(vt);
            }
            ps.close();
            rs.close();
            ketNoi.close();
        } catch (SQLException ex) {
            System.out.println("Lỗi load reader");
        }   
    }    
    
    public void loadBookList(DefaultTableModel model){
        
        model.setNumRows(0);
        Connection ketNoi= Connect.GetConnect();
        Vector vt;
        try {
            PreparedStatement ps = ketNoi.prepareStatement("select b.book_id, b.title, l.location, a.name, p.name, c.category, b.no_of_copies_current\n" +
                                                            "from book b\n" +
                                                            "inner join location l on b.location_id = l.location_id\n" +
                                                            "inner join author a on b.author_id = a.author_id\n" +
                                                            "inner join publisher p on b.publisher_id = p.publisher_id\n" +
                                                            "inner join category c on b.category_id = c.category_id");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                vt = new Vector();
                vt.add(rs.getString(1));
                vt.add(rs.getString(2));
                vt.add(rs.getString(3));
                vt.add(rs.getString(4));
                vt.add(rs.getString(5));
                vt.add(rs.getString(6));
                vt.add(rs.getString(7));
                model.addRow(vt);
            }
            ps.close();
            rs.close();
            ketNoi.close();
        } catch (SQLException ex) {
            System.out.println("Lỗi load reader");
        }   
    }    
    
    public void loadBookBorrowed(Map<Integer, Vector> mapBookBorrewed, DefaultTableModel model, String username){
        
        model.setNumRows(0);
        Connection ketNoi= Connect.GetConnect();
        Vector vt;
        try {
            PreparedStatement ps = ketNoi.prepareStatement("select b.book_id, b.title, l.location, a.name, p.name, c.category, loan.date_start\n" +
                                                            "from loan\n" +
                                                            "inner join loan_detail dt on loan.loan_id = dt.loan_id\n" +
                                                            "inner join book b on b.book_id = dt.book_id\n" +
                                                            "inner join location l on b.location_id = l.location_id\n" +
                                                            "inner join author a on b.author_id = a.author_id\n" +
                                                            "inner join publisher p on b.publisher_id = p.publisher_id\n" +
                                                            "inner join category c on b.category_id = c.category_id\n" +
                                                            "where dt.status = 0 and loan.user_id = '" + username + "'");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                vt = new Vector();
                vt.add(rs.getString(1));
                vt.add(rs.getString(2));
                vt.add(rs.getString(3));
                vt.add(rs.getString(4));
                vt.add(rs.getString(5));
                vt.add(rs.getString(6));
                vt.add(rs.getString(7));
                model.addRow(vt);
                mapBookBorrewed.put(rs.getInt(1), vt);
            }
            ps.close();
            rs.close();
            ketNoi.close();
        } catch (SQLException ex) {
            System.out.println("Lỗi load Book Borrowed");
        } 
    }    
    
    public void loadLoanList(DefaultTableModel model){
        
        model.setNumRows(0);
        Connection ketNoi= Connect.GetConnect();
        Vector vt;
        try {
            PreparedStatement ps = ketNoi.prepareStatement("select l.loan_id, a.Full_Name, a.phone_number, l.date_start, DATEADD(day, r.max_rental_day, l.date_start), l.rule_id\n" +
                                                            "from loan l\n" +
                                                            "inner join account a\n" +
                                                            "on l.user_id = a.username\n" +
                                                            "inner join [rule] r\n" +
                                                            "on l.rule_id = r.rule_id\n" +
                                                            "order by l.loan_id desc");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                vt = new Vector();
                vt.add(rs.getString(1));
                vt.add(rs.getString(2));
                vt.add(rs.getString(3));
                vt.add(rs.getString(4));
                vt.add(rs.getString(5));
                vt.add(rs.getString(6));
                model.addRow(vt);
            }
            ps.close();
            rs.close();
            ketNoi.close();
        } catch (SQLException ex) {
            System.out.println("Lỗi load Loan List");
        } 
    }    
    
    public void loadLoanDetail(DefaultTableModel model, String loanID){
        
        model.setNumRows(0);
        Connection ketNoi= Connect.GetConnect();
        Vector vt;
        int status = 0;
        try {
            PreparedStatement ps = ketNoi.prepareStatement("select dt.loan_id, b.title, a.name, dt.date_end, dt.status\n" +
                                                            "from loan_detail dt\n" +
                                                            "inner join book b\n" +
                                                            "on dt.book_id = b.book_id\n" +
                                                            "inner join author a\n" +
                                                            "on b.author_id = a.author_id\n" +
                                                            "where dt.loan_id = " + loanID);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                vt = new Vector();
                vt.add(rs.getString(1));
                vt.add(rs.getString(2));
                vt.add(rs.getString(3));
                vt.add(rs.getString(4));
                status = rs.getInt(5);
                /*
                    Status 0: đang mượn chưa trả
                    Status 1: đã trả, không trễ, không làm hỏng/mất
                    Status 2: đã trả, trả trễ, không làm hỏng/mất
                    Status 3: đã trả, không trễ, làm hỏng/mất
                    Status 4: đã trả, trả trễ, làm hỏng/mất
                */
                if(status == 0)
                    vt.add("Đang mượn");
                else if(status == 1)
                    vt.add("Đã trả");
                else if(status == 2)
                    vt.add("Trễ hạn");
                else if(status == 3)
                    vt.add("Hỏng/mất");
                else
                    vt.add("Trễ hạn, hỏng/mất");
                model.addRow(vt);
            }
            ps.close();
            rs.close();
            ketNoi.close();
        } catch (SQLException ex) {
            System.out.println("Lỗi load Loan List");
        } 
    }    
    
    public boolean findChosenBook(DefaultTableModel model, String id) {
        int size = model.getRowCount();
        for(int i = 0; i < size; i++) {
            if (model.getValueAt(i,0).toString().equals(id))
                return true;
        }
        return false;
    }
    
    public boolean findBorrowedBook(String username, String bookID) {
        String query =  "select *\n" +
                        "from loan l\n" +
                        "inner join loan_detail dt\n" +
                        "on l.loan_id = dt.loan_id\n" +
                        "where l.user_id = '" + username + "'\n" +
                        "and dt.status = 0\n" +
                        "and dt.book_id = " + bookID;
        try {
            Connection conn = Connect.GetConnect();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {                
                return true;                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookLoan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public void insertLoan(String username) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        String ngayMuon = dateFormatter.format(new java.util.Date());
        int ruleID = getCurrentRule().getMaQuyDinh();
        try (
            Connection con = Connect.GetConnect();
            PreparedStatement rs = con.prepareStatement("INSERT INTO LOAN VALUES(?, ?, ?)")) {
            rs.setString(1, username);
            rs.setString(2, ngayMuon);
            rs.setInt(3, ruleID);
            rs.executeUpdate();
            rs.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookLoan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getCurrentBorrow() {
        String query =  "select top 1 *\n" +
                        "from loan\n" +
                        "order by loan_id\n" +
                        "desc";
        int loanID = 0;
        try {
            Connection con = Connect.GetConnect();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                loanID = rs.getInt(1);
            }
            rs.close();
            ps.close();
            con.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookLoan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return loanID;
    }
    
    public void updateBookQuantity(DefaultTableModel modelChosenBook) {
        
        int size = modelChosenBook.getRowCount();
        for (int i = 0; i < size; i++) {
            try {
                Connection con = Connect.GetConnect();
                PreparedStatement rs = con.prepareStatement("UPDATE BOOK SET no_of_copies_current = no_of_copies_current - 1 WHERE book_id = ?");
                rs.setInt(1, Integer.parseInt(modelChosenBook.getValueAt(i,0).toString()));
                rs.executeUpdate();
                rs.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BookLoan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }          
    }
    
    public void updateBookQuantity1(DefaultTableModel modelChosenBook) {
        
        int size = modelChosenBook.getRowCount();
        for (int i = 0; i < size; i++) {
            
            if(Integer.parseInt(modelChosenBook.getValueAt(i,4).toString()) != 0)
                continue;
            
            try {
                Connection con = Connect.GetConnect();
                PreparedStatement rs = con.prepareStatement("UPDATE BOOK SET no_of_copies_current = no_of_copies_current + 1 WHERE book_id = ?");
                rs.setInt(1, Integer.parseInt(modelChosenBook.getValueAt(i,0).toString()));
                rs.executeUpdate();
                rs.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BookLoan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }          
    }
    
    public void borrowBook(String username, DefaultTableModel modelChosenBook) {
        insertLoan(username);
        int loanID = getCurrentBorrow();
        String query;
        int size = modelChosenBook.getRowCount();
        for (int i = 0; i < size; i++) {
            try {
                Connection con = Connect.GetConnect();
                PreparedStatement rs = con.prepareStatement("INSERT INTO LOAN_DETAIL (loan_id, book_id, status) VALUES(?, ?, ?)");
                rs.setInt(1, loanID);
                rs.setInt(2, Integer.parseInt(modelChosenBook.getValueAt(i,0).toString()));
                rs.setInt(3, 0);
                rs.executeUpdate();
                rs.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BookLoan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
        updateBookQuantity(modelChosenBook);
    }
    
    public void returnBook(String username, DefaultTableModel modelChosenBook) {
        
        String query = "update loan_detail\n" +
                        "set status = ?, date_end = Getdate()\n" +
                        "where status = 0 and book_id = ?\n" +
                        "and loan_id = (select dt.loan_id\n" +
                        "                from loan l\n" +
                        "                inner join loan_detail dt\n" +
                        "                on l.loan_id = dt.loan_id\n" +
                        "                where l.user_id = '" + username + "'\n" +
                        "                and dt.status = 0\n" +
                        "                and dt.book_id = ?)";
        int size = modelChosenBook.getRowCount();
        int bookID = 0;
        int overDueFines = 0;
        int brokenLostFines = 0;
        for (int i = 0; i < size; i++) {
            bookID = Integer.parseInt(modelChosenBook.getValueAt(i,0).toString());
            overDueFines = Integer.parseInt(modelChosenBook.getValueAt(i,3).toString());
            brokenLostFines = Integer.parseInt(modelChosenBook.getValueAt(i,4).toString());
            try {
                Connection con = Connect.GetConnect();
                PreparedStatement rs = con.prepareStatement(query);
                /*
                    Status 0: đang mượn chưa trả
                    Status 1: đã trả, không trễ, không làm hỏng/mất
                    Status 2: đã trả, trả trễ, không làm hỏng/mất
                    Status 3: đã trả, không trễ, làm hỏng/mất
                    Status 4: đã trả, trả trễ, làm hỏng/mất
                */
                if(brokenLostFines != 0 && overDueFines != 0)
                    rs.setInt(1, 4);
                else if(brokenLostFines != 0 && overDueFines == 0)
                    rs.setInt(1, 3);
                else if(brokenLostFines == 0 && overDueFines != 0)
                    rs.setInt(1, 2);
                else
                    rs.setInt(1, 1);
                rs.setInt(2, bookID);
                rs.setInt(3, bookID);
                rs.executeUpdate();
                rs.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BookLoan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
        updateBookQuantity1(modelChosenBook);
    }
    
    public boolean expiredUser(String username){
        LocalDate today = LocalDate.now();
        String query = "EXEC [dbo].[SP_GetExpirationDate] '" + username + "'";
        try {
            Connection conn = Connect.GetConnect();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                // Calculate days between today and ngayHetHan
                LocalDate ngayHetHan = LocalDate.parse(rs.getString(1));
                Duration diff = Duration.between(ngayHetHan.atStartOfDay(), today.atStartOfDay());
                long diffDays = diff.toDays();

                if (diffDays > 0) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookLoan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public int numberOfBooksBorrowing(String username) {
        String query = "select count(*) from loan_detail dt inner join loan l on dt.loan_id = l.loan_id and dt.status = 0 and l.user_id = '" + username + "'";
        try (
            Connection con = Connect.GetConnect();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery()) {
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(BookLoan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public Rule getCurrentRule() {
        String query = "select top 1 * FROM [rule] ORDER BY rule_id DESC";
        Rule rule = null;
        try {
            Connection con = Connect.GetConnect();
            PreparedStatement ps = con.prepareStatement(query);
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
    
    public int getOverdueFines(String username, String bookID) {
        String query = "select DATEADD(day, r.max_rental_day, loan.date_start), r.fine\n" +
                        "from loan\n" +
                        "inner join [rule] r on loan.rule_id = r.rule_id\n" +
                        "inner join loan_detail dt on loan.loan_id = dt.loan_id\n" +
                        "where dt.status = 0 and loan.user_id = '" + username + "' and dt.book_id = " + bookID;
        int overDueFines = 0;
        String date = null;
        try {
            Connection con = Connect.GetConnect();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                date = rs.getString(1);
                overDueFines = rs.getInt(2);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        // Calculate days between today and hanTra
        LocalDate today = LocalDate.now();
        LocalDate hanTra = LocalDate.parse(date);
        Duration diff = Duration.between(hanTra.atStartOfDay(), today.atStartOfDay());
        long diffDays = diff.toDays();
        System.out.println("Số ngày trễ hạn: " + diffDays);
        
        // Check if the book is returned late or not
        if (diffDays <= 0) {
            return 0;
        }
        else {
            return (int) (overDueFines * diffDays);
        }
    }
       
    public int getBrokenLostFines(String username, String bookID) {
        String query = "select b.price, r.penalties_damaged\n" +
                        "from loan\n" +
                        "inner join [rule] r on loan.rule_id = r.rule_id\n" +
                        "inner join loan_detail dt on loan.loan_id = dt.loan_id\n" +
                        "inner join book b on dt.book_id = b.book_id\n" +
                        "where dt.status = 0 and loan.user_id = '" + username + "' and dt.book_id = " + bookID;
        int brokenlost = 0;
        int price = 0;
        try {
            Connection con = Connect.GetConnect();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                price = rs.getInt(1);
                brokenlost = rs.getInt(2);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        // Calculate fines for loss/broke book
        int fines = price * brokenlost / 100;
        return fines;
    }
    
    public boolean expiredBook(String username, int soNgayMuonToiDa) {
        String query = "select * from loan_detail dt inner join loan l on dt.loan_id = l.loan_id and dt.status = 0 and l.user_id = '" + username + "'";
        LocalDate today = LocalDate.now();
        try (
                Connection con = Connect.GetConnect();
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                // Calculate days between today and hanTra
                LocalDate date_start = LocalDate.parse(rs.getString("date_start"));
                Duration diff = Duration.between(date_start.atStartOfDay(), today.atStartOfDay());
                long diffDays = diff.toDays();
                System.out.println(diffDays);
                if (diffDays > soNgayMuonToiDa) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookLoan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public Reader getReaderInformation(String username) {
        String query = "select a.username,a.Full_Name,a.gender,a.date_of_birth,address.specific_address + ' - ' + ward.ward_name  + ' - ' + district.district_name + ' - ' + province.province_name as diachi,a.phone_number,a.email,a.registered_date from account a\n" +
                                                                "inner join address\n" +
                                                                "on address.address_id = a.address_id\n" +
                                                                "left join ward\n" +
                                                                "on address.ward_id = ward.ward_id\n" +
                                                                "left join district\n" +
                                                                "on ward.district_id = district.district_id\n" +
                                                                "left join province\n" +
                                                                "on district.province_id = province.province_id\n" +
                                                                "where a.username = '" + username + "'";
        Reader reader = null;
        try {
            Connection con = Connect.GetConnect();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                reader = new Reader(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), "");
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return reader;
    }
}
