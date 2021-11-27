/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.main.librarian;

import control.librarian.BookLoan;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.database.Rule;
import swing.UIController;

/**
 *
 * @author Admin
 */
public class ChooseReaderPanel extends javax.swing.JPanel {

    public static int remainingBook;
    public static String username;
    private int flag;
    private LoanDialog loanDialog;
    private ReturnDialog returnDialog;
    private BookLoan bookLoan;
    private DefaultTableModel model;
    private Rule rule;

    /**
     * Creates new form ChooseReaderPanel
     */
    public ChooseReaderPanel() {
        initComponents();
        UIController.setDefaultTableHeader(jTable_Reader);
        bookLoan = new BookLoan();
        model = (DefaultTableModel) jTable_Reader.getModel();
        bookLoan.loadReader(model);
        rule = bookLoan.getCurrentRule();
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Reader = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jTextField_Search = new javax.swing.JTextField();
        jButton_ClearSearch = new javax.swing.JButton();
        jPanel_Card3 = new javax.swing.JPanel();
        jRadioButton_Name = new javax.swing.JRadioButton();
        jRadioButton_Phone = new javax.swing.JRadioButton();
        jButton_Choose = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jTable_Reader.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username", "Name", "Gender", "Date of birth", "Address", "Phone number", "Email", "Ngày đăng ký"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable_Reader);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 14), new java.awt.Color(153, 153, 153))); // NOI18N

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel21.setText("Search with");

        jTextField_Search.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jTextField_Search.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextField_SearchCaretUpdate(evt);
            }
        });

        jButton_ClearSearch.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_ClearSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clear.png"))); // NOI18N
        jButton_ClearSearch.setText("Clear");
        jButton_ClearSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ClearSearchActionPerformed(evt);
            }
        });

        jPanel_Card3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_Card3.setLayout(new java.awt.GridLayout(1, 0, 20, 0));

        jRadioButton_Name.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton_Name);
        jRadioButton_Name.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jRadioButton_Name.setSelected(true);
        jRadioButton_Name.setText("Name");
        jPanel_Card3.add(jRadioButton_Name);

        jRadioButton_Phone.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton_Phone);
        jRadioButton_Phone.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jRadioButton_Phone.setText("Phone number");
        jPanel_Card3.add(jRadioButton_Phone);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addGap(18, 18, 18)
                .addComponent(jPanel_Card3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton_ClearSearch)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField_Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_ClearSearch))
                    .addComponent(jPanel_Card3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jButton_Choose.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_Choose.setForeground(new java.awt.Color(51, 51, 51));
        jButton_Choose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/choose.png"))); // NOI18N
        jButton_Choose.setText("Choose reader");
        jButton_Choose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Choose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ChooseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1300, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_Choose)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jButton_Choose)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ChooseActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable_Reader.convertRowIndexToModel(jTable_Reader.getSelectedRow());
        if(selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn độc giả!");
            return;
        }
        username = (String) model.getValueAt(selectedRow, 0);
        System.out.println("Username: " + username);
        // check if reader card has expired
        if(bookLoan.expiredUser(username)) {
            JOptionPane.showMessageDialog(this, "Thẻ độc giả đã hết hạn! Vui lòng yêu cầu độc giả gia hạn thẻ để mượn sách");
            return;
        }
        System.out.println("Số sách tối đa được phép mượn: " + rule.getSoSachMuonToiDa());
        System.out.println("Số sách " + username + " đang mượn: " + bookLoan.numberOfBooksBorrowing(username));
        
        remainingBook = rule.getSoSachMuonToiDa() - bookLoan.numberOfBooksBorrowing(username);
        if(remainingBook <= 0) {
            JOptionPane.showMessageDialog(this, "Độc giả đã mượn số sách tối đa được phép là " + rule.getSoSachMuonToiDa() + ". Không thể mượn thêm!");
            return;
        }
        
        if(bookLoan.expiredBook(username, rule.getSoNgayMuonToiDa())) {
            JOptionPane.showMessageDialog(this, "Vui lòng trả sách mượn quá hạn trước để có thể mượn sách mới!");
            return;
        }
            
        if (flag == 1) {
            this.loanDialog = new LoanDialog(null, true, this);
            this.loanDialog.setVisible(true);
        } else if (flag == 2) {
            this.returnDialog = new ReturnDialog(null, true, this);
            this.returnDialog.setVisible(true);
        }
    }//GEN-LAST:event_jButton_ChooseActionPerformed

    private void jTextField_SearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextField_SearchCaretUpdate
        // TODO add your handling code here:
        String tuKhoa = jTextField_Search.getText();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        jTable_Reader.setRowSorter(trs);

        if (jRadioButton_Name.isSelected()) {
            trs.setRowFilter(RowFilter.regexFilter("(?i)" + tuKhoa, 1));
        }
        if (jRadioButton_Phone.isSelected()) {
            trs.setRowFilter(RowFilter.regexFilter("(?i)" + tuKhoa, 5));
        }
    }//GEN-LAST:event_jTextField_SearchCaretUpdate

    private void jButton_ClearSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ClearSearchActionPerformed
        // TODO add your handling code here:
        jTextField_Search.setText("");
    }//GEN-LAST:event_jButton_ClearSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton_Choose;
    private javax.swing.JButton jButton_ClearSearch;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel_Card3;
    private javax.swing.JRadioButton jRadioButton_Name;
    private javax.swing.JRadioButton jRadioButton_Phone;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Reader;
    private javax.swing.JTextField jTextField_Search;
    // End of variables declaration//GEN-END:variables
}
