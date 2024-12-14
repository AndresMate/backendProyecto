package edu.uptc.presupuesto.repository;

import edu.uptc.presupuesto.model.Alerta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlertaRepository extends JpaRepository<Alerta, Long> {
    List<Alerta> findByAsignacionId(Long asignacionId);
}