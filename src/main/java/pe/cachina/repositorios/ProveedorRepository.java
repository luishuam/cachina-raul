package pe.cachina.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import pe.cachina.entidades.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {

    // Soft delete
    @Query("select v from Proveedor as v where estado = true")
    List<Proveedor> listByStatus();

    @Modifying
    @Transactional
    @Query("update Proveedor v set v.estado = false where v.id = :id")
    void deleteByStatus(Long id);

    @Query("select v from Proveedor as v where estado = false")
    List<Proveedor> listEliminados();
}
