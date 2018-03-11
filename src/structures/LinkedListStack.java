package structures;

import java.util.LinkedList;

public class LinkedListStack<E> implements Stack<E> {
	LinkedList<E> list = new LinkedList<>();
	
	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.size() == 0;
	}

	@Override
	public E pop() {
		return list.removeFirst();
	}

	@Override
	public void push(E e) {
		list.addFirst(e);;
	}

	@Override
	public E peek() {
		return list.getFirst();
	}
	
	@Override
	public void print() {
		System.out.println("TOP " + list.toString());
	}
}
