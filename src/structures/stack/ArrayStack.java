package structures.stack;

public class ArrayStack<E> implements Stack<E> {
  public static final int CAPACITY = 1000;
  private E[] data;
  private int top = -1;

  public ArrayStack() {
    this(CAPACITY);
  }

  public ArrayStack(int capacity) {
    data = (E[]) new Object[capacity];
  }

  @Override
  public int size() {
    return top + 1;
  }

  @Override
  public boolean isEmpty() {
    return top == -1;
  }

  @Override
  public E pop() {
    if (isEmpty())
      return null;
    E element = data[top];
    data[top--] = null;
    return element;
  }

  @Override
  public void push(E e) {
    if (size() == data.length)
      return;
    data[++top] = e;

  }

  @Override
  public E peek() {
    if (isEmpty())
      return null;
    return data[top];
  }

  @Override
  public String toString() {
    if (isEmpty())
      return "Empty stack!";
    StringBuilder stringBuilder = new StringBuilder("TOP" + System.lineSeparator());
    for (int i = 0; i <= top; i++) {
      stringBuilder.append(data[i].toString()).append(System.lineSeparator());
    }
    return stringBuilder.toString();
  }

  @Override
  public void print() {
    System.out.println(toString());
  }
}
