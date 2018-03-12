package structures.queue;

import com.sun.glass.ui.Size;

import javafx.scene.chart.PieChart.Data;
import sun.security.ec.ECDHKeyAgreement;

public class ArrayQueue<E> implements Queue<E> {
	private static final int CAPACITY = 1000;
	private E[] data;
	private int size = 0,
							front = 0;

	public ArrayQueue() {
		this(CAPACITY);
	}
	
	public ArrayQueue(int capacity) {
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
	public void enqueue(E e) throws IllegalStateException {
		if (size == data.length) throw new IllegalStateException("Queue is full!");
		int availableIndex = (front + size) % data.length;
		data[availableIndex] = e;
		size++;
	}

	@Override
	public E dequeue() {
		if (isEmpty()) return null;
		E element = data[front];
		data[front] = null;
		front = (front + 1) % data.length;
		size--;
		return element;
	}

	@Override
	public E peek() {
		if (isEmpty()) return null;
		return data[front];
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
