package no.emagnus.ulurulib.conditions;

import no.emagnus.ulurulib.PieceColor;

import org.junit.Test;

public class TwoSpaceAwayConditionTest extends AbstractConditionTest {
    
    @Test
    public void should_be_met_if_two_places_away_from_other() {
	conf.setPos(0, PieceColor.BLACK);
	conf.setPos(3, PieceColor.BLUE);
	
	TwoSpacesAwayCondition cond = new TwoSpacesAwayCondition(PieceColor.BLUE, PieceColor.BLACK);
	assertThatConditionIsMetSpecifically(cond, true);
    }

    @Test
    public void should_not_be_met_if_one_place_away_from_other() {
	conf.setPos(0, PieceColor.BLACK);
	conf.setPos(2, PieceColor.BLUE);
	
	TwoSpacesAwayCondition cond = new TwoSpacesAwayCondition(PieceColor.BLUE, PieceColor.BLACK);
	assertThatConditionIsMetSpecifically(cond, false);
    }
    
    @Test
    public void should_not_be_met_if_one_place_away_from_other_in_nw_corner() {
	conf.setPos(0, PieceColor.BLACK);
	conf.setPos(6, PieceColor.BLUE);
	
	TwoSpacesAwayCondition cond = new TwoSpacesAwayCondition(PieceColor.BLUE, PieceColor.BLACK);
	assertThatConditionIsMetSpecifically(cond, false);
    }

    @Test
    public void should_not_be_met_if_neighbours() {
	conf.setPos(0, PieceColor.BLACK);
	conf.setPos(7, PieceColor.BLUE);
	
	TwoSpacesAwayCondition cond = new TwoSpacesAwayCondition(PieceColor.BLUE, PieceColor.BLACK);
	assertThatConditionIsMetSpecifically(cond, false);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void should_not_accept_only_one_color() {
	new TwoSpacesAwayCondition(PieceColor.BLACK, null);
    }

}
