package edu.uptc.presupuesto.controller;

import edu.uptc.presupuesto.dto.ReporteDTO;
import edu.uptc.presupuesto.service.ReporteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reportes")
@Tag(name = "Gestión de Reportes")
public class ReporteController {
    @Autowired
    private ReporteService service;

    @PostMapping
    @Operation(summary = "Crear un nuevo reporte")
    public ResponseEntity<ReporteDTO> crearReporte(@RequestBody ReporteDTO dto) {
        return ResponseEntity.ok(service.crearReporte(dto));
    }

    @GetMapping("/usuario/{usuarioId}")
    @Operation(summary = "Obtener reportes por usuario")
    public List<ReporteDTO> obtenerReportesPorUsuario(@PathVariable Long usuarioId) {
        return service.obtenerReportesPorUsuario(usuarioId);
    }
}