package edu.uptc.presupuesto.service;

import edu.uptc.presupuesto.model.EstadoRubro;
import edu.uptc.presupuesto.model.RubroPresupuestal;
import edu.uptc.presupuesto.dto.RubroPresupuestalDTO;
import edu.uptc.presupuesto.repository.RubroPresupuestalRepository;
import edu.uptc.presupuesto.mapper.RubroPresupuestalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RubroPresupuestalService {
    @Autowired
    private RubroPresupuestalRepository repository;

    @Autowired
    private RubroPresupuestalMapper mapper;

    public RubroPresupuestalDTO crearRubro(RubroPresupuestalDTO rubroDTO) {
        RubroPresupuestal rubro = mapper.toEntity(rubroDTO);

        if (rubro.getFechaInicio() == null) {
            rubro.setFechaInicio(LocalDate.now());
        }
        rubro.setEstado(EstadoRubro.PENDIENTE);
        rubro.setPresupuestoEjecutado(BigDecimal.ZERO);

        RubroPresupuestal savedRubro = repository.save(rubro);
        return mapper.toDTO(savedRubro);
    }

    public List<RubroPresupuestalDTO> obtenerRubrosProximosAVencer() {
        LocalDate fechaProximoVencimiento = LocalDate.now().plusMonths(1);
        return repository.findRubrosProximosAVencer(fechaProximoVencimiento)
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<RubroPresupuestalDTO> obtenerRubrosCasiAgotados() {
        return repository.findRubrosCasiAgotados()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public void actualizarEjecucionPresupuestal(Long rubroId, BigDecimal montoEjecutado) {
        RubroPresupuestal rubro = repository.findById(rubroId)
                .orElseThrow(() -> new RuntimeException("Rubro no encontrado"));

        BigDecimal nuevoPresupuestoEjecutado = rubro.getPresupuestoEjecutado().add(montoEjecutado);
        rubro.setPresupuestoEjecutado(nuevoPresupuestoEjecutado);

        if (nuevoPresupuestoEjecutado.divide(rubro.getPresupuestoTotal()).compareTo(BigDecimal.valueOf(0.9)) >= 0) {
            rubro.setEstado(EstadoRubro.SOBREPASADO);
        }

        repository.save(rubro);
    }
}