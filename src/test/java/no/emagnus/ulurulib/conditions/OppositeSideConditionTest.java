package no.emagnus.ulurulib.conditions;

import no.emagnus.ulurulib.PieceColor;

import org.junit.Test;

public class OppositeSideConditionTest extends AbstractConditionTest {
    
    @Test
    public void should_be_met_if_other_color_on_opposite_short_side() {
	conf.setPos(3, PieceColor.BLACK);
	conf.setPos(7, PieceColor.BLUE);
	
	Condition cond = new OppositeSideCondition(PieceColor.BLACK, PieceColor.BLUE);
	assertThatConditionIsMetSpecifically(cond, true);
    }
    
    @Test
    public void should_not_be_met_if_other_color_on_same_side() {
	conf.setPos(6, PieceColor.BLACK);
	conf.setPos(7, PieceColor.BLUE);
	
	Condition cond = new OppositeSideCondition(PieceColor.BLACK, PieceColor.BLUE);
	assertThatConditionIsMetSpecifically(cond, false);
    }
    
    @Test
    public void should_not_be_met_if_other_color_on_adjacent_side() {
	conf.setPos(5, PieceColor.BLACK);
	conf.setPos(6, PieceColor.BLUE);
	
	Condition cond = new OppositeSideCondition(PieceColor.BLACK, PieceColor.BLUE);
	assertThatConditionIsMetSpecifically(cond, false);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void should_not_accept_only_one_color() {
	new OppositeSideCondition(PieceColor.BLACK, null);
    }

}
