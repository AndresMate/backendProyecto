package edu.uptc.presupuesto.controller;

import edu.uptc.presupuesto.dto.AsignacionPresupuestalDTO;
import edu.uptc.presupuesto.service.AsignacionPresupuestalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asignaciones")
@Tag(name = "Gestión de Asignaciones Presupuestales")
public class AsignacionPresupuestalController {
    @Autowired
    private AsignacionPresupuestalService service;

    @PostMapping
    @Operation(summary = "Crear una nueva asignación presupuestal")
    public ResponseEntity<AsignacionPresupuestalDTO> crearAsignacion(@RequestBody AsignacionPresupuestalDTO dto) {
        return ResponseEntity.ok(service.crearAsignacion(dto));
    }

    @GetMapping("/rubro/{rubroId}")
    @Operation(summary = "Obtener asignaciones por rubro")
    public List<AsignacionPresupuestalDTO> obtenerAsignacionesPorRubro(@PathVariable Long rubroId) {
        return service.obtenerAsignacionesPorRubro(rubroId);
    }
}