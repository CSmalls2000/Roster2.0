package playlist;

import playlist.Album2.Node;

public class DDLM {
	
	class Node{  
        Album2 a;  
        Node prev;  
        Node next;  
          
        public Node(Album2 a) {  
            this.a=a;  
        }  
    }  
	
	 Node head, tail = null; 
	 
	 public int getSize() {
			int size = 0;
			while(head != null) {
				size ++;
				head = head.next;
			}
			return size;
			
		}
	 
	 public void addAlbum(Album2 a) {
			Node newNode = new Node(a);
			
			if (head==null) {
				head = tail = newNode;
				head.prev = null;
				tail.next = null;

			}
			else {
				tail.next = newNode;
				newNode.prev = tail;
				tail = newNode;
				tail.next = null;
			}
		}
	 
	 public void deleteAlbum(Album2 a) {
			Node n = new Node(a);
			if (head==null ||  n == null) {
			}
			if (head == n) {
				head = n.next;
			}
			if (n.next != null) {
				n.next.prev = n.prev;
			}
			if(n.prev != null) {
				n.prev.next = n.next;
			}
		}
	 
	 public Album2 prevAlbum(Album2 a) {
			Node newNode = new Node(a);
			return newNode.prev.a;
		}
		
	 public Album2 nextAlbum(Album2 a) {
			Node newNode = new Node(a);
			return newNode.next.a;
		}
		
	 public void searchAlbum(Album2 a) {
			int i = 0;
			boolean flag = false;
			Node current = head;
			
			if (head == null) {
				System.out.println("List is empty");
			}
			
			while(current != null) {
				if (current.a == a) {
					flag = true;
					break;
				}
				current = current.next;
				i++;
			}
			
			if (flag == true) {
				System.out.println("Song present at index " + i);
			}
			else {
				System.out.println("Song not present");
			}
		}
	 
	 public void sortAlbumName() {
			Node current = null, index = null;  
		    Album2 temp;  
		 
		    if(head == null) {  
		      return;  
		    }  
		    else {   
		     for(current = head; current.next != null; current = current.next) {  
		        for(index = current.next; index != null; index = index.next) {  
		           if(current.a.name.compareTo(index.a.name) > 1) {  
		                temp = current.a;  
		                current.a = index.a;  
		                index.a = temp;  
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
	  
	           System.out.println(current.a + " "); 
	            current = current.next;  
	        }  
	        System.out.println();  
	    }
	 

}
