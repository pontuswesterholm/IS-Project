package ispProg;

public class Result {
	private int result;
	private String letterGrade;

	Student student;
	WrittenExam doneExam;

	public Result(Student student, WrittenExam doneExam, int result) {
		this.student = student;
		this.doneExam = doneExam;
		this.result = result;
	}
	
	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Result(int result) {
		this.result = result;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getLetterGrade() {
		return letterGrade;
	}

	public void setLetterGrade(String letterGrade) {
		this.letterGrade = letterGrade;
	}

	public void grade(int result) {
		if (result >= 85) {
			this.letterGrade = "A";
		} else if (result >= 75 && result < 85) {
			this.letterGrade = "B";
		} else if (result >= 65 && result < 75) {
			this.letterGrade = "C";
		} else if (result >= 55 && result < 65) {
			this.letterGrade = "D";
		} else if (result >= 50 && result < 55) {
			this.letterGrade = "E";
		} else {
			this.letterGrade = "Fail";
		}
		
	}

	public WrittenExam getDoneExam() {
		return doneExam;
	}

	public void setDoneExam(WrittenExam doneExam) {
		this.doneExam = doneExam;
	}
		
	public String examCode() {
		return doneExam.getExamId();
	}
	
}
