package no.emagnus.ulurulib.conditions;

import static org.fest.assertions.Assertions.assertThat;
import no.emagnus.ulurulib.PieceColor;
import no.emagnus.ulurulib.PieceConfiguration;

import org.junit.Before;
import org.junit.Test;

public class NoConditionTest {

    private PieceConfiguration conf;
    
    @Before
    public void setup() {
	conf = PieceConfiguration.emptyConfiguration();
    }
    
    @Test
    public void should_be_met_if_present() {
	conf.setPos(5, PieceColor.BLACK);
	
	Condition cond = new NoCondition(PieceColor.BLACK);
	assertThat(cond.isMetSpecifically(conf)).isTrue();
    }
    
    @Test
    public void should_not_be_met_if_not_present() {
	Condition cond = new NoCondition(PieceColor.BLACK);
	assertThat(cond.isMetSpecifically(conf)).isFalse();
    }

}
