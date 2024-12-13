package edu.uptc.presupuesto.service;

import edu.uptc.presupuesto.model.RubroPresupuestal;
import edu.uptc.presupuesto.model.EstadoRubro;
import edu.uptc.presupuesto.repository.RubroPresupuestalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class RubroPresupuestalService {
    @Autowired
    private RubroPresupuestalRepository repository;

    public RubroPresupuestal crearRubro(RubroPresupuestal rubro) {
        // Validaciones antes de guardar
        if (rubro.getFechaInicio() == null) {
            rubro.setFechaInicio(LocalDate.now());
        }
        rubro.setEstado(EstadoRubro.PENDIENTE);
        rubro.setPresupuestoEjecutado(BigDecimal.ZERO);

        return repository.save(rubro);
    }

    public List<RubroPresupuestal> obtenerRubrosProximosAVencer() {
        LocalDate fechaProximoVencimiento = LocalDate.now().plusMonths(1);
        return repository.findRubrosProximosAVencer(fechaProximoVencimiento);
    }

    public List<RubroPresupuestal> obtenerRubrosCasiAgotados() {
        return repository.findRubrosCasiAgotados();
    }

    public void actualizarEjecucionPresupuestal(Long rubroId, BigDecimal montoEjecutado) {
        RubroPresupuestal rubro = repository.findById(rubroId)
                .orElseThrow(() -> new RuntimeException("Rubro no encontrado"));

        BigDecimal nuevoPresupuestoEjecutado = rubro.getPresupuestoEjecutado().add(montoEjecutado);
        rubro.setPresupuestoEjecutado(nuevoPresupuestoEjecutado);

        // Actualizar estado si se ha ejecutado más del 90% del presupuesto
        if (nuevoPresupuestoEjecutado.divide(rubro.getPresupuestoTotal()).compareTo(BigDecimal.valueOf(0.9)) >= 0) {
            rubro.setEstado(EstadoRubro.SOBREPASADO);
        }

        repository.save(rubro);
    }
}