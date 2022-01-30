package br.com.dkzit.ruleengine.services.rules;

import br.com.dkzit.ruleengine.commons.ObjectType;
import br.com.dkzit.ruleengine.dto.CelestialObjectClassificationRequestDTO;
import br.com.dkzit.ruleengine.services.EvaluationResult;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StarRule implements Rule {

    private static final double MASS_OF_JUIPTER = 1.898e27;
    private static final double UPPER_MASS_LIMIT = MASS_OF_JUIPTER * 13;
    private static final double MIN_SURFACE_TEMPERATURE = 2500;

    @Override
    public boolean shoudRun(CelestialObjectClassificationRequestDTO celestialObject) {
        // in order to be a star the mass should be at least 13 times larger than the mass of Jupiter
        // AND
        // the surface temperature is at least 2500 Kelvins
        return (celestialObject.getMass() >= UPPER_MASS_LIMIT) && (celestialObject.getSurfaceTemperature() >= MIN_SURFACE_TEMPERATURE);
    }

    @Override
    public EvaluationResult evaluate(CelestialObjectClassificationRequestDTO celestialObject) {
        log.info("Star Rule executed");

        return new EvaluationResult() {
            @Override
            public ObjectType getType() {
                return ObjectType.STAR;
            }

            @Override
            public int getPrecedente() {
                return 1;
            }
        };
    }
}
