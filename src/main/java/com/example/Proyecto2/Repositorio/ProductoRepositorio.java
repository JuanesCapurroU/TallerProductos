package com.example.Proyecto2.Repositorio;

import com.example.Proyecto2.Modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductoRepositorio extends JpaRepository<Producto, Long> {

    // Obtener producto por descripcion de DetalleProducto
    @Query("SELECT p FROM Producto p WHERE p.detalleProducto.descripcion = :descripcion")
    Optional<Producto> findByDetalleProductoDescripcion(@Param("descripcion") String descripcion);

    // Obtener todos los productos por descripcion de DetalleProducto
    @Query("SELECT p FROM Producto p WHERE p.detalleProducto.descripcion = :descripcion")
    List<Producto> findAllByDetalleProductoDescripcion(@Param("descripcion") String descripcion);

    // Actualizar nombre del producto por ID
    @Modifying
    @Query("UPDATE Producto p SET p.nombre = :nombre WHERE p.id = :id")
    void updateProductoNombre(@Param("id") Long id, @Param("nombre") String nombre);

    // Obtener productos que tienen DetalleProducto
    @Query("SELECT p FROM Producto p INNER JOIN p.detalleProducto d")
    List<Producto> findProductoConDetalleProducto();
}
