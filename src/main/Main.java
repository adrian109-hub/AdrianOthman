package main;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import dao.GenericDao;
import dao.LibroDAOmysql;
import dao.LibroDAOarchivo;
import modelo.Libro;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== SISTEMA DE BIBLIOTECA =====");
        System.out.println("1. Trabajar con archivo");
        System.out.println("2. Trabajar con MySQL");
        System.out.println("0. Salir");
        System.out.print("Elige una opción: ");

        int opcion = sc.nextInt();
        sc.nextLine();

        GenericDao<Libro> repositorio;

        if (opcion == 1) {

            repositorio = new LibroDAOarchivo("libros.txt");

            System.out.println("Has seleccionado el archivo.");

        } else if (opcion == 2) {

            repositorio = new LibroDAOmysql();

            System.out.println("Has seleccionado MySQL.");

        } else {

            System.out.println("Programa finalizado.");

            sc.close();

            return;
        }

        int opcionMenu;

        do {

            System.out.println();
            System.out.println("===== MENÚ =====");
            System.out.println("1. Mostrar todos los libros");
            System.out.println("2. Buscar por título");
            System.out.println("3. Buscar por autor");
            System.out.println("4. Buscar por precio");
            System.out.println("5. Insertar libro");
            System.out.println("6. Eliminar libro por ID");
            System.out.println("7. Actualizar libro");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            opcionMenu = sc.nextInt();
            sc.nextLine();

            switch (opcionMenu) {

                case 1:

                    List<Libro> libros =
                            repositorio.obtenertodos();

                    System.out.println();
                    System.out.println("===== TODOS LOS LIBROS =====");

                    for (Libro libro : libros) {

                        System.out.println(
                                libro.getId() + " | "
                                + libro.getTitulo() + " | "
                                + libro.getAutor() + " | "
                                + libro.getPrecio() + " € | "
                                + libro.getStock()
                        );
                    }

                    break;

                case 2:

                    System.out.print("Introduce el título: ");
                    String titulo = sc.nextLine();

                    List<Libro> porTitulo =
                            repositorio.obtenerPorTitulo(titulo);

                    System.out.println();
                    System.out.println("===== RESULTADOS =====");

                    for (Libro libro : porTitulo) {

                        System.out.println(
                                libro.getId() + " | "
                                + libro.getTitulo() + " | "
                                + libro.getAutor() + " | "
                                + libro.getPrecio() + " € | "
                                + libro.getStock()
                        );
                    }

                    break;

                case 3:

                    System.out.print("Introduce el autor: ");
                    String autor = sc.nextLine();

                    List<Libro> porAutor =
                            repositorio.obtenerPorAutor(autor);

                    System.out.println();
                    System.out.println("===== RESULTADOS =====");

                    for (Libro libro : porAutor) {

                        System.out.println(
                                libro.getId() + " | "
                                + libro.getTitulo() + " | "
                                + libro.getAutor() + " | "
                                + libro.getPrecio() + " € | "
                                + libro.getStock()
                        );
                    }

                    break;

                case 4:

                    System.out.print("Precio mínimo: ");
                    double minimo = sc.nextDouble();

                    System.out.print("Precio máximo: ");
                    double maximo = sc.nextDouble();

                    sc.nextLine();

                    List<Libro> porPrecio =
                            repositorio.obtenerPorPrecio(
                                    minimo,
                                    maximo
                            );

                    System.out.println();
                    System.out.println("===== RESULTADOS =====");

                    for (Libro libro : porPrecio) {

                        System.out.println(
                                libro.getId() + " | "
                                + libro.getTitulo() + " | "
                                + libro.getAutor() + " | "
                                + libro.getPrecio() + " € | "
                                + libro.getStock()
                        );
                    }

                    break;

                case 5:

                    System.out.print("ID: ");
                    String id = sc.nextLine();

                    System.out.print("Título: ");
                    String nuevoTitulo = sc.nextLine();

                    System.out.print("Autor: ");
                    String nuevoAutor = sc.nextLine();

                    System.out.print("Precio: ");
                    double precio = sc.nextDouble();

                    System.out.print("Stock: ");
                    int nuevoStock = sc.nextInt();

                    sc.nextLine();

                    Libro nuevoLibro = new Libro(
                            id,
                            nuevoTitulo,
                            nuevoAutor,
                            precio,
                            nuevoStock
                    );

                    if (repositorio.insertar(nuevoLibro)) {

                        System.out.println(
                                "Libro insertado correctamente."
                        );

                    } else {

                        System.out.println(
                                "No se pudo insertar el libro."
                        );
                    }

                    break;

                case 6:

                    System.out.print(
                            "Introduce el ID del libro que quieres eliminar: "
                    );

                    String idEliminar = sc.nextLine();

                    if (repositorio.eliminar(idEliminar)) {

                        System.out.println(
                                "Libro eliminado correctamente."
                        );

                    } else {

                        System.out.println(
                                "No se encontró ningún libro con ese ID."
                        );
                    }

                    break;

                case 7:

                    System.out.print("ID del libro que quieres actualizar: ");
                    String idActualizar = sc.nextLine();

                    System.out.print("Nuevo título: ");
                    String tituloActualizar = sc.nextLine();

                    System.out.print("Nuevo autor: ");
                    String autorActualizar = sc.nextLine();

                    System.out.print("Nuevo precio: ");
                    double precioActualizar = sc.nextDouble();

                    System.out.print("Nuevo stock: ");
                    int stockActualizar = sc.nextInt();

                    sc.nextLine();

                    Libro libroActualizar = new Libro(
                            idActualizar,
                            tituloActualizar,
                            autorActualizar,
                            precioActualizar,
                            stockActualizar
                    );

                    if (repositorio.actualizar(libroActualizar)) {

                        System.out.println(
                                "Libro actualizado correctamente."
                        );

                    } else {

                        System.out.println(
                                "No se encontró el libro."
                        );
                    }

                    break;

                case 0:

                    System.out.println(
                            "Programa finalizado."
                    );

                    break;

                default:

                    System.out.println(
                            "Opción no válida."
                    );
            }

        } while (opcionMenu != 0);

        sc.close();
    }
}
