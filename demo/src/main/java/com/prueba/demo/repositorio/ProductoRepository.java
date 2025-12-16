package com.prueba.demo.repositorio;

import com.prueba.demo.modelo.Producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

// Heredamos de JpaRepository<[Clase de la Entidad], [Tipo de la Llave Primaria]>
public interface ProductoRepository extends JpaRepository<Producto, Long> { 
    
}
