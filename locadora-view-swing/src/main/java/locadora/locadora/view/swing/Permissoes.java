/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.locadora.view.swing;

public class Permissoes {
     public String abrirHome(String cargo){
         switch (cargo) {
             case "Vendedor" -> {
                 return "Vendedor";
             }
             case "Gerente" -> {
                 return "Gerente";
             }
             case "Diretor" -> {
                 return "Diretor";
             }
             default -> {
             }
         }
         return null;
     }
}
