package structures.tree;

import structures.list.Position;

public abstract class AbstractTree<E> implements Tree<E> {
  public boolean isRoot(Position<E> p) {
    return p == root();
  }
  public boolean isExternal(Position<E> p) {
    return numChildren(p) == 0;
  }
  
  public boolean isInternal(Position<E> p) {
    return numChildren(p) > 0;
  }
  
  public boolean isEmpty() {
    return size() == 0;
  }
  
  public int depth(Position<E> p) {
    if (isRoot(p)) {
      return 0;
    } else {
      return 1 + depth(parent(p));
    }
  }
  
  public int height(Position<E> p) {
    int h = 0;
    for (Position<E> c : children(p)) {
      h = Math.max(h, 1 + height(c));
    }
    return h;
  }
  
  public int badHeight() {
    int h = 0;
    for (Position<E> p : positions()) {
      // Must be a leaf because internal node indicates children which indicates more depth.
      if (isExternal(p)) {
        h = Math.max(h, depth(p));
      }
    }
    return h;
  }
}
