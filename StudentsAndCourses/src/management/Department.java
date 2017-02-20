package management;

import java.util.ArrayList;

public class Department {
	
	private String deptName;
    private ArrayList<Course> courses;
    private static ArrayList<Department> depts;
    
    ArrayList<Lecturer> lecturerList = new ArrayList<Lecturer>();
    ArrayList<Student> studentList = new ArrayList<Student>();

    
    //constructors
    public Department (String dName) {
        deptName = dName;
        depts = new ArrayList<Department>();
        courses = new ArrayList<Course>();
    }
     
    public Department () {
        deptName = null;
    }
 
 
    //getters and setters
    public String getDeptName() {
        return deptName;
    }
    public ArrayList<Course> getCourses() {
        return courses;
    }
    public static ArrayList<Department> getDepts() {
        return depts;
    }
 
     
    //return info about each dept
    public String dString() {
        return (deptName);
    }
     
 
    //add courses to dept
    public void addCourse(Course c) {
        courses.add(c);
    }
     
     
    //return number of courses in each department
    public int numCourses() {
        return courses.size();
    }
     
     
    //return info about courses, students and lecturers for each department
    public void reports() {
 
        System.out.println();
        System.out.println("Department " + deptName + " report:");
         
        for (int i = 0; i < courses.size(); i++) {
            System.out.println("Course " + courses.get(i).getCourseName() + " Number of Lecturers: " + courses.get(i).numLecturers() + 
                    " Number of students: " + courses.get(i).numStudents());
             
            System.out.println("Lecturers:");
            lecturerList = courses.get(i).getLecturers();
            for (int j = 0; j < lecturerList.size(); j++) {
                System.out.println(lecturerList.get(j).getLecturerName());
            }
             
            System.out.println("Students:");
            studentList = courses.get(i).getStudents();
            for (int j = 0; j < studentList.size(); j++) {
                System.out.println(studentList.get(j).getStudentName());
            }
            
            System.out.println();
        }
    }

}
