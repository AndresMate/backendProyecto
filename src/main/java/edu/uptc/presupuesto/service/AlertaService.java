package edu.uptc.presupuesto.service;

import edu.uptc.presupuesto.dto.AlertaDTO;
import edu.uptc.presupuesto.mapper.AlertaMapper;
import edu.uptc.presupuesto.model.Alerta;
import edu.uptc.presupuesto.repository.AlertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlertaService {
    @Autowired
    private AlertaRepository repository;

    @Autowired
    private AlertaMapper mapper;

    public AlertaDTO crearAlerta(AlertaDTO dto) {
        Alerta alerta = mapper.toEntity(dto);
        Alerta savedAlerta = repository.save(alerta);
        return mapper.toDTO(savedAlerta);
    }

    public List<AlertaDTO> obtenerAlertasPorAsignacion(Long asignacionId) {
        return repository.findByAsignacionId(asignacionId)
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
}