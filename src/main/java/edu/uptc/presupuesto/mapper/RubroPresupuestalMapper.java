package edu.uptc.presupuesto.mapper;

import edu.uptc.presupuesto.model.RubroPresupuestal;
import edu.uptc.presupuesto.dto.RubroPresupuestalDTO;
import org.springframework.stereotype.Component;

@Component
public class RubroPresupuestalMapper {
    public RubroPresupuestalDTO toDTO(RubroPresupuestal rubro) {
        RubroPresupuestalDTO dto = new RubroPresupuestalDTO();
        dto.setId(rubro.getId());
        dto.setNombre(rubro.getNombre());
        dto.setPresupuestoTotal(rubro.getPresupuestoTotal());
        dto.setPresupuestoEjecutado(rubro.getPresupuestoEjecutado());
        dto.setFechaInicio(rubro.getFechaInicio());
        dto.setFechaFin(rubro.getFechaFin());
        dto.setEstado(rubro.getEstado());
        dto.setPorcentajeEjecucion(rubro.getPorcentajeEjecucion());
        return dto;
    }

    public RubroPresupuestal toEntity(RubroPresupuestalDTO dto) {
        RubroPresupuestal rubro = new RubroPresupuestal();
        rubro.setId(dto.getId());
        rubro.setNombre(dto.getNombre());
        rubro.setPresupuestoTotal(dto.getPresupuestoTotal());
        rubro.setPresupuestoEjecutado(dto.getPresupuestoEjecutado());
        rubro.setFechaInicio(dto.getFechaInicio());
        rubro.setFechaFin(dto.getFechaFin());
        rubro.setEstado(dto.getEstado());
        return rubro;
    }
}