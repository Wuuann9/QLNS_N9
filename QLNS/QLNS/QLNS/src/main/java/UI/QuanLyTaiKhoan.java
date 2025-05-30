package UI;

import Connect.NhanVien_Connect;
import Connect.TaiKhoan_Connect;
import Model.NhanVien;
import Model.TaiKhoan;
import java.awt.Toolkit;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;// quan ly du lieu 

// khai bao thuoc tinh qltk 
public class QuanLyTaiKhoan extends javax.swing.JFrame {  // hien thi interface
private DefaultTableModel dtmNhanVien; //dữ liệu bảng jTable
private ArrayList<NhanVien> nhanViens =null;// ds nhanvien
private DefaultTableModel dtmTaiKhoan;
private ArrayList<TaiKhoan> taiKhoans =null;
private ArrayList<NhanVien> dsnv_tim = null; // ds nv filter
private ArrayList<TaiKhoan> dstk_tim=null;

//constructor chạy giao diện interface 
    public QuanLyTaiKhoan(String title) {
        initComponents(); // thực hiện lệnh chạy nhờ vào kéo thả 
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("images/books_30px.png"));
        this.setLocationRelativeTo(null);
        this.setTitle(title);
        hienThiToanBoTaiKhoan(); // thuc hien ham
        hienThiToanBoNhanVien();
    }
    // hien thi ds nhann vien len NhanvienTable
    private void hienThiToanBoNhanVien() {
        NhanVien_Connect nv_conn = new NhanVien_Connect();// tao 1 nv_conn moi cua NV_connect
        nhanViens = nv_conn.layToanBoNhanVien(); // lay ds nv luu vao 1 arrayList nhanViens
        dtmNhanVien = new DefaultTableModel(); // tao 1 bang nhanvien 
        dtmNhanVien.addColumn("Mã nhân viên");  // them 3 cot 
        dtmNhanVien.addColumn("Tên nhân viên");
        dtmNhanVien.addColumn("Chức vụ");
        dtmNhanVien.setRowCount(0); // xoa sach cac dong hien co de reload 
        for(NhanVien nv : nhanViens){  // duyet
            Vector<Object> vec = new Vector<Object>();  
            vec.add(nv.getMaNV()); // them theo dung thu tu 
            vec.add(nv.getTenNV());
            vec.add(nv.getMaCV());
            dtmNhanVien.addRow(vec);// them 1 dong moi theo kieu vec
        }
        NhanVienTable.setModel(dtmNhanVien); // gan du lieu dtmNhanVien hien thi len NhanVientable
    }   
    //hien thi ds tai khoan len TaiKhoanTable
    private void hienThiToanBoTaiKhoan(){
        TaiKhoan_Connect tk_conn = new TaiKhoan_Connect();
        taiKhoans = tk_conn.layToanBoTaiKhoan();
        dtmTaiKhoan = new DefaultTableModel();
        dtmTaiKhoan.addColumn("Mã tài khoản");
        dtmTaiKhoan.addColumn("Mã nhân viên");
        dtmTaiKhoan.addColumn("Username");
        dtmTaiKhoan.addColumn("Password");
        for(TaiKhoan tk : taiKhoans){
            Vector<Object> vec = new Vector<Object>();
            vec.add(tk.getMaTK());
            vec.add(tk.getMaNV());
            vec.add(tk.getUserName());
            vec.add(tk.getPassWord());
            dtmTaiKhoan.addRow(vec);
        }
        TaiKhoanTable.setModel(dtmTaiKhoan);
    }
    // xu ly envent them tai khoan 
    private void xuLyThemMoi(String maTK, String username, String manv) throws ParseException{  // throws nem loi ngay gio tu csdl vao 
        TaiKhoan_Connect tk_conn = new TaiKhoan_Connect();
        if(tk_conn.kiemTraTonTai(maTK, username, manv)==true) // check ton tai 
            JOptionPane.showMessageDialog(null, "Mã tài khoản, username hoặc mã nhân viên đã tồn tại!");
        else{
            // thuc hien OK Cancle truoc khi thuc hien lenh tiep theo 
            int ret=JOptionPane.showConfirmDialog(null, "Bạn muốn thêm tài khoản mới?", "Vui Lòng Xác Nhận", JOptionPane.OK_CANCEL_OPTION);
            if(ret==JOptionPane.OK_OPTION){
                TaiKhoan tk= new TaiKhoan();
                tk.setMaTK(maTK);
                tk.setMaNV(manv);
                tk.setUserName(username);
                tk.setPassWord(PasswordInput.getText()); // thuc hien set ở ô password 
                
                //thuc hien phan quyen set  bang isselected  Jcheckbox tra ve true flase 
                tk.setBaoCao(BaoCaoCheckBox.isSelected()? 1: 0);
                tk.setTaiKhoan(TaiKhoanCheckBox.isSelected()? 1: 0);
                tk.setDanhMuc(DanhMucCheckBox.isSelected()? 1: 0);
                tk.setSach(SachCheckBox.isSelected()? 1: 0);
                tk.setNXB(NXBCheckBox.isSelected()? 1: 0);
                tk.setNhanVien(NhanVienCheckBox.isSelected()? 1: 0);
                tk.setHoaDon(HoaDonCheckBox.isSelected()? 1: 0);
                tk.setNCCVPP(NCCVPPCheckBox.isSelected()? 1: 0);
                tk.setVPP(VPPCheckBox.isSelected()? 1: 0);
                tk.setKhachHang(KHCheckBox.isSelected()? 1: 0);
                
                //themTaiKhoan bang cau lệnh SQL 
                int activeLuu = tk_conn.themTaiKhoan(tk);// activeLuu tra ve 1/0 
                if(activeLuu>0){
                    JOptionPane.showMessageDialog(null, "Thêm mới thành công!");
                    hienThiToanBoTaiKhoan();
                }
                else JOptionPane.showMessageDialog(null, "Thêm mới thất bại!");	
            } 
        } 
    }
 // ham check kiem tra da nhap chua    
    private boolean checkInputs(){
        if(MaTKInput.getText().isEmpty() || MaNVInput.getText().isEmpty() || UsernameInput.getText().isEmpty() || PasswordInput.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Thiếu dữ liệu!");
            return false;
        } 
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TaiKhoanTable = new javax.swing.JTable();
        MaTaiKhoanPanel = new javax.swing.JPanel();
        MaTKInput = new javax.swing.JTextField();
        MaTKLabel = new javax.swing.JLabel();
        MaNhanVienPanel = new javax.swing.JPanel();
        MaNVInput = new javax.swing.JTextField();
        MaNVLabel = new javax.swing.JLabel();
        UsernamePane = new javax.swing.JPanel();
        UsernameInput = new javax.swing.JTextField();
        UsernameLabel = new javax.swing.JLabel();
        PasswordPane = new javax.swing.JPanel();
        PasswordInput = new javax.swing.JTextField();
        PasswordLabel = new javax.swing.JLabel();
        ThemTKBtn = new javax.swing.JButton();
        SuaTKBtn = new javax.swing.JButton();
        XoaTKBTN = new javax.swing.JButton();
        TimKiemTaiKhoanPanel = new javax.swing.JPanel();
        TKTaiKhoanBtn = new javax.swing.JButton();
        TKMaNVInput = new javax.swing.JTextField();
        TKMaNVLabel = new javax.swing.JLabel();
        AllTKTaiKhoanBtn = new javax.swing.JButton();
        ResetTKBTN = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        NhanVienTable = new javax.swing.JTable();
        TimKiemNhanVienPanel = new javax.swing.JPanel();
        TKNhanVienBtn = new javax.swing.JButton();
        TenNVInput = new javax.swing.JTextField();
        TKNhanVienLabel = new javax.swing.JLabel();
        ALLNhanVienBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        TaiKhoanCheckBox = new javax.swing.JCheckBox();
        BaoCaoCheckBox = new javax.swing.JCheckBox();
        NhanVienCheckBox = new javax.swing.JCheckBox();
        SachCheckBox = new javax.swing.JCheckBox();
        NXBCheckBox = new javax.swing.JCheckBox();
        HoaDonCheckBox = new javax.swing.JCheckBox();
        VPPCheckBox = new javax.swing.JCheckBox();
        KHCheckBox = new javax.swing.JCheckBox();
        DanhMucCheckBox = new javax.swing.JCheckBox();
        NCCVPPCheckBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tài khoản");
        jLabel1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel1AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tài khoản", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(255, 0, 0))); // NOI18N

        TaiKhoanTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TaiKhoanTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TaiKhoanTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TaiKhoanTable);

        MaTKLabel.setText("Mã tài khoản");

        javax.swing.GroupLayout MaTaiKhoanPanelLayout = new javax.swing.GroupLayout(MaTaiKhoanPanel);
        MaTaiKhoanPanel.setLayout(MaTaiKhoanPanelLayout);
        MaTaiKhoanPanelLayout.setHorizontalGroup(
            MaTaiKhoanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MaTaiKhoanPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MaTaiKhoanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MaTaiKhoanPanelLayout.createSequentialGroup()
                        .addComponent(MaTKLabel)
                        .addGap(0, 108, Short.MAX_VALUE))
                    .addComponent(MaTKInput))
                .addContainerGap())
        );
        MaTaiKhoanPanelLayout.setVerticalGroup(
            MaTaiKhoanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MaTaiKhoanPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MaTKLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MaTKInput)
                .addContainerGap())
        );

        MaNVLabel.setText("Mã nhân viên");

        javax.swing.GroupLayout MaNhanVienPanelLayout = new javax.swing.GroupLayout(MaNhanVienPanel);
        MaNhanVienPanel.setLayout(MaNhanVienPanelLayout);
        MaNhanVienPanelLayout.setHorizontalGroup(
            MaNhanVienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MaNhanVienPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MaNhanVienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MaNVLabel)
                    .addComponent(MaNVInput, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MaNhanVienPanelLayout.setVerticalGroup(
            MaNhanVienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MaNhanVienPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MaNVLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MaNVInput, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        UsernameLabel.setText("Username");

        javax.swing.GroupLayout UsernamePaneLayout = new javax.swing.GroupLayout(UsernamePane);
        UsernamePane.setLayout(UsernamePaneLayout);
        UsernamePaneLayout.setHorizontalGroup(
            UsernamePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UsernamePaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(UsernamePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UsernamePaneLayout.createSequentialGroup()
                        .addComponent(UsernameLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(UsernameInput, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                .addContainerGap())
        );
        UsernamePaneLayout.setVerticalGroup(
            UsernamePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UsernamePaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(UsernameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UsernameInput)
                .addContainerGap())
        );

        PasswordLabel.setText("Password");

        javax.swing.GroupLayout PasswordPaneLayout = new javax.swing.GroupLayout(PasswordPane);
        PasswordPane.setLayout(PasswordPaneLayout);
        PasswordPaneLayout.setHorizontalGroup(
            PasswordPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PasswordPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PasswordPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PasswordPaneLayout.createSequentialGroup()
                        .addComponent(PasswordLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(PasswordInput, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                .addContainerGap())
        );
        PasswordPaneLayout.setVerticalGroup(
            PasswordPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PasswordPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PasswordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PasswordInput, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addContainerGap())
        );

        ThemTKBtn.setText("Thêm");
        ThemTKBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ThemTKBtnMouseClicked(evt);
            }
        });

        SuaTKBtn.setText("Sửa");
        SuaTKBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SuaTKBtnMouseClicked(evt);
            }
        });

        XoaTKBTN.setText("Xóa");
        XoaTKBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                XoaTKBTNMouseClicked(evt);
            }
        });

        TimKiemTaiKhoanPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));

        TKTaiKhoanBtn.setBackground(new java.awt.Color(0, 102, 255));
        TKTaiKhoanBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TKTaiKhoanBtn.setForeground(new java.awt.Color(255, 255, 255));
        TKTaiKhoanBtn.setText("Tìm kiếm");
        TKTaiKhoanBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TKTaiKhoanBtnMouseClicked(evt);
            }
        });

        TKMaNVInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TKMaNVInputActionPerformed(evt);
            }
        });
        TKMaNVInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TKMaNVInputKeyPressed(evt);
            }
        });

        TKMaNVLabel.setText("Nhập mã nhân viên ");

        AllTKTaiKhoanBtn.setBackground(new java.awt.Color(0, 102, 255));
        AllTKTaiKhoanBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AllTKTaiKhoanBtn.setForeground(new java.awt.Color(255, 255, 255));
        AllTKTaiKhoanBtn.setText("Tất cả");
        AllTKTaiKhoanBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AllTKTaiKhoanBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout TimKiemTaiKhoanPanelLayout = new javax.swing.GroupLayout(TimKiemTaiKhoanPanel);
        TimKiemTaiKhoanPanel.setLayout(TimKiemTaiKhoanPanelLayout);
        TimKiemTaiKhoanPanelLayout.setHorizontalGroup(
            TimKiemTaiKhoanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TimKiemTaiKhoanPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TKMaNVLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TKMaNVInput, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TKTaiKhoanBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AllTKTaiKhoanBtn))
        );
        TimKiemTaiKhoanPanelLayout.setVerticalGroup(
            TimKiemTaiKhoanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TimKiemTaiKhoanPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TimKiemTaiKhoanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TKTaiKhoanBtn)
                    .addComponent(TKMaNVInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TKMaNVLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AllTKTaiKhoanBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ResetTKBTN.setText("Reset");
        ResetTKBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ResetTKBTNMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(MaTaiKhoanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(MaNhanVienPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(UsernamePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(PasswordPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(ThemTKBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SuaTKBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ResetTKBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(XoaTKBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TimKiemTaiKhoanPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(MaNhanVienPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MaTaiKhoanPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(UsernamePane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PasswordPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ThemTKBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(SuaTKBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(XoaTKBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ResetTKBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TimKiemTaiKhoanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nhân viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(255, 0, 0))); // NOI18N

        NhanVienTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(NhanVienTable);

        TimKiemNhanVienPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));

        TKNhanVienBtn.setBackground(new java.awt.Color(0, 102, 255));
        TKNhanVienBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TKNhanVienBtn.setForeground(new java.awt.Color(255, 255, 255));
        TKNhanVienBtn.setText("Tìm kiếm");
        TKNhanVienBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TKNhanVienBtnMouseClicked(evt);
            }
        });

        TenNVInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TenNVInputKeyPressed(evt);
            }
        });

        TKNhanVienLabel.setText("Nhập tên nhân viên/Mã nhân viên");

        ALLNhanVienBtn.setBackground(new java.awt.Color(0, 102, 255));
        ALLNhanVienBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ALLNhanVienBtn.setForeground(new java.awt.Color(255, 255, 255));
        ALLNhanVienBtn.setText("Tất cả");
        ALLNhanVienBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ALLNhanVienBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout TimKiemNhanVienPanelLayout = new javax.swing.GroupLayout(TimKiemNhanVienPanel);
        TimKiemNhanVienPanel.setLayout(TimKiemNhanVienPanelLayout);
        TimKiemNhanVienPanelLayout.setHorizontalGroup(
            TimKiemNhanVienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TimKiemNhanVienPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(TKNhanVienLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TenNVInput, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TKNhanVienBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ALLNhanVienBtn)
                .addContainerGap())
        );
        TimKiemNhanVienPanelLayout.setVerticalGroup(
            TimKiemNhanVienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TimKiemNhanVienPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TimKiemNhanVienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TKNhanVienBtn)
                    .addComponent(TenNVInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TKNhanVienLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ALLNhanVienBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(TimKiemNhanVienPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TimKiemNhanVienPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Phân quyền", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel3.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jPanel3AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        TaiKhoanCheckBox.setText("Tài khoản");
        TaiKhoanCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TaiKhoanCheckBoxActionPerformed(evt);
            }
        });

        BaoCaoCheckBox.setText("Báo cáo");
        BaoCaoCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BaoCaoCheckBoxActionPerformed(evt);
            }
        });

        NhanVienCheckBox.setText("Nhân viên");

        SachCheckBox.setText("Sách");

        NXBCheckBox.setText("NXB");

        HoaDonCheckBox.setText("Hóa đơn");

        VPPCheckBox.setText("VPP");

        KHCheckBox.setText("Khách hàng");

        DanhMucCheckBox.setText("Danh Mục");

        DanhMucCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DanhMucCheckBoxActionPerformed(evt);
            }
        });


        NCCVPPCheckBox.setText("NCCVPP");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(BaoCaoCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TaiKhoanCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(DanhMucCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SachCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(NXBCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(NhanVienCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(HoaDonCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(NCCVPPCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(VPPCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(KHCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BaoCaoCheckBox)
                    .addComponent(TaiKhoanCheckBox)
                    .addComponent(DanhMucCheckBox)
                    .addComponent(SachCheckBox)
                    .addComponent(NXBCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NhanVienCheckBox)
                    .addComponent(HoaDonCheckBox)
                    .addComponent(NCCVPPCheckBox)
                    .addComponent(VPPCheckBox)
                    .addComponent(KHCheckBox))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(90, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // event click TKtable set lai cac quyen thong tin 
    private void TaiKhoanTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TaiKhoanTableMouseClicked
        int select = TaiKhoanTable.getSelectedRow(); // xac dinh vi tri dong 
        // gan du lieu tu dong dang chon vao textfield 
        //setText hien thi tren o textfield
        MaTKInput.setText(TaiKhoanTable.getValueAt(select, 0)+""); //ep kieu ve chuoi 
        MaNVInput.setText(TaiKhoanTable.getValueAt(select, 1)+"");
        UsernameInput.setText(TaiKhoanTable.getValueAt(select, 2)+"");
        PasswordInput.setText(TaiKhoanTable.getValueAt(select, 3)+"");
        //truy van lai doi tuong tu CSDL bang MaTK
        TaiKhoan_Connect tk_conn = new TaiKhoan_Connect();
        TaiKhoan tk = tk_conn.TimTaiKhoanBangMaTK(MaTKInput.getText());
        // lay get de hien thi phan quyen bang if else roi setselected lại 
        if(tk.getBaoCao()==1) BaoCaoCheckBox.setSelected(true);
        else BaoCaoCheckBox.setSelected(false);
        if(tk.getTaiKhoan()==1) TaiKhoanCheckBox.setSelected(true);
        else TaiKhoanCheckBox.setSelected(false);
        if(tk.getDanhMuc()==1) DanhMucCheckBox.setSelected(true);
        else DanhMucCheckBox.setSelected(false);
        if(tk.getSach()==1) SachCheckBox.setSelected(true);
        else SachCheckBox.setSelected(false);
        if(tk.getNXB()==1) NXBCheckBox.setSelected(true);
        else NXBCheckBox.setSelected(false);
        if(tk.getNhanVien()==1) NhanVienCheckBox.setSelected(true);
        else NhanVienCheckBox.setSelected(false);
        if(tk.getHoaDon()==1) HoaDonCheckBox.setSelected(true);
        else HoaDonCheckBox.setSelected(false);
        if(tk.getNCCVPP()==1) NCCVPPCheckBox.setSelected(true);
        else NCCVPPCheckBox.setSelected(false);
        if(tk.getVPP()==1) VPPCheckBox.setSelected(true);
        else VPPCheckBox.setSelected(false);
        if(tk.getKhachHang()==1) KHCheckBox.setSelected(true);
        else KHCheckBox.setSelected(false);
    }//GEN-LAST:event_TaiKhoanTableMouseClicked

    // event them tai khoan 
    private void ThemTKBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThemTKBtnMouseClicked
        if(!checkInputs()) return; 
        String maTK = MaTKInput.getText(); // lay du lieu tu textField 
        String username = UsernameInput.getText();
        String manv = MaNVInput.getText();
        //
        try {
            xuLyThemMoi(maTK, username, manv); // gọi hàm truyền dữ liệu vào 
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_ThemTKBtnMouseClicked

    // sửa lại thông tin và phân quyền tài khoản 
    private void SuaTKBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SuaTKBtnMouseClicked
        if(!checkInputs()) return;
        int ret=JOptionPane.showConfirmDialog(null, "Bạn muốn chỉnh sửa tài khoản?", "Xác nhận chỉnh sửa", JOptionPane.OK_CANCEL_OPTION);
        if(ret==JOptionPane.OK_OPTION){
            TaiKhoan_Connect tk_conn = new TaiKhoan_Connect();
            TaiKhoan tk = new TaiKhoan();
            tk.setMaTK(MaTKInput.getText());
            tk.setMaNV(MaNVInput.getText());
            tk.setUserName(UsernameInput.getText());
            tk.setPassWord(PasswordInput.getText());
            //thực hiện tích checkBox lại 
            tk.setBaoCao(BaoCaoCheckBox.isSelected()? 1: 0);
            tk.setTaiKhoan(TaiKhoanCheckBox.isSelected()? 1: 0);
            tk.setDanhMuc(DanhMucCheckBox.isSelected()? 1: 0);
            tk.setSach(SachCheckBox.isSelected()? 1: 0);
            tk.setNXB(NXBCheckBox.isSelected()? 1: 0);
            tk.setNhanVien(NhanVienCheckBox.isSelected()? 1: 0);
            tk.setHoaDon(HoaDonCheckBox.isSelected()? 1: 0);
            tk.setNCCVPP(NCCVPPCheckBox.isSelected()? 1: 0);
            tk.setVPP(VPPCheckBox.isSelected()? 1: 0);
            tk.setKhachHang(KHCheckBox.isSelected()? 1: 0);
            int activeUpdate = tk_conn.updateTaiKhoan(tk);  //tai đây sửa tài khoản có sẵn theo SQL
             if(activeUpdate>0){
                JOptionPane.showMessageDialog(null, "Chỉnh sửa thành công!");
                hienThiToanBoTaiKhoan();
            }
            else JOptionPane.showMessageDialog(null, "Chỉnh sửa thất bại!");
        }
    }//GEN-LAST:event_SuaTKBtnMouseClicked

    // xóa tài khoản 
    private void XoaTKBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XoaTKBTNMouseClicked
        String matk = MaTKInput.getText();// lay dữ liệu textField ở MaTk
        TaiKhoan_Connect tk_conn = new TaiKhoan_Connect();
        int ret = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa?", "Xác nhận xóa", JOptionPane.OK_CANCEL_OPTION);
        if(ret==JOptionPane.OK_OPTION){
            int active = tk_conn.xoaTaiKhoan(matk);  // thực hiện delete với matk truyền vào SQL và kiểm tra pre.executUpdate
            if(active>0){
                    JOptionPane.showMessageDialog(null, "Xóa thành công!");
                    hienThiToanBoTaiKhoan();
            }
            else JOptionPane.showMessageDialog(null, "Xóa thất bại!");
        }
    }//GEN-LAST:event_XoaTKBTNMouseClicked

    private void TKTaiKhoanBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TKTaiKhoanBtnMouseClicked
        //nếu ô mã nhân viên rỗng thì trả về tất cả nhân viên
        if(TKMaNVInput.getText().trim().isEmpty() ) {
            hienThiToanBoTaiKhoan();
            return ;
        }
        //nếu không thì tìm theo mã nhân viên đó
        String key = TKMaNVInput.getText(); // lay du lieu MaNV tu o tim kiem 
        TaiKhoan_Connect tk_conn = new TaiKhoan_Connect();
        dstk_tim = tk_conn.timTaiKhoan(key); // thuc hien tim tai khoan tra ve 1 thi gan vao mang dstk
        dtmTaiKhoan.setRowCount(0);// xoa het du lieu cu tu table 
        for(TaiKhoan tk : dstk_tim){
            Vector<Object> vec = new Vector<Object>();
            vec.add(tk.getMaTK());
            vec.add(tk.getMaNV());
            vec.add(tk.getUserName());
            vec.add(tk.getPassWord());
            dtmTaiKhoan.addRow(vec);// them du lieu vec vao table 
        }
        TaiKhoanTable.setModel(dtmTaiKhoan); // gan du lieu moi cho bang 
    }//GEN-LAST:event_TKTaiKhoanBtnMouseClicked
// tìm khiếm nhân viên băngf tên/ mã nhân viên 
    private void TKNhanVienBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TKNhanVienBtnMouseClicked
        //nếu ô tên nhân viên rỗng thì trả về tất cả nhân viên
        if(TenNVInput.getText().trim().isEmpty() ) {
            hienThiToanBoNhanVien();
            return ;
        }
        //nếu không thì tìm theo tên nhân viên đó
        String key = TenNVInput.getText();
        NhanVien_Connect nv_conn = new NhanVien_Connect();
        dsnv_tim = nv_conn.timNhanVien(key);
        dtmNhanVien.setRowCount(0);
        for(NhanVien nv : dsnv_tim){
            Vector<Object> vec = new Vector<Object>();
            vec.add(nv.getMaNV());
            vec.add(nv.getTenNV());
            vec.add(nv.getNgaySinh());
            vec.add(nv.getNgayVaolam());
            vec.add(nv.getSoChungMinh());
            vec.add(nv.getMaCV());
            vec.add(nv.getSDT());
            vec.add(nv.getEmail());
            dtmNhanVien.addRow(vec);
        }
	NhanVienTable.setModel(dtmNhanVien);	
    }//GEN-LAST:event_TKNhanVienBtnMouseClicked
// reset tài khoản 
    private void ResetTKBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetTKBTNMouseClicked
        MaTKInput.setText("");
        MaNVInput.setText("");
        UsernameInput.setText("");
        PasswordInput.setText("");
        BaoCaoCheckBox.setSelected(false);
        TaiKhoanCheckBox.setSelected(false);
        DanhMucCheckBox.setSelected(false);
        SachCheckBox.setSelected(false);
        NXBCheckBox.setSelected(false);
        NhanVienCheckBox.setSelected(false);
        HoaDonCheckBox.setSelected(false);
        NCCVPPCheckBox.setSelected(false);
        VPPCheckBox.setSelected(false);
        KHCheckBox.setSelected(false);
    }//GEN-LAST:event_ResetTKBTNMouseClicked

    private void ALLNhanVienBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ALLNhanVienBtnMouseClicked
        hienThiToanBoNhanVien();
    }//GEN-LAST:event_ALLNhanVienBtnMouseClicked
// thực hiện phím enter thay vì bấm tìm kiếm 
    private void TKMaNVInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TKMaNVInputKeyPressed
        if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER){
            TKTaiKhoanBtnMouseClicked(null);
        }
    }//GEN-LAST:event_TKMaNVInputKeyPressed

    private void AllTKTaiKhoanBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AllTKTaiKhoanBtnMouseClicked
        hienThiToanBoTaiKhoan();
    }//GEN-LAST:event_AllTKTaiKhoanBtnMouseClicked

    private void TenNVInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TenNVInputKeyPressed
        if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER){
            TKNhanVienBtnMouseClicked(null);
        }
    }//GEN-LAST:event_TenNVInputKeyPressed



    private void TaiKhoanCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TaiKhoanCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TaiKhoanCheckBoxActionPerformed

    private void BaoCaoCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BaoCaoCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BaoCaoCheckBoxActionPerformed


    private void DanhMucCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DanhMucCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DanhMucCheckBoxActionPerformed


    private void jLabel1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1AncestorAdded

    private void jPanel3AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jPanel3AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel3AncestorAdded

    private void TKMaNVInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TKMaNVInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TKMaNVInputActionPerformed


    // sử dụng invokeLater chạy tron GUI để tránh xung đột 
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
            java.util.logging.Logger.getLogger(TaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyTaiKhoan("Tài khoản").setVisible(true); // tạo 1 cửa số mới để hiển thị 
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ALLNhanVienBtn;
    private javax.swing.JButton AllTKTaiKhoanBtn;
    private javax.swing.JCheckBox BaoCaoCheckBox;
    private javax.swing.JCheckBox DanhMucCheckBox;
    private javax.swing.JCheckBox HoaDonCheckBox;
    private javax.swing.JCheckBox KHCheckBox;
    private javax.swing.JTextField MaNVInput;
    private javax.swing.JLabel MaNVLabel;
    private javax.swing.JPanel MaNhanVienPanel;
    private javax.swing.JTextField MaTKInput;
    private javax.swing.JLabel MaTKLabel;
    private javax.swing.JPanel MaTaiKhoanPanel;
    private javax.swing.JCheckBox NCCVPPCheckBox;
    private javax.swing.JCheckBox NXBCheckBox;
    private javax.swing.JCheckBox NhanVienCheckBox;
    private javax.swing.JTable NhanVienTable;
    private javax.swing.JTextField PasswordInput;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JPanel PasswordPane;
    private javax.swing.JButton ResetTKBTN;
    private javax.swing.JCheckBox SachCheckBox;
    private javax.swing.JButton SuaTKBtn;
    private javax.swing.JTextField TKMaNVInput;
    private javax.swing.JLabel TKMaNVLabel;
    private javax.swing.JButton TKNhanVienBtn;
    private javax.swing.JLabel TKNhanVienLabel;
    private javax.swing.JButton TKTaiKhoanBtn;
    private javax.swing.JCheckBox TaiKhoanCheckBox;
    private javax.swing.JTable TaiKhoanTable;
    private javax.swing.JTextField TenNVInput;
    private javax.swing.JButton ThemTKBtn;
    private javax.swing.JPanel TimKiemNhanVienPanel;
    private javax.swing.JPanel TimKiemTaiKhoanPanel;
    private javax.swing.JTextField UsernameInput;
    private javax.swing.JLabel UsernameLabel;
    private javax.swing.JPanel UsernamePane;
    private javax.swing.JCheckBox VPPCheckBox;
    private javax.swing.JButton XoaTKBTN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
