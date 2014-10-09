package no.emagnus.ulurulib;

import java.util.ArrayList;
import java.util.List;

import no.emagnus.ulurulib.conditions.Condition;

public class BoardContext {
    
    private PieceConfiguration pieceConfiguration;
    private SetOfConditions conditions;
    
    public BoardContext(PieceConfiguration conf, SetOfConditions cond) {
	pieceConfiguration = conf;
	conditions = cond;
    }
    
    public EvaluationResult evaluate() {
	List<Condition> conditionsMet = new ArrayList<>();
	List<Condition> conditionsNotMet = new ArrayList<>();
	List<Condition> conditionsNA = new ArrayList<>();
	for (PieceColor color : PieceColor.values()) {
	    Condition condition = conditions.getCondition(color);
	    if(pieceConfiguration.isPresent(color)) {
		if(condition.isMet(this)) {
		    conditionsMet.add(condition);
		} else {
		    conditionsNotMet.add(condition);
		}
	    } else {
		conditionsNA.add(condition);
	    }
	}
	
	return new EvaluationResult(conditionsMet, conditionsNotMet, conditionsNA);
    }
    
    public PieceConfiguration getPieceConfiguration() {
	return pieceConfiguration;
    }
    
    public Condition getCondition(PieceColor color) {
	return conditions.getCondition(color);
    }

    public boolean isPresent(PieceColor affected) {
	return pieceConfiguration.isPresent(affected);
    }
    
    public void setPieceConfiguration(PieceConfiguration pieceConfiguration) {
	this.pieceConfiguration = pieceConfiguration;
    }

}
