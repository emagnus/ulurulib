package no.emagnus.ulurulib.conditions;

import static org.fest.assertions.Assertions.assertThat;
import no.emagnus.ulurulib.PieceColor;
import no.emagnus.ulurulib.PieceConfiguration;

import org.junit.Test;

public class NoConditionTest {

    @Test
    public void should_always_be_met() {
	PieceConfiguration conf = PieceConfiguration.emptyConfiguration();
	conf.setPos(5, PieceColor.BLACK);
	
	Condition cond = new NoCondition(PieceColor.BLACK);
	assertThat(cond.isMetSpecifically(conf)).isTrue();
    }

}
