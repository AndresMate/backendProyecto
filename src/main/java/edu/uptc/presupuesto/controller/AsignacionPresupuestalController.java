package edu.uptc.presupuesto.controller;

import edu.uptc.presupuesto.dto.AsignacionPresupuestalDTO;
import edu.uptc.presupuesto.handling.ResponseHandler;
import edu.uptc.presupuesto.service.AsignacionPresupuestalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Object> crearAsignacion(@RequestBody AsignacionPresupuestalDTO dto) {
        try {
            AsignacionPresupuestalDTO nuevaAsignacion = service.crearAsignacion(dto);
            return ResponseHandler.generateResponse("Asignación creada con éxito", HttpStatus.OK, nuevaAsignacion);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.CONFLICT, e.getMessage());
        }
    }

    @GetMapping("/rubro/{rubroId}")
    @Operation(summary = "Obtener asignaciones por rubro")
    public ResponseEntity<Object> obtenerAsignacionesPorRubro(@PathVariable Long rubroId) {
        try {
            List<AsignacionPresupuestalDTO> asignaciones = service.obtenerAsignacionesPorRubro(rubroId);
            return ResponseHandler.generateResponse("Asignaciones obtenidas con éxito", HttpStatus.OK, asignaciones);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.CONFLICT, e.getMessage());
        }
    }

    @GetMapping
    @Operation(summary = "Obtener todas las asignaciones presupuestales")
    public ResponseEntity<Object> obtenerTodasAsignaciones() {
        try {
            List<AsignacionPresupuestalDTO> asignaciones = service.obtenerTodasAsignaciones();
            return ResponseHandler.generateResponse("Asignaciones obtenidas con éxito", HttpStatus.OK, asignaciones);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.CONFLICT, e.getMessage());
        }
    }
}