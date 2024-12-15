package edu.uptc.presupuesto.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "rubros_presupuestales")
public class RubroPresupuestal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del rubro es obligatorio")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    @Column(nullable = false, length = 100)
    private String nombre;

    @NotNull(message = "El presupuesto total es obligatorio")
    @Positive(message = "El presupuesto total debe ser mayor a cero")
    @Column(name = "presupuesto_total", nullable = false, precision = 19, scale = 2)
    private BigDecimal presupuestoTotal;

    @Column(name = "presupuesto_ejecutado", precision = 19, scale = 2)
    private BigDecimal presupuestoEjecutado = BigDecimal.ZERO;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private EstadoRubro estado = EstadoRubro.PENDIENTE;

    // Enum for the states of the rubro
    public enum EstadoRubro {
        PENDIENTE,
        EN_EJECUCION,
        COMPLETADO,
        SOBREPASADO
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPresupuestoTotal() {
        return presupuestoTotal;
    }

    public void setPresupuestoTotal(BigDecimal presupuestoTotal) {
        this.presupuestoTotal = presupuestoTotal;
    }

    public BigDecimal getPresupuestoEjecutado() {
        return presupuestoEjecutado;
    }

    public void setPresupuestoEjecutado(BigDecimal presupuestoEjecutado) {
        this.presupuestoEjecutado = presupuestoEjecutado;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public EstadoRubro getEstado() {
        return estado;
    }

    public void setEstado(EstadoRubro estado) {
        this.estado = estado;
    }

    // Method to calculate execution percentage
    public BigDecimal getPorcentajeEjecucion() {
        if (presupuestoTotal.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }
        return presupuestoEjecutado.divide(presupuestoTotal, 4, BigDecimal.ROUND_HALF_UP)
                .multiply(BigDecimal.valueOf(100));
    }
}