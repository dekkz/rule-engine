package br.com.dkzit.ruleengine.services;

import br.com.dkzit.ruleengine.commons.ObjectType;
import br.com.dkzit.ruleengine.dto.CelestialObjectClassificationRequestDTO;
import br.com.dkzit.ruleengine.dto.CelestialObjectClassificationResponseDTO;
import br.com.dkzit.ruleengine.services.rules.BlackRoleRule;
import br.com.dkzit.ruleengine.services.rules.PlanetRule;
import br.com.dkzit.ruleengine.services.rules.Rule;
import br.com.dkzit.ruleengine.services.rules.StarRule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RuleEngineControl {

    private static final Set<Rule> rules =
            Set.of(new PlanetRule(), new StarRule(), new BlackRoleRule());

    public CelestialObjectClassificationResponseDTO classify(final CelestialObjectClassificationRequestDTO celestialObject) {
        ObjectType objectType = ObjectType.UNKNOWN;

        final List<EvaluationResult> matchedRules = rules.stream().filter(rule ->
                rule.shoudRun(celestialObject))
                .map(rule -> rule.evaluate(celestialObject))
                .collect(Collectors.toList());

        if(!CollectionUtils.isEmpty(matchedRules)) {
            if(matchedRules.size() > 1) {
                matchedRules.sort(Comparator.comparing(EvaluationResult::getPrecedente));
            }
            objectType = matchedRules.get(0).getType();
        }

        return CelestialObjectClassificationResponseDTO.builder()
                .type(objectType.name())
                .build();
    }

}
