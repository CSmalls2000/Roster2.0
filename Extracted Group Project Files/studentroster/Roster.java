package studentroster;

import java.util.Collections;
import java.util.LinkedList;

public class Roster {
	
	protected LinkedList<Student> roster = new LinkedList<>();
	private String semster;
	private String section;
	private String time;
	private String dayMeet;
	
	public Roster(String semter, String section, String time, String dayMeet) {
		this.semster=semter;
		this.section=section;
		this.time=time;
		this.dayMeet=dayMeet;
	}
	
	public Roster() {
		
	}

	//Methods
//	public String getSemster() {
//		return semster;
//	}
//
//	public String getSection() {
//		return section;
//	}
//
//	public String getTime() {
//		return time;
//	}
//
//	public String getDayMeet() {
//		return dayMeet;
//	}
	
	public boolean addStudent(Student s) {
		if(!roster.contains(s)) {
			roster.add(s);
			roster.sort(null);
			return true;
		}
		return false;
	}
	
	public Student removeStudent(int id) {
		Student s = new Student(id);
		if(roster.contains(s)) {
			int pos = roster.indexOf(s);
			s=roster.get(pos);
			roster.remove(s);
			return s;
		}
		return null;
	}
	
	public void sortByActivityLevel(){
		LinkedList<Student> rost = new LinkedList<>(roster);
		Collections.sort(rost, new StudentActivityLevel());
	}
	
	public void sortByCourseProgress(){
		LinkedList<Student> rost = new LinkedList<>(roster);
		Collections.sort(rost, new StudentCourseProgress());
	}
	
	public void sortById(){
		LinkedList<Student> rost = new LinkedList<>(roster);
		Collections.sort(rost, new StudentID());
	}
	
	public void sortByGrade(){
		LinkedList<Student> rost = new LinkedList<>(roster);
		Collections.sort(rost, new StudentGrade());
	}
	
	public String toString() {
		String msg = "";
		for (Student s: roster) {
			msg += s.toString() + "\n";
		}
		return msg;
	}
	
	

}

