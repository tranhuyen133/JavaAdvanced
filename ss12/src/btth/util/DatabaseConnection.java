package btth.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.Class.forName;

public class DatabaseConnection {
    //driver
    private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    //url
    private final static String URL = "jdbc:mysql://localhost:3306/hospital";

    //user
    private final static String USER = "root";

    //password
    private final static String PASSWORD = "Huyen1303";
    private static Object Class;

    public static Connection openConnection(){
        Connection con = null ;
        try {
            //khai báo cho Class biết DRIVER
            Class.forName(DRIVER);
            // mở
            con = DriverManager.getConnection(URL,USER,PASSWORD);
        }catch(classNotFoundException | SQLException e ){
            throw new RuntimeException(e);
        }
        return con;

    }
}
