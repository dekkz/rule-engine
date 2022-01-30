package br.com.dkzit.ruleengine.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CelestialObjectClassificationRequestDTO {

    @NotEmpty
    @Size
    private String name;

    @NotNull
    private Double mass;

    @NotNull
    private Double equatorialDiameter;

    @NotNull
    private Long surfaceTemperature;

}
