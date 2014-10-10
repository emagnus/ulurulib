package no.emagnus.ulurulib.conditions;

import static org.fest.assertions.Assertions.assertThat;

import java.util.Arrays;

import no.emagnus.ulurulib.BoardContext;
import no.emagnus.ulurulib.PieceColor;
import no.emagnus.ulurulib.SetOfConditions;

import org.junit.Test;

public class SameAsConditionTest extends AbstractConditionTest {

    @Test
    public void should_be_met_if_condition_it_depends_on_is_met() {
	TestCondition isMet = new TestCondition(PieceColor.RED, null);
	isMet.isMetSpecifically = true;
	
	SameAsCondition cond = new SameAsCondition(PieceColor.BLUE, PieceColor.RED);
	
	conf.setPos(0, PieceColor.RED);
	conf.setPos(3, PieceColor.BLUE);
	
	BoardContext context = new BoardContext(conf, new SetOfConditions(Arrays.asList(isMet, cond)));
	
	assertThat(cond.isMetSpecifically(context)).isTrue();
    }
    
    @Test
    public void should_not_be_met_if_condition_it_depends_on_is_not_met() {
	TestCondition isMet = new TestCondition(PieceColor.RED, null);
	isMet.isMetSpecifically = false;
	
	SameAsCondition cond = new SameAsCondition(PieceColor.BLUE, PieceColor.RED);
	
	conf.setPos(0, PieceColor.RED);
	conf.setPos(3, PieceColor.BLUE);
	
	BoardContext context = new BoardContext(conf, new SetOfConditions(Arrays.asList(isMet, cond)));
	
	assertThat(cond.isMetSpecifically(context)).isFalse();
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void should_not_accept_only_one_color() {
	new SameAsCondition(PieceColor.BLACK, null);
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
