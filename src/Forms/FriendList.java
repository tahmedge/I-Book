package Forms;


import DB.SignUp;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tahmid
 */
public class FriendList extends javax.swing.JFrame {

    /**
     * Creates new form table
     */
    //  private DefaultListModel jList11;
    SignUp ob = new SignUp();
    Intro ob1 = new Intro();

    public FriendList() throws ClassNotFoundException, SQLException {
        initComponents();
        setResizable(false);
        // String s="he;;"
        int i = 0, x = 0;
        //String S="ads";
       // ob.searchindex;
        for (i = 0; i < ob.total; i++) {
            if(i==ob.sbutrack[ob.searchindex])continue;
            String[] result = new String[2];
            String[] result2 = new String[2];
            result = ob.getFrndReqInfo(Integer.toString(i), Integer.toString( ob.sbutrack[ob.searchindex]));
            result2 = ob.getFrndReqInfo(Integer.toString( ob.sbutrack[ob.searchindex]), Integer.toString(i));
            //System.out.println(result[0]+"   "+result[1]);
            /*if (result[0].compareTo("9") == 0) {
                continue;
            } else {
                ob.frndchecker[i][ ob.sbutrack[ob.searchindex]] = Integer.parseInt(result[0]);

                ob.frndchecker[ ob.sbutrack[ob.searchindex]][i] = Integer.parseInt(result[1]);

                //System.out.println(ob.frndchecker[k][ob1.userpos]+"   "+ob.frndchecker[ob1.userpos][k]);
            }*/
            
             if((result[0].compareTo("1")==0&&result[1].compareTo("1")==0)||(result2[0].compareTo("1")==0&&result2[1].compareTo("1")==0))
        {
            ob.frndchecker[ob.sbutrack[ob.searchindex]][i]=1;
           
            ob.frndchecker[i][ob.sbutrack[ob.searchindex]]=1;
        }
        else if((result[0].compareTo("1")==0&&result[1].compareTo("0")==0))
        {
            ob.frndchecker[i][ob.sbutrack[ob.searchindex]]=Integer.parseInt(result[1]);
            ob.frndchecker[ob.sbutrack[ob.searchindex]][i]=Integer.parseInt(result[0]);
           
            
            //System.out.println(ob.frndchecker[k][ob1.userpos]+"   "+ob.frndchecker[ob1.userpos][k]);
        }
        else if((result2[0].compareTo("1")==0&&result2[1].compareTo("0")==0))
        {
            
            ob.frndchecker[ob.sbutrack[ob.searchindex]][i]=Integer.parseInt(result[0]);
            ob.frndchecker[i][ob.sbutrack[ob.searchindex]]=Integer.parseInt(result[1]);
           
            
            //System.out.println(ob.frndchecker[k][ob1.userpos]+"   "+ob.frndchecker[ob1.userpos][k]);
        }
        else 
        {
            
            ob.frndchecker[ob.sbutrack[ob.searchindex]][i]=0;
            ob.frndchecker[i][ob.sbutrack[ob.searchindex]]=0;
           
            
            //System.out.println(ob.frndchecker[k][ob1.userpos]+"   "+ob.frndchecker[ob1.userpos][k]);
        }
        
            
            
            
            
           
            if (ob.frndchecker[i][ ob.sbutrack[ob.searchindex]] == 1 && ob.frndchecker[ ob.sbutrack[ob.searchindex]][i] == 1) {
                list1.add(ob.uname[i]);
                ob.frndlisttrack[x] = i;
                x++;
            }
        }


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        list1 = new java.awt.List();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        home = new javax.swing.JButton();
        profile = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        jList2.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        list1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                list1ActionPerformed(evt);
            }
        });
        getContentPane().add(list1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 504, 380));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Friend list:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 135, 33));

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 988, Short.MAX_VALUE)
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(profile)
                    .addComponent(home))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(logout)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1317, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 102));
        jLabel11.setText(" Give Comment on their statuses");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 220, 426, -1));

        jLabel4.setBackground(new java.awt.Color(0, 153, 153));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 0, 51));
        jLabel4.setText("Check your friends latest status updates");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 150, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 102));
        jLabel10.setText("Post on their wall");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 340, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setText("See their Wall");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 280, -1, -1));

        jLabel6.setText("Copyright © Tahmid Rahman, Shihab Hasan, Touhidul Islam");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 560, 443, 25));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 102));
        jLabel12.setText("Send them Messages");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 420, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void list1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list1ActionPerformed
        // TODO add your handling code here:
        int r = 0;
        r = list1.getSelectedIndex();
        ob.searchindex = ob.frndlisttrack[r];
        ob.sbutrack[ob.searchindex] = ob.frndlisttrack[r];
        
        this.setVisible(false);
        if(ob.sbutrack[ob.searchindex]==ob1.userpos)
        {
            try {
                new Profile().setVisible(true);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FriendList.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(FriendList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
        try {
            new ProfileOthers().setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FriendList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FriendList.class.getName()).log(Level.SEVERE, null, ex);
        }}
    }//GEN-LAST:event_list1ActionPerformed

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        try {
            new Home().setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FriendList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FriendList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_homeActionPerformed

    private void profileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        try {
            new Profile().setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FriendList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FriendList.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(FriendList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FriendList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FriendList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FriendList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    new FriendList().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(FriendList.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(FriendList.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton home;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.List list1;
    private javax.swing.JButton logout;
    private javax.swing.JButton profile;
    // End of variables declaration//GEN-END:variables
}