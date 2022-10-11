/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.locadora.model.dto;

/**
 *
 * @author Aluno
 */
public class Gerente extends Usuario {

    private double salario;
    private String nome;
    
    public Gerente(double salario, String nome, String username, String senha) {
        super(username, senha);
        this.salario = salario;
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
 
}
