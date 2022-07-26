package edu.westga.cs1302.project2.view.output;

import edu.westga.cs1302.project2.model.Sky;
import edu.westga.cs1302.project2.model.WidthAndSpeedComparator;
import edu.westga.cs1302.project2.view.resources.UI;

/**
 * OutputFormatter builds summaries and reports for Skys.
 *
 * @author CS1302
 * @version 1.0
 */
public class OutputFormatter {

	/**
	 * Initializes the OutputFormatter
	 */
	public OutputFormatter() {
	}

	/**
	 * Creates a report by analyzing a given sky.
	 * 
	 * @precondition sky != null
	 * @postcondition none
	 *
	 * @param sky sky to analyze
	 * @return String with the given report
	 */
	public String buildReport(Sky sky) {
		if (sky == null) {
			throw new IllegalArgumentException(UI.ExceptionMessages.NULL_SKY);
		}

		String summary = "Sky Report:";
		summary += System.lineSeparator();
		summary += System.lineSeparator();
		summary += "Number of Butterflies: " + sky.numberOfButterflies() + System.lineSeparator();
		summary += "Number of Dragonflies: " + sky.numberOfDragonflies() + System.lineSeparator();
		summary += System.lineSeparator();
		summary += "Smallest Butterfly : " + sky.findSmallestButterfly() + System.lineSeparator();
		summary += "Largest Butterfly : " + sky.findLargestButterfly() + System.lineSeparator();
		summary += "Smallest Dragonfly : " + sky.findSmallestDragonfly() + System.lineSeparator();
		summary += "Largest Dragonfly : " + sky.findLargestDragonfly() + System.lineSeparator();
		summary += System.lineSeparator();
		summary += "Insects in sorted order" + System.lineSeparator();
		sky.sort(new WidthAndSpeedComparator());
		for (String insect : sky.insectsInfo()) {
			summary += insect + System.lineSeparator();
		}

		return summary;
	}

}

