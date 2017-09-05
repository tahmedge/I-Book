package DB;


import java.sql.*;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author Vogi
 */
public class SignUp {

    private String driverPath = "com.mysql.jdbc.Driver";
    private String Url = "jdbc:mysql://10.220.53.216:3306/ibook";
    private String UserName = "xnServer";
    private String PassWord = "577119";
    PreparedStatement pst=null;
    public static String[] uname = new String[990];
    public static String[] pass = new String[990];
    public static String[][] status = new String[90][90];
    public static String[][] statTime = new String[90][90];
    public static String[][] wallpostTime = new String[90][90];
    public static String[][] messageTime = new String[90][90];
    public static int statustrack[] = new int[990];
    public static int sentboxtrack[] = new int[990];
    public static int walltrack[] = new int[990];
    public static int inboxtrack[] = new int[990];
    public static int statuslike[][] = new int[90][90];
    public static int statusliketrack[][][] = new int[90][90][90];
    public static int walllike[][] = new int[90][90];
    public static int wallliketrack[][][] = new int[90][90][90];
    public static String[][] wallcomment = new String[99][90];
    public static String[][] wallpost = new String[990][190];
    public static int wallcommenttrack[][] = new int[90][90];
    public static int nfutrack[] = new int[99];
    public static int nfstrack[] = new int[99];
    public static int wputrack[] = new int[99];
    public static int wpstrack[] = new int[99];
    public static int newsfeedindex;
    public static int searchindex;
    public static int wallindex;
    public static int total;
    public static String[] education_institute = new String[100];
    public static String[] working = new String[100];
    public static String[] email = new String[100];
    public static String[] sex = new String[100];
    public static String[] date_of_birth = new String[100];
    public static String[][] statuscomment = new String[990][90];
    public static int statuscommenttrack[][] = new int[90][90];
    public static String search;
    public static int sbutrack[] = new int[99];
    public static int messagelink[][] = new int[90][90];
    public static int checknewsms[][] = new int[90][90];
    public static int inboxlimit[] = new int[90];
    public static int sendsmslimit[][] = new int[90][90];
    public static String[][] message = new String[990][90];
    public static String[][] messagesubject = new String[990][90];
    public static String messagesender[][] = new String[990][90];
    public static int messagesendertrack[][] = new int[100][100];
    public static int messagechecktrack[][] = new int[100][100];
    public static int messagetrack[] = new int[100];
    public static String notificationstring[][] = new String[100][100];
    public static int notificationlimit[] = new int[100];
    public static int newnotification[] = new int[100];
    public static int notificationchecktrack[][] = new int[100][990];
    public static int Notificationtrack[] = new int[100];
    public static int Friendnotificationtrack[] = new int[100];
    public static int Notificationtype[][] = new int[100][990];
    public static int NotificationlinkUser[][] = new int[100][990];
    public static int NotificationlinkPost[][] = new int[100][990];
    public static int inboxindex;
    public static int friendindex;
    public static int frqtrack[] = new int[99];
    public static String frqstring[] = new String[150];
    public static String frndlist[] = new String[150];
    public static int newfrnd[] = new int[100];
    public static int frndchecker[][] = new int[30][30];
    public static int privacy[][] = new int[30][30];
    public static int educationprivacy[] = new int[300];
    public static int emailprivacy[] = new int[300];
    public static int workprivacy[] = new int[300];
    public static int friendlistprivacy[] = new int[300];
    public static int wallprivacy[] = new int[300];
    public static int statusprivacy[] = new int[300];
    public static int DOBprivacy[] = new int[300];
    public static int friendlisttrack;
    public static int frndlisttrack[] = new int[99];
    public static int inboxidtrack[] = new int[99];
    public static int online[] = new int[99];
    public static int wallfrom[][] = new int[99][99];
    public static String statusdisplay;
    public static String walldisplay;
    public static int newevent[] = new int[99];
    public static String dateofbirth[]=new String[99];
    public static String birthday[]=new String[99];
    public static byte[][] pic_byte = new byte[990][990];
    public static String[] uId = new String[990];
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

    public void loadMessage(String Id) throws ClassNotFoundException, SQLException {
        Connection con = sqlConnection();
        Statement stm = con.createStatement();
        String query = "select * from message WHERE Reciever_Id = '" + Id + "'";
        ResultSet rs = stm.executeQuery(query);
        int i = 0;
        int ui = Integer.parseInt(Id);
        while (rs.next()) {

            message[ui][i] = rs.getString("Message");
            messagesubject[ui][i] = rs.getString("Subject");
            messagesendertrack[ui][i] = Integer.parseInt(rs.getString("Sender_Id"));
            messagesender[ui][i] = uname[messagesendertrack[ui][i]];
            messageTime[ui][i]=rs.getString("Time");


            System.out.println(message[ui][i]);
            i++;
        }
        inboxlimit[ui] = i;
        //total = i;

    }

