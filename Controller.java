package ispProg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

public class Controller {

	// relation
	private IsFrame isFrame;
	private Register reg;

	private ArrayList<String> students = new ArrayList<String>();
	private ArrayList<String> courses = new ArrayList<String>();
	private ArrayList<String> exams = new ArrayList<String>();

	// Constructure
	public Controller(IsFrame isFrame, Register reg) {
		this.isFrame = isFrame;
		this.reg = reg;
		declareListeners();
	}

	// Listeners
	private void declareListeners() {
		isFrame.getBtn_Create().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("CREATE");
				String id = isFrame.getTextField_ID().getText();
				String name = isFrame.getTextField_Name().getText();

				if (isFrame.getComboBox_Classes().getSelectedItem() == "Students") {
					if (reg.checkID(id) != true) {
						reg.addStudent(id, name);
						students.add(reg.findStudent(id).getStudentID());
						isFrame.getComboBox_Objects().addItem(reg.findStudent(id).getStudentID());
					}
				} else if (isFrame.getComboBox_Classes().getSelectedItem() == "Courses") {
					if (reg.checkCourseID(id) != true) {
						int credits = isFrame.getTextField_CreditsInt();
						reg.addCourse(id, name, credits);
						courses.add(reg.findCourse(id).getCourseCode());
						isFrame.getComboBox_Objects().addItem(reg.findCourse(id).getCourseCode());
					}
				} else if (isFrame.getComboBox_Classes().getSelectedItem() == "Exams") {
					String courseCode = (String) isFrame.getComboBox_Objects().getSelectedItem();
					if (reg.checkExamID(courseCode, id) != true) {
						String date = isFrame.getTextField_Date().getText();
						String location = isFrame.getTextField_Location().getText();
						String time = isFrame.getTextField_Time().getText();
						reg.addExam(courseCode, id, date, location, time);
						exams.add(reg.findExam(courseCode, id).getExamId());
						isFrame.getComboBox_Exams().addItem(reg.findExam(courseCode, id).getExamId());
					}
				}
			}
		});

		isFrame.getComboBox_Objects().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = (String) isFrame.getComboBox_Objects().getSelectedItem();
				if (isFrame.getComboBox_Classes().getSelectedItem() == "Students") {
					if (reg.checkID(id) == true) {
						isFrame.setTextField_ID(id);
						String name = reg.findStudent(id).getName();
						isFrame.setTextField_Name(name);
						System.out.println(reg.findStudent(id).getName());
					}
				} else if (isFrame.getComboBox_Classes().getSelectedItem() == "Courses") {
					if (reg.checkCourseID(id) == true) {
						isFrame.setTextField_ID(id);
						String name = reg.findCourse(id).getName();
						isFrame.setTextField_Name(name);
						String credits = String.valueOf(reg.findCourse(id).getCredits());
						isFrame.setTextField_Credits(credits);
					}
				} else if (isFrame.getComboBox_Classes().getSelectedItem() == "Exams") {
					String examID = (String) isFrame.getComboBox_Exams().getSelectedItem();
					if (reg.checkExamID(id, examID) == true) {
						isFrame.setTextField_ID(examID);
						String date = reg.findExam(id, examID).getDate();
						isFrame.setTextField_Date(date);
						String location = reg.findExam(id, examID).getLocation();
						isFrame.setTextField_Location(location);
						String time = reg.findExam(id, examID).getTime();
						isFrame.setTextField_Time(time);

						}
					
					if (reg.findCourse(id) != null ) {
						isFrame.getComboBox_Exams().removeAllItems();
						for (Iterator<String> i = exams.iterator(); i.hasNext();)
							isFrame.getComboBox_Exams().addItem(i.next());

				
					}
						
						
				}
			}
		});

		isFrame.getBtn_Update().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.out.println("UPDATE");
				Object object = isFrame.getComboBox_Objects().getSelectedItem();
				String id = (String) isFrame.getComboBox_Objects().getSelectedItem();

				if (isFrame.getComboBox_Classes().getSelectedItem() == "Students") {
					if (reg.checkID(id) == true) {
						String newID = isFrame.getTextField_ID().getText();
						String name = isFrame.getTextField_Name().getText();
						reg.uppdateStudent(id, newID, name);
						isFrame.getComboBox_Objects().addItem(reg.findStudent(newID).getStudentID());

						isFrame.getComboBox_Objects().removeItem(object);
					}
				} else if (isFrame.getComboBox_Classes().getSelectedItem() == "Courses") {
					if (reg.checkCourseID(id) == true) {
						String newID = isFrame.getTextField_ID().getText();
						String name = isFrame.getTextField_Name().getText();
						int credit = isFrame.getTextField_CreditsInt();
						reg.uppdateCourse(id, newID, name, credit);
						isFrame.getComboBox_Objects().addItem(reg.findCourse(newID).getCourseCode());

						isFrame.getComboBox_Objects().removeItem(object);
					}
				} else if (isFrame.getComboBox_Classes().getSelectedItem() == "Exams") {
					String examID = (String) isFrame.getComboBox_Exams().getSelectedItem();
					if (reg.checkExamID(id, examID) == true) {
						String newID = isFrame.getTextField_ID().getText();
						String date = isFrame.getTextField_Date().getText();
						String location = isFrame.getTextField_Location().getText();
						String time = isFrame.getTextField_Time().getText();

					}
				}
			}
		});

		isFrame.getBtn_Delete().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("DELETE");
				String id = (String) isFrame.getComboBox_Objects().getSelectedItem();
				Object object = isFrame.getComboBox_Objects().getSelectedItem();
				isFrame.getComboBox_Objects().removeItem(object);
				isFrame.setTextField_ID("");
				isFrame.setTextField_Name("");
				isFrame.setTextField_Credits("");

				if (isFrame.getComboBox_Classes().getSelectedItem() == "Students") {
					if (reg.checkID(id) == true) {
						reg.removeStudent(id);
					}
				} else if (isFrame.getComboBox_Classes().getSelectedItem() == "Courses") {
					if (reg.checkCourseID(id) == true) {
						isFrame.setTextField_Credits("");
						reg.removeCourse(id);
					}
				}
			}
		});

		isFrame.getComboBox_Classes().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isFrame.getComboBox_Classes().getSelectedItem() == "Courses") {
					isFrame.getLbl_ID().setText("Course code:");
					isFrame.getTextField_Credits().setVisible(true);
					isFrame.getLbl_Credit().setVisible(true);
					isFrame.getTextField_Name().setVisible(true);
					isFrame.getLbl_Name().setVisible(true);

					isFrame.getLbl_Date().setVisible(false);
					isFrame.getTextField_Date().setVisible(false);
					isFrame.getTextField_Location().setVisible(false);
					isFrame.getLbl_Location().setVisible(false);
					isFrame.getTextField_Time().setVisible(false);
					isFrame.getLbl_Time().setVisible(false);
					isFrame.getComboBox_Exams().setVisible(false);

					isFrame.setTextField_ID("");
					isFrame.setTextField_Name("");
					isFrame.setTextField_Credits("");

					isFrame.getComboBox_Objects().removeAllItems();
					for (Iterator<String> i = courses.iterator(); i.hasNext();)
						isFrame.getComboBox_Objects().addItem(i.next());

					// DUMMY
					isFrame.setTextField_ID("C99001");
					isFrame.setTextField_Name("SYSA");
					isFrame.setTextField_Credits("30");

				}
				if (isFrame.getComboBox_Classes().getSelectedItem() == "Students") {
					isFrame.getLbl_ID().setText("Student ID:");
					isFrame.getTextField_Credits().setVisible(false);
					isFrame.getLbl_Credit().setVisible(false);
					isFrame.getTextField_Name().setVisible(true);
					isFrame.getLbl_Name().setVisible(true);

					isFrame.getLbl_Date().setVisible(false);
					isFrame.getTextField_Date().setVisible(false);
					isFrame.getTextField_Location().setVisible(false);
					isFrame.getLbl_Location().setVisible(false);
					isFrame.getTextField_Time().setVisible(false);
					isFrame.getLbl_Time().setVisible(false);
					isFrame.getComboBox_Exams().setVisible(false);

					isFrame.setTextField_ID("");
					isFrame.setTextField_Name("");

					isFrame.getComboBox_Objects().removeAllItems();
					for (Iterator<String> i = students.iterator(); i.hasNext();)
						isFrame.getComboBox_Objects().addItem(i.next());

					// DUMMY
					isFrame.setTextField_ID("S10001");
					isFrame.setTextField_Name("Pontus");

				}
				if (isFrame.getComboBox_Classes().getSelectedItem() == "Exams") {
					isFrame.getLbl_ID().setText("Exam ID:");
					isFrame.getTextField_Credits().setVisible(false);
					isFrame.getLbl_Credit().setVisible(false);
					isFrame.getTextField_Name().setVisible(false);
					isFrame.getLbl_Name().setVisible(false);

					isFrame.getLbl_Date().setVisible(true);
					isFrame.getTextField_Date().setVisible(true);
					isFrame.getTextField_Location().setVisible(true);
					isFrame.getLbl_Location().setVisible(true);
					isFrame.getTextField_Time().setVisible(true);
					isFrame.getLbl_Time().setVisible(true);
					isFrame.getComboBox_Exams().setVisible(true);

					isFrame.setTextField_ID("");
					isFrame.setTextField_Date("");
					isFrame.setTextField_Location("");
					isFrame.setTextField_Time("");

					isFrame.getComboBox_Objects().removeAllItems();
					for (Iterator<String> i = courses.iterator(); i.hasNext();)
						isFrame.getComboBox_Objects().addItem(i.next());

					isFrame.getComboBox_Exams().removeAllItems();
					for (Iterator<String> i = exams.iterator(); i.hasNext();)
						isFrame.getComboBox_Exams().addItem(i.next());

					// DUMMY
					isFrame.setTextField_ID("E001");
					isFrame.setTextField_Date("11/1");
					isFrame.setTextField_Location("Lund");
					isFrame.setTextField_Time("08:00");

				}
			}

		});

	}

	// Metoder

	/*
	 * public void addCourse(String courseCode, String name, int credits) { Course
	 * tmp = new Course(courseCode, name, credits); tmp.setCourseCode(courseCode);
	 * tmp.setName(name); tmp.setCredits(credits); reg.addCourse(tmp); }
	 * 
	 * 
	 * public void addExam(String courseCode, String examID, String date, String
	 * location, String time) { WrittenExam tmp = new WrittenExam(examID, date,
	 * location, time); tmp.setExamId(examID); tmp.setDate(date);
	 * tmp.setLocation(location); tmp.setTime(time);
	 * reg.findCourse(courseCode).addExam(tmp); }
	 */
	public void gradeExam(String courseCode, String examID, String studentID, int result) {
		Result tmp = new Result(result);
		Student tmpStud = reg.findStudent(studentID);
		Course tmpCour = reg.findCourse(courseCode);
		WrittenExam exam = tmpCour.findExam(examID);
		tmp.setDoneExam(exam);
		tmp.grade(result);
		tmpStud.addResult(tmp);
	}

	// reg.findCourse(courseCode);

	public String findGrade(String studentID, String examCode) {
		Student tmp = reg.findStudent(studentID);
		String grade = tmp.getResults().get(examCode).getLetterGrade();
		return grade;
	}

	/*
	 * public void setStudentID (String studentID) { int length =
	 * String.valueOf(studentIdNbr).length(); if ((length == 5) && (studentIdNbr <
	 * Student.maxID) && (studentIdNbr > Student.minID)) { Student stud =
	 * reg.findStudent(studentID); stud.setStudentID("S" + studentIdNbr); } } public
	 * void setCourseCode (int courseCodeNbr) { int length =
	 * String.valueOf(courseCodeNbr).length(); if ((length == 5) && (courseCodeNbr <
	 * Course.maxCode) && (courseCodeNbr > Course.minCode)) {
	 * 
	 * kurs.setCourseCode("C" + courseCodeNbr);
	 * 
	 * } }
	 */

	public void uppdateStudent(String studentID, String newID, String name) {
		reg.uppdateStudent(studentID, newID, name);
	}

	public void uppdateCourse(String courseCode, String newCourseCode, String name, int credits) {
		reg.uppdateCourse(courseCode, newCourseCode, name, credits);
	}
}
