package structures.linkedlist;

public class DoublyLinkedListSimple<E> implements LinkedList<E> {
  private static class Node<E> {
    private Node<E> prev;
    private Node<E> next;
    private E element;

    private Node() {
    }

    Node(E element, Node<E> prev, Node<E> next) {
      this.element = element;
      this.prev = prev;
      this.next = next;
    }
  }

  private Node<E> head;
  private Node<E> tail;
  private int size = 0;

  public DoublyLinkedListSimple() {
    head = new Node<>(null, null, null);
    tail = new Node<>(null, head, null);
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
    if (isEmpty())
      return null;
    return head.next.element;
  }

  private Node<E> getNode(int index) {
    if (index < 0 || index >= size)
      throw new IllegalArgumentException("The index " + index + " is invalid.");
    if (isEmpty())
      return null;
    Node<E> iterator = head;
    for (int i = 0; i <= index; i++) {
      iterator = iterator.next;
    }
    return iterator;
  }

  @Override
  public E getLast() {
    if (isEmpty())
      return null;
    return tail.prev.element;
  }

  @Override
  public E get(int index) {
    return getNode(index).element;
  }

  private void addBetween(E element, Node<E> predecessor, Node<E> successor) {
    Node<E> newNode = new Node<>(element, predecessor, successor);
    predecessor.next = newNode;
    successor.prev = newNode;
    size++;
  }

  @Override
  public void addFirst(E element) {
    addBetween(element, head, head.next);
  }

  @Override
  public void addLast(E element) {
    addBetween(element, tail.prev, tail);
  }

  @Override
  public void add(int index, E element) {
    if (index == size) {
      addLast(element);
      return;
    }
    Node<E> predecessor = getNode(index).prev;
    addBetween(element, predecessor, predecessor.next);
  }

  private E remove(Node<E> node) {
    if (isEmpty() || node == null)
      return null;
    Node<E> predecessor = node.prev;
    Node<E> successor = node.next;
    predecessor.next = successor;
    successor.prev = predecessor;
    node.prev.next = node.next;
    E element = node.element;
    node = null;
    size--;
    return element;
  }

  @Override
  public E removeFirst() {
    return remove(head.next);
  }

  @Override
  public E removeLast() {
    return remove(tail.prev);
  }

  @Override
  public E remove(int index) {
    return remove(getNode(index));
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("[ ");
    Node<E> iterator = head.next;
    for (int i = 0; i < size; i++) {
      stringBuilder.append(iterator.element.toString()).append(" ");
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
