package structures.tree;

import java.util.Iterator;

import structures.list.Position;

public interface Tree<E> extends Iterable<E> {
  /** Returns the root of the tree. */
  Position<E> root();
  
  /** Returns the parent position of p. */
  Position<E> parent(Position<E> p) throws IllegalArgumentException;
  
  /** Returns an iterable collection of positions of position p. */
  Iterable<Position<E>> children(Position<E>  p) throws IllegalArgumentException;
  
  /** Returns the number of children of position of p. */
  int numChildren(Position<E> p) throws IllegalArgumentException;
  
  /** Returns true if position p is an external(leaf: having no children) node. */
  boolean isExternal(Position<E>  p) throws IllegalArgumentException;
  
  /** Returns true if position p is an internal node (having more than 1 children). */
  boolean isInternal(Position<E> p) throws IllegalArgumentException;
  
  /** Returns true if position p is the root of the tree. */
  boolean isRoot(Position<E> p) throws IllegalArgumentException;
  
  /** Returns the number of positions (and thus number of elements) in the tree. */
  int size();
  
  /** Returns true if the tree contains no positions (thus no elements). */
  boolean isEmpty();
  
  /** Returns an iterator for all elements in the tree (so that the tree itself is Iterable). */
  Iterator<E> iterator();
  
  /** Returns an iterable collection of all positions of the tree. */
  Iterable<Position<E>> position(); 
  
  
}
