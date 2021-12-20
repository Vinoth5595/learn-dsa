package learn.coding;

class LList {
	Node head;

	static class Node {
		Node next;
		int data;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	// Method to insert new node at the end
	public static LList insert(LList linkedList, int data) {
		/*
		 * Create new node.
		 * if list is empty points it to head node.
		 * Else traverse till we find the last node.
		 * Then link the node at the last node
		 * 
		 */
		
		Node newNode = new Node(data);
		newNode.next = null;
		
		if(linkedList.head == null) {
			linkedList.head = newNode;
		} else {
			Node lastNode = linkedList.head;
			
			while(lastNode.next != null) {
				lastNode = lastNode.next;
			}
			
			lastNode = newNode;
		}
		
		return linkedList;
	}
	
	public static void printList(LList linkedList) {
		Node currNode = linkedList.head;
		
		while(currNode.next != null) {
			System.out.print(currNode.data + " ");
			currNode = currNode.next;
		}
	}
}

public class CustomLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
