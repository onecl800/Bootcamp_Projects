
// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN131 exercise.
// You may not distribute it in any other way without permission.

import ecs100.*;
import java.io.*;
import java.util.*;
import java.awt.Color;

/**
 * This program will read the data from a file into an ArrayList, which means
 * that it can analyse the numbers more easily and in more different ways. It
 * can also cope with much larger sets of numbers. The numbers are guaranteed to
 * be integers but the values can be negative and the signal swings above and
 * below zero.
 *
 * There are 11 methods you are to complete, all focusing on the ArrayList of
 * data. CORE doRead: reads numbers into an ArrayList. doDisplay: displays the
 * waveform. doReportDistortion: prints out the fraction of time the signal is
 * distorted. COMPLETION doSpread: displays the spread with two horizontal lines
 * and returns its value. doDisplayDistortion: shows in red the distorted part
 * of the signal. doHighlightPeaks: plots the peaks with small green circles.
 * CHALLENGE doNormalise: normalises all the values down so there is no
 * distortion. upperEnvelope: displays the upper envelope. lowerEnvelope:
 * displays the lower envelope. doSave: saves the current waveform values into a
 * file. select and edit: let the user select a regions of the waveform with the
 * mouse to remove them. Add a save button to save the edited values.
 */

public class WaveformAnalyser {
	// Fields
	private ArrayList<Double> waveform; // the field to hold the ArrayList of values

	// Constant: the threshold for the distortionLevel and showDistortion methods
	public static final double THRESHOLD = 200;

	// Constants: the dimensions of the graph for the displayWaveform method
	public static final int GRAPH_LEFT = 10;
	public static final int ZERO_LINE = 360;

	// Constant fields holding the size of the circles for the highlightPeaks method
	public static final int SIZE_CIRCLE = 10;

