/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.time.LocalDate;

/**
 *
 * @author ElAgussYogur
 */
public class Dieta {
    private int idDieta;
    private String nombre;
    private Paciente paciente;
    private LocalDate fechaI;
    private double pesoI;
    private double pesoF;
    private LocalDate fechaF;

    public Dieta() {
    }

    public Dieta(String nombre, Paciente paciente, LocalDate fechaI, double pesoI, double pesoF, LocalDate fechaF) {
        this.nombre = nombre;
        this.paciente = paciente;
        this.fechaI = fechaI;
        this.pesoI = pesoI;
        this.pesoF = pesoF;
        this.fechaF = fechaF;
    }

    public Dieta(int idDieta, String nombre, Paciente paciente, LocalDate fechaI, double pesoI, double pesoF, LocalDate fechaF) {
        this.idDieta = idDieta;
        this.nombre = nombre;
        this.paciente = paciente;
        this.fechaI = fechaI;
        this.pesoI = pesoI;
        this.pesoF = pesoF;
        this.fechaF = fechaF;
    }

    public int getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(int idDieta) {
        this.idDieta = idDieta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDate getFechaI() {
        return fechaI;
    }

    public void setFechaI(LocalDate fechaI) {
        this.fechaI = fechaI;
    }

    public double getPesoI() {
        return pesoI;
    }

    public void setPesoI(double pesoI) {
        this.pesoI = pesoI;
    }

    public double getPesoF() {
        return pesoF;
    }

    public void setPesoF(double pesoF) {
        this.pesoF = pesoF;
    }

    public LocalDate getFechaF() {
        return fechaF;
    }

    public void setFechaF(LocalDate fechaF) {
        this.fechaF = fechaF;
    }

    @Override
    public String toString() {
        return "Dieta{" + "idDieta=" + idDieta + ", nombre=" + nombre + ", paciente=" + paciente + ", fechaI=" + fechaI + ", pesoI=" + pesoI + ", pesoF=" + pesoF + ", fechaF=" + fechaF + '}';
    }
    
    
}
