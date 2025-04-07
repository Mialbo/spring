package com.multiskill.springBoot.service;

import com.multiskill.springBoot.model.Producto;
import com.multiskill.springBoot.repository.ProductoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductoServiceTest {

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ProductoService productoService;

    @Test
    void testGetAllProductos() {
        List<Producto> productos = List.of(
                new Producto("Producto A", 10.0),
                new Producto("Producto B", 15.0)
        );

        when(productoRepository.findAll()).thenReturn(productos);

        List<Producto> resultado = productoService.getAllProductos(); // usa el nombre correcto

        assertEquals(2, resultado.size());
        verify(productoRepository, times(1)).findAll();
    }
}
