package Connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect_sqlServer {
    protected Connection conn = null ;

    public Connect_sqlServer() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl="jdbc:sqlserver://"+"LAPTOP-RVO07K5P"+":1433;databaseName="+"dbQLNS"+";user=sa;password=1234567;";
            conn= DriverManager.getConnection(connectionUrl);         
        } 
        catch (Exception e) {
            e.printStackTrace();
        }	
    }
}
