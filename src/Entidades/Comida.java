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
public class Comida {
    
    private String nombre;
    private String detalle;
    private double calorias;
    private int idComida;

    public Comida() {
    }

    public Comida(String nombre, String detalle, double calorias) {
        this.nombre = nombre;
        this.detalle = detalle;
        this.calorias = calorias;
    }

    public Comida(String nombre, String detalle, double calorias, int idComida) {
        this.nombre = nombre;
        this.detalle = detalle;
        this.calorias = calorias;
        this.idComida = idComida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    public int getIdComida() {
        return idComida;
    }

    public void setIdComida(int idComida) {
        this.idComida = idComida;
    }

    @Override
    public String toString() {
        return "Comida: "+nombre+" Cant. de calorias: "+calorias+" "+detalle;
    }
    
    
    
}
