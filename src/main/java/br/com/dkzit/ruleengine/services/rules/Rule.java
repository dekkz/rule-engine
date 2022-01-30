package br.com.dkzit.ruleengine.services.rules;

import br.com.dkzit.ruleengine.dto.CelestialObjectClassificationRequestDTO;
import br.com.dkzit.ruleengine.services.EvaluationResult;

public interface Rule {

    boolean shoudRun(CelestialObjectClassificationRequestDTO celestialObject);

    EvaluationResult evaluate(CelestialObjectClassificationRequestDTO celestialObject);

}
