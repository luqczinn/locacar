/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.locadora.negocio.dto;


public class Log {
    private String nome;
    private String cargo;
    private String horario;

    public Log(String nome, String cargo, String horario) {
        this.nome = nome;
        this.cargo = cargo;
        this.horario = horario;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public String getHorario() {
        return horario;
    }
    
    
}
