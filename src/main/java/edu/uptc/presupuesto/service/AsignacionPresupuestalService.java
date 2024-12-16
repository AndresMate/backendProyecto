package edu.uptc.presupuesto.service;

import edu.uptc.presupuesto.dto.AsignacionPresupuestalDTO;
import edu.uptc.presupuesto.mapper.AsignacionPresupuestalMapper;
import edu.uptc.presupuesto.model.Alerta;
import edu.uptc.presupuesto.model.AsignacionPresupuestal;
import edu.uptc.presupuesto.model.RubroPresupuestal;
import edu.uptc.presupuesto.repository.AlertaRepository;
import edu.uptc.presupuesto.repository.AsignacionPresupuestalRepository;
import edu.uptc.presupuesto.repository.RubroPresupuestalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AsignacionPresupuestalService {
    private static final Logger logger = LoggerFactory.getLogger(AsignacionPresupuestalService.class);

    @Autowired
    private AsignacionPresupuestalRepository repository;

    @Autowired
    private AsignacionPresupuestalMapper mapper;

    @Autowired
    private RubroPresupuestalRepository rubroRepository;

    @Autowired
    private AlertaRepository alertaRepository;

    public AsignacionPresupuestalDTO crearAsignacion(AsignacionPresupuestalDTO dto) {
        logger.info("Creando una nueva asignación presupuestal");
        AsignacionPresupuestal asignacion = mapper.toEntity(dto);
        asignacion.setMontoUtilizado(BigDecimal.ZERO);
        asignacion.setMontoDisponible(asignacion.getMontoTotal());

        // Update the RubroPresupuestal
        RubroPresupuestal rubro = rubroRepository.findById(dto.getRubroId()).orElseThrow(() -> {
            logger.error("Rubro no encontrado con ID: {}", dto.getRubroId());
            return new RuntimeException("Rubro no encontrado");
        });
        BigDecimal nuevoPresupuestoEjecutado = rubro.getPresupuestoEjecutado().add(asignacion.getMontoTotal());

        if (nuevoPresupuestoEjecutado.compareTo(rubro.getPresupuestoTotal()) > 0) {
            crearAlerta(rubro, "La asignación ha sobrepasado el presupuesto del rubro.");
        }

        rubro.setPresupuestoEjecutado(nuevoPresupuestoEjecutado);
        rubroRepository.save(rubro);

        AsignacionPresupuestal savedAsignacion = repository.save(asignacion);
        logger.info("Asignación presupuestal creada con éxito con ID: {}", savedAsignacion.getId());
        return mapper.toDTO(savedAsignacion);
    }

    private void crearAlerta(RubroPresupuestal rubro, String descripcion) {
        Alerta alerta = Alerta.builder()
                .asignacion(null)
                .tipoAlerta(Alerta.TipoAlerta.RUBRO_AGOTADO)
                .descripcion(descripcion)
                .fechaCreacion(LocalDateTime.now())
                .leida(false)
                .build();
        alertaRepository.save(alerta);
    }

    public List<AsignacionPresupuestalDTO> obtenerAsignacionesPorRubro(Long rubroId) {
        return repository.findByRubroId(rubroId)
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<AsignacionPresupuestalDTO> obtenerTodasAsignaciones() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public void eliminarAsignacion(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Asignación no encontrada");
        }
        repository.deleteById(id);
    }
}