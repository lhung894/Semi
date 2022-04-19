/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BUS.ProductBUS;
import BUS.TagBUS;
import DTO.ProductDTO;
import DTO.TagDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Set;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hyung
 */
public class NhapDlForm extends javax.swing.JFrame {

    DefaultTableModel tbModelTag, tbModelProduct;
    Set<String> tags;
    ProductBUS productBUS = new ProductBUS();
    TagBUS tagBUS = new TagBUS();
    int rowTag = -2, rowProduct = -2;
    boolean selectedTag = false, selectedProduct = false;
    String idTag = "", idProduct = "";
    public static ArrayList<TagDTO> tagDTOs = new ArrayList<>();
//    MainRead readTags

    /**
     * Creates new form NhapDlForm
     */
    public NhapDlForm() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        this.setVisible(false);
        initTableTag();
        initTableProduct();
        jBtnAdd.setEnabled(false);
    }

    public NhapDlForm(Set<String> tags) {
        initComponents();
        this.tags = tags;
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        this.setVisible(true);
        initTableTagSet();
        initTableProduct();
        jBtnAdd.setEnabled(false);
    }

    public void initTableTagSet() {
        tbModelTag.setRowCount(0);
        tableModelTagSet(tbModelTag);
        jTableTag.setRowSorter(null);
        jTableTag.setAutoCreateRowSorter(true);
        jTableTag.setModel(tbModelTag);
        jTableTag.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void initTableTag() {
        tbModelTag.setRowCount(0);
        tableModelTag(tbModelTag);
        jTableTag.setRowSorter(null);
        jTableTag.setAutoCreateRowSorter(true);
        jTableTag.setModel(tbModelTag);
        jTableTag.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void initTagAuto() {
        tbModelTag.setRowCount(0);
        tableModelTag(tbModelTag);
    }

    public void initTableProduct() {
        tbModelProduct.setRowCount(0);
        tableModelProduct(tbModelProduct);
//        jTableProduct.setRowSorter(null);
//        jTableProduct.setAutoCreateRowSorter(true);
        jTableProduct.setModel(tbModelProduct);
        jTableProduct.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void tableModelTagSet(DefaultTableModel model) {
        for (String tag : tags) {
            System.out.println("tag: " + tag);
            Vector row = new Vector();
            row.add(tag);
            model.addRow(row);
        }
    }

    public void tableModelTag(DefaultTableModel model) {
        for (TagDTO tag : tagDTOs) {
            System.out.println("tag: " + tag);
            Vector row = new Vector();
            row.add(tag.getTagId());
            model.addRow(row);
        }
    }

    public void tableModelProduct(DefaultTableModel model) {
        productBUS = new ProductBUS();
        for (ProductDTO product : productBUS.getList()) {
            Vector row = new Vector();
            row.add(product.getProductId());
            row.add(product.getProductName());
            row.add(product.getProductQuantity());
            row.add(product.getProductDetail());
            model.addRow(row);
        }
    }

    public void removeRowTag() {
        for (int i = 0; i < tbModelTag.getRowCount(); i++) {
            if (idTag.equals(tbModelTag.getValueAt(i, 0))) {
                System.out.println("remove");
                tbModelTag.removeRow(i);
                break;
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTag = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProduct = new javax.swing.JTable();
        jBtnAdd = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("GÁN TAG CHO SẢN PHẨM");
        jLabel1.setToolTipText("");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 243, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("DANH SÁCH TAG");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 163, 40));

        Vector tableCol=new Vector();
        tableCol.add("Tag ID");

        tbModelTag = new DefaultTableModel (tableCol,0){
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex){
                return false;
            }
        };
        jTableTag.setModel (tbModelTag);
        jTableTag.setShowGrid(true);
        jTableTag.setFocusable(false);
        //        jTableTag.setIntercellSpacing(new Dimension(0,0));
        jTableTag.setRowHeight(25);
        //        jTableTag.setRowMargin(10);
        jTableTag.getTableHeader().setOpaque(false);
        jTableTag.setFillsViewportHeight(true);
        jTableTag.getTableHeader().setBackground(new Color(220,220,220));
        jTableTag.getTableHeader().setForeground(new Color(30,30,30));
        jTableTag.getTableHeader().setFont (new Font("Dialog", Font.BOLD, 13));
        jTableTag.setSelectionBackground(new Color(0,120,215));
        jTableTag.setSelectionForeground(new Color(255,255,255));
        jTableTag.setForeground(new Color(30,30,30));
        jTableTag.setAutoCreateRowSorter(true);
        jTableTag.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableTag.setGridColor(new java.awt.Color(83, 86, 88));
        jTableTag.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTagMouseClicked(evt);
            }
        });
        jTableTag.getColumn (tableCol.elementAt (0)).setPreferredWidth (230);
        jTableTag.setAutoResizeMode (javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(jTableTag);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 250, 290));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("DANH SÁCH SẢN PHẨM");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 163, 40));

        Vector tableColProduct = new Vector();
        tableColProduct.add("Product ID");
        tableColProduct.add("Product Name");
        tableColProduct.add("Quantity");
        tableColProduct.add("Detail");

        tbModelProduct = new DefaultTableModel (tableColProduct,0){
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex){
                return false;
            }
        };
        jTableProduct.setModel (tbModelProduct);
        jTableProduct.setShowGrid(true);
        jTableProduct.setFocusable(false);
        //        jTableProduct.setIntercellSpacing(new Dimension(0,0));
        jTableProduct.setRowHeight(25);
        //        jTableProduct.setRowMargin(20);
        jTableProduct.getTableHeader().setOpaque(false);
        jTableProduct.setFillsViewportHeight(true);
        jTableProduct.getTableHeader().setBackground(new Color(220,220,220));
        jTableProduct.getTableHeader().setForeground(new Color(30, 30, 30));
        jTableProduct.getTableHeader().setFont (new Font("Dialog", Font.BOLD, 13));
        jTableProduct.setSelectionBackground(new Color(0,120,215));
        jTableProduct.setSelectionForeground(new Color(255,255,255));
        jTableProduct.setForeground(new Color(30,30,30));
        jTableProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableProduct.setGridColor(new java.awt.Color(83, 86, 88));
        jTableProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProductMouseClicked(evt);
            }
        });
        jTableProduct.getColumn (tableColProduct.elementAt (0)).setPreferredWidth (100);
        jTableProduct.getColumn (tableColProduct.elementAt (1)).setPreferredWidth (200);
        jTableProduct.getColumn (tableColProduct.elementAt (2)).setPreferredWidth (100);
        jTableProduct.getColumn (tableColProduct.elementAt (3)).setPreferredWidth (300);
        jTableProduct.setAutoResizeMode (javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane2.setViewportView(jTableProduct);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 500, 290));

        jBtnAdd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jBtnAdd.setText("THÊM");
        jBtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAddActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 430, 150, 42));

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 80, 31));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, 799, 799, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableTagMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTagMouseClicked
        // TODO add your handling code here:
        int row = jTableTag.getSelectedRow();
        System.out.println("row: " + row);
        if (row == rowTag) {
            jTableTag.clearSelection();
            selectedTag = false;
            idTag = "";
            jBtnAdd.setEnabled(false);
            rowTag = -2;
            return;
        }
        if (row != -1) {
            selectedTag = true;
            rowTag = row;
            idTag = (String) jTableTag.getValueAt(rowTag, 0);
            System.out.println("id: " + idTag);
            System.out.println("click table: " + jTableTag.getValueAt(rowTag, 0));
            System.out.println("tbmodel: " + tbModelTag.getValueAt(rowTag, 0));
        }
        if (selectedTag && selectedProduct && idTag != "" && idProduct != "") {
            jBtnAdd.setEnabled(true);
        }
    }//GEN-LAST:event_jTableTagMouseClicked

    private void jTableProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProductMouseClicked
        // TODO add your handling code here:
        int row = jTableProduct.getSelectedRow();
        System.out.println("row: " + row);
        if (row == rowProduct) {
            jTableProduct.clearSelection();
            selectedProduct = false;
            idProduct = "";
            jBtnAdd.setEnabled(false);
            rowProduct = -2;
            return;
        }
        if (row != -1) {
            selectedProduct = true;
            rowProduct = row;
            idProduct = (String) jTableProduct.getValueAt(rowProduct, 0);
            System.out.println("click: " + jTableProduct.getValueAt(rowProduct, 0)); //ch?nh
        }
        if (selectedTag && selectedProduct && idTag != "" && idProduct != "") {
            jBtnAdd.setEnabled(true);
        }
    }//GEN-LAST:event_jTableProductMouseClicked

    private void jBtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAddActionPerformed
        // TODO add your handling code here:
        TagDTO tagDTO = new TagDTO(idTag, idProduct, "", null, "", null, "");
        for (TagDTO t : tagDTOs) {
            if (t.getTagId().equals(idTag)) {
                tagDTO.setTagGateIn(t.getTagGateIn());
                tagDTO.setTagDateIn(t.getTagDateIn());
                break;
            }
        }
        System.out.println("tagDTO: " + tagDTO);
        if (tagBUS.insertTag(tagDTO)) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setProductId((String) tbModelProduct.getValueAt(rowProduct, 0));
            productDTO.setProductQuantity((Integer) tbModelProduct.getValueAt(rowProduct, 2) + 1);
            if (productBUS.updateProduct(productDTO)) {
                jTableProduct.setValueAt((Integer) tbModelProduct.getValueAt(rowProduct, 2) + 1, rowProduct, 2);
                removeRowTag();
                JOptionPane.showMessageDialog(this, "Gán tag cho sản phẩm thành công!");
                jTableTag.clearSelection();
                jTableProduct.clearSelection();
                rowProduct = -2;
                rowTag = -2;
                selectedTag = false;
                selectedProduct = false;
                jBtnAdd.setEnabled(false);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Gán tag cho sản phẩm thất bại!");
        }
    }//GEN-LAST:event_jBtnAddActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        // TODO add your handling code here:

        initTagAuto();
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
            java.util.logging.Logger.getLogger(NhapDlForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhapDlForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhapDlForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhapDlForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NhapDlForm().setVisible(true);
            }
        });
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAdd;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableProduct;
    private javax.swing.JTable jTableTag;
    // End of variables declaration//GEN-END:variables
}
