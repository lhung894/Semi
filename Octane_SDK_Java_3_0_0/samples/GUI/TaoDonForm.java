/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BUS.OrderBUS;
import BUS.OrderDetailBUS;
import BUS.ProductBUS;
import BUS.TagBUS;
import BUS.Utils;
import DTO.OrderDTO;
import DTO.OrderDetailDTO;
import DTO.ProductDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class TaoDonForm extends javax.swing.JFrame {

    DefaultTableModel tbModelOrder, tbModelProduct;
//    Set<String> tags;
    ProductBUS productBUS;
    TagBUS tagBUS = new TagBUS();
    OrderBUS orderBUS = new OrderBUS();
    OrderDetailBUS orderDetailBUS = new OrderDetailBUS();
    Utils ult = new Utils();
    int rowOrder = -2, rowProduct = -2;

    /**
     * Creates new form TaoDonForm
     */
    public TaoDonForm() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        this.setVisible(false);
        initTable();
        clear();
    }

    public void clear() {
        jBtnToOrder.setEnabled(false);
        jBtnCreate.setEnabled(false);
        jBtnDel.setEnabled(false);
        jTableOrder.clearSelection();
        jTableProduct.clearSelection();
        jTxtQuantity.setEditable(false);
        jTxtQuantity.setText("");
        jTxtQuantity.setBackground(new Color(200, 200, 200));
        rowProduct = -2;
        rowOrder = -2;
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

    public void initTable() {
        tbModelProduct.setRowCount(0);
        tableModelProduct(tbModelProduct);
        jTableProduct.setRowSorter(null);
        jTableProduct.setAutoCreateRowSorter(true);
        jTableProduct.setModel(tbModelProduct);
        jTableProduct.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        jTableOrder = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProduct = new javax.swing.JTable();
        jBtnCreate = new javax.swing.JButton();
        jBtnDel = new javax.swing.JButton();
        jBtnToOrder = new javax.swing.JButton();
        jTxtQuantity = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TẠO ĐƠN XUẤT");
        jLabel1.setToolTipText("");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 13, 243, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("ĐƠN HÀNG XUẤT");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, 163, 40));

        Vector tableCol = new Vector();
        tableCol.add("Product ID");
        tableCol.add("Quantity");

        tbModelOrder = new DefaultTableModel (tableCol,0){
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex){
                return false;
            }
        };
        jTableOrder.setModel (tbModelOrder);
        jTableOrder.setShowGrid(true);
        jTableOrder.setFocusable(false);
        jTableOrder.setIntercellSpacing(new Dimension(0,0));
        jTableOrder.setRowHeight(25);
        jTableOrder.getTableHeader().setOpaque(false);
        jTableOrder.setFillsViewportHeight(true);
        //        jTableOrder.getTableHeader().setBackground(new Color(145,209,242));
        //        jTableOrder.getTableHeader().setForeground(new Color(51, 51, 51));
        jTableOrder.getTableHeader().setFont (new Font("Dialog", Font.BOLD, 13));
        //        jTableOrder.setSelectionBackground(new Color(76,121,255));
        jTableOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableOrder.setGridColor(new java.awt.Color(83, 86, 88));
        jTableOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableOrderMouseClicked(evt);
            }
        });
        jTableOrder.getColumn (tableCol.elementAt (0)).setPreferredWidth (100);
        jTableOrder.getColumn (tableCol.elementAt (1)).setPreferredWidth (100);
        jTableOrder.setAutoResizeMode (javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(jTableOrder);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, 210, 290));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("DANH SÁCH SẢN PHẨM");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 163, 40));

        Vector tableColProduct = new Vector();
        tableColProduct.add("Product ID");
        tableColProduct.add("Product Name");
        tableColProduct.add("Remaining");
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
        jTableProduct.setIntercellSpacing(new Dimension(0,0));
        jTableProduct.setRowHeight(25);
        jTableProduct.getTableHeader().setOpaque(false);
        jTableProduct.setFillsViewportHeight(true);
        //        jTableOrder.getTableHeader().setBackground(new Color(145,209,242));
        //        jTableOrder.getTableHeader().setForeground(new Color(51, 51, 51));
        jTableProduct.getTableHeader().setFont (new Font("Dialog", Font.BOLD, 13));
        //        jTableOrder.setSelectionBackground(new Color(76,121,255));
        jTableProduct.setAutoCreateRowSorter(true);
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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 540, 290));

        jBtnCreate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jBtnCreate.setText("TẠO ĐƠN");
        jBtnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCreateActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(577, 434, 90, -1));

        jBtnDel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jBtnDel.setText("XÓA");
        jBtnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDelActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnDel, new org.netbeans.lib.awtextra.AbsoluteConstraints(697, 434, 90, -1));

        jBtnToOrder.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jBtnToOrder.setText("THÊM VÀO ĐƠN");
        jBtnToOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnToOrderActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnToOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 434, -1, -1));
        jPanel1.add(jTxtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 435, 100, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Số lượng");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 438, 60, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, 799, 799, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, 483, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableOrderMouseClicked
        // TODO add your handling code here:
        int row = jTableOrder.getSelectedRow();
//        System.out.println("row: " + row);
        if (row == rowOrder) {
            jTableOrder.clearSelection();
            jBtnDel.setEnabled(false);
            rowOrder = -2;
            return;
        }
        if (row != -1) {
            rowOrder = row;
            jBtnDel.setEnabled(true);
//            System.out.println("click: " + jTableOrder.getValueAt(rowOrder, 0));
        }
    }//GEN-LAST:event_jTableOrderMouseClicked

    private void jTableProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProductMouseClicked
        // TODO add your handling code here:
        int row = jTableProduct.getSelectedRow();
