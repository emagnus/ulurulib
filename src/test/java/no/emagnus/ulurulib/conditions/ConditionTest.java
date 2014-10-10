package no.emagnus.ulurulib.conditions;

import static org.fest.assertions.Assertions.assertThat;

import java.util.Arrays;

import no.emagnus.ulurulib.BoardContext;
import no.emagnus.ulurulib.PieceColor;
import no.emagnus.ulurulib.SetOfConditions;

import org.junit.Test;

public class ConditionTest extends AbstractConditionTest {
    
    @Test
    public void should_accept_two_pieces_of_different_colors() {
	new TestCondition(PieceColor.BLACK, PieceColor.BLUE);
    }

    @Test
    public void should_accept_two_pieces_of_the_same_colors() {
	new TestCondition(PieceColor.BLACK, PieceColor.BLACK);
    }
    
    @Test
    public void should_accept_one_color() {
	new TestCondition(PieceColor.BLACK, null);
    }
    
    @Test
    public void should_be_met_if_same_colors_and_present_in_configuration() {
	conf.setPos(0, PieceColor.BLUE);
	
	Condition cond = new TestCondition(PieceColor.BLUE, PieceColor.BLUE);
	assertThatConditionIsMet(cond, true);
    }
    
    @Test
    public void should_not_be_met_if_same_colors_and_not_present_in_configuration() {
	conf.setPos(0, PieceColor.BLACK);
	
	Condition cond = new TestCondition(PieceColor.BLUE, PieceColor.BLUE);
	assertThatConditionIsMet(cond, false);
    }
    
    @Test
    public void should_be_met_if_not_same_colors_but_condition_met_specifically() {
	conf.setPos(0, PieceColor.BLACK);
	
	TestCondition cond = new TestCondition(PieceColor.BLACK, PieceColor.BLUE);
	cond.isMetSpecifically = true;
	assertThatConditionIsMet(cond, true);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void should_not_accept_no_colors() {
	new TestCondition(null, null);
    }
    
    private void assertThatConditionIsMet(Condition condition, boolean isMet) {
	BoardContext context = new BoardContext(conf, new SetOfConditions(Arrays.asList(condition)));
	assertThat(condition.isMet(context)).isEqualTo(isMet);
    }

    private static class TestCondition extends Condition {
	
	boolean isMetSpecifically = false;
	
	public TestCondition(PieceColor affected, PieceColor other) {
	    super(affected, other);
	}
	
	@Override
	public boolean isMetSpecifically(BoardContext context) {
	    return isMetSpecifically;
	}
	
    }

}
