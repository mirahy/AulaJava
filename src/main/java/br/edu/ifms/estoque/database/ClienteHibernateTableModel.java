/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.estoque.database;

import br.edu.ifms.estoque.dao.ClienteDao;
import br.edu.ifms.estoque.dao.IClienteDao;
import br.edu.ifms.estoque.model.Cliente;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author aluno
 */
public class ClienteHibernateTableModel extends AbstractTableModel{
    
    private IClienteDao dao;
    private List<Cliente> lista;
    private String[] colunas = {"id", "Nome", "Telefone", "E-mail"};
    
    public  ClienteHibernateTableModel(){
        dao = new ClienteDao();
        lista = dao.listar();
        
    }
    
    public void refresh(String nome){
        lista.clear();
        lista.addAll(dao.buscarPorNome(nome));
        fireTableStructureChanged();
    }
    
    public int getRowCount(){
        return lista.size();
    }
    
    public  int getColumnCount(){
        return colunas.length;
    }


    @Override
    public Object getValueAt(int col, int row) {
        Cliente obj = lista.get(row);
        switch(col){
            case 0: return obj.getId();
            case 1: return obj.getNome();
            case 2: return obj.getTelefone();
            case 3: return obj.getEmail();
            default:
                return "";
        
    }
        
        
    
}

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex == 0){
            return Long.class;
        }
        return String.class;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];

    }
    
   
    
    
}
