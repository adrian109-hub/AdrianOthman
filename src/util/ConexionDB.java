/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import io.github.cdimascio.dotenv.Dotenv;

public class ConexionDB {

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