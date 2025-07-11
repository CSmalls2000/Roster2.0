package studentroster;

import java.util.Comparator;

public class StudentClassificationComparator implements Comparator<Student>{

	@Override
	public int compare(Student s1, Student s2) {
		String o = s1.getClassification().toLowerCase();
		String t = s2.getClassification().toLowerCase();
		if(o.equals("freshman")&&t.equals("sophomore")) {
			return -1;
		}
		else if(o.equals("freshman")&&t.equals("junior")) {
			return -1;
		}
		else if(o.equals("freshman")&&t.equals("senior")) {
			return -1;
		}
		else if(o.equals("sophomore")&&t.equals("junior")) {
			return -1;
		}
		else if(o.equals("sophomore")&&t.equals("senior")) {
			return -1;
		}
		else if(o.equals("junior")&&t.equals("senior")) {
			return -1;
		}
		else if(o.equals("senior")&&t.equals("junior")) {
			return 1;
		}
		else if(o.equals("senior")&&t.equals("sophomore")) {
			return 1;
		}
		else if(o.equals("senior")&&t.equals("freshman")) {
			return 1;
		}
		else if(o.equals("junior")&&t.equals("sophomore")) {
			return 1;
		}
		else if(o.equals("junior")&&t.equals("freshman")) {
			return 1;
		}
		else if(o.equals("sophomore")&&t.equals("freshman")) {
			return 1;
		}
		else {
			return 0;
		}
	}

}
