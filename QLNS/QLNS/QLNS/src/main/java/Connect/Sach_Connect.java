package Connect;

import Model.ChucVu;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import Model.NXB;
import Model.Sach;
import Model.TonKho;
import java.sql.CallableStatement;
import java.util.Calendar;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class Sach_Connect extends Connect_sqlServer{

    // Lấy toàn bộ sách ( tất cả sách + 8 thuộc tính mỗi sách) = dss
    public ArrayList<Sach> layToanBoSach()
    {
        ArrayList<Sach> dss = new ArrayList<Sach>() ;// tạo arraylist rỗng để chứa sách = dss
        try {
            // 1. truy vấn tất cả sách rồi lưu kết quả vào resultset
            String sql ="select MaSach, TenSach, TenNXB, TacGia, GiaBan, TheLoai, SoLuong, Discount  from SACH,NXB where SACH.MaNXB = NXB.MaNXB" ;
            Statement statement = conn.createStatement();// 
            ResultSet result = statement.executeQuery(sql);// tạo một đối tượng Statement,
                                          //=> dùng để thực thi các câu truy vấn SQL tĩnh (không có tham số), ngược preparedstatment (có tham số ????)
                
            // 2. lấy kết quả result truy vấn được gán cho sách (s) => đẩy lần lượt vào arraylist sách = dss
                while(result.next()){// 1 lần next là 1 lần xuống dòng trong bảng result 
                Sach s = new Sach();
                s.setMaSach(result.getString(1));
                s.setTenSach(result.getString(2));
                s.setMaNXB(result.getString(3));
                s.setTacGia(result.getString(4));
                s.setGiaBan(result.getDouble(5));
                s.setTenDM(result.getString(6));
                s.setSoLuong(result.getInt(7));
                s.setDiscount(result.getInt(8));
                dss.add(s); //thêm đối tượng Sach vừa tạo vào danh sách sách (dss) .
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return dss;
    }

    // lay doanh sach theo ma nxb va ten sach
    public ArrayList<Sach> laySachTheoNXBTen(String manxb , String ten)
    {
        ArrayList<Sach> dss2 = new ArrayList<Sach>();
        // 1. truy vấn tất cả sách (theo ma NXB+ tên sách) => lưu kết quả vào resultset
        try {
            String sql ="select MaSach, TenSach, TenNXB, TacGia, GiaBan, TheLoai, SoLuong, Discount from SACH,NXB where SACH.MaNXB = NXB.MaNXB and MaNXB=? and TenSach like ? " ;
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, manxb);
            pre.setString(2, "%"+ten+"%"); // Dấu % ở cả hai đầu cho phép tìm kiếm chuỗi con (chỉ cần gõ 1 phần tên sách là đủ)
            ResultSet result = pre.executeQuery();
            
        // 2. Đẩy lần lượt sách vào arraylist sách (theo ma NXB+ tên sách) = dss2    
            while(result.next()){
                Sach s = new Sach();
                s.setMaSach(result.getString(1));
                s.setTenSach(result.getString(2));
                s.setMaNXB(result.getString(3));
                s.setTacGia(result.getString(4));
                s.setGiaBan(result.getDouble(5));
                s.setTenDM(result.getString(6));
                s.setSoLuong(result.getInt(7));
                s.setDiscount(result.getInt(8));
                dss2.add(s);// thêm 1 sách vào arraylist dss2
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dss2;
    }
 
    
 // hàm lấy sách theo "tên sách" = 1 phần tên sách hoặc tên sách
    public ArrayList<Sach> laySachTheoMaTen(String maten)
    {
        ArrayList<Sach> dss3 = new ArrayList<Sach>();// arraylist rỗng , lưu tất sách tìm được theo tên

        // 1. truy vấn tất cả sách (theo tên sách) => lưu kết quả vào resultset
        try {
            String sql = "select MaSach, TenSach, TenNXB, TacGia, GiaBan, TheLoai, SoLuong, Discount from SACH,NXB where SACH.MaNXB = NXB.MaNXB and TenSach like ? " ;
            PreparedStatement pre1 = conn.prepareStatement(sql);
            pre1.setString(1, "%"+maten+"%"); // Dấu % ở cả hai đầu cho phép tìm kiếm chuỗi con (chỉ cần gõ 1 phần tên sách là đủ)
            ResultSet result = pre1.executeQuery();
            
            // 2. Đẩy lần lượt sách vào arraylist sách (theo tên sách) = dss2
            while (result.next()){
                Sach s = new Sach();
                s.setMaSach(result.getString(1));
                s.setTenSach(result.getString(2));
                s.setMaNXB(result.getString(3));
                s.setTacGia(result.getString(4));
                s.setGiaBan(result.getDouble(5));
                s.setTenDM(result.getString(6));
                s.setSoLuong(result.getInt(7));
                s.setDiscount(result.getInt(8));
                dss3.add(s);// thêm 1 sách vào arraylist dss3
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return dss3;
    }
    
    
//hàm lấy sách theo "tên tác giả " = 1 phần tên tác giả hoặc tên tác giả 
     public ArrayList<Sach> laySachTheoTenTacGia(String tenTacGia)
    {
        ArrayList<Sach> dss2 = new ArrayList<Sach>();// arraylist rỗng , lưu tất cả sách tìm được theo tên tác giả 
        
        // 1. truy vấn tất cả sách (theo tên tác giả ) => lưu kết quả vào resultset
        try {
            String sql = "select MaSach, TenSach, TenNXB, TacGia, GiaBan, TheLoai, SoLuong, Discount from SACH,NXB where SACH.MaNXB = NXB.MaNXB and TacGia like ? " ;
            PreparedStatement pre1 = conn.prepareStatement(sql);
            pre1.setString(1, "%"+tenTacGia+"%"); // Dấu % ở cả hai đầu cho phép tìm kiếm chuỗi con (chỉ cần gõ 1 phần tên sách là đủ)
            ResultSet result = pre1.executeQuery();
            
        // 2. Đẩy lần lượt sách  từ resultset vào arraylist sách (theo tên tác giả) = dss2 
            while (result.next()){
                Sach s = new Sach();
                s.setMaSach(result.getString(1));
                s.setTenSach(result.getString(2));
                s.setMaNXB(result.getString(3));
                s.setTacGia(result.getString(4));
                s.setGiaBan(result.getDouble(5));
                s.setTenDM(result.getString(6));
                s.setSoLuong(result.getInt(7));
                s.setDiscount(result.getInt(8));
                dss2.add(s);// thêm 1 sách vào arraylist dss2
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return dss2;
    }
     
     
     
// Lấy sách theo tên sách + tên tác giả 
     public ArrayList<Sach> laySachTheoMaTenVaTenTacGia(String maten, String tenTacGia)
    {
        ArrayList<Sach> dss4 = new ArrayList<Sach>();
  
        // 1. truy vấn tất cả sách (theo tên tác giả + tên sách ) => lưu kết quả vào resultset
        try {
            String sql = "select MaSach, TenSach, TenNXB, TacGia, GiaBan, TheLoai, SoLuong, Discount from SACH,NXB where SACH.MaNXB = NXB.MaNXB and TenSach like ? and TacGia like ?" ;
            PreparedStatement pre1 = conn.prepareStatement(sql);
            pre1.setString(1, "%"+maten+"%");   // Dấu % ở cả hai đầu cho phép tìm kiếm chuỗi con (chỉ cần gõ 1 phần tên sách là đủ)
            pre1.setString(2, "%"+tenTacGia+"%");
            ResultSet result = pre1.executeQuery();
            
         // 2. Đẩy lần lượt sách  từ resultset vào arraylist sách (theo tên tác giả + tên sách) = dss4
            while (result.next()){
                Sach s = new Sach();
                s.setMaSach(result.getString(1));
                s.setTenSach(result.getString(2));
                s.setMaNXB(result.getString(3));
                s.setTacGia(result.getString(4));
                s.setGiaBan(result.getDouble(5));
                s.setTenDM(result.getString(6));
                s.setSoLuong(result.getInt(7));
                s.setDiscount(result.getInt(8));
                dss4.add(s);// thêm 1 sách vào arraylist dss4
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return dss4;
    }

     
// Lấy tất cả các sách theo ma NXB
    public ArrayList<Sach> laySachTheoNXB(String keyWord )
    {
            // 1. Tạo ArrayList trống để lưu all sách 
            ArrayList<Sach> dss2 = new ArrayList<Sach>();
            
            // 2. Truy vấn CSDL SACH => lưu kết quả vào result
            try {
                String sql =" select * from SACH where MaNXB=? ";
                PreparedStatement pre = conn.prepareStatement(sql); //  PreparedStatement truy vấn an toàn tới csdl qua tham số ? 
                pre.setString(1, keyWord);			
                ResultSet result = pre.executeQuery();
                
                // 3. lấy kết quả truy vấn (result) gán cho các thuộc tính của NXB
                while(result.next()){
                    Sach s = new Sach();
                    s.setMaSach(result.getString(1));
                    s.setTenSach(result.getString(2));
                    s.setMaNXB(result.getString(3));
                    s.setTacGia(result.getString(4));
                    s.setGiaBan(result.getDouble(5));
                    s.setTenDM(result.getString(6));
                    s.setSoLuong(result.getInt(7));
                    s.setDiscount(result.getInt(8));
                    dss2.add(s); // Thêm đối tượng Sach vừa tạo vào danh sách dss2.
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return dss2;
    }

    
// Lấy sách bán chạy 
// laySachBanChay(top mấy ,tháng nào, năm nào ) 
public ArrayList<Sach> laySachBanChay(String top, String thang, String nam ){
        
    // 1. Khởi tạo danh sách kết quả
        ArrayList<Sach> dsSBC = new ArrayList<Sach>();
        
    // 2. Truy vấn đến CSDL "SACH"+"HOADON"+"CTHD"
    // => Lấy kết quả theo 2 TH với 3 cột : MaSP+TenSP+Soluong
    // GROUP BY MaSach,TenSach = gộp các cột có mã + tên trùng nhau 
        String sql = "";
        try {
            // TH1: Không chọn tháng => thống kê top bán chạy theo năm 
            if ("0".equals(thang))  
                sql ="SELECT TOP " +top +" A.MaSach,TenSach, SUM(A.SoLuong) as SL FROM (SELECT SACH.MaSach,TenSach,CTHD.SoLuong FROM SACH,HOADON,CTHD WHERE SACH.MaSach=CTHD.MaSP AND CTHD.MaHD=HOADON.MaHD AND YEAR(NgayLap)=? AND HOADON.ThanhCong=1 AND HOADON.NhapSach=0) AS A GROUP BY MaSach, TenSach ORDER BY SL DESC ";
            // TH2: chọn tháng cụ thể => thống kê top bán chạy theo tháng + năm 
            else 
                sql ="SELECT TOP " +top +" A.MaSach,TenSach, SUM(A.SoLuong) as SL FROM (SELECT SACH.MaSach,TenSach,CTHD.SoLuong FROM SACH,HOADON,CTHD WHERE SACH.MaSach=CTHD.MaSP AND CTHD.MaHD=HOADON.MaHD AND MONTH(NgayLap)=? AND YEAR(NgayLap)=? AND HOADON.ThanhCong=1 AND HOADON.NhapSach=0 ) AS A GROUP BY MaSach, TenSach ORDER BY SL DESC";
            PreparedStatement pre = conn.prepareStatement(sql);

            if ("0".equals(thang)) {
                pre.setString(1, nam);
            }
            else {
                pre.setString(1, thang);
                pre.setString(2, nam);
            }	
            
    // 3. Lấy kết quả từ resultset => arraylist sách bán chạy = dsSBC  
            ResultSet result = pre.executeQuery();
            while(result.next()){
                Sach s = new Sach();
                s.setMaSach(result.getString(1));
                s.setTenSach(result.getString(2));
                s.setSoLuong(result.getInt(3));
                dsSBC.add(s);// đẩy thông tin về 1 sách lên dsSBC
            }
        } catch (Exception e) {
                e.printStackTrace();
        }
        return dsSBC;
    }
    
    

// xử lý dữ liệu tồn kho theo tháng+năm
public ArrayList<TonKho> laySachTonKho(int thang, int nam ){
    // 1.Khởi tạo danh sách và biến hỗ trợ
        ArrayList<TonKho> dsTK = new ArrayList<TonKho>();
        String sql = "";
        // tạo một đối tượng Calendar để lấy thông tin thời gian hiện tại.
        Calendar cal = Calendar.getInstance(); 
    // 2. Chuẩn bị và gọi stored procedure
        try {
            sql ="{call GetTonKhoThangHienTai("+nam+","+thang+")}";
            CallableStatement  stmt  = conn.prepareCall(sql);		
            ResultSet result = stmt.executeQuery();
    // 3. Xử lý kết quả và điền vào ArrayList dsTK
            while(result.next()){
                TonKho tk = new TonKho();
                //khi dòng hiện tại là sách
                if(result.getString(1)!=null){
                    tk.setMaSP(result.getString(1));
                    tk.setTenSP(result.getString(2));
                    tk.setTonDau(result.getInt(5));
                    if(Integer.toString(result.getInt(7))!=null)
                        tk.setNhap(result.getInt(7));
                    else tk.setNhap(0);
                    if(Integer.toString(result.getInt(8))!=null)
                        tk.setXuat(result.getInt(8));
                    else tk.setXuat(0);
                    tk.setTonCuoi(result.getInt(9));
                }
                //khi dòng hiện tại là văn phòng phẩm
                else{
                    tk.setMaSP(result.getString(3));
                    tk.setTenSP(result.getString(4));
                    tk.setTonDau(result.getInt(6));
                    if(Integer.toString(result.getInt(7))!=null)
                        tk.setNhap(result.getInt(7));
                    else tk.setNhap(0);
                    if(Integer.toString(result.getInt(8))!=null)
                        tk.setXuat(result.getInt(8));
                    else tk.setXuat(0);
                    tk.setTonCuoi(result.getInt(10));
                }
                dsTK.add(tk);  
            }	
        } catch (Exception e) {
                e.printStackTrace();
        }
        return dsTK;
    }


// Hàm xử lý lấy dữ liệu tồn kho theo tháng, năm 
public ArrayList<TonKho> layThongTinNhapXuat(int thang, int nam ){
    // 1. Khởi tạo danh sách ArrayList<TonKho>    
    ArrayList<TonKho> dsTK = new ArrayList<TonKho>();
    
    // 2. Kết nối CSDL "TONKHO" + "SACH" + "VPP" 
    // => Lấy ra (T.MaSP, S.TenSach, V.TenVPP, TonDau, Nhap, Xuat, TonCuoi) theo tháng+ năm 
    // Sử dụng left join để lấy tất cả bản ghi từ TONKHO => ngay cả khi MaSP không tồn tại trong SACH hoặc VPP (trả về null cho TenSach hoặc TenVPP).
        String sql = "";
        try {
            sql ="select T.MaSP, S.TenSach, V.TenVPP, TonDau, Nhap, Xuat, TonCuoi from TONKHO as T left join SACH as S on T.MaSP = S.MaSach left join VPP as V on T.MaSP = V.MaVPP where Thang="+thang+" and Nam="+nam+"";
            PreparedStatement pre = conn.prepareStatement(sql);	
            ResultSet result = pre.executeQuery();
            
    // 3. Xử lý kết quả và điền vào ArrayList TONKHO
            while(result.next()){
                TonKho tk = new TonKho();
                tk.setMaSP(result.getString(1));
                if(result.getString(2)!=null) // Kiểm tra null trước khi gán vào TenSP (tránh lỗi nếu không có sách).
                    tk.setTenSP(result.getString(2));
                if(result.getString(3)!=null) //Kiểm tra null trước khi gán vào TenSP.
                    tk.setTenSP(result.getString(3));
                tk.setTonDau(result.getInt(4));
                tk.setNhap(result.getInt(5));
                tk.setXuat(result.getInt(6));
                tk.setTonCuoi(result.getInt(7));
                dsTK.add(tk);  // Thêm đối tượng TonKho vào danh sách dsTK.
            }	
        } catch (Exception e) {
                e.printStackTrace();
        }
        return dsTK;
    }
    


// Lưu dữ liệu từ 1 bảng vào CSDL "TONKHO"
// luuDuLieuVaoTonKho(TÊN BẢNG, THÁNG, NĂM )
public int luuDuLieuVaoTonKho(JTable jTable1, int thang, int nam){
       
        // 1. Lấy mã tồn kho để tại matk mới nhất (matk) 
        try{
            int matk = 0;
            String sql = "SELECT TOP 1 MaTK FROM TONKHO ORDER BY MaTK DESC";
            PreparedStatement pre = conn.prepareStatement(sql);	
            ResultSet result = pre.executeQuery();
            while(result.next()){
                // getString(1) = Lấy giá trị cột 1 (MaTK) dưới dạng chuỗi (ví dụ: "TK005").
                // substring(2) = Bỏ tiền tố "TK", lấy phần số phía sau (ví dụ: "TK005" → "005").
                // chuyển chuỗi số thành số nguyên và tăng lên 1 (ví dụ: "005" → 5 → 6).
                matk = Integer.parseInt(result.getString(1).substring(2))+1;
            }
            
        // 2. Thêm dữ liệu tồn kho mới vào CSDL "TONKHO"
            sql = "INSERT INTO TONKHO(MaTK, MaSP, TonDau, Nhap, Xuat, TonCuoi, Thang, Nam) VALUES ( ?, ?, ?, ?, ?, ?, "+thang+", "+nam+")";
            for (int row = 0; row < jTable1.getRowCount(); row++) {
                PreparedStatement statement = conn.prepareStatement(sql); 
                statement.setString(1, "TK"+matk);
                statement.setString(2, jTable1.getValueAt(row, 0).toString());
                statement.setInt(3, Integer.parseInt(jTable1.getValueAt(row, 2).toString()));
                statement.setInt(4, Integer.parseInt(jTable1.getValueAt(row, 3).toString()));
                statement.setInt(5, Integer.parseInt(jTable1.getValueAt(row, 4).toString()));
                statement.setInt(6, Integer.parseInt(jTable1.getValueAt(row, 5).toString()));
                matk++; // tăng để tạo matk mới cho hàng tiếp 
                statement.executeUpdate();
            }
            return 1;
        }
        catch (Exception e) {
                e.printStackTrace();
        }
        return 0;
    }


// Thêm sách mới vào CSDL "SACH"
    public int  themSachMoi(Sach s)
    {
        try {
            String sql = "insert into SACH values (?,?,?,?,?,?,?,?)"  ;
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, s.getMaSach());
            pre.setString(2, s.getTenSach());
            pre.setString(3, s.getMaNXB());
            pre.setString(4, s.getTacGia());
            pre.setDouble(5, s.getGiaBan());
            pre.setString(6, s.getTenDM());
            pre.setInt(7, s.getSoLuong());
            pre.setInt(8, s.getDiscount());
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1 ;
    }
    

    
// Xóa sách trong CSDL
// => trả về >0 nếu xóa thành công 
//           <=0 nếu k thành công 
    public int XoaSach(String maSach)
    {
        try {
            String sql ="delete SACH where MaSach=?" ;
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,maSach);

            return pre.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;
    }
    
    
// hàm cập nhật chỉnh sửa 1 sách 
    //=> trả về 1 = cập nhật sách thành công , 0 nếu không có sách nào cập nhật , -1 nếu lỗi ((Exception))
    public int update (Sach s)
    {
            try {
                String sql = "update SACH set TenSach=? ,MaNXB=? ,TacGia=? ,GiaBan=? ,TheLoai=?,SoLuong=?, Discount=? where MaSach=? " ;
                PreparedStatement pre = conn.prepareStatement(sql);
                pre.setString(1, s.getTenSach());
                pre.setString(2, s.getMaNXB());
                pre.setString(3, s.getTacGia());
                pre.setDouble(4, s.getGiaBan());
                pre.setString(5, s.getTenDM());
                pre.setInt(6, s.getSoLuong());
                pre.setInt(7, s.getDiscount());
                pre.setString(8, s.getMaSach());
                
                return pre.executeUpdate();

            } catch (Exception e) {
                e.printStackTrace();
            }

            return -1 ;
    }
 
    
//**Hàm update số lượng sách sau khi bán
    public int updateSL(String MaSach, int SL){
        try {
            String sql ="update SACH set SoLuong=? where MaSach=?" ;
            PreparedStatement pre = conn.prepareStatement(sql); // dùng preparedStatement để truy cập CSDL an toàn , tránh SQL injection
            pre.setInt(1, SL);
            pre.setString(2,MaSach); // 2 là vị trí ? thứ 2 

            return pre.executeUpdate();//thực thi lệnh UPDATE

            } catch (Exception e) {
                    e.printStackTrace();
            }

        return -1;
    }
    
    // cập nhật giá  1 sách 
       public int updateAllPrice(String MaSach, double ex){
        try {
            String sql ="update SACH set GiaBan=? where MaSach=?" ;
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setDouble(1, ex);
            pre.setString(2,MaSach);

            return pre.executeUpdate();

            } catch (Exception e) {
                    e.printStackTrace();
            }

        return -1;
    }
       
    //Hàm Lấy danh sách sách có số lượng còn dưới 5
    public ArrayList<Sach> laySachConDuoiTon(int SL)
    {
        ArrayList<Sach> dssTon = new ArrayList<Sach>();
        try {
            String sql ="select SACH.MaSach , SACH.TenSach , SACH.SoLuong , NXB.TenNXB from SACH,NXB where SACH.MaNXB = NXB.MaNXB and SACH.SoLuong<=?" ;
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, SL);
            ResultSet result = pre.executeQuery();
            while (result.next()){	
                Sach s = new Sach();				
                s.setMaSach(result.getString(1));
                s.setTenSach(result.getString(2));
                s.setMaNXB(result.getString(4));
                s.setSoLuong(result.getInt(3));				
                dssTon.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dssTon;
    }

    
// Lấy sách theo thể loại sách : hiển thị biểu đồ thống kê số lượng sách theo thể loại
// => dùng cho báo cáo => thống kê => sách 
// GROUP BY the loai = gộp 
   public DefaultPieDataset laySachTheoTheLoai(){
       
   //1. Khởi tạo DefaultPieDataset - một đối tượng chứa dữ liệu để vẽ biểu đồ hình tròn.
   // DefaultPieDataset được thiết kế chứa dữ liệu cho biểu đồ hình tròn,mỗi phần tử là một cặp giá trị: tên thể loại (key) và số lượng sách (value).
       DefaultPieDataset dataset = new DefaultPieDataset();
       
    //2. Truy vấn CSDL SACH 
     // => Lấy ra theo cặp (thể loại,số lượng)
       try{
            String sql = "SELECT TheLoai, COUNT(MaSach) AS SoLuongSach FROM SACH GROUP BY TheLoai";
            // GROUP BY TheLoai: Nhóm kết quả theo cột TheLoai =>  mỗi nhóm sẽ có một giá trị TheLoai và số lượng sách tương ứng.
            PreparedStatement pre = conn.prepareStatement(sql);		
            ResultSet result = pre.executeQuery();
     // 3. Xử lý kết quả và điền dữ liệu vào biểu đồ 
            while(result.next()){
                dataset.setValue( result.getString(1), result.getInt(2));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return dataset;
   }
 

// Kiểm tra xem sách có trong CSDL không 
    public boolean kiemTraTonTai(String maSach)
    {
        try {
            // 1. kết nối CSDL để lấy tất cả sách theo MaSach  => lưu kết quả truy vấn vào resultset
            // Sử dụng PreparedStatement giúp tránh lỗi cú pháp SQL và bảo vệ chống lại tấn công SQL Injection.
            // Dấu ? cho phép truyền tham số an toàn, thay vì nối chuỗi trực tiếp.
            String sql ="select * from SACH where MaSach=?" ;
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, maSach);
            ResultSet result = pre.executeQuery();
            // 2. Kiểm tra tồn tại 
            while (result.next()) return true ;
        } catch (Exception e) {
                e.printStackTrace();
        }

        return false ;
    }
}
