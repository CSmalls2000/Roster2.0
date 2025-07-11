package studentroster;

import java.util.Comparator;

public class StudentAcademicProgress implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {
		if(s1.getAcademicProgress()>s2.getAcademicProgress()) {
			return 1;
		}
		else if(s1.getAcademicProgress()==s2.getAcademicProgress()) {
			return 0;
		}
		else {
			return -1;
		}
	}

}
