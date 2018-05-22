package structures.tree;

import java.util.Iterator;
import structures.list.Position;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {
  protected static class Node<E> implements Position<E> {
    private E element;
    private Node<E> parent;
    private Node<E> left;
    private Node<E> right;
    
    public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
      element = e;
      parent = above;
      left = leftChild;
      right = rightChild;
    }
    
    @Override
    public E getElement() throws IllegalStateException {
      return element;
    }
    
    public void setElement(E e) {
      element = e;
    }

    public Node<E> getParent() {
      return parent;
    }

    public void setParent(Node<E> parent) {
      this.parent = parent;
    }

    public Node<E> getLeft() {
      return left;
    }

    public void setLeft(Node<E> left) {
      this.left = left;
    }

    public Node<E> getRight() {
      return right;
    }

    public void setRight(Node<E> right) {
      this.right = right;
    }
  }
  
  protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right) {
    return new Node<E>(e, parent, left, right);
  }
  
  private Node<E> root;
  private int size = 0;
  
  public LinkedBinaryTree() {}
  
  private Node<E> validate(Position<E> p) throws IllegalArgumentException {
    if (!(p instanceof Node)) {
      throw new IllegalArgumentException("Not a valid position type");
    }
    Node<E> node = (Node<E>) p;
    if (node.getParent() == node) {
      throw new IllegalArgumentException("The node is no longer in the tree");
    }
    return node;
  }
  
  @Override
  public int size() {
    return size;
  }

  @Override
  public Position<E> root() {
    return root;
  }
  
  @Override
  public Position<E> parent(Position<E> p) throws IllegalArgumentException {
    Node<E> node = validate(p);
    return node.getParent();
  }

  @Override
  public Position<E> left(Position<E> p) throws IllegalArgumentException {
    Node<E> node = validate(p);
    return node.getLeft();
  }

  @Override
  public Position<E> right(Position<E> p) throws IllegalArgumentException {
    Node<E> node = validate(p);
    return node.getRight();
  }

  public Position<E> addRoot(E e) throws IllegalArgumentException {
    if (!isEmpty()) {
      throw new IllegalArgumentException("The tree is not empty. Root already exists.");
    }
    root = createNode(e, null, null, null);
    size = 1;
    return root;
  }
  
  public Position<E> addLeft(E e, Position<E> p) throws IllegalArgumentException {
    Node<E> parent = validate(p);
    if (parent.getLeft() != null) {
      throw new IllegalArgumentException("The given position already has left child.");
    }
    Node<E> child = createNode(e, parent, null, null);
    parent.setLeft(child);
    size++;
    return child;
  }
  
  public E set(E e, Position<E> p) {
    Node<E> node = validate(p);
    E previousElement = node.getElement();
    node.setElement(e);
    return previousElement;
  }
  
  public Position<E> addRight(E e, Position<E> p) {
    Node<E> parent = validate(p);
    if (parent.getRight() != null) {
      throw new IllegalArgumentException("The given position already has right child.");
    }
    Node<E> child = createNode(e, parent, null, null);
    parent.setRight(child);
    size++;
    return child;
  }
  
  public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) throws IllegalArgumentException {
    Node<E> node = validate(p);
    if (isInternal(p)) {
      throw new IllegalArgumentException("The provided position has be to a leaf.");
    }
    size = t1.size() + t2.size();
    if(!t1.isEmpty()) {
      t1.root.setParent(node);
      t1.root = null;
      t1.size = 0;
    }
    if(!t2.isEmpty()) {
      t2.root.setParent(node);
      t2.root = null;
      t2.size = 0;
    }
  }

  
  public E remove(Position<E> p) throws IllegalArgumentException {
    Node<E> node = validate(p);
    if (numChildren(p) == 2) {
      throw new IllegalArgumentException("Position has 2 children.");
    }
    Node<E> child = node.getLeft() != null ? node.getLeft() : node.getRight();
    if (child != null) {
      child.setParent(node.getParent());
    }
    if (node == root) {
      root = child;
    } else {
      Node<E> parent = node.getParent();
      if (node == parent.getLeft()) {
        parent.setLeft(child);
      } else {
        parent.setRight(child);
      }
    }
    size--;
    E temp = node.getElement();
    node.setElement(null);
    node.setLeft(null);
    node.setRight(null);
    node.setParent(node); // This implementation convention for defunct node in validate method.
    return temp;
  }
  
  @Override
  public Iterator<E> iterator() {
    return null;
  }

  @Override
  public Iterable<Position<E>> positions() {
    // TODO Auto-generated method stub
    return null;
  }
  
  
}