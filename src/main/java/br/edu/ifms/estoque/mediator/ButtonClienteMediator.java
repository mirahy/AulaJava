/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.estoque.mediator;

import javax.swing.JButton;

/**
 *
 * @author aluno
 */
public class ButtonClienteMediator {
    
    private JButton btSalvar;
    private JButton btEditar;
    private JButton btExcluir;
    private JButton btVisualizar;
    
    
    public  void registerSalvar(JButton btSalvar){
        this.btSalvar = btSalvar;
    }
    
    public  void registerEditar(JButton bteditar){
        this.btEditar = bteditar;
    }
    
    public  void registerExcluir(JButton btExcluir){
        this.btExcluir = btExcluir;
    }
    
    public  void registerVisualizar(JButton btVisualizar){
        this.btVisualizar = btVisualizar;
    }
    
    public  void ativarVisualizar(){
        this.btVisualizar.setVisible(true);
    }
    
    public  void desativarVisualizar(){
        this.btVisualizar.setVisible(false);
    }
    
    
}
