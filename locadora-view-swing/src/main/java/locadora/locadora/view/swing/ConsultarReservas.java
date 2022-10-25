/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package locadora.locadora.view.swing;

import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import locadora.locadora.negocio.dao.ReservasDAO;
import locadora.locadora.negocio.dto.Reservas;
import locadora.locadora.negocio.excessoes.persistenciaException;

/**
 *
 * @author gugup
 */
public class ConsultarReservas extends javax.swing.JDialog {

    public String modo;

    /**
     * Creates new form ConsultarReservas
     */
    public ConsultarReservas(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();
        this.setLocation(((Toolkit.getDefaultToolkit().getScreenSize().width / 2) - (this.getWidth() / 2)),
                ((Toolkit.getDefaultToolkit().getScreenSize().height / 2) - (this.getHeight() / 2)));   
        modo = "Navegar";
        LoadTableContent();
    }

    public void LoadTableContent() throws SQLException {
        Object Colunas[] = {"Código", "Cliente", "Vendedor", "Veiculo", "Unidade", "Telefone", "Coleta", "Entrega", "Valor diário", "Valor total"};
        DefaultTableModel modelo = new DefaultTableModel(Colunas, 0);

        for (int i = 0; i < ReservasDAO.listarReservasBD().size(); i++) {
            modelo.addRow(new Object[]{ReservasDAO.listarReservasBD().get(i).getCodigo(), ReservasDAO.listarReservasBD().get(i).getCliente(), ReservasDAO.listarReservasBD().get(i).getVendedor(), ReservasDAO.listarReservasBD().get(i).getVeiculo(), ReservasDAO.listarReservasBD().get(i).getUnidade(), ReservasDAO.listarReservasBD().get(i).getInicio(), ReservasDAO.listarReservasBD().get(i).getFim(), ReservasDAO.listarReservasBD().get(i).getValorDiaria(), ReservasDAO.listarReservasBD().get(i).getValorReserva()});
        }

        tlb_reservas.setModel(modelo);

    }

    public void onOff() throws SQLException {
        switch (modo) {

            case "Navegar" -> {
                btn_nova_reserva.setEnabled(true);
                btn_editar_reserva.setEnabled(false);
                btn_excluir_reserva.setEnabled(false);
                setVariavelB(modo);
            }
            case "Novo" -> {

                btn_nova_reserva.setEnabled(false);
                btn_editar_reserva.setEnabled(false);
                btn_excluir_reserva.setEnabled(false);
                setVariavelB(modo);

                LoadTableContent();
            }

            case "Editar" -> {

                btn_nova_reserva.setEnabled(true);
                btn_editar_reserva.setEnabled(false);
                btn_excluir_reserva.setEnabled(false);
                setVariavelB(modo);

                LoadTableContent();
            }

            case "Excluir" -> {

                btn_nova_reserva.setEnabled(true);
                btn_editar_reserva.setEnabled(false);
                btn_excluir_reserva.setEnabled(false);
                setVariavelB(modo);

                LoadTableContent();
            }
            case "Selecao" -> {

                btn_nova_reserva.setEnabled(true);
                btn_editar_reserva.setEnabled(true);
                btn_excluir_reserva.setEnabled(true);
                setVariavelB(modo);
            }
            default ->
                System.out.println("Inválido");
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
        tlb_reservas = new javax.swing.JTable();
        btn_excluir_reserva = new javax.swing.JButton();
        btn_nova_reserva = new javax.swing.JButton();
        btn_editar_reserva = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Reservas"));

        tlb_reservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tlb_reservas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tlb_reservasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tlb_reservas);

        btn_excluir_reserva.setText("Excluir");
        btn_excluir_reserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluir_reservaActionPerformed(evt);
            }
        });

        btn_nova_reserva.setText("Nova");
        btn_nova_reserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nova_reservaActionPerformed(evt);
            }
        });

        btn_editar_reserva.setText("Editar");
        btn_editar_reserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editar_reservaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_editar_reserva)
                .addGap(227, 227, 227)
                .addComponent(btn_excluir_reserva)
                .addGap(48, 48, 48))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addComponent(btn_nova_reserva)
                    .addContainerGap(609, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_excluir_reserva)
                    .addComponent(btn_editar_reserva))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(340, Short.MAX_VALUE)
                    .addComponent(btn_nova_reserva)
                    .addContainerGap()))
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

    private void btn_excluir_reservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluir_reservaActionPerformed
        int x = tlb_reservas.getSelectedRow();
        Reservas R = null;
        try {
            R = ReservasDAO.listarReservasBD().get(x);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Erro no Banco de Dados", JOptionPane.ERROR_MESSAGE);
        }
        try {
            ReservasDAO.removerReservaBD(R.getCodigo());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Erro no Banco de Dados", JOptionPane.ERROR_MESSAGE);
        }

        try {
            LoadTableContent();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Erro no Banco de Dados", JOptionPane.ERROR_MESSAGE);
        }
        modo = "Navegar";

        try {
            onOff();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Erro no Banco de Dados", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_excluir_reservaActionPerformed

    private void btn_nova_reservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nova_reservaActionPerformed
        modo = "Novo";
        Controle.abrirCadastroVeiculos();
        setVariavelB(modo);
    }//GEN-LAST:event_btn_nova_reservaActionPerformed

    private void btn_editar_reservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editar_reservaActionPerformed
        int x = tlb_reservas.getSelectedRow();

        modo = "Editar";
        try {
            onOff();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Erro no Banco de Dados", JOptionPane.ERROR_MESSAGE);
        }
        setVariavelA(x);
        Controle.abrirCadastroReservas();
    }//GEN-LAST:event_btn_editar_reservaActionPerformed

    private void tlb_reservasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tlb_reservasMouseClicked
        int x = tlb_reservas.getSelectedRow();
        try {
            Reservas R = ReservasDAO.listarReservasBD().get(x);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Erro no Banco de Dados", JOptionPane.ERROR_MESSAGE);
        }
        setVariavelA(x);
        modo = "Selecao";
        try {
            onOff();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Erro no Banco de Dados", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tlb_reservasMouseClicked
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
    private javax.swing.JButton btn_editar_reserva;
    private javax.swing.JButton btn_excluir_reserva;
    private javax.swing.JButton btn_nova_reserva;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tlb_reservas;
    // End of variables declaration//GEN-END:variables
}
