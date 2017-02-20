// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN131 assignment.
// You may not distribute it in any other way without permission.

/* Code for SWEN131 Individual Project - if
 * Name:
 * Usercode:
 * ID:
 */

import ecs100.*;

/**
 * Reads a date from the user as three integers, and then checks that the date is valid
 */

public class DateValidator {

    /**
     * Asks user for a date, then determines whether the date
     *    specified by the three integers is a valid date.
     * For the Core, you may assume that
     * - All months have 31 days, numbered 1 to 31
     * - The months run from 1 to 12
     * - Years start from 1
     */
    public void validateDateCore(){
    	double day = UI.askDouble("Day:");
    	double month = UI.askDouble("Month:");
    	double year = UI.askDouble("Year:");
    	
    	if (day >= 1 && day <= 31 && month >= 1 && month <= 12 && year > 0) {
    		UI.println("Your date is valid");
    	} else {
    		UI.println("Your date is not valid");
    	}
    }

    /**
     * Asks user for a date, then determines whether the date
     *    specified by the three integers is a valid date.
     * For the Completion, you should also check that
     * - Months have the correct number of days
     * - On leap years February should have 29 days.
     *    A year is a leap year if:
     *       - The year can be evenly divided by 4 but not 100
     *       - The year can be evenly divided by 400
     */
    public void validateDateCompletion(){
    	double day = UI.askDouble("Day:");
    	double month = UI.askDouble("Month:");
    	double year = UI.askDouble("Year:");
    	
    	if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && day >= 1 && day <=31 && year > 0) {
    		UI.println("Your date is valid");
    	} else if ((month == 4 || month == 6 || month == 9 || month == 11) && day >= 1 && day <= 30 && year > 0) {
    		UI.println("Your date is valid");
    	} else if (month == 2 && year > 0) {
    		if (day >=0 && day <= 28) {
    			UI.println("Your date is valid");
    		}
    		else if (day == 29 && (year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
    			UI.println("Your date is valid");
    		} else {
    			UI.println("Your date is not valid");
    		}
    	} else {
    		UI.println("Your date is not valid");
    	}
    }

    /**
     * For the challenge, your program should be extended to deal with the transition from the Julian to Gregorian calendar.
     * The program should look at the date, determine whether this should be a Julian or Gregorian date, and test it appropriately.
     * You will need to find the rules of the Julian calendar yourselves.
     *
     */
    public void validateDateChallenge(){
    	double day = UI.askDouble("Day:");
    	double month = UI.askDouble("Month:");
    	double year = UI.askDouble("Year:");
    	
    	//rules of Julian calender
    	if (year <= 1582) {
    		if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && day >= 1 && day <=31) {
        		UI.println("Your date is valid");
        	} else if ((month == 4 || month == 6 || month == 9 || month == 11) && day >= 1 && day <= 30) {
        		UI.println("Your date is valid");
        	} else if (month == 2) {
        		if (day <=28){
        			UI.println("Your date is valid");
        		} else if (day == 29 && year % 4 == 0){
        			UI.println("Your date is valid");
        		} else {
        			UI.println("Your date is not valid");
        		}
        	} else {
        		UI.println("Your date is not valid");
        	}
    	//rules of Gregorian calender
    	} else if (year >= 1583) {
    		if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && day >= 1 && day <=31) {
        		UI.println("Your date is valid");
        	} else if ((month == 4 || month == 6 || month == 9 || month == 11) && day >= 1 && day <= 30) {
        		UI.println("Your date is valid");
        	} else if (month == 2) {
        		if (day >=0 && day <= 28) {
        			UI.println("Your date is valid");
        		}
        		else if (day == 29 && (year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
        			UI.println("Your date is valid");
        		} else {
        			UI.println("Your date is not valid");
        		}
        	} else {
        		UI.println("Your date is not valid");
        	}
    	} else {
    		UI.println("Your date is not valid");
    	}
    }

    /** ---------- The code below is already written for you ---------- **/
    /** Constructor: set up user interface */
    public DateValidator(){
        UI.initialise();
        UI.addButton("Clear", UI::clearText );
        UI.addButton("Validate Date Core", this::validateDateCore );
        UI.addButton("Validate Date Completion", this::validateDateCompletion );
        UI.addButton("Validate Date Challenge", this::validateDateChallenge);
        UI.addButton("Quit", UI::quit );
        UI.setDivider(1);       // Expand the text area
    }

    public static void main(String[] args) {
    	new DateValidator();
    }
}

