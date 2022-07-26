package edu.westga.cs1302.project2;

import edu.westga.cs1302.project2.model.Sky;
import edu.westga.cs1302.project2.model.manager.SkyManager;
import edu.westga.cs1302.project2.view.output.OutputFormatter;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * The Class SkyAnimation.
 * 
 * @author CS1302
 * @version 1.0
 */

public class SkyAnimation extends Application {
	
	private static final String TITLE = "Project 2 by William Jones";
	private SkyManager skyManager = new SkyManager();

	@Override
	public void start(Stage primaryStage) {
		try {
			Scene scene = this.setupGui();
			primaryStage.setScene(scene);
			primaryStage.setTitle(TITLE);
			primaryStage.show();

			AnimationTimer timer = this.setupAnimaterTImer();
			timer.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Setup gui.
	 *
	 * @return the scene
	 */
	private Scene setupGui() {
		Group root = new Group();
		Scene scene = new Scene(root, Sky.WIDTH, Sky.HEIGHT + 200);

		VBox vbox = new VBox();
		this.skyManager.setupBugsAndClouds();
		vbox.getChildren().add(this.skyManager);

		TextArea skyReport = new TextArea();
		skyReport.setMinHeight(200);
		skyReport.setEditable(false);
		OutputFormatter outputFormatter = new OutputFormatter();
		skyReport.setText(outputFormatter.buildReport(this.skyManager.getSky()));

		vbox.getChildren().add(skyReport);
		root.getChildren().add(vbox);
		
		return scene;
	}

	/**
	 * Setup animationTimer.
	 *
	 * @return the animation timer
	 */
	private AnimationTimer setupAnimaterTImer() {
		AnimationTimer timer = new AnimationTimer() {
			private long lastUpdate = 0;

			@Override
			public void handle(long currentTime) {
				if (currentTime - this.lastUpdate >= 300000000) {
					this.lastUpdate = currentTime;
					SkyAnimation.this.skyManager.update();
				}
			}
		};
		return timer;
	}

	/**
	 * The main method - entry point for the program.
	 *
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param args            the arguments - not used
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
