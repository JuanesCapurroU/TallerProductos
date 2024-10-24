package com.example.Proyecto2.Controlador;


import com.example.Proyecto2.Modelo.DetalleProducto;
import com.example.Proyecto2.Servicios.DetalleProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/detalleproductos")
public class DetalleProductoControlador {

    @Autowired
    private DetalleProductoServicio detalleProductoServicio;

    //crear un nuevo Detalle Producto
    @PostMapping("/guardar")
    public ResponseEntity<String> saveDetalleProducto(@RequestBody DetalleProducto detalleProducto){
        DetalleProducto nuevoDetalleProducto = detalleProductoServicio.saveDetalleProducto(detalleProducto);
        return ResponseEntity.ok("Detalle de Producto registrado con exito. ID: "+ nuevoDetalleProducto.getId());
    }
}
