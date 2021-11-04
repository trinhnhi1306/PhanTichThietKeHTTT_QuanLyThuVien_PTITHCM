/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.main.archivist;

import swing.UIController;

/**
 *
 * @author Admin
 */
public class BookPanel extends javax.swing.JPanel {

    public enum Mode {
        ADD,
        MODIFY,
        FREE
    }
    NewLocationDialog newLocationDialog;
    NewAuthorDialog newAuthorDialog;
    NewPublisherDialog newPublisherDialog;
    NewCategoryDialog newCategoryDialog;
    Mode mode;
    
    /**
     * Creates new form BookPanel
     */
    public BookPanel() {
        initComponents();
        UIController.setDefaultTableHeader(jTable_Book);
        setEditableForAll(false);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jComboBox_Location = new javax.swing.JComboBox<>();
        jComboBox_Author = new javax.swing.JComboBox<>();
        jComboBox_Publisher = new javax.swing.JComboBox<>();
        jTextField_ID = new javax.swing.JTextField();
        jTextField_Title = new javax.swing.JTextField();
        jTextField_Price = new javax.swing.JTextField();
        jDateChooser_PublishDate = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jComboBox_Category = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jSpinner_Add = new javax.swing.JSpinner();
        jButton_Publisher = new javax.swing.JButton();
        jButton_Category = new javax.swing.JButton();
        jButton_Location = new javax.swing.JButton();
        jButton_Author = new javax.swing.JButton();
        jPanel_Card = new javax.swing.JPanel();
        jPanel_Card1 = new javax.swing.JPanel();
        jButton_Add = new javax.swing.JButton();
        jButton_Modify = new javax.swing.JButton();
        jButton_Remove = new javax.swing.JButton();
        jPanel_Card2 = new javax.swing.JPanel();
        jButton_OK = new javax.swing.JButton();
        jButton_Cancel = new javax.swing.JButton();
        jButton_Clear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Book = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jTextField_TitleSearch = new javax.swing.JTextField();
        jButton_ClearSearch = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Book information", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 14), new java.awt.Color(153, 153, 153))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel1.setText("ID");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel2.setText("Title");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel6.setText("Category");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel7.setText("Publish date");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel8.setText("Price");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel10.setText("Publisher");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel11.setText("Location");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel12.setText("Author");

        jComboBox_Location.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jComboBox_Location.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox_Author.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jComboBox_Author.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox_Publisher.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jComboBox_Publisher.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTextField_ID.setEditable(false);
        jTextField_ID.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        jTextField_Title.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        jTextField_Price.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        jDateChooser_PublishDate.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("đ");

        jComboBox_Category.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jComboBox_Category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel9.setText("Add");

        jSpinner_Add.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jSpinner_Add.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jButton_Publisher.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_Publisher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        jButton_Publisher.setMaximumSize(new java.awt.Dimension(35, 29));
        jButton_Publisher.setMinimumSize(new java.awt.Dimension(35, 29));
        jButton_Publisher.setPreferredSize(new java.awt.Dimension(35, 29));
        jButton_Publisher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_PublisherActionPerformed(evt);
            }
        });

        jButton_Category.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_Category.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        jButton_Category.setMaximumSize(new java.awt.Dimension(35, 29));
        jButton_Category.setMinimumSize(new java.awt.Dimension(35, 29));
        jButton_Category.setPreferredSize(new java.awt.Dimension(35, 29));
        jButton_Category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CategoryActionPerformed(evt);
            }
        });

        jButton_Location.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_Location.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        jButton_Location.setMaximumSize(new java.awt.Dimension(35, 29));
        jButton_Location.setMinimumSize(new java.awt.Dimension(35, 29));
        jButton_Location.setPreferredSize(new java.awt.Dimension(35, 29));
        jButton_Location.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LocationActionPerformed(evt);
            }
        });

        jButton_Author.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_Author.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        jButton_Author.setMaximumSize(new java.awt.Dimension(35, 29));
        jButton_Author.setMinimumSize(new java.awt.Dimension(35, 29));
        jButton_Author.setPreferredSize(new java.awt.Dimension(35, 29));
        jButton_Author.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AuthorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooser_PublishDate, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                    .addComponent(jTextField_ID)
                    .addComponent(jTextField_Title))
                .addGap(91, 91, 91)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox_Location, 0, 200, Short.MAX_VALUE)
                    .addComponent(jTextField_Price)
                    .addComponent(jComboBox_Author, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(8, 8, 8)
                .addComponent(jLabel3)
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton_Location, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_Author, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel10)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jComboBox_Category, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox_Publisher, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSpinner_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton_Publisher, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Category, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(58, 58, 58))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8)
                    .addComponent(jTextField_Price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox_Publisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Publisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_Location, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jTextField_Title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox_Location, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(jLabel6)
                        .addComponent(jComboBox_Category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_Category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton_Author, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel12)
                        .addComponent(jComboBox_Author, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(jSpinner_Add, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                    .addComponent(jDateChooser_PublishDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel_Card.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_Card.setLayout(new java.awt.CardLayout());

        jPanel_Card1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_Card1.setLayout(new java.awt.GridLayout(1, 0, 35, 0));

        jButton_Add.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_Add.setForeground(new java.awt.Color(51, 51, 51));
        jButton_Add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add30px.png"))); // NOI18N
        jButton_Add.setText("Add");
        jButton_Add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AddActionPerformed(evt);
            }
        });
        jPanel_Card1.add(jButton_Add);

        jButton_Modify.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_Modify.setForeground(new java.awt.Color(51, 51, 51));
        jButton_Modify.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        jButton_Modify.setText("Modify");
        jButton_Modify.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Modify.setEnabled(false);
        jButton_Modify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ModifyActionPerformed(evt);
            }
        });
        jPanel_Card1.add(jButton_Modify);

        jButton_Remove.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_Remove.setForeground(new java.awt.Color(51, 51, 51));
        jButton_Remove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/trash.png"))); // NOI18N
        jButton_Remove.setText("Remove");
        jButton_Remove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Remove.setEnabled(false);
        jButton_Remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RemoveActionPerformed(evt);
            }
        });
        jPanel_Card1.add(jButton_Remove);

        jPanel_Card.add(jPanel_Card1, "cardFirst");

        jPanel_Card2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_Card2.setLayout(new java.awt.GridLayout(1, 0, 35, 0));

        jButton_OK.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_OK.setForeground(new java.awt.Color(51, 51, 51));
        jButton_OK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add30px.png"))); // NOI18N
        jButton_OK.setText("OK");
        jButton_OK.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_OKActionPerformed(evt);
            }
        });
        jPanel_Card2.add(jButton_OK);

        jButton_Cancel.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_Cancel.setForeground(new java.awt.Color(51, 51, 51));
        jButton_Cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancel20px.png"))); // NOI18N
        jButton_Cancel.setText("Cancel");
        jButton_Cancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CancelActionPerformed(evt);
            }
        });
        jPanel_Card2.add(jButton_Cancel);

        jButton_Clear.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_Clear.setForeground(new java.awt.Color(51, 51, 51));
        jButton_Clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clear.png"))); // NOI18N
        jButton_Clear.setText("Clear");
        jButton_Clear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ClearActionPerformed(evt);
            }
        });
        jPanel_Card2.add(jButton_Clear);

        jPanel_Card.add(jPanel_Card2, "cardSecond");

        jTable_Book.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Title", "Publish date", "Price", "Location", "Author", "Publisher", "Category", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable_Book);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel14.setText("Title");

        jTextField_TitleSearch.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        jButton_ClearSearch.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_ClearSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clear.png"))); // NOI18N
        jButton_ClearSearch.setText("Clear");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField_TitleSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_ClearSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 299, Short.MAX_VALUE)
                        .addComponent(jPanel_Card, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton_ClearSearch)
                        .addComponent(jTextField_TitleSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14))
                    .addComponent(jPanel_Card, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public void clearAll() {
        jDateChooser_PublishDate.setDate(null);
        jTextField_Title.setText("");
        jTextField_Price.setText("");
        jComboBox_Location.setSelectedIndex(0);
        jComboBox_Author.setSelectedIndex(0);
        jComboBox_Publisher.setSelectedIndex(0);
        jComboBox_Category.setSelectedIndex(0);
        jSpinner_Add.setValue(0);
    }

    public void setEditableForAll(boolean editable) {
        jDateChooser_PublishDate.setEnabled(editable);
        jTextField_Title.setEditable(editable);
        jTextField_Price.setEditable(editable);
        jComboBox_Location.setEnabled(editable);
        jComboBox_Author.setEnabled(editable);
        jComboBox_Publisher.setEnabled(editable);
        jComboBox_Category.setEnabled(editable);
        jSpinner_Add.setEnabled(editable);
    }
    
    private void jButton_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AddActionPerformed
        // TODO add your handling code here:
        clearAll();
        jTextField_ID.setText("...");
        mode = Mode.ADD;
        UIController.showCardLayout("cardSecond", jPanel_Card);
        setEditableForAll(true);
    }//GEN-LAST:event_jButton_AddActionPerformed

    private void jButton_ModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ModifyActionPerformed
        // TODO add your handling code here:
        mode = Mode.MODIFY;
        UIController.showCardLayout("cardSecond", jPanel_Card);
        setEditableForAll(true);
    }//GEN-LAST:event_jButton_ModifyActionPerformed

    private void jButton_RemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RemoveActionPerformed
        // TODO add your handling code here:
        jButton_Modify.setEnabled(false);
        jButton_Remove.setEnabled(false);
    }//GEN-LAST:event_jButton_RemoveActionPerformed

    private void jButton_OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_OKActionPerformed
        // TODO add your handling code here:
        if (mode == Mode.ADD) {

        } else if (mode == Mode.MODIFY) {

        }
        UIController.showCardLayout("cardFirst", jPanel_Card);
    }//GEN-LAST:event_jButton_OKActionPerformed

    private void jButton_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CancelActionPerformed
        // TODO add your handling code here:
        mode = Mode.FREE;
        clearAll();
        setEditableForAll(false);
        if (jTable_Book.getSelectedRow() != -1) {
        } else {
            jButton_Modify.setEnabled(false);
            jButton_Remove.setEnabled(false);
        }
        UIController.showCardLayout("cardFirst", jPanel_Card);
    }//GEN-LAST:event_jButton_CancelActionPerformed

    private void jButton_ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ClearActionPerformed
        // TODO add your handling code here:
        clearAll();
    }//GEN-LAST:event_jButton_ClearActionPerformed

    private void jButton_LocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LocationActionPerformed
        // TODO add your handling code here:
        this.newLocationDialog = new NewLocationDialog(null, true, this);
        this.newLocationDialog.setVisible(true);
    }//GEN-LAST:event_jButton_LocationActionPerformed

    private void jButton_AuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AuthorActionPerformed
        // TODO add your handling code here:
        this.newAuthorDialog = new NewAuthorDialog(null, true, this);
        this.newAuthorDialog.setVisible(true);
    }//GEN-LAST:event_jButton_AuthorActionPerformed

    private void jButton_PublisherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_PublisherActionPerformed
        // TODO add your handling code here:
        this.newPublisherDialog = new NewPublisherDialog(null, true, this);
        this.newPublisherDialog.setVisible(true);
    }//GEN-LAST:event_jButton_PublisherActionPerformed

    private void jButton_CategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CategoryActionPerformed
        // TODO add your handling code here:
        this.newCategoryDialog = new NewCategoryDialog(null, true, this);
        this.newCategoryDialog.setVisible(true);
    }//GEN-LAST:event_jButton_CategoryActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Add;
    private javax.swing.JButton jButton_Author;
    private javax.swing.JButton jButton_Cancel;
    private javax.swing.JButton jButton_Category;
    private javax.swing.JButton jButton_Clear;
    private javax.swing.JButton jButton_ClearSearch;
    private javax.swing.JButton jButton_Location;
    private javax.swing.JButton jButton_Modify;
    private javax.swing.JButton jButton_OK;
    private javax.swing.JButton jButton_Publisher;
    private javax.swing.JButton jButton_Remove;
    private javax.swing.JComboBox<String> jComboBox_Author;
    private javax.swing.JComboBox<String> jComboBox_Category;
    private javax.swing.JComboBox<String> jComboBox_Location;
    private javax.swing.JComboBox<String> jComboBox_Publisher;
    private com.toedter.calendar.JDateChooser jDateChooser_PublishDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel_Card;
    private javax.swing.JPanel jPanel_Card1;
    private javax.swing.JPanel jPanel_Card2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner_Add;
    private javax.swing.JTable jTable_Book;
    private javax.swing.JTextField jTextField_ID;
    private javax.swing.JTextField jTextField_Price;
    private javax.swing.JTextField jTextField_Title;
    private javax.swing.JTextField jTextField_TitleSearch;
    // End of variables declaration//GEN-END:variables
}