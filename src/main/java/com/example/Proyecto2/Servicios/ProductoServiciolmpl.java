package com.example.Proyecto2.Servicios;

import com.example.Proyecto2.Modelo.Producto;
import com.example.Proyecto2.Repositorio.ProductoRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiciolmpl implements ProductoServicio {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Override
    public Optional<Producto> getProductoById(Long id){
        return productoRepositorio.findById(id);
    }
    @Override
    public List<Producto> getAllProductos(){
        return productoRepositorio.findAll();
    }
    //1
    @Override
    public Optional<Producto> getProductoByDetalleProductoDescripcion(String descripcion){
        return productoRepositorio.findByDetalleProductoDescripcion(descripcion);

    }
    //2
    @Override
    public List<Producto> getProductosByDetalleProductoDescripcion(String descripcion) {
    return productoRepositorio.findAllByDetalleProductoDescripcion(descripcion);
    }
    @Override
    public Producto saveProducto(Producto producto){
        return productoRepositorio.save(producto);
    }
    // 3
    @Override
    @Transactional
    public void updateProductoNombre(Long id, String nombre){
        productoRepositorio.updateProductoNombre(id, nombre);
    }

    @Override
    public void deleteProducto(Long id){productoRepositorio.deleteById(id);}

    @Override
    public List<Producto> getProductosConDetalleProducto(){
        return productoRepositorio.findProductoConDetalleProducto();
    }



}
