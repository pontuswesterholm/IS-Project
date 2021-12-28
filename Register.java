package ispProg;

import java.util.HashMap;
import java.util.Iterator;

public class Register {

	// Controller controller;

	// Students
	private HashMap<String, Student> students = new HashMap<String, Student>();
	
	public HashMap<String, Student> getStudents() {
		return students;
	}

	public void setStudents(HashMap<String, Student> students) {
		this.students = students;
	}

	public void addStudent(String studentID, String name) {
		Student aStudent = new Student(studentID, name);
		students.put(aStudent.getStudentID(), aStudent);
	}

	public Student findStudent(String studentID) {
		for (Student aStudent : students.values()) {
			if (studentID == aStudent.getStudentID())
				return aStudent;
		}
		return null;
	}

	public boolean checkID(String studentID) {
		boolean check = true;
		if (students.containsKey(studentID) == true) {
			check = true;
		} else {
			check = false;
		}

		return check;
	}

	public void uppdateStudent(String studentID, String newID, String name) {
		for (Student tmp : students.values()) {
			if (studentID == tmp.getStudentID())
				tmp.setStudentID(newID);
			tmp.setName(name);
		}
	}

	public void removeStudent(String studentID) {
		students.remove(studentID);
	}

	// Courses
	private HashMap<String, Course> courses = new HashMap<String, Course>();

	public HashMap<String, Course> getCourses() {
		return courses;
	}

	public void setCourses(HashMap<String, Course> courses) {
		this.courses = courses;
	}

	public void addCourse(String courseCode, String name, int credits) {
		Course aCourse = new Course(courseCode, name, credits);
		courses.put(aCourse.getCourseCode(), aCourse);
	}

	public Course findCourse(String courseCode) {
		for (Course aCourse : courses.values()) {
			if (courseCode == aCourse.getCourseCode())
				return aCourse;
		}
		return null;
	}

	public boolean checkCourseID(String courseID) {
		boolean check = false;
		if (courses.containsKey(courseID) == true) {
			check = true;
		} else {
			check = false;
		}

		return check;
	}

	public void uppdateCourse(String courseCode, String newCourseCode, String name, int credits) {
		for (Course aCourse : courses.values()) {
			if (courseCode == aCourse.getCourseCode())
				aCourse.setCourseCode(newCourseCode);
			aCourse.setName(name);
			aCourse.setCredits(credits);
		}
	}

	public void removeCourse(String courseCode) {
		courses.remove(courseCode);
	}

	//Exams
	public void addExam(String courseCode, String examID, String date, String location, String time) {
		WrittenExam exam = new WrittenExam(examID, date, location, time);
		for (Course aCourse : courses.values()) {
			if (courseCode == aCourse.getCourseCode())
				aCourse.addExam(exam);
		}

	}

	public boolean checkExamID(String courseCode, String examID) {
		boolean check = false;
		for (Course aCourse : courses.values()) {
				if (aCourse.findExam(examID) != null) {
					check = true;
			} else {
				check = false;
			}

		}

		return check;
	}
	
	/*
	public HashMap<String, WrittenExam> getExams(String courseCode) {
		for (Course aCourse : courses.values()) {
			if (courseCode == aCourse.getCourseCode()) {
				return aCourse.getExams();
			}
		}
		return null;
	}
	*/
	
	public WrittenExam findExam(String courseCode, String examID) {
		for (Course aCourse : courses.values()) {
			if (courseCode == aCourse.getCourseCode()) {
				for (WrittenExam exam : aCourse.getExams().values())
					if (examID == exam.getExamId())
						return exam;
			}
		}
		return null;
	}

	public void setGrade() {

	}

}
