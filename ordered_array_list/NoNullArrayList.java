import java.util.ArrayList;


public class NoNullArrayList<T> extends ArrayList<T> {

  public NoNullArrayList() {
    super();
  }

  public NoNullArrayList(int startingCapacity) {
    super(startingCapacity);
  }

  public boolean add(T t) throws IllegalArgumentException {
    if (t == null) {
      throw new IllegalArgumentException(
        "Null is not a valid value."
      );
    } else {
      return super.add(t);
    }
  }

  public void add(int index, T t) throws IllegalArgumentException {
    if (t == null) {
      throw new IllegalArgumentException(
        "Null is not a valid value."
      );
    } else {
      super.add(index, t);
    }
  }

  public T set(int index, T t) throws IllegalArgumentException {
    if (t == null) {
      throw new IllegalArgumentException(
        "Null is not a valid value."
      );
    } else {
      return super.set(index, t);
    }
  }

}