    public void addStatus(String no, String Id, String statNo, String Stat,String time) throws ClassNotFoundException, SQLException {
        Connection con = sqlConnection();
        Statement stm = con.createStatement();
        //total++;
        //if(pas.compareTo(conpas)==0){
        //String query = "Insert into login values('"+total+"','"+unm+"','"+pas+"','"+utyp+"','"+id+"')";
        String query = "Insert into status values('" + no + "','" + Id + "','" + statNo + "','" + Stat + "','','0','0','" + time + "')";
        stm.executeUpdate(query);
        System.out.println(Stat);
        //stm.executeUpdate(query2);
        System.out.println("Data Inserted Successfully");
    }
    
   

    public void addWallpost(String no, String Id, String wpostNo, String wpost, String postFrom, String time) throws ClassNotFoundException, SQLException {
        Connection con = sqlConnection();
        Statement stm = con.createStatement();
        //total++;
        //if(pas.compareTo(conpas)==0){
        //String query = "Insert into login values('"+total+"','"+unm+"','"+pas+"','"+utyp+"','"+id+"')";
        String query = "Insert into wall_post values('" + no + "','" + Id + "','" + wpostNo + "','" + wpost + "','','0','0','" + postFrom + "','" + time + "')";
        stm.executeUpdate(query);
        //System.out.println(Stat);
        //stm.executeUpdate(query2);
        System.out.println("Data Inserted Successfully");
    }

    public void addNotification(String no, String Id, String Notf, String NotfNo, String NotfTyp, String NotfFrom, String postNo) throws ClassNotFoundException, SQLException {
        Connection con = sqlConnection();
        Statement stm = con.createStatement();
        //total++;
        //if(pas.compareTo(conpas)==0){
        //String query = "Insert into login values('"+total+"','"+unm+"','"+pas+"','"+utyp+"','"+id+"')";
        String query = "Insert into notify values('" + no + "','" + Id + "','" + Notf + "','" + NotfNo + "','" + NotfTyp + "','" + NotfFrom + "','" + postNo + "')";
        stm.executeUpdate(query);
        //System.out.println(Stat);
        //stm.executeUpdate(query2);
        System.out.println("Data Inserted Successfully");
    }

    public void addMessage(String no, String sId, String rId, String sub, String mes, String mNo,String time) throws ClassNotFoundException, SQLException {
        Connection con = sqlConnection();
        Statement stm = con.createStatement();
        String query = "Insert into message values('" + no + "','" + sId + "','" + rId + "','" + sub + "','" + mes + "','" + mNo + "','" + time +"')";
        stm.executeUpdate(query);
        System.out.println("Data Inserted Successfully");
    }
     public void addpicture(String Id,byte[] pic) throws ClassNotFoundException, SQLException {
        Connection con = sqlConnection();
        Statement stm = con.createStatement();
        //total++;
        //if(pas.compareTo(conpas)==0){
        //String query = "Insert into login values('"+total+"','"+unm+"','"+pas+"','"+utyp+"','"+id+"')";
        String query = "Insert into pic_upload values(?,?)";
        pst=con.prepareStatement(query);
                pst.setString(1,Id);
                 
                     pst.setBytes(2,pic);
                     pst.execute();
                 JOptionPane.showMessageDialog(null, "Image Saved");
        //stm.executeUpdate(query);
        //System.out.println(Stat);
        //stm.executeUpdate(query2);
        System.out.println("Data Inserted Successfully");
    }
    
     public void updateimage(String id,byte[] pic) throws ClassNotFoundException, SQLException {
        Connection con = sqlConnection();
        Statement stm = con.createStatement();
        String sql = "Update pic_upload  set image=?  Where Id='"+id+"'";
                pst=con.prepareStatement(sql);
                     pst.setBytes(1, pic);
                     pst.execute();
                JOptionPane.showMessageDialog(null, "image saved");
    //    String query = "Update about SET education_institute='"+ inst +"' WHERE u_Id = '" +Id+"' ";
        //String query = "Update pic_upload SET image = '"+pic+"' WHERE Id='"+ id +"'";
        //ResultSet rs = stm.executeQuery(query);
        //int i = 0;
        /*int i = Integer.parseInt(id);
        pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            
        while (rs.next()) {

            uId[i] = rs.getString("Id");
            pic_byte[i] = rs.getBytes("image");
            System.out.println(uId[i]);
            //i++;
        }*/
        //total = i;

    }
    
    public void imageload(String id) throws ClassNotFoundException, SQLException {
        Connection con = sqlConnection();
        Statement stm = con.createStatement();
        String query = "select * from pic_upload WHERE Id='"+ id +"'";
        ResultSet rs = stm.executeQuery(query);
        //int i = 0;
        int i = Integer.parseInt(id);
        pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            
        while (rs.next()) {

            uId[i] = rs.getString("Id");
            pic_byte[i] = rs.getBytes("image");
            System.out.println(uId[i]);
            //i++;
        }
        //total = i;

    }

    public void addInfo(String Id, String inst, String work, String mail, String sx, String birth) throws ClassNotFoundException, SQLException {
        Connection con = sqlConnection();
        Statement stm = con.createStatement();
        //total++;
        //if(pas.compareTo(conpas)==0){
        //String query = "Insert into login values('"+total+"','"+unm+"','"+pas+"','"+utyp+"','"+id+"')";
        String query = "Insert into about  values('" + Id + "','" + inst + "','" + work + "','" + mail + "','" + sx + "','" + birth + "')";
        stm.executeUpdate(query);
        //System.out.println(Stat);
        //stm.executeUpdate(query2);
        System.out.println("Data Inserted Successfully");
    }
    public void addLike(String no, String Id, String pTyp, String pNo, String LId) throws ClassNotFoundException, SQLException
    {
        Connection con = sqlConnection();
        Statement stm = con.createStatement();
      
        String query = "Insert into like_track values('" + no + "','" + Id + "','" + pTyp + "','" + pNo + "','" + LId + "')";
        stm.executeUpdate(query);
    }
    
