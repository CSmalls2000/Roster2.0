package studentroster;

import java.util.Comparator;

public class StudentNameComparator implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {
		int diff = s1.getName().compareToIgnoreCase(s2.getName());
		if(diff<0) {
			return -1;
		}
		else if(diff>0) {
			return 1;
		}
		else {
			return 0;
		}
	}

}
