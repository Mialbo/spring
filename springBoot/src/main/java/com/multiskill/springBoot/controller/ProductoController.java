package com.multiskill.springBoot.controller;

import com.multiskill.springBoot.model.Producto;
import com.multiskill.springBoot.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> obtenerProductos() {
        return productoService.getAllProductos(); // usa el nombre correcto
    }

    @PostMapping
    public Producto guardarProducto(@RequestBody Producto producto) {
        return productoService.guardarProducto(producto);
    }

    @GetMapping("/{id}")
    public Producto obtenerProductoPorId(@PathVariable Long id) {
        return productoService.obtenerProductoPorId(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
    }
}
