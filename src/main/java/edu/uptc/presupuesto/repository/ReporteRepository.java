package edu.uptc.presupuesto.repository;

import edu.uptc.presupuesto.model.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReporteRepository extends JpaRepository<Reporte, Long> {
    List<Reporte> findByUsuarioId(Long usuarioId);
}