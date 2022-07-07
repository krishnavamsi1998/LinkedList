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

	//O(n),O(n)
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
	//O(n)
	void display() {

		if (head == null)
			System.out.println("list is empty");
		else {
			Node temp = head;
			Node last = null;
			while (temp != null) {

				System.out.print(temp.data + "->");
				last = temp;
				temp = temp.next;
			}
			System.out.println();
			System.out.println("in reverse direction");
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
		list.display();

	}

}
