/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.locadora.negocio.dao;

import java.util.ArrayList;
import locadora.locadora.negocio.dto.Gerente;
import java.util.List;
import locadora.locadora.negocio.dto.Usuario;
import locadora.locadora.negocio.excessoes.persistenciaException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Aluno
 */
public class UsuarioDAO {

    public static void cadastrarFuncionario() {
    }

    public static void removerFuncionario() {
    }

    public static void contagemFuncionarios() {
    }

    public static int numeroFuncionarios() {
        return 0;
    }

    public static Usuario procurarPorUsername(String username) {
        ///lista provisória até inserção de BD !!!!!
        List<Usuario> listarUsuarios = new ArrayList<>();
        listarUsuarios.add(new Usuario("stella", "televisao"));
        if (listarUsuarios != null) {
            for (Usuario u : listarUsuarios) {
                if (u.getUsername() == username) {
                    return u;
                }
            }
        }
        return null;
    }

    public static String logarUsuario(String username, String senha) throws persistenciaException {
        Usuario usuario = procurarPorUsername(username);

        if (usuario == null) {
            throw new persistenciaException("Username de usuário não encontrado!");
        }
        try {
            if (usuario.getSenha() == criptografarSenha(senha)) {
                String className = usuario.getClass().getSimpleName();
                return className;
            } else {
                throw new persistenciaException("Senha incorreta!");
            }
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            throw new persistenciaException("Erro ao inserir a senha");
        }
    }

    public static String criptografarSenha(String senha) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));

        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            hexString.append(String.format("%02X", 0xFF & b));
        }
        String senhahex = hexString.toString();
        return senhahex;
    }
}
