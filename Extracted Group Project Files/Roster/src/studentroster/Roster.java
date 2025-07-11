package studentroster;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Roster {
	
	protected DLinkedList2 roster = new DLinkedList2();
	
	public Roster() {

	}

	//Methods	
	public int getRosterSize() {
		return roster.getSize();
	}
	
	public boolean addStudent(Student s) {
		if(!roster.hasStudent(s)) {
			roster.addNode(s);
			return true;
		}
		return false;
	}
	
	public Student removeStudent(int id) {
		Student s = new Student(id);
		return roster.remove(s);
	}
	
	public Student getStudentWithID(int id) {
		Student key = new Student(id);
		if(roster.hasStudent(key)) {
			for(int i=0; i<roster.getSize();i++) {
				Student s = roster.getStudentAt(i);
				if(s.equals(key)) {
					return s;
				}
			}
		}
		return null;
	}
	
	public Student removeStudent(String name) {
		ArrayList<Student> matches=new ArrayList<>();
		for(int i=0;i<roster.getSize();i++) {
			Student s=roster.getStudentAt(i);
			if(s.getFirstName().equalsIgnoreCase(name)||s.getLastName().equalsIgnoreCase(name)) {
				matches.add(s);
			}
		}
		if(matches.size()==0) {
			return null;
		}
		else if(matches.size()==1) {
			Scanner user = new Scanner(System.in);
			Student s=matches.get(0);
			System.out.println("Student you selected for removal:"+s+"\nAre you sure that you want to remove this student? ");
			String answer=user.next();
			if(yes(answer)) {
				Student removed=roster.remove(matches.get(0));
				return removed;
			}
		}
		Scanner user = new Scanner(System.in);
		System.out.println("There's more than one student with the name '"+name+"'.\n"+printAL(matches)+"\nEnter the list position of student you wish to remove: ");
		int pos=user.nextInt()-1;
		Student s=matches.get(pos);
		System.out.println("Student you selected for removal:"+s+"\nAre you sure that you want to remove this student? ");
		String answer=user.next();
		if(yes(answer)) {
			Student removed=roster.remove(matches.get(pos));
			return removed;
		}
		return null;
	}
	
	public Student getStudentAt(int pos) {
		return roster.getStudentAt(pos);
	}
	
	public DLinkedList2 studentsBetween(String type, double num1, double num2) {
		String ltype = type.toLowerCase();
		switch(ltype) {
		case "grade":
			return roster.studentsBetweenGrades(num1, num2);
		case "academic":
			return roster.studentsBetweenAcademicPro(num1, num2);
		}
		return null;
	}
	
	public void sortRoster(String sortTypeOrder) {
		String lSortTO = sortTypeOrder.toLowerCase();
		switch(lSortTO) {
		case "gradei":
			System.out.print("Lowest to Highest Grade\n---------------------");
			roster.sortGradeAscending();
			System.out.println();
			//roster.printOut();
			break;
		case "graded":
			System.out.print("Highest to Lowest Grade\n-------------------");
			roster.sortGradeDescending();
			System.out.println();
			//roster.printOut();
			break;
		case "academici":
			System.out.print("Lowest to Highest Academic Progress\n-------------------");
			roster.sortProgressAscending();
			System.out.println();
			//roster.printOut();
			break;
		case "academicd":
			System.out.print("Highest to Lowest Academic Progress\n-------------------");
			roster.sortProgressDescending();
			System.out.println();
			//roster.printOut();
			break;
		case "classi":
			System.out.print("Class Order: Freshman to Senior\n-----------------------");
			roster.sortClassificationAscending();
			System.out.println();
			//roster.printOut();
			break;
		case "classd":
			System.out.print("Class Order: Senior to Freshman\n---------------------------");
			roster.sortClassificationDescending();
			System.out.println();
			//roster.printOut();
			break;
		case "idi":
			System.out.print("Lowest to Highest ID Number\n------------------------");
			roster.sortIDAscending();
			System.out.println();
			//roster.printOut();
			break;
		case "idd":
			System.out.print("Highest to Lowest ID Number\n-----------------------");
			roster.sortIDDescending();
			System.out.println();
			//roster.printOut();
			break;
		case "namei":
			System.out.print("Students Ordered A to Z\n--------------------------");
			roster.sortNameAscending();
			System.out.println();
			//roster.printOut();
			break;
		case "named":
			System.out.print("Students Ordered Z to A\n---------------------------");
			roster.sortNameDescending();
			System.out.println();
			//roster.printOut();
			break;
		}
	}
	@Override
	public String toString() {
		String printout = String.format("%-10s%-25s%-10s%-8s%-8s", "ID", "Name(Last,First)", "Class","Grade", "Acad Pro");
		for(int i=0; i<getRosterSize();i++) {
			Student s = roster.getStudentAt(i);
			printout +=String.format("\n"+"%-10d%-25s%-10s%-8.1f%-8.1f", s.getId(), s.getName(), s.getClassification(),s.getGrade(), s.getAcademicProgress());
		}
		return printout;
	}
	

	//------------------
	// Helper Method
	//------------------
	private static String printAL(ArrayList<Student> draft) {
		String print="";
		for(int i=0;i<draft.size();i++) {
			Student s = draft.get(i);
			print+=(i+1)+".) "+s.getId()+" "+s.getLastName()+" "+s.getFirstName()+" "+s.getClassification()+" "+s.getGrade()+" "+s.getAcademicProgress()+"\n";
		}
		return print;
	}
	
	private static boolean yes(String answer) {
		String lanswer=answer.toLowerCase();
		ArrayList<String> yes = new ArrayList<>(Arrays.asList("y","yes"));
		if(yes.contains(lanswer)) {
			return true;
		}
		return false;
	}
	
}
