/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.locadora.model.dto;

/**
 *
 * @author Aluno
 */
public class Cliente extends Usuario{
    private int numCadastro;
    private int codigo;
    private int status;
    
    private Cliente(String username, String senha, int numCadastro){
        super(username, senha);
        this.numCadastro = numCadastro;
        this.codigo = 0;
    }
}
