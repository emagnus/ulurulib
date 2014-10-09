package no.emagnus.ulurulib.conditions;

import no.emagnus.ulurulib.PieceColor;

import org.junit.Test;

public class NoConditionTest extends AbstractConditionTest {

    @Test
    public void should_be_met_if_present() {
	conf.setPos(5, PieceColor.BLACK);
	
	Condition cond = new NoCondition(PieceColor.BLACK);
	assertThatConditionIsMetSpecifically(cond, true);
    }
    
    @Test
    public void should_not_be_met_if_not_present() {
	Condition cond = new NoCondition(PieceColor.BLACK);
	assertThatConditionIsMetSpecifically(cond, false);
    }

}
