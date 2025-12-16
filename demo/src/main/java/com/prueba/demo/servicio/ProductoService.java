package com.prueba.demo.servicio;

import java.util.Optional;
import java.util.List;

import org.springframework.stereotype.Service;
import com.prueba.demo.repositorio.ProductoRepository;
import com.prueba.demo.modelo.Producto;


@Service
public class ProductoService {

    private final ProductoRepository repository;
    
    // Inyección de dependencia por contructor
    public ProductoService(ProductoRepository repository){
        this.repository = repository;
    }

    public Producto crearProducto(Producto producto){
        return repository.save(producto);
    }

    public List<Producto> obtenerTodos(){
        return repository.findAll();
    }

    public Optional<Producto> obtenerPorId(Long id){
        return repository.findById(id);
    }

    public Producto actualizarProducto(Long id, Producto productoDetalles){
        Producto producto = repository.findById(id).orElse(null);

        if(producto != null){
            producto.setNombre(productoDetalles.getNombre());
            producto.setPrecio(productoDetalles.getPrecio());
            return repository.save(producto);
        }
        return null;

    }

    public void eliminarProducto(Long id){
        repository.deleteById(id);
    }
}
