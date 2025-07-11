package studentroster;

import java.util.Comparator;

public class StudentActivityLevel implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {
		if(s1.getActivityLevel()>s2.getActivityLevel()) {
			return 1;
		}
		else if(s1.getActivityLevel()==s2.getActivityLevel()) {
			return 0;
		}
		else {
			return -1;
		}
	}

}
