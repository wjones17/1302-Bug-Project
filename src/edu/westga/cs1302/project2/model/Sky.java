package edu.westga.cs1302.project2.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * The Class Sky.
 * 
 * @author CS1302
 * @version 1.0
 */
public class Sky extends Rectangle implements Iterable<Flying> {

	public static final int WIDTH = 750;
	public static final int HEIGHT = 450;
	private List<WingedInsect> wingedInsects;
	private List<Cloud> clouds;

	/**
	 * Instantiates a new sky.
	 * 
	 * @precondition none
	 * @postcondition insects.sze() == 0 && clouds.size() == 0
	 */
	public Sky() {
		super(0, 0, Sky.WIDTH, Sky.HEIGHT);
		this.setFill(Color.CORNFLOWERBLUE);
		this.wingedInsects = new ArrayList<WingedInsect>();
		this.clouds = new ArrayList<Cloud>();
	}

	/**
	 * Adds the specified Winged insect to the Winged insect collection
	 * 
	 * @precondition none
	 * @postcondition this.wingedInects @prev size +1
	 * @param insect is the insect to add to the collection
	 * 
	 * @return true if the specified insect is added to the collection, false
	 *         otherwise
	 */
	public boolean addInsect(WingedInsect insect) {
		return this.wingedInsects.add(insect);
	}

	/**
	 * Adds the specified cloud to the clouds collection
	 * 
	 * @precondition none
	 * @postcondition this.clouds @prev size +1
	 * @param cloud is the cloud to add to the collection
	 * 
	 * @return true if the specified cloud is added to the collection, false
	 *         otherwise
	 */
	public boolean addCloud(Cloud cloud) {
		return this.clouds.add(cloud);
	}

	/**
	 * Finds the largest butterfly and returns it
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the largest butterfly
	 */
	public Flying findLargestButterfly() {
		double width = Double.MIN_VALUE;
		ArrayList<WingedInsect> butterflies = new ArrayList<WingedInsect>();
		WingedInsect insect = null;
		for (WingedInsect curr : this.wingedInsects) {
			if (curr instanceof Butterfly) {
				butterflies.add(curr);
			}
		}
		for (WingedInsect butterfly : butterflies) {
			if (butterfly.getWidth() > width) {
				width = butterfly.getWidth();
				insect = butterfly;
			}
		}
		return insect;
	}

	/**
	 * Finds the Smallest butterfly and returns it
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the largest smallest
	 */
	public Flying findSmallestButterfly() {
		double width = Double.MAX_VALUE;
		ArrayList<WingedInsect> butterflies = new ArrayList<WingedInsect>();
		WingedInsect insect = null;
		for (WingedInsect curr : this.wingedInsects) {
			if (curr instanceof Butterfly) {
				butterflies.add(curr);
			}
		}
		for (WingedInsect butterfly : butterflies) {
			if (butterfly.getWidth() < width) {
				width = butterfly.getWidth();
				insect = butterfly;
			}
		}
		return insect;
	}

	/**
	 * Finds the largest dragonfly and returns it
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the largest dragonfly
	 */
	public Flying findLargestDragonfly() {
		double width = Double.MIN_VALUE;
		ArrayList<WingedInsect> dragonflies = new ArrayList<WingedInsect>();
		WingedInsect insect = null;
		for (WingedInsect curr : this.wingedInsects) {
			if (curr instanceof DragonFly) {
				dragonflies.add(curr);
			}
		}
		for (WingedInsect dragonfly : dragonflies) {
			if (dragonfly.getWidth() > width) {
				width = dragonfly.getWidth();
				insect = dragonfly;
			}
		}
		return insect;
	}

	/**
	 * Finds the smallest dragonfly and returns it
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the smallest dragonfly
	 */
	public Flying findSmallestDragonfly() {
		double width = Double.MAX_VALUE;
		ArrayList<WingedInsect> dragonflies = new ArrayList<WingedInsect>();
		WingedInsect insect = null;
		for (WingedInsect curr : this.wingedInsects) {
			if (curr instanceof DragonFly) {
				dragonflies.add(curr);
			}
		}
		for (WingedInsect dragonfly : dragonflies) {
			if (dragonfly.getWidth() < width) {
				width = dragonfly.getWidth();
				insect = dragonfly;
			}
		}
		return insect;
	}

	/**
	 * Returns a copy of the insects list for info hiding
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return insects which is the array of insects
	 */
	public ArrayList<String> insectsInfo() {
		ArrayList<String> insects = new ArrayList<String>();
		for (WingedInsect insect : this.wingedInsects) {
			insects.add(insect.toString());
		}
		return insects;
	}

	/**
	 * Returns the number of butterflies in the sky
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return total is the total number of butterflies
	 */
	public int numberOfButterflies() {
		int total = 0;
		for (WingedInsect insect : this.wingedInsects) {
			if (insect instanceof Butterfly) {
				total += 1;
			}
		}
		return total;
	}

	/**
	 * Returns the number of dragonflies in the sky
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return total is the total number of dragonflies
	 */
	public int numberOfDragonflies() {
		int total = 0;
		for (WingedInsect insect : this.wingedInsects) {
			if (insect instanceof DragonFly) {
				total += 1;
			}
		}
		return total;
	}

	/**
	 * Sorts the winged insects in their natural order
	 * 
	 */
	public void sort() {
		Collections.sort(this.wingedInsects);
	}

	/**
	 * Sorts the winged insects with the specified comparator
	 * 
	 * @param comp the comparator to use
	 */
	public void sort(Comparator<WingedInsect> comp) {
		Collections.sort(this.wingedInsects, comp);
	}

	@Override
	public Iterator<Flying> iterator() {
		List<Flying> flyingObjects = new ArrayList<Flying>();
		flyingObjects.addAll(this.wingedInsects);
		flyingObjects.addAll(this.clouds);

		return flyingObjects.iterator();
	}

}
