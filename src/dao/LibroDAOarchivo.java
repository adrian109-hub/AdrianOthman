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

public class LibroDAOarchivo implements GenericDao<Libro> {

    private String archivo;

    public LibroDAOarchivo(String archivo) {
        this.archivo = archivo;
    }

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
