package studentroster;

public class DLinkedListTest {

	public static void main(String[]args) {
		
		BuildList();
		gradeIncreasing();
		gradeDecreasing();
		progressIncreasing();
		progressDecreasing();
		sortByIDIncreasing();
		sortByIDDecreasing();
		sortByClassificationIncreasing();
		sortByClassificationDecreasing();
		sortByNameIncreasing();
		sortByNameDecreasing();
		testStudentsBetweenGrades();
		testStudentsBetweenAcadPro();
		
	}
	
	public static void BuildList() {
		System.out.println("-----Roster of Students-----");
		
		DLinkedList2 dl = new DLinkedList2();
		dl.addNode(new Student(001, "Johnson", "Tyler", "Sophomore", 95.7, 45.0));
		dl.addNode(new Student(002, "Jackson", "Sarah", "Junior", 100.0, 50.4));
		dl.addNode(new Student(222, "Smith", "Jessica", "Senior", 84.7, 98.9));
		dl.addNode(new Student(456, "Beck", "Victor", "Freshman", 34.1, 24.2));
		dl.addNode(new Student(193, "New", "Alex", "Junior", 96.9, 76.9));
		dl.addNode(new Student(376, "Miller", "Harris", "Sophomore", 74.3, 83.6));
		dl.addNode(new Student(357, "Creech", "Lily", "Senior", 86.7, 20.0));
		dl.addNode(new Student(598, "Daniels", "Max", "Freshman", 99.5, 19.0));
		dl.addNode(new Student(211, "Parker", "Xandria", "Junior", 51.1, 85.5));
		dl.addNode(new Student(175, "Halloway", "Cyrus", "Senior", 65.8, 91.2));
		dl.addNode(new Student(698, "Carter-Blocker", "Harley", "Sophomore", 79.8, 48.7));
		dl.addNode(new Student(234, "Guinyard", "Kelly", "Freshman", 100.0, 25.8));
		
		dl.display();
	}
	
	public static void gradeDecreasing() {
		System.out.println("-----Ranked Grades (Decreasing) -----");
		
		DLinkedList2 dl = new DLinkedList2();
		dl.addNode(new Student(001, "Johnson", "Tyler", "Sophomore", 95.7, 45.0));
		dl.addNode(new Student(002, "Jackson", "Sarah", "Junior", 100.0, 50.4));
		
		dl.sortGradeDescending();
		
		dl.display();
	}
	
	public static void gradeIncreasing() {
		System.out.println("-----Ranked Grades (Increasing) -----");
		
		DLinkedList2 dl = new DLinkedList2();
		dl.addNode(new Student(001, "Johnson", "Tyler", "Sophomore", 95.7, 45.0));
		dl.addNode(new Student(002, "Jackson", "Sarah", "Junior", 100.0, 50.4));
		
		dl.sortGradeAscending();
		
		dl.display();
	}
	
	
	public static void progressDecreasing() {
		System.out.println("-----Ranked Progress (Decreasing) -----");
		
		DLinkedList2 dl = new DLinkedList2();
		dl.addNode(new Student(001, "Johnson", "Tyler", "Sophomore", 95.7, 45.0));
		dl.addNode(new Student(002, "Jackson", "Sarah", "Junior", 100.0, 50.4));
		
		dl.sortProgressDescending();
		
		dl.display();
	}
	
	public static void progressIncreasing() {
		System.out.println("-----Ranked Progress (Increasing) -----");
		
		DLinkedList2 dl = new DLinkedList2();
		dl.addNode(new Student(001, "Johnson", "Tyler", "Sophomore", 95.7, 45.0));
		dl.addNode(new Student(002, "Jackson", "Sarah", "Junior", 100.0, 50.4));
		
		dl.sortProgressAscending();
		
		dl.display();
	}
	
	
	public static void sortByIDIncreasing() {
		System.out.println("-----Ranked By ID (Increasing) -----");
		
		DLinkedList2 dl = new DLinkedList2();
		dl.addNode(new Student(001, "Johnson", "Tyler", "Sophomore", 95.7, 45.0));
		dl.addNode(new Student(002, "Jackson", "Sarah", "Junior", 100.0, 50.4));
		
		dl.sortIDAscending();
		
		dl.display();
	}
	
