/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.main.librarian;

import control.librarian.BookLoan;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import model.database.Reader;
import swing.UIController;

/**
 *
 * @author Admin
 */
public class ReturnDialog extends javax.swing.JDialog {

    private BookLoan bookLoan;
    private Reader reader;
    private DefaultTableModel modelBookBorrowed;
    private DefaultTableModel modelChosenBook;
    /**
     * Creates new form ReturnDialog
     * @param parent
     * @param modal
     * @param parentPanel
     */
    public ReturnDialog(java.awt.Frame parent, boolean modal, JPanel parentPanel) {
        super(parent, modal);
        initComponents();
        bookLoan = new BookLoan();
        reader = bookLoan.getReaderInformation(ChooseReaderPanel.username);
        modelBookBorrowed = (DefaultTableModel) jTable_BooksBorrowed.getModel();
        modelChosenBook = (DefaultTableModel) jTable_ChosenBook.getModel();
        bookLoan.loadBookBorrowed(modelBookBorrowed, ChooseReaderPanel.username);
        setReaderInformation();
        setLocationRelativeTo(null);
        setTableView();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel_Name = new javax.swing.JLabel();
        jLabel_Gender = new javax.swing.JLabel();
        jLabel_DateOfBirth = new javax.swing.JLabel();
        jLabel_PhoneNumber = new javax.swing.JLabel();
        jLabel_Email = new javax.swing.JLabel();
        jLabel_DayStart = new javax.swing.JLabel();
        jLabel_Address = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_BooksBorrowed = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea_Fines = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_ChosenBook = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jButton_BrokenLost = new javax.swing.JButton();
        jButton_Choose = new javax.swing.JButton();
        jButton_Remove = new javax.swing.JButton();
        jButton_Clear = new javax.swing.JButton();
        jButton_Exit = new javax.swing.JButton();
        jButton_Return = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reader information", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 14), new java.awt.Color(153, 153, 153))); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.GridLayout(2, 0, 35, 10));

        jLabel_Name.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel_Name.setText("Name");
        jPanel3.add(jLabel_Name);

        jLabel_Gender.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel_Gender.setText("Gender");
        jPanel3.add(jLabel_Gender);

        jLabel_DateOfBirth.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel_DateOfBirth.setText("Date of birth");
        jPanel3.add(jLabel_DateOfBirth);

        jLabel_PhoneNumber.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel_PhoneNumber.setText("Phone number");
        jPanel3.add(jLabel_PhoneNumber);

        jLabel_Email.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel_Email.setText("Email");
        jPanel3.add(jLabel_Email);

        jLabel_DayStart.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel_DayStart.setText("Day start");
        jPanel3.add(jLabel_DayStart);

        jLabel_Address.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel_Address.setText("Address");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel_Address, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel_Address)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("List of books borrowed");

        jTable_BooksBorrowed.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Title", "Location", "Author", "Publisher", "Category", "Date Start"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable_BooksBorrowed);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total fines ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 14), new java.awt.Color(153, 153, 153))); // NOI18N

        jTextArea_Fines.setEditable(false);
        jTextArea_Fines.setColumns(20);
        jTextArea_Fines.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jTextArea_Fines.setRows(5);
        jTextArea_Fines.setText("Total overdue fines:\t0\nTotal broken/lost fines:\t0\nTotal fines:\t\t0");
        jScrollPane3.setViewportView(jTextArea_Fines);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Chosen book");

        jTable_ChosenBook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Title", "Author", "Overdue", "Broken/Lost"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable_ChosenBook);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new java.awt.GridLayout(1, 0, 35, 0));

