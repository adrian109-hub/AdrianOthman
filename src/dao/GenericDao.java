/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;

/**
 *
 * @author 2DAM
 */
public interface GenericDao<T> {
    boolean insertar(T objeto);
    List<T> obtenertodos();
    T obtenerPorId(String id);
    boolean actualizar(T objeto);
    boolean eliminar(String id);
      List<T> obtenerPorTitulo(String titulo);
    List<T> obtenerPorAutor(String autor);
    List<T> obtenerPorPrecio(double minimo, double maximo);
}
