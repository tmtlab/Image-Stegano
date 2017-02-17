/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagestegano;

import data.CustomIndexColorModel;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.IndexColorModel;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import steganography.BPCS;
import steganography.BitwiseXOR;
import steganography.ColourMap;
import steganography.ImageManipulation;
import utility.ImageUtility;

/**
 *
 * @author varun
 */
public class ImageStegano extends javax.swing.JFrame {

    BufferedImage originalImage;
    BufferedImage currentImage;
    ImageUtility imageUtility;
    BPCS bitPlane;
    File openedFile;
    BitwiseXOR bitwiseXOR;
    ColourMap colourMap;
    
    // pixel size of original image
    int pixelSize;
    
    /**
     * value of bpcsIndex - 
     * [-8, -1] all plane where -8 is MSB and -1 is LSB
     * [0, 7] blue plane where 0 is MSB and 7 is LSB 
     * [8, 15] green plane where 8 is MSB and 15 is LSB 
     * [16, 23] red plane
     * if alpha channel is present then [0, 7] alpha plane, 0 is MSB and
     * all other planes is shifted by one byte
     * color model is ABGR or BGR (in byte array)
     */
    int bpcsIndex;
    
    // negative index will be used for all plane BPCS 
    int minBPCSIndex;
    
    // value of colourMapIndex - [0, 7] for 8 different colour maps
    int colourMapIndex;
    
    // value of bitwiseXORIndex [1, 28] (4 * 4 + 4 * 3)
    // see mapping method in BitwiseXOR.java
    int bitwiseXORIndex;
    
    CustomIndexColorModel customIndexColorModelObject;
    IndexColorModel customIndexColorModels[];
    int othersIndex;
    ImageManipulation imageManipulation;
    
