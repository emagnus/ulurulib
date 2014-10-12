package no.emagnus.ulurulib;

import static org.fest.assertions.Assertions.assertThat;

import java.util.Arrays;
import java.util.Set;

import no.emagnus.ulurulib.conditions.Condition;
import no.emagnus.ulurulib.conditions.NoCondition;
import no.emagnus.ulurulib.conditions.SameAsCondition;

import org.junit.Test;

public class SetOfConditionsTest {

    @Test
    public void should_find_conditions_that_default_to_being_met_because_of_simple_cycle_in_complex_conditions() {
	Condition cond1 = new SameAsCondition(PieceColor.BLACK, PieceColor.BLUE);
	Condition cond2 = new SameAsCondition(PieceColor.BLUE, PieceColor.BLACK);
	Condition cond3 = new NoCondition(PieceColor.RED);
	SetOfConditions conditions = new SetOfConditions(Arrays.asList(cond1, cond2, cond3));

	Set<PieceColor> colorsInvolvedInCycles = conditions.detectCycles();
	
	assertThat(colorsInvolvedInCycles).containsOnly(PieceColor.BLACK, PieceColor.BLUE);
    }

    @Test
    public void should_find_conditions_that_default_to_being_met_because_of_complex_cycle_in_complex_conditions() {
	Condition cond1 = new SameAsCondition(PieceColor.BLACK, PieceColor.BLUE);
	Condition cond2 = new SameAsCondition(PieceColor.BLUE, PieceColor.RED);
	Condition cond3 = new SameAsCondition(PieceColor.RED, PieceColor.YELLOW);
	Condition cond4 = new SameAsCondition(PieceColor.YELLOW, PieceColor.RED);
	Condition cond5 = new NoCondition(PieceColor.WHITE);
	SetOfConditions conditions = new SetOfConditions(Arrays.asList(cond1, cond2, cond3, cond4, cond5));
	
	Set<PieceColor> colorsInvolvedInCycles = conditions.detectCycles();
	
	assertThat(colorsInvolvedInCycles).containsOnly(PieceColor.BLACK, PieceColor.BLUE, PieceColor.RED, PieceColor.YELLOW);
    }

}