	/**Exercise 1
	 * [CORE] Clears the panes, Creates an ArrayList stored in a field, then
	 * Asks user for a waveform file (eg waveform1.txt) Reads data from the file
	 * into the ArrayList
	 */
	public void doRead() {
		try {
			UI.clearPanes();

			waveform = new ArrayList<Double>();

			String fname = UIFileChooser.open();
			Scanner scanner;
			scanner = new Scanner(new File(fname));
			while (scanner.hasNextDouble()) {
				double nextReading = scanner.nextDouble();
				//add each nextReading to arrayList waveform
				waveform.add(nextReading);
			}
			/* # YOUR CODE HERE - might need something here later on*/

			UI.println("Read " + this.waveform.size() + " data points from " + fname);
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**Exercise 2
	 * [CORE] Displays the waveform as a line graph, The n'th value in waveform
	 * is displayed at x-position is GRAPH_LEFT + n y-position is ZERO_LINE -
	 * the value Plots a line graph of all the points with a blue line between
	 * each pair of adjacent points Draw the horizontal line representing the
	 * value zero. Uses GRAPH_LEFT and ZERO_LINE for the dimensions and
	 * positions of the graph. Don't worry if the lines go off the window
	 */
	public void doDisplay() {
		if (this.waveform == null) { // there is no data to display
			UI.println("No waveform to display");
			return;
		}
		UI.clearGraphics();

		// draw x axis (showing where the value 0 will be)
		UI.setColor(Color.black);
		UI.drawLine(GRAPH_LEFT, ZERO_LINE, GRAPH_LEFT + this.waveform.size(), ZERO_LINE);

		// plot points: blue line between each pair of values
		for (int i = 0; i < waveform.size() - 1; i++) {
			double x1 = GRAPH_LEFT + i;
			double y1 = ZERO_LINE - waveform.get(i);
			double x2 = GRAPH_LEFT + (i) + 1;
			double y2 = ZERO_LINE - waveform.get(i + 1);
			UI.setColor(Color.blue);
			UI.drawLine(x1, y1, x2, y2);
		}
	}

	/**Exercise 3
	 * [CORE] Computes and prints out the fraction of time the signal is
	 * distorted. This fraction of time is defined as the number of distorted
	 * values, divided by the number of values. A distorted value is defined as
	 * one whose absolute value is greater than the value of THRESHOLD [Hint]
	 * You may find Math.abs() useful for this method - it computes the absolute
	 * value
	 */
	public void doReportDistortion() {
		if (this.waveform == null) { // there is no data to analyse
			UI.println("No signal to analyse and report on");
			return;
		}
		double totalDistortedValues = 0;
		
		for (int i = 0; i < waveform.size()-1; i++) {
			if (Math.abs(waveform.get(i)) > THRESHOLD) {
				totalDistortedValues++;
				UI.println(waveform.get(i));
			}
		}
		
		double fraction = totalDistortedValues / waveform.size();
		UI.printf("Fraction of time the signal is distorted %4.3f\n", fraction);
	}

	/**Exercise 4
	 * [COMPLETION] The spread is the difference between the maximum and minimum
	 * values of the waveform. Finds the maximum and minimum values, then
	 * Displays the spread by drawing two horizontal lines on top of the
	 * waveform: one green line for the maximum value, and one red line for the
	 * minimum value.
	 */
	public void doSpread() {
		if (this.waveform == null) { // there is no data to display
			UI.println("No waveform to display");
			return;
		}
		this.doDisplay();
		
		double maxValue = 0;
		double minValue = 0;
		
		for (int i = 0; i < waveform.size()-1; i++) {
			if (waveform.get(i) > maxValue) {
				maxValue = waveform.get(i);	
			}
		}
		UI.println("max value: " + maxValue);
		
		UI.setColor(Color.green);
		UI.drawLine(GRAPH_LEFT, ZERO_LINE - maxValue, GRAPH_LEFT + waveform.size(), ZERO_LINE - maxValue);
		
		for (int j = 0; j < waveform.size()-1; j++) {
			if (waveform.get(j) < minValue) {
				minValue = waveform.get(j);		
			}
		}
		UI.println("min value: " + minValue);
		
		UI.setColor(Color.red);
		UI.drawLine(GRAPH_LEFT, ZERO_LINE - minValue, GRAPH_LEFT + waveform.size(), ZERO_LINE - minValue);
		
		double maxLineY = ZERO_LINE - maxValue;
		double minLineY = ZERO_LINE - minValue;
		UI.println("Max line = " + maxLineY + " Min line = " + minLineY);
	}

	/**Exercise 5
	 * [COMPLETION] [Fancy version of doDisplay] Display the waveform as a line
	 * graph. Draw a line between each pair of adjacent points * If neither of
	 * the points is distorted, the line is BLUE * If either of the two end
	 * points is distorted, the line is RED Draw the horizontal lines
	 * representing the value zero and thresholds values. Uses THRESHOLD to
	 * determine distorted values. Uses GRAPH_LEFT and ZERO_LINE for the
	 * dimensions and positions of the graph. [Hint] You may find Math.abs(int
	 * a) useful for this method. You may assume that all the values are between
	 * -250 and +250.
	 */
	public void doDisplayDistortion() {
		if (this.waveform == null) { // there is no data to display
			UI.println("No waveform to display");
			return;
		}
		UI.clearGraphics();

		// draw zero axis
		UI.setColor(Color.black);
		UI.drawLine(GRAPH_LEFT, ZERO_LINE, GRAPH_LEFT + this.waveform.size(), ZERO_LINE);

		// draw threshold lines
		UI.setColor(Color.orange);
		UI.drawLine(GRAPH_LEFT, ZERO_LINE - THRESHOLD, GRAPH_LEFT + waveform.size(), ZERO_LINE - THRESHOLD);
		UI.drawLine(GRAPH_LEFT, ZERO_LINE + THRESHOLD, GRAPH_LEFT + waveform.size(), ZERO_LINE + THRESHOLD);;
	
		for (int i= 0; i < waveform.size()-1; i++) {
			if (Math.abs(waveform.get(i)) > THRESHOLD) {
				UI.setColor(Color.red);
				UI.drawLine(GRAPH_LEFT + i, ZERO_LINE - waveform.get(i), GRAPH_LEFT + (i+1), ZERO_LINE - waveform.get(i+1));
			} else {
				UI.setColor(Color.blue);
				UI.drawLine(GRAPH_LEFT + i, ZERO_LINE - waveform.get(i), GRAPH_LEFT + (i+1), ZERO_LINE - waveform.get(i+1));
			}
		}
	}

	/**Exercise 6
	 * [COMPLETION] Plots the peaks with small green circles. A peak is defined
	 * as a value that is greater or equals to both its neighbouring values.
	 * Note the size of the circle is in the constant SIZE_CIRCLE You may assume
	 * that peaks values differ from their neighbouring points.
	 */
	public void doHighlightPeaks() {
		this.doDisplayDistortion(); // use doDisplay if doDisplayDistortion isn't complete
		
		for (int i = 1; i < waveform.size()-1; i++) {
			
			if (Math.abs(waveform.get(i)) >= Math.abs(waveform.get(i-1)) 
					&& Math.abs(waveform.get(i)) >= Math.abs(waveform.get(i+1))) {
				UI.setColor(Color.green);
				UI.drawOval((GRAPH_LEFT + i) - 5, (ZERO_LINE - waveform.get(i)) - 5, SIZE_CIRCLE, SIZE_CIRCLE);
				double x = GRAPH_LEFT + i;
				double y = ZERO_LINE - waveform.get(i);
				UI.println("X = " + x + " Y = " + y);
			}
		}
	}

	/**Exercise 7
	 * [CHALLENGE] Finds the largest value (positive or negative) in the
	 * waveform, and normalises all the values down so that the largest value is
	 * now equal to the distortion threshold. Then redraws the waveform.
	 */
	public void doNormalise() {
		//draw zero line
		UI.setColor(Color.black);
		UI.drawLine(GRAPH_LEFT, ZERO_LINE, GRAPH_LEFT + this.waveform.size(), ZERO_LINE);
		
		// draw threshold lines
		UI.setColor(Color.orange);
		UI.drawLine(GRAPH_LEFT, ZERO_LINE - THRESHOLD, GRAPH_LEFT + waveform.size(), ZERO_LINE - THRESHOLD);
		UI.drawLine(GRAPH_LEFT, ZERO_LINE + THRESHOLD, GRAPH_LEFT + waveform.size(), ZERO_LINE + THRESHOLD);
		
		//find largest value
		double largestValue = 0;
		for (int i = 0; i < waveform.size()-1; i++) {
			if (Math.abs(waveform.get(i)) > largestValue) {
				largestValue = waveform.get(i);
			}
		}
		UI.println("largest value: " + largestValue);
		
		//work out formula for normalisation, use it to redraw every y value
		for (int j = 0; j < waveform.size()-1; j++) {
			
			double newY = waveform.get(j) * (THRESHOLD / largestValue);
			double newY2 = waveform.get(j+1) * (THRESHOLD / largestValue);
			
			double x1 = GRAPH_LEFT + j;
			double y1 = ZERO_LINE - newY;
			double x2 = GRAPH_LEFT + (j + 1);
			double y2 = ZERO_LINE - newY2;
			
			UI.setColor(Color.gray);
			UI.drawLine(x1, y1, x2, y2);
			UI.println("X1 = " + x1 + " Y1 = " + y1 + " X2 =  " + x2 + " Y2 = " + y2);
		}
		this.doDisplayDistortion(); 
	}

	public void doEnvelope() {
		if (this.waveform == null) { // there is no data to display
			UI.println("No waveform to display");
			return;
		}
		this.doDisplay(); // display the waveform
		this.upperEnvelope();
		this.lowerEnvelope();
	}

	/**Exercise 8
	 * [CHALLENGE] Displays the upper envelope with GREEN lines connecting all
	 * the peaks. A peak is defined as a point that is greater or equal to
	 * *both* neighbouring points. DO NOT clear the graphics as we also want to
	 * view the waveform.
	 */
	public void upperEnvelope() {
		
		for (int i = 1; i < waveform.size()-1; i++) {
			double point = waveform.get(i);
			double prevPoint = waveform.get(i-1);
			double nextPoint = waveform.get(i+1);
			
			if (point >= prevPoint && point >= nextPoint) {
				
				for (int j = (i+1); j < waveform.size()-1; j++) {
					double point2 = waveform.get(j);
					double prevPoint2 = waveform.get(j-1);
					double nextPoint2 = waveform.get(j+1);
				
					if (point2 >= prevPoint2 && point2 >= nextPoint2) {
						double peak1X = GRAPH_LEFT + i;
						double peak1Y = ZERO_LINE - point;
						double peak2X = GRAPH_LEFT + j;
						double peak2Y = ZERO_LINE - point2;
						
						UI.setColor(Color.green);
						UI.drawLine(peak1X, peak1Y, peak2X, peak2Y);
						UI.println("X1: " + peak1X + " Y1: " + peak1Y + " X2: " + peak2X + " Y2:" + peak2Y);
						UI.println();
						break;
					}	
				}			
			}
		}
	}

	/**Exercise 9
	 * [CHALLENGE] Displays the lower envelope with RED lines connecting all the
	 * "negative" peaks. A "negative" peak is defined as a point that is smaller
	 * or equal to *both* neighbouring points. DO NOT clear the graphics as we
	 * also want to view the waveform.
	 */
	public void lowerEnvelope() {
		for (int i = 1; i < waveform.size()-1; i++) {
			double point = waveform.get(i);
			double prevPoint = waveform.get(i-1);
			double nextPoint = waveform.get(i+1);
			
			if (point <= prevPoint && point <= nextPoint) {
				
				for (int j = (i+1); j < waveform.size()-1; j++) {
					double point2 = waveform.get(j);
					double prevPoint2 = waveform.get(j-1);
					double nextPoint2 = waveform.get(j+1);
				
					if (point2 <= prevPoint2 && point2 <= nextPoint2) {
						double peak1X = GRAPH_LEFT + i;
						double peak1Y = ZERO_LINE - point;
						double peak2X = GRAPH_LEFT + j;
						double peak2Y = ZERO_LINE - point2;
						
						UI.setColor(Color.red);
						UI.drawLine(peak1X, peak1Y, peak2X, peak2Y);
						UI.println("X1: " + peak1X + " Y1: " + peak1Y + " X2: " + peak2X + " Y2:" + peak2Y);
						UI.println();
						break;
					}
				}
			}
		}
	}
	
	/**Exercise 10
	 * [CHALLENGE] Saves the current waveform values into a file
	 */
	public void doSave() {
		/* # YOUR CODE HERE */

	}

	//private int index1;

	/**Exercise 11
	 * [CHALLENGE] Lets user select a region of the waveform with the mouse and
	 * deletes that section of the waveform.
	 */
	public void doMouse(String action, double x, double y) {
		/* # YOUR CODE HERE */

	}

	/** ---------- The code below is already written for you ---------- **/

	/**
	 * Constructor: Set up the ten buttons and mouselistener
	 */
	public WaveformAnalyser() {
		// core
		UI.addButton("Read Data", this::doRead);
		UI.addButton("Display Waveform", this::doDisplay);
		UI.addButton("Report Distortion", this::doReportDistortion);
		// completion
		UI.addButton("Spread", this::doSpread);
		UI.addButton("Display Distortion", this::doDisplayDistortion);
		UI.addButton("Peaks", this::doHighlightPeaks);
		// challenge
		UI.addButton("Normalise", this::doNormalise);
		UI.addButton("Envelope", this::doEnvelope);
		UI.addButton("Save", this::doSave);
		UI.addButton("Quit", UI::quit);
		UI.setMouseListener(this::doMouse); // only for challenge

	}

	// Main
	public static void main(String[] arguments) {
		new WaveformAnalyser();
	}

}
