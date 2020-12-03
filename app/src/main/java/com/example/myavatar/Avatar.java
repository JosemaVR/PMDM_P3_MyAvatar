package com.example.myavatar;

import java.util.Random;

public class Avatar {

    public String nombre, sexo, especie, profesion;
    public int vida, magia, fuerza, velocidad;

    public Avatar(){
        this.nombre = "";
        this.sexo = "";
        this.especie = "";
        this.profesion = "";
        Random r = new Random();
        this.vida = (int) (r.nextDouble()*100);
        this.magia = (int) (r.nextDouble()*10);
        this.fuerza = (int) (r.nextDouble()*20);
        this.velocidad = (int) (r.nextDouble()*5);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getMagia() {
        return magia;
    }

    public void setMagia(int magia) {
        this.magia = magia;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public String toString(){
        return nombre + " - " + sexo + " - " + especie + " - " + profesion + " // " +
                vida + " - " + magia + " - " + fuerza + " - " + velocidad;
    }
}
