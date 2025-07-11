package studentroster;

public class DLinkedListTest {

	public static void main(String[]args) {
		
		BuildRoster();
		highestGrade();
		highestProgress();
		sortByID();
	}
	
	public static void BuildRoster() {
		System.out.println("-----Roster of Students-----");
		
		DLinkedList2 dl = new DLinkedList2();
		dl.addNode(new Student(123, "Young", "Jaden", "Sophmore", 95., 50.4));
		dl.addNode(new Student(149, "Rivers", "Ciera", "Freshman", 68.8, 21.1));
		dl.addNode(new Student(256, "Knight", "Lyric", "Junior", 74.3, 83.6));
		dl.addNode(new Student(347, "Wiliams", "Austin", "Freshman", 86.7, 20.0));
		dl.addNode(new Student(365, "Odom", "Henry", "Junior", 87.6, 81.2));
		dl.addNode(new Student(431, "Zissett", "Xavier", "Sophmore", 51.1, 55.5));
		dl.addNode(new Student(489, "Guinyard", "Kyle", "Senior", 100.0, 99.9));
		dl.addNode(new Student(546, "Jones", "Raven", "Senior", 88.0, 91.9));
		dl.addNode(new Student(578, "West", "Mandy", "Senior", 99.0, 94.7));
		dl.addNode(new Student(765, "Williams", "James", "Freshman", 80.0, 21.3));
		dl.display();
	}
	
	
	
	public static void highestGrade() {
		System.out.println("-----Ranked Grades-----");
		
		DLinkedList2 dl = new DLinkedList2();
		dl.addNode(new Student(123, "Young", "Jaden", "Sophmore", 95., 50.4));
		dl.addNode(new Student(149, "Rivers", "Ciera", "Freshman", 68.8, 21.1));
		dl.addNode(new Student(256, "Knight", "Lyric", "Junior", 74.3, 83.6));
		dl.addNode(new Student(347, "Wiliams", "Austin", "Freshman", 86.7, 20.0));
		dl.addNode(new Student(365, "Odom", "Henry", "Junior", 87.6, 81.2));
		dl.addNode(new Student(431, "Zissett", "Xavier", "Sophmore", 51.1, 55.5));
		dl.addNode(new Student(489, "Guinyard", "Kyle", "Senior", 100.0, 99.9));
		dl.addNode(new Student(546, "Jones", "Raven", "Senior", 88.0, 91.9));
		dl.addNode(new Student(578, "West", "Mandy", "Senior", 99.0, 94.7));
		dl.addNode(new Student(765, "Williams", "James", "Freshman", 80.0, 21.3));
		
		dl.sortGrade();
		
		dl.display();
	}
	
	
	public static void highestProgress() {
		System.out.println("-----Ranked Progress-----");
		
		DLinkedList2 dl = new DLinkedList2();
		dl.addNode(new Student(123, "Young", "Jaden", "Sophmore", 95., 50.4));
		dl.addNode(new Student(149, "Rivers", "Ciera", "Freshman", 68.8, 21.1));
		dl.addNode(new Student(256, "Knight", "Lyric", "Junior", 74.3, 83.6));
		dl.addNode(new Student(347, "Wiliams", "Austin", "Freshman", 86.7, 20.0));
		dl.addNode(new Student(365, "Odom", "Henry", "Junior", 87.6, 81.2));
		dl.addNode(new Student(431, "Zissett", "Xavier", "Sophmore", 51.1, 55.5));
		dl.addNode(new Student(489, "Guinyard", "Kyle", "Senior", 100.0, 99.9));
		dl.addNode(new Student(546, "Jones", "Raven", "Senior", 88.0, 91.9));
		dl.addNode(new Student(578, "West", "Mandy", "Senior", 99.0, 94.7));
		dl.addNode(new Student(765, "Williams", "James", "Freshman", 80.0, 21.3));
		dl.sortProgress();
		
		dl.display();
	}
	
	
	public static void sortByID() {
		System.out.println("-----Ranked By ID-----");
		
		DLinkedList2 dl = new DLinkedList2();
		dl.addNode(new Student(123, "Young", "Jaden", "Sophmore", 95., 50.4));
		dl.addNode(new Student(149, "Rivers", "Ciera", "Freshman", 68.8, 21.1));
		dl.addNode(new Student(256, "Knight", "Lyric", "Junior", 74.3, 83.6));
		dl.addNode(new Student(347, "Wiliams", "Austin", "Freshman", 86.7, 20.0));
		dl.addNode(new Student(365, "Odom", "Henry", "Junior", 87.6, 81.2));
		dl.addNode(new Student(431, "Zissett", "Xavier", "Sophmore", 51.1, 55.5));
		dl.addNode(new Student(489, "Guinyard", "Kyle", "Senior", 100.0, 99.9));
		dl.addNode(new Student(546, "Jones", "Raven", "Senior", 88.0, 91.9));
		dl.addNode(new Student(578, "West", "Mandy", "Senior", 99.0, 94.7));
		dl.addNode(new Student(765, "Williams", "James", "Freshman", 80.0, 21.3));
		dl.sortID();
		
		dl.display();
	}
	
	
	
	
	
}
