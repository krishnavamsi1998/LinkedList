package linkedList;

import java.util.HashSet;
import java.util.Stack;

public class SingleLinkedListOperations {

	class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}

	}

	static Node head = null;

	// O(n),O(1)
	void insertNode(int data) {

		Node newNode = new Node(data);

		if (head == null)
			head = newNode;
		else {
			Node tail = head;

			while (tail.next != null)
				tail = tail.next;

			tail.next = newNode;
		}

	}

	// O(1),O(1)
	void InsertAtFirstNode(int data) {

		Node newNode = new Node(data);

		if (head == null)
			head = newNode;
		else {
			newNode.next = head;
			head = newNode;
		}

	}
	// O(n/2),O(1)

	void insertAtMiddle(int data) {

		Node newNode = new Node(data);

		// if it has only one node insert at last
		if (length() == 1) {
			head.next = newNode;

		} else {
			int target = length() / 2;
			int c = 1;

			Node tail = head;

			while (target != c) {
				c++;
				tail = tail.next;
			}
			// means we have reached target position
			newNode.next = tail.next;
			tail.next = newNode;
		}

	}

	// O(n),O(1)

	void deleteLastNode() {

		// make sure linked list is not empty
		if (head != null) {

			if (head.next != null) {
				Node tail = head;
				while (tail.next.next != null)
					tail = tail.next;
				// this means we are at last but one node
				// need to make the next of it to null
				tail.next = null;
			} else
				// this means only one node is there
				head = null;

		}

	}

	// O(1),O(1)

	void deleteFirstNode() {

		// GC (garbage collector take cares of un rechable objects)

		if (head != null) {
			Node temp = head.next;
			head.next = null;
			head = temp;

		}

	}

	int length() {

		int c = 0;

		if (head == null)
			return 0;

		Node tail = head;

		while (tail != null) {
			c++;
			tail = tail.next;
		}

		return c;

	}
	// O(n),O(1)

	boolean search(int key) {
		if (head == null)
			return false;

		Node tail = head;

		while (tail != null) {
			if (tail.data == key)
				return true;
			tail = tail.next;

		}

		return false;

	}
	// O(n),O(1)

	void reverse() {

		Node prev = null;
		Node curr = head;
		Node next = head;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		// starting node will be previous
		head = prev;
		System.out.println(head.data);

	}
	// O(n),O(n)

	void reverseUsingStack() {

		Stack<Node> s = new Stack<>();

		Node tail = head;

		while (tail.next != null) {
			s.add(tail);
			tail = tail.next;
		}

		// now we are at last node
		head = tail;
		while (s.size() != 0) {

			tail.next = s.pop();
			tail = tail.next;
		}

		tail.next = null;

	}

	//O(n),O(1)
	
	void removeDuplicateInSorted() {

		Node prev = head;
		Node curr = head.next;

		while (curr != null) {
			if (curr.data == prev.data) {
				prev.next = curr.next;
				curr = curr.next;
			} else {
				prev = prev.next;
				curr = curr.next;
			}

		}

	}
	
	void lastToFirst()
	{
		
		if(head.next!=null)
		{
		Node prev=head;
		Node curr=head.next;
		
		while(curr.next!=null)
		{
			prev=prev.next;
			curr=curr.next;
			
		}
		
		//making last but one next null so last node link will be dettached
		prev.next=null;
		curr.next=head;
		head=curr;
		}
		
	}
	
	//O(nlogn) , O(logn)
	
	Node mergeSort(Node head) {
		
		//base case
		if (head == null || head.next==null)
			return head;

		Node mid = findMid(head);
		Node head2 = mid.next;
		//making it to null so it becomes a seperate list
		mid.next = null;

		Node newHead1 = mergeSort(head);
		Node newHead2 = mergeSort(head2);
		Node resHead = merge(newHead1, newHead2);
		return resHead;

	}
	
	Node merge(Node head1, Node head2) {

		Node res = null;

		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;

		if (head1.data <= head2.data) {
			res = head1;
			res.next = merge(head1.next, head2);
		} else {
			res = head2;
			res.next = merge(head1, head2.next);
		}

		return res;

	}

	// tortoise and hare approach
	Node findMid(Node head) {

		Node slow,fast;
		slow=head;
		fast=head.next;
		
		//sequence should be same , first check fast != null condition 
		while(fast!=null && fast.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
					
		}
		//by this time, the fast would be at the end and 
		// slow would be at mid of the linked list
		return slow;
	}
	
	//using stack last in first out or esle we can reverse and compare it takes O(1) space
	//O(n),O(n)
	
	boolean isPalidrome() {

		Stack<Node> s = new Stack<>();

		Node temp = head;

		while (temp != null) {
			s.add(temp);
			temp = temp.next;
		}
		
		temp = head;

		while (s.size() != 0) {

			if (s.pop().data != temp.data)
				return false;

			temp = temp.next;

		}

		return true;

	}
	
	//O(n),O(n)
	
	void removeDupUnsorted() {

		Node prev = null;
		Node curr = head;

		HashSet<Integer> set = new HashSet<>();

		while (curr != null) {

			if (set.contains(curr.data))
				prev.next = curr.next;
			else {
				set.add(curr.data);
				prev = curr;

			}
			curr = curr.next;

		}

	}
	
	
	// O(n),O(1)

	void display() {

		System.out.println();

		if (head == null)
			System.out.println("linked list is empty ");
		else {
			Node tail = head;
			while (tail != null) {
				System.out.print(tail.data + "->");
				tail = tail.next;

			}
		}
		System.out.println();
	}

	public static void main(String[] args) {

		SingleLinkedListOperations list = new SingleLinkedListOperations();

		// inserting nodes with values from 1 to 5
		// for (int i = 1; i <= 8; i++)
		// list.insertNode(i);

		list.insertNode(1);
		list.insertNode(3);
		list.insertNode(1);
		list.insertNode(5);
		
		list.insertNode(5);
		list.insertNode(3);
		list.insertNode(6);

		list.display();
		// list.InsertAtFirstNode(6);
		// list.InsertAtFirstNode(5);
		// System.out.println(list.length());

		// list.insertAtMiddle(6);
		// System.out.println(list.search(6));

		// list.reverse();

		// list.reverseUsingStack();
		// list.display();
		//System.out.println(list.isPalidrome());
		list.removeDupUnsorted();
		list.display();
		//head=list.mergeSort(head);
		//list.removeDuplicateInSorted();
		

		// list.deleteLastNode();

		// list.deleteFirstNode();
		// list.display();

	}
}
