package structures.list;

public class ArrayList<E> implements List<E> {
	private static final int CAPACITY = 16;
	private E[] data;
	private int size = 0;
	
	public ArrayList() {
		this(CAPACITY);
	}
	
	public ArrayList(int capacity) {
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
	public E get(int i) throws IndexOutOfBoundsException {
		checkIndex(i, size);
		return data[i];
	}
	
	@Override
	public E set(int i, E e) throws IndexOutOfBoundsException {
		checkIndex(i, size);
		E element = data[i];
		data[i] = e;
		return element;
	}

	@Override
	public void add(int i, E e) throws IndexOutOfBoundsException {
		/* The reason for using size + 1 is because checkIndex would throw an index out of bound 
		 * exception when the last spot is available. For example, think of an array of length
		 * 5 with the last available spot being at index 4. If only one item is in the array at
		 * index 0, then the size becomes 1. Likewise, if the array is filled up until index 3 then
		 * size becomes 4. If last spot at index 4 was specified as the spot desired for addition,
		 * the size is still 4 because nothing has been added yet. If the size was passed into
		 * the checkIndex method along with the last index of 4, then index == size would be evaluated to
		 * true because 4 == 4. Nothing could be added to the last available spot because an
		 * IllegalArgumentException would be thrown because of the truthful evaluation of the
		 * if statement found in the checkIndex method. */
		checkIndex(i, size + 1); 
		if (size == data.length)
			resize(2 * data.length);
		for (int k = size - 1; k >= i; k--) {
			data[k + 1] = data[k];
		}
		data[i] = e;
		size++;
	}

	@Override
	public E remove(int i) throws IndexOutOfBoundsException {
		checkIndex(i, size);
		if (isEmpty()) return null;
		E element = data[i];
		for (int k = i; k <= size - 2; i++) {
			data[k] = data[k + 1];
		}
		size--;
		return element;
	}

	private void checkIndex(int index, int n) throws IndexOutOfBoundsException {
		if (index < 0 || index >= n)
			throw new IndexOutOfBoundsException("Illegal index " + index);
	}
	
	private void resize(int capacity) {
		E[] temp = (E[]) new Object[capacity];
		for (int i = 0; i < size; i++)
			temp[i] = data[i];
		data = temp;
	}

}
