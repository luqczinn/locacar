/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.locadora.view.swing;

import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import locadora.locadora.negocio.excessoes.negocioException;
import locadora.locadora.negocio.servico.ServicoVeiculo;
import locadora.locadora.negocio.dto.Veiculo; 
import locadora.locadora.negocio.dao.VeiculoDAO; 
import javax.swing.JOptionPane;
/**
 *
 * @author Aluno
 */
public class ConsultaVeiculo extends javax.swing.JFrame {

    /**
     * Creates new form ControleVeiculo
     * @throws locadora.locadora.negocio.excessoes.negocioException
     */
    String usuario = "";
    public ConsultaVeiculo(String usuario) throws negocioException, SQLException {
        initComponents();
        this.setLocation(((Toolkit.getDefaultToolkit().getScreenSize().width / 2) - (this.getWidth() / 2)),
                ((Toolkit.getDefaultToolkit().getScreenSize().height / 2) - (this.getHeight() / 2)));
        ListarTabela(); 
        this.usuario = usuario;
    }
    
    public void ListarTabela() throws negocioException, SQLException {
        Object colunas[] = {
            "ano", "placa", "marca", "tipo Motor", "modelo", "quilometragem", 
            "valor aluguel", "status", "tipo de Carro", "cambio"
        };
        
        DefaultTableModel tabela
                    = new DefaultTableModel(colunas, 0);
         List<Veiculo> listaVeiculos = ServicoVeiculo.listarVeiculos();
        for (int i = 0; i < listaVeiculos.size(); i++) {
            tabela.addRow(new Object[]{listaVeiculos.get(i).getAno(), 
               listaVeiculos.get(i).getPlaca(), listaVeiculos.get(i).getMarca(), 
                listaVeiculos.get(i).getTipoMotor(), listaVeiculos.get(i).getModeloCarro(), 
                listaVeiculos.get(i).getKmRodados(), listaVeiculos.get(i).getValorAluguel(),listaVeiculos.get(i).getStatus(), 
                listaVeiculos.get(i).getTipo(), listaVeiculos.get(i).getCambio()});
        } 
        jTable1.setModel(tabela); 
        //jTable1.setEnabled(false);
    };
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jFrame1 = new javax.swing.JFrame();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        anoCarro = new javax.swing.JComboBox<>();
        placaCarro = new javax.swing.JTextField();
        marcaCarro = new javax.swing.JComboBox<>();
        tipoDeMotor = new javax.swing.JTextField();
        quilometragemRodada = new javax.swing.JTextField();
        modeloCarro1 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        tipoCarro = new javax.swing.JComboBox<>();
        cambioCarro = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        cbxStatus = new javax.swing.JComboBox<>();
        valorAluguel = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        imagemVeiculo = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setFocusCycleRoot(false);

