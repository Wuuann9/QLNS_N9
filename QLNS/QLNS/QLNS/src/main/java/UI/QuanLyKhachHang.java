package UI;

import Connect.KhachHang_Connect;
import Model.KhachHang;
import Model.KhachHang;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;//Hien thi hop thoai thong bao 
import javax.swing.table.DefaultTableModel;


public class QuanLyKhachHang extends javax.swing.JFrame {
private DefaultTableModel dtmKH;
private ArrayList<KhachHang> khachHangs = null;
private ArrayList<KhachHang> dskh_tim = null;

    public QuanLyKhachHang() {
        initComponents();//Khoi tao cac thanh phan GUI
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("images/books_30px.png")); 
        this.setTitle("Quản lý khách hàng");
        this.setLocationRelativeTo(null);//Can giua man hinh 
        hienThiTatCaKH();
    }
    
    private void hienThiTatCaKH(){
        KhachHang_Connect kh_conn = new KhachHang_Connect();
        khachHangs = kh_conn.LayTatCaKhachHang();
        dtmKH = new DefaultTableModel();
        //Them cac cot vao model 
        dtmKH.addColumn("Mã khách hàng");
        dtmKH.addColumn("Tên khách hàng");
        dtmKH.addColumn("Số điện thoại");
        dtmKH.addColumn("Điểm tích lũy");
        dtmKH.setRowCount(0);
        for(KhachHang kh : khachHangs){
            Vector<Object> vec = new Vector<Object>();
            vec.add(kh.getMaKH());
            vec.add(kh.getTenKH());
            vec.add(kh.getSdt());
            vec.add(formatCurrency(kh.getDiem()));
            dtmKH.addRow(vec);
        }
        KHTable.setModel(dtmKH);
    }
    
    private void ResetForm(){
        MaKHInput.setText("");
        TenKHInput.setText("");
        SdtInput.setText("");
        DiemInput.setText("");
    }
    
    private void xuLyThemMoi(String maKH)throws ParseException{
        KhachHang kh = new KhachHang();
        kh.setMaKH(MaKHInput.getText());
        kh.setTenKH(TenKHInput.getText());
        kh.setSdt(SdtInput.getText());
        kh.setDiem(Double.parseDouble(DiemInput.getText()));
        KhachHang_Connect kh_conn = new KhachHang_Connect();
        if(kh_conn.kiemTraTonTai(maKH)==true) JOptionPane.showMessageDialog(null, "Mã khách hàng này đã tồn tại!");
        else{
            int activeLuu = kh_conn.themKhachHang(kh);
            if(activeLuu>0){
                JOptionPane.showMessageDialog(null, "Thêm mới thành công!");
                hienThiTatCaKH();
            }
            else JOptionPane.showMessageDialog(null, "Thêm mới thất bại!");
        } 
    }
    
    //hàm định dạng điểm
    public String formatCurrency(double amount) {
        // Định dạng số có dấu phân cách và đơn vị tiền tệ
        DecimalFormat formatter = new DecimalFormat("#,###");
        String formattedAmount = formatter.format(amount);

        return formattedAmount;
    }
    
    //hàm loại bỏ dấu phẩy và chữ đ trong tiền tệ
    public String removeCurrencyFormatting(String formattedAmount) {
        // Loại bỏ các ký tự không phải số và dấu phân cách
        String amountWithoutFormatting = formattedAmount.replace(",", "");

        return amountWithoutFormatting;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TKKHLabel = new javax.swing.JLabel();
        TKKHInput = new javax.swing.JTextField();
        TKBtn = new javax.swing.JButton();
        AllKHBtn1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        MaKHLabel = new javax.swing.JLabel();
        MaKHInput = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        TenKHLabel = new javax.swing.JLabel();
        TenKHInput = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        SdtLabel = new javax.swing.JLabel();
        SdtInput = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        DiemLabel = new javax.swing.JLabel();
        DiemInput = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        UpdateBtn = new javax.swing.JButton();
        AddBtn = new javax.swing.JButton();
        ResetBtn = new javax.swing.JButton();
        DeleteBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        KHTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(255, 0, 0))); // NOI18N

        TKKHLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TKKHLabel.setText("Nhập tên hoặc mã khách hàng");

        TKKHInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TKKHInputKeyPressed(evt);
            }
        });

        TKBtn.setText("Tìm kiếm");
        TKBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TKBtnMouseClicked(evt);
            }
        });

        AllKHBtn1.setText("Tất cả");
        AllKHBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AllKHBtn1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TKKHInput)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TKKHLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TKBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                        .addComponent(AllKHBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(TKKHLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TKKHInput, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TKBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AllKHBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(255, 0, 0))); // NOI18N

        MaKHLabel.setText("Mã khách hàng");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MaKHLabel)
                .addGap(18, 18, 18)
                .addComponent(MaKHInput, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MaKHLabel)
                    .addComponent(MaKHInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TenKHLabel.setText("Tên khách hàng");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TenKHLabel)
                .addGap(18, 18, 18)
                .addComponent(TenKHInput, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TenKHLabel)
                    .addComponent(TenKHInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        SdtLabel.setText("Số điện thoại");

        SdtInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SdtInputKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SdtLabel)
                .addGap(18, 18, 18)
                .addComponent(SdtInput, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SdtLabel)
                    .addComponent(SdtInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        DiemLabel.setText("Điểm tích lũy");

        DiemInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                DiemInputKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DiemLabel)
                .addGap(18, 18, 18)
                .addComponent(DiemInput)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DiemLabel)
                    .addComponent(DiemInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        UpdateBtn.setText("Cập nhật");
        UpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBtnActionPerformed(evt);
            }
        });

        AddBtn.setText("Thêm");
        AddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ResetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ResetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        KHTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KHTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(KHTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBtnActionPerformed
        int ret=JOptionPane.showConfirmDialog(null, "Bạn muốn cập nhật khách hàng này?", "xác nhận xác nhận để cập nhật", JOptionPane.OK_CANCEL_OPTION);
        if(ret==JOptionPane.OK_OPTION){
            if(MaKHInput.getText().equals("") || TenKHInput.getText().equals("") || SdtInput.getText().equals("") || DiemInput.getText().equals(""))
                JOptionPane.showMessageDialog(null, "Dữ liệu còn thiếu");
            else {
                KhachHang_Connect kh_conn = new KhachHang_Connect();
                KhachHang kh = new KhachHang();
                kh.setMaKH(MaKHInput.getText());
                
                kh.setTenKH(TenKHInput.getText());
                kh.setSdt(SdtInput.getText());
                kh.setDiem(Double.parseDouble(DiemInput.getText()));
                
                int activeUpdate = kh_conn.updateKhachHang(kh);
                if(activeUpdate>0){
                    JOptionPane.showMessageDialog(null, "Chỉnh sửa thành công!");
                    hienThiTatCaKH();
                }
                else JOptionPane.showMessageDialog(null, "Chỉnh sửa thất bại!"); 
            }
        }
    }//GEN-LAST:event_UpdateBtnActionPerformed

    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed
        int ret=JOptionPane.showConfirmDialog(null, "Bạn muốn thêm khách hàng này?", "xác nhận xác nhận để thêm", JOptionPane.OK_CANCEL_OPTION);
        if(ret==JOptionPane.OK_OPTION){
            if(MaKHInput.getText().equals("") || TenKHInput.getText().equals("") || SdtInput.getText().equals("") || DiemInput.getText().equals(""))
                JOptionPane.showMessageDialog(null, "Dữ liệu còn thiếu");
            else {
                String maKH = MaKHInput.getText();				
                try {
                    xuLyThemMoi(maKH);
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_AddBtnActionPerformed

    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
        int ret=JOptionPane.showConfirmDialog(null, "Bạn muốn xóa khách hàng này?", "xác nhận xác nhận để xóa", JOptionPane.OK_CANCEL_OPTION);
        if(ret==JOptionPane.OK_OPTION){
            if(MaKHInput.getText().equals(""))
                JOptionPane.showMessageDialog(null, "Dữ liệu còn thiếu");
            else {
                String makh = MaKHInput.getText();
                KhachHang_Connect nv_conn = new KhachHang_Connect();
                int active = nv_conn.xoaKhachHang(makh);
                if(active>0){
                        JOptionPane.showMessageDialog(null, "Xóa thành công!");
                        hienThiTatCaKH();
                }
                else JOptionPane.showMessageDialog(null, "Xóa thất bại!");
            }
        }
    }//GEN-LAST:event_DeleteBtnActionPerformed

    private void ResetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBtnActionPerformed
        ResetForm();
    }//GEN-LAST:event_ResetBtnActionPerformed

    private void TKBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TKBtnMouseClicked
        if(TKKHInput.getText()==null ) return ;
        String key = TKKHInput.getText();
        KhachHang_Connect nv_conn = new KhachHang_Connect();
        dskh_tim = nv_conn.timKhachHang(key);
        dtmKH.setRowCount(0);
        for(KhachHang kh : dskh_tim){
            Vector<Object> vec = new Vector<Object>();
            vec.add(kh.getMaKH());
            vec.add(kh.getTenKH());
            vec.add(kh.getSdt());
            vec.add(String.format("%.0f", kh.getDiem()));
            dtmKH.addRow(vec);
        }
	KHTable.setModel(dtmKH);
    }//GEN-LAST:event_TKBtnMouseClicked

    private void AllKHBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AllKHBtn1MouseClicked
        hienThiTatCaKH();
        TKKHInput.setText("");
    }//GEN-LAST:event_AllKHBtn1MouseClicked

    private void KHTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KHTableMouseClicked
        int select = KHTable.getSelectedRow();
        MaKHInput.setText(KHTable.getValueAt(select, 0)+"");
        TenKHInput.setText(KHTable.getValueAt(select, 1)+"");
        SdtInput.setText(KHTable.getValueAt(select, 2)+"");
        DiemInput.setText(removeCurrencyFormatting(KHTable.getValueAt(select, 3)+""));
    }//GEN-LAST:event_KHTableMouseClicked

    private void SdtInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SdtInputKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || SdtInput.getText().length() >= 10) {
            evt.consume(); // Ngăn chặn ký tự không hợp lệ và ngăn chặn nhập quá 4 ký tự
        }
    }//GEN-LAST:event_SdtInputKeyTyped

    private void DiemInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DiemInputKeyTyped
        //kiểm tra xem người dùng có nhập số vào không, nếu không phải số thì không nhận
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9') ||
            (c == KeyEvent.VK_BACK_SPACE) ||
            (c == KeyEvent.VK_DELETE))) {
        getToolkit().beep();
        evt.consume();
      }
    }//GEN-LAST:event_DiemInputKeyTyped

    private void TKKHInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TKKHInputKeyPressed
        if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) TKBtnMouseClicked(null);
    }//GEN-LAST:event_TKKHInputKeyPressed

    
    public void showWindow() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLyKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyKhachHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JButton AllKHBtn1;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JTextField DiemInput;
    private javax.swing.JLabel DiemLabel;
    private javax.swing.JTable KHTable;
    private javax.swing.JTextField MaKHInput;
    private javax.swing.JLabel MaKHLabel;
    private javax.swing.JButton ResetBtn;
    private javax.swing.JTextField SdtInput;
    private javax.swing.JLabel SdtLabel;
    private javax.swing.JButton TKBtn;
    private javax.swing.JTextField TKKHInput;
    private javax.swing.JLabel TKKHLabel;
    private javax.swing.JTextField TenKHInput;
    private javax.swing.JLabel TenKHLabel;
    private javax.swing.JButton UpdateBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
