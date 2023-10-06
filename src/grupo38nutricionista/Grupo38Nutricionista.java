/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo38nutricionista;

import Conexiones.ComidaData;
import Conexiones.Conexion;
import Conexiones.PacienteData;
import Entidades.Comida;
import Entidades.Paciente;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jonat
 */
public class Grupo38Nutricionista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        try {
//            Class.forName("org.mariadb.jdbc.Driver");
//        } catch (ClassNotFoundException ex) {
//             JOptionPane.showMessageDialog(null, "Error al cargar Driver " + ex.getMessage());
//        }
//        Connection con=Conexion.getConexion();
        
        //PACIENTE
        
       // Paciente paci = new Paciente("Prueba",1111111,"Pruebita 1111",1511111111);
       // PacienteData pac= new PacienteData();
       // pac.guardarPaciente(paci);
       // pac.modificarPaciente(paci);
       // Paciente pacienteEncontrado = pac.buscarPorDni(1234567);
       // if(pacienteEncontrado!= null){
       // System.out.println("dni "+ pacienteEncontrado.getDni());
       // System.out.println("nombre "+ pacienteEncontrado.getNombre());
       // pac.eliminarPaciente(2);
       
       // for(Paciente paciente:pac.listarPacientes()){
            
       //     System.out.println(paciente.getDni());
       //     System.out.println(paciente.getNombre());
       //     System.out.println(paciente.getDomicilio());
       //     System.out.println(paciente.getTelefono());
      
      ///COMIDA
    ComidaData cd=new ComidaData();
    Comida comi =new Comida("pan","cena",500.0,4);
      cd.ModificarComida(comi);

//    Paciente pac=new Paciente("Prueba",1111111,"Pruebita 1111",1511111111);
//    PacienteData pd=new PacienteData();
//   // pd.guardarPaciente(pac);
//
//   System.out.println("hola"+pd.buscarPaciente(1).getNombre());
    }
    
}
