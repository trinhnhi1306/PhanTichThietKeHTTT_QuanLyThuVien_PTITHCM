/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.admin;

import control.librarian.BookLoan;
import control.manager.Revenue;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import model.database.Connect;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;

/**
 *
 * @author Admin
 */
public class ChartController {
    public static ChartController Instance = new ChartController();
    
    public void SetDataToRevanueChart (JPanel panel, int year)
    {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        String sqlLoadData = "EXEC SP_GetAllRevenueInMonth ";
        
        long revenueOfMonth;
        for (int month = 1; month <= 12; month ++)
        {
            revenueOfMonth = Revenue.Instance.CalculateTotalRevenue(month, year);
            dataset.addValue((Number)revenueOfMonth, "Revenue", month);
        }
        
        String title = "revenue statistics chart in " + String.valueOf(year);
        JFreeChart barChart = ChartFactory.createBarChart(title.toUpperCase(), "Month", "Revenue", dataset, PlotOrientation.VERTICAL, false, true, false);
    
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(panel.getWidth(), 550));
        
        panel.removeAll();
        panel.setLayout(new CardLayout());
        panel.add(chartPanel);
        panel.validate();
        panel.repaint();
    }
    
    public void SetDataToCategoryChart (JPanel panel, int year)
    {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        String query = "select top 10  c.category, num = count(c.category)\n" +
                                "from loan l, loan_detail dt, book b, category c\n" +
                                "where l.loan_id = dt.loan_id\n" +
                                "and dt.book_id = b.book_id\n" +
                                "and b.category_id = c.category_id\n" +
                                "and year(l.date_start) = " + year + "\n" +
                                "group by c.category\n" +
                                "order by num desc";
        
        try (
            Connection con = Connect.GetConnect();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                dataset.addValue(rs.getInt("num"), "Genres", rs.getString("category"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookLoan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String title = "top 10 most borrowed genres in " + String.valueOf(year);
        JFreeChart barChart = ChartFactory.createBarChart(title.toUpperCase(), "Genres", "Number", dataset, PlotOrientation.VERTICAL, false, true, false);
    
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(panel.getWidth(), 550));
        
        panel.removeAll();
        panel.setLayout(new CardLayout());
        panel.add(chartPanel);
        panel.validate();
        panel.repaint();
    }
    
    public void SetDataToAuthorChart (JPanel panel, int year)
    {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        String query = "select top 10 a.name, num = count(a.name)\n" +
                        "from loan l, loan_detail dt, book b, author a\n" +
                        "where l.loan_id = dt.loan_id\n" +
                        "and dt.book_id = b.book_id\n" +
                        "and b.author_id = a.author_id\n" +
                        "and year(l.date_start) = " + year + "\n" +
                        "group by a.name\n" +
                        "order by num desc";
        
        try (
            Connection con = Connect.GetConnect();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                dataset.addValue(rs.getInt("num"), "Author", rs.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookLoan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String title = "top 10 most borrowed authors in " + String.valueOf(year);
        JFreeChart barChart = ChartFactory.createBarChart(title.toUpperCase(), "Author", "Number", dataset, PlotOrientation.VERTICAL, false, true, false);
    
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(panel.getWidth(), 550));
        
        panel.removeAll();
        panel.setLayout(new CardLayout());
        panel.add(chartPanel);
        panel.validate();
        panel.repaint();
    }
    
    public void SetDataToPublisherChart (JPanel panel, int year)
    {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        String query = "select top 10 p.name, num = count(p.name)\n" +
                        "from loan l, loan_detail dt, book b, publisher p\n" +
                        "where l.loan_id = dt.loan_id\n" +
                        "and dt.book_id = b.book_id\n" +
                        "and b.publisher_id = p.publisher_id\n" +
                        "and year(l.date_start) = " + year + "\n" +
                        "group by p.name\n" +
                        "order by num desc";
        
        try (
            Connection con = Connect.GetConnect();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                dataset.addValue(rs.getInt("num"), "Publisher", rs.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookLoan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String title = "top 10 most borrowed publishers in " + String.valueOf(year);
        JFreeChart barChart = ChartFactory.createBarChart(title.toUpperCase(), "Publisher", "Number", dataset, PlotOrientation.VERTICAL, false, true, false);
    
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(panel.getWidth(), 550));
        
        panel.removeAll();
        panel.setLayout(new CardLayout());
        panel.add(chartPanel);
        panel.validate();
        panel.repaint();
    }
}
