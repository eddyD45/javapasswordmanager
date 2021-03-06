/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordManager;

import javax.swing.JOptionPane;

/**
 *
 * @author Lion
 */
public class passwordGenWindow extends javax.swing.JFrame {

    private static passwordGenWindow obj = null;
    /**
     * Creates new form passwordGenWindow
     */
    private passwordGenWindow() {
        initComponents();
    }

    public static passwordGenWindow getObj() {
        if (obj == null) {
            obj = new passwordGenWindow();
        }
        return obj;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        descriptionLab = new javax.swing.JLabel();
        capitalCheck = new javax.swing.JCheckBox();
        lowerCheck = new javax.swing.JCheckBox();
        numberCheck = new javax.swing.JCheckBox();
        symbolCheck = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        numOfChars = new javax.swing.JTextField();
        genPassBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        descriptionLab.setText("Select what you want in your password:");

        capitalCheck.setText("Capitals");

        lowerCheck.setText("Lowercase");

        numberCheck.setText("Numbers");

        symbolCheck.setText("Symbols");

        jLabel1.setText("Enter the number of characters for the password:");

        numOfChars.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numOfCharsActionPerformed(evt);
            }
        });

        genPassBtn.setText("Generate Password");
        genPassBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genPassBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(symbolCheck)
                            .addComponent(numberCheck)
                            .addComponent(lowerCheck)
                            .addComponent(descriptionLab)
                            .addComponent(capitalCheck)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(numOfChars, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(genPassBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(descriptionLab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(capitalCheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lowerCheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numberCheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(symbolCheck)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(numOfChars, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(genPassBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    User user = new User();
    private void numOfCharsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numOfCharsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numOfCharsActionPerformed

    private void genPassBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genPassBtnActionPerformed
        boolean capital = capitalCheck.isSelected();
        boolean lower = lowerCheck.isSelected();
        boolean number = numberCheck.isSelected();
        boolean symbol = symbolCheck.isSelected();
        int chars = Integer.parseInt(numOfChars.getText());
        String password = user.PasswordGen(chars, capital, lower, number, symbol);
        Password s = new Password();
        s.setStrPassword(password);
        super.dispose();
        JOptionPane.showInputDialog(null, "Highlight and press ctrl+c to copy the password:", s.getPassword());
        
        
    }//GEN-LAST:event_genPassBtnActionPerformed

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
            java.util.logging.Logger.getLogger(passwordGenWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(passwordGenWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(passwordGenWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(passwordGenWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new passwordGenWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox capitalCheck;
    private javax.swing.JLabel descriptionLab;
    private javax.swing.JButton genPassBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JCheckBox lowerCheck;
    public javax.swing.JTextField numOfChars;
    private javax.swing.JCheckBox numberCheck;
    private javax.swing.JCheckBox symbolCheck;
    // End of variables declaration//GEN-END:variables
}
