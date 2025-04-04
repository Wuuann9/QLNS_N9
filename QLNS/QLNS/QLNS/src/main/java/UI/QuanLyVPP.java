/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import Connect.CTHD_Connect;
import Connect.HoaDon_Connect;
import Connect.NXB_Connect;
import Connect.NhaCungCapVPP_Connect;
import Connect.Sach_Connect;
import Connect.VanPhongPham_Connect;
import Model.CTHD;
import Model.HoaDon;
import Model.NhaCungCap_VPP;
import Model.VPP;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author nguye
 */
public class QuanLyVPP extends javax.swing.JFrame {

    /**
     * Creates new form QuanLySach
     */
        private String MaHD=null;
        private String MaNV= null;
        private DefaultTableModel dtmVPP ;
	private ArrayList<NhaCungCap_VPP> dsncc = null;
        private ArrayList<VPP> dsChung = null;
        private ArrayList<VPP> dsNCC = null;
	private ArrayList<VPP> dsVPP = null;
	private ArrayList<VPP> dssDanhMuc = null;
	private ArrayList<VPP> dss_tenVPP = null;
	
    public QuanLyVPP(String title, String maNV) {
        initComponents();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("images/books_30px.png"));
        this.setTitle(title);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
        MaNV=maNV;
        hienThiToanBoVPP();
        hienThiToanBoNhaCungCap();
    }
    
   private void hienThiToanBoVPP() {
        VanPhongPham_Connect vppConn = new VanPhongPham_Connect();
        dsVPP = vppConn.layToanBoVPP();
        dtmVPP = new DefaultTableModel();
        dtmVPP.addColumn("Mã VPP");     
        dtmVPP.addColumn("Tên VPP");
        dtmVPP.addColumn("Tên NCCVPP");
        dtmVPP.addColumn("Danh Mục");      
        dtmVPP.addColumn("Số lượng");
        dtmVPP.addColumn("Giá Bán (VNĐ)");
        dtmVPP.addColumn("Giảm Giá (%)");
        dtmVPP.setRowCount(0);
        for (VPP vpp : dsVPP){
            Vector<Object> vec = new Vector<Object>();
            vec.add(vpp.getMaVPP());          
            vec.add(vpp.getTenVPP());
            vec.add(vpp.getMaNCC());
            vec.add(vpp.getDanhMuc());
            vec.add(vpp.getSoLuong());
            vec.add(vpp.getGiaBan());
            
            vec.add(vpp.getDiscount());
            dtmVPP.addRow(vec);	
        }
        jTable_VPP.setModel(dtmVPP);
        jButton_ThemTuExcel.setEnabled(false);
    }
 
      
    private void hienThiToanBoNhaCungCap() {
        NhaCungCapVPP_Connect nccconn = new NhaCungCapVPP_Connect();

        dsncc = nccconn.layToanBoNhaCungCap_VPP();
        NCCInput.removeAllItems();
        NCCInput_TangGia.removeAllItems();
        NhaCungCap_VPP ncc_vpp = new NhaCungCap_VPP();
        ncc_vpp.setMaNCCVPP("0");
        ncc_vpp.setTenNCCVPP("Tất cả");

        NCCInput.addItem(ncc_vpp);
        for(NhaCungCap_VPP s : dsncc) {
            NCCInput.addItem(s);
            NCCInput_TangGia.addItem(s);
        }      
    }
      
    public static boolean isNumeric(String string) {
        int intValue;

        //System.out.println(String.format("Parsing string: \"%s\"", string));

        if(string == null || string.equals("")) {
            //System.out.println("String cannot be parsed, it is null or empty.");
            return false;
        }

        try {
            intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            //System.out.println("Input String cannot be parsed to Integer.");
        }
        return false;
    }
         
    public static boolean isNumeric_Double(String string) {
    double intValue;
	
    //System.out.println(String.format("Parsing string: \"%s\"", string));
		
    if(string == null || string.equals("")) {
        //System.out.println("String cannot be parsed, it is null or empty.");
        return false;
    }
    
    try {
        intValue = Double.parseDouble(string);
        return true;
    } catch (NumberFormatException e) {
        //System.out.println("Input String cannot be parsed to Integer.");
    }
    return false;
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_Top = new javax.swing.JPanel();
        jPanel_TopFunction = new javax.swing.JPanel();
        jButton_ChinhSua = new javax.swing.JButton();
        jButton_XoaVPP = new javax.swing.JButton();
        jButton_ThemVPP = new javax.swing.JButton();
        jLabel_Top = new javax.swing.JLabel();
        jPanel_Data = new javax.swing.JPanel();
        jLabel_MaSach = new javax.swing.JLabel();
        jLabel_TenSach = new javax.swing.JLabel();
        jLabel_MaNXB = new javax.swing.JLabel();
        jLabel_GiaBan = new javax.swing.JLabel();
        jLabel_TheLoai = new javax.swing.JLabel();
        jLabel_SoLuong = new javax.swing.JLabel();
        NCCInput = new javax.swing.JComboBox<NhaCungCap_VPP>();
        TKInput_MaVPP = new javax.swing.JTextField();
        TKInput_TenVPP = new javax.swing.JTextField();
        TKInput_DoanhMuc = new javax.swing.JTextField();
        TKInput_SoLuong = new javax.swing.JTextField();
        TKInput_GiaBan = new javax.swing.JTextField();
        jLabel_Discount = new javax.swing.JLabel();
        TKInput_Discount = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel_Discount1 = new javax.swing.JLabel();
        TKInput_UpdateAllPrice = new javax.swing.JTextField();
        jButton_Accpet_Search = new javax.swing.JButton();
        jButton_Cancel = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel_Discount2 = new javax.swing.JLabel();
        TKInput_UpdateAllPriceNCC = new javax.swing.JTextField();
        jButton_Accpet_TangGiaByNCC = new javax.swing.JButton();
        jButton_CancelNCC = new javax.swing.JButton();
        NCCInput_TangGia = new javax.swing.JComboBox<NhaCungCap_VPP>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel_Discount3 = new javax.swing.JLabel();
        TKInput_UpdateAllPriceDoanhMuc = new javax.swing.JTextField();
        jButton_Accpet_TangGiaDoanhMuc = new javax.swing.JButton();
        jButton_CancelDoanhMuc = new javax.swing.JButton();
        TK_DanhMucInput_TangGia = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jButton_NhapLai = new javax.swing.JButton();
        jButton_importExcel = new javax.swing.JButton();
        jButton_ThemTuExcel = new javax.swing.JButton();
        jPanel_Center = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_VPP = new javax.swing.JTable();
        jLabel_Loc = new javax.swing.JLabel();
        TK_TenVPPInput = new javax.swing.JTextField();
        jButton_Search = new javax.swing.JButton();
        jLabel_Loc1 = new javax.swing.JLabel();
        TK_DanhMucInput = new javax.swing.JTextField();
        NhanTenLabel = new javax.swing.JLabel();
        jButton_RefreshSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel_Top.setLayout(new javax.swing.BoxLayout(jPanel_Top, javax.swing.BoxLayout.LINE_AXIS));

        jButton_ChinhSua.setBackground(new java.awt.Color(255, 255, 102));
        jButton_ChinhSua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_ChinhSua.setText("Cập nhật");
        jButton_ChinhSua.setMaximumSize(new java.awt.Dimension(150, 40));
        jButton_ChinhSua.setMinimumSize(new java.awt.Dimension(150, 40));
        jButton_ChinhSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ChinhSuaActionPerformed(evt);
            }
        });

        jButton_XoaVPP.setBackground(new java.awt.Color(255, 102, 102));
        jButton_XoaVPP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_XoaVPP.setForeground(new java.awt.Color(255, 255, 255));
        jButton_XoaVPP.setText("Xoá VPP");
        jButton_XoaVPP.setMaximumSize(new java.awt.Dimension(150, 40));
        jButton_XoaVPP.setMinimumSize(new java.awt.Dimension(150, 40));
        jButton_XoaVPP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_XoaVPPActionPerformed(evt);
            }
        });

        jButton_ThemVPP.setBackground(new java.awt.Color(51, 255, 153));
        jButton_ThemVPP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_ThemVPP.setForeground(new java.awt.Color(255, 255, 255));
        jButton_ThemVPP.setText("Thêm VPP");
        jButton_ThemVPP.setMaximumSize(new java.awt.Dimension(150, 40));
        jButton_ThemVPP.setMinimumSize(new java.awt.Dimension(150, 40));
        jButton_ThemVPP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ThemVPPActionPerformed(evt);
            }
        });

        jLabel_Top.setFont(new java.awt.Font("Segoe UI", 3, 28)); // NOI18N
        jLabel_Top.setForeground(new java.awt.Color(0, 153, 204));
        jLabel_Top.setText("Quản Lý Văn Phòng Phẩm");

        jPanel_Data.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel_MaSach.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel_MaSach.setText("Mã VPP");

        jLabel_TenSach.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel_TenSach.setText("Tên VPP");

        jLabel_MaNXB.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel_MaNXB.setText("Mã NCC");

        jLabel_GiaBan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel_GiaBan.setText("Giá Bán");

        jLabel_TheLoai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel_TheLoai.setText("Doanh Mục");

        jLabel_SoLuong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel_SoLuong.setText("Số Lượng");

        NCCInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        TKInput_MaVPP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TKInput_MaVPPActionPerformed(evt);
            }
        });

        jLabel_Discount.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel_Discount.setText("Giảm Giá");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel_Discount1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel_Discount1.setText("Tăng giá theo tìm kiếm");

        jButton_Accpet_Search.setText("OK");
        jButton_Accpet_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Accpet_SearchActionPerformed(evt);
            }
        });

        jButton_Cancel.setText("X");
        jButton_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CancelActionPerformed(evt);
            }
        });

        jLabel5.setText("Giá:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TKInput_UpdateAllPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Accpet_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel_Discount1)
                .addGap(65, 65, 65))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_Discount1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TKInput_UpdateAllPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Accpet_Search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_Cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel_Discount.setIcon(new ImageIcon("images/discount_28px.png"));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel_Discount2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel_Discount2.setText("Tăng giá theo NCC");

        jButton_Accpet_TangGiaByNCC.setText("OK");
        jButton_Accpet_TangGiaByNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Accpet_TangGiaByNCCActionPerformed(evt);
            }
        });

        jButton_CancelNCC.setText("X");
        jButton_CancelNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CancelNCCActionPerformed(evt);
            }
        });

        NCCInput_TangGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Giá:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("NCC:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NCCInput_TangGia, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TKInput_UpdateAllPriceNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_Accpet_TangGiaByNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_CancelNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(jLabel_Discount2)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_Discount2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TKInput_UpdateAllPriceNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Accpet_TangGiaByNCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_CancelNCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NCCInput_TangGia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addContainerGap())
        );

        jLabel_Discount.setIcon(new ImageIcon("images/discount_28px.png"));

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel_Discount3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel_Discount3.setText("Tăng giá theo Danh Mục");

        jButton_Accpet_TangGiaDoanhMuc.setText("OK");
        jButton_Accpet_TangGiaDoanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Accpet_TangGiaDoanhMucActionPerformed(evt);
            }
        });

        jButton_CancelDoanhMuc.setText("X");
        jButton_CancelDoanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CancelDoanhMucActionPerformed(evt);
            }
        });

        TK_DanhMucInput_TangGia.setToolTipText("Tên Sách");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Tên danh mục :");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Giá:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel_Discount3)
                .addGap(173, 173, 173))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TK_DanhMucInput_TangGia, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TKInput_UpdateAllPriceDoanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_Accpet_TangGiaDoanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton_CancelDoanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_Discount3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TKInput_UpdateAllPriceDoanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Accpet_TangGiaDoanhMuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_CancelDoanhMuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TK_DanhMucInput_TangGia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jLabel_Discount.setIcon(new ImageIcon("images/discount_28px.png"));

        javax.swing.GroupLayout jPanel_DataLayout = new javax.swing.GroupLayout(jPanel_Data);
        jPanel_Data.setLayout(jPanel_DataLayout);
        jPanel_DataLayout.setHorizontalGroup(
            jPanel_DataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_DataLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel_DataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_DataLayout.createSequentialGroup()
                        .addGroup(jPanel_DataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_MaSach)
                            .addComponent(jLabel_MaNXB)
                            .addComponent(jLabel_TenSach))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel_DataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TKInput_TenVPP, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NCCInput, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TKInput_MaVPP, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel_DataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_SoLuong, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel_TheLoai, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel_GiaBan, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(47, 47, 47)
                .addGroup(jPanel_DataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel_DataLayout.createSequentialGroup()
                        .addGroup(jPanel_DataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TKInput_SoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TKInput_DoanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TKInput_GiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61)
                        .addGroup(jPanel_DataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_DataLayout.createSequentialGroup()
                                .addComponent(jLabel_Discount)
                                .addGap(42, 42, 42)
                                .addComponent(TKInput_Discount, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel_DataLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)))
                .addGap(45, 45, 45))
        );
        jPanel_DataLayout.setVerticalGroup(
            jPanel_DataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_DataLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel_DataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_DataLayout.createSequentialGroup()
                        .addComponent(jLabel_GiaBan)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel_DataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_TheLoai)
                            .addComponent(TKInput_DoanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_DataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_DataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel_TenSach, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(TKInput_TenVPP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel_DataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TKInput_SoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel_SoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel_DataLayout.createSequentialGroup()
                        .addGroup(jPanel_DataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel_MaSach)
                            .addComponent(TKInput_MaVPP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel_DataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TKInput_GiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel_Discount)
                                .addComponent(TKInput_Discount, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel_DataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_DataLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jPanel_DataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel_MaNXB)
                                    .addComponent(NCCInput, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel_DataLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel_DataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        jLabel_MaSach.setIcon(new ImageIcon("images/Code_28px.png"));
        jLabel_TenSach.setIcon(new ImageIcon("images/dog_tag_28px.png"));
        jLabel_MaNXB.setIcon(new ImageIcon("images/link_28px.png"));
        jLabel_GiaBan.setIcon(new ImageIcon("images/Banknotes_28px.png"));
        jLabel_TheLoai.setIcon(new ImageIcon("images/category_28px.png"));
        jLabel_SoLuong.setIcon(new ImageIcon("images/how_many_quest_28px.png"));
        jLabel_Discount.setIcon(new ImageIcon("images/discount_28px.png"));

        jSeparator2.setBackground(new java.awt.Color(102, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(0, 102, 204));

        jButton_NhapLai.setBackground(new java.awt.Color(255, 204, 204));
        jButton_NhapLai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_NhapLai.setText("Nhập lại");
        jButton_NhapLai.setMaximumSize(new java.awt.Dimension(150, 40));
        jButton_NhapLai.setMinimumSize(new java.awt.Dimension(150, 40));
        jButton_NhapLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_NhapLaiActionPerformed(evt);
            }
        });

        jButton_importExcel.setBackground(new java.awt.Color(0, 204, 51));
        jButton_importExcel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_importExcel.setForeground(new java.awt.Color(255, 255, 255));
        jButton_importExcel.setText("Excel +");
        jButton_importExcel.setMaximumSize(new java.awt.Dimension(150, 40));
        jButton_importExcel.setMinimumSize(new java.awt.Dimension(150, 40));
        jButton_importExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_importExcelActionPerformed(evt);
            }
        });

        jButton_ThemTuExcel.setBackground(new java.awt.Color(0, 204, 51));
        jButton_ThemTuExcel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_ThemTuExcel.setForeground(new java.awt.Color(255, 255, 255));
        jButton_ThemTuExcel.setText("Thêm");
        jButton_ThemTuExcel.setMaximumSize(new java.awt.Dimension(150, 40));
        jButton_ThemTuExcel.setMinimumSize(new java.awt.Dimension(150, 40));
        jButton_ThemTuExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ThemTuExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_TopFunctionLayout = new javax.swing.GroupLayout(jPanel_TopFunction);
        jPanel_TopFunction.setLayout(jPanel_TopFunctionLayout);
        jPanel_TopFunctionLayout.setHorizontalGroup(
            jPanel_TopFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_TopFunctionLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel_Top)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_ThemTuExcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton_importExcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jButton_ThemVPP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(jButton_ChinhSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(jButton_NhapLai, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(jButton_XoaVPP, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
            .addComponent(jPanel_Data, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel_TopFunctionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator2)
                .addContainerGap())
        );
        jPanel_TopFunctionLayout.setVerticalGroup(
            jPanel_TopFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_TopFunctionLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel_TopFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_ThemVPP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_ChinhSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_XoaVPP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Top, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_NhapLai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_importExcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_ThemTuExcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_Data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        jButton_ChinhSua.setIcon(new ImageIcon("images/book_and_pencil_25px.png"));
        jButton_XoaVPP.setIcon(new ImageIcon("images/delete_25px.png"));
        jButton_ThemVPP.setIcon(new ImageIcon("images/add_25px.png"));
        jLabel_Top.setIcon(new ImageIcon("images/feather_emoji_40px.png"));
        jButton_ChinhSua.setIcon(new ImageIcon("images/hand_with_pen_25px.png"));
        jButton_ThemVPP.setIcon(new ImageIcon("images/add_book_25px.png"));
        jButton_ThemVPP.setIcon(new ImageIcon("images/add_book_25px.png"));

        jPanel_Top.add(jPanel_TopFunction);

        getContentPane().add(jPanel_Top, java.awt.BorderLayout.PAGE_START);

        jSeparator1.setBackground(new java.awt.Color(102, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(0, 102, 204));

        jTable_VPP.setBackground(new java.awt.Color(244, 243, 243));
        jTable_VPP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable_VPP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_VPPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_VPP);

        jLabel_Loc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel_Loc.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_Loc.setText("Tên VPP:");
        jLabel_Loc.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        TK_TenVPPInput.setToolTipText("Tên Sách");

        jButton_Search.setBackground(new java.awt.Color(51, 153, 255));
        jButton_Search.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton_Search.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Search.setText("Tìm Kiếm");
        jButton_Search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_SearchMouseClicked(evt);
            }
        });

        jLabel_Loc1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel_Loc1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_Loc1.setText("Tên Doanh Mục:");
        jLabel_Loc1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        TK_DanhMucInput.setToolTipText("Tên Sách");

        NhanTenLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        NhanTenLabel.setForeground(new java.awt.Color(0, 153, 153));
        NhanTenLabel.setText("Nhập tên VPP và tên danh mục");

        jButton_RefreshSearch.setBackground(new java.awt.Color(255, 204, 204));
        jButton_RefreshSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_RefreshSearch.setForeground(new java.awt.Color(255, 255, 255));
        jButton_RefreshSearch.setText("!");
        jButton_RefreshSearch.setMaximumSize(new java.awt.Dimension(150, 40));
        jButton_RefreshSearch.setMinimumSize(new java.awt.Dimension(150, 40));
        jButton_RefreshSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RefreshSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_CenterLayout = new javax.swing.GroupLayout(jPanel_Center);
        jPanel_Center.setLayout(jPanel_CenterLayout);
        jPanel_CenterLayout.setHorizontalGroup(
            jPanel_CenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel_CenterLayout.createSequentialGroup()
                .addGroup(jPanel_CenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_CenterLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel_CenterLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel_Loc)
                        .addGap(18, 18, 18)
                        .addComponent(TK_TenVPPInput, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)
                        .addComponent(jLabel_Loc1)
                        .addGap(18, 18, 18)
                        .addComponent(TK_DanhMucInput, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_RefreshSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 197, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel_CenterLayout.createSequentialGroup()
                .addGap(516, 516, 516)
                .addComponent(NhanTenLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_CenterLayout.setVerticalGroup(
            jPanel_CenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_CenterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(NhanTenLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_CenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_RefreshSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel_CenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel_Loc, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TK_TenVPPInput, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel_Loc1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TK_DanhMucInput, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_Search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(5, 5, 5))
        );

        jLabel_Loc.setIcon(new ImageIcon("images/filter_48px.png"));
        jButton_Search.setIcon(new ImageIcon("images/search_25px.png"));
        jLabel_Loc.setIcon(new ImageIcon("images/filter_48px.png"));
        jButton_RefreshSearch.setIcon(new ImageIcon("images/refresh_30px.png"));

        getContentPane().add(jPanel_Center, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //Chỉnh sửa, cập nhật sách
    private void jButton_ChinhSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ChinhSuaActionPerformed
        // TODO add your handling code here:
        if(TKInput_MaVPP.getText().length()==0 ||  
            TKInput_TenVPP.getText().length()==0  || TKInput_GiaBan.getText().length()==0 ||
            TKInput_DoanhMuc.getText().length()==0 || TKInput_SoLuong.getText().length()==0 || TKInput_Discount.getText().length()==0) {
            JOptionPane.showMessageDialog(this, "Nhập thiếu dữ liệu !","Error", JOptionPane.WARNING_MESSAGE);
            return ;
        }
        NhaCungCap_VPP ncc = (NhaCungCap_VPP) NCCInput.getSelectedItem();
        VPP vp = new VPP();
        vp.setMaVPP(TKInput_MaVPP.getText());
        vp.setTenVPP(TKInput_TenVPP.getText());
        vp.setMaNCC(ncc.getMaNCCVPP());
        vp.setDanhMuc(TKInput_DoanhMuc.getText());
        if (!isNumeric_Double(TKInput_GiaBan.getText()) || !isNumeric(TKInput_SoLuong.getText()) || !isNumeric(TKInput_Discount.getText()))
        {
            JOptionPane.showMessageDialog(this, "Giá bán, Số lượng hoặc Giảm giá đã nhập sai định dạng !\n Vui lòng thử lại !","Error", JOptionPane.WARNING_MESSAGE);
            return ;
        }
        vp.setGiaBan(Double.parseDouble(TKInput_GiaBan.getText()));				
        vp.setSoLuong(Integer.parseInt(TKInput_SoLuong.getText()));
        vp.setDiscount(Integer.parseInt(TKInput_Discount.getText()));
        VanPhongPham_Connect vpc = new VanPhongPham_Connect();
        int active = vpc.Update(vp);
        if (active>0)
        {
                JOptionPane.showMessageDialog(null, "Chỉnh sửa thông tin thành công");
        }
        else 
        {
                JOptionPane.showMessageDialog(null, "Chỉnh sửa thất bại");
        }
        hienThiToanBoVPP();
    }//GEN-LAST:event_jButton_ChinhSuaActionPerformed

    
    //Thêm
    private void jButton_ThemVPPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ThemVPPActionPerformed
        // TODO add your handling code here: 
        if(TKInput_MaVPP.getText().length()==0 ||  
            TKInput_TenVPP.getText().length()==0  || TKInput_GiaBan.getText().length()==0 ||
            TKInput_DoanhMuc.getText().length()==0 || TKInput_SoLuong.getText().length()==0 || TKInput_Discount.getText().length()==0) {
            JOptionPane.showMessageDialog(this, "Nhập thiếu dữ liệu !","Error", JOptionPane.WARNING_MESSAGE);
            return ;
        }

        NhaCungCap_VPP np = (NhaCungCap_VPP) NCCInput.getSelectedItem();
        VPP vp = new VPP();
        for (VPP vpp_check : dsVPP){
            if(vpp_check.getMaVPP().equals(TKInput_MaVPP.getText())){
                JOptionPane.showMessageDialog(this, "Văn phòng phẩm đã tồn tại","Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } 
        vp.setMaVPP(TKInput_MaVPP.getText());
        vp.setTenVPP(TKInput_TenVPP.getText());
        vp.setMaNCC(np.getMaNCCVPP());
        vp.setDanhMuc(TKInput_DoanhMuc.getText());
        if (!isNumeric_Double(TKInput_GiaBan.getText()) || !isNumeric(TKInput_SoLuong.getText()) || !isNumeric(TKInput_Discount.getText())){
            JOptionPane.showMessageDialog(this, "Giá bán, Số lượng hoặc Giảm giá đã nhập sai định dạng !\n Vui lòng thử lại !","Error", JOptionPane.WARNING_MESSAGE);
            return ;
        }
        vp.setGiaBan(Double.parseDouble(TKInput_GiaBan.getText()));

        vp.setSoLuong(Integer.parseInt(TKInput_SoLuong.getText()));
        vp.setDiscount(Integer.parseInt(TKInput_Discount.getText()));

        int x =JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn thêm văn phòng phẩm này ?", "Xác nhận thêm",JOptionPane.OK_CANCEL_OPTION);
        if(x==JOptionPane.OK_OPTION){
            xuLyThemMoi(vp);	
        }
        else return;
    }//GEN-LAST:event_jButton_ThemVPPActionPerformed

    protected void xuLyThemMoi(VPP vp) {
        VanPhongPham_Connect themvpp = new VanPhongPham_Connect();
        int active = themvpp.themMoi(vp);
        if(active > 0 ){
            JOptionPane.showMessageDialog(null, "Thêm mới thành công");
            TaoHDVaCTHD();
            TKInput_MaVPP.setText("");
            TKInput_TenVPP.setText("");	

            TKInput_GiaBan.setText("");
            TKInput_DoanhMuc.setText("");
            TKInput_SoLuong.setText("");
            TKInput_Discount.setText("");
            TKInput_MaVPP.requestFocus();
            hienThiToanBoVPP();
        }
        else{
            JOptionPane.showMessageDialog(null, "Thêm mới thất bại");
        }
		
    }
    
    private void TaoHDVaCTHD(){
        String HD = "HD";
        //tạo hóa đơn với mã hóa đơn mới tính từ hóa đơn cuối cùng
        HoaDon_Connect tHD = new HoaDon_Connect();
        CTHD_Connect cthd = new CTHD_Connect();
        String lastmahd = tHD.LastMaHD();
        if (lastmahd==null) MaHD= "HD01";
        else {
            int sohd = Integer.parseInt(lastmahd.substring(2))+1; //bỏ đi hai chữ "HD" và công thêm 1 vào hai số phía sau
            if (sohd<10) MaHD = HD+"0"+String.valueOf(sohd);
            else MaHD = HD+String.valueOf(sohd);
        }    
        System.out.println(MaHD);
        System.out.println(MaNV);
        HoaDon hd = new HoaDon();
        hd.setMaHD(MaHD);
        hd.setMaNV(MaNV);

        Date date = new Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(date);
        hd.setNgaylap(currentTime);
        hd.setTongTien(Double.parseDouble(TKInput_GiaBan.getText())*Double.parseDouble(TKInput_SoLuong.getText()) );
        hd.setTrangThai(0);
        hd.setNhapSach(1);
        tHD.TaoHD(hd); 
    //        
        CTHD ct = new CTHD();
        ct.setMaHD(MaHD);
        ct.setMaSP(TKInput_MaVPP.getText());
        ct.setDonGia(Double.parseDouble(TKInput_GiaBan.getText()));
        ct.setSoLuong(Integer.parseInt(TKInput_SoLuong.getText()));
        ct.setThanhTien(Double.parseDouble(TKInput_GiaBan.getText())*Double.parseDouble(TKInput_SoLuong.getText()) );
        CTHD_Connect ctCon = new CTHD_Connect();
        ctCon.ThemCT(ct);
   }
    
    
    //Tìm kiếm VPP
    private void jButton_SearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_SearchMouseClicked
        // TODO add your handling code here:
        String ten = TK_TenVPPInput.getText();
        String dm = TK_DanhMucInput.getText();
        VanPhongPham_Connect vpc = new VanPhongPham_Connect();
        dss_tenVPP = vpc.laySachTheoTenVPP(ten);
        dssDanhMuc = vpc.laySachTheoDanhMuc(dm);
        dsChung = vpc.laySachTheoDanhMucVaTenVPP(dm, ten);
        //show all data
        if (TK_TenVPPInput.getText().length()==0 && TK_DanhMucInput.getText().length()==0)
            hienThiToanBoVPP();
        //tìm kiếm theo tên VPP
        if (TK_TenVPPInput.getText().length()!= 0 && TK_DanhMucInput.getText().length()==0){
            dtmVPP.setRowCount(0);
            for(VPP vpp : dss_tenVPP){
                Vector<Object> vec = new Vector<Object>();
                vec.add(vpp.getMaVPP());          
                vec.add(vpp.getTenVPP());
                vec.add(vpp.getMaNCC());
                vec.add(vpp.getDanhMuc());
                vec.add(vpp.getSoLuong());
                vec.add(vpp.getGiaBan());

                vec.add(vpp.getDiscount());
            dtmVPP.addRow(vec);	
            }
        }
        //Tìm kiếm theo tên VPP và danh mục
        else if (TK_TenVPPInput.getText().length()!= 0 && TK_DanhMucInput.getText().length()!=0){
            
            dtmVPP.setRowCount(0);
            for(VPP vpp : dsChung){
                Vector<Object> vec = new Vector<Object>();
                vec.add(vpp.getMaVPP());          
                vec.add(vpp.getTenVPP());
                vec.add(vpp.getMaNCC());
                vec.add(vpp.getDanhMuc());
                vec.add(vpp.getSoLuong());
                vec.add(vpp.getGiaBan());

                vec.add(vpp.getDiscount());
                dtmVPP.addRow(vec);	
            }

            
        }
        //tìm kiếm theo danh mục
        else if (TK_TenVPPInput.getText().length()== 0 && TK_DanhMucInput.getText().length()!=0){
            dtmVPP.setRowCount(0);
            for(VPP vpp : dssDanhMuc){
                Vector<Object> vec = new Vector<Object>();
                vec.add(vpp.getMaVPP());          
                vec.add(vpp.getTenVPP());
                vec.add(vpp.getMaNCC());
                vec.add(vpp.getDanhMuc());
                vec.add(vpp.getSoLuong());
                vec.add(vpp.getGiaBan());

                vec.add(vpp.getDiscount());
                dtmVPP.addRow(vec);	
            }
	}
    }//GEN-LAST:event_jButton_SearchMouseClicked

    
    //Xoá
    private void jButton_XoaVPPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_XoaVPPActionPerformed
         //TODO add your handling code here:
        int select = jTable_VPP.getSelectedRow();
        if(select==-1)  {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn văn phòng phẩm muốn xoá","Error", JOptionPane.WARNING_MESSAGE);
            return ;
        }
        String maVPP = (String) jTable_VPP.getValueAt(select, 0);
        //JOptionPane.showMessageDialog(null,jTable_Books.getValueAt(select, 0) );
        int active = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa ?", "Xác Nhận Xóa", JOptionPane.OK_CANCEL_OPTION);
        if(active==JOptionPane.OK_OPTION)
        {
                xuLyXoa(maVPP);
                //JOptionPane.showMessageDialog(null,maSach );
        }
    }//GEN-LAST:event_jButton_XoaVPPActionPerformed

    
    //Nhập lại
    private void jButton_NhapLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_NhapLaiActionPerformed
        // TODO add your handling code here:
        TKInput_MaVPP.setText("");
        TKInput_TenVPP.setText("");
        //txtMaNXB.setText("");
        NCCInput.setSelectedIndex(0);
        TKInput_GiaBan.setText("");
        TKInput_DoanhMuc.setText("");
        TKInput_SoLuong.setText("");
        TKInput_Discount.setText("");
        TKInput_MaVPP.requestFocus();
    }//GEN-LAST:event_jButton_NhapLaiActionPerformed
    
    //Get selected row
    private void jTable_VPPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_VPPMouseClicked
        // TODO add your handling code here:

        int select = jTable_VPP.getSelectedRow();
        NhaCungCapVPP_Connect ncc_con = new NhaCungCapVPP_Connect();
        if(select==-1) return ;

        //lấy thông tin trong table
        VPP vp = new VPP();
        vp.setMaVPP((String) jTable_VPP.getValueAt(select, 0)+"");
        //s.setMaNXB((String) jTable_Books.getValueAt(select, 1));
        //nxb.setMaNXB((String) jTable_Books.getValueAt(select, 1));

        vp.setTenVPP((String) jTable_VPP.getValueAt(select, 1)+"");
        vp.setDanhMuc((String) jTable_VPP.getValueAt(select, 3)+"");

        vp.setSoLuong( Integer.parseInt(jTable_VPP.getValueAt(select, 4)+""));
        vp.setGiaBan( Double.parseDouble(jTable_VPP.getValueAt(select, 5)+""));
        vp.setDiscount(Integer.parseInt(jTable_VPP.getValueAt(select, 6)+""));
            //System.out.println(vp.getGiaBan());

        //đưa thông tin lên panelTop
        TKInput_MaVPP.setText(vp.getMaVPP());


        TKInput_TenVPP.setText(vp.getTenVPP());

        TKInput_GiaBan.setText(vp.getGiaBan()+"");
        TKInput_DoanhMuc.setText(vp.getDanhMuc());
        TKInput_SoLuong.setText(vp.getSoLuong()+"");
        TKInput_Discount.setText(vp.getDiscount()+"");
       NCCInput.setSelectedIndex(Integer.parseInt(ncc_con.TimTenNCC(jTable_VPP.getValueAt(select, 2).toString()).getMaNCCVPP().substring(3)) );
    }//GEN-LAST:event_jTable_VPPMouseClicked

    private void TKInput_MaVPPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TKInput_MaVPPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TKInput_MaVPPActionPerformed

    private void jButton_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CancelActionPerformed
        // TODO add your handling code here:
        TKInput_UpdateAllPrice.setText("");
    }//GEN-LAST:event_jButton_CancelActionPerformed

    //tăng giá all VPP
    private void jButton_Accpet_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Accpet_SearchActionPerformed
        // TODO add your handling code here:
        int active = JOptionPane.showConfirmDialog(null, "Bạn có muốn tăng giá theo tìm kiếm ?", "Xác Nhận Tăng", JOptionPane.OK_CANCEL_OPTION);
				if(active==JOptionPane.OK_OPTION)
				{
        String ten = TK_TenVPPInput.getText();
        String dm = TK_DanhMucInput.getText();
        VanPhongPham_Connect vpc = new VanPhongPham_Connect();
        dss_tenVPP = vpc.laySachTheoTenVPP(ten);
        dssDanhMuc = vpc.laySachTheoDanhMuc(dm);
        dsChung = vpc.laySachTheoDanhMucVaTenVPP(dm, ten);
        //show all data
        if (TK_TenVPPInput.getText().length()==0 && TK_DanhMucInput.getText().length()==0)
            hienThiToanBoVPP();
        thucHienTangGiaVoiVPPDuocTimKiem(dsVPP);
        //tìm kiếm theo tên VPP
        if (TK_TenVPPInput.getText().length()!= 0 && TK_DanhMucInput.getText().length()==0){
            dtmVPP.setRowCount(0);
            for(VPP vpp : dss_tenVPP){
                Vector<Object> vec = new Vector<Object>();
                vec.add(vpp.getMaVPP());          
                vec.add(vpp.getTenVPP());
                vec.add(vpp.getMaNCC());
                vec.add(vpp.getDanhMuc());
                vec.add(vpp.getSoLuong());
                vec.add(vpp.getGiaBan());

                vec.add(vpp.getDiscount());
            dtmVPP.addRow(vec);	
            }
            thucHienTangGiaVoiVPPDuocTimKiem(dss_tenVPP);
        }
        //Tìm kiếm theo tên VPP và danh mục
        else if (TK_TenVPPInput.getText().length()!= 0 && TK_DanhMucInput.getText().length()!=0){
            
            dtmVPP.setRowCount(0);
            for(VPP vpp : dsChung){
                Vector<Object> vec = new Vector<Object>();
                vec.add(vpp.getMaVPP());          
                vec.add(vpp.getTenVPP());
                vec.add(vpp.getMaNCC());
                vec.add(vpp.getDanhMuc());
                vec.add(vpp.getSoLuong());
                vec.add(vpp.getGiaBan());

                vec.add(vpp.getDiscount());
                dtmVPP.addRow(vec);	
            }
            thucHienTangGiaVoiVPPDuocTimKiem(dsChung);

            
        }
        //tìm kiếm theo danh mục
        else if (TK_TenVPPInput.getText().length()== 0 && TK_DanhMucInput.getText().length()!=0){
            dtmVPP.setRowCount(0);
            for(VPP vpp : dssDanhMuc){
                Vector<Object> vec = new Vector<Object>();
                vec.add(vpp.getMaVPP());          
                vec.add(vpp.getTenVPP());
                vec.add(vpp.getMaNCC());
                vec.add(vpp.getDanhMuc());
                vec.add(vpp.getSoLuong());
                vec.add(vpp.getGiaBan());

                vec.add(vpp.getDiscount());
                dtmVPP.addRow(vec);	
            }
            thucHienTangGiaVoiVPPDuocTimKiem(dssDanhMuc);
	}
                                }
    }//GEN-LAST:event_jButton_Accpet_SearchActionPerformed

    
    protected void thucHienTangGiaVoiVPPDuocTimKiem(ArrayList<VPP> dsVPP_Search){
     if (TKInput_UpdateAllPrice.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập giá cần tăng","Error", JOptionPane.WARNING_MESSAGE);
            return ;
        }
        if (!isNumeric(TKInput_UpdateAllPrice.getText().trim())){
            JOptionPane.showMessageDialog(this, "Nhập sai định dạng giá","Error", JOptionPane.WARNING_MESSAGE);
            return ;
        }
        double extraMoney = (Double.parseDouble(TKInput_UpdateAllPrice.getText().trim()));
        //System.out.println(extraMoney);
        VanPhongPham_Connect vpc = new VanPhongPham_Connect();
        for (VPP vp: dsVPP_Search){
            vpc.updatePrice(vp.getMaVPP(), (vp.getGiaBan()+extraMoney));
        }
       hienThiToanBoVPP();
 }
    private void jButton_importExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_importExcelActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();

        // Chỉ định bộ lọc để chỉ cho phép chọn các tệp Excel
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Files", "xls");
        fileChooser.setFileFilter(filter);

        // Hiển thị cửa sổ Explorer và lấy tệp được chọn
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();
            //đọc file excel đó
            try {
                // Tạo đối tượng File từ đường dẫn
                File file = new File(filePath);

                // Đọc tệp Excel
                FileInputStream fis = new FileInputStream(file);
                Workbook workbook = new HSSFWorkbook(fis);

                // Lấy ra sheet đầu tiên từ workbook
                Sheet sheet = workbook.getSheetAt(0);
                
                //Xóa tất cả các dòng trong bảng nhân viên
                dtmVPP.setRowCount(0);

                // Duyệt qua các dòng trong sheet
                for (int rowIndex = 0; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                    if (rowIndex == 0) {
                        continue; // Bỏ qua dòng đầu tiên
                    }
                    
                    Row row = sheet.getRow(rowIndex);
                    
                    String[] rowData = new String[dtmVPP.getColumnCount()];

                    // Duyệt qua các ô trong dòng
                    for (int columnIndex = 0; columnIndex < dtmVPP.getColumnCount(); columnIndex++) {
                        Cell cell = row.getCell(columnIndex);
                        
                        // Chuyển đổi giá trị của ô thành kiểu String và lưu vào mảng rowData
                        String cellValue = "";
                        if (cell != null) {
                            if (cell.getCellType() == CellType.STRING) {
                                cellValue = cell.getStringCellValue();
                            } else if (cell.getCellType() == CellType.NUMERIC) {
                                if (DateUtil.isCellDateFormatted(cell)) {
                                    // Kiểm tra nếu là giá trị ngày tháng
                                    Date dateValue = cell.getDateCellValue();
                                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                                    cellValue = dateFormat.format(dateValue);
                                } else {
                                    cellValue = String.format("%.0f",cell.getNumericCellValue()); 
                                }
                            } else if (cell.getCellType() == CellType.BLANK) {
                                cellValue = "";
                            }
                        }

                        rowData[columnIndex] = cellValue;
                    }

                    // Thêm dòng dữ liệu vào mô hình dtmNhanVien
                    dtmVPP.addRow(rowData);
                }

                // Đóng FileInputStream và workbook
                fis.close();
                workbook.close();

                // Cập nhật bảng NVTable với mô hình dtmNhanVien
                jTable_VPP.setModel(dtmVPP);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        jButton_ThemTuExcel.setEnabled(true);
    }//GEN-LAST:event_jButton_importExcelActionPerformed

    private void jButton_Accpet_TangGiaByNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Accpet_TangGiaByNCCActionPerformed
        // TODO add your handling code here:
        if (TKInput_UpdateAllPriceNCC.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập giá cần tăng","Error", JOptionPane.WARNING_MESSAGE);
            return ;
        }
        if (!isNumeric(TKInput_UpdateAllPriceNCC.getText().trim())){
            JOptionPane.showMessageDialog(this, "Nhập sai định dạng giá","Error", JOptionPane.WARNING_MESSAGE);
            return ;
        }
         double extraMoney = (Double.parseDouble(TKInput_UpdateAllPriceNCC.getText().trim()));
        //System.out.println(extraMoney);
         NhaCungCap_VPP ncc = (NhaCungCap_VPP) NCCInput_TangGia.getSelectedItem();
         VanPhongPham_Connect vc = new VanPhongPham_Connect();
         dsNCC = vc.layVPPTheoNCC(ncc.getMaNCCVPP());
        
        for (VPP vp: dsNCC){
             vc.updatePrice(vp.getMaVPP(), (vp.getGiaBan()+extraMoney));
        }
       hienThiToanBoVPP();
    }//GEN-LAST:event_jButton_Accpet_TangGiaByNCCActionPerformed

    private void jButton_CancelNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CancelNCCActionPerformed
        // TODO add your handling code here:
        TKInput_UpdateAllPriceNCC.setText("");
    }//GEN-LAST:event_jButton_CancelNCCActionPerformed

    private void jButton_Accpet_TangGiaDoanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Accpet_TangGiaDoanhMucActionPerformed
        // TODO add your handling code here:
        if (TKInput_UpdateAllPriceDoanhMuc.getText().equals("") || TK_DanhMucInput_TangGia.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Nhập thiếu dữ liệu cho việc tăng giá","Error", JOptionPane.WARNING_MESSAGE);
            return ;
        }
        if (!isNumeric(TKInput_UpdateAllPriceDoanhMuc.getText().trim())){
            JOptionPane.showMessageDialog(this, "Nhập sai định dạng giá","Error", JOptionPane.WARNING_MESSAGE);
            return ;
        }
        double extraMoney = (Double.parseDouble(TKInput_UpdateAllPriceDoanhMuc.getText().trim()));
        String dm = TK_DanhMucInput_TangGia.getText();
        VanPhongPham_Connect vpc = new VanPhongPham_Connect();
        dssDanhMuc = vpc.laySachTheoDanhMuc(dm);
        int ret =JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn tăng doanh mục này (Vui lòng nhập đúng doanh mục!) ?", "Xác Nhận Tăng Giá", JOptionPane.OK_CANCEL_OPTION);
        if(ret==JOptionPane.OK_OPTION) {
           for (VPP vp: dssDanhMuc){
              
            vpc.updatePrice(vp.getMaVPP(), (vp.getGiaBan()+extraMoney));
        } 
        }
        
       hienThiToanBoVPP();
    }//GEN-LAST:event_jButton_Accpet_TangGiaDoanhMucActionPerformed

    private void jButton_CancelDoanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CancelDoanhMucActionPerformed
        // TODO add your handling code here:
        TK_DanhMucInput_TangGia.setText("");
        TKInput_UpdateAllPriceDoanhMuc.setText("");
    }//GEN-LAST:event_jButton_CancelDoanhMucActionPerformed

    private void jButton_ThemTuExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ThemTuExcelActionPerformed
        // TODO add your handling code here:
        int ret=JOptionPane.showConfirmDialog(null, "Bạn muốn thêm tất cả văn phòng phẩm có trong bảng?", "xác nhận xác nhận để thêm", JOptionPane.OK_CANCEL_OPTION);
        if(ret==JOptionPane.OK_OPTION){
            int dem = 0;
           
            VanPhongPham_Connect vc = new VanPhongPham_Connect();
            NhaCungCapVPP_Connect nc = new NhaCungCapVPP_Connect();
            //lặp qua tất cả các dòng của bảng
            for (int i=0; i< jTable_VPP.getRowCount(); i++){
                
                VPP vp = new VPP ();
                
                vp.setMaVPP(jTable_VPP.getValueAt(i, 0).toString());
                vp.setTenVPP(jTable_VPP.getValueAt(i, 1).toString());
             
                
                NhaCungCap_VPP cv = nc.TimTenNCC(jTable_VPP.getValueAt(i, 2).toString());
                vp.setMaNCC(cv.getMaNCCVPP());
                vp.setDanhMuc((String) jTable_VPP.getValueAt(i, 3));
                vp.setSoLuong( Integer.parseInt(jTable_VPP.getValueAt(i, 4)+""));
                vp.setGiaBan( Double.parseDouble(jTable_VPP.getValueAt(i, 5)+"") );
		vp.setDiscount(Integer.parseInt(jTable_VPP.getValueAt(i, 6)+""));
                if(vc.kiemTraTonTai(vp.getMaVPP())==true) JOptionPane.showMessageDialog(null, "Mã văn phòng phẩm "+vp.getMaVPP()+" đã tồn tại!");
                else{
                    int active = vc.themMoi(vp);
                    if(active<=0) JOptionPane.showMessageDialog(null, "Thêm mới "+vp.getMaVPP()+" thất bại!");
                    else dem++;
                }
            }
            if(dem == jTable_VPP.getRowCount()) hienThiToanBoVPP();
        }
    }//GEN-LAST:event_jButton_ThemTuExcelActionPerformed

    private void jButton_RefreshSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RefreshSearchActionPerformed
        // TODO add your handling code here:
        hienThiToanBoVPP();
    }//GEN-LAST:event_jButton_RefreshSearchActionPerformed
