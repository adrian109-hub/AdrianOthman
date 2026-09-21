/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import com.sun.jdi.connect.spi.Connection;

/**
 *
 * @author 2DAM
 */
public class ConexionDB {
    private static final String URL="";
    private static final String USER="root";
    private static final String PASS="";
    private static Object DriverManager;
    
    public static Connection getConnection() {
Connection con = null;
try {
con = DriverManager.getConnection(URL, USER, PASS);
} catch (SQLException e) {
System.out.println("Error al conectar con la base de datos: " + e.getMessage());
}
return con;
}

}


