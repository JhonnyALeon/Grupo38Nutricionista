/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;

import Entidades.Comida;
import java.sql.Connection;
import java.sql.Date;
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
 * @author jonat
 */
public class ComidaData {
    private Connection con=null;

    public ComidaData() {
        con=Conexion.getConexion();
    }
    
    public void GuardarComida(Comida com){
        String sql="INSERT INTO comida(nombre,detalle,calorias)"
                + "VALUES (?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, com.getNombre());
            ps.setString(2, com.getDetalle());
            ps.setDouble(3, com.getCalorias());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                com.setIdComida(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Nueva Comida registrada con exito");
                

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Comida");
        }
       
    }
    
    public Comida BuscarComidaID(int id){
        
        String sql = " SELECT * FROM comida WHERE idComida = ? ";
        Comida comi=null;
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                comi=new Comida();
                comi.setNombre(rs.getString("nombre"));
                comi.setDetalle(rs.getString("detalle"));
                comi.setCalorias(rs.getDouble("calorias"));
            }else{
                JOptionPane.showMessageDialog(null,"No existe ese plato" );
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la BD" );
        }
        return comi;
    }
    
    public List<Comida> MenosCalorias(int cal){
        
        String sql=" SELECT * FROM comida WHERE calorias <= ?";
        ArrayList<Comida>comidas=new ArrayList<>();
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, cal);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Comida com =new Comida();
                com.setNombre(rs.getString("nombre"));
                com.setCalorias(rs.getDouble("calorias"));
                com.setDetalle(rs.getString("detalle"));
                com.setIdComida(rs.getInt("idComida"));
                
                comidas.add(com);
                
            }
            ps.close();
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error al acceder a la BD COMIDA");
        }
        return comidas;
    }
            
    public List<Comida> MasCalorias(int cal){
        
        String sql=" Select * FROM comida WHERE calorias >= ?";
        ArrayList<Comida>comidas=new ArrayList<>();
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, cal);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Comida com =new Comida();
                com.setNombre(rs.getString("nombre"));
                com.setCalorias(rs.getDouble("calorias"));
                com.setDetalle(rs.getString("detalle"));
                com.setIdComida(rs.getInt("idComida"));
                
                comidas.add(com);
                
            }
            ps.close();
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error al acceder a la BD COMIDA");
        }
        return comidas;
    }       
    
    public void ModificarComida(Comida comida){
        
        String sql = "UPDATE comida SET nombre=?,detalle=?,calorias=? "
                + " WHERE idComida = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, comida.getNombre());
            ps.setString(2, comida.getDetalle());
            ps.setDouble(3, comida.getCalorias());
            ps.setInt(4,comida.getIdComida());

            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Comida modificada exitosamente");

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla Comida");
        }
    }
    
    public void EliminarComida(int id){
        String sql="DELETE FROM comida WHERE idComida=?";
        
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            int var=(ps.executeUpdate());
            if(var==1){
            JOptionPane.showMessageDialog(null,"Plato borrado exitosamente");
               
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la base de datos");
        }
    }
    
    public Comida BuscarComidaNombre(String nombre){
        
        String sql = " SELECT * FROM comida WHERE nombre = ? ";
        Comida comi=null;
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                comi=new Comida();
                comi.setNombre(rs.getString("nombre"));
                comi.setDetalle(rs.getString("detalle"));
                comi.setCalorias(rs.getDouble("calorias"));
                comi.setIdComida(rs.getInt("idComida"));
            }else{
                JOptionPane.showMessageDialog(null,"No existe ese plato" );
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la BD" );
        }
        return comi;
    
    }
    
    
    
    
}
