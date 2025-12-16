package com.prueba.demo.controlador;



import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.demo.servicio.ProductoService;
import com.prueba.demo.modelo.Producto;
import java.util.List;

@RestController
@RequestMapping("/api/productos") //Prefijo para todos los endpoints
public class ProductoController {

    private final ProductoService service;

    //Inyección de dependencias
    public ProductoController(ProductoService service){
        this.service=service;
    }

    //Crear producto
    @PostMapping //mapea a POST /api/productos
    public Producto crearProducto(@RequestBody Producto producto){
        return service.crearProducto(producto);
    }

    //Obtener todos
    @GetMapping
    public List<Producto> obtenerTodos(){
        return service.obtenerTodos();
    }

    //Obtener por id
    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerPorId(@PathVariable Long id){
        //Usa ResponseEntity para manejar el código de estado HTTP
        return service.obtenerPorId(id)
            .map(prodcuto -> ResponseEntity.ok(prodcuto))//Si existe, retornar 200 OK
            .orElse(ResponseEntity.notFound().build()); // Si no existe, retornar 404 NOT FOUND
    }

    //Actualizar Producto
    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @RequestBody Producto producto){
        Producto productoActualizado = service.actualizarProducto(id, producto);
        if (productoActualizado != null) {
            return ResponseEntity.ok(productoActualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id){
        service.eliminarProducto(id);
            return ResponseEntity.noContent().build(); //Retorna 204 No Content
        
    }
}
