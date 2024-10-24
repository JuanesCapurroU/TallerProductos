package com.example.Proyecto2.Controlador;

import com.example.Proyecto2.Modelo.Producto;
import com.example.Proyecto2.Servicios.ProductoServicio;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductoControlador {

    @Autowired
    private ProductoServicio productoServicio;

    //Obtener un producto por su ID
    @GetMapping("/{id}")
    public Optional<Producto> getProductoByID(@PathVariable Long id){
        return productoServicio.getProductoById(id);
    }

    //Obtener Todos los productos
    @GetMapping("/todos")
    public List<Producto> getAllProductos(){
        return productoServicio.getAllProductos();
    }

    //1
    //Obtener producto por descripcion del DetalleProducto
    @GetMapping("/detalleproducto/descripcion/{descripcion}")
    public Optional<Producto> getProductoByDetalleProductosDescripcion(@PathVariable String descripcion){
        return productoServicio.getProductoByDetalleProductoDescripcion(descripcion);
    }

    //2
    //Obtener todos los productos por descripcion del DetalleProducto
    @GetMapping("/detalleproducto/descripcion/all/{descripcion}")
    public List<Producto> getProductosByDetalleProductosDescripcion(@PathVariable String descripcion){
        return productoServicio.getProductosByDetalleProductoDescripcion(descripcion);
    }

    //Crear un producto
    @PostMapping("/guardar")
    public ResponseEntity<String> saveProducto(@RequestBody Producto producto){
        Producto savedProducto = productoServicio.saveProducto(producto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Producto Creado con exito ID: "+ savedProducto.getId());

    }
    //3
    //Actualizar nombre del producto por ID
    @PutMapping("/{id}/actualizarNombre")
    public void updateProductoNombre(@PathVariable Long id, @RequestParam String nombre){
        productoServicio.updateProductoNombre(id, nombre);
    }

    //Eliminar Producto por ID
    @DeleteMapping("/eliminar/{id}")
    public void deleteProducto(@PathVariable Long id){
        productoServicio.deleteProducto(id);
    }

    //Obtener productos con detalleProducto
    @GetMapping("/con-detalleProducto")
    public ResponseEntity<List<Producto>> getProductosConDetalleProducto(){
        List<Producto> productos= productoServicio.getProductosConDetalleProducto();
        return ResponseEntity.ok(productos);
    }


}
