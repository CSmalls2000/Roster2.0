package studentroster;

public class DLinkedListTest {

	public static void main(String[]args) {
		
		BuildList();
		highestActivityLevel();
		highestGrade();
		highestProgress();
		sortByID();
		sortByClassification();
		sortByName();
	}
	
	public static void BuildList() {
		System.out.println("-----Roster of Students-----");
		
		DLinkedList2 dl = new DLinkedList2();
		dl.addNode(new Student(001, "Tyler", "Johnson", "sophmore", 89.9, 95.7, 45.0));
		dl.addNode(new Student(002, "Sarah", "Jackson", "junior", 90.1, 100.0, 50.4));
		
		dl.display();
	}
	
	public static void highestActivityLevel() {
		System.out.println("-----Ranked Activty Level-----");
		
		DLinkedList2 dl = new DLinkedList2();
		dl.addNode(new Student(001, "Tyler", "Johnson", "sophmore", 89.9, 95.7, 45.0));
		dl.addNode(new Student(002, "Sarah", "Jackson", "junior", 90.1, 100.0, 50.4));
		
		dl.sortActivity();
		
		dl.display();
	}
	
	
	public static void highestGrade() {
		System.out.println("-----Ranked Grades-----");
		
		DLinkedList2 dl = new DLinkedList2();
		dl.addNode(new Student(001, "Tyler", "Johnson", "sophmore", 89.9, 95.7, 45.0));
		dl.addNode(new Student(002, "Sarah", "Jackson", "junior", 90.1, 100.0, 50.4));
		
		dl.sortGrade();
		
		dl.display();
	}
	
	
	public static void highestProgress() {
		System.out.println("-----Ranked Progress-----");
		
		DLinkedList2 dl = new DLinkedList2();
		dl.addNode(new Student(001, "Tyler", "Johnson", "sophmore", 89.9, 95.7, 45.0));
		dl.addNode(new Student(002, "Sarah", "Jackson", "junior", 90.1, 100.0, 50.4));
		
		dl.sortProgress();
		
		dl.display();
	}
	
	
	public static void sortByID() {
		System.out.println("-----Ranked By ID-----");
		
		DLinkedList2 dl = new DLinkedList2();
		dl.addNode(new Student(001, "Tyler", "Johnson", "sophmore", 89.9, 95.7, 45.0));
		dl.addNode(new Student(002, "Sarah", "Jackson", "junior", 90.1, 100.0, 50.4));
		
		dl.sortID();
		
		dl.display();
	}
	
	
	public static void sortByClassification() {
		System.out.println("-----Ranked By Class-----");
		
		DLinkedList2 dl = new DLinkedList2();
		dl.addNode(new Student(001, "Tyler", "Johnson", "sophmore", 89.9, 95.7, 45.0));
		dl.addNode(new Student(002, "Sarah", "Jackson", "junior", 90.1, 100.0, 50.4));
		
		dl.sortClassification();
		
		dl.display();
	}
	
	
	public static void sortByName() {
		System.out.println("-----Ranked By Name-----");
		
		DLinkedList2 dl = new DLinkedList2();
		dl.addNode(new Student(001, "Tyler", "Johnson", "sophmore", 89.9, 95.7, 45.0));
		dl.addNode(new Student(002, "Sarah", "Jackson", "junior", 90.1, 100.0, 50.4));
		
		dl.sortName();
		
		dl.display();
	}
}
