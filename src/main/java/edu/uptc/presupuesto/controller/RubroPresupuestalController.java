package edu.uptc.presupuesto.controller;

import edu.uptc.presupuesto.dto.RubroPresupuestalDTO;
import edu.uptc.presupuesto.handling.ResponseHandler;
import edu.uptc.presupuesto.service.RubroPresupuestalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/rubros")
@Tag(name = "Gestión de Rubros Presupuestales")
public class RubroPresupuestalController {
    @Autowired
    private RubroPresupuestalService service;

    @PostMapping
    @Operation(summary = "Crear un nuevo rubro presupuestal")
    public ResponseEntity<Object> crearRubro(@Valid @RequestBody RubroPresupuestalDTO rubroDTO) {
        try {
            RubroPresupuestalDTO nuevoRubro = service.crearRubro(rubroDTO);
            return ResponseHandler.generateResponse("Rubro creado con éxito", HttpStatus.OK, nuevoRubro);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.CONFLICT, e.getMessage());
        }
    }

    @GetMapping("/proximosVencer")
    @Operation(summary = "Obtener rubros próximos a vencer")
    public ResponseEntity<Object> getRubrosProximosAVencer() {
        try {
            List<RubroPresupuestalDTO> rubros = service.obtenerRubrosProximosAVencer();
            return ResponseHandler.generateResponse("Rubros obtenidos con éxito", HttpStatus.OK, rubros);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.CONFLICT, e.getMessage());
        }
    }

    @GetMapping("/casiAgotados")
    @Operation(summary = "Obtener rubros casi agotados")
    public ResponseEntity<Object> getRubrosCasiAgotados() {
        try {
            List<RubroPresupuestalDTO> rubros = service.obtenerRubrosCasiAgotados();
            return ResponseHandler.generateResponse("Rubros obtenidos con éxito", HttpStatus.OK, rubros);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.CONFLICT, e.getMessage());
        }
    }

    @PutMapping("/{rubroId}/ejecutar")
    @Operation(summary = "Actualizar ejecución presupuestal de un rubro")
    public ResponseEntity<Object> actualizarEjecucion(
            @PathVariable Long rubroId,
            @RequestParam BigDecimal montoEjecutado
    ) {
        try {
            service.actualizarEjecucionPresupuestal(rubroId, montoEjecutado);
            return ResponseHandler.generateResponse("Ejecución actualizada con éxito", HttpStatus.OK, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.CONFLICT, e.getMessage());
        }
    }

    @GetMapping
    @Operation(summary = "Listar todos los rubros")
    public ResponseEntity<Object> listarRubros() {
        try {
            List<RubroPresupuestalDTO> rubros = service.listarTodos();
            return ResponseHandler.generateResponse("Rubros obtenidos con éxito", HttpStatus.OK, rubros);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.CONFLICT, e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener rubro por ID")
    public ResponseEntity<Object> obtenerRubroPorId(@PathVariable Long id) {
        try {
            RubroPresupuestalDTO rubro = service.obtenerPorId(id);
            return ResponseHandler.generateResponse("Rubro obtenido con éxito", HttpStatus.OK, rubro);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.CONFLICT, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar rubro")
    public ResponseEntity<Object> actualizarRubro(
            @PathVariable Long id,
            @RequestBody RubroPresupuestalDTO rubroActualizado
    ) {
        try {
            RubroPresupuestalDTO rubro = service.actualizarRubro(id, rubroActualizado);
            return ResponseHandler.generateResponse("Rubro actualizado con éxito", HttpStatus.OK, rubro);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.CONFLICT, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar rubro")
    public ResponseEntity<Object> eliminarRubro(@PathVariable Long id) {
        try {
            service.eliminarRubro(id);
            return ResponseHandler.generateResponse("Rubro eliminado con éxito", HttpStatus.NO_CONTENT, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.CONFLICT, e.getMessage());
        }
    }
}