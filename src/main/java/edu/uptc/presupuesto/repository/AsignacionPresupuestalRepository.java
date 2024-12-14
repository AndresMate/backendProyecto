package edu.uptc.presupuesto.repository;

import edu.uptc.presupuesto.model.AsignacionPresupuestal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsignacionPresupuestalRepository extends JpaRepository<AsignacionPresupuestal, Long> {
    List<AsignacionPresupuestal> findByRubroId(Long rubroId);
}