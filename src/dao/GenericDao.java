/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;

/**
 * Define las operaciones que vamos a utilizar y gestión de objetos
 * almacenados en un repositorio
 *
 * @param <T> el tipo de objeto gestionado por el repositorio
 * @author Adrian y Othman
 * @since 1.0
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
