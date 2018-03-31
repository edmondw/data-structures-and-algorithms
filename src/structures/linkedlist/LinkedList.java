package structures.linkedlist;

public interface LinkedList<E> {
  int size();

  boolean isEmpty();

  E getFirst();

  E getLast();

  E get(int index);

  void addFirst(E element);

  void addLast(E element);

  void add(int index, E element);

  E removeFirst();

  E removeLast();

  E remove(int index);

  void print();
}
