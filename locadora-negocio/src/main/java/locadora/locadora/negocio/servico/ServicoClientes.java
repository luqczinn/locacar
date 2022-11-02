/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.locadora.negocio.servico;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import locadora.locadora.negocio.dao.ClientesDAO;
import locadora.locadora.negocio.dto.Cliente;
import locadora.locadora.negocio.excessoes.negocioException;

/**
 *
 * @author gugup
 */
public class ServicoClientes {

    public void removerCliente(String username) throws negocioException, SQLException, UnsupportedEncodingException, NoSuchAlgorithmException {
        if (username.isEmpty()) {
            throw new negocioException(319, "Insira um username!");
        }
        try {
            ClientesDAO.removerCliente(username);
        } catch (negocioException | SQLException ex) {
            throw new negocioException(315, ex.getMessage());
        }
    }

    public static void cadastrarCliente(String nome, String nascimento, String cpf, String rg, String endereco, String telefone, String email, String usuario, String senha) throws negocioException, SQLException, UnsupportedEncodingException, NoSuchAlgorithmException {
        if (nome.isEmpty()) {
            throw new negocioException(319, "Insira o nome!");
        }
        if (nascimento.isEmpty()) {
            throw new negocioException(319, "Insira a data de nascimento!");
        }
        if (cpf.isEmpty()) {
            throw new negocioException(319, "Insira o cpf!");
        }
        if (rg.isEmpty()) {
            throw new negocioException(319, "Insira o rg!");
        }
        if (endereco.isEmpty()) {
            throw new negocioException(319, "Insira o endereço!");
        }
        if (telefone.isEmpty()) {
            throw new negocioException(319, "Insira o telefone!");
        }
        if (email.isEmpty()) {
            throw new negocioException(319, "Insira o email!");
        }
        if (usuario.isEmpty()) {
            throw new negocioException(319, "Insira o usuário!");
        }
        if (senha.isEmpty()) {
            throw new negocioException(319, "Insira a senha!");
        }
        try {
            ClientesDAO.cadastrarCliente(nome, nascimento, cpf, rg, endereco, telefone, email, usuario, senha);
        } catch (negocioException | SQLException ex) {
            throw new negocioException(315, ex.getMessage());
        }
    }

    public static List<Cliente> listarClientes() throws negocioException, SQLException, UnsupportedEncodingException, NoSuchAlgorithmException {
        if (ClientesDAO.listarClientesBD() == null) {
            throw new negocioException(315, "Não existem clientes cadastrados!");
        }

        return ClientesDAO.listarClientesBD();
    }
}
