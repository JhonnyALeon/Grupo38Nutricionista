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
import javax.swing.JOptionPane;

/**
 *
 * @author jonat
 */
public class DCData {
    
    private Connection con=null;

    public DCData() {
        con=Conexion.getConexion();
    }
    
    public void GuardarDietaComida(int idDieta, int idComida){
        
        
        String sql="INSERT INTO dietacomida(idComida,idDieta)"
                + "VALUES (?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idComida);
            ps.setInt(3, idDieta);
           
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                
                JOptionPane.showMessageDialog(null, "La comida fué agregada con exito a la dieta");
                

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla DietaComida");
        }
       
    
    }
    
}
