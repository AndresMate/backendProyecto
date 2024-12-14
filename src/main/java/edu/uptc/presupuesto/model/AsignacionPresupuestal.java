package edu.uptc.presupuesto.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "asignacion_presupuestal")
public class AsignacionPresupuestal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "rubro_id", nullable = false)
    private RubroPresupuestal rubro;

    @NotNull(message = "Monto total es obligatorio")
    @DecimalMin(value = "0.0", message = "Monto total debe ser positivo")
    private BigDecimal montoTotal;

    private BigDecimal montoUtilizado;

    private BigDecimal montoDisponible;

    @NotNull(message = "Fecha de inicio es obligatoria")
    private LocalDate fechaInicio;

    @NotNull(message = "Fecha de fin es obligatoria")
    private LocalDate fechaFin;

    @Enumerated(EnumType.STRING)
    private EstadoAsignacion estado;

    public enum EstadoAsignacion {
        ACTIVA, AGOTADA, PROXIMA_A_VENCER, COMPLETADA
    }
}