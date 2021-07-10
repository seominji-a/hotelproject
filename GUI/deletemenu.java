/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author 고승희
 */
public class deletemenu extends javax.swing.JFrame {
    File menufile = new File("menu.txt");
    boolean Search = false;
    /**
     * Creates new form deletemenu
     */
    public deletemenu() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        roomnum = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        checknum = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("굴림", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("주문 삭제");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 219, -1));

        jButton3.setText("검색");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 77, -1));

        jLabel2.setText("*고유 번호 :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, -1, 25));

        jLabel3.setText("*룸 번호 : ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        roomnum.setToolTipText("");
        roomnum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomnumActionPerformed(evt);
            }
        });
        getContentPane().add(roomnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 97, -1));

        jButton2.setText("뒤로가기");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 77, -1));
        getContentPane().add(checknum, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 96, -1));

        jButton1.setText("삭제");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 330, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String line = "";
        String[] array;
        boolean check = false;
        FileInputStream fis;
        
            try {
                fis = new FileInputStream(menufile);
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader menureader = new BufferedReader(isr);
                
                while((line = menureader.readLine())!=null){
                    array = line.split("/");
                    if(roomnum.getText().equals(array[0]) && checknum.getText().equals(array[1])){
                        JOptionPane.showMessageDialog(null,"검색인증이 완료되었습니다.\n 주문 내역 : " + array[3]);
                        check = true;
                        Search = true;
                    }
                }
                if(check == false){
                    JOptionPane.showMessageDialog(null,"방 번호와 고유 번호를 확인해주세요.");
                }
                
                menureader.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(OrderMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(OrderMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void roomnumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomnumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roomnumActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(Search == true){
        String line = "";
        String[] array;
        String menudummy = "";
        FileInputStream fis;
        
            try {
                fis = new FileInputStream(menufile);
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader menureader = new BufferedReader(isr);
                
                while((line = menureader.readLine())!=null){
                    array = line.split("/");
                    if(!roomnum.getText().equals(array[0]) && !checknum.getText().equals(array[1])){
                        menudummy += (line + "\r\n");
                    }
                }
                FileWriter fw = new FileWriter("menu.txt");
                JOptionPane.showMessageDialog(null,"주문 삭제가 완료되었습니다.");
                fw.write(menudummy);
                fw.close();
                menureader.close();
                dispose();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(OrderMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(OrderMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
             JOptionPane.showMessageDialog(null,"먼저 방 번호와 고유 번호를 검색인증 해주세요.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(deletemenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(deletemenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(deletemenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(deletemenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new deletemenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField checknum;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField roomnum;
    // End of variables declaration//GEN-END:variables
}