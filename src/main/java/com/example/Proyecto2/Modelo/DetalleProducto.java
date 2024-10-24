package com.example.Proyecto2.Modelo;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
public class DetalleProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private String caracteristicas;

    @OneToOne
    @JoinColumn(name="producto_id")
    @JsonBackReference
    private Producto producto;

    public DetalleProducto() {
    }

    public DetalleProducto(Long id, String descripcion, String caracteristicas) {
        this.id = id;
        this.descripcion = descripcion;
        this.caracteristicas = caracteristicas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    @Override
    public String toString() {
        return "DetalleProducto{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", caracteristicas='" + caracteristicas + '\'' +
                '}';
    }
}

