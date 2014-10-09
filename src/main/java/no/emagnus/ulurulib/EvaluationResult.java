package no.emagnus.ulurulib;

import java.util.List;

import no.emagnus.ulurulib.conditions.Condition;

public class EvaluationResult {
    
    private List<Condition> conditionsMet;
    private List<Condition> conditionsNotMet;
    private List<Condition> conditionsNA;
    
    public EvaluationResult(List<Condition> conditionsMet, List<Condition> conditionsNotMet, List<Condition> conditionsNA) {
	this.conditionsMet = conditionsMet;
	this.conditionsNotMet = conditionsNotMet;
	this.conditionsNA = conditionsNA;
    }
    
    public List<Condition> getConditionsMet() {
	return conditionsMet;
    }
    
    public List<Condition> getConditionsNotMet() {
	return conditionsNotMet;
    }
    
    public List<Condition> getConditionsNA() {
	return conditionsNA;
    }
    
    public int getNumberOfConditionsMet() {
	return conditionsMet.size();
    }

    public int getNumberOfConditionsNotMet() {
	return conditionsNotMet.size() + conditionsNA.size();
    }
    
    @Override
    public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append("Conditions met: \n");
	for (Condition condition : conditionsMet) {
	    sb.append(condition);
	    sb.append("\n");
	}
	sb.append(String.format("Total: %d\n", getNumberOfConditionsMet()));
	sb.append("\nConditions not met: \n");
	for (Condition condition : conditionsNotMet) {
	    sb.append(condition);
	    sb.append("\n");
	}
	sb.append("\nConditions not applied: \n");
	for (Condition condition : conditionsNA) {
	    sb.append(condition);
	    sb.append("\n");
	}
	
	sb.append(String.format("Total: %d\n", getNumberOfConditionsNotMet()));
        return sb.toString();
    }

}
