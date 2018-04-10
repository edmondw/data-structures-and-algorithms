package structures.tree;

import structures.list.Position;

public interface BinaryTree<E> extends Tree<E> {
  /** Returns the Position of p's left child (or null if no child exists). */
  Position<E> left(Position p) throws IllegalArgumentException;

  /** Returns the Position of p's right child (or null if no child exists). */
  Position<E> right(Position p) throws IllegalArgumentException;

  /** Returns the Position of p's sibling (or null if no child exists). */
  Position<E> sibling(Position p) throws IllegalArgumentException;
}
