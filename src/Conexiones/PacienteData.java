/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;

import Entidades.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author W10-PC
 */
public class PacienteData {
    
    private Connection con = null;

    public PacienteData() {
        con=Conexion.getConexion();
        
    }
    public void guardarPaciente (Paciente paciente){
        String sql="INSERT INTO paciente (nombre, dni ,domicilio , telefono)"
                + "VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, paciente.getNombre());
        ps.setInt(2, paciente.getDni() );
        ps.setString(3, paciente.getDomicilio());
        ps.setInt(4, paciente.getTelefono());
        ps.executeUpdate();
        
        ResultSet rs = ps.getGeneratedKeys();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la base de datos");
        }
        
                
        
    }
    
    
    
}
