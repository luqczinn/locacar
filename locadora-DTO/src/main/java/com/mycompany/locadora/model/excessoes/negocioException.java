/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.locadora.model.excessoes;

/**
 *
 * @author Aluno
 */
public class negocioException extends Exception{
    private int codigo;
    
    public negocioException(String str){
        super(str);
        codigo = 0;
    }
    
    public negocioException(int codigo, String str) {
        super(str);
        this.codigo = codigo;
    }
    
     public int getCodigo() {
        return codigo;
    }
}