protected void xuLyXoa(String maVPP) {
    VanPhongPham_Connect sachXoa = new VanPhongPham_Connect();
    int active= sachXoa.Xoa(maVPP);
    if(active > 0)
    {
            JOptionPane.showMessageDialog(null, "Xóa thành công!");
            hienThiToanBoVPP();
    }
    else
    {
            JOptionPane.showMessageDialog(null, "Xóa thất bại");	
    }

}


//Chỉnh Sửa

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<NhaCungCap_VPP> NCCInput;
    private javax.swing.JComboBox<NhaCungCap_VPP> NCCInput_TangGia;
    private javax.swing.JLabel NhanTenLabel;
    private javax.swing.JTextField TKInput_Discount;
    private javax.swing.JTextField TKInput_DoanhMuc;
    private javax.swing.JTextField TKInput_GiaBan;
    private javax.swing.JTextField TKInput_MaVPP;
    private javax.swing.JTextField TKInput_SoLuong;
    private javax.swing.JTextField TKInput_TenVPP;
    private javax.swing.JTextField TKInput_UpdateAllPrice;
    private javax.swing.JTextField TKInput_UpdateAllPriceDoanhMuc;
    private javax.swing.JTextField TKInput_UpdateAllPriceNCC;
    private javax.swing.JTextField TK_DanhMucInput;
    private javax.swing.JTextField TK_DanhMucInput_TangGia;
    private javax.swing.JTextField TK_TenVPPInput;
    private javax.swing.JButton jButton_Accpet_Search;
    private javax.swing.JButton jButton_Accpet_TangGiaByNCC;
    private javax.swing.JButton jButton_Accpet_TangGiaDoanhMuc;
    private javax.swing.JButton jButton_Cancel;
    private javax.swing.JButton jButton_CancelDoanhMuc;
    private javax.swing.JButton jButton_CancelNCC;
    private javax.swing.JButton jButton_ChinhSua;
    private javax.swing.JButton jButton_NhapLai;
    private javax.swing.JButton jButton_RefreshSearch;
    private javax.swing.JButton jButton_Search;
    private javax.swing.JButton jButton_ThemTuExcel;
    private javax.swing.JButton jButton_ThemVPP;
    private javax.swing.JButton jButton_XoaVPP;
    private javax.swing.JButton jButton_importExcel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel_Discount;
    private javax.swing.JLabel jLabel_Discount1;
    private javax.swing.JLabel jLabel_Discount2;
    private javax.swing.JLabel jLabel_Discount3;
    private javax.swing.JLabel jLabel_GiaBan;
    private javax.swing.JLabel jLabel_Loc;
    private javax.swing.JLabel jLabel_Loc1;
    private javax.swing.JLabel jLabel_MaNXB;
    private javax.swing.JLabel jLabel_MaSach;
    private javax.swing.JLabel jLabel_SoLuong;
    private javax.swing.JLabel jLabel_TenSach;
    private javax.swing.JLabel jLabel_TheLoai;
    private javax.swing.JLabel jLabel_Top;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel_Center;
    private javax.swing.JPanel jPanel_Data;
    private javax.swing.JPanel jPanel_Top;
    private javax.swing.JPanel jPanel_TopFunction;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable_VPP;
    // End of variables declaration//GEN-END:variables

    void showWindow() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new QuanLyVPP("Quản lý văn phòng phẩm", MaNV).setVisible(true);
            }
        });
    }

    
}
