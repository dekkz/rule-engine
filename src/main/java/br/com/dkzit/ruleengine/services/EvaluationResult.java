package br.com.dkzit.ruleengine.services;

import br.com.dkzit.ruleengine.commons.ObjectType;

public interface EvaluationResult {

    ObjectType getType();
    int getPrecedente();


}
