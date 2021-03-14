import java.util.HashSet;

/**
 * Class MyLinkedList to create Linked List
 */

public class MyLinkedList {

	Node head;

	/**
	 * insert Method to insert a new Node Inside the Linked lIst
	 * @param value
	 */

	void insert(int value){
		Node newNode = new Node(value);

		if(head == null){
			head = newNode;
		} else {
			Node currentNode = head;
			while (currentNode.next!=null) {
				currentNode = currentNode.next;
			}
			currentNode.next = newNode;
		}

	}

	/**
	 * delete a value from the LinkedList
	 * @param value
	 */
	void delete(int value){
		if (head!= null && head.data == value) {
			head = head.next;
			return;
		}
		Node currentNode = head;
		while (currentNode.next != null) {
			if (currentNode.next.data == value) {
				currentNode.next = currentNode.next.next;
				return;
			}
			currentNode = currentNode.next;
		}

	}


	/**
	 * delete value at index from the Linked List 
	 * @param index of Node to delete
	 */	    
	void deleteAt(int index){
		int count = 0;
		if (index == 0) {
			head = head.next;
			return;
		}
		Node currentNode = this.head;
		while (++count < index && currentNode.next != null) {
			currentNode = currentNode.next;
		}
		if(count == index){
			currentNode.next = currentNode.next.next;
		}
	}

	/**
	 * print all the values present in the Linked List 
	 */
	public void printList(){
		Node temp = head;
		while(temp.next!=null){
			System.out.print(temp.data+" -> ");
			temp = temp.next;
		}
		System.out.println(temp.data);
	}

	/**
	 * detectLoop Method is used to detect the loop inside a linked list.
	 * @param head
	 * @return
	 */
	public boolean detectLoop() 
    { 
        HashSet<Node> set = new HashSet<Node>();
        Node currentNode = head;
        while (currentNode!= null) { 
            if (set.contains(currentNode)) 
                return true; 
            set.add(currentNode); 
            currentNode = currentNode.next; 
        }
        return false; 
    }

	/**
	 * rotates the Sublist clockwise by n times
	 * @param leftIndex left position of the sublist in the MyLinkedList.
	 * @param rightIndex right position of the sublist in the MyLinkedList.
	 * @param n is number of Rotation to perform.
	 */

	public void rotateSubList(int leftIndex,int rightIndex,int n)
	{
		int size = rightIndex-leftIndex+1;
		if(n>size){
			n=n%size;
		}
		if(n==0 || n==size){
			Node temp = head;                
			while(temp!=null){
				System.out.println(temp.data);
				temp = temp.next;
			}
			return;
		}
		Node link = null;
		if(leftIndex==1){
			link =head;
		}
		Node currentNode = head;
		int count = 0;
		Node end = null;
		Node previous = null;
		while(currentNode!=null){
			count++;
			if(count==leftIndex-1){
				previous = currentNode;
				link=currentNode.next;
			}
			if(count==rightIndex-n){
				if(leftIndex==1){
					end = currentNode;
					head = currentNode.next;
				}
				else{
					end = currentNode;
					previous.next=currentNode.next;
				}
			}
			if(count==rightIndex){
				Node d = currentNode.next;
				currentNode.next = link;
				end.next = d;
				Node temp = head;
				while(temp!=null){
					System.out.print(temp.data +" -> ");
					temp = temp.next;
				}
				return;
			}
			currentNode = currentNode.next;
		}
	}
}
