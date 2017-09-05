package Forms;


import DB.SignUp;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author Tahmid
 */
public class ProfileOthers extends javax.swing.JFrame {

    /**
     * Creates new form ProfileI
     */
    String id;
    Boolean flag=true;
    SignUp ob = new SignUp();
    Intro ob1 = new Intro();

    public ProfileOthers() throws ClassNotFoundException, SQLException {
        initComponents();
        setResizable(false);
         ShowBut.setVisible(false);
         ChangePic.setVisible(false);
         uploadImage.setVisible(false);
         imageSave.setVisible(false);
         jTextField9.setVisible(false);
         jDesktopPane1.setVisible(false);
        ob.loadInfo(Integer.toString(ob.sbutrack[ob.searchindex]));
        String[] result = new String[2];
        String[] result2 = new String[2];
        result = ob.getFrndReqInfo(Integer.toString(ob.sbutrack[ob.searchindex]), Integer.toString(ob1.userpos));
        result2 = ob.getFrndReqInfo(Integer.toString(ob1.userpos), Integer.toString(ob.sbutrack[ob.searchindex]));
        //System.out.println(result[0]+"   "+result[1]);
        ob.loadPrivacy(Integer.toString(ob.sbutrack[ob.searchindex]));
        if((result[0].compareTo("1")==0&&result[1].compareTo("1")==0)||(result2[0].compareTo("1")==0&&result2[1].compareTo("1")==0))
        {
            ob.frndchecker[ob.sbutrack[ob.searchindex]][ob1.userpos]=1;
           
            ob.frndchecker[ob1.userpos][ob.sbutrack[ob.searchindex]]=1;
        }
        else if((result[0].compareTo("1")==0&&result[1].compareTo("0")==0))
        {
            ob.frndchecker[ob1.userpos][ob.sbutrack[ob.searchindex]]=Integer.parseInt(result[1]);
            ob.frndchecker[ob.sbutrack[ob.searchindex]][ob1.userpos]=Integer.parseInt(result[0]);
           
            
            //System.out.println(ob.frndchecker[k][ob1.userpos]+"   "+ob.frndchecker[ob1.userpos][k]);
        }
        else if((result2[0].compareTo("1")==0&&result2[1].compareTo("0")==0))
        {
            
            ob.frndchecker[ob.sbutrack[ob.searchindex]][ob1.userpos]=Integer.parseInt(result[0]);
            ob.frndchecker[ob1.userpos][ob.sbutrack[ob.searchindex]]=Integer.parseInt(result[1]);
           
            
            //System.out.println(ob.frndchecker[k][ob1.userpos]+"   "+ob.frndchecker[ob1.userpos][k]);
        }
        else 
        {
            
            ob.frndchecker[ob.sbutrack[ob.searchindex]][ob1.userpos]=0;
            ob.frndchecker[ob1.userpos][ob.sbutrack[ob.searchindex]]=0;
           
            
            //System.out.println(ob.frndchecker[k][ob1.userpos]+"   "+ob.frndchecker[ob1.userpos][k]);
        }
        
        
        if (ob.frndchecker[ob1.userpos][ob.sbutrack[ob.searchindex]] == 1 && ob.frndchecker[ob.sbutrack[ob.searchindex]][ob1.userpos] == 1) {
            frndrequest.setText("Remove Friend");
        }
        if (ob.frndchecker[ob1.userpos][ob.sbutrack[ob.searchindex]] == 1 && ob.frndchecker[ob.sbutrack[ob.searchindex]][ob1.userpos] == 0) {
            frndrequest.setText("Friend Request sent");
        }
        if (ob.frndchecker[ob1.userpos][ob.sbutrack[ob.searchindex]] == 0 && ob.frndchecker[ob.sbutrack[ob.searchindex]][ob1.userpos] == 0) {
            frndrequest.setText("Send Friend Request");
        }
        if (ob.frndchecker[ob1.userpos][ob.sbutrack[ob.searchindex]] == 0 && ob.frndchecker[ob.sbutrack[ob.searchindex]][ob1.userpos] == 1) {
            frndrequest.setText("Respond to Friend Request");
        }
        username.setText("Username: " + ob.uname[ob.sbutrack[ob.searchindex]]);
        institute.setText("Institue: " + ob.education_institute[ob.sbutrack[ob.searchindex]]);
        sex.setText("Sex: " + ob.sex[ob.sbutrack[ob.searchindex]]);
        work.setText("Work: " + ob.working[ob.sbutrack[ob.searchindex]]);
        email.setText("Email: " + ob.email[ob.sbutrack[ob.searchindex]]);
        DOB.setText("Date of Birth: " + ob.date_of_birth[ob.sbutrack[ob.searchindex]]);
 /*public static int educationprivacy[] = new int[300];
    public static int emailprivacy[] = new int[300];
    public static int workprivacy[] = new int[300];
    public static int friendlistprivacy[] = new int[300];
    public static int wallprivacy[] = new int[300];
    public static int statusprivacy[] = new int[300];*/
   // public static int DOBprivacy[] = new int[300];
        if(  ob.frndchecker[ob.sbutrack[ob.searchindex]][ob1.userpos]!=1||
            ob.frndchecker[ob1.userpos][ob.sbutrack[ob.searchindex]]!=1){
        if (ob.educationprivacy[ob.sbutrack[ob.searchindex]] == 1) {
            institute.setVisible(false);
        }
        if (ob.emailprivacy[ob.sbutrack[ob.searchindex]] == 1) {
            email.setVisible(false);
        }
        if (ob.workprivacy[ob.sbutrack[ob.searchindex]] == 1) {
            work.setVisible(false);
        }
          if (ob.friendlistprivacy[ob.sbutrack[ob.searchindex]] == 1) {
            Friendlist.setVisible(false);
        }
            if (ob.wallprivacy[ob.sbutrack[ob.searchindex]] == 1) {
            Wall.setVisible(false);
        }
              if (ob.statusprivacy[ob.sbutrack[ob.searchindex]] == 1) {
            Status.setVisible(false);
        }
        }
        
        
        id = Integer.toString(ob.sbutrack[ob.searchindex]);

        System.out.println("yeah");
        try {
            ob.imageload(id);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        int i = Integer.parseInt(id);
        //byte[] imagedata=rs.getBytes("image");
        //format=new ImageIcon(imagedata);
        //format= ImageIcon(ob.pic_byte[i]);
        format = new ImageIcon(SignUp.pic_byte[i]);
        System.out.println("yeah");
        jLabel3.setIcon(format);
        System.out.println("yeah");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Status = new javax.swing.JButton();
        message = new javax.swing.JButton();
        email = new javax.swing.JLabel();
        work = new javax.swing.JLabel();
        DOB = new javax.swing.JLabel();
        institute = new javax.swing.JLabel();
        sex = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        Friendlist = new javax.swing.JButton();
        Wall = new javax.swing.JButton();
        pinfo = new javax.swing.JLabel();
        frndrequest = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        home = new javax.swing.JButton();
        profile = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        jLabel3 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        uploadImage = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel7 = new javax.swing.JLabel();
        imageSave = new javax.swing.JButton();
        ShowBut = new javax.swing.JButton();
        ChangePic = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Status.setBackground(new java.awt.Color(0, 102, 102));
        Status.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Status.setForeground(new java.awt.Color(255, 255, 255));
        Status.setText("Show Status");
        Status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StatusActionPerformed(evt);
            }
        });

        message.setBackground(new java.awt.Color(0, 102, 102));
        message.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        message.setForeground(new java.awt.Color(255, 255, 255));
        message.setText("Send Message");
        message.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messageActionPerformed(evt);
            }
        });

        email.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        email.setText("Email:");

        work.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        work.setText("Working at:");

        DOB.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        DOB.setText("Date Of Birth:");

        institute.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        institute.setText("Institute:");

        sex.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        sex.setText("Sex:");

        username.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        username.setText("Username:");

        Friendlist.setBackground(new java.awt.Color(0, 102, 102));
        Friendlist.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Friendlist.setForeground(new java.awt.Color(255, 255, 255));
        Friendlist.setText("Friend List");
        Friendlist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FriendlistActionPerformed(evt);
            }
        });

        Wall.setBackground(new java.awt.Color(0, 102, 102));
        Wall.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Wall.setForeground(new java.awt.Color(255, 255, 255));
        Wall.setText("Check Wall");
        Wall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WallActionPerformed(evt);
            }
        });

        pinfo.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        pinfo.setText("Personal Information:");

        frndrequest.setText("Send Friend Request");
        frndrequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frndrequestActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(59, 89, 152));

        home.setBackground(new java.awt.Color(0, 102, 102));
        home.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        home.setForeground(new java.awt.Color(255, 255, 255));
        home.setText("Homepage");
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });

        profile.setBackground(new java.awt.Color(0, 102, 102));
        profile.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        profile.setForeground(new java.awt.Color(255, 255, 255));
        profile.setText("My Profile");
        profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileActionPerformed(evt);
            }
        });

        logout.setBackground(new java.awt.Color(0, 102, 102));
        logout.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        logout.setForeground(new java.awt.Color(255, 255, 255));
        logout.setText("Log Out");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(profile, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(profile)
                    .addComponent(home))
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(logout)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel3.setBounds(10, 10, 200, 200);
        jDesktopPane2.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        uploadImage.setText("Upload  Image");
        uploadImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadImageActionPerformed(evt);
            }
        });

        jLabel7.setBounds(40, 50, 120, 90);
        jDesktopPane1.add(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        imageSave.setText("Save");
        imageSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageSaveActionPerformed(evt);
            }
        });

        ShowBut.setText("Show");
        ShowBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowButActionPerformed(evt);
            }
        });

        ChangePic.setText("Change Pic");
        ChangePic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangePicActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sex, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pinfo, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(work, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(institute, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DOB, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ShowBut)
                        .addGap(18, 18, 18)
                        .addComponent(ChangePic))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(43, 43, 43)
                            .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(24, 24, 24))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(76, 76, 76)
                            .addComponent(frndrequest, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(28, 28, 28)
                                    .addComponent(imageSave))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(30, 30, 30)
                                    .addComponent(uploadImage)))
                            .addGap(36, 36, 36))))
                .addGap(165, 165, 165))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118)
                .addComponent(Status, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140)
                .addComponent(Wall, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106)
                .addComponent(Friendlist, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(172, 172, 172)
                                                .addComponent(sex, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(65, 65, 65)
                                                .addComponent(pinfo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addComponent(work, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(124, 124, 124)
                                        .addComponent(institute, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(DOB, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ChangePic)
                            .addComponent(ShowBut))
                        .addGap(15, 15, 15)
                        .addComponent(frndrequest, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(uploadImage)
                                .addGap(20, 20, 20)
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(imageSave)))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Status, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Wall, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Friendlist, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void messageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messageActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new Message().setVisible(true);
    }//GEN-LAST:event_messageActionPerformed

    private void frndrequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_frndrequestActionPerformed
        // TODO add your handling code here:
        // this.setVisible(false);
        //  new  Sendfriendrequest().setVisible(true);

        if (ob.frndchecker[ob1.userpos][ob.sbutrack[ob.searchindex]] == 0 && ob.frndchecker[ob.sbutrack[ob.searchindex]][ob1.userpos] == 0) {
            try {
                ob.sendFrndReq(Integer.toString(ob1.userpos), Integer.toString(ob.sbutrack[ob.searchindex]));
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ProfileOthers.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ProfileOthers.class.getName()).log(Level.SEVERE, null, ex);
            }
            ob.frndchecker[ob1.userpos][ob.sbutrack[ob.searchindex]] = 1;
            ob.newfrnd[ob.sbutrack[ob.searchindex]]++;
            frndrequest.setText("Friend Request Sent");
            ob.Friendnotificationtrack[ob.sbutrack[ob.searchindex]]++;
                 try {
            ob.updatenewnotification(Integer.toString(ob.sbutrack[ob.searchindex]), Integer.toString(ob.Friendnotificationtrack[ob.sbutrack[ob.searchindex]]), Integer.toString(ob.Notificationtrack[ob.sbutrack[ob.searchindex]]), Integer.toString(ob. messagetrack[ob.sbutrack[ob.searchindex]]), Integer.toString(ob.newevent[ob.sbutrack[ob.searchindex]]));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Otherswall.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Otherswall.class.getName()).log(Level.SEVERE, null, ex);
        }
            //  frndrequest.setText("Send Friend Request");
        } else if (ob.frndchecker[ob1.userpos][ob.sbutrack[ob.searchindex]] == 1 && ob.frndchecker[ob.sbutrack[ob.searchindex]][ob1.userpos] == 1) {
            {
                ob.frndchecker[ob1.userpos][ob.sbutrack[ob.searchindex]] = 0;
                ob.frndchecker[ob.sbutrack[ob.searchindex]][ob1.userpos] = 0;
                try {
                    //   ob.newfrnd[ob.sbutrack[ob.searchindex]]=0;
                    ob.removeFrnd(Integer.toString(ob1.userpos), Integer.toString(ob.sbutrack[ob.searchindex]));
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ProfileOthers.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(ProfileOthers.class.getName()).log(Level.SEVERE, null, ex);
                }
                frndrequest.setText("Send Friend Request");
            }
        } else if (ob.frndchecker[ob1.userpos][ob.sbutrack[ob.searchindex]] == 1 && ob.frndchecker[ob.sbutrack[ob.searchindex]][ob1.userpos] == 0) {
            int x = 0;
            x = JOptionPane.showConfirmDialog(rootPane, "Do you want to cancel the friend request?");
            if (x == 0) {
                ob.frndchecker[ob1.userpos][ob.sbutrack[ob.searchindex]] = 0;
                try {
                    //   ob.newfrnd[ob.sbutrack[ob.searchindex]]=0;
                    ob.removeFrnd(Integer.toString(ob1.userpos), Integer.toString(ob.sbutrack[ob.searchindex]));
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ProfileOthers.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(ProfileOthers.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                frndrequest.setText("Send Friend Request");
            }
        } else if (ob.frndchecker[ob1.userpos][ob.sbutrack[ob.searchindex]] == 0 && ob.frndchecker[ob.sbutrack[ob.searchindex]][ob1.userpos] == 1) {
            ob.frqtrack[ob.friendindex] = ob.sbutrack[ob.searchindex];
            try {
                    //   ob.newfrnd[ob.sbutrack[ob.searchindex]]=0;
                    ob.confirmFrnd(Integer.toString(ob1.userpos), Integer.toString(ob.sbutrack[ob.searchindex]));
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ProfileOthers.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(ProfileOthers.class.getName()).log(Level.SEVERE, null, ex);
                }
            this.setVisible(false);
            new Friendrequestresponse().setVisible(true);
            
            //ob.frndchecker[ob1.userpos][]=1;
            //frndrequest.setText("Remove Friend");
        }

 
        // frndrequest.hide();
        //frndrequest.hide();
        //frndrequest.setVisible(false);
        //  frndrequest.hide();
    }//GEN-LAST:event_frndrequestActionPerformed

    private void WallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WallActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        try {
            new Otherswall().setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProfileOthers.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProfileOthers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_WallActionPerformed

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        try {
            new Home().setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProfileOthers.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProfileOthers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_homeActionPerformed

    private void profileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        try {
            new Profile().setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProfileOthers.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProfileOthers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_profileActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
         try {
            // TODO add your handling code here:
            ob.updateOnline(Integer.toString(ob1.userpos),(ob.birthday[ob1.userpos]),("0"));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
        new Intro().setVisible(true);
    }//GEN-LAST:event_logoutActionPerformed

    private void StatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StatusActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        try {
            new StatusOthers().setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProfileOthers.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProfileOthers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_StatusActionPerformed

    private void uploadImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadImageActionPerformed
        // TODO add your handling code here////////////////////////////////////////////////////////////////////////////////
        try {
            imageSave.setEnabled(true);
            byte[] buf = new byte[102400];
            JFileChooser ch = new JFileChooser();
            ch.showOpenDialog(null);
            File f = ch.getSelectedFile();
            filename = f.getAbsolutePath();
            jTextField9.setText(filename);
            try {
                File image = new File(filename);
                FileInputStream fis = new FileInputStream(image);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                for (int readnum; (readnum = fis.read(buf)) != -1;) {
                    bos.write(buf, 0, readnum);
                }
                person_image = bos.toByteArray();
                // jTextField10.set(person_image);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_uploadImageActionPerformed

    private void imageSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageSaveActionPerformed
        // TODO add your handling code here:////////////////////////////////////////////////////////////////////////////////
        SignUp ob = new SignUp();
        id = Integer.toString(ob.total);
        try {
            ob.addpicture(id, person_image);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
        }



    }//GEN-LAST:event_imageSaveActionPerformed

    private void ShowButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowButActionPerformed
        // TODO add your handling code here:
        SignUp ob = new SignUp();
        id = Integer.toString(ob.total);

        System.out.println("yeah");
        try {
            ob.imageload(id);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
        }

        int i = Integer.parseInt(id);
        //byte[] imagedata=rs.getBytes("image");
        //format=new ImageIcon(imagedata);
        //format= ImageIcon(ob.pic_byte[i]);
        format = new ImageIcon(SignUp.pic_byte[i]);
        System.out.println("yeah");
        jLabel3.setIcon(format);
        System.out.println("yeah");
    }//GEN-LAST:event_ShowButActionPerformed

    private void ChangePicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChangePicActionPerformed
        // TODO add your handling code here:
        SignUp ob = new SignUp();

        id = Integer.toString(ob.total);

        uploadImageActionPerformed(evt);
        //imageSaveActionPerformed(evt);
        try {
            ob.updateimage(id, person_image);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_ChangePicActionPerformed

    private void FriendlistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FriendlistActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        try {
            new FriendList().setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProfileOthers.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProfileOthers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_FriendlistActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProfileOthers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProfileOthers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProfileOthers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProfileOthers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    new ProfileOthers().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ProfileOthers.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(ProfileOthers.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ChangePic;
    private javax.swing.JLabel DOB;
    private javax.swing.JButton Friendlist;
    private javax.swing.JButton ShowBut;
    private javax.swing.JButton Status;
    private javax.swing.JButton Wall;
    private javax.swing.JLabel email;
    private javax.swing.JButton frndrequest;
    private javax.swing.JButton home;
    private javax.swing.JButton imageSave;
    private javax.swing.JLabel institute;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JButton logout;
    private javax.swing.JButton message;
    private javax.swing.JLabel pinfo;
    private javax.swing.JButton profile;
    private javax.swing.JLabel sex;
    private javax.swing.JButton uploadImage;
    private javax.swing.JLabel username;
    private javax.swing.JLabel work;
    // End of variables declaration//GEN-END:variables
    private ImageIcon format=null;
    private String filename;
    private int s=0;
    byte[] person_image=null;
}
