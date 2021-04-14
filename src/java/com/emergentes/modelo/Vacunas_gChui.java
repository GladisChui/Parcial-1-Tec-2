
package com.emergentes.modelo;

/**
 *
 * @author Andrea
 */
public class Vacunas_gChui {
    private int id;
    private String nombre;
    private double peso;
    private int talla;
    private String vacuna;

    public Vacunas_gChui() {
        id = 0;
        nombre = "";
        peso = 0.0;
        talla = 0;
        vacuna = "";
    }
    

    public Vacunas_gChui(int id, String nombre, double peso, int talla, String vacuna) {
        this.id = id;
        this.nombre = nombre;
        this.peso = peso;
        this.talla = talla;
        this.vacuna = vacuna;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getTalla() {
        return talla;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }

    public String getVacuna() {
        return vacuna;
    }

    public void setVacuna(String vacuna) {
        this.vacuna = vacuna;
    }
    
    
    
}
