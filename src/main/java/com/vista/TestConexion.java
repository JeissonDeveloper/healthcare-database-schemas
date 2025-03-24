/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vista;

/**
 *
 * @author admin
 */

import com.modelo.ConexionBD; // Asegúrate de que esta línea está presente
import java.sql.Connection;

public class TestConexion {
    public static void main(String[] args) {
        Connection conexion = ConexionBD.conectar();
        if (conexion != null) {
            System.out.println("🎉 Conectado correctamente a MySQL");
        } else {
            System.out.println("⚠️ Falló la conexión a MySQL");
        }
    }
}


