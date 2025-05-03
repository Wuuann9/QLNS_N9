package Model;

public class CTHD {
	private String maHD ;
	private String maSP;
	private double donGia ;
	private int soLuong ;
	private double thanhTien;
        // constructor
	public CTHD() {
		super();// super() gọi hàm tạo của lớp cha (Object, lớp cha mặc định của mọi lớp trong Java) . Bỏ cũng được 
	}
        
        // methods
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String masp) {
		this.maSP = masp;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}
}
