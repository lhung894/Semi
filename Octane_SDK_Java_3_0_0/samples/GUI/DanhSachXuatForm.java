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
import DTO.TagDTO;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import com.example.sdksamples.MainRead;
import java.awt.Color;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class DanhSachXuatForm extends javax.swing.JFrame {

    DefaultTableModel tbModelOrder, tbModelDetail;
//    Set<String> tags;
    ProductBUS productBUS = new ProductBUS();
    TagBUS tagBUS = new TagBUS();
    OrderBUS orderBUS = new OrderBUS();
    OrderDetailBUS orderDetailBUS = new OrderDetailBUS();
    Utils ult = new Utils();
    int rowOrder = -2, rowDetail = -2;
    boolean isScanning = false;
    String orderId = "";
    public static ArrayList<TagDTO> tagDTOs = new ArrayList<>();
    public static HashMap<String, Integer> detailScan = new HashMap<>();
    ArrayList<OrderDetailDTO> details;
    ArrayList<ProductDTO> products;
    ArrayList<TagDTO> tagDTOsUpdate = new ArrayList<>();

    /**
     * Creates new form DanhSachXuatForm
     */
    public DanhSachXuatForm() {
        initComponents();
        initTableOrder();
        this.setVisible(false);
    }

    public void tableModelOrder(DefaultTableModel model) {
        orderBUS = new OrderBUS();
        for (OrderDTO order : orderBUS.getList()) {
            Vector row = new Vector();
            row.add(order.getOrderId());
            row.add(order.getOrderDate());
            if (order.getStatus() == 2) {
                row.add("Chờ xuất");
            } else if (order.getStatus() == 3) {
                row.add("Hoàn tất");
            }
            model.addRow(row);
        }
    }

    public void initTableOrder() {
//        orderDetailBUS = new OrderDetailBUS();
        details = orderDetailBUS.getList();
//        productBUS = new ProductBUS();
        products = productBUS.getList();
        tbModelOrder.setRowCount(0);
        tableModelOrder(tbModelOrder);
        jTableOrder.setRowSorter(null);
        jTableOrder.setAutoCreateRowSorter(true);
        jTableOrder.setModel(tbModelOrder);
        jTableOrder.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jBtnQuet.setEnabled(false);
        jBtnHuy.setEnabled(false);
        jBtnXuat.setEnabled(false);
    }

    public void tableModelDetail(DefaultTableModel model) {
        Vector row;
        for (OrderDetailDTO detail : details) {
            if (detail.getOrderId().equals(orderId)) {
                row = new Vector();
                if (tbModelOrder.getValueAt(rowOrder, 2).equals("Hoàn tất")) {
                    row.add("ok");
                } else {
                    row.add("");
                }
                row.add(detail.getOrderDetailId());
                row.add(detail.getProductId());
                for (ProductDTO product : products) {
                    if (product.getProductId().equals(detail.getProductId())) {
                        row.add(product.getProductName());
                    }
                }
                row.add(detail.getOrderQuantity());
                model.addRow(row);
//                details.add(new OrderDetailDTO(detail.getOrderDetailId(), orderId, detail.getProductId(), detail.getOrderQuantity()));
            }
        }
    }

    public void initTableDetail() {
        tbModelDetail.setRowCount(0);
        tableModelDetail(tbModelDetail);
        jTableDetail.setModel(tbModelDetail);
        jTableDetail.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void checkScan(String product_id) {
//        String error = "";
        int quantity, count = 0;
        for (int i = 0; i < tbModelDetail.getRowCount(); i++) {
            if (product_id.equals(tbModelDetail.getValueAt(i, 2))) {
                count++;
            }
        }
        if (count == 0) {
            JOptionPane.showMessageDialog(this, "Sản phẩm " + product_id + " không thuộc đơn hàng!");
            jBtnXuat.setEnabled(false);
            return;
        }
        for (int i = 0; i < tbModelDetail.getRowCount(); i++) {
            if (detailScan.containsKey(tbModelDetail.getValueAt(i, 2))) {
                quantity = detailScan.get(tbModelDetail.getValueAt(i, 2));
                if (quantity == Integer.parseInt(String.valueOf(tbModelDetail.getValueAt(i, 4)))) {
                    tbModelDetail.setValueAt("ok", i, 0);
                } else if (quantity > Integer.parseInt(String.valueOf(tbModelDetail.getValueAt(i, 4)))) {
                    tbModelDetail.setValueAt("redundant", i, 0);
                }
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
        jTableOrder = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableDetail = new javax.swing.JTable();
        jBtnXuat = new javax.swing.JButton();
        jBtnQuet = new javax.swing.JButton();
        jBtnHuy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DANH SÁCH ĐƠN XUẤT");
        jLabel1.setToolTipText("");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 13, 243, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("DANH SÁCH ĐƠN");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 163, 40));

        Vector tableCol = new Vector();
        tableCol.add("Order ID");
        tableCol.add("Order Date");
        tableCol.add("Status");

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
        jTableOrder.setAutoCreateRowSorter(true);
        jTableOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableOrder.setGridColor(new java.awt.Color(83, 86, 88));
        jTableOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableOrderMouseClicked(evt);
            }
        });
        jTableOrder.getColumn (tableCol.elementAt (0)).setPreferredWidth (100);
        jTableOrder.getColumn (tableCol.elementAt (1)).setPreferredWidth (150);
        jTableOrder.getColumn (tableCol.elementAt (2)).setPreferredWidth (100);
        jTableOrder.setAutoResizeMode (javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(jTableOrder);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 360, 290));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("CHI TIẾT ĐƠN");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 163, 40));

        Vector tableColDetail = new Vector();
        tableColDetail.add("Status");
        tableColDetail.add("OrderDetail ID");
        tableColDetail.add("Product ID");
        tableColDetail.add("Product Name");
        tableColDetail.add("Quantity");

        tbModelDetail = new DefaultTableModel (tableColDetail,0){
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex){
                return false;
            }
        };
        jTableDetail.setModel (tbModelDetail);
        jTableDetail.setShowGrid(true);
        jTableDetail.setFocusable(false);
        jTableDetail.setIntercellSpacing(new Dimension(0,0));
        jTableDetail.setRowHeight(25);
        jTableDetail.getTableHeader().setOpaque(false);
        jTableDetail.setFillsViewportHeight(true);
        //        jTableOrder.getTableHeader().setBackground(new Color(145,209,242));
        //        jTableOrder.getTableHeader().setForeground(new Color(51, 51, 51));
        jTableDetail.getTableHeader().setFont (new Font("Dialog", Font.BOLD, 13));
        //        jTableOrder.setSelectionBackground(new Color(76,121,255));
        jTableDetail.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableDetail.setGridColor(new java.awt.Color(83, 86, 88));
        jTableDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDetailMouseClicked(evt);
            }
        });
        jTableDetail.getColumn (tableColDetail.elementAt (0)).setPreferredWidth (100);
        jTableDetail.getColumn (tableColDetail.elementAt (1)).setPreferredWidth (100);
        jTableDetail.getColumn (tableColDetail.elementAt (2)).setPreferredWidth (100);
        jTableDetail.getColumn (tableColDetail.elementAt (3)).setPreferredWidth (150);
        jTableDetail.getColumn (tableColDetail.elementAt (4)).setPreferredWidth (100);
        jTableDetail.setAutoResizeMode (javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane2.setViewportView(jTableDetail);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 400, 290));

        jBtnXuat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jBtnXuat.setText("THỰC HIỆN XUẤT");
        jBtnXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnXuatActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnXuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 430, -1, -1));

        jBtnQuet.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jBtnQuet.setText("QUÉT HÀNG XUẤT");
        jBtnQuet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnQuetActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnQuet, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 430, 140, -1));

        jBtnHuy.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jBtnHuy.setText("HỦY QUÉT");
        jBtnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnHuyActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnHuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 430, 120, -1));

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
        if (isScanning) {
            jTableOrder.setRowSelectionAllowed(false);
            return;
        }
        int row = jTableOrder.getSelectedRow();
        if (row == rowOrder) {
            jTableOrder.clearSelection();
            jBtnQuet.setEnabled(false);
            rowOrder = -2;
            orderId = "";
            tbModelDetail.setRowCount(0);
            return;
        }
        if (row != -1) {
            rowOrder = row;
            orderId = (String) jTableOrder.getValueAt(row, 0);
            initTableDetail();
            if (tbModelOrder.getValueAt(rowOrder, 2).equals("Hoàn tất")) {
                jBtnHuy.setEnabled(false);
                jBtnQuet.setEnabled(false);
                jBtnXuat.setEnabled(false);
                return;
            }
            jBtnQuet.setEnabled(true);
        }
    }//GEN-LAST:event_jTableOrderMouseClicked

    private void jTableDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDetailMouseClicked
        // TODO add your handling code here:
        int row = jTableDetail.getSelectedRow();
        if (row == rowDetail) {
            jTableDetail.clearSelection();
            rowDetail = -2;
            return;
        }
        if (row != -1) {
            rowDetail = row;
        }
    }//GEN-LAST:event_jTableDetailMouseClicked

    private void jBtnXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnXuatActionPerformed
        // TODO add your handling code here:
        String error = "";
        int count = 0;
        for (int i = 0; i < tbModelDetail.getRowCount(); i++) {
            if (tbModelDetail.getValueAt(i, 0).equals("ok")) {
                count++;
            } else if (tbModelDetail.getValueAt(i, 0).equals("redundant")) {
                error += "Sản phẩm " + tbModelDetail.getValueAt(i, 2) + " bị dư\n";
            } else {
                error += "Sản phẩm " + tbModelDetail.getValueAt(i, 2) + " chưa hoàn tất\n";
            }
        }
        if (!error.equals("")) {
            JOptionPane.showMessageDialog(this, error);
            return;
        }
        if (count == tbModelDetail.getRowCount()) {
            tagDTOsUpdate = new ArrayList<>();
            if (orderBUS.updateOrderCompleted(orderId)) { // cập nhật đơn
                for (TagDTO a : tagDTOs) {
                    a.setOrderId(orderId);
                }
                if (tagBUS.updateTagsOut(tagDTOs)) { // cập nhật date và gate out cho tag
                    tbModelOrder.setValueAt("Hoàn tất", rowOrder, 2);
                    JOptionPane.showMessageDialog(this, "Xuất đơn thành công!");
                    jBtnHuy.setEnabled(false);
                    jBtnQuet.setEnabled(false);
                    jBtnXuat.setEnabled(false);
                    isScanning = false;
                }
            }

        }
    }//GEN-LAST:event_jBtnXuatActionPerformed

    private void jBtnQuetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnQuetActionPerformed
        // TODO add your handling code here:
        isScanning = true;
        MainRead.flag = 2;
        MainRead.tagMap.clear();
        MainRead.tagDTOsMR = tagBUS.getList();
        detailScan.clear();
//        MainRead.thucThi();
        jBtnHuy.setEnabled(true);
        jBtnQuet.setEnabled(false);
        jBtnXuat.setEnabled(true);
    }//GEN-LAST:event_jBtnQuetActionPerformed

    private void jBtnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnHuyActionPerformed
        // TODO add your handling code here:
        tbModelDetail.setRowCount(0);
        jTableOrder.setRowSelectionAllowed(true);
        isScanning = false;
        MainRead.flag = 0;
        MainRead.tagMap.clear();
        detailScan.clear();
        tagDTOs.clear();
        jBtnHuy.setEnabled(false);
        jBtnQuet.setEnabled(true);
        jBtnXuat.setEnabled(false);
    }//GEN-LAST:event_jBtnHuyActionPerformed

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
            java.util.logging.Logger.getLogger(DanhSachXuatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DanhSachXuatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DanhSachXuatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DanhSachXuatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DanhSachXuatForm().setVisible(true);
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
    private javax.swing.JButton jBtnHuy;
    private javax.swing.JButton jBtnQuet;
    private javax.swing.JButton jBtnXuat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableDetail;
    private javax.swing.JTable jTableOrder;
    // End of variables declaration//GEN-END:variables
}
