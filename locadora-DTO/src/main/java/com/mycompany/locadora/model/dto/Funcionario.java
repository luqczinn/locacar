/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.locadora.model.dto;

/**
 *
 * @author Aluno
 */
public class Funcionario{
    private double salario;
    private String nome; 
    private String username;
    private String senha;
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
