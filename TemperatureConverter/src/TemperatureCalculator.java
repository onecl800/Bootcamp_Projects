import java.math.RoundingMode;
import java.text.DecimalFormat;

import ecs100.*;

public class TemperatureCalculator {
	// Constructor: Set up interface
	public TemperatureCalculator() {
		UI.initialise();
		UI.addButton("F->C", this::fahrenheitToCelsius);
		UI.addButton("Formula", this::printFormula);
		UI.addButton("cm->Inches", this::cmToInches);
		UI.addButton("kg->pounds", this::kgToPounds);
		UI.addButton("Calculate BMI", this::bmiCalculator);
	}

	//Convert from Fahrenheit to Celsius
	public void fahrenheitToCelsius() {
		double fahren = UI.askDouble("Fahrenheit:");
		double celsius = (fahren - 32) * 5 / 9;
		UI.println(fahren + "F  is " + celsius + " C");
	}

	// Print conversion formula 
	public void printFormula() {
		UI.println("Celsius = (Fahrenheit - 32) *5/9");
	}
	
	//convert cm to inches
	public void cmToInches() {
		double cm = UI.askDouble("Centimetres:");
		double inches = cm / 2.54;
		UI.println(cm + " cm is " + inches + " inches");	
	}
	
	//convert kg to pounds
	public void kgToPounds() {
		double kg = UI.askDouble("Kilograms:");
		double pounds = kg * 2.2;
		UI.println(kg + " kgs is " + pounds + " pounds");
	}
	
	// calculate BMI
	public void bmiCalculator() {
		double weight = UI.askDouble("Weight in kg:");
		double height = UI.askDouble("Height in metres:");
		double bmi = weight / (height * height);
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.CEILING);
		if (bmi <= 18) {
			UI.println("Your BMI of " + df.format(bmi) + " is in the underweight range.");
		} else if (bmi < 24) {
			UI.println("Your BMI of " + df.format(bmi) + " is within the healthy range.");
		} else {
			UI.println("Your BMI of " + df.format(bmi) + " is in the overweight range.");
		}
	}
}
