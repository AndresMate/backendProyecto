package edu.uptc.presupuesto.repository;

import edu.uptc.presupuesto.model.RubroPresupuestal;
import edu.uptc.presupuesto.model.EstadoRubro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RubroPresupuestalRepository extends JpaRepository<RubroPresupuestal, Long> {
    // Buscar rubros por estado
    List<RubroPresupuestal> findByEstado(EstadoRubro estado);

    // Buscar rubros próximos a vencer
    @Query("SELECT r FROM RubroPresupuestal r WHERE r.fechaFin <= :fechaProximoVencimiento")
    List<RubroPresupuestal> findRubrosProximosAVencer(LocalDate fechaProximoVencimiento);

    // Buscar rubros con presupuesto casi agotado
    @Query("SELECT r FROM RubroPresupuestal r WHERE (r.presupuestoEjecutado / r.presupuestoTotal) >= 0.9")
    List<RubroPresupuestal> findRubrosCasiAgotados();
}