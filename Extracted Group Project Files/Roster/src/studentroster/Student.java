package studentroster;

public class Student implements Comparable<Student>{
	
	//Instance Variables
	private int id;
	private String firstName;
	private String lastName;
	private String classification;
	private double grade;
	private double acadProgress;
	
	//Constructor
	public Student(int id, String lastName, String firstName, String classification, double grade, double acadPro) {
		this.id=id;
		this.firstName=firstName;
		this.lastName=lastName;
		this.classification=classification;
		this.grade=grade;
		this.acadProgress=acadPro;
	}
	public Student(int id) {
		this(id,"unknown","unknown", "",0.0,0.0);
	}
	
	//Getters
	public int getId() {
		return id;
	}
	public String getLastName() {
		return lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getName() {
		return lastName + ", "+firstName;
	}
	public String getClassification() {
		return classification;
	}
	
	public double getGrade() {
		return grade;
	}
	public double getAcademicProgress() {
		return acadProgress;
	}
	
	public String toString() {
		String printout = String.format("ID: %d Name: %s Classification: %s Grade: %.2f Academic Progress: %.2f", getId(), getName(), getClassification(), getGrade(), getAcademicProgress());
		return printout;
	}

	@Override
	public int compareTo(Student s) {
		int diff = this.id-s.id;
		if(diff<0) {
			return diff;
		}
		if(diff>0) {
			return diff;
		}
		else {
			return 0;
		}
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Student) {
			if(this.id==((Student)o).id) {
				return true;
			}
		}
		return false;
	}
	
	

}
