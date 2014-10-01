package no.emagnus.ulurulib;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import no.emagnus.ulurulib.conditions.Condition;

public class SetOfConditions {
    
    private Map<PieceColor, Condition> conditionPerColor = new HashMap<>();
    
    public SetOfConditions(Collection<Condition> conditions) {
	for (Condition condition : conditions) {
	    conditionPerColor.put(condition.getAffected(), condition);
	}
    }
    
    public Condition getCondition(PieceColor color) {
	return conditionPerColor.get(color);
    }
    
    public boolean hasCondition(PieceColor color) {
	return conditionPerColor.containsKey(color);
    }
    
    @Override
    public String toString() {
	StringBuilder sb = new StringBuilder();
        for (PieceColor color : PieceColor.values()) {
	    sb.append(getCondition(color));
	    sb.append("\n");
	}
        return sb.toString();
    }

}
