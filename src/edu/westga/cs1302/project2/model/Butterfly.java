package edu.westga.cs1302.project2.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Creates a new Butterfly class
 * 
 * @author wtjra
 * @version Spring 2021
 *
 */
public class Butterfly extends WingedInsect {
	private Color color;
	private int count;

	/**
	 * Creates a new Butterfly with the given specifications
	 * 
	 * @precondition none
	 * @postcondition none
	 * @param xCoord is the x coordinate for this canvas
	 * @param yCoord is the y coordinate for this canvas
	 * @param size   is size of this butterfly
	 * @param color  is the color of this butterfly
	 * @param speed  is the speed of the butterfly flying
	 * 
	 * 
	 */
	public Butterfly(double xCoord, double yCoord, double size, Color color, int speed) {
		super(xCoord, yCoord, size, size, speed);
		this.color = color;

		this.draw();
	}

	/**
	 * Creates a new Butterfly with the given specifications
	 * 
	 * @precondition none
	 * @postcondition none
	 * @param xCoord    is the x coordinate for this canvas
	 * @param yCoord    is the y coordinate for this canvas
	 * @param size      is size of this butterfly
	 * @param color     is the color of this butterfly
	 * @param speed     is the speed of this flying butterfly
	 * @param direction is the direction for the insect to be facing
	 * @param count     is a number to keep track of in order for the butterflies to
	 *                  not be in sync when flapping
	 * 
	 */
	public Butterfly(double xCoord, double yCoord, double size, Color color, int speed, Direction direction,
			int count) {
		super(xCoord, yCoord, size, size, speed, direction);
		this.color = color;
		this.setCount(count);

		this.draw();
	}

	/**
	 * Gets the color of this butterfly and returns it
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the color of this butterfly
	 */
	public Color getColor() {
		return this.color;
	}

	/**
	 * Sets the count of this insect being called in the fly method in order for the
	 * butterfly to be able to "Flap" its wings
	 * 
	 * @precondition none
	 * @postcondition none
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public void draw() {
		GraphicsContext gc = this.getGraphicsContext2D();

		if (this.getDirection().equals(Direction.LEFT)) {
			this.drawLeftFacing(gc);
		} else if (this.getDirection().equals(Direction.RIGHT)) {
			this.drawRightFacing(gc);
		}
	}

	private void drawLeftFacing(GraphicsContext gc) {
		this.drawBody(gc);
		this.drawAntennas(gc);
		this.drawWings(gc);
	}

	private void drawRightFacing(GraphicsContext gc) {
		this.drawBody(gc);
		this.drawAntennasRight(gc);
		this.drawWings(gc);
	}

	private void drawLeftFacingWingsDown(GraphicsContext gc) {
		this.drawBody(gc);
		this.drawAntennas(gc);
		this.drawWingsDown(gc);
	}

	private void drawRightFacingWingsDown(GraphicsContext gc) {
		this.drawBody(gc);
		this.drawAntennasRight(gc);
		this.drawWingsDown(gc);
	}

	private void drawBody(GraphicsContext gc) {
		gc.setFill(Color.GREY);
		gc.fillOval(5, 20, (this.getWidth() - 10), (this.getHeight() / 8));
	}

	private void drawAntennas(GraphicsContext gc) {
		gc.setStroke(Color.GREY);
		gc.strokeLine(4, 15, 15, 25);
		gc.strokeLine(2, 18, 13, 23);

	}

	private void drawWings(GraphicsContext gc) {
		gc.setFill(this.color);
		double[] xCoords = { 0.0, (this.getWidth() / 2), this.getWidth(), (this.getWidth() / 2) };
		double[] yCoords = { 0.0, 23, 0.0, 5 };
		gc.fillPolygon(xCoords, yCoords, 4);

	}

	private void drawWingsDown(GraphicsContext gc) {
		gc.setFill(this.color);
		double[] xCoords = { 0.0, (this.getWidth() / 2), this.getWidth(), (this.getWidth() / 2) };
		double[] yCoords = { this.getHeight() / 1.5, this.getHeight() / 1.7, this.getHeight() / 1.5,
				this.getHeight() / 3 };
		gc.fillPolygon(xCoords, yCoords, 4);

	}

	private void drawAntennasRight(GraphicsContext gc) {
		gc.setStroke(Color.GREY);
		gc.strokeLine((this.getWidth() - 4), 15, (this.getWidth() - 15), 25);
		gc.strokeLine((this.getWidth() - 2), 18, (this.getWidth() - 13), 23);

	}

	@Override
	public String toString() {
		return "Butterfly width=" + this.getWidth() + " color=" + this.color + " Speed=" + this.getSpeed();
	}

	@Override
	public void fly() {
		this.setCount(this.count + 1);
		GraphicsContext gc = this.getGraphicsContext2D();

		if (this.getDirection().equals(Direction.RIGHT) && this.count % 2 == 1) {
			gc.clearRect(0, 0, this.getWidth(), this.getHeight());
			this.drawRightFacingWingsDown(gc);
			super.fly();
		} else if (this.getDirection().equals(Direction.LEFT) && this.count % 2 == 1) {
			gc.clearRect(0, 0, this.getWidth(), this.getHeight());
			this.drawLeftFacingWingsDown(gc);
			super.fly();
		} else {
			gc.clearRect(0, 0, this.getWidth(), this.getHeight());
			this.draw();
			super.fly();

		}

	}

}
