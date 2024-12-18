package edu.uptc.presupuesto.service;

import edu.uptc.presupuesto.dto.RubroPresupuestalDTO;
import edu.uptc.presupuesto.mapper.RubroPresupuestalMapper;
import edu.uptc.presupuesto.model.RubroPresupuestal;
import edu.uptc.presupuesto.model.RubroPresupuestal.EstadoRubro;
import edu.uptc.presupuesto.repository.RubroPresupuestalRepository;
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
        rubro.setVersion(0L); // Initialize version field

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

    public List<RubroPresupuestalDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public RubroPresupuestalDTO obtenerPorId(Long id) {
        RubroPresupuestal rubro = repository.findById(id).orElse(null);
        if (rubro == null) {
            return null; // O puedes devolver un DTO vacío o con valores predeterminados
        }
        return mapper.toDTO(rubro);
    }

    public RubroPresupuestalDTO actualizarRubro(Long id, RubroPresupuestalDTO rubroActualizado) {
        RubroPresupuestal rubroExistente = repository.findById(id).orElse(null);
        if (rubroExistente == null) {
            return null; // O puedes devolver un DTO vacío o con valores predeterminados
        }

        // Actualizar campos permitidos
        rubroExistente.setNombre(rubroActualizado.getNombre());
        rubroExistente.setPresupuestoTotal(rubroActualizado.getPresupuestoTotal());
        rubroExistente.setFechaInicio(rubroActualizado.getFechaInicio());
        rubroExistente.setFechaFin(rubroActualizado.getFechaFin());

        RubroPresupuestal rubroGuardado = repository.save(rubroExistente);
        return mapper.toDTO(rubroGuardado);
    }

    public void eliminarRubro(Long id) {
        if (!repository.existsById(id)) {
            return; // No hacer nada si el rubro no existe
        }
        repository.deleteById(id);
    }
}