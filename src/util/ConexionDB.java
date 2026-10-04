/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import io.github.cdimascio.dotenv.Dotenv;
/**
 * Proporciona métodos para establecer conexiones con la base de datos
 * utilizando las credenciales configuradas en las variables de entorno.
 *
 * <p>La conexión utiliza la URL, el usuario y la contraseña definidos
 * mediante las variables de entorno <code>DB_URL</code>,
 * <code>DB_USER</code> y <code>DB_PASSWORD</code> y con estos se completa
 * automáticamente con .env</p>
 * 
 * @author Adrian y Othman
 * @since 1.0
 */

public class ConexionDB {

 /**
 * Establece una conexión con la base de datos utilizando
 * la URL, el usuario y la contraseña configurados.
 *
 * @return la conexión establecida con la base de datos,
 * {@code null} si se produce un error al conectar
 */
    
    public static Connection getConexion() {

        Dotenv dotenv = Dotenv.load();

        String url = dotenv.get("DB_URL");
        String usuario = dotenv.get("DB_USER");
        String contraseña = dotenv.get("DB_PASSWORD");

        try {
            return DriverManager.getConnection(url, usuario, contraseña);
        } catch (Exception e) {
            System.out.println("Error al conectar con la base de datos.");
            System.out.println(e.getMessage());
            return null;
        }
    }

    
}