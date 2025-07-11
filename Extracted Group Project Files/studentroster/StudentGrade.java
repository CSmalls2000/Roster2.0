package studentroster;

import java.util.Comparator;

public class StudentGrade implements Comparator<Student>{
	
//	@Override
//	public int compare(Student s1, Student s2) {
//		if(s1.getGrade()>s2.getGrade()) {
//			return 1;
//		}
//		else if(s1.getGrade()==s2.getGrade()) {
//			return 0;
//		}
//		else {
//			return -1;
//		}
//	}

	
	@Override
	public int compare(Student s1, Student s2) {
		double diff = s1.getGrade() - s2.getGrade();
		if (diff < 0.0) {
			return -1;
		}
		else if (diff > 0.0) {
			return 1;
		}
		else {
			return 0;
		}
	}
}

