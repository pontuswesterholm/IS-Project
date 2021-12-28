package ispProg;

import java.util.HashMap;

public class Course {
	private String courseCode;
	private String name;
	private int credits;
	public static int minCode = 10000;
	public static int maxCode = 99999;
	
	private HashMap<String, WrittenExam> exams = new HashMap<>();

	
	public Course(String courseCode, String name, int credits) {
		this.courseCode = courseCode;
		this.name = name;
		this.credits = credits;
	}
	
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	
	
	
	//exams
	public HashMap<String, WrittenExam> getExams() {
		return exams;
	}

	public void setExams(HashMap<String, WrittenExam> exams) {
		this.exams = exams;
	}
	
	public void addExam(WrittenExam exam) {
		exams.put(exam.getExamId(), exam);
	}
	
	public WrittenExam findExam(String examID) {
		for (WrittenExam tmp : exams.values()) {
			if (examID == tmp.getExamId())
				return tmp;
		}
		return null;
	}
	
}
