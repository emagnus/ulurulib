package no.emagnus.ulurulib;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

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
    
    public Set<PieceColor> detectCycles() {
	Set<PieceColor> cycleColors = new HashSet<>();
	for(Entry<PieceColor, Condition> colorCondition : conditionPerColor.entrySet()) {
	    PieceColor start = colorCondition.getKey();
	    Condition cond = colorCondition.getValue();
	    if(cycleColors.contains(start)) {
		continue;
	    }
	    
	    Set<PieceColor> colorsInThisCycle = new HashSet<>();
	    colorsInThisCycle.add(start);
	    if(cond.isComplex()) {
		PieceColor next = cond.getOther();
		while (conditionPerColor.get(next).isComplex()) {
		    colorsInThisCycle.add(next);
		    if(colorsInThisCycle.contains(next)) {
			cycleColors.addAll(colorsInThisCycle);
			break;
		    }
		    next = conditionPerColor.get(next).getOther();
		} 
	    }
	}
	
	return cycleColors;
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
