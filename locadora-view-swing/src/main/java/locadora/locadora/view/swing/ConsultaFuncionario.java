/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package locadora.locadora.view.swing;

import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import locadora.locadora.negocio.dao.ReservasDAO;
import locadora.locadora.negocio.dao.UsuarioDAO;
import locadora.locadora.negocio.dto.Reservas;
import locadora.locadora.negocio.dto.Usuario;
import locadora.locadora.negocio.excessoes.negocioException;
import locadora.locadora.negocio.excessoes.persistenciaException;
import locadora.locadora.negocio.servico.ServicoUsuarios;

/**
 *
 * @author gugup
 */
public class ConsultaFuncionario extends javax.swing.JFrame {

    public String modo;
    public String cargo;
    public Usuario usuario;

    /**
     * Creates new form ConsultarReservas
     */
    public ConsultaFuncionario(java.awt.Frame parent, boolean modal, Usuario userH) throws SQLException, negocioException {

        //super(parent, modal);
        usuario = userH;
        cargo = usuario.getCargo();
        initComponents();
        this.setLocation(((Toolkit.getDefaultToolkit().getScreenSize().width / 2) - (this.getWidth() / 2)),
                ((Toolkit.getDefaultToolkit().getScreenSize().height / 2) - (this.getHeight() / 2)));
        modo = "Navegar";
        LoadTableContent();
    }

    public void LoadTableContent() throws SQLException, negocioException {

        Object Colunas[] = {"Nome", "CPF", "RG", "E-Mail", "Cargo", "Endereco", "Telefone", "Unidade", "CNIS", "Username", "Senha"};
        DefaultTableModel modelo = new DefaultTableModel(Colunas, 0);
        List<Usuario> listaUsuarios = ServicoUsuarios.listarUsuarios();
        List<Usuario> listaUser = new ArrayList<>();
        for (int j = 0; j < listaUsuarios.size(); j++) {
            if (listaUsuarios.get(j).getCargo().equals("Vendedor")) {
                listaUser.add(listaUsuarios.get(j));
            }
        }
        if (cargo.equals("Gerente")) {
            if (listaUser != null) {
                for (int i = 0; i < listaUser.size(); i++) {
                    modelo.addRow(new Object[]{listaUser.get(i).getNome(), listaUser.get(i).getCpf(), listaUser.get(i).getRg(), listaUser.get(i).getEmail(), listaUser.get(i).getCargo(),
                        listaUser.get(i).getEndereco(), listaUser.get(i).getTelefone(), listaUser.get(i).getUnidade(), listaUser.get(i).getCnis(), listaUser.get(i).getUsername(), listaUser.get(i).getSenha(),});
                }
            }
        }

        if (cargo.equals("Diretor")) {
            listaUser = listaUsuarios;
            for (int i = 0; i < listaUser.size(); i++) {
                modelo.addRow(new Object[]{listaUser.get(i).getNome(), listaUser.get(i).getCpf(), listaUser.get(i).getRg(), listaUser.get(i).getEmail(), listaUser.get(i).getCargo(),
                    listaUser.get(i).getEndereco(), listaUser.get(i).getTelefone(), listaUser.get(i).getUnidade(), listaUser.get(i).getCnis(), listaUser.get(i).getUsername(), listaUser.get(i).getSenha(),});
            }
        }
        tlb_funcionarios.setModel(modelo);

    }

