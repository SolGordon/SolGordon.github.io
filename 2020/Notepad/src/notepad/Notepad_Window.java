/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad;

import com.sun.glass.ui.Application;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author solan
 */
public class Notepad_Window extends javax.swing.JFrame {

    /**
     * Creates new form Notepad_Window
     */
    public Notepad_Window() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtDisplay = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menunew = new javax.swing.JMenuItem();
        menuopen = new javax.swing.JMenuItem();
        menusave = new javax.swing.JMenuItem();
        menusaveas = new javax.swing.JMenuItem();
        menuexit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtDisplay.setColumns(20);
        txtDisplay.setRows(5);
        jScrollPane1.setViewportView(txtDisplay);

        jMenu1.setText("File");

        menunew.setText("New");
        menunew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menunewActionPerformed(evt);
            }
        });
        jMenu1.add(menunew);

        menuopen.setText("Open");
        menuopen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuopenActionPerformed(evt);
            }
        });
        jMenu1.add(menuopen);

        menusave.setText("Save");
        menusave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menusaveActionPerformed(evt);
            }
        });
        jMenu1.add(menusave);

        menusaveas.setText("Save As");
        menusaveas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menusaveasActionPerformed(evt);
            }
        });
        jMenu1.add(menusaveas);

        menuexit.setText("Exit");
        menuexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuexitActionPerformed(evt);
            }
        });
        jMenu1.add(menuexit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Help");

        jMenuItem1.setText("About");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menunewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menunewActionPerformed
        txtDisplay.setText("");
    }//GEN-LAST:event_menunewActionPerformed

    private void menuexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuexitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuexitActionPerformed

    private void menusaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menusaveActionPerformed
        JFileChooser fs = new JFileChooser(new File("c:\\"));
        fs.setDialogTitle("Save");
        int result = fs.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            String content = txtDisplay.getText();
            File fi = fs.getSelectedFile();
            try {
                FileWriter fw = new FileWriter(fi.getPath());
                fw.write(content);
                fw.flush();
                fw.close();
            } catch (IOException e) {

            }
        }
    }//GEN-LAST:event_menusaveActionPerformed

    private void menusaveasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menusaveasActionPerformed
        JFileChooser fs = new JFileChooser(new File("c:\\"));
        fs.setDialogTitle("Save As");
        int result = fs.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            String content = txtDisplay.getText();
            File fi = fs.getSelectedFile();
            try {
                FileWriter fw = new FileWriter(fi.getPath());
                fw.write(content);
                fw.flush();
                fw.close();
            } catch (IOException e) {
              
            }
        }
    }//GEN-LAST:event_menusaveasActionPerformed

    private void menuopenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuopenActionPerformed
        JFileChooser fs = new JFileChooser(new File("c:\\"));
        fs.setDialogTitle("Open");
        int result = fs.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION){
            try {
                File fi = fs.getSelectedFile();
                BufferedReader br = new BufferedReader(new FileReader(fs.getSelectedFile().getPath()));
                String s ="";
                while((s = br.readLine()) != null){
                    txtDisplay.setText(s);
                }
                if(br != null){
                    br.close();
            }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Notepad_Window.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Notepad_Window.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_menuopenActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JOptionPane.showMessageDialog(null, "Solandy Gordon" + "\n" + "Version 1.0 (Netbeans IDE 8.2)" + " \n" + "");
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(Notepad_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Notepad_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Notepad_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Notepad_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Notepad_Window().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem menuexit;
    private javax.swing.JMenuItem menunew;
    private javax.swing.JMenuItem menuopen;
    private javax.swing.JMenuItem menusave;
    private javax.swing.JMenuItem menusaveas;
    private javax.swing.JTextArea txtDisplay;
    // End of variables declaration//GEN-END:variables
}