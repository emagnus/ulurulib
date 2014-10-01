package no.emagnus.ulurulib;

import static no.emagnus.ulurulib.PieceColor.BLACK;
import static no.emagnus.ulurulib.PieceColor.BLUE;
import static no.emagnus.ulurulib.PieceColor.GREEN;
import static no.emagnus.ulurulib.PieceColor.ORANGE;
import static no.emagnus.ulurulib.PieceColor.PINK;
import static no.emagnus.ulurulib.PieceColor.RED;
import static no.emagnus.ulurulib.PieceColor.WHITE;
import static no.emagnus.ulurulib.PieceColor.YELLOW;
import static org.fest.assertions.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import no.emagnus.ulurulib.conditions.Condition;
import no.emagnus.ulurulib.conditions.NextToCondition;
import no.emagnus.ulurulib.conditions.NoCondition;
import no.emagnus.ulurulib.conditions.OppositeSideCondition;

import org.junit.Test;

public class ConfigurationEvaluatorTest {
    private PieceConfiguration configuration = createTestConfiguration();

    @Test
    public void should_return_0_when_no_conditions_are_met() {
	Condition conditionWhichIsNotMet = new NextToCondition(PieceColor.RED, PieceColor.GREEN);
	SetOfConditions conditions = new SetOfConditions(Arrays.asList(conditionWhichIsNotMet));
	
	ConfigurationEvaluator evaluator = new ConfigurationEvaluator(conditions);
	
	int conditionsMet = evaluator.evaluate(configuration);
	assertThat(conditionsMet).isEqualTo(0);
    }
    
    @Test
    public void should_return_1_when_1_condition_is_met() {
	Condition conditionWhichIsMet = new NextToCondition(PieceColor.BLUE, PieceColor.GREEN);
	Condition conditionWhichIsNotMet = new NextToCondition(PieceColor.RED, PieceColor.GREEN);
	SetOfConditions conditions = new SetOfConditions(Arrays.asList(conditionWhichIsMet, conditionWhichIsNotMet));
	
	ConfigurationEvaluator evaluator = new ConfigurationEvaluator(conditions);
	
	int conditionsMet = evaluator.evaluate(configuration);
	assertThat(conditionsMet).isEqualTo(1);
    }
    
    @Test
    public void should_return_3_when_3_conditions_are_met() {
	Condition conditionWhichIsMet1 = new NextToCondition(PieceColor.BLUE, PieceColor.GREEN);
	Condition conditionWhichIsMet2 = new OppositeSideCondition(PieceColor.RED, PieceColor.YELLOW);
	Condition conditionWhichIsMet3 = new NoCondition(PieceColor.PINK);
	Condition conditionWhichIsNotMet = new NextToCondition(PieceColor.BLACK, PieceColor.GREEN);
	
	List<Condition> conditions = Arrays.asList(conditionWhichIsMet1, conditionWhichIsMet2, conditionWhichIsMet3, conditionWhichIsNotMet);
	ConfigurationEvaluator evaluator = new ConfigurationEvaluator(new SetOfConditions(conditions));
	
	int conditionsMet = evaluator.evaluate(configuration);
	assertThat(conditionsMet).isEqualTo(3);
    }
    
    private static PieceConfiguration createTestConfiguration() {
	List<PieceColor> pieces = Arrays.asList(GREEN, BLUE, RED, ORANGE, YELLOW, WHITE, PINK, BLACK);
	return new PieceConfiguration(pieces);
    }

}
