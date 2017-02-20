import ecs100.*;
import java.awt.Color;

public class Drawer {
	//Constructor: Set up interface
	public Drawer() {
		UI.addButton("Draw a lollipop", this::drawOneLollipop);
		UI.addButton("Draw many lollipops", this::drawManyLollipops);
		UI.addButton("Clear", this::clearGraphics);
	}

	//method to draw each lollipop
	public void drawLollipop(double x, double y) {
		UI.setColor(Color.black);
		UI.setLineWidth(10);
		UI.drawLine(x, y, x, y + 200);
		UI.setLineWidth(1);
		UI.setColor(Color.getHSBColor((float) Math.random(), 1.0f, 0.5f));
		UI.fillOval(x - 40, y - 40, 80, 80);
	}
	
	//method to draw one lollipop
	public void drawOneLollipop() {
		drawLollipop(300,200);
	}
	
	//method to draw many lollipops
	public void drawManyLollipops() {
		int numLollipops = UI.askInt("How many lollipops?");
		for (int i = 0; i < numLollipops; i++) {
			double x = 40 + (Math.random()* 700);
			double y = 40 + (Math.random()* 500);
			
			drawLollipop(x,y);
		}
	}
	
	//clear panes
	public void clearGraphics() {
		UI.clearPanes();
	}

	//main method - calls all methods inside drawer class
	public static void main(String[] args) {
		UI.initialise();
		new Drawer();
	}
}
