/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.locadora.model.dto;

/**
 *
 * @author Aluno
 */
public class Gerente extends Funcionario{
    private final String tipo;

    public Gerente(String username, String senha, double salario){
        super(username, senha, salario);
        this.tipo = "gerente";
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getSenha() {
        return senha;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int getCpf() {
        return cpf;
    }

    @Override
    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
    
}
