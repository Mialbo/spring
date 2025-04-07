package com.multiskill.springBoot.integration;

import com.multiskill.springBoot.model.Producto;
import com.multiskill.springBoot.repository.ProductoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
public class ProductoIntegrationTest {

    @Autowired
    private ProductoRepository productoRepository;

    @Test
    public void testGetProductos() {
        // Preparar datos
        productoRepository.save(new Producto(null, "Camiseta", 10.0));
        productoRepository.save(new Producto(null, "Zapatos", 20.0));

        // Ejecutar
        List<Producto> productos = productoRepository.findAll();

        // Verificar
        assertThat(productos).hasSize(2);
        assertThat(productos.get(0).getNombre()).isEqualTo("Camiseta");
    }
}
