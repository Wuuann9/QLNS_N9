package Model;

public class NhaCungCap_VPP {

    private String maNCCVPP;
    private String tenNCCVPP;
    private String SDT;
    private String diaChi;
    private String email;

    public NhaCungCap_VPP() {
        super();
    }

   
    public String getMaNCCVPP() {
        return maNCCVPP;
    }

 
    public void setMaNCCVPP(String maNCCVPP) {
        this.maNCCVPP = maNCCVPP;
    }

 
    public String getTenNCCVPP() {
        return tenNCCVPP;
    }

 
    public void setTenNCCVPP(String tenNCCVPP) {
        this.tenNCCVPP = tenNCCVPP;
    }

    
    public String getSDT() {
        return SDT;
    }

  
    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

   
    public String getDiaChi() {
        return diaChi;
    }

  
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

  
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return this.tenNCCVPP;
    }

}
