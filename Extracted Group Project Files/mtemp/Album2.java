package playlist;



public class Album2 {
	
	protected String name;
	
	
	
	class Node{
		Song s;
		Node prev;
		Node next;
		
		public Node(Song s) {
			this.s=s;
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
	
	
	public void addSong(Song s) {
		Node newNode = new Node(s);
		
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
	
	public void deleteSong(Song s) {
		Node n = new Node(s);
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
	
	public Song prevSong(Song s) {
		Node newNode = new Node(s);
		return newNode.prev.s;
	}
	
	public Song nextSong(Song s) {
		Node newNode = new Node(s);
		return newNode.next.s;
	}
	
	public void searchSong(Song s) {
		int i = 0;
		boolean flag = false;
		Node current = head;
		
		if (head == null) {
			System.out.println("List is empty");
		}
		
		while(current != null) {
			if (current.s == s) {
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
	
	public void sortDuration() {
		Node current = null, index = null;  
	    Song temp;  
	 
	    if(head == null) {  
	      return;  
	    }  
	    else {   
	     for(current = head; current.next != null; current = current.next) {  
	        for(index = current.next; index != null; index = index.next) {  
	           if(current.s.getDuration() < index.s.getDuration()) {  
	                temp = current.s;  
	                current.s = index.s;  
	                index.s = temp;  
	            }  
	         }  
	       }  
	    }  
	}
	
	public void sortTitle() {
		Node current = null, index = null;  
	    Song temp;  
	 
	    if(head == null) {  
	      return;  
	    }  
	    else {   
	     for(current = head; current.next != null; current = current.next) {  
	        for(index = current.next; index != null; index = index.next) {  
	        	SongTitleComparator stc=new SongTitleComparator();
	           if(stc) {  
	                temp = current.s;  
	                current.s = index.s;  
	                index.s = temp;  
	            }  
	         }  
	       }  
	    }  
	}
	
	
	 public void displayAlbum() {  
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
