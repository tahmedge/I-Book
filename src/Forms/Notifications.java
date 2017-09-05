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
public class Notifications extends javax.swing.JFrame {

    /**
     * Creates new form Notifications
     */
    SignUp ob = new SignUp();
    Intro ob1 = new Intro();

    public Notifications() throws SQLException, ClassNotFoundException {
        initComponents();
        setResizable(false);
        /*
         * system("cls"); int r; notify[pos]=0; for(r=e[pos]-1; r>=0; r--) {
         * cout<<" "<<notification[pos][r]<<endl; }
         */
         /*
         * system("cls"); int r; notify[pos]=0; for(r=e[pos]-1; r>=0; r--) {
         * cout<<" "<<notification[pos][r]<<endl; }
         */
        
        ob.loadUserWallpost(Integer.toString(ob1.userpos));
        int i;
        ob.newnotification[ob1.userpos] = 0;
        /*
         * for(i=ob.notificationlimit[ob1.userpos]-1;i>=0;i--) {
         * list1.add(ob.notificationstring[ob1.userpos][i]);
        }
         */
        int x = Integer.parseInt(ob.getTotalNotification(Integer.toString(ob1.userpos)));
        ob.notificationlimit[ob1.userpos]=x;
        for (i = 0; i < ob.notificationlimit[ob1.userpos]; i++) {
            
            ob.notificationstring[ob1.userpos][i]=ob.getNotification(Integer.toString(ob1.userpos), Integer.toString(i));
            String[] result = new String[3];
            result=ob.getNotificationInfo(Integer.toString(ob1.userpos), Integer.toString(i));
            ob.Notificationtype[ob1.userpos][i] = Integer.parseInt(result[0]);
            ob.NotificationlinkUser[ob1.userpos][i] = Integer.parseInt(result[1]);
            ob.NotificationlinkPost[ob1.userpos][i]= Integer.parseInt(result[2]);
            System.out.println(ob.NotificationlinkPost[ob1.userpos][i]+" ");
            list1.add(ob.notificationstring[ob1.userpos][i]);
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

        list1 = new java.awt.List();
        jPanel1 = new javax.swing.JPanel();
        home = new javax.swing.JButton();
        profile = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        list1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                list1ActionPerformed(evt);
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
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(logout)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Notifications:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(list1, javax.swing.GroupLayout.PREFERRED_SIZE, 781, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(list1, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void list1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list1ActionPerformed
        // TODO add your handling code here:
        
        
        
        int r = list1.getSelectedIndex();
        if (ob.Notificationtype[ob1.userpos][r] == 4) {
            ob.searchindex=ob1.userpos;
            ob.sbutrack[ob.searchindex] = ob1.userpos;
            ob.wallindex = ob.NotificationlinkPost[ob1.userpos][r];
            ob.walldisplay= ob.wallpost[ob1.userpos][ob.wallindex];
            System.out.println(  ob.walldisplay);
            this.setVisible(false);
            try {
                new Wallpostcomment().setVisible(true);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Notifications.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Notifications.class.getName()).log(Level.SEVERE, null, ex);
            }
        }                                     
        else if (ob.Notificationtype[ob1.userpos][r] == 3) {
            ob.newsfeedindex = 0;
            ob.nfutrack[ob.newsfeedindex] = ob.NotificationlinkUser[ob1.userpos][r];
            ob.nfstrack[ob.newsfeedindex] = ob.NotificationlinkPost[ob1.userpos][r];
            this.setVisible(false);
            try {
                new Statuscomment().setVisible(true);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Notifications.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Notifications.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_list1ActionPerformed

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        try {
            new Home().setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Notifications.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Notifications.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_homeActionPerformed

    private void profileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        try {
            new Profile().setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Notifications.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Notifications.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(Notifications.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Notifications.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Notifications.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Notifications.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    new Notifications().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Notifications.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Notifications.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton home;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private java.awt.List list1;
    private javax.swing.JButton logout;
    private javax.swing.JButton profile;
    // End of variables declaration//GEN-END:variables
}
