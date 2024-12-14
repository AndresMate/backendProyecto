package edu.uptc.presupuesto.service;

import edu.uptc.presupuesto.dto.ReporteDTO;
import edu.uptc.presupuesto.mapper.ReporteMapper;
import edu.uptc.presupuesto.model.Reporte;
import edu.uptc.presupuesto.repository.ReporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReporteService {
    @Autowired
    private ReporteRepository repository;

    @Autowired
    private ReporteMapper mapper;

    public ReporteDTO crearReporte(ReporteDTO dto) {
        Reporte reporte = mapper.toEntity(dto);
        Reporte savedReporte = repository.save(reporte);
        return mapper.toDTO(savedReporte);
    }

    public List<ReporteDTO> obtenerReportesPorUsuario(Long usuarioId) {
        return repository.findByUsuarioId(usuarioId)
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
}