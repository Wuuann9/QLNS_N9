
package Connect;
import Model.NhanVien;
import Model.TaiKhoan;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TaiKhoan_Connect extends Connect_sqlServer{  //truy xuat toan bo tai khoan roi luu vao lop array
    // tao ra tk 
    public ArrayList<TaiKhoan> layToanBoTaiKhoan(){  //kieu tra ve dstk
        ArrayList<TaiKhoan> dstk = new ArrayList<TaiKhoan>();  //tao lop luu dstk
        try{ // dung them kiem tra ngoai le  tryy(code co the gay ra loi) catch code xu ly khi xay ra loi
            String sql ="select * from TAIKHOAN" ; // lay toan bo dong cot tu bang taikhoan
            PreparedStatement pre = conn.prepareStatement(sql); //ket noi voi sql
            ResultSet result = pre.executeQuery();// chay luu ket qua tra ve bang 
            while(result.next()) // duyet tung dong trong bang 
            {
                TaiKhoan tk = new TaiKhoan();
                tk.setMaTK(result.getString(1)); // truy xuat csdl cot 1-4 gan vao tk 
                tk.setUserName(result.getString(2));//set la gan gia tri 
                tk.setPassWord(result.getString(3));
                tk.setMaNV(result.getString(4));
                
                tk.setBaoCao(result.getInt(5)); // gan gia tri tu csdl vao tk lay tu result
                tk.setTaiKhoan(result.getInt(6));
                tk.setMaVach(result.getInt(7));
                tk.setSach(result.getInt(8));
                tk.setNXB(result.getInt(9));
                tk.setNhanVien(result.getInt(10));
                tk.setHoaDon(result.getInt(11));
                tk.setNCCVPP(result.getInt(12));
                tk.setVPP(result.getInt(13));
                tk.setKhachHang(result.getInt(14));
                dstk.add(tk); // sau khi set xong no se them 1 tk moi vao dstk bang array 
            }

        }catch (Exception e) {
            e.printStackTrace();// bat loi va in ra thong tin dong loi 
        }
        return dstk;
    }
    
    //Tìm tài khoản theo keyword
    public ArrayList<TaiKhoan> timTaiKhoan(String key){  // dung array do ket qua tra ve nhieu ket 
        ArrayList<TaiKhoan> dstk = new ArrayList<TaiKhoan>();
        try {
            String sql ="select * from TAIKHOAN where MaNV like ? " ;// like de so sanh chuoi gan dung 
            PreparedStatement pre = conn.prepareStatement(sql);// vidu key= NV0 no se tra ve NV001
            pre.setString(1, "%"+key+"%"); // % dai dien chuoi se thay the cho ?
            ResultSet result = pre.executeQuery();
            while(result.next())
            {
                TaiKhoan tk = new TaiKhoan();
                tk.setMaTK(result.getString(1));// lay gia tri cot 1 va gan vao matk
                tk.setUserName(result.getString(2));
                tk.setPassWord(result.getString(3));
                tk.setMaNV(result.getString(4));
                tk.setBaoCao(result.getInt(5));
                tk.setTaiKhoan(result.getInt(6));
                tk.setMaVach(result.getInt(7));
                tk.setSach(result.getInt(8));
                tk.setNXB(result.getInt(9));
                tk.setNhanVien(result.getInt(10));
                tk.setHoaDon(result.getInt(11));
                tk.setNCCVPP(result.getInt(12));
                tk.setVPP(result.getInt(13));
                tk.setKhachHang(result.getInt(14));
                dstk.add(tk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dstk ;
    }
    // tim tai khoan dua vao matk
    public TaiKhoan TimTaiKhoanBangMaTK(String matk){
        TaiKhoan tk = new TaiKhoan();
        try {
            String sql ="select top 1 * from TAIKHOAN where MaTK = ? " ; // dung de chon 1 dong tu bang tk co matk 
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, matk); // tham so matk se duoc truyen vao ? 
            ResultSet result = pre.executeQuery();
            while(result.next())
            {
                tk.setMaTK(result.getString(1));
                tk.setUserName(result.getString(2));
                tk.setPassWord(result.getString(3));
                tk.setMaNV(result.getString(4));
                tk.setBaoCao(result.getInt(5));
                tk.setTaiKhoan(result.getInt(6));
                tk.setMaVach(result.getInt(7));
                tk.setSach(result.getInt(8));
                tk.setNXB(result.getInt(9));
                tk.setNhanVien(result.getInt(10));
                tk.setHoaDon(result.getInt(11));
                tk.setNCCVPP(result.getInt(12));
                tk.setVPP(result.getInt(13));
                tk.setKhachHang(result.getInt(14));
            }
        } catch (Exception e) {
            e.printStackTrace();// bat loi va in ra thong tin dong loi
        }
        return tk;
    }
    // tim tai khoan trong csdl dua vao manv
     public TaiKhoan timTaiKhoanBangMaNV(String manv){
        TaiKhoan tk = new TaiKhoan(); //khoi tao 1 doi tuong tk de luu csdl 
        try {
            String sql ="select top 1* from TAIKHOAN where MaNV = ?" ; // chon 1 dong dau tien tu TAIKHOAN voi MANV=manv 
            PreparedStatement pre = conn.prepareStatement(sql);// tham so ? truyen tu csdl 
            pre.setString(1, manv); //truy van vi tri thu 1 MaNV = manv 
            ResultSet result = pre.executeQuery();
            while(result.next()){ // dong nay se la gan gia tri de tra ra de hien thi 
                tk.setMaTK(result.getString(1));
                tk.setUserName(result.getString(2));
                tk.setPassWord(result.getString(3));
                tk.setMaNV(result.getString(4));
                tk.setBaoCao(result.getInt(5));
                tk.setTaiKhoan(result.getInt(6));
                tk.setMaVach(result.getInt(7));
                tk.setSach(result.getInt(8));
                tk.setNXB(result.getInt(9));
                tk.setNhanVien(result.getInt(10));
                tk.setHoaDon(result.getInt(11));
                tk.setNCCVPP(result.getInt(12));
                tk.setVPP(result.getInt(13));
                tk.setKhachHang(result.getInt(14));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tk;
    }
    //kiem tra xem taikhoan co ton tai trong bang TAIKHOAN hay khong 
    public boolean kiemTraTonTai(String matk, String username, String manv)
    {
        try {
            String sql ="select * from TAIKHOAN where MaTk=? or username=? or MaNV = ?" ; //chon tu bang TAIKHOAN cac tham so 
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, matk);// truyen gia tri vao ? 
            pre.setString(2, username);
            pre.setString(3, manv);
            ResultSet result = pre.executeQuery();// luu du lieu nhu bang du lieu tam thoi 
            while (result.next()) return true ;// neu 1 trong 3 gia tri co thi tra ve true 
        } catch (Exception e) {
                e.printStackTrace();
        }

        return false ;
    }
    
    public int themTaiKhoan( TaiKhoan tk){ // dung kieu int de tra ve so luong dong  TAIKHOAN la kieu du lieu tu taikhoan.java
        try{
            String sql ="INSERT INTO TAIKHOAN (MaTk, MaNV, username, password, BaoCao, TaiKhoan, MaVach, Sach, NXB, NhanVien, HoaDon, NCCVPP, VPP, KhachHang) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
            PreparedStatement pre  =  conn.prepareStatement(sql);
            pre.setString(1, tk.getMaTK());// duoi nay them tai khoan se truy xuat tung cot voi viec lay get de tra ve thuoc tinh cua matk
            pre.setString(2, tk.getMaNV());
            pre.setString(3,  tk.getUserName());
            pre.setString(4,  tk.getPassWord());
            pre.setInt(5,  tk.getBaoCao());
            pre.setInt(6,  tk.getTaiKhoan());
            pre.setInt(7,  tk.getMaVach());
            pre.setInt(8,  tk.getSach());
            pre.setInt(9,  tk.getNXB());
            pre.setInt(10,  tk.getNhanVien());
            pre.setInt(11,  tk.getHoaDon());
            pre.setInt(12,  tk.getNCCVPP());
            pre.setInt(13,  tk.getVPP());
            pre.setInt(14,  tk.getKhachHang());
            return pre.executeUpdate();// danh cho insert tra ve kieu int 
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public int updateTaiKhoan(TaiKhoan tk){
        try {
            String sql ="update TAIKHOAN set MaNV=?, username=?, password=? , BaoCao=?, TaiKhoan=?, MaVach=?, Sach=?, NXB=?, NhanVien=?, HoaDon=?, NCCVPP=?, VPP=?, KhachHang=? where MaTk=?" ;
            PreparedStatement pre =conn.prepareStatement(sql);
            pre.setString(1, tk.getMaNV());
            pre.setString(2,  tk.getUserName());
            pre.setString(3,  tk.getPassWord());
            pre.setInt(4,  tk.getBaoCao());
            pre.setInt(5,  tk.getTaiKhoan());
            pre.setInt(6,  tk.getMaVach());
            pre.setInt(7,  tk.getSach());
            pre.setInt(8,  tk.getNXB());
            pre.setInt(9,  tk.getNhanVien());
            pre.setInt(10,  tk.getHoaDon());
            pre.setInt(11,  tk.getNCCVPP());
            pre.setInt(12,  tk.getVPP());
            pre.setInt(13,  tk.getKhachHang());
            pre.setString(14, tk.getMaTK());
            return pre.executeUpdate();	
        } catch (Exception e) {
                e.printStackTrace();
        }
        return -1;
    }
    // xoa tai khoan theo matk 
    public int xoaTaiKhoan(String matk ){
        try {
            String sql ="DELETE FROM TAIKHOAN where MaTk=? " ;
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, matk);
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
