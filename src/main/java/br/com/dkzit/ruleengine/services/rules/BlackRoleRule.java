package br.com.dkzit.ruleengine.services.rules;

import br.com.dkzit.ruleengine.commons.ObjectType;
import br.com.dkzit.ruleengine.dto.CelestialObjectClassificationRequestDTO;
import br.com.dkzit.ruleengine.services.EvaluationResult;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BlackRoleRule implements Rule {

    private static final double GRAVITATIONAL_CONST = 6.67e-11;
    private static final long SPEED_OF_LIGHT = 299_792_458;

    @Override
    public boolean shoudRun(CelestialObjectClassificationRequestDTO celestialObject) {
        final double schwarzschildRadius = (2 * GRAVITATIONAL_CONST * celestialObject.getMass()) / (Math.pow(SPEED_OF_LIGHT, 2));
        final double physicalRadius = celestialObject.getEquatorialDiameter() / 2;
        // in order to be a black-hole the physical radius needs to be smaller than its Schwarzschild radius
        return physicalRadius < schwarzschildRadius;
    }

    @Override
    public EvaluationResult evaluate(CelestialObjectClassificationRequestDTO celestialObject) {
        log.info("Black-Hole Rule executed");

        return new EvaluationResult() {
            @Override
            public ObjectType getType() {
                return ObjectType.BLACK_ROLE;
            }

            @Override
            public int getPrecedente() {
                return 0;
            }
        };
    }
}
