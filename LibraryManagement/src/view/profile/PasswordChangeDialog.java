/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.profile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.database.Connect;
import org.mindrot.bcrypt.BCrypt;
import static view.login.ConfirmDialog.hash;
import view.login.LoginFrame;
import static view.login.LoginFrame.verifyHash;
import view.main.librarian.ReaderPanel;

/**
 *
 * @author Admin
 */
public class PasswordChangeDialog extends javax.swing.JDialog {

    private boolean showPassOld = false;
    private boolean showPassNew = false;
    private boolean showPassVerify = false;

    /**
     * Creates new form PasswordChangeDialog
     *
     * @param parent
     * @param modal
     * @param parentPanel
     */
    public PasswordChangeDialog(java.awt.Frame parent, boolean modal, JPanel parentPanel) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
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
        jPanel2 = new javax.swing.JPanel();
        jButton_Update = new javax.swing.JButton();
        jButton_Cancel = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel_Old = new javax.swing.JLabel();
        jLabel_New = new javax.swing.JLabel();
        jLabel_Verify = new javax.swing.JLabel();
        jPasswordField_Old = new javax.swing.JPasswordField();
        jPasswordField_New = new javax.swing.JPasswordField();
        jPasswordField_Verify = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Change your password");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Change your password");
        jLabel1.setPreferredSize(new java.awt.Dimension(214, 50));
        jPanel1.add(jLabel1, java.awt.BorderLayout.NORTH);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 60));

        jButton_Update.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_Update.setText("Update password");
        jButton_Update.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_UpdateActionPerformed(evt);
            }
        });

        jButton_Cancel.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_Cancel.setText("Cancel");
        jButton_Cancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Cancel.setPreferredSize(new java.awt.Dimension(155, 29));
        jButton_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jButton_Update)
                .addGap(18, 18, 18)
                .addComponent(jButton_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_Update, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(jButton_Cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.SOUTH);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel2.setText("Old password ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel3.setText("New password");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel4.setText("Verify new password");

        jLabel_Old.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hide.png"))); // NOI18N
        jLabel_Old.setRequestFocusEnabled(false);
        jLabel_Old.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_OldMouseClicked(evt);
            }
        });

        jLabel_New.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hide.png"))); // NOI18N
        jLabel_New.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_NewMouseClicked(evt);
            }
        });

        jLabel_Verify.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hide.png"))); // NOI18N
        jLabel_Verify.setToolTipText("");
        jLabel_Verify.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_VerifyMouseClicked(evt);
            }
        });

        jPasswordField_Old.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        jPasswordField_New.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        jPasswordField_Verify.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jPasswordField_Old)
                    .addComponent(jPasswordField_New)
                    .addComponent(jPasswordField_Verify, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_Old)
                    .addComponent(jLabel_New)
                    .addComponent(jLabel_Verify))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_Old)
                    .addComponent(jPasswordField_Old, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_New)
                    .addComponent(jPasswordField_New, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_Verify)
                    .addComponent(jPasswordField_Verify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

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

    private void jButton_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton_CancelActionPerformed

    private void jLabel_OldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_OldMouseClicked
        // TODO add your handling code here:
        if (showPassOld) {
            showPassOld = false;
            jLabel_Old.setIcon(new ImageIcon(getClass().getResource("/img/hide.png")));
            jPasswordField_Old.setEchoChar('*');
        } else {
            showPassOld = true;
            jLabel_Old.setIcon(new ImageIcon(getClass().getResource("/img/show.png")));
            jPasswordField_Old.setEchoChar('\u0000');
        }
    }//GEN-LAST:event_jLabel_OldMouseClicked

    private void jLabel_NewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_NewMouseClicked
        // TODO add your handling code here:
        if (showPassNew) {
            showPassNew = false;
            jLabel_New.setIcon(new ImageIcon(getClass().getResource("/img/hide.png")));
            jPasswordField_New.setEchoChar('*');
        } else {
            showPassNew = true;
            jLabel_New.setIcon(new ImageIcon(getClass().getResource("/img/show.png")));
            jPasswordField_New.setEchoChar('\u0000');
        }
    }//GEN-LAST:event_jLabel_NewMouseClicked

    private void jLabel_VerifyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_VerifyMouseClicked
        // TODO add your handling code here:
        if (showPassVerify) {
            showPassVerify = false;
            jLabel_Verify.setIcon(new ImageIcon(getClass().getResource("/img/hide.png")));
            jPasswordField_Verify.setEchoChar('*');
        } else {
            showPassVerify = true;
            jLabel_Verify.setIcon(new ImageIcon(getClass().getResource("/img/show.png")));
            jPasswordField_Verify.setEchoChar('\u0000');
        }
    }//GEN-LAST:event_jLabel_VerifyMouseClicked

    private void jButton_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_UpdateActionPerformed
        // TODO add your handling code here:
        String pwdOld = new String(jPasswordField_Old.getPassword());
        String pwdNew = new String(jPasswordField_New.getPassword());
        String pwdVerify = new String(jPasswordField_Verify.getPassword());
        if(pwdOld.equalsIgnoreCase("") || pwdNew.equalsIgnoreCase("") || pwdVerify.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Không được để trống password. Vui lòng nhập lại!", "Thông báo", JOptionPane.ERROR_MESSAGE);
             return;
        }
        String passwordConfirm = getPassword(view.login.LoginFrame.username);
        if(!verifyHash(pwdOld, passwordConfirm)){
            JOptionPane.showMessageDialog(null, "Sai mật khẩu. Vui lòng nhập lại!", "Thông báo", JOptionPane.ERROR_MESSAGE);
             return;
        }
        if(!pwdNew.equals(pwdVerify)){
            JOptionPane.showMessageDialog(null, "Mật khẩu mới và mật khẩu xác nhận không trùng nhau. Vui lòng nhập lại!", "Thông báo", JOptionPane.ERROR_MESSAGE);
             return;
        }
        
       
        Connection ketNoi =Connect.GetConnect();
        String sql = "update account\n" +
                        "SET password = ?\n" +
                        "where username = ?";

                PreparedStatement ps;
              try {
                  ps = ketNoi.prepareStatement(sql);
                  ps.setString(1, hash(pwdNew));
                  ps.setString(2, view.login.LoginFrame.username);
                  ps.executeUpdate();
              } catch (SQLException ex) {
                  Logger.getLogger(ReaderPanel.class.getName()).log(Level.SEVERE, null, ex);
              }
        JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công!");
        this.dispose();
    }//GEN-LAST:event_jButton_UpdateActionPerformed
     public static String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }

    public static boolean verifyHash(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }
    String getPassword(String username){
      
        Connection ketNoi= Connect.GetConnect();
        try {
            PreparedStatement ps=ketNoi.prepareStatement("select password from account where username = ?");
            ps.setString(1, username);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                return rs.getString(1);
            }
            ps.close();
            rs.close();
            ketNoi.close();
        } catch (SQLException ex) {
            System.out.println("loi lay phone and email");
        }
        return "";
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Cancel;
    private javax.swing.JButton jButton_Update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel_New;
    private javax.swing.JLabel jLabel_Old;
    private javax.swing.JLabel jLabel_Verify;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField_New;
    private javax.swing.JPasswordField jPasswordField_Old;
    private javax.swing.JPasswordField jPasswordField_Verify;
    // End of variables declaration//GEN-END:variables
}
