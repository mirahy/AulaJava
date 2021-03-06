/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.estoque.facade;

import br.edu.ifms.estoque.dao.ClienteDao;
import br.edu.ifms.estoque.dao.IClienteDao;
import br.edu.ifms.estoque.model.Cliente;
import br.edu.ifms.estoque.view.TelaFormCliente;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author aluno
 */
public class ClienteFacade {
    
    private IClienteDao dao;
    
    public  ClienteFacade(IClienteDao dao){
        this.dao = dao;
    }
    
    public  ClienteFacade(){
        this(new ClienteDao());
    }
    
    public TelaFormCliente abrirFormulario(JFrame frame, ClienteFacade facade, Object rowId){
        TelaFormCliente dialog = new TelaFormCliente(frame, true, facade);
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }        
            
        });
        
        if(rowId != null ){
            Cliente cliente = new Cliente();
            cliente = dao.buscarPorId(rowId);
            dialog.setDados(cliente);  
        }
        return dialog;
        
    }
    
    public boolean salvar(
            JTextField txtId,
            JTextField txtNome,
            JTextField txtTelefone,
            JTextField txtEmail,
            JTextField txtCPF
    ){
        boolean isId = txtId.getText().matches("\\d+");
        Long id = isId ? Long.parseLong(txtId.getText()) : null;
        
        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente.setNome(txtNome.getText());
        cliente.setTelefone(txtTelefone.getText());
        cliente.setEmail(txtEmail.getText());
        cliente.setCpf(txtCPF.getText());
        
        dao.inserir(cliente);

        return true;
 
    }
    
    public boolean alterar(
            JTextField txtId,
            JTextField txtNome,
            JTextField txtTelefone,
            JTextField txtEmail,
            JTextField txtCPF
    ){
        boolean isId = txtId.getText().matches("\\d+");
        Long id = isId ? Long.parseLong(txtId.getText()) : null;
        
        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente.setNome(txtNome.getText());
        cliente.setTelefone(txtTelefone.getText());
        cliente.setEmail(txtEmail.getText());
        cliente.setCpf(txtCPF.getText());
        
        dao.alterar(cliente);
       
        return true;
 
    }
    public boolean excluir(
            JTextField txtId
    ){
        boolean isId = txtId.getText().matches("\\d+");
        Long id = isId ? Long.parseLong(txtId.getText()) : null;
        
        dao.excluir(id);
        
        return true;
 
    }
    
}
