package studentroster;

public class Student implements Comparable<Student>{
	
	//Instance Variables
	private int id;
	private String firstName;
	private String lastName;
	private String classification;
	private double grade;
	private double courseProgress;
	
	//Constructor
	public Student(int id, String lastName, String firstName, String classification, double grade, double coursePro) {
		this.id=id;
		this.firstName=firstName;
		this.lastName=lastName;
		this.classification=classification;
		this.grade=grade;
		this.courseProgress=coursePro;
	}
	public Student(int id) {
		this(id,"unknown","unknown", "", 0.0,0.0);
	}
	
	//Getters
	public int getId() {
		return id;
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
	public double getCourseProgress() {
		return courseProgress;
	}
	
	public String toString() {
		String printout = String.format("ID: %d Name: %s Grade: %.2f Course Progress: %.2f", getId(), getName(), getGrade(), getCourseProgress());
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
