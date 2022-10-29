/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package locadora.locadora.view.swing;

import java.awt.Toolkit;
import java.sql.SQLException;
import locadora.locadora.negocio.dao.ReservasDAO;
import locadora.locadora.negocio.dto.Reservas;

/**
 *
 * @author gugup
 */
public class CadastroFuncionarios extends javax.swing.JDialog {

    /**
     * Creates new form CadastroReservas
     */
    public CadastroFuncionarios(java.awt.Frame parent, boolean modal) throws SQLException {       
        super(parent, modal);
        initComponents();
        this.setLocation(((Toolkit.getDefaultToolkit().getScreenSize().width / 2) - (this.getWidth() / 2)),
                ((Toolkit.getDefaultToolkit().getScreenSize().height / 2) - (this.getHeight() / 2)));     

        String modo = ConsultarReservas.getVariavelB();
        int x = ConsultarReservas.getVariavelA();
        
        if (ConsultarReservas.getVariavelB().equals("Editar")) {
            Reservas R = ReservasDAO.listarReservasBD().get(x);
            textCodigoReserva.setText(Integer.toString(R.getCodigo()));
            txt_DataColeta_reservas.setText(R.getInicio());
            txt_DataEntrega_reservas.setText(R.getFim());
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

        jLabel8 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        codigoReservaLabel1 = new javax.swing.JLabel();
        codigoReservaLabel = new javax.swing.JLabel();
        textCodigoReserva = new javax.swing.JTextField();
        codigoReservaLabel6 = new javax.swing.JLabel();
        textCodigoReserva1 = new javax.swing.JTextField();
        textCodigoReserva2 = new javax.swing.JTextField();
        codigoReservaLabel9 = new javax.swing.JLabel();
        textCodigoReserva5 = new javax.swing.JTextField();
        codigoReservaLabel10 = new javax.swing.JLabel();
        textCodigoReserva6 = new javax.swing.JTextField();
        codigoReservaLabel11 = new javax.swing.JLabel();
        textCodigoReserva7 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        codigoReservaLabel5 = new javax.swing.JLabel();
        codigoReservaLabel3 = new javax.swing.JLabel();
        codigoReservaLabel7 = new javax.swing.JLabel();
        codigoReservaLabel8 = new javax.swing.JLabel();
        txt_DataColeta_reservas = new javax.swing.JTextField();
        txt_DataEntrega_reservas = new javax.swing.JTextField();
        txt_DataColeta_reservas1 = new javax.swing.JTextField();
        txt_DataEntrega_reservas1 = new javax.swing.JTextField();
        codigoReservaLabel12 = new javax.swing.JLabel();
        textCodigoReserva8 = new javax.swing.JTextField();
        codigoReservaLabel13 = new javax.swing.JLabel();
        textCodigoReserva9 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton9 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        jLabel8.setFont(new java.awt.Font("Amiri", 1, 14)); // NOI18N
        jLabel8.setText("Número de Referência:");

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton8.setText("Cadastrar");

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton7.setText("Salvar");

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setText("Cancelar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Reserva"));
        jPanel1.setToolTipText("");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados da reserva"));

        codigoReservaLabel1.setFont(new java.awt.Font("Amiri", 1, 14)); // NOI18N
        codigoReservaLabel1.setText("Nome:");

        codigoReservaLabel.setFont(new java.awt.Font("Amiri", 1, 14)); // NOI18N
        codigoReservaLabel.setText("RG:");

        textCodigoReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCodigoReservaActionPerformed(evt);
            }
        });

        codigoReservaLabel6.setFont(new java.awt.Font("Amiri", 1, 14)); // NOI18N
        codigoReservaLabel6.setText("Sobrenome:");

        textCodigoReserva1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCodigoReserva1ActionPerformed(evt);
            }
        });

        textCodigoReserva2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCodigoReserva2ActionPerformed(evt);
            }
        });

        codigoReservaLabel9.setFont(new java.awt.Font("Amiri", 1, 14)); // NOI18N
        codigoReservaLabel9.setText("CPF:");

        textCodigoReserva5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCodigoReserva5ActionPerformed(evt);
            }
        });

        codigoReservaLabel10.setFont(new java.awt.Font("Amiri", 1, 14)); // NOI18N
        codigoReservaLabel10.setText("E-mail:");

        textCodigoReserva6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCodigoReserva6ActionPerformed(evt);
            }
        });

        codigoReservaLabel11.setFont(new java.awt.Font("Amiri", 1, 14)); // NOI18N
        codigoReservaLabel11.setText("Telefone:");

        textCodigoReserva7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCodigoReserva7ActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Valores"));

        codigoReservaLabel5.setFont(new java.awt.Font("Amiri", 1, 14)); // NOI18N
        codigoReservaLabel5.setText("Salário:");

        codigoReservaLabel3.setFont(new java.awt.Font("Amiri", 1, 14)); // NOI18N
        codigoReservaLabel3.setText("PIX:");

        codigoReservaLabel7.setFont(new java.awt.Font("Amiri", 1, 14)); // NOI18N
        codigoReservaLabel7.setText("Conta bancária:");

        codigoReservaLabel8.setFont(new java.awt.Font("Amiri", 1, 14)); // NOI18N
        codigoReservaLabel8.setText("Cargo:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(codigoReservaLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(codigoReservaLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_DataColeta_reservas1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_DataColeta_reservas, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(codigoReservaLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(codigoReservaLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_DataEntrega_reservas, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_DataEntrega_reservas1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoReservaLabel5)
                    .addComponent(txt_DataColeta_reservas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigoReservaLabel3)
                    .addComponent(txt_DataEntrega_reservas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoReservaLabel7)
                    .addComponent(codigoReservaLabel8)
                    .addComponent(txt_DataColeta_reservas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_DataEntrega_reservas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        codigoReservaLabel12.setFont(new java.awt.Font("Amiri", 1, 14)); // NOI18N
        codigoReservaLabel12.setText("Username:");

        textCodigoReserva8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCodigoReserva8ActionPerformed(evt);
            }
        });

        codigoReservaLabel13.setFont(new java.awt.Font("Amiri", 1, 14)); // NOI18N
        codigoReservaLabel13.setText("Senha:");

        textCodigoReserva9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCodigoReserva9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(codigoReservaLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigoReservaLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigoReservaLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigoReservaLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textCodigoReserva1, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                    .addComponent(textCodigoReserva2)
                    .addComponent(textCodigoReserva6)
                    .addComponent(textCodigoReserva8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(codigoReservaLabel6)
                    .addComponent(codigoReservaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigoReservaLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigoReservaLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textCodigoReserva5, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(textCodigoReserva)
                    .addComponent(textCodigoReserva7)
                    .addComponent(textCodigoReserva9))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoReservaLabel1)
                    .addComponent(textCodigoReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigoReservaLabel6)
                    .addComponent(textCodigoReserva1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoReservaLabel)
                    .addComponent(textCodigoReserva2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textCodigoReserva5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigoReservaLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoReservaLabel10)
                    .addComponent(textCodigoReserva6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigoReservaLabel11)
                    .addComponent(textCodigoReserva7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoReservaLabel12)
                    .addComponent(textCodigoReserva8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigoReservaLabel13)
                    .addComponent(textCodigoReserva9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel17.setText("CADASTRAR FUNCIONÁRIO");

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton9.setText("Cadastrar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton6.setText("Cancelar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(207, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addGap(247, 247, 247))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton9)
                .addGap(302, 302, 302))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        jPanel2.getAccessibleContext().setAccessibleName("Dados do funcionário");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jPanel1.getAccessibleContext().setAccessibleName("Funcionário");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void textCodigoReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCodigoReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCodigoReservaActionPerformed

    private void textCodigoReserva1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCodigoReserva1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCodigoReserva1ActionPerformed

    private void textCodigoReserva2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCodigoReserva2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCodigoReserva2ActionPerformed

    private void textCodigoReserva5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCodigoReserva5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCodigoReserva5ActionPerformed

    private void textCodigoReserva6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCodigoReserva6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCodigoReserva6ActionPerformed

    private void textCodigoReserva7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCodigoReserva7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCodigoReserva7ActionPerformed

    private void textCodigoReserva8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCodigoReserva8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCodigoReserva8ActionPerformed

    private void textCodigoReserva9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCodigoReserva9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCodigoReserva9ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel codigoReservaLabel;
    private javax.swing.JLabel codigoReservaLabel1;
    private javax.swing.JLabel codigoReservaLabel10;
    private javax.swing.JLabel codigoReservaLabel11;
    private javax.swing.JLabel codigoReservaLabel12;
    private javax.swing.JLabel codigoReservaLabel13;
    private javax.swing.JLabel codigoReservaLabel3;
    private javax.swing.JLabel codigoReservaLabel5;
    private javax.swing.JLabel codigoReservaLabel6;
    private javax.swing.JLabel codigoReservaLabel7;
    private javax.swing.JLabel codigoReservaLabel8;
    private javax.swing.JLabel codigoReservaLabel9;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField textCodigoReserva;
    private javax.swing.JTextField textCodigoReserva1;
    private javax.swing.JTextField textCodigoReserva2;
    private javax.swing.JTextField textCodigoReserva5;
    private javax.swing.JTextField textCodigoReserva6;
    private javax.swing.JTextField textCodigoReserva7;
    private javax.swing.JTextField textCodigoReserva8;
    private javax.swing.JTextField textCodigoReserva9;
    private javax.swing.JTextField txt_DataColeta_reservas;
    private javax.swing.JTextField txt_DataColeta_reservas1;
    private javax.swing.JTextField txt_DataEntrega_reservas;
    private javax.swing.JTextField txt_DataEntrega_reservas1;
    // End of variables declaration//GEN-END:variables
}
