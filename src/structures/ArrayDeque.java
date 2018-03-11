package structures;

public class ArrayDeque<E> implements Deque<E> {
	private static final int CAPACITY = 1000;
	private E[] data;
	private int front = 0,
							size = 0;
	
	public ArrayDeque() {
		this(CAPACITY);
	}
	
	public ArrayDeque(int capacity) {
		data = (E[]) new Object[capacity];
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
	public void addFirst(E e) throws IllegalStateException {
		if (size == data.length) throw new IllegalStateException("Deque is full!");
		front = (front - 1 + data.length) % data.length;
		data[front] = e;
		size++;
	}

	@Override
	public void addLast(E e) throws IllegalStateException {
		if (size == data.length) new IllegalStateException("Deque is full!");
		int availableIndex = (front + size) % data.length;
		data[availableIndex] = e;
		size++;
	}

	@Override
	public E removeFirst() {
		if (isEmpty()) return null;
		E element = data[front];
		data[front] = null;
		front = (front + 1) % data.length;
		size--;
		return element;
	}

	@Override
	public E removeLast() {
		if (isEmpty()) return null;
		int lastIndex = (front + size - 1) % data.length;
		E element = data[lastIndex];
		data[lastIndex] = null;
		size--;
		return element;
	}

	@Override
	public E peekFirst() {
		if (isEmpty()) return null;
		return data[front];
	}

	@Override
	public E peekLast() {
		if (isEmpty()) return null;
		int lastIndex =  (front + size - 1) % data.length;
		return data[lastIndex];
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder("TOP" + System.lineSeparator());
		int dataIndex = front;
		for (int i = 0; i < size; i++) {
			stringBuilder.append(data[dataIndex]).append(System.lineSeparator());
			dataIndex = (dataIndex + 1) % data.length;
		}
		return stringBuilder.toString();
	}

	@Override
	public void print() {
		System.out.println(toString());
	}
}
