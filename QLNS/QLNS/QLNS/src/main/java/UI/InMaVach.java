
package UI;

import Connect.Sach_Connect;
import Connect.VanPhongPham_Connect;
import Model.Sach;
import Model.VPP;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.Barcode39;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;


public class InMaVach extends javax.swing.JFrame {
private DefaultTableModel dtmSach, dtmInSach, dtmSanPham, dtmInSanPham ;
private ArrayList<Sach> dss = null;
private ArrayList<VPP> dsvpp = null;

String filePath = "D:\\BTL_OOP\\QLNS\\QLNS\\Excel\\";
    /**
     * Creates new form InMaVach_UI
     */
    public InMaVach(String title) {
        initComponents();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("images/books_30px.png"));
        this.setTitle(title);
        this.setLocationRelativeTo(null);
        hienThiToanBoSach();
        hienThiToanBoSanPham();
        TaoBangMaVachSach();
        TaoBangMaVachSanPham();
    }
    
    private void hienThiToanBoSach() {
        Sach_Connect sachConn = new Sach_Connect();
        dss = sachConn.layToanBoSach();
        dtmSach = new DefaultTableModel();
        dtmSach.addColumn("Mã sách");
        dtmSach.addColumn("Tên Sách");
        dtmSach.addColumn("Số lượng"); // đây là số lượng sách trong kho
        dtmSach.addColumn("Giá Bán (VNĐ)");
        dtmSach.addColumn("Giảm Giá (%)");
        dtmSach.setRowCount(0);
        for (Sach s : dss){
            Vector<Object> vec = new Vector<Object>();
            vec.add(s.getMaSach());
            vec.add(s.getTenSach());
            vec.add(s.getSoLuong());
            vec.add(s.getGiaBan());
            vec.add(s.getDiscount());
            dtmSach.addRow(vec);	
        }
        SachTable.setModel(dtmSach);
    }
    
    private void hienThiToanBoSanPham() {
        VanPhongPham_Connect sachConn = new VanPhongPham_Connect();
        dsvpp = sachConn.layToanBoVPP();
        dtmSanPham = new DefaultTableModel();
        dtmSanPham.addColumn("Mã sản phẩm");
        dtmSanPham.addColumn("Tên sản phẩm");
        dtmSanPham.addColumn("Số lượng"); // đây là số lượng sản phẩm trong kho
        dtmSanPham.addColumn("Giá Bán (VNĐ)");
        dtmSanPham.addColumn("Giảm Giá (%)");
        dtmSanPham.setRowCount(0);
        for (VPP s : dsvpp){
            Vector<Object> vec = new Vector<Object>();
            vec.add(s.getMaVPP());
            vec.add(s.getTenVPP());
            vec.add(s.getSoLuong());
            vec.add(s.getGiaBan());
            vec.add(s.getDiscount());
            dtmSanPham.addRow(vec);	
        }
        SanphamTable.setModel(dtmSanPham);
    }
    
    private void TaoBangMaVachSach (){
        dtmInSach = new DefaultTableModel();
        dtmInSach.addColumn("Mã sách");
        dtmInSach.addColumn("Tên sách");
        dtmInSach.addColumn("Giá Bán");
        dtmInSach.addColumn("Số lượng"); // đây là số lượng mã vạch sẽ được in ra
        MaVachSachTable.setModel(dtmInSach);
    }
    
    private void TaoBangMaVachSanPham (){
        dtmInSanPham = new DefaultTableModel();
        dtmInSanPham.addColumn("Mã sản phẩm");
        dtmInSanPham.addColumn("Tên sản phẩm");
        dtmInSanPham.addColumn("Giá Bán");
        dtmInSanPham.addColumn("Số lượng"); // đây là số lượng mã vạch sẽ được in ra
        MaVachSanphamTable.setModel(dtmInSanPham);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TitleLabel = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        DSS_Label = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        SachTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        DMV_Label = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        MaVachSachTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        SLLabel = new javax.swing.JLabel();
        SLInput = new javax.swing.JSpinner();
        ThemButton = new javax.swing.JButton();
        GenerateBtn = new javax.swing.JButton();
        XoaButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        DSSP_Label = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        SanphamTable = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        DSSPMV_Label = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        MaVachSanphamTable = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        SLSPLabel = new javax.swing.JLabel();
        SLSPInput = new javax.swing.JSpinner();
        ThemSPButton = new javax.swing.JButton();
        GenerateSPBtn = new javax.swing.JButton();
        XoaSPButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        TitleLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TitleLabel.setForeground(new java.awt.Color(0, 0, 255));
        TitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitleLabel.setText("In Mã Vạch");

        DSS_Label.setText("Danh sách Sách");

        jScrollPane1.setViewportView(SachTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(DSS_Label)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DSS_Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        DMV_Label.setText("Danh sách Sách sẽ được in mã vạch");

        jScrollPane3.setViewportView(MaVachSachTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(DMV_Label)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DMV_Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        SLLabel.setText("Số lượng");

        SLInput.setModel(new SpinnerNumberModel(1, 1, 100, 1));
        JFormattedTextField textField = ((JSpinner.DefaultEditor) SLInput.getEditor()).getTextField();
        ((NumberFormatter) textField.getFormatter()).setAllowsInvalid(false); // Chỉ cho phép giá trị hợp lệ là số

        ThemButton.setText("Thêm");
        ThemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemButtonActionPerformed(evt);
            }
        });

        GenerateBtn.setText("Tạo");
        GenerateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerateBtnActionPerformed(evt);
            }
        });

        XoaButton.setText("Xóa");
        XoaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XoaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(SLLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SLInput, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ThemButton, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(GenerateBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(XoaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SLLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SLInput, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ThemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(XoaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(GenerateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
        );

        jTabbedPane1.addTab("Sách", jPanel2);

        DSSP_Label.setText("Danh sách Sản phẩm");

        jScrollPane2.setViewportView(SanphamTable);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DSSP_Label)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DSSP_Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        DSSPMV_Label.setText("Danh sách Sản phẩm sẽ được in mã vạch");

        jScrollPane4.setViewportView(MaVachSanphamTable);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(DSSPMV_Label)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DSSPMV_Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        SLSPLabel.setText("Số lượng");

        SLSPInput.setModel(new SpinnerNumberModel(1, 1, 100, 1));
        JFormattedTextField txtField = ((JSpinner.DefaultEditor) SLSPInput.getEditor()).getTextField();
        ((NumberFormatter) txtField.getFormatter()).setAllowsInvalid(false); // Chỉ cho phép giá trị hợp lệ là số

        ThemSPButton.setText("Thêm");
        ThemSPButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemSPButtonActionPerformed(evt);
            }
        });

        GenerateSPBtn.setText("Tạo");
        GenerateSPBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerateSPBtnActionPerformed(evt);
            }
        });

        XoaSPButton.setText("Xóa");
        XoaSPButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XoaSPButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(SLSPLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SLSPInput, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ThemSPButton, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(GenerateSPBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(XoaSPButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SLSPLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SLSPInput, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ThemSPButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(XoaSPButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(GenerateSPBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
        );

        jTabbedPane1.addTab("Văn phòng phẩm", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(TitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ThemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemButtonActionPerformed
        if ((SachTable.getSelectedRow()<0))
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn loại sách muốn in mã vạch");
//        nếu sách cần lấy có giá trị là 0 thì không cho lấy
        else if("0".equals(SachTable.getValueAt(SachTable.getSelectedRow(), SachTable.getSelectedColumn()).toString()) ){
            JOptionPane.showMessageDialog(null, "Sách bạn muốn chọn đã hết");
        }
        else {
            Vector<Object> vec = new Vector<Object>();
            int vitriSach = -1;
            //kiểm tra xem sách đang được chọn có nằm trong hóa đơn chưa
            for (int i=0;i<dtmInSach.getRowCount();i++) {
                if (dtmInSach.getValueAt(i, 0).equals(SachTable.getValueAt(SachTable.getSelectedRow(), 0))) vitriSach=i;
            }
            //nếu đã có trong hóa đơn thì cập nhật lại số lượng mã vạch
            if (vitriSach!=-1){
                dtmInSach.setValueAt(Integer.parseInt(SLInput.getValue().toString())+Integer.parseInt(dtmInSach.getValueAt(vitriSach, 3).toString()), vitriSach, 3);
            }
            //nếu chưa có thì tạo dòng mới
            else{                        
                vec.add(SachTable.getValueAt(SachTable.getSelectedRow(), 0));
                vec.add(SachTable.getValueAt(SachTable.getSelectedRow(), 1));
                vec.add(SachTable.getValueAt(SachTable.getSelectedRow(), 3));
                vec.add(SLInput.getValue());                                                                     
                dtmInSach.addRow(vec);                                               
            }
            
            SLInput.setValue(1);
        }
    }//GEN-LAST:event_ThemButtonActionPerformed

    private void GenerateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerateBtnActionPerformed
        if(MaVachSachTable.getRowCount()==0){
            JOptionPane.showMessageDialog(null, "Danh sách tạo mã vạch rỗng!");
            return;
        }
        int dialogResult = JOptionPane.showConfirmDialog (null, "Tạo mã vạch cho các sách trong bảng bên PHẢI!","Warning",JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION){
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1; // Tháng được đếm từ 0 (0 - 11)
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);
            int second = calendar.get(Calendar.SECOND);

            String filename ="Sach_"+ day+"-"+month+"-"+year+"_"+hour+"-"+minute+"-"+second;

            int numberOfTableRows = MaVachSachTable.getRowCount(); // số lượng dòng trong bảng bảng
            int barcodesPerRow = 3; // Số lượng mã vạch trên mỗi hàng
            
            // Tính số lượng ô trống cần thêm vào cuối bảng
            int remainingCells = barcodesPerRow - (numberOfTableRows % barcodesPerRow);

            Document document = new Document(PageSize.A4);

            try {
                //sửa đường dẫn lại cho phù hợp trong máy mình nha
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath+filename+".pdf"));
                document.open();

                PdfPTable table = new PdfPTable(barcodesPerRow);
                table.setWidthPercentage(100);

                // Tạo font hỗ trợ Tiếng Việt
                BaseFont bf = BaseFont.createFont("fonts/Roboto-Medium.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
                // Font cho các phần tử PDF
                com.itextpdf.text.Font font = new com.itextpdf.text.Font(bf, 12);

                //duyệt qua tất cả các dòng trong bảng
                for(int i=0; i < numberOfTableRows; i++){
                    //lấy giá trị cột cố lượng của dòng này
                    int qty = Integer.parseInt(MaVachSachTable.getValueAt(i,3).toString());
                    for(int l=1; l <=qty; l++){
                        //tạo mã barcode
                        Barcode39 barcode = new Barcode39();
                        barcode.setCode(MaVachSachTable.getValueAt(i, 0).toString());
                        barcode.setStartStopText(false);
                        barcode.setExtended(true);

                        //thiết lập một ô trong bảng của file pdf
                        PdfPCell cell = new PdfPCell();
                        cell.setBorderWidth(1f);
                        cell.setBorderColor(com.itextpdf.text.BaseColor.BLACK);
                        cell.setPadding(10);
                        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);

                        //thêm mã barcode vào trong ô
                        cell.addElement(barcode.createImageWithBarcode(writer.getDirectContent(),null,null));

                        //thêm tên sản phẩm vào trong ô
                        Paragraph nameParagraph = new Paragraph(MaVachSachTable.getValueAt(i, 1).toString(), font);
                        nameParagraph.setAlignment(Paragraph.ALIGN_CENTER);
                        cell.addElement(nameParagraph);

                        //thêm giá bán vào trong ô
                        Paragraph priceParagraph = new Paragraph(MaVachSachTable.getValueAt(i, 2).toString().replace(".0", "")+ " vnđ", font);
                        priceParagraph.setAlignment(Paragraph.ALIGN_CENTER);
                        cell.addElement(priceParagraph);

                        table.addCell(cell);
                    }
                }
                // Thêm các ô trống vào bảng
                for (int i = 0; i < remainingCells; i++) {
                    PdfPCell emptyCell = new PdfPCell();
                    emptyCell.setBorder(PdfPCell.NO_BORDER);
                    table.addCell(emptyCell);
                }
                document.add(table);
                document.close();
                
                //mở file pdf đó ra
                File pdfFile = new File(filePath+filename+".pdf");
                if (pdfFile.exists()) {
                    if (Desktop.isDesktopSupported()) {
                        Desktop.getDesktop().open(pdfFile);
                    } else {
                        JOptionPane.showMessageDialog(null, "Máy tính không hỗ trợ!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "File không tồn tại!");
                }
            } catch (DocumentException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_GenerateBtnActionPerformed

    private void XoaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoaButtonActionPerformed
        if (MaVachSachTable.getSelectedRow()<0) 
        JOptionPane.showMessageDialog(null, "Bạn chưa chọn sách muốn xóa!");
        else{
            int dialogResult = JOptionPane.showConfirmDialog (null, "Bạn có chắc chắn muốn xóa?","Warning",JOptionPane.YES_NO_OPTION);
            if(dialogResult == JOptionPane.YES_OPTION){
                dtmInSach.removeRow(MaVachSachTable.getSelectedRow());                                                                      
            }
        }
    }//GEN-LAST:event_XoaButtonActionPerformed

    private void ThemSPButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemSPButtonActionPerformed
        if ((SanphamTable.getSelectedRow()<0))
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn sản phẩm muốn in mã vạch");
//        nếu sách cần lấy có giá trị là 0 thì không cho lấy
        else if("0".equals(SanphamTable.getValueAt(SanphamTable.getSelectedRow(), SanphamTable.getSelectedColumn()).toString()) ){
            JOptionPane.showMessageDialog(null, "Sản phẩm bạn muốn chọn đã hết");
        }
        else {
            Vector<Object> vec = new Vector<Object>();
            int vitriSanpham = -1;
            //kiểm tra xem sách đang được chọn có nằm trong hóa đơn chưa
            for (int i=0;i<dtmInSanPham.getRowCount();i++) {
                if (dtmInSanPham.getValueAt(i, 0).equals(SanphamTable.getValueAt(SanphamTable.getSelectedRow(), 0))) vitriSanpham=i;
            }
            //nếu đã có trong hóa đơn thì cập nhật lại số lượng mã vạch
            if (vitriSanpham!=-1){
                dtmInSanPham.setValueAt(Integer.parseInt(SLSPInput.getValue().toString())+Integer.parseInt(dtmInSanPham.getValueAt(vitriSanpham, 3).toString()), vitriSanpham, 3);
            }
            //nếu chưa có thì tạo dòng mới
            else{                        
                vec.add(SanphamTable.getValueAt(SanphamTable.getSelectedRow(), 0));
                vec.add(SanphamTable.getValueAt(SanphamTable.getSelectedRow(), 1));
                vec.add(SanphamTable.getValueAt(SanphamTable.getSelectedRow(), 3));
                vec.add(SLSPInput.getValue());                                                                     
                dtmInSanPham.addRow(vec);                                               
            }
            
            SLSPInput.setValue(1);
        }
    }//GEN-LAST:event_ThemSPButtonActionPerformed

    private void GenerateSPBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerateSPBtnActionPerformed
        if(MaVachSanphamTable.getRowCount()==0){
            JOptionPane.showMessageDialog(null, "Danh sách tạo mã vạch rỗng!");
            return;
        }
        int dialogResult = JOptionPane.showConfirmDialog (null, "Tạo mã vạch cho các sản phẩm trong bảng bên PHẢI!","Warning",JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION){
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1; // Tháng được đếm từ 0 (0 - 11)
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);
            int second = calendar.get(Calendar.SECOND);

            String filename = "SanPham_"+ day+"-"+month+"-"+year+"_"+hour+"-"+minute+"-"+second;

            int numberOfTableRows = MaVachSanphamTable.getRowCount(); // số lượng dòng trong bảng bảng
            int barcodesPerRow = 3; // Số lượng mã vạch trên mỗi hàng
            
            // Tính số lượng ô trống cần thêm vào cuối bảng
            int remainingCells = barcodesPerRow - (numberOfTableRows % barcodesPerRow);

            Document document = new Document(PageSize.A4);

            try {
                //sửa đường dẫn lại cho phù hợp trong máy mình nha
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath+filename+".pdf"));
                document.open();

                PdfPTable table = new PdfPTable(barcodesPerRow);
                table.setWidthPercentage(100);

                // Tạo font hỗ trợ Tiếng Việt
                BaseFont bf = BaseFont.createFont("fonts/Roboto-Medium.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
                // Font cho các phần tử PDF
                com.itextpdf.text.Font font = new com.itextpdf.text.Font(bf, 12);

                //duyệt qua tất cả các dòng trong bảng
                for(int i=0; i < numberOfTableRows; i++){
                    //lấy giá trị cột cố lượng của dòng này
                    int qty = Integer.parseInt(MaVachSanphamTable.getValueAt(i,3).toString());
                    for(int l=1; l <=qty; l++){
                        //tạo mã barcode
                        Barcode39 barcode = new Barcode39();
                        barcode.setCode(MaVachSanphamTable.getValueAt(i, 0).toString());
                        barcode.setStartStopText(false);
                        barcode.setExtended(true);

                        //thiết lập một ô trong bảng của file pdf
                        PdfPCell cell = new PdfPCell();
                        cell.setBorderWidth(1f);
                        cell.setBorderColor(com.itextpdf.text.BaseColor.BLACK);
                        cell.setPadding(10);
                        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);

                        //thêm mã barcode vào trong ô
                        cell.addElement(barcode.createImageWithBarcode(writer.getDirectContent(),null,null));

                        //thêm tên sản phẩm vào trong ô
                        Paragraph nameParagraph = new Paragraph(MaVachSanphamTable.getValueAt(i, 1).toString(), font);
                        nameParagraph.setAlignment(Paragraph.ALIGN_CENTER);
                        cell.addElement(nameParagraph);

                        //thêm giá bán vào trong ô
                        Paragraph priceParagraph = new Paragraph(MaVachSanphamTable.getValueAt(i, 2).toString().replace(".0", "")+ " vnđ", font);
                        priceParagraph.setAlignment(Paragraph.ALIGN_CENTER);
                        cell.addElement(priceParagraph);

                        table.addCell(cell);
                    }
                }
                // Thêm các ô trống vào bảng
                for (int i = 0; i < remainingCells; i++) {
                    PdfPCell emptyCell = new PdfPCell();
                    emptyCell.setBorder(PdfPCell.NO_BORDER);
                    table.addCell(emptyCell);
                }
                document.add(table);
                document.close();
                
                //mở file pdf đó ra
                File pdfFile = new File(filePath+filename+".pdf");
                if (pdfFile.exists()) {
                    if (Desktop.isDesktopSupported()) {
                        Desktop.getDesktop().open(pdfFile);
                    } else {
                        JOptionPane.showMessageDialog(null, "Máy tính không hỗ trợ!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "File không tồn tại!");
                }
            } catch (DocumentException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_GenerateSPBtnActionPerformed

    private void XoaSPButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoaSPButtonActionPerformed
        if (MaVachSanphamTable.getSelectedRow()<0) 
        JOptionPane.showMessageDialog(null, "Bạn chưa chọn sản phẩm muốn xóa!");
        else{
            int dialogResult = JOptionPane.showConfirmDialog (null, "Bạn có chắc chắn muốn xóa?","Warning",JOptionPane.YES_NO_OPTION);
            if(dialogResult == JOptionPane.YES_OPTION){
                dtmInSanPham.removeRow(MaVachSanphamTable.getSelectedRow());                                                                      
            }
        }
    }//GEN-LAST:event_XoaSPButtonActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(InMaVach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InMaVach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InMaVach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InMaVach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InMaVach("In mã vạch").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DMV_Label;
    private javax.swing.JLabel DSSPMV_Label;
    private javax.swing.JLabel DSSP_Label;
    private javax.swing.JLabel DSS_Label;
    private javax.swing.JButton GenerateBtn;
    private javax.swing.JButton GenerateSPBtn;
    private javax.swing.JTable MaVachSachTable;
    private javax.swing.JTable MaVachSanphamTable;
    private javax.swing.JSpinner SLInput;
    private javax.swing.JLabel SLLabel;
    private javax.swing.JSpinner SLSPInput;
    private javax.swing.JLabel SLSPLabel;
    private javax.swing.JTable SachTable;
    private javax.swing.JTable SanphamTable;
    private javax.swing.JButton ThemButton;
    private javax.swing.JButton ThemSPButton;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JButton XoaButton;
    private javax.swing.JButton XoaSPButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
