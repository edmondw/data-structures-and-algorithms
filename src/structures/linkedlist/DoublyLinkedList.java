package structures.linkedlist;

public class DoublyLinkedList<E> implements LinkedList<E> {
	private static class Node<E> {
		private E e;
		private Node<E> next;
		private Node<E> previous;
		
		private Node() {}
		
		public Node(E e, Node<E> previous, Node<E> next) {
			this.e = e;
			this.next = next;
			this.previous = previous;
		}

		@Override
		public String toString() {
			return "<" + this.previous + ", " + this.e.toString() + ", " + this.next + ">";
		}
		
		void print() {
			System.out.println(toString());
		}
	}
	
	private Node<E> head;
	private Node<E> tail; 
	private int size = 0;
	
	public DoublyLinkedList() {
		head = new Node<E>(null, null, null);
		tail = new Node<E>(null, head, null); 
		head.next = tail;
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public E getFirst() {
		if (isEmpty()) return null;
		return head.next.e;
	}

	@Override
	public E getLast() {
		if (isEmpty()) return null;
		return tail.previous.e;
	}

	@Override
	public E get(int index) {
		return null;
	}
	
	private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
		Node<E> newNode = new Node<>(e, predecessor, successor);
		predecessor.next = newNode;
		successor.previous = newNode;
		size++;
	}

	@Override
	public void addFirst(E e) {
		addBetween(e, head, head.next);
	}

	@Override
	public void addLast(E e) {
		addBetween(e, tail.previous, tail);
	}
	
	private boolean isInLeftHalf(int index) {
		return index < ((size - 1) / 2);
	}

	@Override
	public void add(int index, E e) {
		if (index < 0 || index > size) return;
		if (index == 0) {
			addFirst(e);
		} else if (index == size - 1 || index == size) {
			addLast(e);
		} else {
			Node<E> newNode;
			if (isInLeftHalf(index)) {
				newNode = getNodeStartingHead(index);
			} else {
				newNode = getNodeStartingTail(index);
			}
			addBetween(e, newNode.previous, newNode);
		}
	}

	@Override
	public E removeFirst() {
		if (isEmpty()) return null;
		return remove(head.next);
	}

	@Override
	public E removeLast() {
		if (isEmpty()) return null;
		return remove(tail.previous);
	}

	@Override
	public E remove(int index) {
		if (index < 0 || index >= size) return null;
		if (index == 0) {
			return removeFirst();
		} else if (index == (size - 1)) {
			return removeLast();
		} else {
			Node<E> node;
			if (isInLeftHalf(index)) {
				node = getNodeStartingHead(index);
			} else {
				node = getNodeStartingTail(index);
			}
			return remove(node);
		}
	}
	
	private E remove(Node<E> node) {
		Node<E> predecessor = node.previous;
		Node<E> successor = node.next;
		predecessor.next = successor;
		successor.previous = predecessor;
		size--;
		E e = node.e;
		node = null;
		return e;
	}
	
	private Node<E> getNodeStartingHead(int index) {
		Node<E> iterator = head.next;
		for (int i = 0; (i < index) && (iterator.next != null); i++) {
			iterator = iterator.next;
		}
		return iterator;
	}
//	0 1 2 3 4
	private Node<E> getNodeStartingTail(int index) {
		Node<E> iterator = tail.previous;
		for (int i = size - 1; (i > index) && (iterator.previous != null); i--) {
			iterator = iterator.previous;
		}
		return iterator;
	}

	private boolean isValidPosition(int index) {
		if (index < 0 || index >= size) 
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder("[ ");
		Node<E> iterator = head.next;
		for (int i = 0; i < size; i++) {
			stringBuilder.append(iterator.e.toString()).append(" ");
			iterator = iterator.next;
		}
		stringBuilder.append("]");
		return stringBuilder.toString();
	}
	
	@Override
	public void print() {
		System.out.println(toString());
	}
}
