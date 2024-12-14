package edu.uptc.presupuesto.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "alerta")
public class Alerta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "asignacion_id", nullable = false)
    private AsignacionPresupuestal asignacion;

    @Enumerated(EnumType.STRING)
    private TipoAlerta tipoAlerta;

    @NotBlank(message = "Descripción de la alerta es obligatoria")
    private String descripcion;

    private LocalDateTime fechaCreacion;

    private boolean leida;

    public enum TipoAlerta {
        RECURSOS_BAJOS, PROXIMO_A_VENCER, RUBRO_AGOTADO, GASTO_EXCESIVO
    }
}