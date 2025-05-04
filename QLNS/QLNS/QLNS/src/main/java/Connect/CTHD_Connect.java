
package Connect; // Xác định file này thuộc package Connect, dùng để chứa các class kết nối database


import Model.CTHD; //  Class lưu trữ thông tin chi tiết hóa đơn.
import java.sql.PreparedStatement; // Chuẩn bị câu lệnh SQL để thực thi.
import java.sql.ResultSet; //  Nhận dữ liệu trả về từ truy vấn SQL.
// Dùng để tạo bảng dữ liệu hiển thị trong giao diện (JTable).
import java.util.Vector;        
import javax.swing.table.DefaultTableModel; 


// thao tác với bảng CTHD trong CSDL
public class CTHD_Connect extends Connect_sqlServer{
    // thêm một dòng chi tiết hóa đơn vào bảng CTHD.
    public int ThemCT(CTHD cthd) {
        try {	
            String sql = "insert into CTHD values(?,?,?,?,?) " ; // Tạo câu lệnh SQL với 5 dấu ? (tương ứng 5 cột cần điền trong bảng CTHD)
            PreparedStatement pre = conn.prepareStatement(sql);// dùng " PreparedStatement"  để truy vấn an toàn hơn , tránh SQL injection
                                                               // " conn " là đối tượng tạo kết nối tới CSDL thuộc class cha Connect_sqlServer.
            // Lấy dữ liệu từ đối tượng cthd rồi set vào PreparedStatement.     
            // 1 2 3 4 5 là vị trí dấu ? với SetString(index,value) 
            pre.setString(1, cthd.getMaHD()+"");
            pre.setString(2, cthd.getMaSP()+"");
            pre.setString(3, cthd.getDonGia()+"");
            pre.setString(4, cthd.getSoLuong()+"");
            pre.setString(5, cthd.getThanhTien()+"");

            return pre.executeUpdate();	
            } 
        catch (Exception e) {
                    e.printStackTrace();
        }
        return -1 ;
    }
   
    // Lấy ra CTHD bằng MaHD
    public DefaultTableModel layCTHDBangMaHD(String mahd){
        // DefaultTableModel - một lớp trong Java Swing, được sử dụng để lưu trữ dữ liệu dạng bảng (các hàng và cột) để hiển thị trên JTable.
        //1.  Tạo bảng CTHD gồm 4 cột
        DefaultTableModel dtm_cthd = new DefaultTableModel(); // tạo 1 bảng trống
        dtm_cthd.addColumn("Tên sản phẩm");
        dtm_cthd.addColumn("Đơn giá");
        dtm_cthd.addColumn("Số lượng");
        dtm_cthd.addColumn("Thành tiền");
        dtm_cthd.setRowCount(0); // Đặt số hàng của bảng về 0 (xóa toàn bộ dữ liệu hiện tại nếu có) => bảng bắt đầu trống trước khi thêm dữ liệu mới.
        // 2. Lấy data từ CSDL => lưu kết quả và ResultSet
        try {	
            String sql = "SELECT S.TenSach, V.TenVPP, C.SoLuong, C.DonGia, C.ThanhTien  FROM HOADON AS H LEFT JOIN CTHD AS C ON H.MaHD= C.MaHD LEFT JOIN SACH AS S ON C.MaSP=S.MaSach LEFT JOIN VPP AS V ON C.MaSP=V.MaVPP WHERE H.NhapSach=0 AND H.ThanhCong=1 AND H.MaHD = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, mahd);
            ResultSet result  = pre.executeQuery();
            // 3. lấy kết quả từ ResultSet vào bảng CTHD
            while(result.next())
            // 1 là TenSach,2 là TenVPP,3 là Soluong, 4 là DonGia, 5 là ThanhTien
            {
                Vector<Object> vec = new Vector<Object>();
                // Vì một sản phẩm chỉ có thể là sách hoặc văn phòng phẩm (không thể là cả hai),
                //=>  một trong hai cột TenSach hoặc TenVPP sẽ là null.
                if(result.getString(1)!=null)
                    vec.add(result.getString(1));
                if(result.getString(2)!=null)
                    vec.add(result.getString(2));
                vec.add(result.getString(3));
                vec.add(result.getString(4));
                vec.add(result.getString(5));
                dtm_cthd.addRow(vec);
            }
        } 
        catch (Exception e) {
                    e.printStackTrace();
        }
        return dtm_cthd;
    }
}
