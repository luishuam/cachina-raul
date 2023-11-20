package pe.cachina.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import pe.cachina.entidades.Producto;
import pe.cachina.entidades.ProductoRequest;
import pe.cachina.repositorios.ProductoRepository;

@RestController
@RequestMapping("productos")
@AllArgsConstructor
public class ProductoController {

    ProductoRepository productoRepository;

    // /* Listado */
    // @GetMapping
    // public List<Producto> listAll() {

    // return productoRepository.findAll();
    // }

    /* Listado filtrando status */
    @GetMapping
    public List<Producto> listAll() {

        return productoRepository.listByStatus();
    }

    /* Listado filtrando status */
    @GetMapping("eliminados")
    public List<Producto> listEliminados() {

        return productoRepository.listEliminados();
    }

    /* Insert */
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Long insertProducto(@RequestBody @Valid ProductoRequest productoRequest) {
        Producto producto = new Producto();

        producto.setNombre(productoRequest.getName());
        producto.setDescripcion(productoRequest.getDescription());
        producto.setFecha(productoRequest.getAdquisitionDate());
        producto.setPrecio(productoRequest.getPrice());
        producto.setStock(productoRequest.getStock());
        producto.setEstado(productoRequest.getStatus());

        Producto productoGuardado = productoRepository.save(producto);
        return productoGuardado.getId();

    }

    /* Update */
    @PutMapping("{id}")
    public ResponseEntity<Producto> modificar(@PathVariable Long id,
            @RequestBody @Valid ProductoRequest productoRequest) {

        return productoRepository.findById(id).map(producto -> {

            producto.setNombre(productoRequest.getName());
            producto.setDescripcion(productoRequest.getDescription());
            producto.setFecha(productoRequest.getAdquisitionDate());
            producto.setPrecio(productoRequest.getPrice());
            producto.setStock(productoRequest.getStock());
            producto.setEstado(productoRequest.getStatus());

            productoRepository.save(producto);

            return ResponseEntity.ok(producto);

        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // /* Hard Delete */
    // @DeleteMapping("{id}")
    // public void deleteById(@PathVariable Long id) {
    // productoRepository.deleteById(id);

    // }

    /* Soft Delete */
    @DeleteMapping("{id}")
    public String deleteByEstado(@PathVariable Long id) {
        productoRepository.deleteByStatus(id);

        return id + " inactivo";
    }
}
