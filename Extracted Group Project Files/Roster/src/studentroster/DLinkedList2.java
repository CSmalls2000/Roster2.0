package studentroster;

public class DLinkedList2 {
	
	
	class Node{  
        Student s;  
        Node previous;  
        Node next;  
          
        public Node(Student student) {  
            this.s = student;  
        }  
    }  
	
	
	 Node head, tail = null; 
	 
	 private int size;
	 
	 public int getSize() {
		 return size;
	 }
	 
	 
	 public void addNode(Student s) {  
	        //Create a new node  
	        Node newNode = new Node(s);  
	          
	        //If list is empty  
	        if(head == null) {  
	            //Both head and tail will point to newNode  
	            head = tail = newNode;  
	            //head's previous will point to null  
	            head.previous = null;  
	            //tail's next will point to null, as it is the last node of the list  
	            tail.next = null;
	            size++;
	        }  
	        else {  
	            //newNode will be added after tail such that tail's next will point to newNode  
	            tail.next = newNode;  
	            //newNode's previous will point to tail  
	            newNode.previous = tail;  
	            //newNode will become new tail  
	            tail = newNode;  
	            //As it is last node, tail's next will point to null  
	            tail.next = null;
	            size++;
	        }  
	    }
	 
	 public Student remove(Student s) {
			if(getSize()>0) {
				if(head.s.equals(s)) {
					Student inList=head.s;
					head=head.next;
					size--;
					return inList;
				}
				else if(tail.s.equals(s)) {
					Student inList=tail.s;
					tail=tail.previous;
					size--;
					return inList;
				}
				Node current = head;
				while(current!=null) {
					Student inList = current.s;
					if(inList.equals(s)) {
						//Unlinking/removing node
						Node cPrevious = current.previous;
						Node cNext = current.next;
						cPrevious.next=cNext;
						cNext.previous=cPrevious;
						size--;
						return inList;
					}
					current=current.next;
				}
			}
			return null;
		}
	 
	 public Student getStudentAt(int pos) {
		 if(0<=pos||pos<getSize()) {
			 int index=0;
			 Node current=head;
			 while(current!=null) {
				 if(index==pos) {
					 return current.s;
				 }
				 index++;
				 current=current.next;
			 }
		 }
		 return null;
	 }
	 
	 public DLinkedList2 studentsBetweenGrades(double g1, double g2) {
		 double min = Math.min(g1, g2);
		 double max = Math.max(g1, g2);
		 DLinkedList2 grade = new DLinkedList2();
		 Node current = head;
		 while(current!=null) {
			 if(min<=current.s.getGrade()&&current.s.getGrade()<=max) {
				 grade.addNode(current.s);
			 }
			 current=current.next;
		 }
		 return grade;
	 }
	 
	 public DLinkedList2 studentsBetweenAcademicPro(double a1, double a2) {
		 double min = Math.min(a1, a2);
		 double max = Math.max(a1, a2);
		 DLinkedList2 acadPro = new DLinkedList2();
		 Node current = head;
		 while(current!=null) {
			 if(min<=current.s.getAcademicProgress()&&current.s.getAcademicProgress()<=max) {
				 acadPro.addNode(current.s);
			 }
			 current=current.next;
		 }
		 return acadPro;
	 }
	 
	 public void sortGradeDescending() {
		 Node current = null, index = null;  
		 Student temp;  
		 //Check whether list is empty  
		 if(head == null) {  
			 return;  
		 }  
		 else {  
			 //Current will point to head  
			 for(current = head; current.next != null; current = current.next) {  
				 //Index will point to node next to current  
				 for(index = current.next; index != null; index = index.next) {  
					 //If current's data is greater than index's data, swap the data of current and index  
					 if(current.s.getGrade() < index.s.getGrade()) {  
						 temp = current.s;  
						 current.s = index.s;  
						 index.s = temp;  
					 }  
				 }  
			 }  
		 }  
	 }  
	 
	 public void sortGradeAscending() {
		 Node current = null, index = null;  
		 Student temp;  
		 //Check whether list is empty  
		 if(head == null) {  
			 return;  
		 }  
		 else {  
			 //Current will point to head  
			 for(current = head; current.next != null; current = current.next) {  
				 //Index will point to node next to current  
				 for(index = current.next; index != null; index = index.next) {  
					 //If current's data is greater than index's data, swap the data of current and index  
					 if(current.s.getGrade() > index.s.getGrade()) {  
						 temp = current.s;  
						 current.s = index.s;  
						 index.s = temp;  
					 }  
				 }  
			 }  
		 }  
	 }  
	 
	 
	 public void sortProgressDescending() {
		 Node current = null, index = null;  
		 Student temp;  
		 //Check whether list is empty  
		 if(head == null) {  
			 return;  
		 }  
		 else {  
			 //Current will point to head  
			 for(current = head; current.next != null; current = current.next) {  
				 //Index will point to node next to current  
				 for(index = current.next; index != null; index = index.next) {  
					 //If current's data is greater than index's data, swap the data of current and index  
					 if(current.s.getAcademicProgress() < index.s.getAcademicProgress()) {  
						 temp = current.s;  
						 current.s = index.s;  
						 index.s = temp;  
					 }  
				 }  
			 }  
		 }  
	 }  
	 
	 public void sortProgressAscending() {
		 Node current = null, index = null;  
		 Student temp;  
		 //Check whether list is empty  
		 if(head == null) {  
			 return;  
		 }  
		 else {  
			 //Current will point to head  
			 for(current = head; current.next != null; current = current.next) {  
				 //Index will point to node next to current  
				 for(index = current.next; index != null; index = index.next) {  
					 //If current's data is greater than index's data, swap the data of current and index  
					 if(current.s.getAcademicProgress() > index.s.getAcademicProgress()) {  
						 temp = current.s;  
						 current.s = index.s;  
						 index.s = temp;  
					 }  
				 }  
			 }  
		 }  
	 }  
	 
