package structures.list;

public interface Position<E> {
  /**
   * Used to get the element stored at this position.
   * 
   * @return The stored element in the position.
   * @throws IllegalStateException
   *           If position has been removed from the list and thus invalid.
   */
  E getElement() throws IllegalStateException;
}
