/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * Representa un libro  almacenando su identificador, título, autor, precio y cantidad disponible en stock. 
 * 
 * <p>La clase permite consultar y modificar los datos del libro
 * por sus métodos <code>get</code> y <code>set</code></p>
 * 
 * @author Adrian y Othman
 * @since 1.0 
 */
public class Libro {
   private String id;
   private String titulo;
   private String autor;
   private double precio;
   private int stock;
   /**
     * Crea un libro vacio sin inicializar sus datos.
     *
     * @since 1.0
     */

    public Libro() {
    }

    
    /**
     * Crea un libro inicializando todos sus datos.
     *
     * @param id identificador único del libro
     * @param titulo título del libro
     * @param autor autor del libro
     * @param precio precio del libro
     * @param stock cantidad de unidades disponibles del libro
     * @since 1.0
     */

 
    public Libro(String id, String titulo, String autor, double precio, int stock) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
        this.stock = stock;
    }

    /**
     * Obtiene el identificador del libro.
     *
     * @return identificador del libro
     * @since 1.0
     */
    public String getId() {
        return id;
    }

    /**
     * Obtiene el título del libro.
     *
     * @return título del libro
     * @since 1.0
     */
    
    public String getTitulo() {
        return titulo;
    }

     /**
     * Obtiene el autor del libro.
     *
     * @return autor del libro
     * @since 1.0
     */

    public String getAutor() {
        return autor;
    }

      /**
     * Obtiene el precio actual del libro.
     *
     * @return precio del libro
     * @since 1.0
     */


    public double getPrecio() {
        return precio;
    }

     /**
     * Obtiene la cantidad de unidades disponibles del libro.
     *
     * @return cantidad de unidades disponibles
     * @since 1.0
     */

    public int getStock() {
        return stock;
    }

     /**
     * Modifica el identificador del libro.
     *
     * @param id nuevo identificador del libro
     * @since 1.0
     */

    public void setId(String id) {
        this.id = id;
    }

     /**
     * Modifica el título del libro.
     *
     * @param titulo nuevo título del libro
     * @since 1.0
     */

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

     /**
     * Modifica el autor del libro.
     *
     * @param autor nuevo autor del libro
     * @since 1.0
     */

    public void setAutor(String autor) {
        this.autor = autor;
    }

      /**
     * Modifica el precio del libro.
     *
     * @param precio nuevo precio del libro
     * @since 1.0
     */

    public void setPrecio(double precio) {
        this.precio = precio;
    }

     /**
     * Modifica la cantidad de unidades disponibles del libro.
     *
     * @param stock nueva cantidad de unidades disponibles
     * @since 1.0
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

     /**
     * Genera una representación textual del libro con todos sus datos.
     *
     * @return cadena de texto con el identificador, título, autor, precio y stock
     * @since 1.0
     */
    @Override
    public String toString() {
        return "Libro{" + "id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", precio=" + precio + ", stock=" + stock + '}';
    }
   
   
}
