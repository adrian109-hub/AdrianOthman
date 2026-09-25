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

public class LibroDAOmysql implements GenericDao<Libro> {

    @Override
    public boolean insertar(Libro objeto) {

        String sql = "INSERT INTO libros (id, titulo, autor, precio, stock) "
                   + "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = ConexionDB.getConnection();
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

    @Override
    public List<Libro> obtenertodos() {

        List<Libro> lista = new ArrayList<>();

        String sql = "SELECT * FROM libros";

        try (Connection con = ConexionDB.getConnection();
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

    @Override
    public Libro obtenerPorId(String id) {

        String sql = "SELECT * FROM libros WHERE id = ?";

        try (Connection con = ConexionDB.getConnection();
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

    @Override
    public boolean actualizar(Libro objeto) {

        String sql = "UPDATE libros SET titulo = ?, autor = ?, "
                   + "precio = ?, stock = ? WHERE id = ?";

        try (Connection con = ConexionDB.getConnection();
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

    @Override
    public boolean eliminar(String id) {

        String sql = "DELETE FROM libros WHERE id = ?";

        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, id);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error eliminando libro: "
                    + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Libro> obtenerPorTitulo(String titulo) {

        List<Libro> lista = new ArrayList<>();

        String sql = "SELECT * FROM libros WHERE titulo LIKE ?";

        try (Connection con = ConexionDB.getConnection();
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

    @Override
    public List<Libro> obtenerPorAutor(String autor) {

        List<Libro> lista = new ArrayList<>();

        String sql = "SELECT * FROM libros WHERE autor LIKE ?";

        try (Connection con = ConexionDB.getConnection();
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

    @Override
    public List<Libro> obtenerPorPrecio(double minimo, double maximo) {

        List<Libro> lista = new ArrayList<>();

        String sql = "SELECT * FROM libros WHERE precio BETWEEN ? AND ?";

        try (Connection con = ConexionDB.getConnection();
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