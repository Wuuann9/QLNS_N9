package Connect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Model.HoaDon;
import java.sql.CallableStatement;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import org.jfree.data.category.DefaultCategoryDataset;

public class HoaDon_Connect extends Connect_sqlServer{
    
    public ArrayList<HoaDon> LayTatCaHoaDon(){
        ArrayList<HoaDon> dshd = new ArrayList<HoaDon>();
        try {
            String sql = "select * from HOADON where ThanhCong=1 and NhapSach=0" ;
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet result  = pre.executeQuery();
            while(result.next()){
                HoaDon hd = new HoaDon();
                hd.setMaHD(result.getString(1));
                hd.setMaNV(result.getString(2));
                hd.setMaKH(result.getString(3));
                hd.setNgaylap(result.getDate(4)+"");
                hd.setTongTien(result.getDouble(5));
                dshd.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dshd ;
    }

    
// Lấy toàn bộ hóa đơn theo tháng và năm 
    public DefaultTableModel layToanBoHoaDonTheoThangNam(String month , String year)
    {
        // 1. Tạo bảng mới và add 5 cột 
        DefaultTableModel dshd = new DefaultTableModel();
        dshd.addColumn("Mã hóa Đơn");
        dshd.addColumn("Nhân viên");
        dshd.addColumn("Khách hàng");
        dshd.addColumn("Ngày lập");
        dshd.addColumn("Tổng tiền");
        dshd.setRowCount(0); // Đặt số hàng của dshd về 0, đảm bảo bảng trống trước khi thêm dữ liệu mới.
        
        // 2.Truy vấn CSDL để lấy data
        // DÙNG LEFT JOIN vì : Đảm bảo tất cả hóa đơn từ bảng HOADON được trả về, bất kể có thông tin nhân viên hoặc khách hàng có đủ hay không 
        String sql = "";
        try {
            // NẾU THÁNG =0  => IN RA TẤT CẢ HÓA ĐƠN TRONG NĂM 
            if("0".equals(month))
                sql = "select H.MaHD, N.TenNV, K.TenKH, NgayLap, TongTien from HOADON AS H LEFT JOIN NHANVIEN AS N ON H.MaNV=N.MaNV LEFT JOIN KHACHHANG AS K ON H.MaKH=K.MaKH where Year(NgayLap) = ? and ThanhCong = 1 and NhapSach=0" ;
            // THÁNG !=0   => IN RA THEO THÁNG ĐÓ 
            else
                sql = "select H.MaHD, N.TenNV, K.TenKH, NgayLap, TongTien from HOADON AS H LEFT JOIN NHANVIEN AS N ON H.MaNV=N.MaNV LEFT JOIN KHACHHANG AS K ON H.MaKH=K.MaKH where MONTH(NgayLap) = ? and Year(NgayLap) = ? and ThanhCong = 1 and NhapSach=0" ;
        
           // 3. Chuẩn bị và gán tham số cho truy vấn
            PreparedStatement pre = conn.prepareStatement(sql); // PreparedStatement cho phép gán tham số an toàn.
            if ("0".equals(month))
                pre.setString(1, year);
            else {
                pre.setString(1,month); // ? thứ 1 là month
                pre.setString(2, year); // ? thứ 1 là year
            }
            
            // 4. Thực thi truy vấn và xử lý kết quả
            ResultSet result  = pre.executeQuery(); // thực thi câu truy vấn SQL và trả về một ResultSet, chứa các hàng dữ liệu từ cơ sở dữ liệu.
            while(result.next()) // result.next() di chuyển con trỏ đến hàng tiếp theo
            {
                Vector<Object> vec = new Vector<Object>();
                vec.add(result.getString(1));
                vec.add(result.getString(2));
                vec.add(result.getString(3));
                vec.add(result.getString(4));
                vec.add(result.getString(5));
                dshd.addRow(vec); // thêm hàng dữ liệu (vec) vào DefaultTableModel dshd, tạo một hàng mới trong bảng.
            }

        } catch (Exception e) {
                e.printStackTrace();
        }
        return dshd ;
    }
 
    
    
// Hmà Lấy toàn bộ hóa đơn trong ngày 
    public DefaultTableModel layToanBoHoaDonHomNay()
    {
        
        // 1. Lấy ngày, tháng, năm hiện tại từ hệ thống.
        Calendar cal = Calendar.getInstance(); // đại diện cho thời điểm hiện tại của hệ thống, dựa trên múi giờ và locale mặc định.
        int day = cal.get(Calendar.DAY_OF_MONTH); // lấy ngày hiện tại 
        int month = cal.get(Calendar.MONTH) + 1; // Lấy tháng hiện tại. Trong Java, Calendar.MONTH trả về giá trị từ 0 (tháng 1) đến 11 (tháng 12), nên cần +1 để lấy tháng thực tế (1–12).
        int year =cal.get(Calendar.YEAR);   // lấy năm hiện tại 
        
        // 2. Tạo một DefaultTableModel để lưu trữ dữ liệu hóa đơn.
        DefaultTableModel dshd = new DefaultTableModel();
        dshd.addColumn("Mã hóa Đơn");
        dshd.addColumn("Nhân viên");
        dshd.addColumn("Khách hàng");
        dshd.addColumn("Ngày lập");
        dshd.addColumn("Tổng tiền");
        dshd.setRowCount(0); // Đặt số hàng của dshd về 0, đảm bảo bảng trống trước khi thêm dữ liệu mới.
        
        // 3. Truy vấn SQL để lấy hóa đơn trong ngày hiện tại.
        try {
            String sql = "select H.MaHD, N.TenNV, K.TenKH, NgayLap, TongTien from HOADON AS H LEFT JOIN NHANVIEN AS N ON H.MaNV=N.MaNV LEFT JOIN KHACHHANG AS K ON H.MaKH=K.MaKH where Day(NgayLap)=? and MONTH(NgayLap)=? and Year(NgayLap) = ? and ThanhCong = 1 and NhapSach=0";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, day);  // ? 1
            pre.setInt(2, month);// ? 2
            pre.setInt(3, year); // ? 3
            ResultSet result  = pre.executeQuery(); // thực hiện lệnh select
            
        // 4. Đưa dữ liệu vào DefaultTableModel để sử dụng trong bảng giao diện.
            while(result.next())
            {
                Vector<Object> vec = new Vector<Object>();
                vec.add(result.getString(1));
                vec.add(result.getString(2));
                vec.add(result.getString(3));
                vec.add(result.getString(4));
                vec.add(result.getString(5));
                dshd.addRow(vec); // thêm 1 hàng dữ liệu mới gồm 5 cột data ở trên (vec)
            }

        } catch (Exception e) {
                e.printStackTrace();
        }
        return dshd ;
    }
	

    // lấy ra "MaHD" mới nhất từ CSDL "HOADON"
    public String LastMaHD(){
        try{
            //String sql = "select * from hoadon ORDER BY mahd DESC LIMIT 1" ;
            String sql = "SELECT TOP 1 * FROM hoadon ORDER BY mahd DESC";// lấy bản ghi chứa mã hóa đơn mới nhất = dòng 1
            Statement statement = conn.createStatement(); //Tạo một đối tượng Statement để gửi câu lệnh SQL đến cơ sở dữ liệu (conn là kết nối Database).
            ResultSet result = statement.executeQuery(sql);// lấy mã hóa đơn lớn nhất lưu vào resultst
            while(result.next()) return result.getString(1);   // Lấy giá trị của cột đầu tiên (cột 1) trong dòng vừa đọc được.
                                                               // Ở đây vì SELECT *, nên cột 1 chính là mahd (mã hóa đơn).
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    
    
//
    public DefaultCategoryDataset DoanhThuCacThang(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try{
            String sql = "{call DoanhThuCacThang()}";
             CallableStatement  stmt  = conn.prepareCall(sql);	  //stored provedure thu tu luu tru 	
            ResultSet result = stmt.executeQuery();
            while(result.next()){ // lap qua tung dong 
                dataset.addValue( Double.parseDouble(result.getString(2)),"Doanh thu bán hàng",result.getString(1));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return dataset;
    }

// HÀM Đẩy hóa đơn vào CSDL
    public int TaoHD(HoaDon hd) {
        try {
            String sql="insert into hoadon values(?,?,?,?,?,?,?) " ;
            PreparedStatement pre =conn.prepareStatement(sql);
            pre.setString(1, hd.getMaHD()+"");
            pre.setString(2, hd.getMaNV()+"");
            pre.setString(3, hd.getMaKH()+"");
            pre.setString(4, hd.getNgaylap()+"");
            pre.setString(5, hd.getTongTien()+"");
            pre.setString(6, hd.getTrangThai()+"");
            pre.setString(7, hd.getNhapSach()+"");
            return pre.executeUpdate();
        } catch (Exception e) {
                e.printStackTrace();
        }
        return -1 ;
    }
    
    public int TaoHDTuSach(HoaDon hd) {
       try {
            String sql="insert into hoadon values(?,?,?,?,?,?,?) " ;
            PreparedStatement pre =conn.prepareStatement(sql);
            pre.setString(1, hd.getMaHD()+"");
            pre.setString(2, hd.getMaNV()+"");
            pre.setString(3, hd.getMaKH()+"");
            pre.setString(4, hd.getNgaylap()+"");
            pre.setString(5, hd.getTongTien()+"");
            pre.setString(6, hd.getTrangThai()+"");
            pre.setString(7, hd.getNhapSach()+"");
            return pre.executeUpdate();
        } catch (Exception e) {
                e.printStackTrace();
        }
        return -1 ;
    }
    
    
    // hàm cập nhật mã khách hàng (makh) vào hóa đơn (mahd) trong CSDL "HOADON" .
    // => ĐẢM BẢO truy vấn được hóa đơn thuộc về khách hàng nào
    public int capNhatMaKH(String makh, String mahd){
        try {
            String sql="update hoadon set makh = ? where mahd=?" ;
            PreparedStatement pre =conn.prepareStatement(sql);
            pre.setString(1, makh);
            pre.setString(2, mahd);
            return pre.executeUpdate();// HÀM THỰC HIỆN UPDATE
        } catch (Exception e) {
                e.printStackTrace();
        }
        return -1;
    }
    
    
    
    // hàm dùng để:
    // Cập nhật hóa đơn đã thanh toán (ThanhCong = 1)
    // Cập nhật tổng tiền (TongTien)
    // Chỉ áp dụng cho hóa đơn bán hàng (không phải nhập sách) → NhapSach = 0
    public int ThanhToan(String MaHD, String total){
        try{
            // NhapSach = 0 → là hóa đơn bán hàng  bán hàng 
            // NhapSach = 1 → là hóa đơn nhập hàng về kho 
            String sql="update hoadon set ThanhCong = 1, TongTien = ? where MaHD=? and NhapSach=0" ;
            PreparedStatement pre =conn.prepareStatement(sql);
            pre.setString(1,total); // total = tong tien moi 
            pre.setString(2,MaHD+"");// Chỉ cập nhật hóa đơn bán hàng có mã khớp
                                     // +"" là ép kiểu sang String nếu lỡ MaHD là số
            return pre.executeUpdate();// thực hiện update 
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return -1; //  là thanh toán thất bại
    }
    
    
    // xóa một hóa đơn khỏi cơ sở dữ liệu dựa trên MaHD (mã hóa đơn)
    public int HuyHoaDon(String MaHD){
        try{
            String sql="DELETE FROM HOADON WHERE MaHD=?" ; // xóa hóa đơn có MaHD = ? (ví dụ ? = "HD02")
            PreparedStatement pre =conn.prepareStatement(sql);// câu lệnh SQL này để truyền giá trị vào dấu ?(chỗ trông đại diện) .
            pre.setString(1,MaHD);// 1 là dấu ? thứ 1
            return pre.executeUpdate();//Thực thi lệnh SQL và trả về số dòng bị ảnh hưởng 
                                       // là 1 nếu xóa thành công, 0 nếu không có mã hóa đơn nào khớp.
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }
}