    public void updateInfo(String Id, String inst, String work, String mail, String sx, String birth) throws ClassNotFoundException, SQLException {
        Connection con = sqlConnection();
        Statement stm = con.createStatement();
        //total++;"UPDATE signup SET Total_Notification='" + TotalNotf + "' WHERE Id = '" + Id + "' "
        //if(pas.compareTo(conpas)==0){UPDATE friend_list SET Value1= '0' and Value2= '0' WHERE Id1 = '" + Id1 + "' and Id2 = '" + Id2 + "'
        //String query = "Insert into login values('"+total+"','"+unm+"','"+pas+"','"+utyp+"','"+id+"')";
        String query = "Update about SET education_institute='" + inst + "' WHERE u_Id = '" + Id + "' ";
        stm.executeUpdate(query);
        String query2 = "Update about SET working='" + work + "' WHERE u_Id = '" + Id + "' ";
        stm.executeUpdate(query2);
        String query3 = "Update about SET email='" + mail + "' WHERE u_Id = '" + Id + "' ";
        stm.executeUpdate(query3);
        String query4 = "Update about SET sex='" + sx + "' WHERE u_Id = '" + Id + "' ";
        stm.executeUpdate(query4);
        String query5 = "Update about SET date_of_birth='" + birth + "' WHERE u_Id = '" + Id + "' ";
        stm.executeUpdate(query5);

        //System.out.println(Stat);
        //stm.executeUpdate(query2);
        System.out.println("Data Inserted Successfully");
    }

    public void loadInfo(String Id) throws ClassNotFoundException, SQLException {
        Connection con = sqlConnection();
        Statement stm = con.createStatement();
        String query = "select * from about";
        ResultSet rs = stm.executeQuery(query);
        //Intro ob1 = new Intro();
        int uId = Integer.parseInt(Id);
        while (rs.next()) {
            if (Id.compareTo(rs.getString("u_ID")) == 0) {
                //int statNo = Integer.parseInt(rs.getString("Status_No"));
                //  ob1.userpos=Integer.parseInt(rs.getString("u_ID"));
                education_institute[uId] = rs.getString("education_institute");
                working[uId] = rs.getString("working");
                email[uId] = rs.getString("email");
                sex[uId] = rs.getString("sex");
                date_of_birth[uId] = rs.getString("date_of_birth");
                //System.out.println(status[uId][statNo]);
            }
        }

    }

    public void addPrivacy(String Id, String edu, String mail, String work, String friendl, String wall, String status, String dob) throws ClassNotFoundException, SQLException {
        Connection con = sqlConnection();
        Statement stm = con.createStatement();
        //total++;
        //if(pas.compareTo(conpas)==0){
        //String query = "Insert into login values('"+total+"','"+unm+"','"+pas+"','"+utyp+"','"+id+"')";
        String query = "Insert into privacy  values('" + Id + "','" + edu + "','" + mail + "','" + work + "','" + friendl + "','" + wall + "','" + status + "','" + dob + "')";
        stm.executeUpdate(query);
        //System.out.println(Stat);
        //stm.executeUpdate(query2);
        System.out.println("Data Inserted Successfully");
    }

    public void updatePrivacy(String Id, String edu, String mail, String work, String friendl, String wall, String status, String dob) throws ClassNotFoundException, SQLException {
        Connection con = sqlConnection();
        Statement stm = con.createStatement();
        //total++;"UPDATE signup SET Total_Notification='" + TotalNotf + "' WHERE Id = '" + Id + "' "
        //if(pas.compareTo(conpas)==0){UPDATE friend_list SET Value1= '0' and Value2= '0' WHERE Id1 = '" + Id1 + "' and Id2 = '" + Id2 + "'
        //String query = "Insert into login values('"+total+"','"+unm+"','"+pas+"','"+utyp+"','"+id+"')";
        String query = "Update privacy SET education='" + edu + "' WHERE u_Id = '" + Id + "' ";
        stm.executeUpdate(query);
        String query2 = "Update privacy SET email='" + mail + "' WHERE u_Id = '" + Id + "' ";
        stm.executeUpdate(query2);
        String query3 = "Update privacy SET work='" + work + "' WHERE u_Id = '" + Id + "' ";
        stm.executeUpdate(query3);
        String query4 = "Update privacy SET friendlist='" + friendl + "' WHERE u_Id = '" + Id + "' ";
        stm.executeUpdate(query4);
        String query5 = "Update privacy SET wall='" + wall + "' WHERE u_Id = '" + Id + "' ";
        stm.executeUpdate(query5);
        String query6 = "Update privacy SET status='" + status + "' WHERE u_Id = '" + Id + "' ";
        stm.executeUpdate(query6);
        String query7 = "Update privacy SET dob='" + dob + "' WHERE u_Id = '" + Id + "' ";
        stm.executeUpdate(query7);
        ///String query8 = "Update privacy SET type='"+ type +"' WHERE u_Id = '" +Id+"' ";
        //stm.executeUpdate(query8);
        //String query5 = "Update privacy SET date_of_birth='"+ type +"' WHERE u_Id = '" +Id+"' ";
        //stm.executeUpdate(query5);

        //System.out.println(Stat);
        //stm.executeUpdate(query2);
        System.out.println("Data Inserted Successfully");
    }

