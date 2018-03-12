package structures.deque;

public interface Deque<E> {
	int size();
	boolean isEmpty();
	void addFirst(E e);
	void addLast(E e);
	E removeFirst();
	E removeLast();
	E peekFirst();
	E peekLast();
	void print();
}
