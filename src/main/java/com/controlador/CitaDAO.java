/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controlador;

/**
 *
 * @author admin
 */

import com.modelo.Cita;
import com.modelo.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CitaDAO {

    // Método para insertar una nueva cita en la base de datos
    public void insertarCita(Cita cita) {
        String sql = "INSERT INTO citas (paciente, medico, fecha, hora, motivo) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cita.getPaciente());
            stmt.setString(2, cita.getMedico());
            stmt.setString(3, cita.getFecha());
            stmt.setString(4, cita.getHora());
            stmt.setString(5, cita.getMotivo());
            stmt.executeUpdate();
            System.out.println("✅ Cita registrada con éxito.");
        } catch (SQLException e) {
        }
    }

    // Método para obtener todas las citas
    public List<Cita> obtenerCitas() {
        List<Cita> lista = new ArrayList<>();
        String sql = "SELECT * FROM citas";
        try (Connection conn = ConexionBD.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Cita cita = new Cita(
                        rs.getInt("id"),
                        rs.getString("paciente"),
                        rs.getString("medico"),
                        rs.getString("fecha"),
                        rs.getString("hora"),
                        rs.getString("motivo")
                );
                lista.add(cita);
            }
        } catch (SQLException e) {
        }
        return lista;
    }

    // Método para actualizar una cita
    public void actualizarCita(Cita cita) {
        String sql = "UPDATE citas SET paciente=?, medico=?, fecha=?, hora=?, motivo=? WHERE id=?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cita.getPaciente());
            stmt.setString(2, cita.getMedico());
            stmt.setString(3, cita.getFecha());
            stmt.setString(4, cita.getHora());
            stmt.setString(5, cita.getMotivo());
            stmt.setInt(6, cita.getId());
            stmt.executeUpdate();
            System.out.println("✅ Cita actualizada con éxito.");
        } catch (SQLException e) {
        }
    }

    // Método para eliminar una cita por ID
    public void eliminarCita(int id) {
        String sql = "DELETE FROM citas WHERE id=?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("✅ Cita eliminada con éxito.");
        } catch (SQLException e) {
        }
    }
}
