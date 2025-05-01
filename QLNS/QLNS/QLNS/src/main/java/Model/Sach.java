package Model; //B:\BTL_OOP\QLNS_N9\QLNS\QLNS\QLNS\src\main\java\Model

public class Sach {
    // fields
	private String maSach ;
	private String tenSach;
	private String maNXB ;
	private String tacGia ;
	private double giaBan ;
	private String theLoai ;
	private int soLuong ;
        private int discount;
        
    // constructor
	public Sach() {
		super();
	}

    // methods
    // method 1: lấy mã sách
	public String getMaSach() {
		return maSach;
	}
    // method 2 : sửa mã sách 
	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}
    // method 3 : 
	public String getTenSach() {
		return tenSach;
	}
    // method 4 : sửa tên sách
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
    // method 5: lấy  mã NXB
	public String getMaNXB() {
		return maNXB;
	}
    // method 6: sửa mã NXB
	public void setMaNXB(String maNXB) {
		this.maNXB = maNXB;
	}
   // method 7 : lấy tên tác giả 
	public String getTacGia() {
		return tacGia;
	}
    // method 8 : sửa tên tác giả 
	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}
    // method 9: lấy giá 
	public double getGiaBan() {
		return giaBan;
	}
    // method 10: sửa giá 
	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}
    // method 11: lấy thể lại
	public String getTheLoai() {
		return theLoai;
	}
    // method 12 : sửa thể loại
	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}
    // method 13 : lấy số lượng
	public int getSoLuong() {
		return soLuong;
	}
    // method 14: sửa số lượng 
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}


    // in theo mẫu : khi in đối tượng Sach thì chỉ in ra 1  thuộc tính "tenSach";
        @Override
	public String toString() {
		return this.tenSach;
	}
    // method 16 : lấy mã giảm giá 
        public int getDiscount(){
            return this.discount;
        }
    // method 17 : sửa giá trị mã giảm giá 
	public void setDiscount(int discount){
            this.discount = discount;
        }
        
	

}
