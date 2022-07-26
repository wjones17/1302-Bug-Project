package edu.westga.cs1302.project2.model;

import edu.westga.cs1302.project2.view.resources.UI.ExceptionMessages;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

/**
 * Creates an abstract WingedInsect class
 * 
 * @author wtjra
 * @version Spring 2021
 *
 */
public abstract class WingedInsect extends Canvas implements Comparable<WingedInsect>, Flying {
	private Direction direction;
	private int speed;

	/**
	 * Creates a protected constructor for a WingedInsect with the given information
	 * 
	 * @precondition x >= 0 && y >= 0 && speed >= 0
	 * @postcondition none
	 * @param xCoord is the x coordinate for this canvas
	 * @param yCoord is the y coordinate for this canvas
	 * @param width  is the width of the canvas
	 * @param height is the height of the canvas
	 * @param speed  is the speed of the insect flying
	 * 
	 */
	protected WingedInsect(double xCoord, double yCoord, double width, double height, int speed) {
		super(width, height);
		if (xCoord < 0) {
			throw new IllegalArgumentException(ExceptionMessages.NEGATIVE_COORDINATE);
		} else {
			super.setLayoutX(xCoord);
		}
		if (yCoord < 0) {
			throw new IllegalArgumentException(ExceptionMessages.NEGATIVE_COORDINATE);
		} else {
			super.setLayoutY(yCoord);
		}
		if (speed < 0) {
			throw new IllegalArgumentException("Speed must be a Postive value");
		}
		this.direction = Direction.LEFT;
		this.speed = speed;
	}

	/**
	 * Creates a protected constructor for a WingedInsect with the given information
	 * 
	 * @precondition x >= 0 && y >= 0
	 * @postcondition none
	 * @param xCoord is the x coordinate for this canvas
	 * @param yCoord is the y coordinate for this canvas
	 * @param width  is the width of the canvas
	 * @param height is the height of the canvas
	 * 
	 */
	protected WingedInsect(double xCoord, double yCoord, double width, double height, int speed, Direction direction) {
		this(xCoord, yCoord, width, height, speed);
		this.setDirection(direction);
	}

	/**
	 * Gets the Direction of this and returns it
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the direction
	 */
	public Direction getDirection() {
		return this.direction;
	}

	/**
	 * sets the Direction of this WingedInsect
	 * 
	 * @precondition none
	 * @postcondition none
	 * @param direction is the direction to set this wingedInsect facing
	 */
	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	/**
	 * Gets the speed of this WingedInsect and returns it
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the speed
	 */
	public int getSpeed() {
		return this.speed;
	}

	/**
	 * Clears this canvas
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 */
	public void clear() {
		GraphicsContext gc = this.getGraphicsContext2D();
		gc.clearRect(0, 0, this.getWidth(), this.getHeight());
	}

	/**
	 * Draws this canvas
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 */
	public abstract void draw();

	@Override
	public int compareTo(WingedInsect insect) {
		if (this.getWidth() > insect.getWidth()) {
			return 1;
		} else if (this.getWidth() < insect.getWidth()) {
			return -1;
		} else {
			return 0;
		}

	}

	@Override
	public void fly() {
		double xRight = this.getLayoutX() + this.speed;
		double xLeft = this.getLayoutX() - this.speed;
		if (this.direction.equals(Direction.RIGHT)) {
			this.setLayoutX(xRight);
			if (this.getLayoutX() > Sky.WIDTH) {
				xRight = 0 - this.getWidth();
				this.setLayoutX(xRight);
			}
		}

		if (this.direction.equals(Direction.LEFT)) {
			this.setLayoutX(xLeft);
			if (this.getLayoutX() <= 0 - this.getWidth()) {
				xLeft = Sky.WIDTH;
				this.setLayoutX(xLeft);
			}
		}

	}

}
