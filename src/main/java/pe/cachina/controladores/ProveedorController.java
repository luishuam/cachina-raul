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
import pe.cachina.entidades.Proveedor;
import pe.cachina.entidades.ProveedorRequest;
import pe.cachina.repositorios.ProveedorRepository;

@RestController
@RequestMapping("proveedores")
@AllArgsConstructor
public class ProveedorController {

    ProveedorRepository proveedorRepository;

    /* Listado filtrando status */
    @GetMapping
    public List<Proveedor> listAll() {

        return proveedorRepository.listByStatus();
    }

    /* Listado filtrando status */
    @GetMapping("eliminados")
    public List<Proveedor> listEliminados() {

        return proveedorRepository.listEliminados();
    }

    /* Insert */
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Long insertProveedor(@RequestBody @Valid ProveedorRequest proveedorRequest) {
        Proveedor proveedor = new Proveedor();

        proveedor.setNombre(proveedorRequest.getName());
        proveedor.setDescripcion(proveedorRequest.getDescription());
        proveedor.setDni(proveedorRequest.getDni());
        proveedor.setCategoria(proveedorRequest.getCategory());
        proveedor.setEstado(proveedorRequest.getStatus());

        Proveedor proveedorGuardado = proveedorRepository.save(proveedor);
        return proveedorGuardado.getId();

    }

    /* Update */
    @PutMapping("{id}")
    public ResponseEntity<Proveedor> modificar(@PathVariable Long id,
            @RequestBody @Valid ProveedorRequest proveedorRequest) {

        return proveedorRepository.findById(id).map(proveedor -> {

            proveedor.setNombre(proveedorRequest.getName());
            proveedor.setDescripcion(proveedorRequest.getDescription());
            proveedor.setDni(proveedorRequest.getDni());
            proveedor.setCategoria(proveedorRequest.getCategory());
            proveedor.setEstado(proveedorRequest.getStatus());

            proveedorRepository.save(proveedor);

            return ResponseEntity.ok(proveedor);

        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /* Soft Delete */
    @DeleteMapping("{id}")
    public String deleteByEstado(@PathVariable Long id) {
        proveedorRepository.deleteByStatus(id);

        return id + " inactivo";
    }
}
