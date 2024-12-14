package edu.uptc.presupuesto.service;

import edu.uptc.presupuesto.dto.AsignacionPresupuestalDTO;
import edu.uptc.presupuesto.mapper.AsignacionPresupuestalMapper;
import edu.uptc.presupuesto.model.AsignacionPresupuestal;
import edu.uptc.presupuesto.repository.AsignacionPresupuestalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AsignacionPresupuestalService {
    @Autowired
    private AsignacionPresupuestalRepository repository;

    @Autowired
    private AsignacionPresupuestalMapper mapper;

    public AsignacionPresupuestalDTO crearAsignacion(AsignacionPresupuestalDTO dto) {
        AsignacionPresupuestal asignacion = mapper.toEntity(dto);
        AsignacionPresupuestal savedAsignacion = repository.save(asignacion);
        return mapper.toDTO(savedAsignacion);
    }

    public List<AsignacionPresupuestalDTO> obtenerAsignacionesPorRubro(Long rubroId) {
        return repository.findByRubroId(rubroId)
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
}