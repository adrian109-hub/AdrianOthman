/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import com.sun.jdi.connect.spi.Connection;
import java.sql.DriverManager;
import java.sql.*;



/**
 *
 * @author 2DAM
 */
public class ConexionDB {
    private static final String URL="jdbc:mysql://localhost:3306/librorepositorymysql";
    private static final String USER="root";
    private static final String PASS="";
    private static  DriverManager driverManager;
    
    public static Connection getConnection2() {
Connection con = null;
try {
    
con = (Connection) driverManager.getConnection(URL, USER, PASS);


} catch (SQLException e) {
System.out.println("Error al conectar con la base de datos: " + e.getMessage());
}
return con;
}

}


