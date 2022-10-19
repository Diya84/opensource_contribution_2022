public class RotateLinkedList {
	private Node head;

	private class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	void rotate(int k) {
		if (k == 0) {
			return;
		}

		Node current = head;
		int count = 1;

		while (count < k && current != null) {
			current = current.next;
			count++;
		}
		if (current == null) {
			return;
		}

		Node kthNode = current;

		while (current.next != null) {
			current = current.next;
		}

		current.next = head;
		head = kthNode.next;
		kthNode.next = null;
	}

	void push(int new_data) {
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
	}

	void printList() {
		Node temp = head;

		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}

		System.out.println();
	}

	public static void main(String args[]) {
		RotateLinkedList linkedList = new RotateLinkedList();
		for (int i = 15; i >= 10; i--)
			linkedList.push(i);

		System.out.println("Given list is ");
		linkedList.printList();

		linkedList.rotate(4);

		System.out.println("Rotated Linked List is ");
		linkedList.printList();
	}
}
