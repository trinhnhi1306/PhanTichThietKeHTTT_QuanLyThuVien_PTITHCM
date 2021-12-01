/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Admin
 */
public class UIController {
    public static void setHorizontalAlignmentForColumn(JTable table, int columnNumber, int Alignment) {
        DefaultTableCellRenderer align = new DefaultTableCellRenderer();
        align.setHorizontalAlignment(Alignment);
        table.getColumnModel().getColumn(columnNumber).setCellRenderer(align);
    }

    public static void setColumnWidth(JTable table, int column, int width) {
        table.getColumnModel().getColumn(column).setMinWidth(width);
        table.getColumnModel().getColumn(column).setMaxWidth(width);
    }

    public static void setDefaultTableHeader(JTable table) {
        DefaultTableCellRenderer defaultTableCellRenderer;
        table.setRowHeight(30);
        defaultTableCellRenderer = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
        defaultTableCellRenderer.setHorizontalAlignment(0); //Tiêu đề nằm giữa
        table.getTableHeader().setFont(new Font("Segoe UI", 1, 15));
        table.setFont(new java.awt.Font("Segoe UI", 0, 15));

        setHorizontalAlignmentForColumn(table, 0, JLabel.CENTER);
        setColumnWidth(table, 0, 50);
    }
       
    public static void showCardLayout(String cardName, JPanel cardPanel) {
        CardLayout layout = (CardLayout) (cardPanel.getLayout());
        layout.show(cardPanel, cardName);
        cardPanel.repaint();
    }
}
