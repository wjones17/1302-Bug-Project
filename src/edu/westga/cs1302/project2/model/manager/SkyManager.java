package edu.westga.cs1302.project2.model.manager;

import java.util.Random;

import edu.westga.cs1302.project2.model.Butterfly;
import edu.westga.cs1302.project2.model.Cloud;
import edu.westga.cs1302.project2.model.Direction;
import edu.westga.cs1302.project2.model.DragonFly;
import edu.westga.cs1302.project2.model.Flying;
import edu.westga.cs1302.project2.model.Sky;
import edu.westga.cs1302.project2.model.WingedInsect;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * The Class SkyManager.
 * 
 * @author CS1302
 * @version 1.0
 */

public class SkyManager extends Pane {

	private Sky sky;

	/**
	 * Instantiates a new sky.
	 * 
	 * @precondition none
	 * @postcondition getSky() != null
	 */
	public SkyManager() {
		this.sky = new Sky();
		this.getChildren().add(this.sky);
	}

	/**
	 * Gets the sky.
	 *
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the sky
	 */
	public Sky getSky() {
		return this.sky;
	}

	/**
	 * Sets the up bugs and clouds.
	 * 
	 * @precondition nInsects >= 0
	 * @postcondition getSky().getInsects().getSize() == nInsects
	 */
	public void setupBugsAndClouds() {
		this.generateInsects();
		this.generateClouds();
	}

	/**
	 * Generate insects.
	 */
	private void generateInsects() {
		Random rd = new Random();
		Color[] colors = { Color.AQUA, Color.DEEPPINK, Color.ORANGE, Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW,
				           Color.VIOLET };
		Direction[] directions = { Direction.LEFT, Direction.RIGHT };

		WingedInsect insect = null;

		for (int in = 0; in < 8; in++) {

			double size = this.generateSize();
			double xCoord = this.generateXCoord(size);
			double yCoord = this.generateYCoord(size);
			int speed = this.generateSpeed();
			int count = this.generateCount();
			Color color = colors[rd.nextInt(7)];
			Direction direction = directions[rd.nextInt(2)];
			double chances = rd.nextDouble();

			if (chances <= 0.75) {
				insect = new Butterfly(xCoord, yCoord, size, color, speed, direction, count);
			} else {
				insect = new DragonFly(xCoord, yCoord, size, speed, direction);
			}

			this.sky.addInsect(insect);
			this.getChildren().add(insect);

		}

	}

	private double generateXCoord(double size) {
		double low = 0.0;
		double high = (this.sky.getWidth() + 1) - size;

		double xCoord = (Math.random() * ((high - low) + 1)) + low;
		xCoord = Math.round(xCoord * 100.0) / 100.0;

		return xCoord;
	}

	private double generateYCoord(double size) {
		double low = 151;
		double high = (this.sky.getHeight() + 1) - size;

		double yCoord = (Math.random() * ((high - low) + 1)) + low;
		yCoord = Math.round(yCoord * 100.0) / 100.0;

		return yCoord;
	}

	private double generateSize() {
		double low = 50;
		double high = 101;

		double size = (Math.random() * ((high - low) + 1)) + low;
		size = Math.round(size * 100.0) / 100.0;

		return size;

	}

	private int generateSpeed() {
		Random rd = new Random();
		int low = 10;
		int high = 31;

		int speed = rd.nextInt(high - low) + low;

		return speed;
	}

	private int generateCount() {
		Random rd = new Random();
		int low = 1;
		int high = 3;

		int count = rd.nextInt(high - low) + low;

		return count;
	}

	private double generateCloudSize() {
		double low = 101;
		double high = 150;

		double size = (Math.random() * ((high - low) + 1)) + low;
		size = Math.round(size * 100.0) / 100.0;

		return size;

	}

	private void generateClouds() {
		Cloud cloud = null;

		for (int in = 0; in < 5; in++) {

			double size = this.generateCloudSize();
			double xCoord = this.generateXCoord(size);
			double yCoord = this.generateYCoord(size);
			int speed = this.generateSpeed();
			cloud = new Cloud(xCoord, yCoord, speed, size);
			this.sky.addCloud(cloud);
			this.getChildren().add(cloud);

		}

	}

	/**
	 * Move all flying objects in the sky
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public void update() {
		for (Flying object : this.sky) {
			object.fly();
		}

	}
}
