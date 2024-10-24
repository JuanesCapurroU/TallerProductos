package com.example.Proyecto2.Servicios;

import com.example.Proyecto2.Modelo.DetalleProducto;
import com.example.Proyecto2.Repositorio.DetalleProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleProductoServiciolmpl implements DetalleProductoServicio{

    @Autowired
    private DetalleProductoRepositorio detalleProductoRepositorio;

    @Override
    public DetalleProducto saveDetalleProducto(DetalleProducto detalleProducto){
        return detalleProductoRepositorio.save(detalleProducto);
    }
}
