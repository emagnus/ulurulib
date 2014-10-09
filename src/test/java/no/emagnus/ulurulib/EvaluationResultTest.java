package no.emagnus.ulurulib;

import static org.fest.assertions.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import no.emagnus.ulurulib.conditions.Condition;
import no.emagnus.ulurulib.conditions.NoCondition;

import org.junit.Test;

public class EvaluationResultTest {
    
    private final List<Condition> noConditions = Collections.<Condition>emptyList();
    
    @Test
    public void should_return_number_of_conditions_met() {
	EvaluationResult result = new EvaluationResult(oneCondition(), noConditions, noConditions);
	assertThat(result.getNumberOfConditionsMet()).isEqualTo(1);
    }
    
    @Test
    public void should_return_total_number_of_conditions_not_met() {
	EvaluationResult result = new EvaluationResult(noConditions, oneCondition(), oneCondition());
	assertThat(result.getNumberOfConditionsNotMet()).isEqualTo(2);
    }
    
    private List<Condition> oneCondition() {
	List<Condition> conditions = new ArrayList<>();
	conditions.add(new NoCondition(PieceColor.BLUE));
	return conditions;
    }

}
