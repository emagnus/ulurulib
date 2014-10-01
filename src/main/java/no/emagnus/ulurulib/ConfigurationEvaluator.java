package no.emagnus.ulurulib;

import java.util.Collection;

import no.emagnus.ulurulib.conditions.Condition;

public class ConfigurationEvaluator {
    
    private Collection<Condition> conditions;

    public ConfigurationEvaluator(Collection<Condition> conditions) {
	this.conditions = conditions;
    }
    
    public int evaluate(PieceConfiguration conf) {
	int conditionsMet = 0;
	for (Condition condition : conditions) {
	    if(condition.isMetSpecifically(conf)) {
		conditionsMet++;
	    }
	}
	return conditionsMet;
    }

}
