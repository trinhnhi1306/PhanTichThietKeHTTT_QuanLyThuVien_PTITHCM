/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.admin;

import control.manager.Revenue;
import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
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
}