        btnSalvar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("Fechar");
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Droid Serif", 0, 24)); // NOI18N
        jLabel1.setText("Consulta dos Veículos da Empresa");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Carro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Amiri", 0, 16))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Amiri", 1, 14)); // NOI18N
        jLabel9.setText("Ano:");

        jLabel10.setFont(new java.awt.Font("Amiri", 1, 14)); // NOI18N
        jLabel10.setText("Placa:");

        jLabel11.setFont(new java.awt.Font("Amiri", 1, 14)); // NOI18N
        jLabel11.setText("Marca:");

        jLabel12.setFont(new java.awt.Font("Amiri", 1, 14)); // NOI18N
        jLabel12.setText("Modelo:");

        jLabel13.setFont(new java.awt.Font("Amiri", 1, 14)); // NOI18N
        jLabel13.setText("Tipo de Motor:");

        jLabel14.setFont(new java.awt.Font("Amiri", 1, 14)); // NOI18N
        jLabel14.setText("KM Rodados:");

        anoCarro.setEditable(true);
        anoCarro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o Ano", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", " " }));
        anoCarro.setEnabled(false);
        anoCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anoCarroActionPerformed(evt);
            }
        });

        placaCarro.setEditable(false);
        placaCarro.setEnabled(false);
        placaCarro.setFocusable(false);

        marcaCarro.setEditable(true);
        marcaCarro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione a Marca", "AUDI", "BMW", "CITROEN", "FIAT", "FORD", "HONDA", "HYUNDAI", "JEEP", "KIA", "MERCEDES-BENZ", "MITSUBISHI", "PEUGEOT", "RENAULT", "TOYOTA", "VOLKSWAGEN", "VOLVO", " ", " " }));
        marcaCarro.setEnabled(false);
        marcaCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marcaCarroActionPerformed(evt);
            }
        });

        tipoDeMotor.setEnabled(false);

        quilometragemRodada.setEnabled(false);

        modeloCarro1.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(anoCarro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(placaCarro)
                    .addComponent(marcaCarro, 0, 196, Short.MAX_VALUE)
                    .addComponent(tipoDeMotor)
                    .addComponent(quilometragemRodada)
                    .addComponent(modeloCarro1))
                .addGap(22, 22, 22))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(anoCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(placaCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(marcaCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(modeloCarro1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(tipoDeMotor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(quilometragemRodada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados para Cadastro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Amiri", 0, 16))); // NOI18N

        jLabel17.setFont(new java.awt.Font("Amiri", 1, 14)); // NOI18N
        jLabel17.setText("Tipo de Carro:");

        jLabel18.setFont(new java.awt.Font("Amiri", 1, 14)); // NOI18N
        jLabel18.setText("Câmbio:");

        jLabel19.setFont(new java.awt.Font("Amiri", 1, 14)); // NOI18N
        jLabel19.setText("Valor Diária:");

        tipoCarro.setEditable(true);
        tipoCarro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o Modelo", "A", "B", "C", "D", " ", " " }));
        tipoCarro.setEnabled(false);
        tipoCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoCarroActionPerformed(evt);
            }
        });

        cambioCarro.setEditable(true);
        cambioCarro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o Cambio", "Manual", "Automatico", "Misto" }));
        cambioCarro.setEnabled(false);
        cambioCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambioCarroActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Amiri", 1, 14)); // NOI18N
        jLabel21.setText("Status:");

        cbxStatus.setEditable(true);
        cbxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o Status", "Alugado", "Livre", "Em Manutenção", "Ultrapassado", " " }));
        cbxStatus.setEnabled(false);
        cbxStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxStatusActionPerformed(evt);
            }
        });

        valorAluguel.setText("  ,00");
        valorAluguel.setEnabled(false);

        jLabel22.setFont(new java.awt.Font("Amiri", 1, 14)); // NOI18N
        jLabel22.setText("Link da imagem:");

        imagemVeiculo.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(imagemVeiculo))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(21, 21, 21)
                                    .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cambioCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tipoCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(valorAluguel))))))
                .addGap(48, 48, 48))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(tipoCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(cambioCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(valorAluguel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(imagemVeiculo)
                        .addContainerGap())))
        );

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(334, 334, 334)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1045, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEditar)
                                .addGap(139, 139, 139)
                                .addComponent(btnSalvar)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(btnExcluir)
                                .addGap(131, 131, 131)
                                .addComponent(btnCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4)
                                .addGap(51, 51, 51)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnSalvar)
                    .addComponent(btnExcluir)
                    .addComponent(btnCancelar)
                    .addComponent(jButton4))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        int x = jTable1.getSelectedRow();
        Veiculo v = null;
        //pegar o veiculo
        try {
            v = VeiculoDAO.listarVeiculosBD().get(x);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaVeiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //colocar nos campos de acordo com o veiculo selecionado
        anoCarro.setSelectedItem(v.getAno());
        placaCarro.setText(v.getPlaca());
        marcaCarro.setSelectedItem(v.getMarca());
        imagemVeiculo.setText(v.getModeloCarro());
        tipoDeMotor.setText(v.getTipoMotor());
        quilometragemRodada.setText(Double.toString(v.getKmRodados()));
        tipoCarro.setSelectedItem(v.getTipo());
        cambioCarro.setSelectedItem(v.getCambio());
        valorAluguel.setText(Double.toString(v.getValorAluguel()));
        cbxStatus.setSelectedItem(v.getStatus());
        imagemVeiculo.setText(v.getImagem());
        modeloCarro1.setText(v.getModeloCarro());
        
        //libera os campos de veiculo para fazer a alteração
        anoCarro.setEnabled(true);
        //placaCarro.setEnabled(true); 
        //obs: a placa do carro n pode ser alterada 
        marcaCarro.setEnabled(true);
        imagemVeiculo.setEnabled(true);
        tipoDeMotor.setEnabled(true);
        quilometragemRodada.setEnabled(true);
        tipoCarro.setEnabled(true);
        cambioCarro.setEnabled(true);
        valorAluguel.setEnabled(true);
        cbxStatus.setEnabled(true);
        imagemVeiculo.setEnabled(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int x = jTable1.getSelectedRow();
        Veiculo v = null;
        
        try {
            v = VeiculoDAO.listarVeiculosBD().get(x); 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Erro no Banco de Dados", JOptionPane.ERROR_MESSAGE);
        }
        
        try {
            VeiculoDAO.removerVeiculoBD(v.getPlaca(), usuario); 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Erro no Banco de Dados", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            Logger.getLogger(ConsultaVeiculo.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            ListarTabela();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Erro no Banco de Dados", JOptionPane.ERROR_MESSAGE);
        } catch (negocioException ex) {
            Logger.getLogger(ConsultaVeiculo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        //pegar novos valores do cadastro
        String ano = anoCarro.getSelectedItem().toString();
        String placa = placaCarro.getText();
        String marca = marcaCarro.getSelectedItem().toString();
        String modelo = modeloCarro1.getText();
        String tipoMotor = tipoDeMotor.getText();
        String quilometragem = quilometragemRodada.getText(); 
        String tipoDeCarro = tipoCarro.getSelectedItem().toString();
        String cambio = cambioCarro.getSelectedItem().toString();
        String valorDiaria = valorAluguel.getText();
        String status = cbxStatus.getSelectedItem().toString(); 
        String imagem = imagemVeiculo.getText();
        
        try {
            //adicionar na lista de carros
            ServicoVeiculo.removerVeiculoPorPlaca(placa, usuario);
            ServicoVeiculo.inserirVeiculoBD(ano, placa, marca, tipoMotor, 
                    modelo,
                    quilometragem, valorDiaria, status, 
                    tipoDeCarro, cambio, imagem, usuario); 
        } catch (negocioException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Erro ao consultar veículo", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(CadastroVeiculo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Erro ao consultar veículo", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(CadastroVeiculo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ConsultaVeiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.dispose(); 
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void anoCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anoCarroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_anoCarroActionPerformed

    private void marcaCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marcaCarroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_marcaCarroActionPerformed

    private void tipoCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoCarroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoCarroActionPerformed

    private void cambioCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambioCarroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cambioCarroActionPerformed

    private void cbxStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxStatusActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

    }//GEN-LAST:event_jTable1MouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> anoCarro;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cambioCarro;
    private javax.swing.JComboBox<String> cbxStatus;
    private javax.swing.JTextField imagemVeiculo;
    private javax.swing.JButton jButton4;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> marcaCarro;
    private javax.swing.JTextField modeloCarro1;
    private javax.swing.JTextField placaCarro;
    private javax.swing.JTextField quilometragemRodada;
    private javax.swing.JComboBox<String> tipoCarro;
    private javax.swing.JTextField tipoDeMotor;
    private javax.swing.JTextField valorAluguel;
    // End of variables declaration//GEN-END:variables
}