    /**
     * Creates new form ImageStegano
     */
    public ImageStegano() {
        originalImage = null;
        currentImage = null;
        imageUtility = new ImageUtility();
        bitPlane = new BPCS();
        bpcsIndex = -9;
        colourMapIndex = -1;
        bitwiseXORIndex = 0;
        bitwiseXOR = new BitwiseXOR();
        colourMap = new ColourMap();
        
        //[-1, -8] all plane BPCS
        minBPCSIndex = -8;
        
        customIndexColorModelObject = new CustomIndexColorModel();
        customIndexColorModels = 
                customIndexColorModelObject.getIndexColorModelArray();
        othersIndex = 0;
        imageManipulation = new ImageManipulation();
        
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

        fileChooser = new javax.swing.JFileChooser();
        buttonGroup1 = new javax.swing.ButtonGroup();
        previousButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        imageLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        bitPlaneRadioButton = new javax.swing.JRadioButton();
        colourMapRadioButton = new javax.swing.JRadioButton();
        bitwiseXORRadioButton = new javax.swing.JRadioButton();
        othersRadioButton = new javax.swing.JRadioButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        analyzeMenu = new javax.swing.JMenu();
        histogramMenu = new javax.swing.JMenu();
        hideDataMenu = new javax.swing.JMenu();
        helpMenu = new javax.swing.JMenu();

        fileChooser.setDialogTitle("Choose an image");
        fileChooser.setFileFilter(new imagestegano.ImageFileFilter());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        previousButton.setText("Previous");
        previousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousButtonActionPerformed(evt);
            }
        });
        previousButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                previousButtonKeyReleased(evt);
            }
        });

        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });
        nextButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nextButtonKeyReleased(evt);
            }
        });

        imageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jScrollPane1.setViewportView(imageLabel);

        nameLabel.setText("Open an Image using Ctrl + O or File menu");

        buttonGroup1.add(bitPlaneRadioButton);
        bitPlaneRadioButton.setSelected(true);
        bitPlaneRadioButton.setText("Bit Plane");

        buttonGroup1.add(colourMapRadioButton);
        colourMapRadioButton.setText("Colour Map");

        buttonGroup1.add(bitwiseXORRadioButton);
        bitwiseXORRadioButton.setText("Bitwise XOR");

        buttonGroup1.add(othersRadioButton);
        othersRadioButton.setText("Others");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bitPlaneRadioButton)
                        .addGap(54, 54, 54)
                        .addComponent(colourMapRadioButton)
                        .addGap(54, 54, 54)
                        .addComponent(bitwiseXORRadioButton)
                        .addGap(51, 51, 51)
                        .addComponent(othersRadioButton)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bitPlaneRadioButton)
                    .addComponent(colourMapRadioButton)
                    .addComponent(bitwiseXORRadioButton)
                    .addComponent(othersRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        fileMenu.setText("File");

        openMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openMenuItem.setText("Open");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuItem);

        saveAsMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveAsMenuItem.setText("Save As");
        saveAsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        jMenuBar1.add(fileMenu);

        analyzeMenu.setText("Analyze");
        jMenuBar1.add(analyzeMenu);

        histogramMenu.setText("Histogram");
        jMenuBar1.add(histogramMenu);

        hideDataMenu.setText("Hide Data");
        jMenuBar1.add(hideDataMenu);

        helpMenu.setText("Help");
        jMenuBar1.add(helpMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(previousButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nextButton)
                .addGap(143, 143, 143))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(previousButton)
                    .addComponent(nextButton)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
        fileChooser.setDialogTitle("Select an image");
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            openedFile = fileChooser.getSelectedFile();
            String name = openedFile.getName();
            try {
                ImageFileFilter imageFilter = new ImageFileFilter();
                if (imageFilter.isImage(name)) {
                    originalImage = ImageIO.read(openedFile);
                    
                    // will initialize pixelSize variable
                    System.out.println("Original Image Info:");
                    printImageInfo(originalImage);
                    
                    // converting original image to suitable type
                    currentImage = imageUtility.convertImage(originalImage);
                    if (currentImage != null) {
                        originalImage = currentImage;
                        System.out.println("Converted Image Info:");
                        
                        // will ovverride pixelSize variable
                        printImageInfo(originalImage);
                    }
                    
                    imageLabel.setIcon(new ImageIcon(originalImage));
                    nameLabel.setText("Normal Image. Use --> " + 
                            "and <-- key to navigate.");
                } else {
                    JOptionPane.showMessageDialog(null, 
                            "Please select an image");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File access cancelled by user.");
        }
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void previousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousButtonActionPerformed
        if (bitPlaneRadioButton.isSelected()) {
            if (bpcsIndex <= minBPCSIndex) {
                bpcsIndex = pixelSize;
            }
            bpcsIndex--;
            manipulateImage();
        } else if (bitwiseXORRadioButton.isSelected()) {
            if (bitwiseXORIndex <= 1) {
                bitwiseXORIndex = 29;
            }
            bitwiseXORIndex--;
            applyBitwiseXOR();
        } else if (colourMapRadioButton.isSelected()) {
            if (colourMapIndex <= 0) {
                colourMapIndex = 8;
            }
            colourMapIndex--;
            applyColourMap();
        } else if (othersRadioButton.isSelected()) {
            if (othersIndex <= 1) {
                othersIndex = 3;
            }
            othersIndex--;
            otherManipulations();
        }
    }//GEN-LAST:event_previousButtonActionPerformed

    private void previousButtonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_previousButtonKeyReleased
        int keyCode = evt.getKeyCode();
        if (keyCode == 39) {
            nextButton.doClick();
        } else if (keyCode == 37) {
            previousButton.doClick();
        }
    }//GEN-LAST:event_previousButtonKeyReleased

    private void nextButtonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nextButtonKeyReleased
        int keyCode = evt.getKeyCode();
        if (keyCode == 39) {
            nextButton.doClick();
        } else if (keyCode == 37) {
            previousButton.doClick();
        }
    }//GEN-LAST:event_nextButtonKeyReleased

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        if (bitPlaneRadioButton.isSelected()) {
            if (bpcsIndex >= pixelSize - 1) {
                bpcsIndex = minBPCSIndex - 1;
            }
            bpcsIndex++;
            manipulateImage();
        } else if (bitwiseXORRadioButton.isSelected()) {
            if (bitwiseXORIndex >= 28) {
                bitwiseXORIndex = 0;
            }
            bitwiseXORIndex++;
            applyBitwiseXOR();
        } else if (colourMapRadioButton.isSelected()) {
            if (colourMapIndex >= 7) {
                colourMapIndex = -1;
            }
            colourMapIndex++;
            applyColourMap();
        } else if (othersRadioButton.isSelected()) {
            if (othersIndex >= 2) {
                othersIndex = 0;
            }
            othersIndex++;
            otherManipulations();
        }
    }//GEN-LAST:event_nextButtonActionPerformed

    private void saveAsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsMenuItemActionPerformed
        if (currentImage == null) {
            return;
        }
        fileChooser.setDialogTitle("Choose a location");
        String oldFileName = openedFile.getName();
        String newFileName = imageUtility.getNewFileName(oldFileName);
        String path = openedFile.getAbsolutePath();
        path = path.substring(0, path.lastIndexOf(File.separator) + 1);
        File file = new File(path + newFileName);
        fileChooser.setSelectedFile(file);
        int returnVal = fileChooser.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            String name = file.getName();
            if (imageUtility.isImage(name)) {
                imageUtility.saveImage(currentImage, file);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid file name");
            }
            
        } else {
            System.out.println("File access cancelled by user.");
        }
    }//GEN-LAST:event_saveAsMenuItemActionPerformed

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
            java.util.logging.Logger.getLogger(ImageStegano.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImageStegano.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImageStegano.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImageStegano.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImageStegano().setVisible(true);
            }
        });
    }
    
    private void applySinglePlaneBPCS() {
        if (originalImage != null) {
            currentImage = imageUtility.copyImage(originalImage);
            bitPlane.singlePlaneBPCS(currentImage, bpcsIndex, pixelSize);
            imageLabel.setIcon(new ImageIcon(currentImage));
            int bitPlaneCode = bpcsIndex / 8;
            String bitPlaneName = "Alpha";
            
            // checking if alpha channel is absent
            if (pixelSize <= 24) {
                bitPlaneCode += 1;
            }
            switch(bitPlaneCode) {
                case 1: 
                    bitPlaneName = "Blue";
                    break;
                case 2:
                    bitPlaneName = "Green";
                    break;
                case 3:
                    bitPlaneName = "Red";
                    break;
            }
            nameLabel.setText(bitPlaneName + " plane: " + 
                    (7 - (bpcsIndex % 8)) + "th bit");
        }
    }
    
    private void manipulateImage() {
        if (bpcsIndex >= 0) {
            applySinglePlaneBPCS();
        } else if (bpcsIndex >= minBPCSIndex) {
            applyAllPlaneBPCS();
        }
    }
    
    private void applyAllPlaneBPCS() {
        if (originalImage != null) {
            currentImage = imageUtility.copyImage(originalImage);
            bitPlane.allPlaneBPCS(currentImage, bpcsIndex, pixelSize);
            imageLabel.setIcon(new ImageIcon(currentImage));
            nameLabel.setText("All plane: " + ((bpcsIndex * -1) - 1) + "th bit");
        }
    }
    
    private void applyBitwiseXOR() {
        if (originalImage != null) {
            currentImage = imageUtility.copyImage(originalImage);
            bitwiseXOR.xor(currentImage, bitwiseXORIndex, pixelSize, nameLabel);
            imageLabel.setIcon(new ImageIcon(currentImage));
        }
    }
    
    private void printImageInfo(BufferedImage image) {
        System.out.println("Image Type: " + image.getType());
        ColorModel colorModel = image.getColorModel();
        pixelSize = colorModel.getPixelSize();
        System.out.println("Pixel size: " + pixelSize);
        System.out.println("Alpha channel present: "
                + colorModel.hasAlpha());
    }
    
    private void applyColourMap() {
        if (originalImage != null) {
            currentImage = imageUtility.copyImage(originalImage);
            currentImage = colourMap.changeColourMap(currentImage, 
                    customIndexColorModels[colourMapIndex]);
            if (currentImage != null) {
                nameLabel.setText("Colour Map: " + colourMapIndex);
                imageLabel.setIcon(new ImageIcon(currentImage));
            } else {
                nameLabel.setText("Not an indexed image");
            }
        }
    }
    
    private void otherManipulations() {
        if (originalImage == null) {
            return;
        }
        currentImage = imageUtility.copyImage(originalImage);
        switch (othersIndex) {
            case 1: {
                imageManipulation.convertToGrayscale(currentImage);
                nameLabel.setText("Grayscale");
                break;
            }
            case 2: {
                imageManipulation.invertImage(currentImage, pixelSize);
                nameLabel.setText("Inverted");
                break;
            }
        }
        imageLabel.setIcon(new ImageIcon(currentImage));
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu analyzeMenu;
    private javax.swing.JRadioButton bitPlaneRadioButton;
    private javax.swing.JRadioButton bitwiseXORRadioButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton colourMapRadioButton;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenu hideDataMenu;
    private javax.swing.JMenu histogramMenu;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton nextButton;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JRadioButton othersRadioButton;
    private javax.swing.JButton previousButton;
    private javax.swing.JMenuItem saveAsMenuItem;
    // End of variables declaration//GEN-END:variables
}
