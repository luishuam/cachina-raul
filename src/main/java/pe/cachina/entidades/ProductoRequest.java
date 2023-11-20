package pe.cachina.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;

@Getter
public class ProductoRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @PastOrPresent
    private LocalDate adquisitionDate;
    @Digits(integer = 3, fraction = 2)
    @DecimalMin(value = "0.0")
    private BigDecimal price;
    @PositiveOrZero
    private int stock;
    @NotNull
    private Boolean status;
}
