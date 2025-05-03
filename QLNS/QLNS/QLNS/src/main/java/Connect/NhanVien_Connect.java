package Connect;

import Model.NhanVien;

//Thu vien lam viec voi SQL
import java.sql.Date;
import java.sql.PreparedStatement;//tao cau lenh sql co tham so
import java.sql.ResultSet;
//Thu vien xu ly dinh dang
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Vector;

//Hien thi thong bao 
import javax.swing.JOptionPane;

public class NhanVien_Connect extends Connect_sqlServer{
    private DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    public ArrayList<NhanVien> layToanBoNhanVien(){
        ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
        try {
            String sql ="select MaNV, TenNV, NgaySinh, NgayVaoLam, SoChungMinh, ChucVu, SDT, Email, Luong from NHANVIEN,CHUCVU where NHANVIEN.MaCV = CHUCVU.MaCV" ;
            PreparedStatement pre = conn.prepareStatement(sql);//Tao cau lenh sql co the truyen tham so
            ResultSet result = pre.executeQuery(); //kq duoi dang bang 
            while(result.next())
            {
                NhanVien nv = new NhanVien();
                nv.setMaNV(result.getString(1));
                nv.setTenNV(result.getString(2));
                nv.setNgaySinh(df.format(result.getDate(3))); //df.format(): chuyen Date sang dd/mm/yy
                nv.setNgayVaolam(df.format(result.getDate(4)));
                nv.setSoChungMinh(result.getString(5));
                nv.setMaCV(result.getString(6));
                nv.setSDT(result.getString(7));
                nv.setEmail(result.getString(8));
                nv.setLuong(result.getDouble(9));
                dsnv.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dsnv;
    }
    // Them moi nv 
    public int themNhanVien(NhanVien nv){
        try {
            String sql ="INSERT INTO NHANVIEN (MaNV, TenNV, NgaySinh, NgayVaoLam, SoChungMinh, MaCV, SDT, Email, Luong) values (?,?,?,?,?,?,?,?,?) ";
            PreparedStatement pre  =  conn.prepareStatement(sql);
            pre.setString(1, nv.getMaNV());
            pre.setString(2, nv.getTenNV());
            pre.setString(3,  nv.getNgaySinh());
            pre.setString(4,  nv.getNgayVaolam());
            pre.setString(5, nv.getSoChungMinh());
            pre.setString(6, nv.getMaCV());
            pre.setString(7, nv.getSDT());
            pre.setString(8, nv.getEmail());
            pre.setDouble(9, nv.getLuong());
            return pre.executeUpdate();			

        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1 ;
    }
    //update nhân viên
    public int updateNhanVien(NhanVien nv){
        try {
            String sql ="update NHANVIEN set TenNV=?, NgaySinh=CONVERT(DATE, ?, 103), NgayVaoLam=CONVERT(DATE, ?, 103), SoChungMinh=?, MaCV=?, SDT=?, Email=?, Luong=? where MaNV=?" ;
            //CONVERT(DATE, ?, 103) chuyển chuỗi thành kiểu DATE, định dạng dd/MM/yyyy 
            PreparedStatement pre =conn.prepareStatement(sql);
            //truyen cac gia tri thuoc tinh (?)
            pre.setString(1, nv.getTenNV());
            pre.setString(2,  nv.getNgaySinh()+"");
            pre.setString(3, nv.getNgayVaolam()+"");
            pre.setString(4, nv.getSoChungMinh());
            pre.setString(5, nv.getMaCV());
            pre.setString(6, nv.getSDT());
            pre.setString(7, nv.getEmail());
            pre.setDouble(8, nv.getLuong());
            pre.setString(9, nv.getMaNV());

            return pre.executeUpdate();	//Thuc thi lenh INSERT (1 neu thanh cong)
        } catch (Exception e) {
                e.printStackTrace();
        }
        return -1;
    }
    //Xóa nhân viên
    public int xoaNhanVien(String manv ){
        try {
            String sql ="DELETE FROM NHANVIEN where MaNV=? " ;//xoa nhan vien theo MaNV
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, manv);
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    // lấy ra nhân viên có mã cho trước (kiểm tra đã tồn tại hay chưa)
    public boolean kiemTraTonTai(String manv)
    {
        NhanVien nv = new NhanVien();
        try {
            String sql ="select * from NHANVIEN where MaNV=?" ;
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, manv);
            ResultSet result = pre.executeQuery();
            while (result.next()) return true ;
        } catch (Exception e) {
                e.printStackTrace();
        }

        return false ;
    }
    //Tim kiem nhân viên theo keyword
    public ArrayList<NhanVien> timNhanVien(String key){
        ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
        try {
            String sql ="SELECT nv.*, cv.ChucVu " +
                    "FROM NHANVIEN nv " + 
                    "JOIN CHUCVU cv ON nv.MaCV = cv.MaCV " +
                    "WHERE nv.MaNV LIKE ? OR nv.TenNV LIKE ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, "%"+key+"%"); //%key%: tim tat ca cac chuoi co chua key o bat ky vi tri nao 
            pre.setString(2, "%"+key+"%");
            ResultSet result = pre.executeQuery();
            //Duyet kq va tao danh sach nv
            while(result.next()){
                NhanVien nv = new NhanVien();
                nv.setMaNV(result.getString(1));
                nv.setTenNV(result.getString(2));
                nv.setNgaySinh(df.format(result.getDate(3)));
                nv.setNgayVaolam(df.format(result.getDate(4)));
                nv.setSoChungMinh(result.getString(5));
                nv.setChucVu(result.getString(10));
                nv.setSDT(result.getString(7));
                nv.setEmail(result.getString(8));
                nv.setLuong(result.getDouble(9));
                dsnv.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsnv ;
    }
}
