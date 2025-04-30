/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connect;


import Model.ChucVu;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import Model.NXB;
import Model.Sach;
import Model.DanhMuc;
import Model.TonKho;
import java.sql.CallableStatement;
import java.util.Calendar;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class DanhMuc_Connect extends Connect_sqlServer {

    public ArrayList<DanhMuc> layToanBoDanhMuc() {
        ArrayList<DanhMuc> dss = new ArrayList<DanhMuc>();
        try {
            String sql = "select MaSach, TenSach, TenNXB, TacGia, TheLoai, SoLuong from DANHMUC,NXB where DANHMUC.MaNXB = NXB.MaNXB";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                DanhMuc s = new DanhMuc();
                s.setMaSach(result.getString(1));
                s.setTenSach(result.getString(2));
                s.setMaNXB(result.getString(3));
                s.setTacGia(result.getString(4));
                s.setTheLoai(result.getString(5));
                s.setSoLuong(result.getInt(6));
                dss.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dss;
    }

    // hàm lấy danh sách theo maNXB và tên sách
    public ArrayList<DanhMuc> laySachTheoNXBTen(String manxb, String ten) {
        ArrayList<DanhMuc> dss2 = new ArrayList<DanhMuc>();
        try {
            String sql = "select MaSach, TenSach, TenNXB, TacGia, TheLoai, SoLuong from DANHMUC,NXB where DANHMUC.MaNXB = NXB.MaNXB and MaNXB=? and TenSach like ? ";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, manxb);
            pre.setString(2, "%" + ten + "%");

            ResultSet result = pre.executeQuery();
            while (result.next()) {
                DanhMuc s = new DanhMuc();
                s.setMaSach(result.getString(1));
                s.setTenSach(result.getString(2));
                s.setMaNXB(result.getString(3));
                s.setTacGia(result.getString(4));
                s.setTheLoai(result.getString(5));
                s.setSoLuong(result.getInt(6));
                dss2.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dss2;
    }

    // ham lay doanh sach theo ten sach
    public ArrayList<DanhMuc> laySachTheoMaTen(String maten) {
        ArrayList<DanhMuc> dss3 = new ArrayList<DanhMuc>();

        try {
            String sql = "select MaSach, TenSach, TenNXB, TacGia, TheLoai, SoLuong from DANHMUC,NXB where DANHMUC.MaNXB = NXB.MaNXB and TenSach like ? ";
            PreparedStatement pre1 = conn.prepareStatement(sql);
            pre1.setString(1, "%" + maten + "%");
            ResultSet result = pre1.executeQuery();
            while (result.next()) {
                DanhMuc s = new DanhMuc();
                s.setMaSach(result.getString(1));
                s.setTenSach(result.getString(2));
                s.setMaNXB(result.getString(3));
                s.setTacGia(result.getString(4));
                s.setTheLoai(result.getString(5));
                s.setSoLuong(result.getInt(6));
                dss3.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dss3;
    }

    public ArrayList<DanhMuc> laySachTheoTenTacGia(String tenTacGia) {
        ArrayList<DanhMuc> dss2 = new ArrayList<DanhMuc>();

        try {
            String sql = "select MaSach, TenSach, TenNXB, TacGia, GiaBan, TheLoai, SoLuong, Discount from SACH,NXB where SACH.MaNXB = NXB.MaNXB and TacGia like ? ";
            PreparedStatement pre1 = conn.prepareStatement(sql);
            pre1.setString(1, "%" + tenTacGia + "%");
            ResultSet result = pre1.executeQuery();
            while (result.next()) {
                DanhMuc s = new DanhMuc();
                s.setMaSach(result.getString(1));
                s.setTenSach(result.getString(2));
                s.setMaNXB(result.getString(3));
                s.setTacGia(result.getString(4));
                s.setTheLoai(result.getString(5));
                s.setSoLuong(result.getInt(6));
                dss2.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dss2;
    }
    
    public ArrayList<DanhMuc> laySachTheoMaTenVaTenTacGia(String maten, String tenTacGia)
    {
        ArrayList<DanhMuc> dss4 = new ArrayList<DanhMuc>();

        try {
            String sql = "select MaSach, TenSach, TenNXB, TacGia, TheLoai, SoLuong from SACH,NXB where SACH.MaNXB = NXB.MaNXB and TenSach like ? and TacGia like ?" ;
            PreparedStatement pre1 = conn.prepareStatement(sql);
            pre1.setString(1, "%"+maten+"%");
            pre1.setString(2, "%"+tenTacGia+"%");
            ResultSet result = pre1.executeQuery();
            while (result.next()){
                DanhMuc s = new DanhMuc();
                s.setMaSach(result.getString(1));
                s.setTenSach(result.getString(2));
                s.setMaNXB(result.getString(3));
                s.setTacGia(result.getString(4));
                s.setTheLoai(result.getString(5));
                s.setSoLuong(result.getInt(6));
                dss4.add(s);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return dss4;
    }

    // ham them moi vao csdl
    public int themSachMoi(DanhMuc s) {
        try {
            String sql = "insert into DANHMUC values (?,?,?,?,?,?)";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, s.getMaSach());
            pre.setString(2, s.getTenSach());
            pre.setString(3, s.getMaNXB());
            pre.setString(4, s.getTacGia());
            pre.setString(5, s.getTheLoai());
            pre.setInt(6, s.getSoLuong());
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;
    }

    public int XoaSach(String maSach) {
        try {
            String sql = "delete DANHMUC where MaSach=?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,maSach);

            return pre.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;
    }

    // hàm cập nhật chỉnh sửa sách 
    public int update(DanhMuc s) {
        try {
            String sql = "update DANHMUC set TenSach=? ,MaNXB=? ,TacGia=? ,TheLoai=?,SoLuong=? where MaSach=? ";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, s.getTenSach());
            pre.setString(2, s.getMaNXB());
            pre.setString(3, s.getTacGia());
            pre.setString(4, s.getTheLoai());
            pre.setInt(5, s.getSoLuong());
            pre.setString(6, s.getMaSach());

            return pre.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;
    }

    //Hàm update số lượng sách sau khi bán
    public int updateSL(String MaSach, int SL) {
        try {
            String sql = "update DANHMUC set SoLuong=? where MaSach=?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, SL);
            pre.setString(2, MaSach);

            return pre.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;
    }

    public boolean kiemTraTonTai(String maSach) {

        try {
            String sql = "select * from DANHMUC where MaSach=?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, maSach);
            ResultSet result = pre.executeQuery();
            while (result.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
