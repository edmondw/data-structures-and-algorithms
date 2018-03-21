package structures.list;

/** An interface for positional lists. */

public interface PositionalList<E> {
	/** Returns the number of elements in the list. */
	int size();
	
	/** Test whether the list is empty. */
	boolean isEmpty();
	
	/** Returns the first Position in the list (or null, if empty). */
	Position<E> first();
	
	/** Returns the last Position in the list (or null, if empty). */
	Position<E> last();
	
	/** Returns the Position immediately before Position p (or null, if empty). */
	Position<E> before(Position<E> position); 
	
	/** Returns the Position immediately after Position p (or null, if empty). */
	Position<E> after(Position<E> position);
	
	/** Inserts element e at the front of the list and returns its new Position. */
	Position<E> addFirst(E e);
	
	/** Inserts element e at the end of the list and returns its new Position. */
	Position<E> addLast(E e);
	
	/** Removes the element at the front of the list and returns the element. */
	E removeFirst();
	
	/** Removes the element at the tail of the list and returns the element. */
	E removeLast();
	
	/** Inserts element e immediately before Position p returns the new Position. */
	Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException;
	
	/** Inserts element e immediately after Position p returns the new Position. */
	Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException;
	
	/** Removes element e immediately before Position p and returns the element. */
	E removeBefore(Position<E> p);
	
	/** Removes element e immediately after Position p and returns the element. */
	E removeAfter(Position<E> p);
	
	/**  Replaces the element stored at Position p and returns the replaced element. */
	E set(Position<E> p, E e) throws IllegalArgumentException;

	/** Removes the element stored at Position p and returns it (invalidating p). */
	E remove(Position<E> p) throws IllegalArgumentException;
}
