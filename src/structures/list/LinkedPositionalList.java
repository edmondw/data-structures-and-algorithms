package structures.list;

public class LinkedPositionalList<E> implements PositionalList<E> {
  private static class Node<E> implements Position<E> {
    private E element;
    private Node<E> prev;
    private Node<E> next;

    public Node(E element, Node<E> prev, Node<E> next) {
      this.element = element;
      this.prev = prev;
      this.next = next;
    }

    @Override
    public E getElement() throws IllegalStateException {
      if (next == null)
        throw new IllegalStateException("Position no longer valid");
      return element;
    }

    public void setElement(E element) {
      this.element = element;
    }

    public Node<E> getPrev() {
      return prev;
    }

    public void setPrev(Node<E> prev) {
      this.prev = prev;
    }

    public Node<E> getNext() {
      return next;
    }

    public void setNext(Node<E> next) {
      this.next = next;
    }
  }

  private Node<E> head;
  private Node<E> tail;
  private int size = 0;

  public LinkedPositionalList() {
    head = new Node<>(null, null, null);
    tail = new Node<>(null, head, null);
    head.setNext(tail);
  }

  /** Validates the position and returns it as a node. */
  private Node<E> validate(Position<E> p) throws IllegalArgumentException {
    if (!(p instanceof Node))
      throw new IllegalArgumentException("Invalid position. Not a node.");
    Node<E> node = (Node<E>) p;
    if (node.getNext() == null) // Convention for defunct node.
      throw new IllegalArgumentException("The position is no longer in the list.");
    return node;
  }

  /** Returns the given node as a Position (or null, if it is a sentinel). */
  private Position<E> position(Node<E> node) {
    if (node == head || node == tail)
      return null; // Don't expose the user to sentinels.
    return node;
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
  public Position<E> first() {
    return position(head.getNext());
  }

  @Override
  public Position<E> last() {
    return position(tail.getPrev());
  }

  @Override
  public Position<E> before(Position<E> position) {
    Node<E> node = validate(position);
    return position(node.getPrev());
  }

  @Override
  public Position<E> after(Position<E> position) {
    Node<E> node = validate(position);
    return position(node.getNext());
  }

  private Position<E> addBetween(E element, Node<E> predecessor, Node<E> successor) {
    Node<E> newNode = new Node<>(element, predecessor, successor);
    predecessor.setNext(newNode);
    successor.setPrev(newNode);
    size++;
    return newNode;
  }

  @Override
  public Position<E> addFirst(E e) {
    return addBetween(e, head, head.getNext());
  }

  @Override
  public Position<E> addLast(E e) {
    return addBetween(e, tail.getPrev(), tail);
  }

  @Override
  public E removeFirst() {
    return remove(head.getNext());
  }

  @Override
  public E removeLast() {
    return remove(tail.getPrev());
  }

  @Override
  public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
    Node<E> node = validate(p);
    return addBetween(e, node.getPrev(), node);
  }

  @Override
  public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
    Node<E> node = validate(p);
    return addBetween(e, node, node.getNext());
  }

  @Override
  public E removeBefore(Position<E> p) {
    Node<E> node = validate(p);
    return remove(node.getNext());
  }

  @Override
  public E removeAfter(Position<E> p) {
    Node<E> node = validate(p);
    return remove(node.getPrev());
  }

  @Override
  public E set(Position<E> p, E e) throws IllegalArgumentException {
    Node<E> node = validate(p);
    E element = node.getElement();
    node.setElement(e);
    return element;
  }

  @Override
  public E remove(Position<E> p) throws IllegalArgumentException {
    Node<E> node = validate(p);
    return remove(node);
  }

  private E remove(Node<E> node) {
    if (node == head || node == tail || node == null)
      return null;
    E element = node.getElement();
    Node<E> predecessor = node.getPrev();
    Node<E> successor = node.getNext();
    predecessor.setNext(successor);
    successor.setPrev(predecessor);
    node.setNext(null);
    node.setPrev(null);
    node.setElement(null);
    node = null;
    size--;
    return element;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    Node<E> iterator = head.getNext();
    while (iterator != tail) {
      stringBuilder.append(iterator.getElement());
      iterator = iterator.getNext();
    }
    return stringBuilder.toString();
  }

  /** Prints the list to console. */
  public void print() {
    System.out.println(toString());
  }
}
