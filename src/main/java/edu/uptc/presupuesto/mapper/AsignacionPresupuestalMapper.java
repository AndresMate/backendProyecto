package edu.uptc.presupuesto.mapper;

import edu.uptc.presupuesto.dto.AsignacionPresupuestalDTO;
import edu.uptc.presupuesto.model.AsignacionPresupuestal;
import org.springframework.stereotype.Component;

@Component
public class AsignacionPresupuestalMapper {
    public AsignacionPresupuestalDTO toDTO(AsignacionPresupuestal asignacion) {
        AsignacionPresupuestalDTO dto = new AsignacionPresupuestalDTO();
        dto.setId(asignacion.getId());
        dto.setRubroId(asignacion.getRubro().getId());
        dto.setMontoTotal(asignacion.getMontoTotal());
        dto.setMontoUtilizado(asignacion.getMontoUtilizado());
        dto.setMontoDisponible(asignacion.getMontoDisponible());
        dto.setFechaInicio(asignacion.getFechaInicio());
        dto.setFechaFin(asignacion.getFechaFin());
        dto.setEstado(asignacion.getEstado());
        return dto;
    }

    public AsignacionPresupuestal toEntity(AsignacionPresupuestalDTO dto) {
        AsignacionPresupuestal asignacion = new AsignacionPresupuestal();
        asignacion.setId(dto.getId());
        asignacion.setMontoTotal(dto.getMontoTotal());
        asignacion.setMontoUtilizado(dto.getMontoUtilizado());
        asignacion.setMontoDisponible(dto.getMontoDisponible());
        asignacion.setFechaInicio(dto.getFechaInicio());
        asignacion.setFechaFin(dto.getFechaFin());
        asignacion.setEstado(dto.getEstado());
        return asignacion;
    }
}