	 public void sortIDAscending() {
		 Node current = null, index = null;  
		 Student temp;  
		 //Check whether list is empty  
		 if(head == null) {  
			 return;  
		 }  
		 else {  
			 //Current will point to head  
			 for(current = head; current.next != null; current = current.next) {  
				 //Index will point to node next to current  
				 for(index = current.next; index != null; index = index.next) {  
					 //If current's data is greater than index's data, swap the data of current and index  
					 if(current.s.getId() > index.s.getId()) {  
						 temp = current.s;  
						 current.s = index.s;  
						 index.s = temp;  
					 }  
				 }  
			 }  
		 }  
	 }  
	 
	 public void sortIDDescending() {
		 Node current = null, index = null;  
		 Student temp;  
		 //Check whether list is empty  
		 if(head == null) {  
			 return;  
		 }  
		 else {  
			 //Current will point to head  
			 for(current = head; current.next != null; current = current.next) {  
				 //Index will point to node next to current  
				 for(index = current.next; index != null; index = index.next) {  
					 //If current's data is greater than index's data, swap the data of current and index  
					 if(current.s.getId() < index.s.getId()) {  
						 temp = current.s;  
						 current.s = index.s;  
						 index.s = temp;  
					 }  
				 }  
			 }  
		 }  
	 }  
	 
	 public void sortClassificationAscending() {
		 Node current = null, index = null;  
		 Student temp;  
		 StudentClassificationComparator scc = new StudentClassificationComparator();
		 //Check whether list is empty  
		 if(head == null) {  
			 return;  
		 }  
		 else {  
			 //Current will point to head  
			 for(current = head; current.next != null; current = current.next) {  
				 //Index will point to node next to current  
				 for(index = current.next; index != null; index = index.next) {  
					 //If current's data is greater than index's data, swap the data of current and index  
					 if(scc.compare(current.s, index.s) == 1) {  
						 temp = current.s;  
						 current.s = index.s;  
						 index.s = temp;  
					 }
				 }  
			 }  
		 }  
	 }  
	 
	 public void sortClassificationDescending() {
			Node current = null, index = null;  
		    Student temp;  
		    StudentClassificationComparator scc = new StudentClassificationComparator();
		        //Check whether list is empty  
		    if(head == null) {  
		      return;  
		    }  
		    else {  
		    //Current will point to head  
		     for(current = head; current.next != null; current = current.next) {  
		       //Index will point to node next to current  
		        for(index = current.next; index != null; index = index.next) {  
	//If current's data is greater than index's data, swap the data of current and index  
		           if(scc.compare(current.s, index.s) == 1) {  
		                temp = current.s;  
		                current.s = index.s;  
		                index.s = temp;  
		            }
		         }  
		       }  
		    }  
		 }  
	 
	 
	 
	 public void sortNameDescending() {
		 Node current = null, index = null;  
		 Student temp;
		 StudentNameComparator snc = new StudentNameComparator();
		 //Check whether list is empty  
		 if(head == null) {  
			 return;  
		 }  
		 else {  
			 //Current will point to head  
			 for(current = head; current.next != null; current = current.next) {  
				 //Index will point to node next to current  
				 for(index = current.next; index != null; index = index.next) {  
					 //If current's data is greater than index's data, swap the data of current and index  
					 if(snc.compare(current.s, index.s) == -1) {  
						 temp = current.s;  
						 current.s = index.s;  
						 index.s = temp;  
					 }  
				 }  
			 }  
		 }  
	 }  
	 
	 public void sortNameAscending() {
		 Node current = null, index = null;  
		 Student temp;  
		 StudentNameComparator snc = new StudentNameComparator();
		 //Check whether list is empty  
		 if(head == null) {  
			 return;  
		 }  
		 else {  
			 //Current will point to head  
			 for(current = head; current.next != null; current = current.next) {  
				 //Index will point to node next to current  
				 for(index = current.next; index != null; index = index.next) {  
					 //If current's data is greater than index's data, swap the data of current and index  
					 if( snc.compare(current.s, index.s)== -1) {  
						 temp = current.s;  
						 current.s = index.s;  
						 index.s = temp;  
					 }  
				 }  
			 }  
		 }  
	 }  

	 
	 public void display() {  
	        //Node current will point to head  
	        Node current = head;  
	        if(head == null) {  
	            System.out.println("List is empty");  
	            return;  
	        }  
	        while(current != null) {  
	            //Prints each node by incrementing the pointer.  
	  
	            System.out.println(current.s + " ");  
	            current = current.next;  
	        }  
	        System.out.println();  
	    }
	 
	 public void printOut() {
			Node current = head;
			if(head==null) {
				System.out.println("List is empty.");
			}
			String out = String.format("%-5s%-25s%-10s%-8s%-8s", "ID","Name(Last,First)","Class","Grade","Acad Pro");
			while(current != null) {
				out += String.format("\n%-5d%-25s%-10s%-8.1f%-8.1f", current.s.getId(),current.s.getName(),current.s.getClassification(),current.s.getGrade(),current.s.getAcademicProgress());
				current = current.next;
			}
			System.out.println(out);
		}
	 
	 public boolean hasStudent(Student s) {
		 if(head!=null) {
			 Node current=head;
			 while(current!=null) {
				 if(current.s.equals(s)) {
					 return true;
				 }
				 current=current.next;
			 }
		 }
		 return false;
	 }

 

}
