package ispProg;

import java.util.HashMap;



public class Student {

	
	private String studentID;
	private String name;
	//private String idNbr;
	//private String studentID = ("S" + idNbr);7
	private HashMap<String, Result> results = new HashMap<>();

	public static int minID = 10000;
	public static int maxID = 99999;
	
	//Konstrukt
	public Student (String studentID, String name) {
		this.studentID = studentID;
		this.name = name;
	}
	
	
	//GET/SET
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public HashMap<String, Result> getResults() {
		return results;
	}
	public void setResults(HashMap<String, Result> results) {
		this.results = results;
	}
	
	public void addResult(Result result) {
		results.put(result.examCode(), result);
	}
	/*
	public String grades() {
	Iterator<HashMap.Entry<String, Result>> it = results.entrySet().iterator();
		        while (it.hasNext()) {
		            Map.Entry<String, Result> pair = it.next();
		            System.out.format(results.getDoneExam(), results.getLetterGrade(), 
		                    //pair.getValue());
		           String exam = results.getDoneExam();
		           String grade = results.getLetterGrade();
		           return String(exam + ": " + grade);
		        }
	}
	*/
	
	
	
}