    public void loadPrivacy(String Id) throws ClassNotFoundException, SQLException {
        Connection con = sqlConnection();
        Statement stm = con.createStatement();
        String query = "select * from privacy";
        ResultSet rs = stm.executeQuery(query);

        int uId = Integer.parseInt(Id);
        while (rs.next()) {
            if (Id.compareTo(rs.getString("u_ID")) == 0) {
                //int statNo = Integer.parseInt(rs.getString("Status_No"));
                //  ob1.userpos=Integer.parseInt(rs.getString("u_ID"));
                educationprivacy[uId] = Integer.parseInt(rs.getString("education"));
                emailprivacy[uId] = Integer.parseInt(rs.getString("email"));
                workprivacy[uId] = Integer.parseInt(rs.getString("work"));
                friendlistprivacy[uId] = Integer.parseInt(rs.getString("friendlist"));
                wallprivacy[uId] = Integer.parseInt(rs.getString("wall"));
                statusprivacy[uId] = Integer.parseInt(rs.getString("status"));
                DOBprivacy[uId] = Integer.parseInt(rs.getString("dob"));
                //  privacy[uId][7] = Integer.parseInt(rs.getString("type"));
                //privacy[uId][8] = Integer.parseInt(rs.getString("education"));
                //System.out.println(status[uId][statNo]);
            }
        }

    }
    
    public void addOnline(String Id, String bday,String on) throws ClassNotFoundException, SQLException {
        Connection con = sqlConnection();
        Statement stm = con.createStatement();
        //total++;
        //if(pas.compareTo(conpas)==0){
        //String query = "Insert into login values('"+total+"','"+unm+"','"+pas+"','"+utyp+"','"+id+"')";
        String query = "Insert into online  values('" + Id + "','" + bday + "','" + on + "')";
        stm.executeUpdate(query);
        //System.out.println(Stat);
        //stm.executeUpdate(query2);
        System.out.println("Data Inserted Successfully");
    }

    public void updateOnline(String Id, String bday,String on) throws ClassNotFoundException, SQLException {
        Connection con = sqlConnection();
        Statement stm = con.createStatement();
        //total++;"UPDATE signup SET Total_Notification='" + TotalNotf + "' WHERE Id = '" + Id + "' "
        //if(pas.compareTo(conpas)==0){UPDATE friend_list SET Value1= '0' and Value2= '0' WHERE Id1 = '" + Id1 + "' and Id2 = '" + Id2 + "'
        //String query = "Insert into login values('"+total+"','"+unm+"','"+pas+"','"+utyp+"','"+id+"')";
        String query = "Update online SET birthday='" + bday + "' WHERE Id = '" + Id + "' ";
        stm.executeUpdate(query);
        String query2 = "Update online SET ontrack='" + on + "' WHERE Id = '" + Id + "' ";
        stm.executeUpdate(query2);
        
        ///String query8 = "Update privacy SET type='"+ type +"' WHERE u_Id = '" +Id+"' ";
        //stm.executeUpdate(query8);
        //String query5 = "Update privacy SET date_of_birth='"+ type +"' WHERE u_Id = '" +Id+"' ";
        //stm.executeUpdate(query5);

        //System.out.println(Stat);
        //stm.executeUpdate(query2);
        System.out.println("Data Inserted Successfully");
    }

    public void loadOnline(String Id) throws ClassNotFoundException, SQLException {
        Connection con = sqlConnection();
        Statement stm = con.createStatement();
        String query = "select * from online";
        ResultSet rs = stm.executeQuery(query);

        int uId = Integer.parseInt(Id);
        while (rs.next()) {
            if (Id.compareTo(rs.getString("Id")) == 0) {
                //int statNo = Integer.parseInt(rs.getString("Status_No"));
                //  ob1.userpos=Integer.parseInt(rs.getString("u_ID"));
                birthday[uId] = (rs.getString("birthday"));
                online[uId] = Integer.parseInt(rs.getString("ontrack"));
                
                //  privacy[uId][7] = Integer.parseInt(rs.getString("type"));
                //privacy[uId][8] = Integer.parseInt(rs.getString("education"));
                //System.out.println(status[uId][statNo]);
            }
        }

    }


