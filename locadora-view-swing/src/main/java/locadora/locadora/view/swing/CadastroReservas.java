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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import locadora.locadora.negocio.dao.ReservasDAO;
import locadora.locadora.negocio.dao.UnidadesDAO;
import locadora.locadora.negocio.dao.UsuarioDAO;
import locadora.locadora.negocio.dao.VeiculoDAO;
import locadora.locadora.negocio.dto.Cliente;
import locadora.locadora.negocio.dto.Reservas;
import locadora.locadora.negocio.dto.Unidades;
import locadora.locadora.negocio.dto.Usuario;
import locadora.locadora.negocio.dto.Veiculo;
import locadora.locadora.negocio.excessoes.negocioException;
import locadora.locadora.negocio.servico.ServicoClientes;
import static locadora.locadora.negocio.servico.ServicoClientes.cadastrarCliente;
import locadora.locadora.negocio.servico.ServicoReservas;
import locadora.locadora.negocio.servico.ServicoUnidades;
import locadora.locadora.negocio.servico.ServicoUsuarios;
import locadora.locadora.negocio.servico.ServicoVeiculo;

/**
 *
 * @author gugup
 */
public class CadastroReservas extends javax.swing.JFrame {

    /**
     * Creates new form CadastroReservas
     */
    String usuario = "";
    List<Reservas> listaReservas = ServicoReservas.listarReservas();

    public CadastroReservas(java.awt.Frame parent, boolean modal, String usuario) throws SQLException, negocioException, UnsupportedEncodingException, NoSuchAlgorithmException {
        //super(parent, modal);
        initComponents();
        this.usuario = usuario;
        this.setLocation(((Toolkit.getDefaultToolkit().getScreenSize().width / 2) - (this.getWidth() / 2)),
                ((Toolkit.getDefaultToolkit().getScreenSize().height / 2) - (this.getHeight() / 2)));
        String modo = "";
        if (ConsultarReservas.getVariavelB() != null) {
            modo = ConsultarReservas.getVariavelB();
        }
        int x = 0;
        if (ConsultarReservas.getVariavelA() == 0) {
            x = ConsultarReservas.getVariavelA();
        }
        if (modo.equals("Editar")) {
            Reservas R = listaReservas.get(x);
            textCodigoReserva.setText(Integer.toString(R.getCodigo()));
            combo_unidade_reserva.setSelectedItem(R.getUnidade());
            comb_rs_cliente.setSelectedItem(R.getCliente());
            comb_rs_vendedor.setSelectedItem(R.getVendedor());
            combo_veiculo_reservas.setSelectedItem(R.getVeiculo());
            txt_DataColeta_reservas.setText(R.getInicio());
            txt_DataEntrega_reservas.setText(R.getFim());
        }
        LoadCombos();
    }

