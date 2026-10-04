/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import modelo.Libro;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Devuelve los métodos que vamos a utilizar en el main e implemntenta el GenericDao para tener los métodos principales
 * y darles como hacerlos
 *
 * @author Adrian y Othman
 * @version 1.0
 * @since 1.0
 */

public class LibroDAOarchivo implements GenericDao<Libro> {
    /**
    * Nombre o ruta del fichero donde se almacenan los libros
    */
    private String archivo;
    /**
    * Crea un objeto {@code LibroDAOarchivo} asociado al fichero indicado
    *
    * @param archivo nombre o ruta del fichero donde se almacenan los libros
    */
    public LibroDAOarchivo(String archivo) {
        this.archivo = archivo;
    }
    /**
     * Con la lista de libros que tengas te da los parámetros de cada uno 
     * 
     * @return Los libros de la "biblioteca" y todos sus datos
     */
    @Override
    public List<Libro> obtenertodos() {

        List<Libro> lista = new ArrayList<>();

        try {

            FileReader leerFichero = new FileReader(archivo);
            Scanner sc = new Scanner(leerFichero);

            while (sc.hasNextLine()) {

                String linea = sc.nextLine();

                String[] datos = linea.split("\\^");

                Libro libro = new Libro(
                        datos[0],
                        datos[1],
                        datos[2],
                        Double.parseDouble(datos[3]),
                        Integer.parseInt(datos[4])
                );

                lista.add(libro);
            }

            sc.close();
            leerFichero.close();

        } catch (IOException ex) {

            System.out.println(
                    "No se ha podido leer el fichero."
            );
        }

        return lista;
    }
    
    /**
     * Inserta un libro a la biblioteca pasandole uno ya completado
     * 
     * @param libro Le pasas un libro ya completo
     * @return {@code true} si el libro se elimina correctamente;
     * {@code false} si se produce algún error
     */
    @Override
    public boolean insertar(Libro libro) {

        PrintWriter out = null;

        try {

            out = new PrintWriter(
                    new FileWriter(archivo, true)
            );

            out.println(
                    libro.getId() + "^"
                    + libro.getTitulo() + "^"
                    + libro.getAutor() + "^"
                    + libro.getPrecio() + "^"
                    + libro.getStock()
            );

            out.close();

            return true;

        } catch (IOException ex) {

            System.out.println(
                    "No se ha podido guardar el fichero."
            );

            return false;
        }
    }
    
    /**
     * Obtiene los valores de un libro por su id
     * 
     * @param id El id del libro que tiene cada uno
     * @return {@code null} si no se encuentra el libro o se produce
     * un error al leer el fichero
     */
    @Override
    public Libro obtenerPorId(String id) {

        try {

            FileReader leerFichero = new FileReader(archivo);
            Scanner sc = new Scanner(leerFichero);

            while (sc.hasNextLine()) {

                String linea = sc.nextLine();

                String[] datos = linea.split("\\^");

                if (datos[0].equals(id)) {

                    Libro libro = new Libro(
                            datos[0],
                            datos[1],
                            datos[2],
                            Double.parseDouble(datos[3]),
                            Integer.parseInt(datos[4])
                    );

                    sc.close();
                    leerFichero.close();

                    return libro;
                }
            }

            sc.close();
            leerFichero.close();

        } catch (IOException ex) {

            System.out.println(
                    "No se ha podido leer el fichero."
            );
        }

        return null;
    }
    /**
     * Elimina un libro del fichero utilizando su id
     * 
     * @param id ide del libro que se desea eliminar
     * @return {@code true} si el libro se elimina correctamente;
     * {@code false} si no se encuentra el libro
     */
    @Override
    public boolean eliminar(String id) {

        List<Libro> lista = obtenertodos();

        boolean eliminado = false;

        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i).getId().equals(id)) {

                lista.remove(i);

                eliminado = true;

                break;
            }
        }

        if (eliminado) {
            guardarTodos(lista);
        }

        return eliminado;
    }
     /**
      * Actualiza los datos de un libro utilizando su id
      * 
      * @param libro Le pasas un libro ya completo para actualizar el contenido
      * @return {@code true} si el libro se ha encontrado correctamente;
      * {@code false} si no se encuentra el libro
      */
    @Override
    public boolean actualizar(Libro libro) {

        List<Libro> lista = obtenertodos();

        boolean actualizado = false;

        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i).getId().equals(libro.getId())) {

                lista.set(i, libro);

                actualizado = true;

                break;
            }
        }

        if (actualizado) {
            guardarTodos(lista);
        }

        return actualizado;
    }
    /**
     * Obtiene los libros que coinciden con el título
     * 
     * @param titulo Escribes el título del libro para recibirlo
     * @return Te devuelve el libro con ese título
     */
    @Override
    public List<Libro> obtenerPorTitulo(String titulo) {

        List<Libro> lista = obtenertodos();

        List<Libro> resultado = new ArrayList<>();

        for (Libro libro : lista) {

            if (libro.getTitulo().equalsIgnoreCase(titulo)) {

                resultado.add(libro);
            }
        }

        return resultado;
    }
    /**
     * Obtiene los libros por el autor
     * 
     * @param autor Escribes el autor para recibir sus libros
     * @return Te devuelve el libro o libros que tenga ese autor en la librería
     */
    @Override
    public List<Libro> obtenerPorAutor(String autor) {

        List<Libro> lista = obtenertodos();

        List<Libro> resultado = new ArrayList<>();

        for (Libro libro : lista) {

            if (libro.getAutor().equalsIgnoreCase(autor)) {

                resultado.add(libro);
            }
        }

        return resultado;
    }
    /**
     * Recibes los libros que esten en un rango de precio que tu expreses
     * 
     * @param minimo El precio mínimo establecido para el rango de los libros
     * @param maximo El precio máximo establecido para el rango de los libros
     * @return Devuelve los libros establecido en el rango de precio
     */
    @Override
    public List<Libro> obtenerPorPrecio(
            double minimo, double maximo) {

        List<Libro> lista = obtenertodos();

        List<Libro> resultado = new ArrayList<>();

        for (Libro libro : lista) {

            if (libro.getPrecio() >= minimo
                    && libro.getPrecio() <= maximo) {

                resultado.add(libro);
            }
        }

        return resultado;
    }
    /**
     * Guarda todos los libros de la lista en el fichero indicado
     * 
     * @param lista lista de libros que se desea guardar en el fichero
     */
    private void guardarTodos(List<Libro> lista) {

        PrintWriter out = null;

        try {

            out = new PrintWriter(
                    new FileWriter(archivo)
            );

            for (Libro libro : lista) {

                out.println(
                        libro.getId() + "^"
                        + libro.getTitulo() + "^"
                        + libro.getAutor() + "^"
                        + libro.getPrecio() + "^"
                        + libro.getStock()
                );
            }

            out.close();

        } catch (IOException ex) {

            System.out.println(
                    "No se ha podido guardar el fichero."
            );
        }
    }
}
