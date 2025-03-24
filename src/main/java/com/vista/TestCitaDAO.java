/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vista;

/**
 *
 * @author admin
 */

import com.controlador.CitaDAO;
import com.modelo.Cita;
import java.util.List;

public class TestCitaDAO {
    public static void main(String[] args) {
        CitaDAO citaDAO = new CitaDAO();

        // Prueba: Insertar una nueva cita
        Cita nuevaCita = new Cita(0, "Juan Pérez", "Dra. Gómez", "2024-03-15", "10:00", "Consulta general");
        citaDAO.insertarCita(nuevaCita);

        // Prueba: Obtener todas las citas
        List<Cita> citas = citaDAO.obtenerCitas();
        System.out.println("📌 Lista de citas registradas:");
        for (Cita cita : citas) {
            System.out.println(cita.getId() + " - " + cita.getPaciente() + " - " + cita.getMedico());
        }

        // Prueba: Actualizar una cita (asumimos que hay una cita con ID 1)
        Cita citaActualizada = new Cita(1, "Juan Pérez", "Dr. Ramírez", "2024-03-16", "11:00", "Control de rutina");
        citaDAO.actualizarCita(citaActualizada);

        // Prueba: Eliminar una cita (asumimos que hay una cita con ID 2)
        citaDAO.eliminarCita(2);
    }
}
