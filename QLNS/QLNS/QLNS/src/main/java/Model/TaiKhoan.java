package Model;

// contructor thuc hien cac phuong thuc set get
public class TaiKhoan {
	private String maTK;
	private String userName;
	private String passWord;
	private String maNV ;


        private int baoCao;
        private int taiKhoan;
        private int danhMuc;
        private int Sach;
        private int NXB;
        private int NhanVien;
        private int HoaDon;
        private int NCCVPP;
        private int VPP;
        private int KhacHang;
	public TaiKhoan() {
		super();
	}
	public String getMaTK() {
		return maTK;
	}
	public void setMaTK(String maTK) {
		this.maTK = maTK;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
        
        public int getBaoCao(){
            return this.baoCao;
        }
        
        public void setBaoCao(int baocao){
            this.baoCao = baocao;
        }
        
        public int getTaiKhoan(){
            return this.taiKhoan;
        }
        
        public void setTaiKhoan(int tk){
            this.taiKhoan = tk;
        }
        
        public int getDanhMuc(){

            return this.danhMuc;
        }
        
        public void setDanhMuc(int dm){
            this.danhMuc= dm;

        }
        
        public int getSach(){
            return this.Sach;
        }
        
        public void setSach(int s){
            this.Sach = s;
        }
        
        public int getNXB(){
            return this.NXB;
        }
        
        public void setNXB(int nxb){
            this.NXB = nxb;
        }
        
        public int getNhanVien(){
            return this.NhanVien;
        }
        
        public void setNhanVien(int nv){
            this.NhanVien = nv;
        }
        
        public int getHoaDon (){
            return this.HoaDon;
        }
        
        public void setHoaDon(int hd){
            this.HoaDon=hd;
        }
        
        public int getNCCVPP(){
            return this.NCCVPP;
        }
        
        public void setNCCVPP(int ncc){
            this.NCCVPP = ncc;
        }
        
        public int getVPP(){
            return this.VPP;
        }
        
        public void setVPP(int vpp){
            this.VPP = vpp;
        }
        
        public int getKhachHang(){
            return this.KhacHang;
        }
        
        public void setKhachHang(int kh){
            this.KhacHang = kh;
        }
}
