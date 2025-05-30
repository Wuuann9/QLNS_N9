
package UI;

import Connect.NXB_Connect;
import Model.NXB;
import java.awt.Toolkit;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class QuanLyNXB extends javax.swing.JFrame {

    private DefaultTableModel dtmNXB;
    private ArrayList<NXB> dsnxbs = null;
    private ArrayList<NXB> dsnxb_tim = null;

    public QuanLyNXB(String title) {
        initComponents();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("images/books_30px.png"));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Quản lý nhà xuất bản");
        hienThiToanBoNhaXuatBan();
    }

    private void hienThiToanBoNhaXuatBan() {
        NXB_Connect nxb_conn = new NXB_Connect();
        dsnxbs = nxb_conn.layToanBoNhaXuatBan();
        dtmNXB = new DefaultTableModel();
        dtmNXB.addColumn("Mã nhà xuất bản");
        dtmNXB.addColumn("Tên nhà xuất bản");
        dtmNXB.addColumn("Số điện thoại");
        dtmNXB.addColumn("Địa chỉ");
        dtmNXB.addColumn("Email");
        dsnxbs = nxb_conn.layToanBoNhaXuatBan();
        dtmNXB.setRowCount(0);
        for (NXB nxb : dsnxbs) {
            Vector<Object> vec = new Vector<Object>();
            vec.add(nxb.getMaNXB());
            vec.add(nxb.getTenNXB());
            vec.add(nxb.getSDT());
            vec.add(nxb.getDiaChi());
            vec.add(nxb.getEmail());
            dtmNXB.addRow(vec);
        }
        NXBTable.setModel(dtmNXB);
    }

    //hàm check email
    public boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        NXBTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        MaNVLabel = new javax.swing.JLabel();
        MaNXBInput = new javax.swing.JTextField();
        TenNVLabel = new javax.swing.JLabel();
        TenNXBInput = new javax.swing.JTextField();
        SDTLabel = new javax.swing.JLabel();
        SDTInput = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        CCCDLabel = new javax.swing.JLabel();
        DiachiInput = new javax.swing.JTextField();
        EmailLabel = new javax.swing.JLabel();
        EmailInput = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        AddBtn = new javax.swing.JButton();
        UpdateBtn = new javax.swing.JButton();
        ResetBtn = new javax.swing.JButton();
        DeleteBtn = new javax.swing.JButton();
        TimNhanVienLabel = new javax.swing.JLabel();
        ThongTinNhanVienLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        TKNXBBtn = new javax.swing.JButton();
        AllNXBBtn = new javax.swing.JButton();
        TimKiemInput = new javax.swing.JTextField();
        NhanTenLabel = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        NXBTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NXBTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(NXBTable);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        MaNVLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        MaNVLabel.setText("Mã nhà xuất bản");

        TenNVLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TenNVLabel.setText("Tên nhà xuất bản");

        SDTLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SDTLabel.setText("Số điện thoại");

        SDTInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SDTInputKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(SDTLabel)
                            .addGap(34, 34, 34))
                        .addComponent(TenNVLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(MaNVLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(MaNXBInput, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                    .addComponent(TenNXBInput)
                    .addComponent(SDTInput))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MaNVLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MaNXBInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TenNVLabel)
                    .addComponent(TenNXBInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SDTLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SDTInput, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        CCCDLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CCCDLabel.setText("Địa chỉ");

        DiachiInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiachiInputActionPerformed(evt);
            }
        });

        EmailLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        EmailLabel.setText("Email");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CCCDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(EmailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DiachiInput, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                    .addComponent(EmailInput))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CCCDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DiachiInput, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EmailInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EmailLabel))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        AddBtn.setText("Thêm");
        AddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnActionPerformed(evt);
            }
        });

        UpdateBtn.setText("Cập nhật");
        UpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBtnActionPerformed(evt);
            }
        });

        ResetBtn.setText("Nhập lại");
        ResetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBtnActionPerformed(evt);
            }
        });

        DeleteBtn.setText("Xóa");
        DeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(UpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ResetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ResetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        TimNhanVienLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        TimNhanVienLabel.setForeground(new java.awt.Color(255, 0, 0));
        TimNhanVienLabel.setText("Tìm nhà xuất bản");

        ThongTinNhanVienLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ThongTinNhanVienLabel.setForeground(new java.awt.Color(255, 0, 0));
        ThongTinNhanVienLabel.setText("Thông tin nhà xuất bản");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        TKNXBBtn.setText("Tìm kiếm");
        TKNXBBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TKNXBBtnActionPerformed(evt);
            }
        });

        AllNXBBtn.setText("Tất cả");
        AllNXBBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AllNXBBtnActionPerformed(evt);
            }
        });

        TimKiemInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimKiemInputActionPerformed(evt);
            }
        });
        TimKiemInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TimKiemInputKeyPressed(evt);
            }
        });

        NhanTenLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        NhanTenLabel.setText("Nhập tên hoặc mã nhà xuất bản");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TimKiemInput)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(NhanTenLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(TKNXBBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AllNXBBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(NhanTenLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TimKiemInput, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TKNXBBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AllNXBBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TimNhanVienLabel)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ThongTinNhanVienLabel)
                        .addGap(561, 572, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ThongTinNhanVienLabel)
                    .addComponent(TimNhanVienLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NXBTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NXBTableMouseClicked
        int select = NXBTable.getSelectedRow();
        NXB_Connect nxbconn = new NXB_Connect();
        MaNXBInput.setText(NXBTable.getValueAt(select, 0) + "");
        TenNXBInput.setText(NXBTable.getValueAt(select, 1) + "");
        DiachiInput.setText(NXBTable.getValueAt(select, 3) + "");
        //CVInput.setSelectedItem(cvconn.TimChucVu(NVTable.getValueAt(select, 5).toString()));
        SDTInput.setText(NXBTable.getValueAt(select, 2) + "");
        EmailInput.setText(NXBTable.getValueAt(select, 4) + "");

    }//GEN-LAST:event_NXBTableMouseClicked

    private void TKNXBBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TKNXBBtnActionPerformed
        if (TimKiemInput.getText() == null) {
            return;
        }
        String key = TimKiemInput.getText();
        NXB_Connect nxbconn = new NXB_Connect();
        dsnxb_tim = nxbconn.TimTenNXBmacdinh(key);
        dtmNXB.setRowCount(0);
        for (NXB nxb : dsnxb_tim) {
            Vector<Object> vec = new Vector<Object>();
            vec.add(nxb.getMaNXB());
            vec.add(nxb.getTenNXB());
            vec.add(nxb.getSDT());
            vec.add(nxb.getDiaChi());
            vec.add(nxb.getEmail());
            dtmNXB.addRow(vec);
        }
        NXBTable.setModel(dtmNXB);
    }//GEN-LAST:event_TKNXBBtnActionPerformed

    private void AllNXBBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AllNXBBtnActionPerformed
        hienThiToanBoNhaXuatBan();
    }//GEN-LAST:event_AllNXBBtnActionPerformed

    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
        String manxb = MaNXBInput.getText();
        NXB_Connect nxb_conn = new NXB_Connect();
        int ret = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa?", "Xác nhận xóa", JOptionPane.OK_CANCEL_OPTION);
        if (ret == JOptionPane.OK_OPTION) {
            int active = nxb_conn.XoaNXB(manxb);
            if (active > 0) {
                JOptionPane.showMessageDialog(null, "Xóa thành công!");
                hienThiToanBoNhaXuatBan();
            } else {
                JOptionPane.showMessageDialog(null, "Xóa thất bại!");
            }
        }
    }//GEN-LAST:event_DeleteBtnActionPerformed

    private void ResetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBtnActionPerformed
        MaNXBInput.setText("");
        TenNXBInput.setText("");
        DiachiInput.setText("");
        SDTInput.setText("");
        EmailInput.setText("");
    }//GEN-LAST:event_ResetBtnActionPerformed

    private void UpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBtnActionPerformed
        NXB_Connect nv_conn = new NXB_Connect();
        NXB nxb = new NXB();
        nxb.setMaNXB(MaNXBInput.getText());
        nxb.setTenNXB(TenNXBInput.getText());
        nxb.setSDT(SDTInput.getText());
        nxb.setDiaChi(DiachiInput.getText());
        nxb.setEmail(EmailInput.getText());
        int ret = JOptionPane.showConfirmDialog(null, "Bạn muốn chỉnh sửa nhà xuất bản?", "xác nhận chỉnh sửa", JOptionPane.OK_CANCEL_OPTION);
        if (ret == JOptionPane.OK_OPTION) {
            if (!isValidEmail(EmailInput.getText())) {
                JOptionPane.showMessageDialog(null, "Email không đúng định dạng!");
                return;
            }
            int activeUpdate = nv_conn.updateNXB(nxb);
            if (activeUpdate > 0) {
                JOptionPane.showMessageDialog(null, "Chỉnh sửa thành công!");
                hienThiToanBoNhaXuatBan();
            }
        }
    }//GEN-LAST:event_UpdateBtnActionPerformed
    private void xuLyThemMoi(String maNXB) throws ParseException {
        NXB nxb = new NXB();
        nxb.setMaNXB(MaNXBInput.getText());
        nxb.setTenNXB(TenNXBInput.getText());
        nxb.setSDT(SDTInput.getText());
        nxb.setEmail(EmailInput.getText());
        nxb.setDiaChi(DiachiInput.getText());
        NXB_Connect nxb_conn = new NXB_Connect();
        if (nxb_conn.kiemTraTonTai(maNXB) == true) {
            JOptionPane.showMessageDialog(null, "Mã nhà xuất bản này đã tồn tại!");
        } else {
            int activeLuu = nxb_conn.ThemMoiNXB(nxb);
            if (activeLuu > 0) {
                JOptionPane.showMessageDialog(null, "Thêm mới thành công!");
                hienThiToanBoNhaXuatBan();
            } else {
                JOptionPane.showMessageDialog(null, "Thêm mới thất bại!");
            }
        }
    }
    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed
        int ret = JOptionPane.showConfirmDialog(null, "Bạn muốn thêm nhà xuất bản này?", "xác nhận xác nhận để thêm", JOptionPane.OK_CANCEL_OPTION);
        if (ret == JOptionPane.OK_OPTION) {
            if (MaNXBInput.getText().equals("") || TenNXBInput.getText().equals("") || SDTInput.getText().equals("") || DiachiInput.getText().equals("") || EmailInput.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Dữ liệu còn thiếu");
            } else {
                if (!isValidEmail(EmailInput.getText())) {
                    JOptionPane.showMessageDialog(null, "Email không đúng định dạng!");
                    return;
                }
                String maNXB = MaNXBInput.getText();
                try {
                    xuLyThemMoi(maNXB);
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_AddBtnActionPerformed

    private void TimKiemInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimKiemInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TimKiemInputActionPerformed

    private void DiachiInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiachiInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DiachiInputActionPerformed

    private void SDTInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SDTInputKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || SDTInput.getText().length() >= 10) {
            evt.consume(); // Ngăn chặn ký tự không hợp lệ và ngăn chặn nhập quá 4 ký tự
        }
    }//GEN-LAST:event_SDTInputKeyTyped

    private void TimKiemInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TimKiemInputKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER)
            TKNXBBtnActionPerformed(null);
    }//GEN-LAST:event_TimKiemInputKeyPressed

    
    public void showWindow() {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(QuanLyNXB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyNXB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyNXB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyNXB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyNXB("Quản lý nhà xuất bản").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JButton AllNXBBtn;
    private javax.swing.JLabel CCCDLabel;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JTextField DiachiInput;
    private javax.swing.JTextField EmailInput;
    private javax.swing.JLabel EmailLabel;
    private javax.swing.JLabel MaNVLabel;
    private javax.swing.JTextField MaNXBInput;
    private javax.swing.JTable NXBTable;
    private javax.swing.JLabel NhanTenLabel;
    private javax.swing.JButton ResetBtn;
    private javax.swing.JTextField SDTInput;
    private javax.swing.JLabel SDTLabel;
    private javax.swing.JButton TKNXBBtn;
    private javax.swing.JLabel TenNVLabel;
    private javax.swing.JTextField TenNXBInput;
    private javax.swing.JLabel ThongTinNhanVienLabel;
    private javax.swing.JTextField TimKiemInput;
    private javax.swing.JLabel TimNhanVienLabel;
    private javax.swing.JButton UpdateBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
