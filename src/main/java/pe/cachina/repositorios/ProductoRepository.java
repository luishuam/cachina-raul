package pe.cachina.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import pe.cachina.entidades.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    // Soft delete
    @Query("select p from Producto as p where estado = true")
    List<Producto> listByStatus();

    @Modifying
    @Transactional
    @Query("update Producto p set p.estado = false where p.id = :id")
    void deleteByStatus(Long id);

    @Query("select p from Producto as p where estado = false")
    List<Producto> listEliminados();
}
