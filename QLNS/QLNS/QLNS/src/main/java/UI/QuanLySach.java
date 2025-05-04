/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import Connect.CTHD_Connect;
import Connect.DM_Connect;
import Connect.HoaDon_Connect;
import Connect.DM_Connect;
import Connect.NXB_Connect;
import Connect.Sach_Connect;
import Model.DM;
import Model.CTHD;
import Model.HoaDon;
import Model.DM;
import Model.NXB;
import Model.DM;
import Model.Sach;
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

public class QuanLySach extends javax.swing.JFrame {

    /**
     * Creates new form QuanLySach
     */
 // fields : các thuộc tính 
    private String MaHD = null;
    private String MaNV = null;
    private DefaultTableModel dtmSach;  // bảng sách trống 
    private ArrayList<DM> dsdm = null;        // danh sách các danh mục 
    private ArrayList<NXB> dsnxb = null;      // danh sách các nhà xuất bản 
    private ArrayList<Sach> dsChung = null;   // danh sách sách lấy theo tên + tác giả 
    private ArrayList<Sach> dss = null;       // danh sách sách hiện có 
    private ArrayList<Sach> dssTacGia = null; // danh sách tác giả 
    private ArrayList<Sach> dss_tensach = null; // danh sách sách theo tên sách 
    private ArrayList<Sach> dssByNXB = null;   // danh sách theo NXB

    
//constructor : Hàm khởi tạo này thiết lập cửa sổ giao diện và khởi tạo dữ liệu ban đầu cho quản lý sách 
    public QuanLySach(String title, String maNV) {
        initComponents();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("images/books_30px.png"));
        this.setTitle(title);
        this.setLocationRelativeTo(null);
        // Khi cửa sổ bị đóng, nó sẽ được giải phóng (disposed) khỏi bộ nhớ, nhưng ứng dụng chính (nếu có cửa sổ khác) vẫn có thể chạy.
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        MaNV = maNV;
        hienThiToanBoSach();
        hienThiToanBoDanhMuc();
        hienThiToanBoNhaXuatBan();

    }

 // Hiển thị toàn bộ sách lên giao diện bảng sách (jTable_Books )
    private void hienThiToanBoSach() {
        // 1. lấy toàn bộ sách = dss
        Sach_Connect sachConn = new Sach_Connect();
        dss = sachConn.layToanBoSach();
       // 2. tạo bảng chứa sách trên giao diện = dtmSach
        dtmSach = new DefaultTableModel();
        dtmSach.addColumn("Mã sách");
        dtmSach.addColumn("Tên NXB");
        dtmSach.addColumn("Tên Sách");
        dtmSach.addColumn("Thể loại");
        dtmSach.addColumn("Tác giả");
        dtmSach.addColumn("Số lượng");
        dtmSach.addColumn("Giá Bán (VNĐ)");
        dtmSach.addColumn("Giảm Giá (%)");
        dtmSach.setRowCount(0); // xóa tất cả các hàng => đảm bảo bảng k có data nào
        // 3. Thêm dữ liệu vào bảng sách (dtmSach)
        for (Sach s : dss) {
            Vector<Object> vec = new Vector<Object>();
            vec.add(s.getMaSach());
            vec.add(s.getMaNXB());
            vec.add(s.getTenSach());
            vec.add(s.getTenDM());
            vec.add(s.getTacGia());
            vec.add(s.getSoLuong());
            vec.add(s.getGiaBan());
            vec.add(s.getDiscount());
            dtmSach.addRow(vec); // thêm sách vào bảng sách (dtmSach)
        }
        // 4. gán mô hình cho bảng hiển thị
        jTable_Books.setModel(dtmSach);
    }

    
// Hàm hiển thị toàn bộ nhà xuất bản 
    private void hienThiToanBoNhaXuatBan() {
        // 1. tạo đối tượng xử lý kết nối + truy vấn CSDL "NXB"
        NXB_Connect nxbconn = new NXB_Connect();
        dsnxb = nxbconn.layToanBoNhaXuatBan();
        // 2. Xóa các mục hiện tại trong  Mã NXB + NXB
        // => Đảm bảo danh sách được làm mới hoàn toàn trước khi thêm dữ liệu mới, tránh trùng lặp hoặc dữ liệu cũ.
        // removeAllItems() : xóa tất cả các mục hiện tại trong cả 2 jComboBox
        NXBInput.removeAllItems();
        NXBInput_TangGia.removeAllItems();
        // 3. Tạo NXB mới để thêm lựa chọn "tất cả " trong khi chọn NXB
        // addItem() :Thêm một mục (item) vào danh sách thả xuống (JComboBox), để mục đó hiển thị trong danh sách các lựa chọn mà người dùng có thể chọn.
        NXB nxb = new NXB();
        nxb.setMaNXB("0");
        nxb.setTenNXB("Tất cả"); //=> "tất cả" ứng với mã NXB = 0 
        NXBInput.addItem(nxb);
        // 4. duyệt lần lượt toàn bộ NXB => thêm lân lượt các NXB vào 2 jComboBox ( Mã NXB + NXB)
        for (NXB s : dsnxb) {
            NXBInput.addItem(s);
            NXBInput_TangGia.addItem(s);
        }

    }

 
    
