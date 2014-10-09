package no.emagnus.ulurulib.conditions;

import no.emagnus.ulurulib.PieceColor;

import org.junit.Test;

public class PositionConditionTest extends AbstractConditionTest {

    @Test
    public void should_be_met_if_in_big_boomerang() {
	conf.setPos(0, PieceColor.BLACK);
	
	PositionCondition cond = PositionCondition.bigBoomerang(PieceColor.BLACK);
	assertThatConditionIsMetSpecifically(cond, true);
    }
    
    @Test
    public void should_not_be_met_if_not_in_big_boomerang() {
	conf.setPos(3, PieceColor.BLACK);
	
	PositionCondition cond = PositionCondition.bigBoomerang(PieceColor.BLACK);
	assertThatConditionIsMetSpecifically(cond, false);
    }
    
    @Test
    public void should_be_met_if_in_small_boomerang() {
	conf.setPos(3, PieceColor.BLACK);
	
	PositionCondition cond = PositionCondition.smallBoomerang(PieceColor.BLACK);
	assertThatConditionIsMetSpecifically(cond, true);
    }
    
    @Test
    public void should_not_be_met_if_not_in_small_boomerang() {
	conf.setPos(2, PieceColor.BLACK);
	
	PositionCondition cond = PositionCondition.smallBoomerang(PieceColor.BLACK);
	assertThatConditionIsMetSpecifically(cond, false);
    }
    
    @Test
    public void should_be_met_if_on_short_sides() {
	conf.setPos(3, PieceColor.BLACK);
	
	PositionCondition cond = PositionCondition.shortSides(PieceColor.BLACK);
	assertThatConditionIsMetSpecifically(cond, true);
    }
    
    @Test
    public void should_not_be_met_if_not_on_short_sides() {
	conf.setPos(2, PieceColor.BLACK);
	
	PositionCondition cond = PositionCondition.shortSides(PieceColor.BLACK);
	assertThatConditionIsMetSpecifically(cond, false);
    }
    
    @Test
    public void should_be_met_if_on_long_sides() {
	conf.setPos(2, PieceColor.BLACK);
	
	PositionCondition cond = PositionCondition.longSides(PieceColor.BLACK);
	assertThatConditionIsMetSpecifically(cond, true);
    }
    
    @Test
    public void should_not_be_met_if_not_on_long_sides() {
	conf.setPos(3, PieceColor.BLACK);
	
	PositionCondition cond = PositionCondition.longSides(PieceColor.BLACK);
	assertThatConditionIsMetSpecifically(cond, false);
    }

}