//        System.out.println("row: " + row);
        if (row == rowProduct) {
            jTableProduct.clearSelection();
            jBtnToOrder.setEnabled(false);
            rowProduct = -2;
            jTxtQuantity.setEditable(false);
            jTxtQuantity.setText("");
            jTxtQuantity.setBackground(new Color(200, 200, 200));
            return;
        }
        if (row != -1) {
            rowProduct = row;
            jBtnToOrder.setEnabled(true);
            jTxtQuantity.setEditable(true);
            jTxtQuantity.setText("1");
            jTxtQuantity.setBackground(new Color(255, 255, 255));
        }
    }//GEN-LAST:event_jTableProductMouseClicked

    private void jBtnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCreateActionPerformed
        // TODO add your handling code here:
        OrderDTO order = new OrderDTO();
        order.setOrderId(ult.initOrderId());
        order.setOrderDate(ult.initDateNow());
        order.setStatus(2);
//        System.out.println("date: " + order.getOrderDate());
//        System.out.println("Order: " + order);
        if (orderBUS.insertOrder(order)) {
            ArrayList<OrderDetailDTO> orDetails = new ArrayList<>();
            OrderDetailDTO orDetail;
            ArrayList<ProductDTO> products = new ArrayList<>();
            ProductDTO product;
            for (int i = 0; i < tbModelOrder.getRowCount(); i++) {
                orDetail = new OrderDetailDTO();
                orDetail.setOrderId(order.getOrderId());
                orDetail.setProductId((String) tbModelOrder.getValueAt(i, 0));
                orDetail.setOrderQuantity(Integer.parseInt(String.valueOf(tbModelOrder.getValueAt(i, 1))));
                orDetails.add(orDetail);
                for (int j = 0; j < tbModelProduct.getRowCount(); j++) {
                    if (tbModelOrder.getValueAt(i, 0).equals(tbModelProduct.getValueAt(j, 0))) {
                        product = new ProductDTO();
                        product.setProductId((String) tbModelProduct.getValueAt(j, 0));
                        product.setProductQuantity(Integer.parseInt(String.valueOf(tbModelProduct.getValueAt(j, 2))));
                        products.add(product);
                    }
                }
            }
            if (orderDetailBUS.insertOrderDetail(orDetails) && productBUS.updateProducts(products)) {
                JOptionPane.showMessageDialog(this, "Tạo đơn xuất thành công!");
                tbModelOrder.setRowCount(0);
                clear();
                return;
            }
            System.out.println("Order: " + order);
            System.out.println("OrderDetail: " + orDetails);
        }
        JOptionPane.showMessageDialog(this, "Tạo đơn thất bại!");
    }//GEN-LAST:event_jBtnCreateActionPerformed

    private void jBtnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDelActionPerformed
        // TODO add your handling code here:
        for (int i = 0; i < tbModelProduct.getRowCount(); i++) {
            if (tbModelOrder.getValueAt(rowOrder, 0).equals(tbModelProduct.getValueAt(i, 0))) {
                tbModelProduct.setValueAt(Integer.parseInt(String.valueOf(tbModelProduct.getValueAt(i, 2)))
                        + Integer.parseInt(String.valueOf(tbModelOrder.getValueAt(rowOrder, 1))), i, 2);
//                jBtnCreate.setEnabled(true);
                tbModelOrder.removeRow(rowOrder);
                jTableOrder.clearSelection();
                rowOrder = -2;
                jBtnDel.setEnabled(false);
                if (tbModelOrder.getRowCount() == 0) {
                    jBtnCreate.setEnabled(false);
                }
                return;
            }
        }
    }//GEN-LAST:event_jBtnDelActionPerformed

    private void jBtnToOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnToOrderActionPerformed
        // TODO add your handling code here:
        if (jTxtQuantity.getText().equals("") || jTxtQuantity.getText().equals(null)) {
            JOptionPane.showMessageDialog(this, "Hãy nhập vào số lượng!");
        } else {
            try {
                int quantity = Integer.parseInt(jTxtQuantity.getText());
                if (quantity < 1) {
                    JOptionPane.showMessageDialog(this, "Hãy nhập số lượng lớn hơn 0!");
                    return;
                }
                if (quantity > (Integer) tbModelProduct.getValueAt(rowProduct, 2)) {
                    JOptionPane.showMessageDialog(this, "Vượt quá số lượng hiện có!");
                    return;
                }
//                System.out.println("tbModelOrder.getRowCount(): " + tbModelOrder.getRowCount());
                for (int i = 0; i < tbModelOrder.getRowCount(); i++) {
                    if (tbModelProduct.getValueAt(rowProduct, 0).equals(tbModelOrder.getValueAt(i, 0))) {
                        tbModelOrder.setValueAt(Integer.parseInt(String.valueOf(tbModelOrder.getValueAt(i, 1))) + quantity, i, 1);
                        tbModelProduct.setValueAt((Integer) tbModelProduct.getValueAt(rowProduct, 2) - quantity, rowProduct, 2);
                        jBtnCreate.setEnabled(true);
                        jBtnDel.setEnabled(false);
                        return;
                    }
                }
                Vector row = new Vector();
                row.add(tbModelProduct.getValueAt(rowProduct, 0));
                row.add(jTxtQuantity.getText());
                tbModelOrder.addRow(row);
                tbModelProduct.setValueAt((Integer) tbModelProduct.getValueAt(rowProduct, 2) - quantity, rowProduct, 2);
                jBtnCreate.setEnabled(true);
                jBtnDel.setEnabled(false);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Hãy nhập kiểu số vào \"Số lượng\"!");
            }
        }
    }//GEN-LAST:event_jBtnToOrderActionPerformed

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
            java.util.logging.Logger.getLogger(TaoDonForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TaoDonForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TaoDonForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TaoDonForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TaoDonForm().setVisible(true);
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
    private javax.swing.JButton jBtnCreate;
    private javax.swing.JButton jBtnDel;
    private javax.swing.JButton jBtnToOrder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableOrder;
    private javax.swing.JTable jTableProduct;
    private javax.swing.JTextField jTxtQuantity;
    // End of variables declaration//GEN-END:variables
}