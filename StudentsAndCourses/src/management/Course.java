package management;

import java.util.ArrayList;

public class Course {
	
	
	//variables
	private String courseName;
	private int courseId;
	private double courseCost;
	private int coursePoints;
	private ArrayList<Student> students = new ArrayList<Student>();
	private ArrayList<Lecturer> lecturers = new ArrayList<Lecturer>();



	//constructors
	public Course (String c, int cId, double cC, int points) {
		courseName = c;
		courseId = cId;
		courseCost = cC;
		coursePoints = points;
	}


	//getters and setters
	public String getCourseName() {
		return courseName;
	}
	public int getCourseId() {
		return courseId;
	}
	public double getCourseCost() {
		return courseCost;
	}
	public int getCoursePoints() {
		return coursePoints;
	}
	public ArrayList<Student> getStudents() {
		return students;
	}
	public ArrayList<Lecturer> getLecturers() {
		return lecturers;
	}


	//print info about course
	public String courseString() {
		return (courseName + ", " + courseId + ", " + courseCost);
	}


	//add students to course
	public void addStudent(Student s) {
		students.add(s);
	}


	//add lecturers to course
	public void addLecturers(Lecturer l) {
		lecturers.add(l);
	}


	//return number of students in course
	public int numStudents() {
		return students.size();
	}


	//return number of lecturers for course
	public int numLecturers() {
		return lecturers.size();
	}


	//return course profit
	public double courseProfit() {
		double courseProfit = 0;
		double totalFees = 0;
		double totalCost = 0;

		for (int i = 0; i < students.size(); i++) {
			double singleFee = students.get(i).getFee();
			totalFees = totalFees + singleFee;
		}

		for (int j = 0; j < lecturers.size(); j++) {
			double singleCost = lecturers.get(j).getCost();
			totalCost = totalCost + singleCost;
		}

		courseProfit = (courseCost + totalCost) - totalFees;

		return courseProfit;
	}
	
	
}