    public void loadUserStatus(String Id) throws ClassNotFoundException, SQLException {
        Connection con = sqlConnection();
        Statement stm = con.createStatement();
        String query = "select * from status";
        ResultSet rs = stm.executeQuery(query);

        int uId = Integer.parseInt(Id);
        while (rs.next()) {
            if (Id.compareTo(rs.getString("Id")) == 0) {
                int statNo = Integer.parseInt(rs.getString("Status_No"));
                status[uId][statNo] = rs.getString("Status");
                statuscomment[uId][statNo] = rs.getString("Comments");
                statuscommenttrack[uId][statNo] = Integer.parseInt(rs.getString("Total_Comments"));
                statuslike[uId][statNo] = Integer.parseInt(rs.getString("Total_Like"));
                statTime[uId][statNo]=rs.getString("Time");
                //System.out.println(status[uId][statNo]);
            }
        }

    }

   

    public void loadUserWallpost(String Id) throws ClassNotFoundException, SQLException {
        Connection con = sqlConnection();
        Statement stm = con.createStatement();
        String query = "select * from wall_post Where Id = '" + Id + "'";
        ResultSet rs = stm.executeQuery(query);

        int uId = Integer.parseInt(Id);
        while (rs.next()) {
            if (Id.compareTo(rs.getString("Id")) == 0) {
                int statNo = Integer.parseInt(rs.getString("Wallpost_No"));
                wallpost[uId][statNo] = rs.getString("Wallpost");
                wallcomment[uId][statNo] = rs.getString("Comments");
                wallcommenttrack[uId][statNo] = Integer.parseInt(rs.getString("Total_Comments"));
                walllike[uId][statNo] = Integer.parseInt(rs.getString("Total_Like"));
                wallpostTime[uId][statNo] = rs.getString("Time");
                //System.out.println(status[uId][statNo]);
            }
        }

    }
     public String loadLike(String Id, String pTyp, String pNo, String liker) throws ClassNotFoundException, SQLException {
        Connection con = sqlConnection();
        Statement stm = con.createStatement();
        String query = "select Liker_Id from like_track Where Id = '" + Id + "' and Post_Type = '" + pTyp + "' and Post_No = '"+ pNo+ "'";
        ResultSet rs = stm.executeQuery(query);
        String result = new String();
        int uId = Integer.parseInt(Id);
        int x=0;
        while (rs.next()) {
            String name = rs.getString(1);
            result = name;
           
            if(result.compareTo(liker)==0)
            {
                x=2;
                break;
            }
        }
        
        if(x==2)return "1";
        else return "0";

    }
     
     public String getPosLike(String Id, String pTyp, String pNo, String liker) throws ClassNotFoundException, SQLException {
        Connection con = sqlConnection();
        Statement stm = con.createStatement();
        String query = "select No from like_track Where Id = '" + Id + "' and Post_Type = '" + pTyp + "' and Post_No = '"+ pNo+ "' and Liker_Id = '"+liker+"'";
        ResultSet rs = stm.executeQuery(query);
        String result = new String();
        int uId = Integer.parseInt(Id);
        int x=0;
        while (rs.next()) {
            String name = rs.getString(1);
            result = name;
           
        }
        
       return result;

    }
    

