/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.ifms.estoque.dao;

import java.util.List;

/**
 *
 * @author nicholas.santos
 */
public interface IDao<T> {

    T inserir(T object);

    T alterar(T object);

    void excluir(Object object);

    List<T> listar();
    
    T buscarPorId(Object object);
}
