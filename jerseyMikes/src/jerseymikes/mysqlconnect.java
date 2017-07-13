package jerseymikes;

import java.sql.*;
import java.util.List;
public class mysqlconnect {
    Connection conn = null;

    public static Connection Db() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/cjose1db","cjose1","Cosc*n53t");
            System.out.println("Connection success!");
            return conn;
        } catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
 
}

