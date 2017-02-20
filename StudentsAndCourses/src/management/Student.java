package management;

public class Student implements Customer {

	//variables
    private String studentName;
    private int studentId;
    private double studentFees;
     
    //constructor
    public Student (String sn, int id, double fees) {
        studentName = sn;
        studentId = id;
        studentFees = fees;
    }
     
     
    //getters and setters
    public String getStudentName() {
        return studentName;
    }
    public int getId() {
        return studentId;
    }
    public double getFee() {
        return studentFees;
    }
 
     
    //return info about each student
    public String toString() {
        return (studentName + ", " + studentId + ", " + studentFees);
    }
     
	
}
