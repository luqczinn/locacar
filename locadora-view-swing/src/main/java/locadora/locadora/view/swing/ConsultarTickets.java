/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package locadora.locadora.view.swing;

import java.awt.Toolkit;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import locadora.locadora.negocio.dao.ReservasDAO;
import locadora.locadora.negocio.dao.TicketDAO;
import locadora.locadora.negocio.dao.UnidadesDAO;
import locadora.locadora.negocio.dao.UsuarioDAO;
import locadora.locadora.negocio.dto.Reservas;
import locadora.locadora.negocio.dto.Ticket;
import locadora.locadora.negocio.dto.Unidades;
import locadora.locadora.negocio.excessoes.negocioException;
import locadora.locadora.negocio.excessoes.persistenciaException;
import locadora.locadora.negocio.servico.ServicoTicket;

/**
 *
 * @author gugup
 */
public class ConsultarTickets extends javax.swing.JFrame {

    static String usuario;
    static int verStatus = 0;
    static TableColumnModel colmod;
    /**
     * Creates new form ConsultarReservas
     */
    public ConsultarTickets(String usuario) throws SQLException {
        this.usuario = usuario;
        initComponents();
        this.setLocation(((Toolkit.getDefaultToolkit().getScreenSize().width / 2) - (this.getWidth() / 2)),
                ((Toolkit.getDefaultToolkit().getScreenSize().height / 2) - (this.getHeight() / 2))); 
        TableColumnModel colmod = tlb_tickets.getColumnModel();
        TableColumn x = colmod.getColumn(1);
        x.setPreferredWidth(300);
        LoadTableContent();
        
    }
    

    static public void LoadTableContent() throws SQLException {
        Object Colunas[] = {"ID", "Assunto", "Data", "Usuário", "Status"};
        DefaultTableModel modelo = new DefaultTableModel(Colunas, 0);
        List<Ticket> listaTickets = TicketDAO.listarTicketsBD();
        if(listaTickets != null){
            for (int i = 0; i < TicketDAO.listarTicketsBD().size(); i++) {
                if(listaTickets.get(i).getFuncionarioResposta() == null){
                    modelo.addRow(new Object[]{listaTickets.get(i).getId(), listaTickets.get(i).getAssunto(), listaTickets.get(i).getDataCriada(),listaTickets.get(i).getUsuarioPedido(), "Aberto"});
                }else{
                    if(verStatus == 1){
                        modelo.addRow(new Object[]{listaTickets.get(i).getId(), listaTickets.get(i).getAssunto(), listaTickets.get(i).getDataCriada(),listaTickets.get(i).getUsuarioPedido(), "Respondido"});
                    }
                }
            }

            tlb_tickets.setModel(modelo);
            TableColumnModel colmod = tlb_tickets.getColumnModel();
            TableColumn x1 = colmod.getColumn(0);
            x1.setPreferredWidth(25);
            TableColumn x2 = colmod.getColumn(1);
            x2.setPreferredWidth(330);
            TableColumn x3 = colmod.getColumn(2);
            x3.setPreferredWidth(110);
        }else{
            while (modelo.getRowCount()>0)
          {
             modelo.removeRow(0);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tlb_tickets = new javax.swing.JTable();
        btn_cancelar = new javax.swing.JButton();
        btn_responder = new javax.swing.JButton();
        btn_excluir = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tickets"));

        tlb_tickets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        tlb_tickets.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tlb_ticketsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tlb_tickets);

        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        btn_responder.setText("Acessar");
        btn_responder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_responderActionPerformed(evt);
            }
        });

        btn_excluir.setText("Excluir");
        btn_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluirActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Visualizar Tickets Respondidos");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_responder)
                        .addGap(95, 95, 95)
                        .addComponent(btn_excluir)
                        .addGap(87, 87, 87)
                        .addComponent(btn_cancelar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancelar)
                    .addComponent(btn_excluir)
                    .addComponent(btn_responder)
                    .addComponent(jCheckBox1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        this.dispose();

    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_responderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_responderActionPerformed
   
            int x =  (int) tlb_tickets.getValueAt(tlb_tickets.getSelectedRow(), 0);
            Controle.abrirResponderTicket(usuario, x);
              
    }//GEN-LAST:event_btn_responderActionPerformed

    private void btn_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluirActionPerformed
      
                int x =  (int) tlb_tickets.getValueAt(tlb_tickets.getSelectedRow(), 0);
                try {
                    ServicoTicket.removerTicket(x, usuario);
                    LoadTableContent();
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(ConsultarTickets.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(ConsultarTickets.class.getName()).log(Level.SEVERE, null, ex);
                }
        
    }//GEN-LAST:event_btn_excluirActionPerformed

    private void tlb_ticketsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tlb_ticketsMouseClicked

    }//GEN-LAST:event_tlb_ticketsMouseClicked

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        try {
            if(verStatus == 0){
                verStatus = 1;
            }else{
                verStatus = 0;
            }
            LoadTableContent();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarTickets.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged
    public static String b;

    public void setVariavelB(String x) {
        b = x;
    }

    public static String getVariavelB() {
        return b;
    }
    public static int a;

    public void setVariavelA(int x) {
        a = x;
    }

    public static int getVariavelA() {
        return a;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_excluir;
    private javax.swing.JButton btn_responder;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable tlb_tickets;
    // End of variables declaration//GEN-END:variables
}
