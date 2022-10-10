/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.locadora.model.dto;

/**
 *
 * @author Aluno
 */
public class Funcionario extends Usuario{
    private double salario;
    private String nome; 
    
    public Funcionario(String username, String senha, double salario){
        this.username = username;
        this.senha = senha;
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
}
