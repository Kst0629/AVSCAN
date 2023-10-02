/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.barcodegenerationprototype;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.*;

/**
 *
 * @author vince-kong
 */
public class background extends javax.swing.JFrame {
    private BitMatrix matrix;
    private String randCode;
    

    /**
     * Creates new form background
     */
    public background() {
        initComponents();
        barcodeDisplay.setOpaque(true);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barcodeGenerate = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        barcodeDisplay = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        barcodeGenerate.setText("Generate barcode");
        barcodeGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barcodeGenerateActionPerformed(evt);
            }
        });

        barcodeDisplay.setBackground(new java.awt.Color(255, 255, 255));
        barcodeDisplay.setForeground(new java.awt.Color(255, 255, 255));

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(barcodeDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(barcodeGenerate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabel1)
                        .addGap(132, 132, 132))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(barcodeDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(barcodeGenerate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(saveButton)
                .addContainerGap())
        );

        barcodeDisplay.setOpaque(true);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void barcodeGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barcodeGenerateActionPerformed
        // TODO add your handling code here:
    BarcodeGenerationPrototype generator = new BarcodeGenerationPrototype();// this object calls the functions from the other java file. 
    randCode = generator.randomCode();
//        String path = "/Users/vince-kong/Documents/Barcodes/barcode.jpg";
    Code128Writer cWriter = new Code128Writer();
        try{
            matrix = cWriter.encode(randCode, BarcodeFormat.CODE_128, 500, 200);
            Icon icon = generator.convertBarcode(matrix); // Call the method on 'generator'
            barcodeDisplay.setIcon(icon);  
            
        }  catch(Exception e) {
            JOptionPane.showMessageDialog(null, "There was an error while generating!");
        }    
    }//GEN-LAST:event_barcodeGenerateActionPerformed
    //saves the generated code into the selected destination. 
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        //if matrix and the random code is null it will generate the barcode. 
         if (matrix != null && randCode != null) {
            try {
                String path = "/Users/vince-kong/Documents/Barcodes/barcode_" + randCode + ".jpg";
                BufferedImage image = MatrixToImageWriter.toBufferedImage(matrix);
                ImageIO.write(image, "jpg", new File(path));
                JOptionPane.showMessageDialog(null, "Barcode saved successfully.");
            } catch (IOException e) {//this catch is here so that if a problem occurs while saving a warning message will come up to alert the user.
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error saving barcode: " + e.getMessage());
            }
        } else {//this else shows up when the user tries to save a barcode, but if the user has not generated a barcode this message will pop up to warn the user to generate one first
            JOptionPane.showMessageDialog(null, "No barcode to save. Generate a barcode first.");
        }

    }//GEN-LAST:event_saveButtonActionPerformed

   
    
    
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
            java.util.logging.Logger.getLogger(background.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(background.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(background.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(background.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new background().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel barcodeDisplay;
    private javax.swing.JButton barcodeGenerate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}
