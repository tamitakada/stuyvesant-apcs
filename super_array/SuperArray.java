public class SuperArray {

  private String[] data;
  private int size;

  public SuperArray(int initialCapacity) {
    if (initialCapacity < 0) {
      throw new IllegalArgumentException(
        initialCapacity + " is negative. Capacity cannot be negative.");
    }
    data = new String[initialCapacity];
    size = 0;
  }

  public SuperArray() {
    data = new String[10];
    size = 0;
  }

  public int size() {
    return size;
  }

  public boolean add(String element) {
    if (data.length == size) {
      resize();
    }

    data[size] = element;
    size++;

    return true;
  }

  public void add(int index, String element) {
    if ((index > size) || (index < 0)) {
      throw new IndexOutOfBoundsException(
        "Index must be positive and below size. " + index + " is out of bounds."
      );
    }
    int newSize = data.length;
    if (data.length == size) newSize = (2 * size);
    String[] newData = new String[newSize];

    size++;

    for (int i = 0; i < size; i++) {
      if (i < index) newData[i] = data[i];
      else if (i == index) newData[i] = element;
      else newData[i] = data[i - 1];
    }

    data = newData;
  }

  public String get(int index) {
    if ((index >= size) || (index < 0)) {
      throw new IndexOutOfBoundsException(
        "Index must be positive and below size. " + index + " is out of bounds."
      );
    }
    return data[index];
  }

  public String set(int index, String element) {
    if ((index >= size) || (index < 0)) {
      throw new IndexOutOfBoundsException(
        "Index must be positive and below size. " + index + " is out of bounds."
      );
    }
    String toReplace = data[index];
    data[index] = element;
    return toReplace;
  }

  private void resize() {
    String[] newData = new String[size * 2 + 10];
    for (int i = 0; i < size; i++) {
      newData[i] = data[i];
    }
    data = newData;
  }

  public boolean isEmpty() {
    return (size == 0);
  }

  public void clear() {
    size = 0;
    data = new String[10];
  }

  public String toString() {
    String toReturn = "[";
    for (int i = 0; i < size; i++) {
      toReturn += data[i];
      if (i != (size - 1)) toReturn += ", ";
    }
    return (toReturn + "]");
  }

  public boolean contains(String s) {
    return (indexOf(s) != -1);
  }

  public String remove(int index) {
    if ((index >= size) || (index < 0)) {
      throw new IndexOutOfBoundsException(
        "Index must be positive and below size. " + index + " is out of bounds."
      );
    }
    String[] newData = new String[data.length];
    int count = 0;

    String toRemove = data[index];

    for (int i = 0; i < size; i++) {
      if (i != index) {
        newData[count] = data[i];
        count++;
      }
    }

    data = newData;
    size--;

    return toRemove;
  }

  public int indexOf(String s) {
    for (int i = 0; i < size; i++) {
      if (s.equals(data[i])) return i;
    }
    return -1;
  }

  public String[] toArray() {
    String[] array = new String[size];

    for (int i = 0; i < size; i++) {
      array[i] = data[i];
    }

    return array;
  }

  public int lastIndexOf(String value){
    for (int i = size - 1; i >= 0; i--) {
      if (data[i].equals(value)) return i;
    }
    return -1;
  }

  public boolean equals(SuperArray other){
    if (other.size() != size) return false;

    for (int i = 0; i < size; i++) {
      if (!other.get(i).equals(data[i])) return false;
    }

    return true;
  }

}