    public void LoadCombos() throws SQLException, negocioException, UnsupportedEncodingException, NoSuchAlgorithmException {
        if (listaReservas != null) {
            if (listaReservas.isEmpty()) {
                textCodigoReserva.setText("0001");
            } else {
                int mat = listaReservas.size() + 1;
                textCodigoReserva.setText(Integer.toString(mat));
            }
        }
        List<Usuario> listaUsuarios = ServicoUsuarios.listarUsuarios();
        for (int i = 0; i < listaUsuarios.size(); i++) {
            String nome = listaUsuarios.get(i).getNome();
            String cargo = listaUsuarios.get(i).getCargo();
            String gerente = nome + "  |  " + cargo + ".";
            comb_rs_vendedor.addItem(gerente);
        }
        List<Cliente> listaClientes = ServicoClientes.listarClientes();
        for (int i = 0; i < listaClientes.size(); i++) {
            String nome = listaClientes.get(i).getNome();
            String cpf = listaClientes.get(i).getCpf();
            String cliente = nome + "  |  " + cpf + ".";
            comb_rs_cliente.addItem(cliente);
        }
        List<Unidades> listaUnidades = UnidadesDAO.listarUnidadesBD();
        if (listaUnidades != null) {
            if (!listaUnidades.isEmpty()) {
                for (int j = 0; j < listaUnidades.size(); j++) {
                    String matricula = listaUnidades.get(j).getNumReferencia();
                    String cidade = listaUnidades.get(j).getCidade();
                    String unidade = matricula + " | " + cidade + ".";
                    combo_unidade_reserva.addItem(unidade);
                }
            }
        }
        List<Veiculo> listaVeiculos = VeiculoDAO.listarVeiculosBD();
        if (!listaVeiculos.isEmpty()) {
            for (int z = 0; z < listaVeiculos.size(); z++) {
                if (listaVeiculos.get(z).getStatus().equals("Livre")) {
                    String placa = listaVeiculos.get(z).getPlaca();
                    String modelo = listaVeiculos.get(z).getModeloCarro();
                    String carro = placa + " | " + modelo + ".";
                    combo_veiculo_reservas.addItem(carro);
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
        codigoReservaLabel2 = new javax.swing.JLabel();
        comb_rs_vendedor = new javax.swing.JComboBox<>();
        comb_rs_cliente = new javax.swing.JComboBox<>();
        textCodigoReserva = new javax.swing.JTextField();
        codigoReservaLabel6 = new javax.swing.JLabel();
        combo_unidade_reserva = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        codigoReservaLabel4 = new javax.swing.JLabel();
        combo_veiculo_reservas = new javax.swing.JComboBox<>();
        txt_tipo_carro = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_cambio_carro = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_placa_carro = new javax.swing.JTextField();
        txt_modelo_carro = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_marca_carro = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txt_km_carro = new javax.swing.JTextField();
        txt_ano_carro = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        codigoReservaLabel5 = new javax.swing.JLabel();
        codigoReservaLabel3 = new javax.swing.JLabel();
        codigoReservaLabel7 = new javax.swing.JLabel();
        codigoReservaLabel8 = new javax.swing.JLabel();
        txt_DataColeta_reservas = new javax.swing.JTextField();
        txt_DataEntrega_reservas = new javax.swing.JTextField();
        valorTotaltxt = new javax.swing.JTextField();
        valorDiaria = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton9 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        jLabel8.setFont(new java.awt.Font("Amiri", 1, 14)); // NOI18N
        jLabel8.setText("N??mero de Refer??ncia:");

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
        setTitle("Cadastro Reservas");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Reserva"));
        jPanel1.setToolTipText("");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados da reserva"));

        codigoReservaLabel1.setFont(new java.awt.Font("Amiri", 1, 14)); // NOI18N
        codigoReservaLabel1.setText("C??digo de reserva:");

        codigoReservaLabel.setFont(new java.awt.Font("Amiri", 1, 14)); // NOI18N
        codigoReservaLabel.setText("Cliente:");

        codigoReservaLabel2.setFont(new java.awt.Font("Amiri", 1, 14)); // NOI18N
        codigoReservaLabel2.setText("Vendedor:");

        textCodigoReserva.setEditable(false);
        textCodigoReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCodigoReservaActionPerformed(evt);
            }
        });

        codigoReservaLabel6.setFont(new java.awt.Font("Amiri", 1, 14)); // NOI18N
        codigoReservaLabel6.setText("Unidade:");

        jButton1.setText("+");
        jButton1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jButton1FocusLost(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(codigoReservaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comb_rs_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(codigoReservaLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textCodigoReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(codigoReservaLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combo_unidade_reserva, 0, 165, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(codigoReservaLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comb_rs_vendedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textCodigoReserva, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(codigoReservaLabel1)
                        .addComponent(codigoReservaLabel6)
                        .addComponent(combo_unidade_reserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoReservaLabel)
                    .addComponent(comb_rs_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoReservaLabel2)
                    .addComponent(comb_rs_vendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do ve??culo"));

        codigoReservaLabel4.setFont(new java.awt.Font("Amiri", 1, 14)); // NOI18N
        codigoReservaLabel4.setText("Ve??culo:");

        combo_veiculo_reservas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                combo_veiculo_reservasFocusLost(evt);
            }
        });

        txt_tipo_carro.setEditable(false);

        jLabel10.setText("Modelo:");

        txt_cambio_carro.setEditable(false);

        jLabel14.setText("Tipo:");

        jLabel13.setText("Marca:");

        jLabel11.setText("Placa:");

        txt_placa_carro.setEditable(false);

        txt_modelo_carro.setEditable(false);

        jLabel12.setText("Cambio:");

        txt_marca_carro.setEditable(false);

        jLabel15.setText("Quilometragem:");

        txt_km_carro.setEditable(false);
        txt_km_carro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_km_carroActionPerformed(evt);
            }
        });

        txt_ano_carro.setEditable(false);

        jLabel16.setText("Ano:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(codigoReservaLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combo_veiculo_reservas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_modelo_carro))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_km_carro))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(txt_placa_carro))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_cambio_carro, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txt_tipo_carro)
                                    .addComponent(txt_marca_carro)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(30, 30, 30)
                                .addComponent(txt_ano_carro)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoReservaLabel4)
                    .addComponent(combo_veiculo_reservas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_modelo_carro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_marca_carro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txt_placa_carro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txt_tipo_carro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txt_cambio_carro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(txt_ano_carro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_km_carro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Valores"));

        codigoReservaLabel5.setFont(new java.awt.Font("Amiri", 1, 14)); // NOI18N
        codigoReservaLabel5.setText("Data de coleta:");

        codigoReservaLabel3.setFont(new java.awt.Font("Amiri", 1, 14)); // NOI18N
        codigoReservaLabel3.setText("Data de entrega:");

        codigoReservaLabel7.setFont(new java.awt.Font("Amiri", 1, 14)); // NOI18N
        codigoReservaLabel7.setText("Valor di??ria:");

        codigoReservaLabel8.setFont(new java.awt.Font("Amiri", 1, 14)); // NOI18N
        codigoReservaLabel8.setText("Valor da reserva:");

        txt_DataEntrega_reservas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_DataEntrega_reservasFocusLost(evt);
            }
        });