// Hiển thị toàn bộ danh mục 
    private void hienThiToanBoDanhMuc() {
        // 1. tạo đối tượng xử lý kết nối + truy vấn CSDL "DANHMUC"

        DM_Connect nxbconn = new DM_Connect();
        // 2. lấy toàn bộ danh mục  = dsdm
        dsdm = nxbconn.layToanBoDanhMuc();
        // 3. Tạo DM mới để Thêm lựa chọn "Tất cả" khi chọn danh mục
        DanhM.removeAllItems();
        DM dm = new DM();
        dm.setMaDM("0");
        dm.setTenDM("Tất cả");
        DanhM.addItem(dm.getTenDM());
        // 4.duyệt lần lượt toàn bộ DM => thêm lân lượt các DM vào JComboBox DM
        for (DM s : dsdm) {
            DanhM.addItem(s.getTenDM());
        }

    }


    
// kiểm tra xem một chuỗi (String) có thể được chuyển đổi thành một số nguyên (Integer) hay không

    public static boolean isNumeric(String string) {
        int intValue; // có thể bỏ 
         // 1. Kiểm tra đầu vào có hợp lệ hay không : phải khác rỗng hoặc null
        if (string == null || string.equals("")) {
            return false;
        }
        // 2. chuyển đổi chuỗi thành số nguyên
        try {
            intValue = Integer.parseInt(string);
            return true;
        } 
        catch (NumberFormatException e) {
        }
        return false;
    }


