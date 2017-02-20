package management;

import java.util.ArrayList;

public class Main {
	
	private static ArrayList<Department> depts = new ArrayList<Department>();
    
    public static void main(String[] args) {
         
        //Department dep = new Department();
        depts = Department.getDepts();
         
        //create students, lecturers, courses and departments
        Student a = new Student("Abby", 12432, 1200);
        Student b = new Student("Benjamin", 16543, 1200);
        Student c = new Student("Claire", 89453, 1000);
        Student d = new Student("David", 23461, 1200);
        Student e = new Student("Elizabeth", 65438, 1100);
        Student f = new Student("Francis", 99834, 1000);
        Student g = new Student("Georgina", 23464, 1150);
        Student h = new Student("Henry", 15678, 1200);
        Student i = new Student("Irene", 98425, 1000);
        Student j = new Student("James", 54450, 1400);
        Student k = new Student("Kate", 65414, 1300);
        Student l = new Student("Lorna", 78922, 1000);
         
        Course m = new Course("SWEN131", 131, 2000, 15);
        Course n = new Course("SWEN501", 501, 2000, 15);
        Course o = new Course("SWEN502", 502, 2000, 30);
        Course p = new Course("SWEN503", 503, 2000, 30);
        Course q = new Course("SWEN504", 504, 2000, 30);
         
        Lecturer y = new Lecturer("Yolanda", 44795,1200);
        Lecturer x = new Lecturer("Xray", 44256,1150);
        Lecturer w = new Lecturer("William", 44963, 1175);
        Lecturer v = new Lecturer("Violet", 44124, 1200);
        Lecturer u = new Lecturer("Uruguay", 44200, 1100);
        Lecturer t = new Lecturer("Theresa", 44003, 1150);
        Lecturer z = new Lecturer("Zachary", 44852, 1000);
         
        Department r = new Department("Engineering");
        Department s = new Department("Software Dev");
         
        //add students to courses
        m.addStudent(a);
        m.addStudent(b);
        m.addStudent(c);
        m.addStudent(d);
        n.addStudent(a);
        n.addStudent(f);
        n.addStudent(g);
        n.addStudent(h);
        o.addStudent(f);
        o.addStudent(b);
        o.addStudent(c);
        o.addStudent(e);
        p.addStudent(i);
        p.addStudent(h);
        p.addStudent(l);
        p.addStudent(j);
        q.addStudent(k);
        q.addStudent(i);
        q.addStudent(j);
        q.addStudent(k);
        q.addStudent(l);
        q.addStudent(f);
         
        //add lecturers to course
        m.addLecturers(z);
        m.addLecturers(y);
        n.addLecturers(x);
        n.addLecturers(w);
        o.addLecturers(v);
        p.addLecturers(t);
        q.addLecturers(u);
         
        //add courses to departments
        r.addCourse(m);
        r.addCourse(n);
        r.addCourse(o);
        s.addCourse(p);
        s.addCourse(q);
         
 
        System.out.println();
        System.out.println("Courses:");
        System.out.println(m.courseString() + " Course profit: $" + m.courseProfit() + " Number of students: " + m.numStudents());
        System.out.println(n.courseString() + " Course profit: $" + n.courseProfit() + " Number of students: " + n.numStudents());
        System.out.println(o.courseString() + " Course profit: $" + o.courseProfit() + " Number of students: " + o.numStudents());
        System.out.println(p.courseString() + " Course profit: $" + p.courseProfit() + " Number of students: " + p.numStudents());
        System.out.println(q.courseString() + " Course profit: $" + q.courseProfit() + " Number of students: " + q.numStudents());
         
        System.out.println();
        System.out.println("Students:");
        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(c.toString());
        System.out.println(d.toString());
        System.out.println(e.toString());
        System.out.println(f.toString());
        System.out.println(g.toString());
        System.out.println(h.toString());
        System.out.println(i.toString());
        System.out.println(j.toString());
        System.out.println(k.toString());
        System.out.println(l.toString());
         
        System.out.println();
        System.out.println("Lecturers:");
        System.out.println(z.lString());
        System.out.println(y.lString());
        System.out.println(x.lString());
        System.out.println(v.lString());
        System.out.println(u.lString());
        System.out.println(t.lString());
        System.out.println(w.lString());
         
        System.out.println();
        System.out.println("Departments:");
        System.out.println(r.dString() + " Number of courses: " + r.numCourses());
        System.out.println(s.dString() + " Number of courses: "  + s.numCourses());
         
        r.reports();
        s.reports();
        
    }   

}
