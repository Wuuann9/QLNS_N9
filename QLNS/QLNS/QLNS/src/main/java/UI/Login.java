
package UI;

import Connect.login_sql;
import Model.TaiKhoan;
import java.awt.Font;
import java.awt.Toolkit; // truy cap chuc nang hdh 
import javax.swing.JOptionPane; 

//tao 1 constructor hien thi interface 
public class Login extends javax.swing.JFrame {

    
    public Login(String title) {
        this.setTitle(title);
        this.setLocationRelativeTo(null); // can giua
        initComponents(); 
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("images/books_30px.png"));
    }

    
    @SuppressWarnings("unchecked") // tat canh bao ep kieu du lieu
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LoginLabel = new javax.swing.JLabel();
        LoginLabel.setFont(new Font("Arial", Font.BOLD, 20));
        TKInput = new javax.swing.JTextField();
        TKLabel = new javax.swing.JLabel();
        MKLabel = new javax.swing.JLabel();
        LoginBtn = new javax.swing.JButton();
        MKInput = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        LoginLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LoginLabel.setForeground(new java.awt.Color(51, 51, 255));
        LoginLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LoginLabel.setText("Đăng nhập");
        LoginLabel.setMaximumSize(new java.awt.Dimension(90, 48));
        LoginLabel.setName(""); // NOI18N

        TKInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TKInputActionPerformed(evt);
            }
        });
        TKInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TKInputKeyPressed(evt);
            }
        });

        TKLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TKLabel.setText("Tài khoản");

        MKLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        MKLabel.setText("Mật khẩu");

        LoginBtn.setText("Đăng nhập");
        LoginBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginBtnMouseClicked(evt);
            }
        });

        MKInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                MKInputKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LoginLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TKLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MKLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TKInput, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                            .addComponent(MKInput))
                        .addGap(52, 52, 52))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(LoginLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TKInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TKLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MKLabel)
                    .addComponent(MKInput, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(LoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // kiem tra tai khoan mat khau da nhap chua khi click dang nhap
    private void LoginBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginBtnMouseClicked
        if(TKInput.getText()==null || MKInput.getText()==null) 
            return ;
            xuLyDangNhap();
    }//GEN-LAST:event_LoginBtnMouseClicked

    // xu ly khi nhan enter tai o TKInput
    private void TKInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TKInputKeyPressed
        if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER){ // neu nhan enter thi tra ve true thuc hien cau lenh tiep theo
            if(TKInput.getText()==null || MKInput.getText()==null) return ;
            xuLyDangNhap();
        }
    }//GEN-LAST:event_TKInputKeyPressed
// xu ly khi nhan enter tai o MKinput
    private void MKInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MKInputKeyPressed
        if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER){  
            if(TKInput.getText()==null || MKInput.getText()==null) return ;
            xuLyDangNhap();
        }
    }//GEN-LAST:event_MKInputKeyPressed

    private void TKInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TKInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TKInputActionPerformed
  
    // kiem tra MKinput va TKinput  với TK MK cua CSDl
    protected void xuLyDangNhap() {
        login_sql login = new login_sql(); // tao 1 doi tuong cua sql de kiem tra 
        TaiKhoan active = login.login(TKInput.getText(), MKInput.getText()); // truyen du lieu vao phuong thuc login va thuc hien kiem tra với csdl
        if(active == null){
            JOptionPane.showMessageDialog(null, "Đăng nhập thất bại ");
        }
        else{
            dispose();	// dong cua so dang nhap 
            BanHang ui = new BanHang("Bán hàng",active.getMaNV()); // tao 1 giao dien ban hang va truy vet nguoc tu MaNV xac dinh quyen cua tk
            ui.showWindow(); // hien thi trang ban hang
        }	
    }
   
    public void showWindow() {
        
        // cai nimbus làm giao dien ung dung 
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {  // dam bao chay dung va khong bi treo (xếp vào hàng đợi và chạy trên luồng GUI)
            public void run() {
                new Login("Đăng nhập").setVisible(true); // tao 1 jframe login moi va hien thi dang nhap  
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoginBtn;
    private javax.swing.JLabel LoginLabel;
    private javax.swing.JPasswordField MKInput;
    private javax.swing.JLabel MKLabel;
    private javax.swing.JTextField TKInput;
    private javax.swing.JLabel TKLabel;
    // End of variables declaration//GEN-END:variables
}
