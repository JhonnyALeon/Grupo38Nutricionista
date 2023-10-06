
package Conexiones;

import Entidades.Dieta;
import Entidades.Paciente;
import java.sql.Connection;
import java.sql.Date;
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
 *  int idDieta;
    String nombre;
    Paciente paciente;
    LocalDate fechaI;
    double pesoI;
    double pesoF;
    double pesoA;
    LocalDate fechaF;
    boolean estado;
 */
public class DietaData {
    
    private Connection con=null;

    public DietaData() {
        con=Conexion.getConexion();
    }
    
    public void GuardarDieta(Dieta dieta){
        
        String sql=" INSERT INTO dieta(nombre, idPaciente, estado, fechaI, pesoI,"
                + " pesoAc, pesoF, fechaF)"
                + "VALUES (?,?,?,?,?,?,?,?)";
        
         try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, dieta.getNombre());
            ps.setInt(2, dieta.getPaciente().getIdPaciente());
            ps.setBoolean(3, true);
            ps.setDate(4, Date.valueOf(dieta.getFechaI()));
            ps.setDouble(5, dieta.getPesoI());
            ps.setDouble(6, dieta.getPesoA());
            ps.setDouble(7, dieta.getPesoF());
            ps.setDate(8, Date.valueOf(dieta.getFechaF()));
            
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {

                dieta.setIdDieta(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Régimen creado con exito");

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la BD");
        }
    }
    
    public Dieta BuscarDieta(int Dni){
        
        PacienteData pd=new PacienteData();
        Paciente pc=pd.buscarPorDni(Dni);
        int id=pc.getIdPaciente();
        
        String sql= " SELECT * FROM dieta WHERE idPaciente=? ";
        
        Dieta dieta=null;
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs= ps.executeQuery();
            
            if(rs.next()){
                dieta=new Dieta();
                dieta.setIdDieta(rs.getInt("idDieta"));
                dieta.setNombre(rs.getString("nombre"));
                dieta.setPaciente(pc);
                dieta.setPesoA(rs.getDouble("pesoAc"));
                dieta.setPesoF(rs.getDouble("pesoF"));
                dieta.setPesoI(rs.getDouble("pesoI"));
                dieta.setFechaI(rs.getDate("fechaI").toLocalDate());
                dieta.setFechaF(rs.getDate("fechaF").toLocalDate());
                if(rs.getInt("estado")==1){
                    dieta.setEstado(true);
                }
                
            }else{
                JOptionPane.showMessageDialog(null,"El paciente no registra dieta" );
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la BD");
        }
        return dieta;
        
    }
    
    
    
    
}
