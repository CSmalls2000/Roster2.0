package studentroster;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class RosterIOTest {
	final static String filePath = "src/studentroster/";
	static String writeFileName = filePath+"writeRoster";
	
	public static void main(String[] args) {
//		testWriteRoster(writeFileName);
//		testReadRosterFile(writeFileName);
//		testCreateAndAddStudent();
//		testCreateAndAddStudents();
//		testCreateStudentsViaText();
//		testLoadRosterIntoTxtFile();
//		testRemoveStudent();
//		testRemoveStudentName();
		testRun();
	}
	
	private static void testWriteRoster(String fileName) {
		System.out.println("--->testWriteRosterFile()");
		
		//Building Roster
		Roster r = new Roster();
		ArrayList<Student> sList = listOfStudents20();
		for(Student s: sList) {
			r.addStudent(s);
		}
		
		//Writing Roster
		String textfileName=RosterIO.writeRosterFile(fileName, r);
		
		//Reads and prints out file
		Scanner input;
		try {
			input=new Scanner(new File(textfileName));
			while(input.hasNext()) {
				System.out.println(input.nextLine());
			}
			input.close();
		}
		catch(FileNotFoundException e) {
			System.out.println(e.getCause());
		}
		catch(RuntimeException rt) {
			System.out.println("Error reading written file. Incorrect format.");
		}
		System.out.println();
		
	}
	
	private static void testReadRosterFile(String fileName) {
		System.out.println("\n--->testReadRosterFile()");
		Roster r = RosterIO.readRosterFile(fileName);
		System.out.println(r.toString());
	}
	
	private static void testCreateAndAddStudent() {
		System.out.println("\n--->testCreateAndAddStudent()");
		//Roster
		Roster r = new Roster();
		//prompt user to create and add student
		RosterIO.createStudent(r);
		System.out.println("Student added:\n"+r.toString());
		
	}
	
	private static void testCreateAndAddStudents() {
		System.out.println("\n--->testCreateStudents()");
		
		Roster r = new Roster();
		RosterIO rio=new RosterIO();
		System.out.println("Student(s) currently existing in the roster before the user adds any Student(s):\n"+r.toString());
		System.out.println();
		/**
		 * Runs until the number the user entered has been achieved and 
		 *  the students the user wants to add to added to the roster
		 */
		rio.createStudents(r);
		
		System.out.println("Student(s) in the roster after the user input:\n\n"+r.toString());
	}
	
	private static void testCreateStudentsViaText() {
		System.out.print("\n--->testCreateStudentsViaText()");
		
		Roster r = new Roster();
		RosterIO rio =new RosterIO();
		System.out.println("Student(s) currently existing in the roster before the user adds any Student(s):\n"+r.toString());
		System.out.println();
		
		rio.createStudentsViaText(r);
		
		System.out.println("Student(s) in the roster after the user input from txt file:\n\n"+r.toString());
	}
	
	private static void testLoadRosterIntoTxtFile() {
		System.out.print("\n--->testLoadRosterIntoTxtFile()");
		
		Roster r = new Roster();
		RosterIO rio = new RosterIO();
		System.out.println("Student(s) currently existing in the roster before the user adds any Student(s):\n"+r.toString());
		System.out.println();
		
		rio.createStudentsViaText(r);
		
		System.out.println("Student(s) in the roster after the user input from txt file:\n\n"+r.toString());
		System.out.println(rio.loadRosterIntoTxtFile(r));
	}
	
	private static void testRemoveStudent() {
		
		Roster r=new Roster();
		RosterIO rio=new RosterIO();
		rio.createStudentsViaText(r);
		System.out.println("Student(s) in the roster after the user input from txt file:\n\n"+r.toString());
		Scanner user=new Scanner(System.in);
		System.out.println("How many students do you wish to remove? ");
		int num=user.nextInt();
		for(int i=0;i<num;i++) {
			RosterIO.removeStudentByID(r);
			System.out.println(r);
		}
	}
	
	private static void testRemoveStudentName() {
		Roster r=new Roster();
		ArrayList<Student> sList=listOfStudents20();
		for(Student s: sList) {
			r.addStudent(s);
		}
		int sizeB=r.getRosterSize();
		Scanner user=new Scanner(System.in);
		System.out.println("How many students do you wish to remove? ");
		int num=user.nextInt();
		for(int i=0;i<num;i++) {
			RosterIO.removeStudentByName(r);
			int sizeA=r.getRosterSize();
			if(sizeB!=sizeA) {
				System.out.println(r);
			}
		}
	}
	
	private static void testRun() {
		RosterIO rio=new RosterIO();
		rio.run();
	}
	
	//---------------------
	// Helper Method
	//----------------------
	
	private static ArrayList<Student> listOfStudents10(){
		ArrayList<Student> sList = new ArrayList<>();
		                    //ID     LName     FName     Class    Grade  CPro
		sList.add(new Student(765, "William", "James", "Freshman", 80.0, 21.3));
		sList.add(new Student(546, "Jones", "Raven", "Senior", 88.0, 91.9));
		sList.add(new Student(123, "Young", "Jaden", "Sophomore", 95.0, 50.4));
		sList.add(new Student(256, "Knight", "Lyric", "Junior", 74.3, 83.6));
		sList.add(new Student(347, "William", "Austin", "Freshman", 86.7, 20.0));
		sList.add(new Student(578, "West", "Mandy", "Senior", 99.0, 94.7));
		sList.add(new Student(431, "Zissett", "Xavier", "Sophomore", 51.1, 55.5));
		sList.add(new Student(149, "Rivers", "Ciera", "Freshman", 65.8, 21.2));
		sList.add(new Student(365, "Odom", "Henry", "Junior", 87.6, 81.2));
		sList.add(new Student(489, "Guinyard", "Kyle", "Senior", 100.0, 99.9));
		
		return sList;
	}
	
	private static ArrayList<Student> listOfStudents20(){
		ArrayList<Student> sList = listOfStudents10();
		sList.add(new Student(222, "Smith", "Jessica", "Senior", 84.7, 98.9));
		sList.add(new Student(456, "Beck", "Victor", "Freshman", 34.1, 24.2));
		sList.add(new Student(193, "New", "William", "Junior", 96.9, 76.9));
		sList.add(new Student(376, "Miller", "Harris", "Sophomore", 74.3, 83.6));
		sList.add(new Student(357, "Creech", "Lily", "Senior", 86.7, 20.0));
		sList.add(new Student(598, "Daniels", "Max", "Freshman", 99.5, 19.0));
		sList.add(new Student(211, "Parker", "Xandria", "Junior", 51.1, 85.5));
		sList.add(new Student(175, "Halloway", "Cyrus", "Senior", 65.8, 91.2));
		sList.add(new Student(698, "Carter-Blocker", "Harley", "Sophomore", 79.8, 48.7));
		sList.add(new Student(234, "Guinyard", "Kelly", "Freshman", 100.0, 25.8));
		return sList;
	}

}