// kiểm tra xem một chuỗi (String) có thể được chuyển đổi thành một số thực (double) hay không.

    public static boolean isNumeric_Double(String string) {
        double intValue; // có thể bỏ 

        // 1. Kiểm tra đầu vào có hợp lệ hay không : phải khác rỗng hoặc null
        if (string == null || string.equals("")) {
            return false;
        }
        // 2. chuyển đổi chuỗi thành số thực
        try {
            intValue = Double.parseDouble(string);
            return true;
        } 
        catch (NumberFormatException e) {
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

        jLabel_Discount1 = new javax.swing.JLabel();
        TKInput_UpdateAllPrice = new javax.swing.JTextField();
        jButton_Accpet = new javax.swing.JButton();
        jButton_Cancel = new javax.swing.JButton();
        jPanel_Top = new javax.swing.JPanel();
        jPanel_TopFunction = new javax.swing.JPanel();
        jButton_ChinhSua = new javax.swing.JButton();
        jButton_XoaSach = new javax.swing.JButton();
        jButton_ThemSach = new javax.swing.JButton();
        jLabel_Top = new javax.swing.JLabel();
        jPanel_Data = new javax.swing.JPanel();
        jLabel_MaSach = new javax.swing.JLabel();
        jLabel_TenSach = new javax.swing.JLabel();
        jLabel_MaNXB = new javax.swing.JLabel();
        jLabel_TacGia = new javax.swing.JLabel();
        jLabel_GiaBan = new javax.swing.JLabel();
        jLabel_TheLoai = new javax.swing.JLabel();
        jLabel_SoLuong = new javax.swing.JLabel();
        NXBInput = new javax.swing.JComboBox<NXB>();
        TKInput_MaSach = new javax.swing.JTextField();
        TKInput_TenSach = new javax.swing.JTextField();
        TKInput_TacGia = new javax.swing.JTextField();
        TKInput_SoLuong = new javax.swing.JTextField();
        TKInput_GiaBan = new javax.swing.JTextField();
        jLabel_Discount = new javax.swing.JLabel();
        TKInput_Discount = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel_Discount3 = new javax.swing.JLabel();
        TKInput_UpdateAllPriceNXB = new javax.swing.JTextField();
        jButton_AccpetTangGiaNXB = new javax.swing.JButton();
        jButton_CancelNXB = new javax.swing.JButton();
        NXBInput_TangGia = new javax.swing.JComboBox<NXB>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        DanhM = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        jButton_NhapLai = new javax.swing.JButton();
        jPanel_Center = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Books = new javax.swing.JTable();
        jLabel_Loc = new javax.swing.JLabel();
        TKInput = new javax.swing.JTextField();
        jButton_Search = new javax.swing.JButton();
        jLabel_Loc1 = new javax.swing.JLabel();
        TKInput1 = new javax.swing.JTextField();
        NhanTenLabel = new javax.swing.JLabel();
        jButton_RefreshSearch = new javax.swing.JButton();

        jLabel_Discount1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel_Discount1.setText("Tăng giá đồng loạt");

        jButton_Accpet.setText("OK");

        jButton_Cancel.setText("X");
        jButton_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CancelActionPerformed(evt);
            }
        });

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

        jButton_XoaSach.setBackground(new java.awt.Color(255, 102, 102));
        jButton_XoaSach.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_XoaSach.setForeground(new java.awt.Color(255, 255, 255));
        jButton_XoaSach.setText("Xoá Sách");
        jButton_XoaSach.setMaximumSize(new java.awt.Dimension(150, 40));
        jButton_XoaSach.setMinimumSize(new java.awt.Dimension(150, 40));
        jButton_XoaSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_XoaSachActionPerformed(evt);
            }
        });

        jButton_ThemSach.setBackground(new java.awt.Color(51, 255, 153));
        jButton_ThemSach.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_ThemSach.setForeground(new java.awt.Color(255, 255, 255));
        jButton_ThemSach.setText("Thêm Sách");
        jButton_ThemSach.setMaximumSize(new java.awt.Dimension(150, 40));
        jButton_ThemSach.setMinimumSize(new java.awt.Dimension(150, 40));
        jButton_ThemSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ThemSachActionPerformed(evt);
            }
        });

        jLabel_Top.setFont(new java.awt.Font("Segoe UI", 3, 28)); // NOI18N
        jLabel_Top.setForeground(new java.awt.Color(0, 153, 204));
        jLabel_Top.setText("Quản Lý Sách");

        jPanel_Data.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel_MaSach.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel_MaSach.setText("Mã Sách");

        jLabel_TenSach.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel_TenSach.setText("Tên Sách");

        jLabel_MaNXB.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel_MaNXB.setText("Mã NXB");

        jLabel_TacGia.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel_TacGia.setText("Tác Giả");

        jLabel_GiaBan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel_GiaBan.setText("Giá Bán");

        jLabel_TheLoai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel_TheLoai.setText("Danh Mục");

        jLabel_SoLuong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel_SoLuong.setText("Số Lượng");

        NXBInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel_Discount.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel_Discount.setText("Giảm Giá");

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel_Discount3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel_Discount3.setText("Tăng giá theo NXB");

        jButton_AccpetTangGiaNXB.setText("OK");
        jButton_AccpetTangGiaNXB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AccpetTangGiaNXBActionPerformed(evt);
            }
        });

        jButton_CancelNXB.setText("X");
        jButton_CancelNXB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CancelNXBActionPerformed(evt);
            }
        });

        NXBInput_TangGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel1.setText("Giá:");

        jLabel2.setText("NXB:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NXBInput_TangGia, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TKInput_UpdateAllPriceNXB, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel_Discount3)
                        .addGap(160, 160, 160)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_CancelNXB, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_AccpetTangGiaNXB, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Discount3)
                    .addComponent(jButton_AccpetTangGiaNXB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NXBInput_TangGia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TKInput_UpdateAllPriceNXB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_CancelNXB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)))
                .addContainerGap())
        );

        jLabel_Discount.setIcon(new ImageIcon("images/discount_28px.png"));

        javax.swing.GroupLayout jPanel_DataLayout = new javax.swing.GroupLayout(jPanel_Data);
        jPanel_Data.setLayout(jPanel_DataLayout);
        jPanel_DataLayout.setHorizontalGroup(
            jPanel_DataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_DataLayout.createSequentialGroup()
                .addGroup(jPanel_DataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_DataLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel_DataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_MaSach)
                            .addComponent(jLabel_MaNXB)
                            .addComponent(jLabel_TenSach))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel_DataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_DataLayout.createSequentialGroup()
                                .addGroup(jPanel_DataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TKInput_MaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel_DataLayout.createSequentialGroup()
                                        .addComponent(TKInput_TenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                                        .addComponent(jLabel_SoLuong)))
                                .addGap(28, 28, 28))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_DataLayout.createSequentialGroup()
                                .addGroup(jPanel_DataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel_DataLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel_TacGia))
                                    .addGroup(jPanel_DataLayout.createSequentialGroup()
                                        .addComponent(NXBInput, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)

                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)

                                        .addComponent(jLabel_TheLoai)))
                                .addGap(40, 40, 40)))
                        .addGroup(jPanel_DataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TKInput_TacGia, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                            .addComponent(TKInput_SoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                            .addComponent(DanhM, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))

                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)

                        .addGroup(jPanel_DataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel_GiaBan)
                            .addComponent(jLabel_Discount)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_DataLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)))
                .addGroup(jPanel_DataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_DataLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(TKInput_GiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_DataLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(TKInput_Discount, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(55, 55, 55))
        );
        jPanel_DataLayout.setVerticalGroup(
            jPanel_DataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_DataLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(jPanel_DataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TKInput_GiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TKInput_TacGia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_MaSach)
                    .addComponent(TKInput_MaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_TacGia)
                    .addComponent(jLabel_GiaBan))
                .addGap(25, 25, 25)
                .addGroup(jPanel_DataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_MaNXB)
                    .addComponent(NXBInput, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_TheLoai)
                    .addComponent(jLabel_Discount)
                    .addComponent(TKInput_Discount, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DanhM, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel_DataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

                    .addGroup(jPanel_DataLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel_DataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_TenSach)
                            .addComponent(TKInput_TenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))

                    .addGroup(jPanel_DataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TKInput_SoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel_SoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        jLabel_MaSach.setIcon(new ImageIcon("images/repository_28px.png"));
        jLabel_TenSach.setIcon(new ImageIcon("images/cbz_28px.png"));
        jLabel_MaNXB.setIcon(new ImageIcon("images/link_28px.png"));
        jLabel_TacGia.setIcon(new ImageIcon("images/customer_28px.png"));
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

        javax.swing.GroupLayout jPanel_TopFunctionLayout = new javax.swing.GroupLayout(jPanel_TopFunction);
        jPanel_TopFunction.setLayout(jPanel_TopFunctionLayout);
        jPanel_TopFunctionLayout.setHorizontalGroup(
            jPanel_TopFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_TopFunctionLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel_Top)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_ThemSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(jButton_ChinhSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(jButton_NhapLai, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(jButton_XoaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addComponent(jPanel_Data, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel_TopFunctionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator2)
                .addContainerGap())
        );
        jPanel_TopFunctionLayout.setVerticalGroup(
            jPanel_TopFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_TopFunctionLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel_TopFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_ThemSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_ChinhSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_XoaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Top, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_NhapLai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_Data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jButton_ChinhSua.setIcon(new ImageIcon("images/book_and_pencil_25px.png"));
        jButton_XoaSach.setIcon(new ImageIcon("images/remove_book_25px.png"));
        jButton_ThemSach.setIcon(new ImageIcon("images/add_book_25px.png"));
        jLabel_Top.setIcon(new ImageIcon("images/add_book_40px.png"));
        jButton_ChinhSua.setIcon(new ImageIcon("images/hand_with_pen_25px.png"));

        jPanel_Top.add(jPanel_TopFunction);

        getContentPane().add(jPanel_Top, java.awt.BorderLayout.PAGE_START);

        jSeparator1.setBackground(new java.awt.Color(102, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(0, 102, 204));

        jTable_Books.setBackground(new java.awt.Color(244, 243, 243));
        jTable_Books.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable_Books.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_BooksMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Books);

        jLabel_Loc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel_Loc.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_Loc.setText("Tên Sách:");
        jLabel_Loc.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        TKInput.setToolTipText("Tên Sách");

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
        jLabel_Loc1.setText("Tên Tác Giả:");
        jLabel_Loc1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        TKInput1.setToolTipText("Tên Sách");

        NhanTenLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        NhanTenLabel.setForeground(new java.awt.Color(0, 153, 153));
        NhanTenLabel.setText("Nhập tên sách và tên tác giả");

        jButton_RefreshSearch.setBackground(new java.awt.Color(255, 204, 204));
        jButton_RefreshSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_RefreshSearch.setForeground(new java.awt.Color(255, 255, 255));
        jButton_RefreshSearch.setText("!");
        jButton_RefreshSearch.setMaximumSize(new java.awt.Dimension(150, 40));
        jButton_RefreshSearch.setMinimumSize(new java.awt.Dimension(150, 40));
        jButton_RefreshSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_RefreshSearchMouseClicked(evt);
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
                        .addGroup(jPanel_CenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_CenterLayout.createSequentialGroup()
                                .addGap(514, 514, 514)
                                .addComponent(NhanTenLabel))
                            .addGroup(jPanel_CenterLayout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(jLabel_Loc)
                                .addGap(18, 18, 18)
                                .addComponent(TKInput, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78)
                                .addComponent(jLabel_Loc1)
                                .addGap(18, 18, 18)
                                .addComponent(TKInput1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_RefreshSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 90, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel_CenterLayout.setVerticalGroup(
            jPanel_CenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_CenterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(NhanTenLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel_CenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Loc, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TKInput, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Loc1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TKInput1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_RefreshSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        jLabel_Loc.setIcon(new ImageIcon("images/filter_48px.png"));
        jButton_Search.setIcon(new ImageIcon("images/search_25px.png"));
        jLabel_Loc.setIcon(new ImageIcon("images/filter_48px.png"));
        jButton_RefreshSearch.setIcon(new ImageIcon("images/refresh_30px.png"));

        getContentPane().add(jPanel_Center, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
// Hàm xử lý khi nhấn " cập nhật " lại các thuộc tính của sách
    private void jButton_ChinhSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ChinhSuaActionPerformed

        // 1. Kiểm tra dữ liệu nhập vào => đảm bảo k được nhập thiếu trường nào trong 8 thuộc tính 
        if (TKInput_MaSach.getText().length() == 0
                || TKInput_TenSach.getText().length() == 0 || TKInput_TacGia.getText().length() == 0
                || TKInput_GiaBan.getText().length() == 0
                || TKInput_SoLuong.getText().length() == 0 || TKInput_Discount.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Nhập thiếu dữ liệu !", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // 2. lựa chọn nhà xuất bản (NXB)
        // Phương thức getSelectedItem() trong Java  để lấy giá trị đáng được người dùng chọn hiện tại 
        NXB manxb = (NXB) NXBInput.getSelectedItem(); // Lấy NXB được chọn từ danh sách NXB có sẵn (NXBInput)
        if (manxb == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhà xuất bản!", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // 3. Kiểm tra lựa chọn danh mục (Thể loại)
        Object tendm = DanhM.getSelectedItem(); //Lấy danh mục được chọn từ danh sách Danh Mục có sẵn (DanhM)
        // nếu chưa chọn danh mục => lỗi 
        if (tendm == null) { 
            JOptionPane.showMessageDialog(this, "Vui lòng chọn danh mục!", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        // nếu chọn rồi nhưng mà là "tất cả"  => lỗi 
        } else if (tendm.toString().matches("Tất cả")) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn danh mục!", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // 4. Tạo đối tượng sách (Sach) và gán 5/8 thuộc tính 
        Sach s = new Sach();
        s.setMaSach(TKInput_MaSach.getText().trim()); // Gán mã sách (loại bỏ khoảng trắng  đầu + cuối bằng trim()).
        s.setTenSach(TKInput_TenSach.getText().trim());
        s.setMaNXB(manxb.getMaNXB());

        s.setTacGia(TKInput_TacGia.getText().trim());

        s.setTenDM(tendm.toString());

        // 5. Kiểm tra định dạng số : giá bán phải số thực , số lượng và giảm giá phải là số nguyên 
        if (!isNumeric_Double(TKInput_GiaBan.getText().trim())
                || !isNumeric(TKInput_SoLuong.getText().trim())
                || !isNumeric(TKInput_Discount.getText().trim())) {
            JOptionPane.showMessageDialog(this, "Giá bán, Số lượng hoặc Giảm giá đã nhập sai định dạng!\nVui lòng thử lại!", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // 6. Gán các giá trị cho 3 thuộc tính  còn lại cho sách 
        s.setGiaBan(Double.parseDouble(TKInput_GiaBan.getText().trim()));
        s.setSoLuong(Integer.parseInt(TKInput_SoLuong.getText().trim()));
        s.setDiscount(Integer.parseInt(TKInput_Discount.getText().trim()));

        
        // 7. Hiển thị thông báo kết quả
        Sach_Connect sachconnect = new Sach_Connect();
        int active = sachconnect.update(s); // update sẽ trả về 1 = thành công , 0 nếu k có cập nhật , -1 nếu lỗi (Exception)
         if (active > 0) {

            JOptionPane.showMessageDialog(null, "Chỉnh sửa thông tin sách thành công");
        } else if (active == 0) { // sai mã sách , ..
            JOptionPane.showMessageDialog(this, "Không tìm thấy sách để chỉnh sửa!", "Error", JOptionPane.WARNING_MESSAGE);
        } else { // có thể do lỗi kết nối hoặc dữ liệu
            JOptionPane.showMessageDialog(this, "Chỉnh sửa sách thất bại. Kiểm tra lại kết nối hoặc dữ liệu!", "Error", JOptionPane.ERROR_MESSAGE);
        }
         
        //8.  Hiển thị kết quả  bảng sau khi "cập nhật" 
        hienThiToanBoSach();
    }//GEN-LAST:event_jButton_ChinhSuaActionPerformed

    
    

    //khi nhấn "thêm sách " để thêm sách mới 
    private void jButton_ThemSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ThemSachActionPerformed
        // 1. Kiểm tra dữ liệu nhập vào 6 thuộc tính   => đảm bảo k được nhập thiếu thuộc tính nào trong 6/8 thuộc tính 
        if (TKInput_MaSach.getText().length() == 0 || TKInput_TenSach.getText().length() == 0
                || TKInput_TacGia.getText().length() == 0 || TKInput_GiaBan.getText().length() == 0
                || TKInput_SoLuong.getText().length() == 0 || TKInput_Discount.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Nhập thiếu dữ liệu", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        //2.Chọn 2/8 thuộc tính còn lại (NXB , Danh Mục) từ 2 JcomboBox
        // . Lấy tên NXB từ JComboBox "Mã NXB"
        // Phương thức getSelectedItem() trong Java  để lấy giá trị đáng được người dùng chọn hiện tại 
        NXB nxb = (NXB) NXBInput.getSelectedItem();// Lấy NXB được chọn từ danh sách NXB có sẵn (NXBInput)
        if (nxb == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhà xuất bản!", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // . Lấy tên danh mục đối tượng JComboBox "Danh Mục" (DM) 
        Object selectedItem = DanhM.getSelectedItem(); // có thể dùng biến kiểu Object để chứa bất kỳ kiểu đối tượng nào
        if (selectedItem.toString().matches("Tất cả")) {
            JOptionPane.showMessageDialog(this, "Dữ liệu danh mục không hợp lệ!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 3. Tạo đối tượng Sach mới (s) + thêm lần lượt 8 thuộc tính vừa nhập vào sách (s)
        Sach s = new Sach();
        for (Sach s_check : dss) {
            if (s_check.getMaSach().equals(TKInput_MaSach.getText())) {
                JOptionPane.showMessageDialog(this, "Sách đã tồn tại", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        // thêm 8 thuộc tính cho sách
        s.setMaSach(TKInput_MaSach.getText());
        s.setTenSach(TKInput_TenSach.getText());
        s.setMaNXB(nxb.getMaNXB());
        s.setTacGia(TKInput_TacGia.getText());
        s.setTenDM(selectedItem.toString()); // 
        // kiểm tra xem :
        // + giá bán có đúng là số thực không 
        // + số lượng + giảm giá có đúng là số nguyên 
        if (!isNumeric_Double(TKInput_GiaBan.getText()) || !isNumeric(TKInput_SoLuong.getText()) || !isNumeric(TKInput_Discount.getText())) {
            JOptionPane.showMessageDialog(this, "Giá bán, Số lượng hoặc Giảm giá đã nhập sai định dạng!\n Vui lòng thử lại!", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        s.setGiaBan(Double.parseDouble(TKInput_GiaBan.getText()));
        s.setSoLuong(Integer.parseInt(TKInput_SoLuong.getText()));
        s.setDiscount(Integer.parseInt(TKInput_Discount.getText()));
        // 4. Hiển thị thông báo Xác nhận thêm sách 
        int x = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn thêm sách", "Xác nhận thêm", JOptionPane.OK_CANCEL_OPTION);
        if (x == JOptionPane.OK_OPTION) {
            xuLyThemMoi(s);
        } else {
            return;
        }
    }//GEN-LAST:event_jButton_ThemSachActionPerformed

// xử lý khi muốn thêm mới sách 
// protected -> cho phép phương thức được truy cập trong cùng gói hoặc bởi các lớp con (nếu có kế thừa).
    protected void xuLyThemMoi(Sach s) {
        // 1. Khởi tạo đối tượng Sach_Connect 
        Sach_Connect themsach = new Sach_Connect();
        
        //2 .thực hiện thêm sách + kiểm tra kết quả 
        int active = themsach.themSachMoi(s);
        //Kiểm tra kết quả và xử lý
        if (active > 0) {
            JOptionPane.showMessageDialog(null, "Thêm mới thành công");
            TaoHDVaCTHD();
            // Làm sạch các trường nhập liệu
            TKInput_MaSach.setText("");
            TKInput_TenSach.setText("");
            TKInput_TacGia.setText("");
            TKInput_GiaBan.setText("");
            TKInput_SoLuong.setText("");
            TKInput_Discount.setText("");
            TKInput_MaSach.requestFocus();// Đặt con trỏ chuột vào trường "Mã Sách", sẵn sàng cho người dùng nhập sách tiếp theo.
            hienThiToanBoSach(); // Đảm bảo giao diện phản ánh dữ liệu mới nhất, hiển thị sách vừa được thêm.
        } else {
            JOptionPane.showMessageDialog(null, "Thêm mới thất bại");
        }
    }

    
// Tạo hóa đơn và CTHD
     private void TaoHDVaCTHD() {
        String HD = "HD";
        // 1. Khởi tạo và lấy mã hóa đơn mới với mã hóa đơn mới tính từ hóa đơn cuối cùng
        HoaDon_Connect tHD = new HoaDon_Connect();
        CTHD_Connect cthd = new CTHD_Connect();
        String lastmahd = tHD.LastMaHD();
        if (lastmahd == null) {
            MaHD = "HD01";
        } else {
            int sohd = Integer.parseInt(lastmahd.substring(2)) + 1; //bỏ đi hai chữ "HD" và công thêm 1 vào hai số phía sau
            if (sohd < 10) {
                MaHD = HD + "0" + String.valueOf(sohd);
            } else {
                MaHD = HD + String.valueOf(sohd);
            }
        }
        System.out.println(MaHD);
        System.out.println(MaNV);
        
        // 2. Tạo và thiết lập đối tượng HoaDon với 7 thuộc tính 
        HoaDon hd = new HoaDon();
        hd.setMaHD(MaHD); // Gán mã hóa đơn mới vừa tạo 
        hd.setMaNV(MaNV); // Gán mã nhân viên (MaNV) từ biến toàn cục (được truyền vào từ hàm khởi tạo QuanLySach
        Date date = new Date();
        // Lấy thời gian hiện tại bằng new Date() và định dạng thành chuỗi theo mẫu
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(date);
        hd.setNgaylap(currentTime);
        hd.setTongTien(Double.parseDouble(TKInput_GiaBan.getText()) * Double.parseDouble(TKInput_SoLuong.getText()));
        hd.setTrangThai(0);
        hd.setNhapSach(1); //Gán NhapSach = 1, biểu thị đây là hóa đơn nhập sách (khác với NhapSach = 0 cho hóa đơn bán sách).
        tHD.TaoHD(hd); // Gọi phương thức TaoHD từ HoaDon_Connect để thêm hóa đơn hd vào cơ sở dữ liệu.
        
        // 3. Tạo và thiết lập đối tượng CTHD với 5 thuộc tính       
        CTHD ct = new CTHD();
        ct.setMaHD(MaHD);
        ct.setMaSP(TKInput_MaSach.getText());
        ct.setDonGia(Double.parseDouble(TKInput_GiaBan.getText()));
        ct.setSoLuong(Integer.parseInt(TKInput_SoLuong.getText()));
        ct.setThanhTien(Double.parseDouble(TKInput_GiaBan.getText()) * Double.parseDouble(TKInput_SoLuong.getText()));
        CTHD_Connect ctCon = new CTHD_Connect();
        ctCon.ThemCT(ct);// gọi phương thức ThemCT để thêm đối tượng CTHD ct vào cơ sở dữ liệu.
    }

    
    
//Hàm thực hiện khi ấn "Tìm kiếm " sách 
// => Có 4 TH tìm kiếm 
    // TH1 : Không tìm theo gì  => hiện tất cả sách 
    // TH2 : Tìm theo tên sách 
    // TH3 : Tìm theo tên cả sách và tên tác giả 
    // TH4 : Tìm theo tên tác giả 
    private void jButton_SearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_SearchMouseClicked
        
       // 1. lẤY DANH SÁCH SÁCH THEO 3 TRƯỜNG HỢP (2,3,4)
        String ten = TKInput.getText();
        String tenTacGia = TKInput1.getText();
        Sach_Connect sachnxb1 = new Sach_Connect();
        dss_tensach = sachnxb1.laySachTheoMaTen(ten);         // tìm kiếm cho TH2
        dssTacGia = sachnxb1.laySachTheoTenTacGia(tenTacGia); // tìm kiếm cho TH4
        dsChung = sachnxb1.laySachTheoMaTenVaTenTacGia(ten, tenTacGia); // tìm kiếm cho TH3
        
        //2. Truy vấn theo 4 Trường Hợp
        //TH1 : Không tìm theo gì  => hiện tất cả sách 
        if (TKInput.getText().length() == 0 && TKInput1.getText().length() == 0) {
            hienThiToanBoSach();
        }
        
        // TH2: tìm kiếm theo tên sách(TKInput)
        if (TKInput.getText().length() != 0 && TKInput1.getText().length() == 0) {
            dtmSach.setRowCount(0);
            for (Sach s : dss_tensach) {
                Vector<Object> vec = new Vector<Object>();
                vec.add(s.getMaSach());
                vec.add(s.getMaNXB());
                vec.add(s.getTenSach());
                vec.add(s.getTenDM());
                vec.add(s.getTacGia());

                vec.add(s.getSoLuong());
                vec.add(s.getGiaBan());
                vec.add(s.getDiscount());
                dtmSach.addRow(vec);
            }
        } 
        
        // TH2: Tìm kiếm theo tên sách(TKInput) và tên tác giả(TKInput1)
        else if (TKInput.getText().length() != 0 && TKInput1.getText().length() != 0) {
            dtmSach.setRowCount(0);
            for (Sach s : dsChung) {
                Vector<Object> vec = new Vector<Object>();
                vec.add(s.getMaSach());
                vec.add(s.getMaNXB());
                vec.add(s.getTenSach());
                vec.add(s.getTenDM());
                vec.add(s.getTacGia());
                vec.add(s.getSoLuong());
                vec.add(s.getGiaBan());
                vec.add(s.getDiscount());
                dtmSach.addRow(vec);
            }
        } 
        
        //TH3: tìm kiếm theo tên tác giả (TKInput1)
        else if (TKInput.getText().length() == 0 && TKInput1.getText().length() != 0) {
            dtmSach.setRowCount(0);


            for (Sach s : dssTacGia) {
                Vector<Object> vec = new Vector<Object>();
                vec.add(s.getMaSach());
                vec.add(s.getMaNXB());
                vec.add(s.getTenSach());
                vec.add(s.getTenDM());
                vec.add(s.getTacGia());
                vec.add(s.getSoLuong());
                vec.add(s.getGiaBan());
                vec.add(s.getDiscount());
                dtmSach.addRow(vec);
            }
        }
    }//GEN-LAST:event_jButton_SearchMouseClicked

    
    
// Hàm thực hiện khi nhấn "Xoá sách"
    private void jButton_XoaSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_XoaSachActionPerformed
      
        int select = jTable_Books.getSelectedRow();
        if (select == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn sách muốn xoá", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String maSach = (String) jTable_Books.getValueAt(select, 0);
        int active = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa", "Xác Nhận Xóa", JOptionPane.OK_CANCEL_OPTION);
        if (active == JOptionPane.OK_OPTION) {
            xuLyXoa(maSach);
        }
    }//GEN-LAST:event_jButton_XoaSachActionPerformed

    
// Hàm xử lý khi ấn "Nhập Lại" sách 
    private void jButton_NhapLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_NhapLaiActionPerformed
        // Làm sạch các trường nhập liệu+ Đặt lại lựa chọn mặc định trong danh sách thả xuống
        TKInput_MaSach.setText("");
        TKInput_TenSach.setText("");
        NXBInput.setSelectedIndex(0);
        DanhM.setSelectedIndex(0); 
        TKInput_TacGia.setText("");
        TKInput_GiaBan.setText("");
        TKInput_SoLuong.setText("");
        TKInput_Discount.setText("");
        TKInput_MaSach.requestFocus(); // đặt con trỏ chuột (focus) vào TKInput_MaSach 
                                       // => người dùng có thể bắt đầu nhập thông tin ngay lập tức mà không cần nhấp chuột.
    }//GEN-LAST:event_jButton_NhapLaiActionPerformed

    
// Hàm xử lý khi click chuột chọn 1 sách (1 hàng ) trong bảng sách 
// => Lấy thông tin từ hàng đó để điền lên 8 Ô ở trên giao diện ( ô mã sách, ô tên sách,.....)
    private void jTable_BooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_BooksMouseClicked
        // 1. Kiểm tra hàng được chọn 
        // Chỉ số hàng (tính từ 0) nếu có hàng được chọn => -1 nếu không có hàng nào được chọn
        int select = jTable_Books.getSelectedRow();
        if (select == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng trong bảng!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
     
        // 2. Khởi tạo đối tượng và kết nối cơ sở dữ liệu NXB + DM
        NXB_Connect nxb_con = new NXB_Connect();
        DM_Connect dm_con = new DM_Connect(); // ko đc dùng , để dự phòng thôi 

       // 3. Tạo đối tượng sách mới + lấy thông tin 8 thuộc tính của sách 
        Sach s = new Sach();
        // Kiểm ra mã sách xem có hợp lệ k
        Object maSachObj = jTable_Books.getValueAt(select, 0);
        if (maSachObj == null) {
            JOptionPane.showMessageDialog(this, "Mã sách không hợp lệ!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        // 4. lấy thông tin 7/8 thuộc tính  (còn tên NXB lấy ở dưới )
        // 4 thuộc tính dạng chuỗi 
        s.setMaSach(maSachObj.toString());
        s.setTenSach((String) jTable_Books.getValueAt(select, 2));
        s.setTenDM((String) jTable_Books.getValueAt(select, 3));
        s.setTacGia((String) jTable_Books.getValueAt(select, 4));
        try {
            // ép giá trị cho 3 thuộc tính dạng số 
            s.setSoLuong(Integer.parseInt(jTable_Books.getValueAt(select, 5).toString()));
            s.setGiaBan(Double.parseDouble(jTable_Books.getValueAt(select, 6).toString()));
            s.setDiscount(Integer.parseInt(jTable_Books.getValueAt(select, 7).toString()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ trong bảng!", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // 5. Hiển thị lên giao diện 8 ô (trường nhập liệu)
        // 5.1 Điền thông tin vào giao diện cho 6/ 8 trường nhập liệu (còn Mã NXB + Danh Mục)
        TKInput_MaSach.setText(s.getMaSach());
        TKInput_TenSach.setText(s.getTenSach());
        TKInput_TacGia.setText(s.getTacGia());
        TKInput_GiaBan.setText(String.valueOf(s.getGiaBan()));
        TKInput_SoLuong.setText(String.valueOf(s.getSoLuong()));
        TKInput_Discount.setText(String.valueOf(s.getDiscount()));

        // 5.2 Cập nhật danh sách thả xuống cho nhà xuất bản (7/8 trường nhập liệu)
        String maNXB = nxb_con.TimTenNXBCheckBox(jTable_Books.getValueAt(select, 1).toString()).getMaNXB();// thuộc tính còn lại 
        if (maNXB == null || maNXB.length() < 3) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy nhà xuất bản hợp lệ!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        NXBInput.setSelectedIndex(Integer.parseInt(maNXB.substring(3)));
        
        // 5.3 Cập nhật danh sách thả xuống cho danh mục (8/8 trường nhập liệu)
        String maDM = jTable_Books.getValueAt(select, 3).toString();
        boolean isFoundDm = false;
        int indexMaDm = 0;
        // duyệt toàn bộ danh mục tìm xem có 
        for (int i = 0; i < dsdm.size(); ++i) {
            if (maDM.matches(dsdm.get(i).getTenDM())) {
                isFoundDm = true;
                indexMaDm = i;
                break;
            }
        }
        // Kiểm tra và xử lý nếu không tìm thấy danh mục
        if (!isFoundDm) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy danh mục hợp lệ!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        DanhM.setSelectedIndex(indexMaDm + 1); // Cập nhật danh sách thả xuống DanhM
        // Danh sách DanhM có mục đầu tiên là "tất cả " ứng với index 0  =>  các danh mục thực từ dsdm bắt đầu từ chỉ số 1. Do đó, indexMaDm (lấy từ dsdm) cần tăng thêm 1 để khớp với chỉ số trong DanhM.
    }//GEN-LAST:event_jTable_BooksMouseClicked

    
    private void jButton_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_CancelActionPerformed

    
// Khi nhấn "OK" trong ô tăng giá theo NXB
    private void jButton_AccpetTangGiaNXBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AccpetTangGiaNXBActionPerformed
        // 1. Kiểm tra ô "giá" : Nếu chưa nhập giá cần tăng
        if (TKInput_UpdateAllPriceNXB.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập giá cần tăng", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        // 2. Kiểm tra ô "giá" : Nếu nhập giá cần tăng nhưng sai định giá (nhập chữ,...)
        if (!isNumeric(TKInput_UpdateAllPriceNXB.getText().trim())) {
            JOptionPane.showMessageDialog(this, "Nhập sai định dạng giá", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        // 3. Lấy giá trị tăng thêm (giá trị ô "giá" ) = extraMoney
        double extraMoney = (Double.parseDouble(TKInput_UpdateAllPriceNXB.getText().trim()));
        
        // 4. Lấy all sách của 1 NXB để tăng = dssByNXB
        NXB nxb = (NXB) NXBInput_TangGia.getSelectedItem(); // lấy tên NXB cần tăng 
        Sach_Connect sc = new Sach_Connect();
        dssByNXB = sc.laySachTheoNXB(nxb.getMaNXB());

        // 5. Tăng giá tất cả sách của NXB
        for (Sach s : dssByNXB) {
            sc.updateAllPrice(s.getMaSach(), (s.getGiaBan() + extraMoney));
        }
        hienThiToanBoSach(); // hiển thị lại toàn bộ sách sau khi cập nhật giá 
    }//GEN-LAST:event_jButton_AccpetTangGiaNXBActionPerformed

    
// Khi ấn "X" = xóa giá tăng vừa nhập => 0
    private void jButton_CancelNXBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CancelNXBActionPerformed
              TKInput_UpdateAllPriceNXB.setText("");
    }//GEN-LAST:event_jButton_CancelNXBActionPerformed

    
// Hàm xử lý khi ấn nút "refesh" trong Nhập tên sách và tên tác giả 
    private void jButton_RefreshSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_RefreshSearchMouseClicked
            hienThiToanBoSach();// Hiển thị lại toàn bộ sách trên bảng sách (jTable_Book)
    }//GEN-LAST:event_jButton_RefreshSearchMouseClicked
 
    
// xóa  1 sách  
    protected void xuLyXoa(String maSach) {
        Sach_Connect sachXoa = new Sach_Connect();
        int active = sachXoa.XoaSach(maSach);
        if (active > 0) {
            JOptionPane.showMessageDialog(null, "Xóa thành công sách!");
            hienThiToanBoSach();
        } else {
            JOptionPane.showMessageDialog(null, "Xóa thất bại");
        }
    }

//Chỉnh Sửa
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> DanhM;
    private javax.swing.JComboBox<NXB> NXBInput;
    private javax.swing.JComboBox<NXB> NXBInput_TangGia;
    private javax.swing.JLabel NhanTenLabel;
    private javax.swing.JTextField TKInput;
    private javax.swing.JTextField TKInput1;
    private javax.swing.JTextField TKInput_Discount;
    private javax.swing.JTextField TKInput_GiaBan;
    private javax.swing.JTextField TKInput_MaSach;
    private javax.swing.JTextField TKInput_SoLuong;
    private javax.swing.JTextField TKInput_TacGia;
    private javax.swing.JTextField TKInput_TenSach;
    private javax.swing.JTextField TKInput_UpdateAllPrice;
    private javax.swing.JTextField TKInput_UpdateAllPriceNXB;
    private javax.swing.JButton jButton_Accpet;
    private javax.swing.JButton jButton_AccpetTangGiaNXB;
    private javax.swing.JButton jButton_Cancel;
    private javax.swing.JButton jButton_CancelNXB;
    private javax.swing.JButton jButton_ChinhSua;
    private javax.swing.JButton jButton_NhapLai;
    private javax.swing.JButton jButton_RefreshSearch;
    private javax.swing.JButton jButton_Search;
    private javax.swing.JButton jButton_ThemSach;
    private javax.swing.JButton jButton_XoaSach;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_Discount;
    private javax.swing.JLabel jLabel_Discount1;
    private javax.swing.JLabel jLabel_Discount3;
    private javax.swing.JLabel jLabel_GiaBan;
    private javax.swing.JLabel jLabel_Loc;
    private javax.swing.JLabel jLabel_Loc1;
    private javax.swing.JLabel jLabel_MaNXB;
    private javax.swing.JLabel jLabel_MaSach;
    private javax.swing.JLabel jLabel_SoLuong;
    private javax.swing.JLabel jLabel_TacGia;
    private javax.swing.JLabel jLabel_TenSach;
    private javax.swing.JLabel jLabel_TheLoai;
    private javax.swing.JLabel jLabel_Top;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel_Center;
    private javax.swing.JPanel jPanel_Data;
    private javax.swing.JPanel jPanel_Top;
    private javax.swing.JPanel jPanel_TopFunction;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable_Books;
    // End of variables declaration//GEN-END:variables

    
// phương thức showWindow là một phương thức chịu trách nhiệm hiển thị cửa sổ giao diện của ứng dụng quản lý sách (QuanLySach) trên luồng sự kiện của giao diện người dùng
    void showWindow() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new QuanLySach("Quản lý sách", MaNV).setVisible(true);
            }
        });
    }

}
