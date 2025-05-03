package Model;
public class KhachHang {
    private String MaKH;
    private String TenKH;
    private String Sdt;
    private double Diem;
    
    public KhachHang(){
        super();
    }
    
    public String getMaKH(){
        return this.MaKH;
    }
    
    public void setMaKH(String makh){
        this.MaKH = makh;
    }
    
    public String getTenKH(){
        return this.TenKH;
    }
    
    public void setTenKH(String ten){
        this.TenKH=ten;
    }
    
    public String getSdt(){
        return this.Sdt;
    }
    
    public void setSdt(String sdt){
        this.Sdt=sdt;
    }
    
    public double getDiem(){
        return this.Diem;
    }
    
    public void setDiem(double diem){
        this.Diem=diem;
    }
}
