/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import modelo.Libro;
import util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Implementa las operaciones de acceso a datos de {@link Libro}
 * utilizando una base de datos MySQL.
 *
 * @author Adrian y Othman
 */

public class LibroDAOmysql implements GenericDao<Libro> {
  
    
    /**
     * Inserta un libro en la base de datos.
     *
     * @param objeto el libro que se desea insertar
     * @return true si el libro se inserta correctamente; false si se produce
     * un error durante la inserción
     * @throws SQLException si se produce un error al insertar el libro
     */


    @Override
    public boolean insertar(Libro objeto) {

        String sql = "INSERT INTO libro (id, titulo, autor, precio, stock) "
                   + "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = ConexionDB.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, objeto.getId());
            ps.setString(2, objeto.getTitulo());
            ps.setString(3, objeto.getAutor());
            ps.setDouble(4, objeto.getPrecio());
            ps.setInt(5, objeto.getStock());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error insertando libro: "
                    + e.getMessage());
            return false;
        }
    }

    /**
     * Obtiene todos los libros almacenados en la base de datos.
     *
     * @return lista de todos los libros encontrados
     * @throws SQLException si se produce un error al obtener los libros
     */
    @Override
    public List<Libro> obtenertodos() {

        List<Libro> lista = new ArrayList<>();

        String sql = "SELECT * FROM libro";

        try (Connection con = ConexionDB.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(mapear(rs));
            }

        } catch (SQLException e) {
            System.out.println("Error obteniendo libros: "
                    + e.getMessage());
        }

        return lista;
    }

      /**
     * Busca un libro en la base de datos mediante su identificador.
     *
     * @param id el identificador del libro que se desea buscar
     * @return el libro encontrado o null si no existe
     * @throws SQLException si se produce un error al buscar el libro
     */

    @Override
    public Libro obtenerPorId(String id) {

        String sql = "SELECT * FROM libro WHERE id = ?";

        try (Connection con = ConexionDB.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return mapear(rs);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error obteniendo libro por id: "
                    + e.getMessage());
        }

        return null;
    }

      /**
     * Actualiza los datos de un libro existente en la base de datos.
     *
     * @param objeto el libro con los datos que se desean actualizar
     * @return true si el libro se actualiza correctamente; false si se produce
     * un error durante la actualización
     * @throws SQLException si se produce un error al actualizar el libro
     */

    @Override
    public boolean actualizar(Libro objeto) {

        String sql = "UPDATE libro SET titulo = ?, autor = ?, "
                   + "precio = ?, stock = ? WHERE id = ?";

        try (Connection con = ConexionDB.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, objeto.getTitulo());
            ps.setString(2, objeto.getAutor());
            ps.setDouble(3, objeto.getPrecio());
            ps.setInt(4, objeto.getStock());
            ps.setString(5, objeto.getId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error actualizando libro: "
                    + e.getMessage());
            return false;
        }
    }

    /**
     * Elimina un libro de la base de datos mediante su identificador.
     *
     * @param id el identificador del libro que se desea eliminar
     * @return true si el libro se elimina correctamente; false si se produce
     * un error durante la eliminación
     * @throws SQLException si se produce un error al eliminar el libro
     */
    @Override
    public boolean eliminar(String id) {

        String sql = "DELETE FROM libro WHERE id = ?";

        try (Connection con = ConexionDB.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, id);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error eliminando libro: "
                    + e.getMessage());
            return false;
        }
    }

    /**
     * Busca los libros cuyo título contiene el texto indicado.
     *
     * @param titulo el texto que se desea buscar en el título
     * @return lista de libros cuyo título contiene el texto indicado
     * @throws SQLException si se produce un error al buscar por título
     */

    @Override
    public List<Libro> obtenerPorTitulo(String titulo) {

        List<Libro> lista = new ArrayList<>();

        String sql = "SELECT * FROM libro WHERE titulo LIKE ?";

        try (Connection con = ConexionDB.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + titulo + "%");

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    lista.add(mapear(rs));
                }
            }

        } catch (SQLException e) {
            System.out.println("Error buscando por titulo: "
                    + e.getMessage());
        }

        return lista;
    }

     /**
     * Busca los libros cuyo autor contiene el texto indicado.
     *
     * @param autor el texto que se desea buscar en el autor
     * @return lista de libros cuyo autor contiene el texto indicado
     * @throws SQLException si se produce un error al buscar por autor
     */

    @Override
    public List<Libro> obtenerPorAutor(String autor) {

        List<Libro> lista = new ArrayList<>();

        String sql = "SELECT * FROM libro WHERE autor LIKE ?";

        try (Connection con = ConexionDB.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + autor + "%");

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    lista.add(mapear(rs));
                }
            }

        } catch (SQLException e) {
            System.out.println("Error buscando por autor: "
                    + e.getMessage());
        }

        return lista;
    }

      /**
     * Busca los libros cuyo precio se encuentra entre los valores indicados.
     *
     * @param minimo el precio mínimo de búsqueda
     * @param maximo el precio máximo de búsqueda
     * @return lista de libros cuyo precio se encuentra dentro del intervalo indicado
     * @throws SQLException si se produce un error al buscar por precio
     */

    @Override
    public List<Libro> obtenerPorPrecio(double minimo, double maximo) {

        List<Libro> lista = new ArrayList<>();

        String sql = "SELECT * FROM libro WHERE precio BETWEEN ? AND ?";

        try (Connection con = ConexionDB.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDouble(1, minimo);
            ps.setDouble(2, maximo);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    lista.add(mapear(rs));
                }
            }

        } catch (SQLException e) {
            System.out.println("Error buscando por precio: "
                    + e.getMessage());
        }

        return lista;
    }

    /**
     * Convierte los datos de un resultado de consulta en un objeto Libro.
     *
     * @param rs el resultado de la consulta que contiene los datos del libro
     * @return el objeto Libro creado a partir de los datos obtenidos
     * @throws SQLException si se produce un error al obtener los datos
     * del resultado de la consulta
     */

    private Libro mapear(ResultSet rs) throws SQLException {

        Libro libro = new Libro();

        libro.setId(rs.getString("id"));
        libro.setTitulo(rs.getString("titulo"));
        libro.setAutor(rs.getString("autor"));
        libro.setPrecio(rs.getDouble("precio"));
        libro.setStock(rs.getInt("stock"));

        return libro;
    }
}
