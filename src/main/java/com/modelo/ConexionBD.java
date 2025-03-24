/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.modelo;

/**
 *
 * @author admin
 */
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/SaludVital";
    private static final String USUARIO = "root"; // Tu usuario de MySQL
    private static final String PASSWORD = ""; // Si tienes contraseña en MySQL, agrégala aquí

    public static Connection conectar() {
        try {
            Connection conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            System.out.println("✅ Conexión exitosa a la base de datos.");
            return conexion;
        } catch (SQLException e) {
            System.out.println("❌ Error de conexión: " + e.getMessage());
            return null;
        }
    }
}
