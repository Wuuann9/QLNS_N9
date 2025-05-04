package Connect;   // khai bao class nay nam trong package Connect

import java.sql.PreparedStatement; // lay cac thu vien cua sql
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.sql.Statement;  // ho tro xu li loi

import Model.TaiKhoan; // lay class tu lop tai khoan trong Model 

public class login_sql extends Connect_sqlServer{   // lop dang nhap ke thua tu connect sql server tu package Connect
	
    public TaiKhoan login (String user , String pass){ // lop dang nhap tra ve
        String sql = "select * from TAIKHOAN where username=? and password=?" ; // lay thong tin tu TAIKHOAN neu usename,paas dung ? la truyen sau 
        TaiKhoan tk = null;
        try {
            PreparedStatement pre  = conn.prepareStatement(sql); //tao 1 pre va tham so truyen
            pre.setString(1, user); // gan user o ?=1
            pre.setString(2, pass); // gan pass o ?=2
            ResultSet result = pre.executeQuery(); // tra ket qua 
            if(result.next()){ // neu dunng user va pass thi
            tk= new TaiKhoan(); // tao tk moi chua thong  tin tu bang TAIKHOAN
            tk.setMaTK(result.getString(1));   // gan gia tri tu bang TAIKHOAN theo vi tri cot tu trai qua phai
            tk.setUserName(result.getString(2));
            tk.setPassWord(result.getString(3));
            tk.setMaNV(result.getString(4));
        }

        } catch (Exception e) {  // xu ly ngoai le, Exception la lop cha cua tat ca cac loi trong khoi try
            e.printStackTrace(); // in ra chi tiet loi
        }   // neu muon kiem tra rieng loi sql thi dung SQLExecption
        return tk ; // tra ve doi tuong tai khoan sai thi tra ve null
    }

}
