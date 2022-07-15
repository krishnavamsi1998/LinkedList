package linkedList;

public class DoublyLinkedListOperations {

	class Node {

		int data;
		Node prev;
		Node next;

		Node(int data) {
			this.data = data;
			this.prev = null;
			this.next = null;
		}

	}

	static Node head;

	// O(n),O(n)
	void insert(int data) {

		Node newNode = new Node(data);

		if (head == null)
			head = newNode;
		else {
			Node temp = head;
			while (temp.next != null)
				temp = temp.next;
			temp.next = newNode;
			newNode.prev = temp;

		}

	}

	// O(1)
	void insertBegin(int data) {
		Node newNode = new Node(data);

		if (head != null) {

			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		} else
			head = newNode;

	}

	// O(n)
	void deleteLast() {
		if (head != null) {
			if (head.next == null)
				head = null;
			else {

				Node temp = head;
				while (temp.next.next != null)
					temp = temp.next;
				temp.next = null;
			}
		}

	}

	
	
	// O(1)
	void deleteFirst() {
	
		
		if (head != null) {
			if (head.next == null)
				head = null;
			else {
				head.next.prev = null;
				head = head.next;

			}
		}

	}

	// O(n)
	int length() {

		if (head == null)
			return 0;
		else {
			int l = 0;

			Node temp = head;
			while (temp != null) {
				l += 1;
				temp = temp.next;
			}
			return l;
		}

	}
	
	//O(n/2),O(1)
	
	void insertMid(int data) {
		Node newNode = new Node(data);
		Node temp = head;
		int c = 0;
		if (temp.next != null) {
			while (c != (length() / 2) - 1) {
				c++;
				temp = temp.next;
			}

			Node nextNode = temp.next;
			temp.next = newNode;
			newNode.prev = temp;
			newNode.next = nextNode;
			nextNode.prev = newNode;
		} else {
			temp.next = newNode;
			newNode.prev = temp;
		}

	}
	

	// O(n)
	void display() {

		if (head == null)
			System.out.println("list is empty");
		else {
			Node temp = head;
			Node last = null;
			System.out.println();
			System.out.println("in forward direction");
			while (temp != null) {

				System.out.print(temp.data + "->");
				last = temp;
				temp = temp.next;
			}

			System.out.println("\nin reverse direction");
			while (last != null) {

				System.out.print(last.data + "->");
				last = last.prev;

			}

		}
	}

	public static void main(String[] args) {

		DoublyLinkedListOperations list = new DoublyLinkedListOperations();
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);
	
		list.display();
		// System.out.println("\n\nlength: "+list.length());

		// list.deleteFirst();
		list.insertMid(0);
		list.display();
		

	}

}
