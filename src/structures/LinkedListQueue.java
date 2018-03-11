package structures;

import java.awt.List;
import java.util.LinkedList;

public class LinkedListQueue<E> implements Queue<E> {
	LinkedList<E> list = new LinkedList<>();

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public void enqueue(E e) {
		list.addLast(e);
	}
	
	@Override
	public E dequeue() {
		if (isEmpty()) return null;
		return list.removeFirst();
	}

	@Override
	public E peek() {
		return list.peek();
	}

	@Override
	public void print() {
		System.out.println("TOP " + list.toString());
	}
}
