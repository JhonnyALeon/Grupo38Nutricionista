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
import java.util.ArrayList;
import java.util.List;
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
        if (rs.next()){
            
            paciente.setIdPaciente(rs.getInt(1));
            JOptionPane.showMessageDialog(null, "Paciente guardado");
            
        
         
        }
        ps.close();
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la base de datos");
        }
        
    }
    
    public void modificarPaciente (Paciente paciente){
        String sql="UPDATE paciente SET nombre=?, dni=?, domicilio=?,telefono=? "
                + "WHERE idPaciente=?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, paciente.getNombre());
            ps.setInt(2,paciente.getDni() );
            ps.setString(3,paciente.getDomicilio());
            ps.setInt(4, paciente.getTelefono());
            ps.setInt(5, paciente.getIdPaciente());
            
            int exito = ps.executeUpdate();
            if(exito==1) {
                JOptionPane.showMessageDialog(null,"Paciente modificado");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla Paciente");
        }
        
    }
    public void eliminarPaciente (int id){
        String sql=  "DELETE FROM paciente WHERE idPaciente=?";
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, id);
            int var = (ps.executeUpdate());
            if(var==1){
                JOptionPane.showMessageDialog(null, "Paciente eliminado");
            }
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de datos");
        }
       
        }
        public void buscarPaciente(int id){
            String sql= "SELECT nombre , dni , domicilio , telefono FROM paciente WHERE idPaciente=?";
            Paciente paciente = null;
            
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                
                paciente= new Paciente();
                paciente.setIdPaciente(id);
                paciente.setNombre(rs.getString("nombre"));
                paciente.setDni(rs.getInt("dni"));
                paciente.setDomicilio(rs.getString("domicilio"));
                paciente.setTelefono(rs.getInt("telefono"));
            }else{
                JOptionPane.showMessageDialog(null,"No existe el Paciente");
                
               }
            ps.close();
            
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de datos");
        }
        
        }
        public Paciente buscarPorDni (int dni){
            String sql= "SELECT idPaciente , nombre ,dni ,domicilio ,telefono FROM paciente WHERE dni=?";
            Paciente paciente = null;
            
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                
                paciente = new Paciente();
                paciente.setIdPaciente(rs.getInt("idPaciente"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setDni(rs.getInt("dni"));
                paciente.setDomicilio(rs.getString("domicilio"));
                paciente.setTelefono(rs.getInt("telefono"));
                
                
            }else{
                JOptionPane.showMessageDialog(null,"No existe el Paciente");
            }
            ps.close();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de datos");
        }
            return paciente;
        }   
    public List<Paciente> listarPacientes(){
        String sql= "SELECT idPaciente , nombre , dni , domicilio, telefono FROM paciente WHERE 1 ";
        ArrayList<Paciente> pacientes = new ArrayList<>();
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                Paciente paciente = new Paciente();
                paciente.setIdPaciente(rs.getInt("idPaciente"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setDni(rs.getInt("dni"));
                paciente.setDomicilio(rs.getString("domicilio"));
                paciente.setTelefono(rs.getInt("telefono"));
                
                pacientes.add(paciente);
                        
            }
            ps.close();
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de datos");
        }
        return pacientes;
        
    }
}

    

