package edu.westga.cs1302.project2.model;

import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Creates a new DragonFly class
 * 
 * @author wtjra
 * @version Spring 2021
 *
 */
public class DragonFly extends WingedInsect {
	private Color wingColor;

	/**
	 * Creates a new dragonfly with the specified information
	 * 
	 * @precondition none
	 * @postcondition none
	 * @param xCoord is the x coordinate of this dragonfly
	 * @param yCoord is the y coordinate of this dragonfly
	 * @param size   is the size of this dragonfly
	 * @param speed is the speed of this flying dragonfly
	 * 
	 */
	public DragonFly(double xCoord, double yCoord, double size, int speed) {
		super(xCoord, yCoord, size, size, speed);
		this.wingColor = Color.BLACK;

		this.draw();

	}

	/**
	 * Creates a new dragonfly with the specified information
	 * 
	 * @precondition none
	 * @postcondition none
	 * @param xCoord    is the x coordinate of this dragonfly
	 * @param yCoord    is the y coordinate of this dragonfly
	 * @param size      is the size of this dragonfly
	 * @param speed is the speed of this flying dragonfly
	 * @param direction is the direction to have the insect facing
	 * 
	 */
	public DragonFly(double xCoord, double yCoord, double size, int speed, Direction direction) {
		super(xCoord, yCoord, size, size, speed, direction);
		this.wingColor = Color.BLACK;

		this.draw();

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
		this.drawTorsoAndHeadAndEyes(gc);
		this.drawBackBody(gc);
		this.drawWings(gc);
		this.drawLegs(gc);
	}

	private void drawRightFacing(GraphicsContext gc) {
		this.drawTorsoAndHeadAndEyesRight(gc);
		this.drawBackBodyRight(gc);
		this.drawWings(gc);
		this.drawLegsRight(gc);
	}

	private void drawTorsoAndHeadAndEyes(GraphicsContext gc) {
		gc.setFill(Color.GREY);
		gc.fillOval(10, 10, (this.getWidth() / 4), (this.getHeight() / 5));
		gc.setFill(Color.DARKGOLDENROD);
		gc.fillOval(0, 4, (this.getWidth() / 4), (this.getHeight() / 6));
		gc.setFill(Color.RED);
		gc.fillOval(0, 4, (this.getWidth() / 15), (this.getHeight() / 15));
		gc.fillOval(6, 6, (super.getWidth() / 15), (super.getHeight() / 15));
		gc.setFill(Color.BLACK);
		gc.fillOval(1, 5.40, (this.getWidth() / 23), (this.getHeight() / 23));
		gc.fillOval(7, 6.2, (this.getWidth() / 23), (this.getHeight() / 23));
	}

	private void drawTorsoAndHeadAndEyesRight(GraphicsContext gc) {
		gc.setFill(Color.GREY);
		gc.fillOval((this.getWidth() - (this.getWidth() / 4) - 10), 10, (this.getWidth() / 4),
				(this.getHeight() / 5));
		gc.setFill(Color.DARKGOLDENROD);
		gc.fillOval(this.getWidth() - (this.getWidth() / 4), 4, (this.getWidth() / 4), (this.getHeight() / 6));
		gc.setFill(Color.RED);
		gc.fillOval(this.getWidth() - (this.getWidth() / 15), 4, (this.getWidth() / 15), (this.getHeight() / 15));
		gc.fillOval((this.getWidth() - (this.getWidth() / 15) - 6), 6, (this.getWidth() / 15),
				(this.getHeight() / 15));
		gc.setFill(Color.BLACK);
		gc.fillOval((this.getWidth() - (this.getWidth() / 23) - 1), 5.40, (this.getWidth() / 23),
				(this.getHeight() / 23));
		gc.fillOval((this.getWidth() - (this.getWidth() / 23) - 7), 6.2, (this.getWidth() / 23),
				(this.getHeight() / 23));
	}

	private void drawBackBody(GraphicsContext gc) {
		Color[] colors = { Color.AQUA, Color.DEEPPINK, Color.ORANGE, Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.VIOLET };
		Random rd = new Random();
		double xCoord = 22;
		double yCoord = 10;
		for (int in = 0; in < 3; in++) {
			Color color = colors[rd.nextInt(8)];
			gc.setFill(color);
			gc.fillOval(xCoord, yCoord, (this.getWidth() / 8), (this.getHeight() / 5));
			xCoord = xCoord + (this.getWidth() / 10);
		}
		for (int in = 0; in < 3; in++) {
			Color color = colors[rd.nextInt(8)];
			gc.setFill(color);
			gc.fillOval(xCoord, yCoord, (this.getWidth() / 8), (this.getHeight() / 5));
			xCoord = xCoord + (this.getWidth() / 14);
			yCoord = yCoord + 6;
		}

	}

