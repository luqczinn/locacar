/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package locadora.locadora.view.swing;

import java.awt.Toolkit;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import locadora.locadora.negocio.dao.UnidadesDAO;
import locadora.locadora.negocio.dao.UsuarioDAO;
import locadora.locadora.negocio.dto.Unidades;
import locadora.locadora.negocio.dto.Usuario;
import locadora.locadora.negocio.excessoes.negocioException;
import locadora.locadora.negocio.servico.ServicoUnidades;
import locadora.locadora.negocio.servico.ServicoUsuarios;

/**
 *
 * @author gugup
 */
public class CadastroFuncionarios extends javax.swing.JFrame {

    /**
     * Creates new form CadastroReservas
     */
    String modo = "";
    List<Usuario> listaUsuarios = ServicoUsuarios.listarUsuarios();

    public CadastroFuncionarios(Usuario usuario) throws SQLException, negocioException {
        initComponents();

        this.setLocation(((Toolkit.getDefaultToolkit().getScreenSize().width / 2) - (this.getWidth() / 2)),
                ((Toolkit.getDefaultToolkit().getScreenSize().height / 2) - (this.getHeight() / 2)));

        String cargo = usuario.getCargo();

        if (cargo.equals("Gerente")) {
            getCargo.addItem("Vendedor");
        }
        if (cargo.equals("Diretor")) {
            getCargo.addItem("Vendedor");
            getCargo.addItem("Gerente");
            getCargo.addItem("Diretor");
        }

        if (ConsultaFuncionario.getVariavelB() != null) {
            modo = ConsultaFuncionario.getVariavelB();
        }
        int x = 0;
        if (ConsultaFuncionario.getVariavelA() == 0) {
            x = ConsultaFuncionario.getVariavelA();
        }
        if (modo.equals("Editar")) {
            Usuario U = listaUsuarios.get(x);
            getNome.setText(U.getNome());
            getCpf.setText(U.getCpf());
            getEmail.setText(U.getEmail());
            data_Nascimento.setText(U.getNascimento());
            getUsername.setText(U.getUsername());
            getEndereco.setText(U.getEndereco());
            getRg.setText(U.getRg());
            getTel.setText(U.getTelefone());
            unidades_list.setSelectedItem(U.getUnidade());
            getSenha.setText(U.getSenha());
            getSalario.setText(U.getSalario());
            getCnis.setText(U.getCnis());
            getCargo.setSelectedItem(U.getCargo());
        }
        List<Unidades> listaUnidades = ServicoUnidades.listarUnidades();
        if (listaUnidades != null) {
            if (!listaUnidades.isEmpty()) {
                for (int j = 0; j < listaUnidades.size(); j++) {
                    String matricula = listaUnidades.get(j).getNumReferencia();
                    String cidade = listaUnidades.get(j).getCidade();
                    String unidade = matricula + " | " + cidade + ".";
                    unidades_list.addItem(unidade);
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

        jLabel8 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        codigoReservaLabel1 = new javax.swing.JLabel();
        codigoReservaLabel = new javax.swing.JLabel();
        getNome = new javax.swing.JTextField();
        getCpf = new javax.swing.JTextField();
        codigoReservaLabel9 = new javax.swing.JLabel();
        getRg = new javax.swing.JTextField();
        codigoReservaLabel10 = new javax.swing.JLabel();
        getEmail = new javax.swing.JTextField();
        codigoReservaLabel11 = new javax.swing.JLabel();
        getTel = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        codigoReservaLabel5 = new javax.swing.JLabel();
        codigoReservaLabel7 = new javax.swing.JLabel();
        codigoReservaLabel8 = new javax.swing.JLabel();
        getSalario = new javax.swing.JTextField();
        getCnis = new javax.swing.JTextField();
        getCargo = new javax.swing.JComboBox<>();
        codigoReservaLabel12 = new javax.swing.JLabel();
        getUsername = new javax.swing.JTextField();
        codigoReservaLabel13 = new javax.swing.JLabel();
        getSenha = new javax.swing.JTextField();
        codigoReservaLabel14 = new javax.swing.JLabel();
        codigoReservaLabel15 = new javax.swing.JLabel();
        codigoReservaLabel16 = new javax.swing.JLabel();
        getEndereco = new javax.swing.JTextField();
        unidades_list = new javax.swing.JComboBox<>();
        data_Nascimento = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        botaoCadastrarFunc = new javax.swing.JButton();
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Funcionários"));
        jPanel1.setToolTipText("");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Funcionário"));

        codigoReservaLabel1.setFont(new java.awt.Font("Amiri", 1, 14)); // NOI18N
        codigoReservaLabel1.setText("Nome:");

        codigoReservaLabel.setFont(new java.awt.Font("Amiri", 1, 14)); // NOI18N
        codigoReservaLabel.setText("RG:");

        getNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getNomeActionPerformed(evt);
            }
        });

        getCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getCpfActionPerformed(evt);
            }
        });

        codigoReservaLabel9.setFont(new java.awt.Font("Amiri", 1, 14)); // NOI18N
        codigoReservaLabel9.setText("CPF:");

        getRg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getRgActionPerformed(evt);
            }
        });

        codigoReservaLabel10.setFont(new java.awt.Font("Amiri", 1, 14)); // NOI18N
        codigoReservaLabel10.setText("E-mail:");

        getEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getEmailActionPerformed(evt);
            }
        });

        codigoReservaLabel11.setFont(new java.awt.Font("Amiri", 1, 14)); // NOI18N
        codigoReservaLabel11.setText("Telefone:");

        getTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getTelActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Valores"));

        codigoReservaLabel5.setFont(new java.awt.Font("Amiri", 1, 14)); // NOI18N
        codigoReservaLabel5.setText("Salário:");

        codigoReservaLabel7.setFont(new java.awt.Font("Amiri", 1, 14)); // NOI18N
        codigoReservaLabel7.setText("CNIS:");

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
                    .addComponent(getCnis, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(getSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(codigoReservaLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(getCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoReservaLabel5)
                    .addComponent(getSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigoReservaLabel8)
                    .addComponent(getCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoReservaLabel7)
                    .addComponent(getCnis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        codigoReservaLabel12.setFont(new java.awt.Font("Amiri", 1, 14)); // NOI18N
        codigoReservaLabel12.setText("Username:");

        getUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getUsernameActionPerformed(evt);
            }
        });

        codigoReservaLabel13.setFont(new java.awt.Font("Amiri", 1, 14)); // NOI18N
        codigoReservaLabel13.setText("Unidade:");

        getSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getSenhaActionPerformed(evt);
            }
        });

        codigoReservaLabel14.setFont(new java.awt.Font("Amiri", 1, 14)); // NOI18N
        codigoReservaLabel14.setText("Data de nascimento:");

        codigoReservaLabel15.setFont(new java.awt.Font("Amiri", 1, 14)); // NOI18N
        codigoReservaLabel15.setText("Senha:");

        codigoReservaLabel16.setFont(new java.awt.Font("Amiri", 1, 14)); // NOI18N
        codigoReservaLabel16.setText("Endereço:");

        getEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getEnderecoActionPerformed(evt);
            }
        });

        unidades_list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unidades_listActionPerformed(evt);
            }
        });

        data_Nascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                data_NascimentoActionPerformed(evt);
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
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(codigoReservaLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(codigoReservaLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
                    .addComponent(codigoReservaLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(getNome)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(getCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                            .addComponent(getEmail)
                            .addComponent(getUsername)
                            .addComponent(data_Nascimento))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(codigoReservaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(codigoReservaLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(codigoReservaLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(codigoReservaLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(getRg)
                            .addComponent(getTel)
                            .addComponent(getSenha)
                            .addComponent(unidades_list, 0, 140, Short.MAX_VALUE)))
                    .addComponent(getEndereco))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoReservaLabel1)
                    .addComponent(getNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoReservaLabel)
                    .addComponent(getCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(getRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigoReservaLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoReservaLabel10)
                    .addComponent(getEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigoReservaLabel11)
                    .addComponent(getTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(codigoReservaLabel13)
                            .addComponent(unidades_list, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(getSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(codigoReservaLabel14)
                            .addComponent(data_Nascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(codigoReservaLabel12)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(getUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(codigoReservaLabel15)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoReservaLabel16)
                    .addComponent(getEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel17.setText("CADASTRAR FUNCIONÁRIO");

        botaoCadastrarFunc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botaoCadastrarFunc.setText("Cadastrar");
        botaoCadastrarFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarFuncActionPerformed(evt);
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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(134, 134, 134))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botaoCadastrarFunc)
                        .addGap(21, 21, 21))))
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botaoCadastrarFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39))))
        );

        jPanel2.getAccessibleContext().setAccessibleName("Dados do funcionário");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("Funcionário");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void botaoCadastrarFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarFuncActionPerformed
        String nome, cpf, email, username, endereco, rg, tel, unidade, senha, salario, cnis, cargo;
        nome = getNome.getText();
        cpf = getCpf.getText();
        email = getEmail.getText();
        username = getUsername.getText();
        endereco = getEndereco.getText();
        rg = getRg.getText();
        tel = getTel.getText();
        unidade = unidades_list.getSelectedItem().toString();
        senha = getSenha.getText();
        salario = getSalario.getText();
        salario.replaceAll(",", ".");
        Double salarioDouble = Double.parseDouble(salario);
        cnis = getCnis.getText();
        cargo = (String) getCargo.getSelectedItem();
        String dataString = data_Nascimento.getText();

        if (modo.equals("Editar")) {
            try {
                UsuarioDAO.removerFuncionario(username);
            } catch (SQLException | negocioException ex) {
                Logger.getLogger(CadastroFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                ServicoUsuarios.cadastrarFuncionario(nome, cpf, rg, dataString, cnis, salarioDouble, cargo, endereco, tel, email, username, senha, unidade);
            } catch (negocioException | SQLException | UnsupportedEncodingException | NoSuchAlgorithmException ex) {
                Logger.getLogger(CadastroFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                ServicoUsuarios.cadastrarFuncionario(nome, cpf, rg, dataString, cnis, salarioDouble, cargo, endereco, tel, email, username, senha, unidade);
            } catch (negocioException | SQLException | UnsupportedEncodingException | NoSuchAlgorithmException ex) {
                Logger.getLogger(CadastroFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        String mensagem = "Funcionário cadastrado com sucesso";
        JOptionPane.showMessageDialog(null, mensagem);
        this.dispose();
    }//GEN-LAST:event_botaoCadastrarFuncActionPerformed

    private void getNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_getNomeActionPerformed

    private void getCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_getCpfActionPerformed

    private void getRgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getRgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_getRgActionPerformed

    private void getEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_getEmailActionPerformed

    private void getTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getTelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_getTelActionPerformed

    private void getUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getUsernameActionPerformed
        // TODO add your handling code here
    }//GEN-LAST:event_getUsernameActionPerformed

    private void getSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_getSenhaActionPerformed

    private void getEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_getEnderecoActionPerformed

    private void data_NascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_data_NascimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_data_NascimentoActionPerformed

    private void unidades_listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unidades_listActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unidades_listActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCadastrarFunc;
    private javax.swing.JLabel codigoReservaLabel;
    private javax.swing.JLabel codigoReservaLabel1;
    private javax.swing.JLabel codigoReservaLabel10;
    private javax.swing.JLabel codigoReservaLabel11;
    private javax.swing.JLabel codigoReservaLabel12;
    private javax.swing.JLabel codigoReservaLabel13;
    private javax.swing.JLabel codigoReservaLabel14;
    private javax.swing.JLabel codigoReservaLabel15;
    private javax.swing.JLabel codigoReservaLabel16;
    private javax.swing.JLabel codigoReservaLabel5;
    private javax.swing.JLabel codigoReservaLabel7;
    private javax.swing.JLabel codigoReservaLabel8;
    private javax.swing.JLabel codigoReservaLabel9;
    private javax.swing.JTextField data_Nascimento;
    private javax.swing.JComboBox<String> getCargo;
    private javax.swing.JTextField getCnis;
    private javax.swing.JTextField getCpf;
    private javax.swing.JTextField getEmail;
    private javax.swing.JTextField getEndereco;
    private javax.swing.JTextField getNome;
    private javax.swing.JTextField getRg;
    private javax.swing.JTextField getSalario;
    private javax.swing.JTextField getSenha;
    private javax.swing.JTextField getTel;
    private javax.swing.JTextField getUsername;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JComboBox<String> unidades_list;
    // End of variables declaration//GEN-END:variables
}
