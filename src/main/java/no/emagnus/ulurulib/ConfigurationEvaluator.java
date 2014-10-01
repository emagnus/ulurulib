package no.emagnus.ulurulib;


public class ConfigurationEvaluator {
    
    private SetOfConditions conditions;

    public ConfigurationEvaluator(SetOfConditions conditions) {
	this.conditions = conditions;
    }
    
    public int evaluate(PieceConfiguration conf) {
	int conditionsMet = 0;
	for (PieceColor color : PieceColor.values()) {
	    if(conditions.hasCondition(color) &&
		    conditions.getCondition(color).isMetSpecifically(conf)) {
		conditionsMet++;
	    }
	}
	return conditionsMet;
    }

}
