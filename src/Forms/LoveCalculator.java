package Forms;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tahmid
 */
import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*; 
import java.math.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class LoveCalculator extends javax.swing.JFrame {

    /**
     * Creates new form Apps
     */
      String a, b,d,ee;
        int ax,bx;
        Double  c;
    public LoveCalculator() {
        initComponents();
        setResizable(false);
        label3.setVisible(false);
        setResizable(false);
      //   label3.setEnabled(false);
        // ImageIcon ic = new ImageIcon("a.jpg");  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        textBox1 = new javax.swing.JTextField();
        textBox2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1024, 768));
        getContentPane().setLayout(null);

        jButton2.setBackground(new java.awt.Color(0, 102, 102));
        jButton2.setText("Home");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(0, 0, 110, 40);
        getContentPane().add(textBox1);
        textBox1.setBounds(300, 60, 170, 40);
        getContentPane().add(textBox2);
        textBox2.setBounds(300, 150, 170, 40);

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(350, 220, 73, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setText("Enter Your Name:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(120, 50, 150, 50);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 51));
        jLabel2.setText("Enter Your Lover's Name:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(120, 140, 170, 40);

        label3.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        label3.setForeground(new java.awt.Color(237, 48, 48));
        label3.setText("Love");
        getContentPane().add(label3);
        label3.setBounds(530, 100, 470, 230);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/Pink-Love-58573-SK-HD.jpg"))); // NOI18N
        jLabel4.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, -20, 1030, 810);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
          a = textBox1.getText();
            d = a;
            a = a. toLowerCase ();
            ax=0;
            for (int i = 0; i < a.length(); i++)
            {
             //   str.charAt(12)
                ax = ax + (a.charAt(i) - 96);
            }
            int cx=0;
          
            while (true)
            {
                cx =cx+ (ax % 10);
                ax = ax / 10;
                if (ax == 0)
                {
                    if (cx > 9)
                    { ax = cx; cx = 0; }
                    else break;
                }
            }
            ax = cx;
             bx = 0;
            b = textBox2.getText();
            ee = b;
            b = b. toLowerCase ();
            for (int i = 0; i < b.length(); i++)
            {
              
                bx = bx + (b.charAt(i) - 96);
            }
            cx = 0;
            while (true)
            {
                cx = cx + (bx % 10);
                bx = bx / 10;
                if (bx == 0)
                {
                    if (cx > 9)
                    { bx = cx; cx = 0; }
                    else break;
                }
            }
            bx = cx;
              if (ax < bx)
                c = (double)ax / bx;
            else
                c =(double) bx / ax;
            c = c * 100;
          //  ax = c;
            c = Math.ceil(c);
            String stringVal =  Double.toString(c);
            stringVal = stringVal + " %";
            stringVal = "Love between \n" + d + " and " + ee + " is " + stringVal;
            if (textBox2.getText() == null || textBox1.getText() == null)
                 JOptionPane.showMessageDialog(null,"Please fill all the name!!!");
              
            else {
               // MessageBox.Show("Love between " +d+" and "+ee+" is "+ stringVal);
                //MessageBox.Show(); 
                label3.setText(stringVal);
                label3.setVisible(true);
            }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        try {
            new Home().setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoveCalculator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoveCalculator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Apps.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Apps.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Apps.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Apps.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new LoveCalculator().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel label3;
    private javax.swing.JTextField textBox1;
    private javax.swing.JTextField textBox2;
    // End of variables declaration//GEN-END:variables
}
