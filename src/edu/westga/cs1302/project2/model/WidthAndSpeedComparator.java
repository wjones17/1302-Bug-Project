package edu.westga.cs1302.project2.model;

import java.util.Comparator;

/**
 * Creates a comparator for a two level sort by width first then speed
 * 
 * @author wtjra
 * @version Spring 2021
 *
 */
public class WidthAndSpeedComparator implements Comparator<WingedInsect> {

	@Override
	public int compare(WingedInsect insect1, WingedInsect insect2) {
		if (insect1.getWidth() > insect2.getWidth()) {
			return 1;
		} else if (insect1.getWidth() < insect2.getWidth()) {
			return -1;
		} else if (insect1.getSpeed() > insect2.getSpeed()) {
			return 1;
		} else if (insect1.getSpeed() < insect2.getSpeed()) {
			return -1;
		} else {
			return 0;
		}
	}

}
