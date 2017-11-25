package com.example.maxi.firebaseapp;

import java.util.List;

public class ObjetoComplejo {
    private String nombre;
    private int edad;
    private boolean soltero;
    private List<String> hijos;
    private String apellido;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isSoltero() {
        return soltero;
    }

    public void setSoltero(boolean soltero) {
        this.soltero = soltero;
    }

    public List<String> getHijos() {
        return hijos;
    }

    public void setHijos(List<String> hijos) {
        this.hijos = hijos;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
