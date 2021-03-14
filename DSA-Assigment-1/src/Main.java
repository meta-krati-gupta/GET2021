public class Main {

	/**
	 * main Method
	 * @param args
	 */

	public static void main(String[] args)
	{
		MyLinkedList list = new MyLinkedList();
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);
		list.insert(6);
		list.insert(7);
		list.printList();
		if(list.detectLoop()){
			System.out.println("Loop Found !!!");
		}
		else{
			System.out.println("No Loop Found !!!");
		}
		int l=2,r=5,n=2;
		System.out.println("After Rotation of Sublist ===>>");
		list.rotateSubList(l,r,n);
	}

}
