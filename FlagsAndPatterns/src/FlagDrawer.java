// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN131 assignment.
// You may not distribute it in any other way without permission.

/* Code for SWEN131
 * Name:
 * Usercode:
 * ID:
 */

import ecs100.*;
import java.awt.Color;
import javax.swing.JColorChooser;

public class FlagDrawer {
	
    public static final double width = 200;
    public static final double height = 133;

    /**
     * asks user for a position and three colours, then calls the
     * drawThreeColourFlagCore method, passing the appropriate arguments
     *
     * CORE
     */
    public void testCore(){
    	//method to choose placement and color of flag
        double left = UI.askDouble("left of flag");
        double top = UI.askDouble("top of flag");
        UI.println("Now choose the colours");
        Color stripe1 = JColorChooser.showDialog(null, "First Stripe", Color.white);
        Color stripe2 = JColorChooser.showDialog(null, "Second Stripe", Color.white);
        Color stripe3 = JColorChooser.showDialog(null, "Third Stripe", Color.white);
        //// Uncomment this line when you start work on the core:
        this.drawThreeColourFlagCore(left, top, stripe1, stripe2, stripe3 );
        //UI.println("You need to uncomment the line above this in testCore.");
    }

    /**
     * draws a three colour flag consisting of three vertical equal-width stripes
     * at the given position
     * CORE
     */
    //method to draw flag using info from testCore
    public void drawThreeColourFlagCore(double left, double top, Color stripe1, Color stripe2, Color stripe3){
    	UI.setColor(stripe1);
        UI.fillRect(left, top, width / 3, height);
        UI.setColor(stripe2);
        UI.fillRect(left + width / 3, top, width / 3, height);
        UI.setColor(stripe3);
        UI.fillRect(left + (width / 3) * 2, top, width / 3, height);
   }

    /**
     * draws multiple flag made up of three equal size stripes by calling the
     * drawThreeColourFlagCompletion method, passing the appropriate arguments
     *
     * COMPLETION
     */
    //method to define location, direction of stripes and colors of flag
    public void testCompletion(){
        //// Uncomment these lines when you start working on the completion:
        this.drawThreeColourFlagCompletion(true, 20, 50, Color.black, Color.yellow, Color.red);               // Belgium
        this.drawThreeColourFlagCompletion(false, 250, 100, Color.black, Color.red, Color.yellow);            // Germany
        this.drawThreeColourFlagCompletion(true, 140, 430, Color.blue, Color.white, Color.red);               // France
        this.drawThreeColourFlagCompletion(false, 470, 30, Color.red, Color.white, Color.blue);               // The Netherlands
        this.drawThreeColourFlagCompletion(false, 50, 250, Color.white, Color.blue, Color.red);               // Russia
        this.drawThreeColourFlagCompletion(true, 290, 270, Color.red, Color.yellow, Color.green.darker());    // Guinea
        //UI.println("You need to uncomment the lines above this in testCompletion.");
    }

    /**
     * draws a three colour flag consisting of three equal-size stripes
     * at the given position
     * The stripes can be either vertical or horizontal
     *
     * COMPLETION
     */
    
    //method to draw flag using info from testCompletion
    public void drawThreeColourFlagCompletion(boolean check, double left, double top, Color color1, Color color2, Color color3) {
    	
    	if (check) {
    		UI.setColor(color1);
    		UI.fillRect(left, top, width/3, height);
    		UI.setColor(color2);
    		UI.fillRect(left + width/3, top, width/3, height);
    		UI.setColor(color3);
    		UI.fillRect(left + (width/3) * 2, top, width/3, height);
    	} else {
    		UI.setColor(color1);
    		UI.fillRect(left, top, width, height/3);
    		UI.setColor(color2);
    		UI.fillRect(left, top + height/3, width, height/3);
    		UI.setColor(color3);
    		UI.fillRect(left, top + (height/3) * 2, width, height/3);
    	}
    }
}