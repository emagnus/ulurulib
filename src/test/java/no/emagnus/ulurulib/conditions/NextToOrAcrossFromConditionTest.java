package no.emagnus.ulurulib.conditions;

import no.emagnus.ulurulib.PieceColor;

import org.junit.Test;

public class NextToOrAcrossFromConditionTest extends AbstractConditionTest {

    @Test
    public void should_not_be_met_if_pieces_are_neighbours() {
	conf.setPos(0, PieceColor.BLACK);
	conf.setPos(1, PieceColor.BLUE);
	
	Condition cond = new NextToOrAcrossFromCondition(PieceColor.BLACK, PieceColor.BLUE);
	assertThatConditionIsMetSpecifically(cond, false);
    }

    @Test
    public void should_not_be_met_if_pieces_are_across_from_each_other() {
	conf.setPos(0, PieceColor.BLACK);
	conf.setPos(5, PieceColor.BLUE);
	
	Condition cond = new NextToOrAcrossFromCondition(PieceColor.BLACK, PieceColor.BLUE);
	assertThatConditionIsMetSpecifically(cond, false);
    }
    
    @Test
    public void should_be_met_if_pieces_are_neither_across_from_each_other_nor_neighbours() {
	conf.setPos(0, PieceColor.BLACK);
	conf.setPos(2, PieceColor.BLUE);
	
	Condition cond = new NextToOrAcrossFromCondition(PieceColor.BLACK, PieceColor.BLUE);
	assertThatConditionIsMetSpecifically(cond, true);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void should_not_accept_only_one_color() {
	new NextToOrAcrossFromCondition(PieceColor.BLACK, null);
    }

}
