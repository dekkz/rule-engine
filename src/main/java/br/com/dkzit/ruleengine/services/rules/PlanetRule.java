package br.com.dkzit.ruleengine.services.rules;

import br.com.dkzit.ruleengine.commons.ObjectType;
import br.com.dkzit.ruleengine.dto.CelestialObjectClassificationRequestDTO;
import br.com.dkzit.ruleengine.services.EvaluationResult;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PlanetRule implements Rule {

    private static final Double MASS_OF_JUPITER = 1.898e27;
    private static final Double UPPER_MASS_LIMIT = MASS_OF_JUPITER * 13;

    @Override
    public boolean shoudRun(CelestialObjectClassificationRequestDTO celestialObject) {
        // in order to be a planet the mass should be at most 13 times the mass of Jupiter
        return celestialObject.getMass() <= UPPER_MASS_LIMIT;
    }

    @Override
    public EvaluationResult evaluate(CelestialObjectClassificationRequestDTO celestialObject) {
        log.info("Planet Rule executed");

        return new EvaluationResult() {
            @Override
            public ObjectType getType() {
                return ObjectType.PLANET;
            }

            @Override
            public int getPrecedente() {
                return 1;
            }
        };
    }
}