	public static void sortByIDDecreasing() {
		System.out.println("-----Ranked By ID (Decreasing) -----");
		
		DLinkedList2 dl = new DLinkedList2();
		dl.addNode(new Student(001, "Johnson", "Tyler", "Sophomore", 95.7, 45.0));
		dl.addNode(new Student(002, "Jackson", "Sarah", "Junior", 100.0, 50.4));
		
		dl.sortIDDescending();
		
		dl.display();
	}
	
	
	public static void sortByClassificationIncreasing() {
		System.out.println("-----Ranked By Class (Increasing) -----");
		
		DLinkedList2 dl = new DLinkedList2();
		dl.addNode(new Student(001, "Johnson", "Tyler", "Sophomore", 95.7, 45.0));
		dl.addNode(new Student(002, "Jackson", "Sarah", "Junior", 100.0, 50.4));
		dl.addNode(new Student(222, "Smith", "Jessica", "Senior", 84.7, 98.9));
		dl.addNode(new Student(456, "Beck", "Victor", "Freshman", 34.1, 24.2));
		dl.addNode(new Student(193, "New", "Alex", "Junior", 96.9, 76.9));
		dl.addNode(new Student(376, "Miller", "Harris", "Sophomore", 74.3, 83.6));
		dl.addNode(new Student(357, "Creech", "Lily", "Senior", 86.7, 20.0));
		dl.addNode(new Student(598, "Daniels", "Max", "Freshman", 99.5, 19.0));
		dl.addNode(new Student(211, "Parker", "Xandria", "Junior", 51.1, 85.5));
		dl.addNode(new Student(175, "Halloway", "Cyrus", "Senior", 65.8, 91.2));
		dl.addNode(new Student(698, "Carter-Blocker", "Harley", "Sophomore", 79.8, 48.7));
		dl.addNode(new Student(234, "Guinyard", "Kelly", "Freshman", 100.0, 25.8));
		
		dl.sortClassificationAscending();
		
		dl.printOut();
	}
	
	public static void sortByClassificationDecreasing() {
		System.out.println("\n-----Ranked By Class (Decreasing) -----");
		
		DLinkedList2 dl = new DLinkedList2();
		dl.addNode(new Student(001, "Johnson", "Tyler", "Sophomore", 95.7, 45.0));
		dl.addNode(new Student(002, "Jackson", "Sarah", "Junior", 100.0, 50.4));
		dl.addNode(new Student(222, "Smith", "Jessica", "Senior", 84.7, 98.9));
		dl.addNode(new Student(456, "Beck", "Victor", "Freshman", 34.1, 24.2));
		dl.addNode(new Student(193, "New", "Alex", "Junior", 96.9, 76.9));
		dl.addNode(new Student(376, "Miller", "Harris", "Sophomore", 74.3, 83.6));
		dl.addNode(new Student(357, "Creech", "Lily", "Senior", 86.7, 20.0));
		dl.addNode(new Student(598, "Daniels", "Max", "Freshman", 99.5, 19.0));
		dl.addNode(new Student(211, "Parker", "Xandria", "Junior", 51.1, 85.5));
		dl.addNode(new Student(175, "Halloway", "Cyrus", "Senior", 65.8, 91.2));
		dl.addNode(new Student(698, "Carter-Blocker", "Harley", "Sophomore", 79.8, 48.7));
		dl.addNode(new Student(234, "Guinyard", "Kelly", "Freshman", 100.0, 25.8));
		
		dl.sortClassificationDescending();
		
		dl.printOut();
	}
	
	
	public static void sortByNameDecreasing() {
		System.out.println("-----Ranked By Name (Decreasing) -----");
		
		DLinkedList2 dl = new DLinkedList2();
		dl.addNode(new Student(001, "Johnson", "Tyler", "Sophomore", 95.7, 45.0));
		dl.addNode(new Student(002, "Jackson", "Sarah", "Junior", 100.0, 50.4));
		
		dl.sortIDDescending();
		
		dl.display();
	}
	