        jButton_BrokenLost.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_BrokenLost.setForeground(new java.awt.Color(51, 51, 51));
        jButton_BrokenLost.setText("Broken / Lost ");
        jButton_BrokenLost.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_BrokenLost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BrokenLostActionPerformed(evt);
            }
        });

        jButton_Choose.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_Choose.setForeground(new java.awt.Color(51, 51, 51));
        jButton_Choose.setText("Choose");
        jButton_Choose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Choose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ChooseActionPerformed(evt);
            }
        });

        jButton_Remove.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_Remove.setForeground(new java.awt.Color(51, 51, 51));
        jButton_Remove.setText("Remove");
        jButton_Remove.setToolTipText("");
        jButton_Remove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RemoveActionPerformed(evt);
            }
        });

        jButton_Clear.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_Clear.setForeground(new java.awt.Color(51, 51, 51));
        jButton_Clear.setText("Clear");
        jButton_Clear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ClearActionPerformed(evt);
            }
        });

        jButton_Exit.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_Exit.setForeground(new java.awt.Color(51, 51, 51));
        jButton_Exit.setText("Exit");
        jButton_Exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ExitActionPerformed(evt);
            }
        });

        jButton_Return.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_Return.setForeground(new java.awt.Color(51, 51, 51));
        jButton_Return.setText("Return");
        jButton_Return.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ReturnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(217, 217, 217))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton_Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(158, 158, 158)
                        .addComponent(jButton_Choose, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(jButton_BrokenLost))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 120, Short.MAX_VALUE)
                        .addComponent(jButton_Return, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(jButton_Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jButton_Remove, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton_Remove)
                        .addComponent(jButton_Clear)
                        .addComponent(jButton_Exit)
                        .addComponent(jButton_Choose)
                        .addComponent(jButton_BrokenLost)
                        .addComponent(jButton_Return))
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setReaderInformation() {
        jLabel_Name.setText("Name: " + reader.getName());
        jLabel_Gender.setText("Gender: " + reader.getGender());
        jLabel_DateOfBirth.setText("Date of birth: " + reader.getDateOfBirth());
        jLabel_PhoneNumber.setText("Phone: " + reader.getPhone());
        jLabel_Email.setText("Email: " + reader.getEmail());
        jLabel_DayStart.setText("Registration date: " + reader.getRegisteredDate());
        jLabel_Address.setText("Address: " + reader.getAddress());
    }
    
    private void setTableView() {
        UIController.setDefaultTableHeader(jTable_BooksBorrowed);
        UIController.setDefaultTableHeader(jTable_ChosenBook);
    }

    private void jButton_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ExitActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton_ExitActionPerformed

    private void calculateTotalFines() {
        int totalOverdueFines = 0;
        int totalBrokenLostFines = 0;
        int size = modelChosenBook.getRowCount();
        for (int i = 0; i < size; i++) {
            totalOverdueFines += Integer.parseInt(modelChosenBook.getValueAt(i,3).toString());
            totalBrokenLostFines += Integer.parseInt(modelChosenBook.getValueAt(i,4).toString());
        }
        String str = "Total overdue fines:\t" + totalOverdueFines + "\n" +
                     "Total broken/lost fines:\t" + totalBrokenLostFines + "\n" +
                     "Total fines:\t\t" + (totalOverdueFines + totalBrokenLostFines);
        jTextArea_Fines.setText(str);
    }
    
    private void jButton_ChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ChooseActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable_BooksBorrowed.getSelectedRow();
        
        if(selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sách muốn mượn!");
            return;
        }
        
        if(bookLoan.findChosenBook(modelChosenBook, modelBookBorrowed.getValueAt(selectedRow, 0).toString())) {
            JOptionPane.showMessageDialog(this, "Sách này đã được chọn!");
            return;
        }
        
        Vector vt = new Vector();
        int overDueFines = bookLoan.getOverdueFines(ChooseReaderPanel.username, modelBookBorrowed.getValueAt(selectedRow, 0).toString());
        System.out.println(overDueFines);
        vt.add(modelBookBorrowed.getValueAt(selectedRow, 0));
        vt.add(modelBookBorrowed.getValueAt(selectedRow, 1));
        vt.add(modelBookBorrowed.getValueAt(selectedRow, 3));
        vt.add(overDueFines);
        vt.add(0);
        modelChosenBook.addRow(vt);
        calculateTotalFines();
    }//GEN-LAST:event_jButton_ChooseActionPerformed

    private void jButton_RemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RemoveActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable_ChosenBook.getSelectedRow();
        if(selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sách muốn xóa!");
            return;
        }
        modelChosenBook.removeRow(selectedRow);
        calculateTotalFines();
    }//GEN-LAST:event_jButton_RemoveActionPerformed

    private void jButton_BrokenLostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BrokenLostActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable_BooksBorrowed.getSelectedRow();
        
        if(selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sách muốn mượn!");
            return;
        }
        
        if(bookLoan.findChosenBook(modelChosenBook, modelBookBorrowed.getValueAt(selectedRow, 0).toString())) {
            JOptionPane.showMessageDialog(this, "Sách này đã được chọn!");
            return;
        }
        
        Vector vt = new Vector();
        int overDueFines = bookLoan.getOverdueFines(ChooseReaderPanel.username, modelBookBorrowed.getValueAt(selectedRow, 0).toString());
        int brokenLostFines = bookLoan.getBrokenLostFines(ChooseReaderPanel.username, modelBookBorrowed.getValueAt(selectedRow, 0).toString());
        System.out.println(overDueFines);
        vt.add(modelBookBorrowed.getValueAt(selectedRow, 0));
        vt.add(modelBookBorrowed.getValueAt(selectedRow, 1));
        vt.add(modelBookBorrowed.getValueAt(selectedRow, 3));
        vt.add(overDueFines);
        vt.add(brokenLostFines);
        modelChosenBook.addRow(vt);
        calculateTotalFines();
    }//GEN-LAST:event_jButton_BrokenLostActionPerformed

    private void jButton_ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ClearActionPerformed
        // TODO add your handling code here:
        modelChosenBook.setNumRows(0);
        calculateTotalFines();
    }//GEN-LAST:event_jButton_ClearActionPerformed

    private void jButton_ReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ReturnActionPerformed
        // TODO add your handling code here:
        if(modelChosenBook.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Chưa có sách được chọn!");
            return;
        }
        bookLoan.returnBook(ChooseReaderPanel.username, modelChosenBook);
        JOptionPane.showMessageDialog(this, "Trả sách thành công!");
        bookLoan.loadBookBorrowed(modelBookBorrowed, ChooseReaderPanel.username);
        modelChosenBook.setNumRows(0);
    }//GEN-LAST:event_jButton_ReturnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_BrokenLost;
    private javax.swing.JButton jButton_Choose;
    private javax.swing.JButton jButton_Clear;
    private javax.swing.JButton jButton_Exit;
    private javax.swing.JButton jButton_Remove;
    private javax.swing.JButton jButton_Return;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel_Address;
    private javax.swing.JLabel jLabel_DateOfBirth;
    private javax.swing.JLabel jLabel_DayStart;
    private javax.swing.JLabel jLabel_Email;
    private javax.swing.JLabel jLabel_Gender;
    private javax.swing.JLabel jLabel_Name;
    private javax.swing.JLabel jLabel_PhoneNumber;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable_BooksBorrowed;
    private javax.swing.JTable jTable_ChosenBook;
    private javax.swing.JTextArea jTextArea_Fines;
    // End of variables declaration//GEN-END:variables
}
