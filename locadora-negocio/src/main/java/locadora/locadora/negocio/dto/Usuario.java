/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.locadora.negocio.dto;

/**
 *
 * @author Aluno
 */
public class Usuario {

    private String nome;
    private String cpf;
    private String rg;
    private String nascimento;
    private String cnis;
    private String salario;
    private String cargo;
    private String endereco;
    private String telefone;
    private String email;
    private String username;
    private String senha;
    private String unidade;

    public Usuario(String nome, String cpf, String rg, String nascimento, String cnis, String salario, String cargo, String endereco, String telefone, String email, String username, String senha, String unidade) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.nascimento = nascimento;
        this.cnis = cnis;
        this.salario = salario;
        this.cargo = cargo;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.username = username;
        this.senha = senha;
        this.unidade = unidade;
    }
    
    public Usuario(String nome, String cargo) {
        this.nome = nome;
        this.cargo = cargo;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public String getNascimento() {
        return nascimento;
    }

    public String getCnis() {
        return cnis;
    }

    public String getSalario() {
        return salario;
    }

    public String getCargo() {
        return cargo;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getSenha() {
        return senha;
    }

    public String getUnidade() {
        return unidade;
    }
    

}