	public static void sortByNameIncreasing() {
		System.out.println("\n-----Ranked By Name (Increasing) -----");
		
		DLinkedList2 dl = new DLinkedList2();
		dl.addNode(new Student(001, "Johnson", "Tyler", "Sophomore", 95.7, 45.0));
		dl.addNode(new Student(002, "Jackson", "Sarah", "Junior", 100.0, 50.4));
		
		dl.sortIDAscending();
		
		dl.display();
	}
	
	public static void testStudentsBetweenGrades() {
		System.out.println("------Students between Grades-------");
		DLinkedList2 dl = new DLinkedList2();
		dl.addNode(new Student(001, "Johnson", "Tyler", "Sophomore", 95.7, 45.0));
		dl.addNode(new Student(002, "Jackson", "Sarah", "Junior", 100.0, 50.4));
		dl.addNode(new Student(222, "Smith", "Jessica", "Senior", 84.7, 98.9));
		dl.addNode(new Student(456, "Beck", "Victor", "Freshman", 34.1, 24.2));
		dl.addNode(new Student(193, "New", "Alex", "Junior", 96.9, 76.9));
		dl.addNode(new Student(376, "Miller", "Harris", "Sophomore", 74.3, 83.6));
		dl.addNode(new Student(357, "Creech", "Lily", "Senior", 86.7, 20.0));
		dl.addNode(new Student(598, "Daniels", "Max", "Freshman", 99.5, 19.0));
		dl.addNode(new Student(211, "Parker", "Xandria", "Junior", 51.1, 85.5));
		dl.addNode(new Student(175, "Halloway", "Cyrus", "Senior", 65.8, 91.2));
		dl.addNode(new Student(698, "Carter-Blocker", "Harley", "Sophomore", 79.8, 48.7));
		dl.addNode(new Student(234, "Guinyard", "Kelly", "Freshman", 100.0, 25.8));
		
		
		double grade1=97.1;
		double grade2=78.6;
		DLinkedList2 betGrades=dl.studentsBetweenGrades(grade1, grade2);
		
		System.out.printf("Students who have or are in between %.1f-%.1f gradewise are:\n", Math.min(grade1, grade2), Math.max(grade1, grade2));
		betGrades.printOut();
	}
	
	public static void testStudentsBetweenAcadPro() {
		System.out.println("\n------Students Between Academic Progress-------");
		DLinkedList2 dl = new DLinkedList2();
		dl.addNode(new Student(001, "Johnson", "Tyler", "Sophomore", 95.7, 45.0));
		dl.addNode(new Student(002, "Jackson", "Sarah", "Junior", 100.0, 75.4));
		dl.addNode(new Student(222, "Smith", "Jessica", "Senior", 84.7, 98.9));
		dl.addNode(new Student(456, "Beck", "Victor", "Freshman", 34.1, 24.2));
		dl.addNode(new Student(193, "New", "Alex", "Junior", 96.9, 76.9));
		dl.addNode(new Student(376, "Miller", "Harris", "Sophomore", 74.3, 56.6));
		dl.addNode(new Student(357, "Creech", "Lily", "Senior", 86.7, 98.4));
		dl.addNode(new Student(598, "Daniels", "Max", "Freshman", 99.5, 19.0));
		dl.addNode(new Student(211, "Parker", "Xandria", "Junior", 51.1, 85.5));
		dl.addNode(new Student(175, "Halloway", "Cyrus", "Senior", 65.8, 91.2));
		dl.addNode(new Student(698, "Carter-Blocker", "Harley", "Sophomore", 79.8, 48.7));
		dl.addNode(new Student(234, "Guinyard", "Kelly", "Freshman", 100.0, 25.8));
		
		double Acad1=57.5;
		double Acad2=19.0;
		DLinkedList2 betAcad=dl.studentsBetweenAcademicPro(Acad1, Acad2);
		
		System.out.printf("Students who have or are in between %.1f-%.1f in Academic Progress are:\n", Math.min(Acad1, Acad2), Math.max(Acad1, Acad2));
		betAcad.printOut();
	}
}
