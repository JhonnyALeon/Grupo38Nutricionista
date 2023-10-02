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
public class DietaComida {
    
     private Comida comida;
    private int idDietaComida;
    private Dieta dieta;

    public DietaComida() {
    }

    public DietaComida(Comida comida, Dieta dieta) {
        this.comida = comida;
        this.dieta = dieta;
    }

    public DietaComida(Comida comida, int idDietaComida, Dieta dieta) {
        this.comida = comida;
        this.idDietaComida = idDietaComida;
        this.dieta = dieta;
    }

    public Comida getComida() {
        return comida;
    }

    public void setComida(Comida comida) {
        this.comida = comida;
    }

    public int getIdDietaComida() {
        return idDietaComida;
    }

    public void setIdDietaComida(int idDietaComida) {
        this.idDietaComida = idDietaComida;
    }

    public Dieta getDieta() {
        return dieta;
    }

    public void setDieta(Dieta dieta) {
        this.dieta = dieta;
    }

    @Override
    public String toString() {
        return "DietaComida{" + "comida=" + comida + ", idDietaComida=" + idDietaComida + ", dieta=" + dieta + '}';
    }
    
    
    
}
