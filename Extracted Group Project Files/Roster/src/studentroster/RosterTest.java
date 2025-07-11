package studentroster;

public class RosterTest {
	
	public static void main(String[] args) {
		testGetSize();
		testRemoveStudent();
		testToString();
		testSortRoster();
	}
	
	public static void testGetSize() {
		System.out.print("--->testGetSize");
		//Create roster
		Roster r = new Roster();
		
		//Empty roster
		int beforeAdd = r.getRosterSize();
		
		//Add students
		r.addStudent(new Student(234, "Guinyard", "Kelly", "Freshman", 100.0, 25.8));
		r.addStudent(new Student(193, "New", "Alex", "Junior", 96.9, 76.9));
		r.addStudent(new Student(222, "Smith", "Jessica", "Senior", 84.7, 98.9));
		r.addStudent(new Student(376, "Miller", "Harris", "Sophomore", 74.3, 83.6));
		
		//roster size after add
		int afterAdd = r.getRosterSize();
		
		//Expected and Actual
		String expected = "\nExpected: Size before adding should be 0. Size after adding should be 4.";
		String actual = "Actual: Size before adding = "+beforeAdd+". Size after adding = "+afterAdd+".";
		//Results
		System.out.println(expected);
		System.out.println(actual);
	}
	
	public static void testRemoveStudent() {
		System.out.println("\n--->testRemoveStudent");
		//Create roster
		Roster r = new Roster();
		
		//Add Students 
		r.addStudent(new Student(234, "Guinyard", "Kelly", "Freshman", 100.0, 25.8));
		r.addStudent(new Student(193, "New", "Alex", "Junior", 96.9, 76.9));
		r.addStudent(new Student(222, "Smith", "Jessica", "Senior", 84.7, 98.9));
		r.addStudent(new Student(376, "Miller", "Harris", "Sophomore", 74.3, 83.6));
		
		System.out.println("Roster before removing student:\n");
		r.roster.printOut();
		
		//size before removal
		int beforeRemove = r.getRosterSize();
		
		//Removed student
		int id = 222;
		Student removed=r.removeStudent(id);
		int afterRemove=r.getRosterSize();
		
		//Expected and Actual
		String expected = "Expected: Before removal the size should be 4. After removal the student with id ("+id+") should be removed and the size should be 3.";
		String actual = "Actual: The size of the roster before removal is "+beforeRemove+". ";
		if(removed!=null) {
			actual+="\nStudent removed: "+removed;
		}
		actual+=". The size after removal is "+afterRemove;
		
		//Results
		System.out.println(expected);
		System.out.println(actual);
		System.out.println("Roster after removal:\n");
		r.roster.printOut();
	}
	
	public static void testToString() {
		System.out.println("\n--->testToString()");
		
		//Create roster
		Roster r = new Roster();
		
		//Adding students
		r.addStudent(new Student(234, "Guinyard", "Kelly", "Freshman", 100.0, 25.8));
		r.addStudent(new Student(193, "New", "Alex", "Junior", 96.9, 76.9));
		r.addStudent(new Student(222, "Smith", "Jessica", "Senior", 84.7, 98.9));
		r.addStudent(new Student(376, "Miller", "Harris", "Sophomore", 74.3, 83.6));
		
		//Call to Method
		String printout = r.toString();
		
		//Expected and Actual
		String msgExpected = "Expected: The call to the method should print out a roster of students.";
		String msgActual = "Actual: \n";
		
		//Result
		System.out.println(msgExpected);
		System.out.println(msgActual+printout);
		
	}
	
	public static void testSortRoster() {
		System.out.println("\n--->testSortRoster");
		//Create roster
		Roster r = new Roster();
		//Add Students
		r.addStudent(new Student(001, "Johnson", "Tyler", "Sophomore", 95.7, 45.0));
		r.addStudent(new Student(002, "Jackson", "Sarah", "Junior", 100.0, 50.4));
		r.addStudent(new Student(222, "Smith", "Jessica", "Senior", 84.7, 98.9));
		r.addStudent(new Student(456, "Beck", "Victor", "Freshman", 34.1, 24.2));
		r.addStudent(new Student(193, "New", "Alex", "Junior", 96.9, 76.9));
		r.addStudent(new Student(376, "Miller", "Harris", "Sophomore", 74.3, 83.6));
		r.addStudent(new Student(357, "Creech", "Lily", "Senior", 86.7, 20.0));
		r.addStudent(new Student(598, "Daniels", "Max", "Freshman", 99.5, 19.0));
		r.addStudent(new Student(211, "Parker", "Xandria", "Junior", 51.1, 85.5));
		r.addStudent(new Student(175, "Halloway", "Cyrus", "Senior", 65.8, 91.2));
		r.addStudent(new Student(698, "Carter-Blocker", "Harley", "Sophomore", 79.8, 48.7));
		r.addStudent(new Student(234, "Guinyard", "Kelly", "Freshman", 100.0, 25.8));
		String[] sortTypes = {"IDD","GradeI", "ClassD", "AcademicI", "NameD"};
		
		for(String sortType: sortTypes) {
			System.out.println("\n");
			r.sortRoster(sortType);
			
		}
	}

}
