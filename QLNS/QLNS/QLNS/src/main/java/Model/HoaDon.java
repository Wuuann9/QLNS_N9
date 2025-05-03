package Model;

import java.util.Date;

public class HoaDon {
    // fields 
	private String maHD ;
	private String maNV ;
        private String maKH;
	private String ngaylap ;
	private double tongTien;
	private int ThanhCong ; //  trạng thái thanh toán hóa đơn : 1 là thành công , 0 là chưa 
        private int nhapSach ; //  trạng thái nhập sách : 1 là nhập sách về kho, 0 là bán cho khách 
        
        // constructor : 
	public HoaDon() {
		super();//  gọi constructor mặc định  Object() , có thể bỏ super() mà k ảnh hưởng
	}
        
        //methods
        // method 1: lấy mã hóa đơn
	public String getMaHD() {
		return maHD;
	}
        // method 2 : sửa mã hóa đơn 
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
        // method 3 : lấy mã nhân viên 
	public String getMaNV() {
		return maNV;
	}
        // method 4 : sửa mã nhân viên 
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
        // method 5 : lấy mã khách hàng
        public String getMaKH(){
            return maKH;
        }
        // method 6 : sửa mã khách hàng 
        public void setMaKH(String makh){
            this.maKH = makh;
        }
        // method 7 : lấy ngày lập hóa đơn 
	public String getNgaylap() {
		return ngaylap;
	}
       // method 8 : sửa ngày lập hóa đơn 
	public void setNgaylap(String ngaylap) {
		this.ngaylap = ngaylap;
	}
        // method 9 : lấy tổng tiền
	public double getTongTien() {
		return tongTien;
	}
        // method 10 : sửa tổng tiền 
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
        // method 11 : lấy trạng thái hóa đơn 
	public int getTrangThai() {
		return ThanhCong;
	}
        // method 12 : sửa trạng thái hóa đơn 
	public void setTrangThai(int ThanhCong) {
		this.ThanhCong = ThanhCong;
	}
        // method 13 : nhập sách 
	public int getNhapSach() {
		return nhapSach;
	}
        // method 14 : sửa sách 
	public void setNhapSach(int nhapSach) {
		this.nhapSach = nhapSach;
	}

}
