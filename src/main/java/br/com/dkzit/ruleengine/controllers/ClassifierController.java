package br.com.dkzit.ruleengine.controllers;

import br.com.dkzit.ruleengine.dto.CelestialObjectClassificationRequestDTO;
import br.com.dkzit.ruleengine.dto.CelestialObjectClassificationResponseDTO;
import br.com.dkzit.ruleengine.services.RuleEngineControl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@Validated
@RequiredArgsConstructor
public class ClassifierController {

    private final RuleEngineControl ruleEngineControl;

    @PostMapping("/v1/classifier")
    public ResponseEntity<CelestialObjectClassificationResponseDTO> classify(
            @Valid @RequestBody @NotNull final CelestialObjectClassificationRequestDTO request) {

        CelestialObjectClassificationResponseDTO response = this.ruleEngineControl.classify(request);
        return ResponseEntity.ok(response);

    }



}
