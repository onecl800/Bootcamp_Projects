package management;

public class Lecturer implements Payee {
	
	//variables/fields
    private String lecturerName;
    private int lecturerId;
    private double lecturerCost;
 
     
    //constructors
    public Lecturer (String l, int lId, double lC) {
        lecturerName = l;
        lecturerId = lId;
        lecturerCost = lC;
    }
 
     
    //getter and setters
    public String getLecturerName() {
        return lecturerName;
    }
    public int getId() {
        return lecturerId;
    }
    public double getCost() {
        return lecturerCost;
    }
 
     
    //print info about each lecturer
    public String lString() {
        return (lecturerName + ", " + lecturerId + ", " + lecturerCost);
    }
 

}
