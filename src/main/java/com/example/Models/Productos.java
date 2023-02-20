package com.example.Models;

public class Productos {
    private int Id;
    private String nombre;
    private float precio;
    private String foto;
    private String categoria;
    private int Favorito;

    public Productos(int id, String nombre, float precio, String foto, String categoria) {
        this.Id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.foto = foto;
        this.categoria = categoria;
    }
    public Productos() {
    }
    
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public int getFavorito() {
        return Favorito;
    }
    public void setFavorito(int favorito) {
        Favorito = favorito;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public String getFoto() {
        return foto;
    }
    public void setFoto(String foto) {
        this.foto = foto;
    }
}

