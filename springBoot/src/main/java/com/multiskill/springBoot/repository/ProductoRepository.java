package com.multiskill.springBoot.repository;

import com.multiskill.springBoot.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
