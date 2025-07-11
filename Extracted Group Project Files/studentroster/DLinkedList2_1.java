package studentroster;

import java.util.Collections;

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
	        }  
	    }  
	 
	 
	 
	 
	 public void sortGrade() {
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
	 
	 
	 public void sortProgress() {
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
		           if(current.s.getCourseProgress() < index.s.getCourseProgress()) {  
		                temp = current.s;  
		                current.s = index.s;  
		                index.s = temp;  
		            }  
		         }  
		       }  
		    }  
		 }  
	 
	 
	 public void sortID() {
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

 

}
