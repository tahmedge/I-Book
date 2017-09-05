
import java.sql.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Vogi
 */
public class SignUp {

    private String driverPath = "com.mysql.jdbc.Driver";
    private String Url = "jdbc:mysql://localhost:3306/ibook";
    private String UserName = "root";
    private String PassWord = "";
    public static String[] uname = new String[990];
    public static String[] pass = new String[990];
    public static String[][] status = new String[990][990];
    public static int statustrack[] = new int[990];
    public static int sentboxtrack[] = new int[990];
    public static int inboxtrack[] = new int[990];
    public static int statuslike[][] = new int[990][990];
    public static int statusliketrack[][][] = new int[90][90][90];
    public static int walllike[][] = new int[90][90];
    public static int wallliketrack[][][] = new int[90][90][90];
    public static int nfutrack[] = new int[99];
    public static int nfstrack[] = new int[99];
    public static int newsfeedindex;
    public static int total;
    public static String [][] statuscomment = new String[990][90];
    public static int statuscommenttrack[][] = new int[90][90];

    public Connection sqlConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driverPath);
        Connection con = DriverManager.getConnection(Url, UserName, PassWord);
        return con;
    }

    public void printAll() throws ClassNotFoundException, SQLException {
        Connection con = sqlConnection();
        Statement stm = con.createStatement();
        String query = "select * from signup";
        ResultSet rs = stm.executeQuery(query);
        int i = 0;
        while (rs.next()) {
            System.out.println();
            System.out.println("Data No. " + (i + 1));
            System.out.println("Name: " + rs.getString("Name"));
            System.out.println("UserName: " + rs.getString("UserName"));
            System.out.println("Password: " + rs.getString("Password"));
            System.out.println("Email: " + rs.getString("Email"));
            System.out.println("Id: " + rs.getInt("Id"));

            i++;
        }

    }

    public void load() throws ClassNotFoundException, SQLException {
        Connection con = sqlConnection();
        Statement stm = con.createStatement();
        String query = "select * from signup";
        ResultSet rs = stm.executeQuery(query);
        int i = 0;
        while (rs.next()) {

            uname[i] = rs.getString("UserName");
            pass[i] = rs.getString("Password");
            System.out.println(uname[i]);



            i++;
        }
        total = i;

    }

    public void addValue() throws ClassNotFoundException, SQLException {
        Connection con = sqlConnection();
        Statement stm = con.createStatement();
        String query = "Insert into signup values('Owners','Admins','01','admins@yahoo.com','5')";
        stm.executeUpdate(query);
        System.out.println("Data Inserted Successfully");
    }

    public void delValue() throws ClassNotFoundException, SQLException {
        Connection con = sqlConnection();
        Statement stm = con.createStatement();
        String query = "Delete from signup where Id=5";
        stm.executeUpdate(query);
        System.out.println("Data Deleted Successfully");
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        SignUp s = new SignUp();

        s.load();
        //s.delValue();
        //s.printAll();
    }
}
