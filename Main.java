package ispProg;

public class Main {
	

	public static void main(String[] args) {
		Register reg = new Register();
		IsFrame isFrame = new IsFrame();
		Controller controller = new Controller(isFrame, reg);
		
		//reg.regStudent("1996", "Pontus");
		//System.out.println(reg.findStudent("1996").getName());
		
		//controller.addStudent("S10001", "Pontus");
		//controller.addStudent("S10002", "Sven");
		
		/*
		 * controller.addCourse("C11001", "SYSA21", 30); 
		 * controller.addExam("C11001", "01", "1/1", "Lund", "09:15"); 
		 * controller.gradeExam("C11001", "01", "S10001", 99); 
		 * controller.gradeExam("C11001", "01", "S10002", 56);
		 */
		
	}

}
