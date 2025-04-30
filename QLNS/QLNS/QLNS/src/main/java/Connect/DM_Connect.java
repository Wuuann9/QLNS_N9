package Connect;

import Model.DM;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class DM_Connect extends Connect_sqlServer {
    //lấy toàn bộ danh muc

    public ArrayList<DM> layToanBoDanhMuc() {
        ArrayList<DM> dsdm = new ArrayList<DM>();
        try {
            String sql = "select * from DM";
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet result = pre.executeQuery();
            while (result.next()) {
                DM dm = new DM();
                dm.setMaDM(result.getString(1));
                dm.setTenDM(result.getString(2));
                dm.setMoTa(result.getString(3));
                dsdm.add(dm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsdm;
    }
    // lấy toàn bộ nhà xuất bản theo tên danh muc

    public ArrayList<DM> layDanhMucTheoTen(String tendm) {
        ArrayList<DM> dsdm = new ArrayList<DM>();
        try {
            String sql = "select * from DM where TenDM like ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, "%" + tendm + "%");
            ResultSet result = pre.executeQuery();
            while (result.next()) {
                DM dm = new DM();
                dm.setMaDM(result.getString(1));
                dm.setTenDM(result.getString(2));
                dm.setMoTa(result.getString(3));
                dsdm.add(dm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dsdm;
    }

    // Hàm thêm mới danh muc
    public int ThemMoiDM(DM dm) {
        try {
            String sql = "insert into DM values(?,?,?) ";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, dm.getMaDM() + "");
            pre.setString(2, dm.getTenDM() + "");
            pre.setString(3, dm.getMoTa() + "");
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public boolean kiemTraTonTai(String madm) {
        DM dm = new DM();
        try {
            String sql = "select * from DM where MaDM=?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, madm);
            ResultSet result = pre.executeQuery();
            while (result.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    //hàm xóa 1 DM

    public int XoaDM(String madm) {
        try {
            String sql = "delete from DM where MaDM=?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, madm);
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;
    }
    //cap nhật chỉnh sửa danh muc

    public int updateDM(DM dm) {
        try {
            if (dm.getMaDM() == null || dm.getMaDM().trim().isEmpty()
                    || dm.getTenDM() == null || dm.getTenDM().trim().isEmpty()
                    || dm.getMoTa() == null || dm.getMoTa().trim().isEmpty()) {
                throw new IllegalArgumentException("Thông tin danh mục không được để trống.");
            }

            String sql = "UPDATE DM SET TenDM=?, MoTa=? WHERE MaDM=?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, dm.getTenDM());
            pre.setString(2, dm.getMoTa());
            pre.setString(3, dm.getMaDM());

            int rowsAffected = pre.executeUpdate();
            if (rowsAffected == 0) {
                System.err.println("Không tìm thấy danh mục cần chỉnh sửa.");
            }
            return rowsAffected;
        } catch (IllegalArgumentException e) {
            System.err.println("Lỗi đầu vào: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi khi cập nhật danh mục: " + e.getMessage());
            e.printStackTrace();
        }
        return -1; // Trả về -1 khi lỗi xảy ra
    }

    public ArrayList<DM> TimTenDMmacdinh(String key) {
        ArrayList<DM> dsdm = new ArrayList<DM>();
        try {
            String sql = "select * from DM where MaDM like ? or TenDM like ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, "%" + key + "%");
            pre.setString(2, "%" + key + "%");
            ResultSet result = pre.executeQuery();
            while (result.next()) {
                DM dm = new DM();
                dm.setMaDM(result.getString(1));
                dm.setTenDM(result.getString(2));
                dm.setMoTa(result.getString(3));
                dsdm.add(dm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsdm;
    }

    public DM TimTenDM(String key) {
        DM dm = new DM();
        try {
            String sql = "select * from DM where MaDM like ? or TenDM like ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, "%" + key + "%");
            pre.setString(2, "%" + key + "%");
            ResultSet result = pre.executeQuery();
            while (result.next()) {
                dm.setMaDM(result.getString(1));
                dm.setTenDM(result.getString(2));
                dm.setMoTa(result.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dm;
    }

    public DM TimTenDMCheckBox(String tenDM) {
        DM dm = new DM();
        try {
            String sql = "select top 1 MaDM, TenDM from DM where TenDM=?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, tenDM);
            ResultSet result = pre.executeQuery();
            while (result.next()) {
                dm.setMaDM(result.getString(1));
                dm.setTenDM(result.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dm;
    }

}
