/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BUS.BaoCaoBUS;
import com.toedter.calendar.JDateChooser;
import BUS.OrderBUS;
import BUS.OrderDetailBUS;
import BUS.ProductBUS;
import BUS.TagBUS;
import BUS.Utils;
import BUS.XuatExcel;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class BaoCaoForm1 extends javax.swing.JFrame
{

    DefaultTableModel tbModelOrder, tbModelDetail;
//    Set<String> tags;
    ProductBUS productBUS = new ProductBUS();
    OrderBUS orderBUS = new OrderBUS();
    OrderDetailBUS orderDetailBUS = new OrderDetailBUS();
    BaoCaoBUS baoCaoBUS = new BaoCaoBUS();
    XuatExcel xuatExcel = new XuatExcel();
    int rowOrder = -2, rowDetail = -2;
    String orderId = "";
    ArrayList<OrderDTO> orders, ordersFind = new ArrayList<>();
    ArrayList<OrderDetailDTO> details;
    ArrayList<ProductDTO> products;

    /**
     * Creates new form BaoCaoForm
     */
    public BaoCaoForm1()
    {
        initComponents();
        this.setVisible(false);
        jTableOrder.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTableDetail.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void tableModelOrder(DefaultTableModel model, ArrayList<OrderDTO> orderDTOs)
    {
        for (OrderDTO order : orderDTOs)
        {
            Vector row = new Vector();
            row.add(order.getOrderId());
            row.add(order.getOrderDate());
            if (order.getStatus() == 2)
            {
                row.add("Đang Chờ....");
            } else if (order.getStatus() == 3)
            {
                row.add("Hoàn thành");
            }
            model.addRow(row);
        }
    }

    public void initTableOrder()
    {
//        orderDetailBUS = new OrderDetailBUS();
        jDateFrom.setCalendar(null);
        jDateTo.setCalendar(null);
        tbModelOrder.setRowCount(0);
        tbModelDetail.setRowCount(0);

        orders = orderBUS.getList();
        details = orderDetailBUS.getList();
//        productBUS = new ProductBUS();
        products = productBUS.getList();
//        tableModelOrder(tbModelOrder, orders);
        jTableOrder.setRowSorter(null);
        jTableOrder.setAutoCreateRowSorter(true);
        jTableOrder.setModel(tbModelOrder);
    }

    public void tableModelDetail(DefaultTableModel model)
    {
        Vector row;
        for (OrderDetailDTO detail : details)
        {
            if (detail.getOrderId().equals(orderId))
            {
                row = new Vector();
                if (tbModelOrder.getValueAt(rowOrder, 2).equals("Hoàn thành"))
                {
                    row.add("OK");
                } else
                {
                    row.add("");
                }
                row.add(detail.getOrderDetailId());
                row.add(detail.getProductId());
                for (ProductDTO product : products)
                {
                    if (product.getProductId().equals(detail.getProductId()))
                    {
                        row.add(product.getProductName());
                    }
                }
                row.add(detail.getOrderQuantity());
                model.addRow(row);
//                details.add(new OrderDetailDTO(detail.getOrderDetailId(), orderId, detail.getProductId(), detail.getOrderQuantity()));
            }
        }
    }

    public void initTableDetail()
    {
        tbModelDetail.setRowCount(0);
        tableModelDetail(tbModelDetail);
        jTableDetail.setModel(tbModelDetail);
    }

    public void timKiemByDate(Date from, Date to)
    {
        if (ordersFind != null)
        {
            ordersFind.clear();
        }
        tbModelOrder.setRowCount(0);
        Date orderDate = null;
        for (OrderDTO order : orders)
        {
            try
            {
                orderDate = new SimpleDateFormat("yyyy-MM-dd").parse(order.getOrderDate());
            } catch (Exception e)
            {
                System.out.println("e: " + e);
                JOptionPane.showMessageDialog(this, e);
                return;
            }
            if (orderDate.after(from) && orderDate.before(to) || orderDate.equals(from) || orderDate.equals(to))
            {
                ordersFind.add(order);
            }
        }
        if (ordersFind != null)
        {
            tableModelOrder(tbModelOrder, ordersFind);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jBtnXuat = new javax.swing.JButton();
        jBtnTimKiem = new javax.swing.JButton();
        jBtnRefresh = new javax.swing.JButton();
        jDateTo = new com.toedter.calendar.JDateChooser();
        jDateFrom = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableOrder = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableDetail = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(990, 650));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("XUẤT BÁO CÁO");
        jLabel1.setToolTipText("");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 290, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("DANH SÁCH ĐƠN");
        jLabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 163, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("CHI TIẾT ĐƠN");
        jLabel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 163, 40));

        jBtnXuat.setBackground(new java.awt.Color(255, 255, 255));
        jBtnXuat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jBtnXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_microsoft_excel_32.png"))); // NOI18N
        jBtnXuat.setBorder(null);
        jBtnXuat.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBtnXuatActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnXuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 150, -1, -1));

        jBtnTimKiem.setBackground(new java.awt.Color(255, 255, 255));
        jBtnTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jBtnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search_25px.png"))); // NOI18N
        jBtnTimKiem.setBorder(null);
        jBtnTimKiem.setPreferredSize(new java.awt.Dimension(38, 38));
        jBtnTimKiem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBtnTimKiemActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, -1, -1));

        jBtnRefresh.setBackground(new java.awt.Color(255, 255, 255));
        jBtnRefresh.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jBtnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_refresh_32.png"))); // NOI18N
        jBtnRefresh.setBorder(null);
        jBtnRefresh.setPreferredSize(new java.awt.Dimension(38, 38));
        jBtnRefresh.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBtnRefreshActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, -1, -1));

        jDateTo.setBackground(new java.awt.Color(214, 217, 223));
        jDateTo.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(jDateTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 160, 40));

        jDateFrom.setBackground(new java.awt.Color(214, 217, 223));
        jDateFrom.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(jDateFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 160, 40));

        Vector tableCol = new Vector();
        tableCol.add("ID Đơn");
        tableCol.add("Ngày tạo");
        tableCol.add("Trạng Thái");

        tbModelOrder = new DefaultTableModel (tableCol,0)
        {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
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
        jTableOrder.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jTableOrderMouseClicked(evt);
            }
        });
        jTableOrder.getColumn (tableCol.elementAt (0)).setPreferredWidth (150);
        jTableOrder.getColumn (tableCol.elementAt (1)).setPreferredWidth (150);
        jTableOrder.getColumn (tableCol.elementAt (2)).setPreferredWidth (150);
        jTableOrder.setAutoResizeMode (javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(jTableOrder);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 440, 440));

        Vector tableColDetail = new Vector();
        tableColDetail.add("Trạng Thái");
        tableColDetail.add("ID CT Đơn");
        tableColDetail.add("ID Sản Phẩm");
        tableColDetail.add("Tên Sản Phẩm");
        tableColDetail.add("Số Lượng");

        tbModelDetail = new DefaultTableModel (tableColDetail,0)
        {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
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
        jTableDetail.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jTableDetailMouseClicked(evt);
            }
        });
        jTableDetail.getColumn (tableColDetail.elementAt (0)).setPreferredWidth (110);
        jTableDetail.getColumn (tableColDetail.elementAt (1)).setPreferredWidth (110);
        jTableDetail.getColumn (tableColDetail.elementAt (2)).setPreferredWidth (110);
        jTableDetail.getColumn (tableColDetail.elementAt (3)).setPreferredWidth (150);
        jTableDetail.getColumn (tableColDetail.elementAt (4)).setPreferredWidth (110);
        jTableDetail.setAutoResizeMode (javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane2.setViewportView(jTableDetail);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, 460, 440));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("TỪ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 30, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("ĐẾN");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 40, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnXuatActionPerformed
        // TODO add your handling code here:
        if (jTableOrder.getRowCount() < 1)
        {
            JOptionPane.showMessageDialog(this, "Không có dữ liệu để xuất!");
            return;
        }
        xuatExcel.xuatFileExcelDonHang(baoCaoBUS.initBaoCao(ordersFind));
//        JOptionPane.showMessageDialog(this, "Xuất báo cáo!");
    }//GEN-LAST:event_jBtnXuatActionPerformed

    private void jBtnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnTimKiemActionPerformed
        // TODO add your handling code here:
        String dateFrom = ((JTextField) jDateFrom.getDateEditor().getUiComponent()).getText(),
                dateTo = ((JTextField) jDateTo.getDateEditor().getUiComponent()).getText();
        if (dateFrom.equals("") || dateTo.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Ngày \"đến\" / ngày \"từ\" không được bỏ trống!");
            return;
        }
        try
        {
            Date dateF = new SimpleDateFormat("yyyy-MM-dd").parse(dateFrom),
                    dateT = new SimpleDateFormat("yyyy-MM-dd").parse(dateTo);
            if (dateF.after(dateT))
            {
                JOptionPane.showMessageDialog(this, "Ngày \"đến\" không được ở sau ngày \"từ\"!");
                return;
            }
            timKiemByDate(dateF, dateT);
        } catch (Exception e)
        {
            System.out.println("e: " + e);
            JOptionPane.showMessageDialog(this, e);
            return;
        }
    }//GEN-LAST:event_jBtnTimKiemActionPerformed

    private void jBtnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRefreshActionPerformed
        // TODO add your handling code here:
        initTableOrder();
        jDateFrom.setCalendar(null);
        jDateTo.setCalendar(null);
        tbModelDetail.setRowCount(0);
    }//GEN-LAST:event_jBtnRefreshActionPerformed

    private void jTableOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableOrderMouseClicked
        // TODO add your handling code here:
        int row = jTableOrder.getSelectedRow();
        if (row == rowOrder)
        {
            jTableOrder.clearSelection();
            rowOrder = -2;
            orderId = "";
            tbModelDetail.setRowCount(0);
            return;
        }
        if (row != -1)
        {
            rowOrder = row;
            orderId = (String) jTableOrder.getValueAt(row, 0);
            initTableDetail();
        }
    }//GEN-LAST:event_jTableOrderMouseClicked

    private void jTableDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDetailMouseClicked
        // TODO add your handling code here:
        int row = jTableDetail.getSelectedRow();
        if (row == rowDetail)
        {
            jTableDetail.clearSelection();
            rowDetail = -2;
            return;
        }
        if (row != -1)
        {
            rowDetail = row;
        }
    }//GEN-LAST:event_jTableDetailMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(BaoCaoForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(BaoCaoForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(BaoCaoForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(BaoCaoForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new BaoCaoForm1().setVisible(true);
            }
        });
    }

    public JPanel getjPanel1()
    {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1)
    {
        this.jPanel1 = jPanel1;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnRefresh;
    private javax.swing.JButton jBtnTimKiem;
    private javax.swing.JButton jBtnXuat;
    private com.toedter.calendar.JDateChooser jDateFrom;
    private com.toedter.calendar.JDateChooser jDateTo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableDetail;
    private javax.swing.JTable jTableOrder;
    // End of variables declaration//GEN-END:variables
}
