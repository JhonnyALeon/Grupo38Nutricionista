/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author ElAgussYogur
 */
public class Paciente {
    private int idPaciente;
    private int dni;
    private String nombre;
    private String domicilio;
    private int telefono;

    public Paciente() {
    }

    public Paciente(int dni, String nombre, String domicilio, int telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.telefono = telefono;
    }

    public Paciente(int idPaciente, int dni, String nombre, String domicilio, int telefono) {
        this.idPaciente = idPaciente;
        this.dni = dni;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.telefono = telefono;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Paciente{" + "idPaciente=" + idPaciente + ", dni=" + dni + ", nombre=" + nombre + ", domicilio=" + domicilio + ", telefono=" + telefono + '}';
    }
    
    
    
}
