/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DTO.UserDTO;
import java.awt.Dimension;
import java.awt.Toolkit;
import com.example.sdksamples.MainRead;
import com.example.sdksamples.ReadTags;
import java.util.HashMap;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Dashboard extends javax.swing.JFrame {

    private UserForm userForm;
    private NhapDlForm inputTag;
    private TaoDonForm createOrder;
    private DanhSachXuatForm listOrder;
    private BaoCaoForm baoCaoForm;
    public static UserDTO userLogin = new UserDTO();

    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        userForm = new UserForm();
        inputTag = new NhapDlForm();
        createOrder = new TaoDonForm();
        listOrder = new DanhSachXuatForm();
        baoCaoForm = new BaoCaoForm();
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        this.setVisible(true);
        jPanelMenu.setVisible(true);
        jPanelUser.setVisible(false);
        jPanelInput.setVisible(false);
        jPanelCreateOrder.setVisible(false);
        jPanelOrder.setVisible(false);
        jPanelBaoCao.setVisible(false);
        jBtnUserBack.setVisible(false);
        jBtnInputBack.setVisible(false);
        jBtnCreateOrderBack.setVisible(false);
        jBtnOrderBack.setVisible(false);
        jBtnBaoCaoBack.setVisible(false);
    }

    public void falseFunc1() {

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
        jPanelMenu = new javax.swing.JPanel();
        jBtnInput = new javax.swing.JButton();
        jBtnCreateOrder = new javax.swing.JButton();
        jBtnOrder = new javax.swing.JButton();
        jBtnBaoCao = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jBtnLogout = new javax.swing.JButton();
        jLabelHello = new javax.swing.JLabel();
        jBtnUser = new javax.swing.JButton();
        jPanelCreateOrder = new javax.swing.JPanel();
        jCreateOrder = new javax.swing.JPanel();
        jBtnCreateOrderBack = new javax.swing.JButton();
        jPanelInput = new javax.swing.JPanel();
        jInput = new javax.swing.JPanel();
        jBtnInputBack = new javax.swing.JButton();
        jPanelOrder = new javax.swing.JPanel();
        jOrder = new javax.swing.JPanel();
        jBtnOrderBack = new javax.swing.JButton();
        jPanelBaoCao = new javax.swing.JPanel();
        jBaoCao = new javax.swing.JPanel();
        jBtnBaoCaoBack = new javax.swing.JButton();
        jPanelUser = new javax.swing.JPanel();
        jUser = new javax.swing.JPanel();
        jBtnUserBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBtnInput.setText("GÁN TAG");
        jBtnInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnInputActionPerformed(evt);
            }
        });
        jPanelMenu.add(jBtnInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 400, 240));

        jBtnCreateOrder.setText("TẠO ĐƠN XUẤT");
        jBtnCreateOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCreateOrderActionPerformed(evt);
            }
        });
        jPanelMenu.add(jBtnCreateOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 400, 240));

        jBtnOrder.setText("ĐƠN XUẤT");
        jBtnOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnOrderActionPerformed(evt);
            }
        });
        jPanelMenu.add(jBtnOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 400, 240));

        jBtnBaoCao.setText("BÁO CÁO");
        jBtnBaoCao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBaoCaoActionPerformed(evt);
            }
        });
        jPanelMenu.add(jBtnBaoCao, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, 400, 240));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBtnLogout.setText("Logout");
        jBtnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLogoutActionPerformed(evt);
            }
        });
        jPanel2.add(jBtnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, 80, 40));

        jLabelHello.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelHello.setText("Xin chào, Admin");
        jPanel2.add(jLabelHello, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 200, 40));

        jBtnUser.setText("Người dùng");
        jBtnUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnUserActionPerformed(evt);
            }
        });
        jPanel2.add(jBtnUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, 110, 40));

        jPanelMenu.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 40));

        jPanel1.add(jPanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 520));

        jPanelCreateOrder.setBackground(new java.awt.Color(245, 245, 245));

        javax.swing.GroupLayout jCreateOrderLayout = new javax.swing.GroupLayout(jCreateOrder);
        jCreateOrder.setLayout(jCreateOrderLayout);
        jCreateOrderLayout.setHorizontalGroup(
            jCreateOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        jCreateOrderLayout.setVerticalGroup(
            jCreateOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        jBtnCreateOrderBack.setText("Back");
        jBtnCreateOrderBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCreateOrderBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCreateOrderLayout = new javax.swing.GroupLayout(jPanelCreateOrder);
        jPanelCreateOrder.setLayout(jPanelCreateOrderLayout);
        jPanelCreateOrderLayout.setHorizontalGroup(
            jPanelCreateOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCreateOrderLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanelCreateOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnCreateOrderBack)
                    .addComponent(jCreateOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanelCreateOrderLayout.setVerticalGroup(
            jPanelCreateOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCreateOrderLayout.createSequentialGroup()
                .addComponent(jBtnCreateOrderBack, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCreateOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        //jPanel3.setVisible(false);
        jCreateOrder.add(createOrder.getjPanel1());

        jPanel1.add(jPanelCreateOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        jPanelCreateOrder.setVisible(false);

        jPanelInput.setBackground(new java.awt.Color(245, 245, 245));

        javax.swing.GroupLayout jInputLayout = new javax.swing.GroupLayout(jInput);
        jInput.setLayout(jInputLayout);
        jInputLayout.setHorizontalGroup(
            jInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        jInputLayout.setVerticalGroup(
            jInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        jBtnInputBack.setText("Back");
        jBtnInputBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnInputBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelInputLayout = new javax.swing.GroupLayout(jPanelInput);
        jPanelInput.setLayout(jPanelInputLayout);
        jPanelInputLayout.setHorizontalGroup(
            jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInputLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnInputBack)
                    .addComponent(jInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanelInputLayout.setVerticalGroup(
            jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInputLayout.createSequentialGroup()
                .addComponent(jBtnInputBack, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        //jPanelInput.setVisible(false);
        jInput.add(inputTag.getjPanel1());

        jPanel1.add(jPanelInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 520));
        jPanelInput.setVisible(false);

        jPanelOrder.setBackground(new java.awt.Color(245, 245, 245));

        javax.swing.GroupLayout jOrderLayout = new javax.swing.GroupLayout(jOrder);
        jOrder.setLayout(jOrderLayout);
        jOrderLayout.setHorizontalGroup(
            jOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        jOrderLayout.setVerticalGroup(
            jOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        jBtnOrderBack.setText("Back");
        jBtnOrderBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnOrderBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelOrderLayout = new javax.swing.GroupLayout(jPanelOrder);
        jPanelOrder.setLayout(jPanelOrderLayout);
        jPanelOrderLayout.setHorizontalGroup(
            jPanelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelOrderLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnOrderBack)
                    .addComponent(jOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanelOrderLayout.setVerticalGroup(
            jPanelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelOrderLayout.createSequentialGroup()
                .addComponent(jBtnOrderBack, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        //jPanelInput.setVisible(false);
        jOrder.add(listOrder.getjPanel1());
        jOrder.setVisible(true);

        jPanel1.add(jPanelOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 520));
        jPanelInput.setVisible(false);

        jPanelBaoCao.setBackground(new java.awt.Color(245, 245, 245));

        javax.swing.GroupLayout jBaoCaoLayout = new javax.swing.GroupLayout(jBaoCao);
        jBaoCao.setLayout(jBaoCaoLayout);
        jBaoCaoLayout.setHorizontalGroup(
            jBaoCaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        jBaoCaoLayout.setVerticalGroup(
            jBaoCaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        jBtnBaoCaoBack.setText("Back");
        jBtnBaoCaoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBaoCaoBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBaoCaoLayout = new javax.swing.GroupLayout(jPanelBaoCao);
        jPanelBaoCao.setLayout(jPanelBaoCaoLayout);
        jPanelBaoCaoLayout.setHorizontalGroup(
            jPanelBaoCaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBaoCaoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanelBaoCaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnBaoCaoBack)
                    .addComponent(jBaoCao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanelBaoCaoLayout.setVerticalGroup(
            jPanelBaoCaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBaoCaoLayout.createSequentialGroup()
                .addComponent(jBtnBaoCaoBack, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBaoCao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        //jPanelInput.setVisible(false);
        jBaoCao.add(baoCaoForm.getjPanel1());
        jBaoCao.setVisible(true);

        jPanel1.add(jPanelBaoCao, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 520));
        jPanelInput.setVisible(false);

        jPanelUser.setBackground(new java.awt.Color(245, 245, 245));

        javax.swing.GroupLayout jUserLayout = new javax.swing.GroupLayout(jUser);
        jUser.setLayout(jUserLayout);
        jUserLayout.setHorizontalGroup(
            jUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        jUserLayout.setVerticalGroup(
            jUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        jBtnUserBack.setText("Back");
        jBtnUserBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnUserBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelUserLayout = new javax.swing.GroupLayout(jPanelUser);
        jPanelUser.setLayout(jPanelUserLayout);
        jPanelUserLayout.setHorizontalGroup(
            jPanelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUserLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnUserBack)
                    .addComponent(jUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanelUserLayout.setVerticalGroup(
            jPanelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUserLayout.createSequentialGroup()
                .addComponent(jBtnUserBack, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        //jPanelInput.setVisible(false);
        jUser.add(userForm.getjPanel1());
        jUser.setVisible(true);

        jPanel1.add(jPanelUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 520));
        jPanelInput.setVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, 799, 799, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnInputActionPerformed
        // TODO add your handling code here:
        jPanelMenu.setVisible(false);
        jPanelUser.setVisible(false);
        jPanelInput.setVisible(true);
        jPanelCreateOrder.setVisible(false);
        jPanelOrder.setVisible(false);
        jPanelBaoCao.setVisible(false);
        jBtnUserBack.setVisible(false);
        jBtnInputBack.setVisible(true);
        jBtnCreateOrderBack.setVisible(false);
        jBtnOrderBack.setVisible(false);
        jBtnBaoCaoBack.setVisible(false);
        inputTag.initTableProduct();
        MainRead.flag = 1;
        MainRead.tagMap.clear();
    }//GEN-LAST:event_jBtnInputActionPerformed

    private void jBtnCreateOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCreateOrderActionPerformed
        // TODO add your handling code here:
        jPanelMenu.setVisible(false);
        jPanelUser.setVisible(false);
        jPanelInput.setVisible(false);
        jPanelCreateOrder.setVisible(true);
        jPanelOrder.setVisible(false);
        jPanelBaoCao.setVisible(false);
        jBtnUserBack.setVisible(false);
        jBtnInputBack.setVisible(false);
        jBtnCreateOrderBack.setVisible(true);
        jBtnOrderBack.setVisible(false);
        jBtnBaoCaoBack.setVisible(false);
        createOrder.initTable();
    }//GEN-LAST:event_jBtnCreateOrderActionPerformed

    private void jBtnInputBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnInputBackActionPerformed
        // TODO add your handling code here:
        jPanelMenu.setVisible(true);
        jPanelUser.setVisible(false);
        jPanelInput.setVisible(false);
        jPanelCreateOrder.setVisible(false);
        jPanelOrder.setVisible(false);
        jPanelBaoCao.setVisible(false);
        jBtnUserBack.setVisible(false);
        jBtnInputBack.setVisible(false);
        jBtnCreateOrderBack.setVisible(false);
        jBtnOrderBack.setVisible(false);
        jBtnBaoCaoBack.setVisible(false);
        inputTag.tagDTOs.clear();
        MainRead.flag = 0;
        MainRead.tagMap.clear();
    }//GEN-LAST:event_jBtnInputBackActionPerformed

    private void jBtnCreateOrderBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCreateOrderBackActionPerformed
        // TODO add your handling code here:
        jPanelMenu.setVisible(true);
        jPanelUser.setVisible(false);
        jPanelInput.setVisible(false);
        jPanelCreateOrder.setVisible(false);
        jPanelOrder.setVisible(false);
        jPanelBaoCao.setVisible(false);
        jBtnUserBack.setVisible(false);
        jBtnInputBack.setVisible(false);
        jBtnCreateOrderBack.setVisible(false);
        jBtnOrderBack.setVisible(false);
        jBtnBaoCaoBack.setVisible(false);
    }//GEN-LAST:event_jBtnCreateOrderBackActionPerformed

    private void jBtnOrderBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnOrderBackActionPerformed
        // TODO add your handling code here:
        jPanelMenu.setVisible(true);
        jPanelUser.setVisible(false);
        jPanelInput.setVisible(false);
        jPanelCreateOrder.setVisible(false);
        jPanelOrder.setVisible(false);
        jPanelBaoCao.setVisible(false);
        jBtnUserBack.setVisible(false);
        jBtnInputBack.setVisible(false);
        jBtnCreateOrderBack.setVisible(false);
        jBtnOrderBack.setVisible(false);
        jBtnBaoCaoBack.setVisible(false);
        MainRead.flag = 0;
        MainRead.tagMap.clear();
    }//GEN-LAST:event_jBtnOrderBackActionPerformed

    private void jBtnOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnOrderActionPerformed
        // TODO add your handling code here:
        jPanelMenu.setVisible(false);
        jPanelUser.setVisible(false);
        jPanelInput.setVisible(false);
        jPanelCreateOrder.setVisible(false);
        jPanelOrder.setVisible(true);
        jPanelBaoCao.setVisible(false);
        jBtnUserBack.setVisible(false);
        jBtnInputBack.setVisible(false);
        jBtnCreateOrderBack.setVisible(false);
        jBtnOrderBack.setVisible(true);
        jBtnBaoCaoBack.setVisible(false);
        listOrder.initTableOrder();
    }//GEN-LAST:event_jBtnOrderActionPerformed

    private void jBtnBaoCaoBackActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnBaoCaoBackActionPerformed
    {//GEN-HEADEREND:event_jBtnBaoCaoBackActionPerformed
        // TODO add your handling code here:
        jPanelMenu.setVisible(true);
        jPanelUser.setVisible(false);
        jPanelInput.setVisible(false);
        jPanelCreateOrder.setVisible(false);
        jPanelOrder.setVisible(false);
        jPanelBaoCao.setVisible(false);
        jBtnUserBack.setVisible(false);
        jBtnInputBack.setVisible(false);
        jBtnCreateOrderBack.setVisible(false);
        jBtnOrderBack.setVisible(false);
        jBtnBaoCaoBack.setVisible(false);
    }//GEN-LAST:event_jBtnBaoCaoBackActionPerformed

    private void jBtnBaoCaoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnBaoCaoActionPerformed
    {//GEN-HEADEREND:event_jBtnBaoCaoActionPerformed
        // TODO add your handling code here:
        jPanelMenu.setVisible(false);
        jPanelUser.setVisible(false);
        jPanelInput.setVisible(false);
        jPanelCreateOrder.setVisible(false);
        jPanelOrder.setVisible(false);
        jPanelBaoCao.setVisible(true);
        jBtnUserBack.setVisible(false);
        jBtnInputBack.setVisible(false);
        jBtnCreateOrderBack.setVisible(false);
        jBtnOrderBack.setVisible(false);
        jBtnBaoCaoBack.setVisible(true);
        baoCaoForm.initTableOrder();
    }//GEN-LAST:event_jBtnBaoCaoActionPerformed

    private void jBtnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLogoutActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn muốn đăng xuất?",
                "Xác nhận", JOptionPane.OK_CANCEL_OPTION);
        if (confirm == JOptionPane.OK_OPTION) {
            this.setVisible(false);
            ReadTags.visibleLogin();
//            dispose(); ////  Exit Program
//            LoginForm lg = new LoginForm();
//            lg.setVisible(true);
        }

    }//GEN-LAST:event_jBtnLogoutActionPerformed

    private void jBtnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnUserActionPerformed
        // TODO add your handling code here:
        jPanelMenu.setVisible(false);
        jPanelUser.setVisible(true);
        jPanelInput.setVisible(false);
        jPanelCreateOrder.setVisible(false);
        jPanelOrder.setVisible(false);
        jPanelBaoCao.setVisible(false);
        jBtnUserBack.setVisible(true);
        jBtnInputBack.setVisible(false);
        jBtnCreateOrderBack.setVisible(false);
        jBtnOrderBack.setVisible(false);
        jBtnBaoCaoBack.setVisible(false);
        userForm.initTableUser();
    }//GEN-LAST:event_jBtnUserActionPerformed

    private void jBtnUserBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnUserBackActionPerformed
        // TODO add your handling code here:
        jPanelMenu.setVisible(true);
        jPanelInput.setVisible(false);
        jPanelCreateOrder.setVisible(false);
        jPanelOrder.setVisible(false);
        jPanelBaoCao.setVisible(false);
        jBtnUserBack.setVisible(false);
        jBtnInputBack.setVisible(false);
        jBtnCreateOrderBack.setVisible(false);
        jBtnOrderBack.setVisible(false);
        jBtnBaoCaoBack.setVisible(false);
    }//GEN-LAST:event_jBtnUserBackActionPerformed

    public void setHello () {
        jLabelHello.setText("Xin chào, " + userLogin.getFullName());
    }
    
    public NhapDlForm getInputTag() {
        return inputTag;
    }

    public void setInputTag(NhapDlForm inputTag) {
        this.inputTag = inputTag;
    }

    public DanhSachXuatForm getListOrder() {
        return listOrder;
    }

    public void setListOrder(DanhSachXuatForm listOrder) {
        this.listOrder = listOrder;
    }

    public JLabel getjLabelHello() {
        return jLabelHello;
    }

    public void setjLabelHello(JLabel jLabelHello) {
        this.jLabelHello = jLabelHello;
    }

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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jBaoCao;
    private javax.swing.JButton jBtnBaoCao;
    private javax.swing.JButton jBtnBaoCaoBack;
    private javax.swing.JButton jBtnCreateOrder;
    private javax.swing.JButton jBtnCreateOrderBack;
    private javax.swing.JButton jBtnInput;
    private javax.swing.JButton jBtnInputBack;
    private javax.swing.JButton jBtnLogout;
    private javax.swing.JButton jBtnOrder;
    private javax.swing.JButton jBtnOrderBack;
    private javax.swing.JButton jBtnUser;
    private javax.swing.JButton jBtnUserBack;
    private javax.swing.JPanel jCreateOrder;
    private javax.swing.JPanel jInput;
    private javax.swing.JLabel jLabelHello;
    private javax.swing.JPanel jOrder;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelBaoCao;
    private javax.swing.JPanel jPanelCreateOrder;
    private javax.swing.JPanel jPanelInput;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel jPanelOrder;
    private javax.swing.JPanel jPanelUser;
    private javax.swing.JPanel jUser;
    // End of variables declaration//GEN-END:variables
}