	private void drawBackBodyRight(GraphicsContext gc) {
		Color[] colors = { Color.AQUA, Color.DEEPPINK, Color.ORANGE, Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.VIOLET };
		Random rd = new Random();
		double xCoord = this.getWidth() - (this.getWidth() / 8) - 22;
		double yCoord = 10;
		for (int in = 0; in < 3; in++) {
			Color color = colors[rd.nextInt(8)];
			gc.setFill(color);
			gc.fillOval(xCoord, yCoord, (this.getWidth() / 8), (this.getHeight() / 5));
			xCoord = xCoord - (this.getWidth() / 9);
		}
		for (int in = 0; in < 3; in++) {
			Color color = colors[rd.nextInt(8)];
			gc.setFill(color);
			gc.fillOval(xCoord, yCoord, (this.getWidth() / 8), (this.getHeight() / 5));
			xCoord = xCoord - (this.getWidth() / 14);
			yCoord = yCoord + 6;
		}

	}

	private void drawWings(GraphicsContext gc) {
		Color[] colors = { Color.BLACK, Color.GREEN, Color.BLUE };
		Random rd = new Random();
		Color color = colors[rd.nextInt(3)];
		this.wingColor = color;
		gc.setFill(color);
		double[] xCoords = { 1, (this.getWidth() / 2.2), (this.getWidth() - 10), (this.getWidth() - 20), (this.getWidth() / 2.2), 10 };
		double[] yCoords = { 0.0, 19, 0.0, 0.0, 19, 0.0 };
		gc.fillPolygon(xCoords, yCoords, 6);
		double[] xCoords2 = { 15, (this.getWidth() / 2.2), (this.getWidth() - 25), (this.getWidth() - 30), (this.getWidth() / 2.2), 20 };
		double[] yCoords2 = { 0.0, 19, 0.0, 0.0, 19, 0.0 };
		gc.fillPolygon(xCoords2, yCoords2, 6);

	}

	private void drawLegs(GraphicsContext gc) {
		gc.setStroke(Color.BLACK);
		double[] xCoords = { (this.getWidth() / 4), (this.getWidth() / 5), 20 };
		double[] yCoords = { 20, 25, 35 };
		gc.strokePolyline(xCoords, yCoords, 3);
		double[] xCoords2 = { (this.getWidth() / 4) + 8, (this.getWidth() / 5) + 8, 28 };
		double[] yCoords2 = { 20, 25, 35 };
		gc.strokePolyline(xCoords2, yCoords2, 3);
		double[] xCoords3 = { (this.getWidth() / 4) + 16, (this.getWidth() / 5) + 16, 36 };
		double[] yCoords3 = { 20, 25, 35 };
		gc.strokePolyline(xCoords3, yCoords3, 3);

	}
	
	private void drawLegsRight(GraphicsContext gc) {
		gc.setStroke(Color.BLACK);
		double[] xCoords = { (this.getWidth() - (this.getWidth() / 4)), (this.getWidth() - (this.getWidth() / 5)), (this.getWidth() - 20)};
		double[] yCoords = { 20, 25, 35 };
		gc.strokePolyline(xCoords, yCoords, 3);
		double[] xCoords2 = { (this.getWidth() - (this.getWidth() / 4) - 8), (this.getWidth() - (this.getWidth() / 5) - 8), (this.getWidth() - 28)};
		double[] yCoords2 = { 20, 25, 35 };
		gc.strokePolyline(xCoords2, yCoords2, 3);
		double[] xCoords3 = {  (this.getWidth() - (this.getWidth() / 4) - 16), (this.getWidth() - (this.getWidth() / 5) - 16), (this.getWidth() - 36)};
		double[] yCoords3 = { 20, 25, 35 };
		gc.strokePolyline(xCoords3, yCoords3, 3);

	}

	@Override
	public String toString() {
		return "DragonFly width=" + this.getWidth() + " Wing-Color=" + this.wingColor + " Speed=" + this.getSpeed();
	}

}