    public void onOff() throws SQLException, negocioException {
        switch (modo) {

            case "Navegar" -> {
                btn_nova_funcionario.setEnabled(true);
                btn_editar_funcionario.setEnabled(false);
                btn_excluir_funcionario.setEnabled(false);
                setVariavelB(modo);
            }
            case "Novo" -> {

                btn_nova_funcionario.setEnabled(false);
                btn_editar_funcionario.setEnabled(false);
                btn_excluir_funcionario.setEnabled(false);
                setVariavelB(modo);

                LoadTableContent();
            }

            case "Editar" -> {

                btn_nova_funcionario.setEnabled(true);
                btn_editar_funcionario.setEnabled(false);
                btn_excluir_funcionario.setEnabled(false);
                setVariavelB(modo);

                LoadTableContent();
            }

            case "Excluir" -> {

                btn_nova_funcionario.setEnabled(true);
                btn_editar_funcionario.setEnabled(false);
                btn_excluir_funcionario.setEnabled(false);
                setVariavelB(modo);

                LoadTableContent();
            }
            case "Selecao" -> {

                btn_nova_funcionario.setEnabled(true);
                btn_editar_funcionario.setEnabled(true);
                btn_excluir_funcionario.setEnabled(true);
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
        tlb_funcionarios = new javax.swing.JTable();
        btn_excluir_funcionario = new javax.swing.JButton();
        btn_nova_funcionario = new javax.swing.JButton();
        btn_editar_funcionario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Funcionários");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Funcionarios"));

        tlb_funcionarios.setModel(new javax.swing.table.DefaultTableModel(
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
        tlb_funcionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tlb_funcionariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tlb_funcionarios);

        btn_excluir_funcionario.setText("Excluir");
        btn_excluir_funcionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluir_funcionarioActionPerformed(evt);
            }
        });

        btn_nova_funcionario.setText("Nova");
        btn_nova_funcionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nova_funcionarioActionPerformed(evt);
            }
        });

        btn_editar_funcionario.setText("Editar");
        btn_editar_funcionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editar_funcionarioActionPerformed(evt);
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
                .addComponent(btn_editar_funcionario)
                .addGap(227, 227, 227)
                .addComponent(btn_excluir_funcionario)
                .addGap(48, 48, 48))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addComponent(btn_nova_funcionario)
                    .addContainerGap(609, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_excluir_funcionario)
                    .addComponent(btn_editar_funcionario))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(340, Short.MAX_VALUE)
                    .addComponent(btn_nova_funcionario)
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

    private void btn_excluir_funcionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluir_funcionarioActionPerformed
        int x = tlb_funcionarios.getSelectedRow();
        Usuario U = null;
        try {
            U = ServicoUsuarios.listarUsuarios().get(x);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Erro no Banco de Dados", JOptionPane.ERROR_MESSAGE);
        } catch (negocioException ex) {
            Logger.getLogger(ConsultaFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            UsuarioDAO.removerFuncionario(U.getUsername());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Erro no Banco de Dados", JOptionPane.ERROR_MESSAGE);
        } catch (negocioException ex) {
            Logger.getLogger(ConsultaFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            LoadTableContent();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Erro no Banco de Dados", JOptionPane.ERROR_MESSAGE);
        } catch (negocioException ex) {
            Logger.getLogger(ConsultaFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        modo = "Navegar";

        try {
            onOff();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Erro no Banco de Dados", JOptionPane.ERROR_MESSAGE);
        } catch (negocioException ex) {
            Logger.getLogger(ConsultaFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_excluir_funcionarioActionPerformed

    private void btn_nova_funcionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nova_funcionarioActionPerformed
        modo = "Novo";
        Controle.abrirCadastroFuncionario(usuario);
        setVariavelB(modo);
    }//GEN-LAST:event_btn_nova_funcionarioActionPerformed

    private void btn_editar_funcionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editar_funcionarioActionPerformed
        int x = tlb_funcionarios.getSelectedRow();

        modo = "Editar";
        try {
            onOff();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Erro no Banco de Dados", JOptionPane.ERROR_MESSAGE);
        } catch (negocioException ex) {
            Logger.getLogger(ConsultaFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        setVariavelA(x);
        Controle.abrirCadastroFuncionario(usuario);
    }//GEN-LAST:event_btn_editar_funcionarioActionPerformed

    private void tlb_funcionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tlb_funcionariosMouseClicked
        int x = tlb_funcionarios.getSelectedRow();
        setVariavelA(x);
        modo = "Selecao";
        try {
            onOff();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (negocioException ex) {
            Logger.getLogger(ConsultaFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_tlb_funcionariosMouseClicked
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
    private javax.swing.JButton btn_editar_funcionario;
    private javax.swing.JButton btn_excluir_funcionario;
    private javax.swing.JButton btn_nova_funcionario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tlb_funcionarios;
    // End of variables declaration//GEN-END:variables
}
