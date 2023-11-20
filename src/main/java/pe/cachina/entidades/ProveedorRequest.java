package pe.cachina.entidades;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class ProveedorRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @Size(min = 8, max = 8)
    private String dni;
    @NotBlank
    private String category;
    @NotNull
    private Boolean status;
}
