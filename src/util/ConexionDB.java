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
 * @author Adiran y Othman
 * @since 1.0
 */

public class ConexionDB {

 /**
 * Establece una conexión con la base de datos utilizando
 * la URL, el usuario y la contraseña configurados.
 *
 * @return la conexión establecida con la base de datos,
 * {@code null} si se produce un error al conectar
 * @throws Exception si se produce un error durante la conexión
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