        valorTotaltxt.setEditable(false);

        valorDiaria.setEditable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(codigoReservaLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(codigoReservaLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txt_DataColeta_reservas, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(valorDiaria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(codigoReservaLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(codigoReservaLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_DataEntrega_reservas, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valorTotaltxt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
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
                    .addComponent(valorDiaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigoReservaLabel8)
                    .addComponent(valorTotaltxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel17.setText("CADASTRAR RESERVA");

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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(247, 247, 247))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_km_carroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_km_carroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_km_carroActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        String codReserva = textCodigoReserva.getText();
        String unidade = combo_unidade_reserva.getSelectedItem().toString();
        String cliente = comb_rs_cliente.getSelectedItem().toString();
        String vendedor = comb_rs_vendedor.getSelectedItem().toString();
        String veiculo = combo_veiculo_reservas.getSelectedItem().toString();
        String dataDeColeta = txt_DataColeta_reservas.getText();
        String dataDeEntrega = txt_DataEntrega_reservas.getText();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        Date d1 = null;
        try {
            d1 = df.parse(dataDeColeta);
        } catch (ParseException ex) {
            Logger.getLogger(CadastroReservas.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(d1);
        Date d2 = null;
        try {
            d2 = df.parse(dataDeEntrega);
        } catch (ParseException ex) {
            Logger.getLogger(CadastroReservas.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(d2);
        long dt = (d2.getTime() - d1.getTime());
        long dias = dt / 86400000L;
        int diasInt = (int) dias;

        int pos = veiculo.indexOf(" |");
        String placa = veiculo.substring(0, pos);
        double diaria = 0;
        try {
            diaria = ServicoVeiculo.consultarPorPlaca(placa).getValorAluguel();
        } catch (negocioException | SQLException ex) {
            Logger.getLogger(CadastroReservas.class.getName()).log(Level.SEVERE, null, ex);
        }
        double valorTotal = diaria * diasInt;
        if (ConsultarReservas.getVariavelB() != null) {
            if (ConsultarReservas.getVariavelB().equals("Editar")) {
                try {
                    ServicoReservas.removerReservaPorCodigo(Integer.valueOf(codReserva));
                    ServicoReservas.inserirReservaBD(Integer.valueOf(codReserva), cliente, vendedor, veiculo, unidade, dataDeColeta, dataDeEntrega, Double.toString(diaria), Double.toString(valorTotal), usuario);
                } catch (negocioException | SQLException ex) {
                    Logger.getLogger(CadastroReservas.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(CadastroReservas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        try {
            ServicoReservas.inserirReservaBD(Integer.valueOf(codReserva), cliente, vendedor, veiculo, unidade, dataDeColeta, dataDeEntrega, Double.toString(diaria), Double.toString(valorTotal), usuario);
        } catch (negocioException | SQLException ex) {
            Logger.getLogger(CadastroReservas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CadastroReservas.class.getName()).log(Level.SEVERE, null, ex);
        }

        String mensagem = "Reserva cadastrada com sucesso";
        JOptionPane.showMessageDialog(null, mensagem);
        this.dispose();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void textCodigoReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCodigoReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCodigoReservaActionPerformed

    private void combo_veiculo_reservasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_combo_veiculo_reservasFocusLost
        try {
            String veiculo = combo_veiculo_reservas.getSelectedItem().toString();
            int pos = veiculo.indexOf(" |");
            String placa = veiculo.substring(0, pos);
            Veiculo veiculosPlaca = ServicoVeiculo.consultarPorPlaca(placa);
            String modelo = veiculosPlaca.getModeloCarro();
            String cambio = veiculosPlaca.getMarca();
            String km = Double.toString(veiculosPlaca.getKmRodados());
            String marca = veiculosPlaca.getMarca();
            String tipo = veiculosPlaca.getTipo();
            String ano = Integer.toString(veiculosPlaca.getAno());
            txt_modelo_carro.setText(modelo);
            txt_placa_carro.setText(placa);
            txt_marca_carro.setText(marca);
            txt_cambio_carro.setText(cambio);
            txt_tipo_carro.setText(tipo);
            txt_km_carro.setText(km);
            txt_ano_carro.setText(ano);
        } catch (negocioException | SQLException ex) {
            Logger.getLogger(CadastroReservas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_combo_veiculo_reservasFocusLost

    private void txt_DataEntrega_reservasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_DataEntrega_reservasFocusLost
        String veiculo = combo_veiculo_reservas.getSelectedItem().toString();
        int pos = veiculo.indexOf(" |");
        String placa = veiculo.substring(0, pos);
        String dataDeColeta = txt_DataColeta_reservas.getText();
        String dataDeEntrega = txt_DataEntrega_reservas.getText();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        Date d1 = null;
        try {
            d1 = df.parse(dataDeColeta);
        } catch (ParseException ex) {
            Logger.getLogger(CadastroReservas.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(d1);
        Date d2 = null;
        try {
            d2 = df.parse(dataDeEntrega);
        } catch (ParseException ex) {
            Logger.getLogger(CadastroReservas.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(d2);
        long dt = (d2.getTime() - d1.getTime());
        long dias = dt / 86400000L;
        int diasInt = (int) dias;
        double diaria;
        try {
            diaria = ServicoVeiculo.consultarPorPlaca(placa).getValorAluguel();
            double valorTotal = diaria * diasInt;
            valorDiaria.setText(Double.toString(diaria));
            valorTotaltxt.setText(Double.toString(valorTotal));
        } catch (negocioException | SQLException ex) {
            Logger.getLogger(CadastroReservas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txt_DataEntrega_reservasFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Controle.abrirCadastroCliente();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton1FocusLost
        try {
            LoadCombos();
        } catch (SQLException | negocioException | UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            Logger.getLogger(CadastroReservas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1FocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel codigoReservaLabel;
    private javax.swing.JLabel codigoReservaLabel1;
    private javax.swing.JLabel codigoReservaLabel2;
    private javax.swing.JLabel codigoReservaLabel3;
    private javax.swing.JLabel codigoReservaLabel4;
    private javax.swing.JLabel codigoReservaLabel5;
    private javax.swing.JLabel codigoReservaLabel6;
    private javax.swing.JLabel codigoReservaLabel7;
    private javax.swing.JLabel codigoReservaLabel8;
    private javax.swing.JComboBox<String> comb_rs_cliente;
    private javax.swing.JComboBox<String> comb_rs_vendedor;
    private javax.swing.JComboBox<String> combo_unidade_reserva;
    private javax.swing.JComboBox<String> combo_veiculo_reservas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField textCodigoReserva;
    private javax.swing.JTextField txt_DataColeta_reservas;
    private javax.swing.JTextField txt_DataEntrega_reservas;
    private javax.swing.JTextField txt_ano_carro;
    private javax.swing.JTextField txt_cambio_carro;
    private javax.swing.JTextField txt_km_carro;
    private javax.swing.JTextField txt_marca_carro;
    private javax.swing.JTextField txt_modelo_carro;
    private javax.swing.JTextField txt_placa_carro;
    private javax.swing.JTextField txt_tipo_carro;
    private javax.swing.JTextField valorDiaria;
    private javax.swing.JTextField valorTotaltxt;
    // End of variables declaration//GEN-END:variables
}
