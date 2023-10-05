/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;

import Entidades.Comida;
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
            
        
        
    
    
    
    
}
