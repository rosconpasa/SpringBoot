package com.prueba.demo.modelo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity //JPA la identifica como una tabla
public class Producto {

    @Id //define el campo id como llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremento
    private Long id;
    
    private String nombre;
    private double precio;

    public Producto(){}

    public Producto(String nombre, double precio){
        this.nombre = nombre;
        this.precio = precio;
    }

    public Long getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public double getPrecio(){
        return precio;
    }

    public void setPrecio(double precio){
        this.precio=precio;
    }


}
