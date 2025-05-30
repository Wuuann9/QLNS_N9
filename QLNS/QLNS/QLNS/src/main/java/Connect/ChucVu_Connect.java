package Connect;

import Model.ChucVu;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ChucVu_Connect extends Connect_sqlServer{
    public ArrayList<ChucVu> layToanBoChucVu(){
        ArrayList<ChucVu> dscv = new ArrayList<ChucVu>();
        try{
            String sql ="select * from CHUCVU" ;
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet result = pre.executeQuery();
            while(result.next()){
                ChucVu cv = new ChucVu();
                cv.setMaCV(result.getString(1));
                cv.setChucVu(result.getString(2));
                dscv.add(cv);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return dscv;
    }
    
    public ChucVu TimChucVu(String Chucvu){
        ChucVu cv = new ChucVu();
        try{
            String sql ="select top 1 MaCV, ChucVu from CHUCVU where ChucVu=?" ;
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, Chucvu);
            ResultSet result = pre.executeQuery();
            while (result.next()) {
                cv.setMaCV(result.getString(1));
                cv.setChucVu(result.getString(2));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return cv;
    }
}
