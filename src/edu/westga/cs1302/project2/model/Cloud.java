package edu.westga.cs1302.project2.model;

import edu.westga.cs1302.project2.view.resources.UI.ExceptionMessages;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Creates a new cloud class
 * 
 * @author wtjra
 * @version Spring 2021
 *
 */
public class Cloud extends Canvas implements Flying {
	private int speed;

	/**
	 * Creates a new cloud with a given direction and speed
	 * 
	 * @precondition speed > 0
	 * 
	 * @param xCoord is the xCoordinate of this cloud
	 * @param yCoord is the y Coordinate of this cloud, set to zerp fpr the clouds
	 *               to stay at the top
	 * @param size   is the size of this cloud
	 * @param speed  is how fast the cloud will be moving
	 */
	public Cloud(double xCoord, double yCoord, int speed, double size) {
		super(size * 2, size);
		if (xCoord < 0) {
			throw new IllegalArgumentException(ExceptionMessages.NEGATIVE_COORDINATE);
		} else {
			super.setLayoutX(xCoord);
		}
		if (speed < 0) {
			throw new IllegalArgumentException("Speed must be a Postive value");
		}
		yCoord = 0;
		super.setLayoutY(yCoord);
		this.speed = speed;

		this.draw();
	}

	/**
	 * Draws the cloud
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 */
	public void draw() {
		GraphicsContext gc = this.getGraphicsContext2D();

		gc.setFill(Color.WHITESMOKE);
		gc.fillOval(5, this.getHeight() - 60, (this.getWidth() - 5), (this.getHeight() / 7));
		gc.fillOval(40, this.getHeight() - 75, (this.getWidth() / 5), (this.getHeight() / 5));
		gc.fillOval(60, this.getHeight() - 100, (this.getWidth() / 2), (this.getHeight() / 2));

	}

	@Override
	public void fly() {
		double xRight = this.getLayoutX() + this.speed;
		this.setLayoutX(xRight);
		if (this.getLayoutX() > Sky.WIDTH) {
			xRight = 0 - this.getWidth();
			this.setLayoutX(xRight);
		}

	}

}