    public String getStatusTrack(String Id) throws SQLException, ClassNotFoundException {
        Connection con = sqlConnection();

        String result = new String();
        PreparedStatement ps = con.prepareStatement("SELECT Total_Status FROM signup WHERE Id = '" + Id + "'");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String name = rs.getString(1);
            result = name;
        }
        System.out.println(result);
        return result;
    }
    
    

    public String getWallTrack(String Id) throws SQLException, ClassNotFoundException {
        Connection con = sqlConnection();

        String result = new String();
        PreparedStatement ps = con.prepareStatement("SELECT Total_Wallpost FROM signup WHERE Id = '" + Id + "'");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String name = rs.getString(1);
            result = name;
        }
        System.out.println(result);
        return result;
    }

    public String getdbWallNo() throws SQLException, ClassNotFoundException {
        Connection con = sqlConnection();

        String result = new String();
        PreparedStatement ps = con.prepareStatement("SELECT Total_Wall FROM dbinfo");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String name = rs.getString(1);
            result = name;
        }
        System.out.println(result);
        return result;
    }
     public String getdbLikeNo() throws SQLException, ClassNotFoundException {
        Connection con = sqlConnection();

        String result = new String();
        PreparedStatement ps = con.prepareStatement("SELECT Total_Like FROM dbinfo");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String name = rs.getString(1);
            result = name;
        }
        System.out.println(result);
        return result;
    }

    public String getdbStatusNo() throws SQLException, ClassNotFoundException {
        Connection con = sqlConnection();

        String result = new String();
        PreparedStatement ps = con.prepareStatement("SELECT Total_Status FROM dbinfo");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String name = rs.getString(1);
            result = name;
        }
        System.out.println(result);
        return result;
    }

    public String getdbMessageNo() throws SQLException, ClassNotFoundException {
        Connection con = sqlConnection();

        String result = new String();
        PreparedStatement ps = con.prepareStatement("SELECT Total_Message FROM dbinfo");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String name = rs.getString(1);
            result = name;
        }
        System.out.println(result);
        return result;
    }

    public String getdbNotificationNo() throws SQLException, ClassNotFoundException {
        Connection con = sqlConnection();

        String result = new String();
        PreparedStatement ps = con.prepareStatement("SELECT Total_Notification FROM dbinfo");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String name = rs.getString(1);
            result = name;
        }
        System.out.println(result);
        return result;
    }

    public String getStatusComment(String Id, String statNo) throws SQLException, ClassNotFoundException {
        Connection con = sqlConnection();

        String result = new String();
        PreparedStatement ps = con.prepareStatement("SELECT Comments FROM status WHERE Id = '" + Id + "' and Status_No = '" + statNo + "'");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String name = rs.getString(1);
            result = name;
        }
        System.out.println(result);
        return result;
    }

    public String getNotification(String Id, String notfNo) throws SQLException, ClassNotFoundException {
        Connection con = sqlConnection();

        String result = new String();
        PreparedStatement ps = con.prepareStatement("SELECT Notification FROM notify WHERE Id = '" + Id + "' and Notification_No = '" + notfNo + "'");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String name = rs.getString(1);
            result = name;
        }
        System.out.println(result);
        return result;
    }

    public String getTotalMessage(String Id) throws SQLException, ClassNotFoundException {
        Connection con = sqlConnection();

        String result = new String();
        PreparedStatement ps = con.prepareStatement("SELECT Total_Message FROM signup WHERE Id = '" + Id + "'");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String name = rs.getString(1);
            result = name;
        }
        System.out.println(result);
        return result;
    }

    public String getTotalNotification(String Id) throws SQLException, ClassNotFoundException {
        Connection con = sqlConnection();

        String result = new String();
        PreparedStatement ps = con.prepareStatement("SELECT Total_Notification FROM signup WHERE Id = '" + Id + "'");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String name = rs.getString(1);
            result = name;
        }
        System.out.println(result);
        return result;
    }
    public String getTotalLike(String Id , String StatNo) throws SQLException, ClassNotFoundException {
        Connection con = sqlConnection();

        String result = new String();
        PreparedStatement ps = con.prepareStatement("SELECT Total_Like FROM status WHERE Id = '" + Id + "' and Status_No = '" + StatNo+"'");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String name = rs.getString(1);
            result = name;
        }
        System.out.println(result);
        return result;
    }

    public String[] getNotificationInfo(String Id, String notfNo) throws SQLException, ClassNotFoundException {
        Connection con = sqlConnection();

        String[] result = new String[3];
        PreparedStatement ps = con.prepareStatement("SELECT Notification_Type, Notification_From, Notification_PostNo FROM notify WHERE Id = '" + Id + "'and Notification_No = '" + notfNo + "'");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String typ = rs.getString(1);
            result[0] = typ;
            String from = rs.getString(2);
            result[1] = from;
            String postNo = rs.getString(3);
            result[2] = postNo;
        }
        //System.out.println(result);
        return result;
    }

    public void update_Total_dbWall(String x) throws ClassNotFoundException, SQLException {
        Connection con = sqlConnection();
        Statement stm = con.createStatement();
        String query = "UPDATE dbinfo SET Total_Wall='" + x + "'";
        stm.executeUpdate(query);
        //System.out.println("Data Updated Successfully");
    }
     public void update_Total_dbLike(String x) throws ClassNotFoundException, SQLException {
        Connection con = sqlConnection();
        Statement stm = con.createStatement();
        String query = "UPDATE dbinfo SET Total_Like='" + x + "'";
        stm.executeUpdate(query);
        //System.out.println("Data Updated Successfully");
    }

    public void update_Total_dbStatus(String x) throws ClassNotFoundException, SQLException {
        Connection con = sqlConnection();
        Statement stm = con.createStatement();
        String query = "UPDATE dbinfo SET Total_Status='" + x + "'";
        stm.executeUpdate(query);
        //System.out.println("Data Updated Successfully");
    }

    public void update_Total_dbMessage(String x) throws ClassNotFoundException, SQLException {
        Connection con = sqlConnection();
        Statement stm = con.createStatement();
        String query = "UPDATE dbinfo SET Total_Message='" + x + "'";
        stm.executeUpdate(query);
        //System.out.println("Data Updated Successfully");
    }

    public void update_Total_dbNotification(String x) throws ClassNotFoundException, SQLException {
        Connection con = sqlConnection();
        Statement stm = con.createStatement();
        String query = "UPDATE dbinfo SET Total_Notification='" + x + "'";
        stm.executeUpdate(query);
        //System.out.println("Data Updated Successfully");
    }

    public void update_TotalStatus(String Id, String TotalStat) throws ClassNotFoundException, SQLException {
        Connection con = sqlConnection();
        Statement stm = con.createStatement();
        String query = "UPDATE signup SET Total_Status='" + TotalStat + "' WHERE Id = '" + Id + "' ";
        stm.executeUpdate(query);
        //System.out.println("Data Updated Successfully");
    }

    public void update_TotalWallpost(String Id, String TotalWPost) throws ClassNotFoundException, SQLException {
        Connection con = sqlConnection();
        Statement stm = con.createStatement();
        String query = "UPDATE signup SET Total_Wallpost='" + TotalWPost + "' WHERE Id = '" + Id + "' ";
        stm.executeUpdate(query);
        //System.out.println("Data Updated Successfully");
    }

    public void update_TotalMessage(String Id, String TotalMes) throws ClassNotFoundException, SQLException {
        Connection con = sqlConnection();
        Statement stm = con.createStatement();
        String query = "UPDATE signup SET Total_Message='" + TotalMes + "' WHERE Id = '" + Id + "' ";
        stm.executeUpdate(query);
        System.out.println("Data Updated Successfully");
    }

    public void update_TotalNotification(String Id, String TotalNotf) throws ClassNotFoundException, SQLException {
        Connection con = sqlConnection();
        Statement stm = con.createStatement();
        String query = "UPDATE signup SET Total_Notification='" + TotalNotf + "' WHERE Id = '" + Id + "' ";
        stm.executeUpdate(query);
        System.out.println("Data Updated Successfully");
    }

    public void update_StatusComment(String Id, String statNo, String com, String total_com) throws ClassNotFoundException, SQLException {
        Connection con = sqlConnection();
        Statement stm = con.createStatement();
        String query1 = "UPDATE status SET Comments = '" + com + "' WHERE Id = '" + Id + "' and Status_No = '" + statNo + "'";
        stm.executeUpdate(query1);
        String query2 = "UPDATE status SET Total_Comments = '" + total_com + "' WHERE Id = '" + Id + "' and Status_No = '" + statNo + "'";
        stm.executeUpdate(query2);
        //System.out.println("Data Updated Successfully");
    }
    public void update_StatusLike(String Id, String statNo, String total_like) throws ClassNotFoundException, SQLException {
        Connection con = sqlConnection();
        Statement stm = con.createStatement();
        String query1 = "UPDATE status SET Total_Like = '" + total_like + "' WHERE Id = '" + Id + "' and Status_No = '" + statNo + "'";
        stm.executeUpdate(query1);
        //System.out.println("Data Updated Successfully");
    }
    
    public void update_WallComment(String Id, String postNo, String com, String total_com) throws ClassNotFoundException, SQLException {
        Connection con = sqlConnection();
        Statement stm = con.createStatement();
        String query1 = "UPDATE wall_post SET Comments = '" + com + "' WHERE Id = '" + Id + "' and Wallpost_No = '" + postNo + "'";
        stm.executeUpdate(query1);
        String query2 = "UPDATE wall_post SET Total_Comments = '" + total_com + "' WHERE Id = '" + Id + "' and Wallpost_No = '" + postNo + "'";
        stm.executeUpdate(query2);
        //System.out.println("Data Updated Successfully");
    }

    public void confirmFrnd(String Id1, String Id2) throws ClassNotFoundException, SQLException {
        Connection con = sqlConnection();
        Statement stm = con.createStatement();
        String query = "UPDATE friend_list SET Value2= '1' WHERE Id1 = '" + Id1 + "' and Id2 = '" + Id2 + "'";
        stm.executeUpdate(query);
        System.out.println("Data Updated Successfully");
    }

    public void ignoreFrnd(String Id1, String Id2) throws ClassNotFoundException, SQLException {
        Connection con = sqlConnection();
        Statement stm = con.createStatement();
        String query = "UPDATE friend_list SET Value1= '0' and Value2= '0' WHERE Id1 = '" + Id1 + "' and Id2 = '" + Id2 + "'";
        stm.executeUpdate(query);
        System.out.println("Data Updated Successfully");
    }

    public void removeFrnd(String Id1, String Id2) throws ClassNotFoundException, SQLException {
        Connection con = sqlConnection();
        Statement stm = con.createStatement();
        /*String query = "UPDATE friend_list SET Value1= '0' WHERE Id1 = '" + Id1 + "' and Id2 = '" + Id2 + "'";
        stm.executeUpdate(query);
        String query1 = "UPDATE friend_list SET Value2= '0' WHERE Id1 = '" + Id1 + "' and Id2 = '" + Id2 + "'";
        stm.executeUpdate(query1);
        String query2 = "UPDATE friend_list SET Value1= '0'  WHERE Id1 = '" + Id2 + "' and Id2 = '" + Id1 + "'";
        stm.executeUpdate(query2);
        String query3 = "UPDATE friend_list SET Value2= '0' WHERE Id1 = '" + Id2 + "' and Id2 = '" + Id1 + "'";
        * 
        * 
        stm.executeUpdate(query3);*/
        
        String query = "Delete from friend_list where Id1= '"+ Id1 +"' and Id2 = '"+ Id2 +"'";
        stm.executeUpdate(query);
        String query2 = "Delete from friend_list where Id1= '"+ Id2 +"' and Id2 = '"+ Id1 +"'";
        stm.executeUpdate(query2);
        System.out.println("Data Updated Successfully");
    }

    public void addValue(String nm,String uname,String pass,String sx,String mail,String id,String stat,String mes,String wall,String not) throws ClassNotFoundException, SQLException {

        Connection con = sqlConnection();
        Statement stm = con.createStatement();
        String query = "Insert into signup values('" + nm + "','" + uname + "','" + pass + "','" + sx + "','" + mail + "','" + id + "','" + stat + "'," + mes + "," + wall + "," + not + ")";
        stm.executeUpdate(query);
        System.out.println("Data Inserted Successfully");
    }
     public void addPass(String id,String pass) throws ClassNotFoundException, SQLException {

     
      //  String query = "Insert into signup values('" + nm + "','" + uname + "','" + pass + "','" + sx + "','" + mail + "','" + id + "','" + stat + "'," + mes + "," + wall + "," + not + ")";
        Connection con = sqlConnection();
        Statement stm = con.createStatement();
        String query = "Update signup SET Password='" + pass + "' WHERE id = '" + id+ "' ";
        stm.executeUpdate(query);
    
        System.out.println("Data Inserted Successfully");
    }

    public void sendFrndReq(String Id1, String Id2) throws ClassNotFoundException, SQLException {
        Connection con = sqlConnection();
        Statement stm = con.createStatement();
        String query = "Insert into friend_list values('" + Id1 + "','1','" + Id2 + "','0')";
        stm.executeUpdate(query);
        System.out.println("Data Inserted Successfully");
    }

    public String[] getFrndReqInfo(String Id1, String Id2) throws ClassNotFoundException, SQLException {
        Connection con = sqlConnection();

        String[] result = new String[2];
        PreparedStatement ps = con.prepareStatement("SELECT Value1 , Value2 FROM friend_list WHERE Id1 = '" + Id1 + "' and Id2 = " + Id2 + "");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String value1 = rs.getString(1);

            result[0] = value1;
            String value2 = rs.getString(2);
            result[1] = value2;
        }
        //System.out.println(result);
        if (result[0] == null) {
            result[0] = "9";
        }
        if (result[1] == null) {
            result[1] = "9";
        }
        return result;
    }

    public void delValue() throws ClassNotFoundException, SQLException {
        Connection con = sqlConnection();
        Statement stm = con.createStatement();
        String query = "Delete from signup where Id=5";
        stm.executeUpdate(query);
        System.out.println("Data Deleted Successfully");
    }
    
    public void delLike(String no) throws ClassNotFoundException, SQLException {
        Connection con = sqlConnection();
        Statement stm = con.createStatement();
        String query = "Delete from like_track where No= '"+ no +"'";
        stm.executeUpdate(query);
        System.out.println("Data Deleted Successfully");
    }

    public void insertnewnotification(String Id, String frnd, String notify, String inbox, String event) throws ClassNotFoundException, SQLException {
        Connection con = sqlConnection();
        Statement stm = con.createStatement();
        String query = "Insert into newnotification values('" + Id + "','" + frnd + "','" + notify + "','" + inbox + "','" + event + "')";
        stm.executeUpdate(query);
        System.out.println("Data Inserted Successfully");

        //total = i;

    }

    public void updatenewnotification(String Id, String frnd, String notify, String inbox, String event) throws ClassNotFoundException, SQLException {
        Connection con = sqlConnection();
        Statement stm = con.createStatement();
        String query = "Update newnotification SET newfrndreq='" + frnd + "' WHERE id = '" + Id + "' ";
        stm.executeUpdate(query);
        String query2 = "Update newnotification SET newnotify='" + notify + "' WHERE id = '" + Id + "' ";
        stm.executeUpdate(query2);
        String query3 = "Update newnotification SET newinbox='" + inbox + "' WHERE id = '" + Id + "' ";
        stm.executeUpdate(query3);
        String query4 = "Update newnotification SET newevent='" + event + "' WHERE id = '" + Id + "' ";
        stm.executeUpdate(query4);


        //System.out.println(Stat);
        //stm.executeUpdate(query2);
        System.out.println("Data Inserted Successfully");
        //total = i;

    }

    public void loadnewnotification(String Id) throws ClassNotFoundException, SQLException {
        Connection con = sqlConnection();
        Statement stm = con.createStatement();
        String query = "select * from newnotification WHERE id = '" + Id + "'";
        ResultSet rs = stm.executeQuery(query);
        int i = 0;
        int ui = Integer.parseInt(Id);
        while (rs.next()) {

            messagetrack[ui] = Integer.parseInt(rs.getString("newinbox"));
            Notificationtrack[ui] = Integer.parseInt(rs.getString("newnotify"));
            Friendnotificationtrack[ui] = Integer.parseInt(rs.getString("newfrndreq"));


            //    System.out.println(message[ui][i]);
            i++;
        }
       // inboxlimit[ui] = i;
        /*
         * total = i; if(ob.messagetrack[ob1.userpos]!=0) {
         * Inbox.setText("Inbox(new)"); }
         * if(ob.Notificationtrack[ob1.userpos]!=0) {
         * Notifications.setText("Notifications(new)"); }
         * if(ob.Friendnotificationtrack[ob1.userpos]!=0) {
         * Friendreq.setText("Friend Requests(new)"); 
        }
         */

    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        SignUp s = new SignUp();
        String[] x = new String[3];
        x= s.getNotificationInfo("1","0");
        
        System.out.println(x[0]+" "+x[1]+" "+x[2]);
        //s.update_Total_Wall("2");
        //s.getStatusTrack("2");
        //
        //s.getStatusComment("1","0");
        //s.delValue();
        //s.printAll();
        //s.update_Comment("1","0","Shah - tai naki!!", "1");
        //String[] result = new String[2];
        //result = s.getFrndReqInfo("0", "2");
        //System.out.println(result[0] + "   " + result[1]);
    }

    public int totals() {
        return total;
    }

    public int track(int x, int y, int z) {
        nfutrack[z] = x;
        nfstrack[z] = y;
        return 0;
    }
}
