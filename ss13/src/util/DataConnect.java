package btth.util;

public class DataConnect {
    //DRIVER
    private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    //URL
    private final static String URL= "jdbc:mysql://localhost:3306/banking?createDatabaseIfNotExist=tr";
    //USER
    private final static String USER = "root";
    //PASSWORD
    private final static String PASSWORD = "Huyen1303";

    public static Connection openConnection(){
        try {
            //khai báo DRIVER
            Class.forName(DRIVER);
            //mở kết nối
            con = DriverManager.getConnection(URL,USER,PASSWORD);

        }catch(ClassNotFoundException e){
            throw new RuntimeException(e);
        }
        return con;
    }
}
