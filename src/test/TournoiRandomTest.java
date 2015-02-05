package test;

import static org.junit.Assert.assertEquals;
import model.TournoiParPoules;

import org.junit.Test;

public class TournoiRandomTest {

	@Test
	public void test() {
		assertEquals(3,TournoiParPoules.getListEquipeDuTournoi("jaune","rouge","cyan").size());
	}

}
