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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public void GuardarDietaComida( int idComida, int idDieta){
        
        
        String sql="INSERT INTO dietacomida(idComida,idDieta)"
                + "VALUES (?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idComida);
            ps.setInt(2, idDieta);
           
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                
                JOptionPane.showMessageDialog(null, "La comida fué agregada con exito a la dieta");
                

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla DietaComida");
        }
       
    
    }
    
    public List<Integer> buscarComida(int idDieta){
            String sql=" SELECT idComida FROM dietacomida WHERE idDieta=?";  
            ArrayList<Integer>comidas=new ArrayList<>();
        try {
 
            PreparedStatement ps =con.prepareStatement(sql);
            ps.setInt(1, idDieta);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
            
              comidas.add(rs.getInt("idComida"));
                
                       
            }
        } catch (SQLException ex) {
            

            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla COMIDADIETA");
                    }
        return comidas;
        
    }
    
}
