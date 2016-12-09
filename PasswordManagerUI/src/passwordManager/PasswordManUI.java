/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordManager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;


/**
 *
 * @author Lion
 */
public class PasswordManUI extends javax.swing.JFrame {

    /**
     * Creates new form passwordManUI
     */
    public PasswordManUI() {
        
        initComponents();
        MouseListener ml = new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                DefaultTreeModel model = (DefaultTreeModel)siteTree.getModel();
                DefaultMutableTreeNode node =(DefaultMutableTreeNode) siteTree.getLastSelectedPathComponent();
                
                
                if (e.getClickCount() == 2 && node.getLevel() > 1) {
                    System.out.println("Double clicked");
                    System.out.println(node.toString());
                    Object nodeinfo = node.getUserObject();
                    Website nodesite = (Website)nodeinfo;
                    SiteWindow viewSite = new SiteWindow(nodesite.getSiteName(), nodesite.getUserName(), nodesite.getPassword(), nodesite.getNotes());
                    viewSite.setVisible(true);
            }
        }
    };
    siteTree.addMouseListener(ml);
        
       
        
    }
       //setting the jList to be a DefaultListModel, which is mutable
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addFolderBtn = new javax.swing.JButton();
        siteScrollPane = new javax.swing.JScrollPane();
        siteTree = new javax.swing.JTree();
        addSiteBtn = new javax.swing.JButton();
        randPassword = new javax.swing.JButton();
        labMessage = new javax.swing.JLabel();
        deleteBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Password Manager");

        addFolderBtn.setText("Add Folder");
        addFolderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFolderBtnActionPerformed(evt);
            }
        });

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Websites");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Default");
        treeNode1.add(treeNode2);
        siteTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        siteTree.setToolTipText("");
        siteScrollPane.setViewportView(siteTree);

        addSiteBtn.setText("Add Website");
        addSiteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSiteBtnActionPerformed(evt);
            }
        });

        randPassword.setText("Generate Random Password");
        randPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randPasswordActionPerformed(evt);
            }
        });

        deleteBtn.setText("Delete Item");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(randPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addComponent(labMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(deleteBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addFolderBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addSiteBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 282, Short.MAX_VALUE)
                        .addComponent(siteScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(addFolderBtn)
                        .addGap(18, 18, 18)
                        .addComponent(addSiteBtn)
                        .addGap(18, 18, 18)
                        .addComponent(deleteBtn)
                        .addGap(0, 114, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(siteScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labMessage)
                    .addComponent(randPassword))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    User user = new User();
    private void addFolderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFolderBtnActionPerformed
        // TODO add your handling code here:
        System.out.println("Add folder button pressed.");
        labMessage.setText("");
        DefaultTreeModel model = (DefaultTreeModel)(siteTree.getModel()); 
        String newFolder =
            JOptionPane.showInputDialog(this, "Please enter the name of your new folder:");
        DefaultMutableTreeNode root = (DefaultMutableTreeNode)model.getRoot();
        root.add(new DefaultMutableTreeNode(newFolder));
        model.reload();
        

       
    }//GEN-LAST:event_addFolderBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        labMessage.setText("");
        System.out.println("Delete button pressed.");
        DefaultTreeModel model = (DefaultTreeModel) (siteTree.getModel());
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) (siteTree.getLastSelectedPathComponent());
        if (node.isRoot()) {
            labMessage.setText("The root cannot be deleted");
        }
        else {
            if (node != null) {
                model.removeNodeFromParent(node);
            }
            else {
             labMessage.setText("Please select a website or username to delete");
            }
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void randPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randPasswordActionPerformed
        // run password generator on click
        System.out.println("Password generator button pressed");
        passwordGenWindow.getObj().setVisible(true);
        
    }//GEN-LAST:event_randPasswordActionPerformed

    private void addSiteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSiteBtnActionPerformed
        System.out.println("Add site button pressed.");
        labMessage.setText("");
        DefaultTreeModel model = (DefaultTreeModel) (siteTree.getModel());

        DefaultMutableTreeNode parent = (DefaultMutableTreeNode) (siteTree.getLastSelectedPathComponent());
        if(parent.isRoot()){
            labMessage.setText("You must select a folder to insert a website");
        }
        else {
            Website tmpsite = new Website();
            String newSite =
                JOptionPane.showInputDialog(this, "Please enter the name of your new website:");
            String newUser =
                    JOptionPane.showInputDialog(this, "Please enter the name of your new username:");
            String newPass = 
                JOptionPane.showInputDialog(this, "Please enter a password:");
            tmpsite.setSiteName(newSite);
            tmpsite.setPassword(newPass);
            tmpsite.setUserName(newUser);
            model.insertNodeInto(new DefaultMutableTreeNode(tmpsite), parent, parent.getChildCount());
        }
    }//GEN-LAST:event_addSiteBtnActionPerformed


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
            java.util.logging.Logger.getLogger(PasswordManUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PasswordManUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PasswordManUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PasswordManUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PasswordManUI().setVisible(true);
                
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addFolderBtn;
    private javax.swing.JButton addSiteBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel labMessage;
    private javax.swing.JButton randPassword;
    private javax.swing.JScrollPane siteScrollPane;
    private javax.swing.JTree siteTree;
    // End of variables declaration//GEN-END:variables
}