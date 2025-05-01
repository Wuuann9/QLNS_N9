//** Lớp Connect_sqlServer sẽ:
// 1. Tải driver JDBC cho SQL Server.
// 2. Tạo chuỗi kết nối với DB dbQLNS.
// 3. Kết nối và lưu vào biến conn để các class khác sử dụng.



package Connect; //** file connect chứa các lớp xử lý kết nối đến database, lấy dữ liệu, thêm, sửa, xóa...
                 //**( B:\QLNS\QLNS\QLNS\src\main\java\Connect )

import java.sql.Connection; //** Connection là đối tượng đại diện cho kết nối đến CSDL.
import java.sql.DriverManager;//** là lớp quản lý driver JDBC, dùng để tạo kết nối với SQL Server.

public class Connect_sqlServer {
    // dùng protected đảm bảo rằng biến conn chỉ có thể được truy cập bởi 
    //      + chính lớp Connect_sqlServer
    //      + các lớp kế thừa từ nó
    //      + các lớp khác trong cùng package Connect. 
    //=> kiểm soát quyền truy cập và bảo vệ kết nối.
    protected Connection conn = null ;//** Biến conn sẽ lưu đối tượng kết nối đến SQL Server.

    public Connect_sqlServer() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//** tải driver JDBC(Java Database Connectivity)cho SQL Server (bắt buộc để kết nối).
            //** tạo chuỗi kết nối bao gồm :
            //** DESKTOP-HUGLVTT( tên máy chủ đang chạy SQL server)
            //** 1433:  cổng mặc định của SQL Server.
            //** databaseName = dbQLNS: tên cơ sở dữ liệu muốn kết nối.
            String connectionUrl="jdbc:sqlserver://"+"DESKTOP-HUGLVTT"+":1433;databaseName="+"dbQLNS"+";user=sa;password=17112003;";
            conn = DriverManager.getConnection(connectionUrl); //**Tạo kết nối đến CSDL bằng DriverManager rồi lưu vào biến conn
                                                              //** => các class khác có thể sử dụng
        } 
        //** Nếu có lỗi khi kết nối (sai driver, sai tên DB, sai user/pass...), chương trình sẽ in lỗi ra console.
        catch (Exception e) {
            e.printStackTrace();
        }	
    }
}
