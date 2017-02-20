// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN131 assignment.
// You may not distribute it in any other way without permission.

/* Code for SWEN131
 * Name:
 * Usercode:
 * ID:
 */

import java.awt.Color;

import ecs100.*;

public class PatternDrawer{

    public static final double boardLeft = 50;   // Top left corner of the board
    public static final double boardTop = 50;
    public static final double boardSize = 300;  // The size of the board on the window

    /** Draw a square grid board with white squares.
     *  Asks the user for the number of squares on each side
     *
     * CORE
     */
    public void drawGridBoard(){
        UI.clearGraphics();
        int num = UI.askInt("How many rows:");
        int squares = num;
        double widthOfSquare = boardSize/num;
        
        for (num = 1; num < squares; num++) {
        	double x = boardLeft + (widthOfSquare * num);
        	UI.drawRect(x, boardTop, widthOfSquare, boardSize);
        	UI.println("I loop" + "X = " + x + " Y = " + boardTop);
        }
        
        for (num = 0; num < squares; num++) {
    		double y = boardTop + (widthOfSquare * num);
    		UI.drawRect(boardLeft, y, boardSize, widthOfSquare);
    		UI.println("J loop" + "X = " + boardLeft + " Y = " + y);
    	}
    }

    /** Illusion
     * a pattern that makes dark circles appear in the intersections
     * when you look at it.
     **/
    public void drawIllusion(){
        UI.clearGraphics();
        int num = UI.askInt("How many rows:");
        int square = num;
        double widthOfSquare = boardSize / num;
        // draw black square
        UI.setColor(Color.black);
		UI.fillRect(boardLeft, boardTop, boardSize, boardSize);
        
		for (square = 1; square < num; square++) {
        	//draw white horizontal lines
			double rx1 = boardLeft;
        	double ry1 = boardTop + (widthOfSquare * square);
        	double rx2 = boardLeft + boardSize;
        	double ry2 = boardTop + (widthOfSquare * square);
    		UI.setLineWidth(10);
    		UI.setColor(Color.white);
    		UI.drawLine(rx1, ry1, rx2, ry2);
    		UI.println("RX1 = " +  rx1 + " RY1 = " + ry1 + " RX2 = " + rx2 + " RY2 = " + ry2);
    		//draw white vertical lines
    		double cx1 = boardLeft + (widthOfSquare * square);
            double cy1 = boardTop;
            double cx2 = boardLeft + (widthOfSquare * square);
            double cy2 = boardTop + boardSize;
            UI.setLineWidth(10);
        	UI.setColor(Color.white);
        	UI.drawLine(cx1, cy1, cx2, cy2);
        	UI.println("CX1 = " +  cx1 + " Cy1 = " + cy1 + " CX2 = " + cx2 + " CY2 = " + cy2);
    	}
    }

    /** Draw a checkered board with alternating black and white squares
     *    Asks the user for the number of squares on each side
     *
     * COMPLETION
     */
    public void drawCheckersBoard(){
        UI.clearGraphics();
        int num = UI.askInt("How many rows:");
        double widthOfSquare = boardSize/num;
        Color evenSquare = Color.gray;
        Color oddSquare = Color.black;
        int row = 0;
        int column = 0;
        
        for (row = 0; row < num; row++) {
        	for (column = 0; column < num; column++) {
        		double x = boardLeft + ((boardSize/num) * row);
        		double y = boardTop + ((boardSize/num) * column);
        		if ((row+column)%2 == 0) {
        			UI.setColor(evenSquare);
        			UI.fillRect(x, y, widthOfSquare, widthOfSquare);
        		} else {
        			UI.setColor(oddSquare);
        			UI.fillRect(x, y, widthOfSquare, widthOfSquare);
        		}
        	}
        }
    }
       
    
    
    /** Draw a board made of concentric circles, 2 pixel apart
     *  Asks the user for the number of squares on each side
     */
    public void drawConcentricBoard(){
        UI.clearGraphics();
        int num = UI.askInt("How many rows: ");
        double widthOfCircle = boardSize/num;
 
        double row;
        double column;
        double circle;
        double numInnerCircles = ((boardSize/num) / 4);
                
        for (row = 0; row < num; row++) {
        	for (column = 0; column < num; column++) {
        		double x = boardLeft + ((boardSize/num) * row);
        		double y = boardTop + ((boardSize/num) * column);
        		UI.drawOval(x, y, widthOfCircle, widthOfCircle);
        		//UI.println("x: " + x + " y: " + " width: " + widthOfCircle);
        		for (circle = 0; circle < numInnerCircles; circle++) { 
        			double innerX = x + (2 * circle);
        			double innerY = y + (2 * circle);
        			double innerWidthOfCircle = widthOfCircle - (4 * circle);
        			UI.drawOval(innerX, innerY, innerWidthOfCircle, innerWidthOfCircle);
        			//UI.println("number of inner circles: " + numInnerCircles);
        			//UI.println("innerX: " + innerX + " innerY: " + innerY + " inner Width: " + innerWidthOfCircle);
        		}
        	}
        }
    }    
    
}


