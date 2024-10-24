package com.example.Proyecto2.Servicios;

import com.example.Proyecto2.Modelo.DetalleProducto;
import com.example.Proyecto2.Modelo.Producto;

import java.util.Optional;
import java.util.List;

public interface ProductoServicio {


    Optional<Producto> getProductoById(Long id);

    List<Producto> getAllProductos();

    // 1
    Optional<Producto> getProductoByDetalleProductoDescripcion(String descripcion);

    // 2
    List<Producto> getProductosByDetalleProductoDescripcion(String descripcion);

    Producto saveProducto(Producto producto);
    // 3
    void updateProductoNombre(Long id, String nombre);

    void deleteProducto(Long id);


    List<Producto> getProductosConDetalleProducto();
}

