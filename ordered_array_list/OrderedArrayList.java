public class OrderedArrayList<T extends Comparable<T>> extends NoNullArrayList<T> {

  public OrderedArrayList() {
    super();
  }

  public OrderedArrayList(int initialCapacity) {
    super(initialCapacity);
  }

  public boolean add(T item) throws IllegalArgumentException {
    if (item == null) {
      throw new IllegalArgumentException("Null is not valid.");
    }

    int index = -1;
    for (int i = 0; i < this.size(); i++) {
      if (item.compareTo(this.get(i)) < 0) {
        index = i;
        break;
      }
    }

    if (index == -1) {
      if (this.size() == 0) index = 0;
      else index = this.size();
    }

    super.add(index, item);
    return true;
  }

  public void add(int index, T item) throws IllegalArgumentException {
    add(item);
  }

  public T set(int index, T item) throws IllegalArgumentException {
    T toReturn = remove(index);
    add(item);
    return toReturn;
  }

}
