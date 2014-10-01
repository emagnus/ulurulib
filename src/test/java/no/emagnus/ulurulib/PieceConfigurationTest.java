package no.emagnus.ulurulib;

import static org.fest.assertions.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class PieceConfigurationTest {

    @Test
    public void should_accept_list_of_size_8() {
	List<PieceColor> allColors = Arrays.asList(PieceColor.values());
	new PieceConfiguration(allColors);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void should_not_accept_null_list() throws Exception {
	new PieceConfiguration(null);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void should_not_accept_list_of_size_7() throws Exception {
	new PieceConfiguration(new ArrayList<PieceColor>());
    }
    
    @Test
    public void should_say_when_color_is_present() {
	PieceConfiguration conf = PieceConfiguration.emptyConfiguration();
	conf.setPos(0, PieceColor.BLACK);
	
	assertThat(conf.isPresent(PieceColor.BLACK)).isTrue();
    }
    
    @Test
    public void should_say_when_color_is_not_present() {
	PieceConfiguration conf = PieceConfiguration.emptyConfiguration();
	
	assertThat(conf.isPresent(PieceColor.BLACK)).isFalse();
    }

}
