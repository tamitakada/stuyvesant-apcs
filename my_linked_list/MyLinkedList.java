public class MyLinkedList{
  private int size;
  private Node start,end;

  public MyLinkedList() {
    size = 0;
    start = null;
    end = null;
  }

  public int size() {
    return size;
  }

  public boolean add(String value) {
    Node next = new Node(value);

    if (getEnd() != null) {
      next.setPrev(end);
      getEnd().setNext(next);
      setEnd(next);
    } else if (getStart() != null) {
      next.setPrev(getStart());
      getStart().setNext(next);
      setEnd(next);
    } else setStart(next);

    setSize(size() + 1);

    return true;
  }

  public boolean add(int index, String value) {
    if (index < 0 || index > size()) throw new IndexOutOfBoundsException();
    Node toAdd = new Node(value);

    Node current = getStart();
    int count = 0;

    while (current != null && count < index) {
      current = current.getNext();
      count++;
    }

    if (current != null) {
      if (current.getPrev() != null) {
        Node prev = current.getPrev();
        prev.setNext(toAdd);
        toAdd.setPrev(prev);
      }

      toAdd.setNext(current);
      current.setPrev(toAdd);

      setSize(size() + 1);
    } else {
      add(value);
    }

    if (index == 0) setStart(toAdd);

    return true;
  }

  public String get(int index) {
    if (index < 0 || (index >= size() && size() != 0)) throw new IndexOutOfBoundsException();
    Node current = getStart();
    for (int i = 0; i < index; i++) {
      current = current.getNext();
    }
    return current.getData();
  }

  public String set(int index, String value) {
    if (index < 0 || index > size()) throw new IndexOutOfBoundsException();
    if (index == size()) {
      add(value);
      return "";
    } else {
      Node toAdd = new Node(value);

      Node current = getStart();
      int count = 0;

      while (current != null && count < index) {
        current = current.getNext();
        count++;
      }

      if (current != null) {
        toAdd.setPrev(current.getPrev());
        toAdd.setNext(current.getNext());

        if (current.getNext() != null) {
          Node next = current.getNext();
          next.setPrev(toAdd);
        }

        if (current.getPrev() != null) {
          Node prev = current.getPrev();
          prev.setNext(toAdd);
        }

        if (current == getEnd()) setEnd(toAdd);
        if (current == getStart()) setStart(toAdd);
      }
      return current.getData();
    }
  }

  public String toString() {
    String s = "[";

    Node current = getStart();
    int count = 0;
    while (current != null) {
      s += current.getData();

      if (count != size() - 1) s += ", ";

      current = current.getNext();
      count++;
    }

    return s + "]";
  }

  public String remove(int index) {
    if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();
    Node current = getStart();
    int count = 0;
    while (current != null && count < index) {
      current = current.getNext();
      count++;
    }

    if (current != null) {
      if (current.getPrev() != null) {
        current.getPrev().setNext(current.getNext());
      }

      if (current.getNext() != null) {
        current.getNext().setPrev(current.getPrev());
      }

      setSize(size() - 1);
    }

    if (index == 0) setStart(current.getNext());
    else if (index == size() - 1) {
      if (current.getNext() != null) setEnd(current.getNext());
      else setEnd(current.getPrev());
    }

    return current.getData();
  }

/*
*@postcondition: All of the elements from other are removed from the other, and connected to the end of this linked list.
*@postcondition: The size of other is reduced to 0.
*@postcondition: The size of this is now the combined sizes of both original lists
*/
  public void extend(MyLinkedList other){
    if (other.getStart() != null) {
      boolean noEnd = false;
      if (this.getEnd() != null) {
        this.getEnd().setNext(other.getStart());
        other.getStart().setPrev(this.getEnd());
      } else if (this.getStart() != null) {
        this.getStart().setNext(other.getStart());
        other.getStart().setPrev(this.getStart());
      } else {
        noEnd = true;
        this.setStart(other.getStart());
      }

      if (other.getEnd() != null) this.setEnd(other.getEnd());
      else if (noEnd) this.setEnd(other.getStart());

      this.setSize(size() + other.size());

      other.setSize(0);
      other.setStart(null);
      other.setEnd(null);
    }
  }

  private void setSize(int newSize) {
    size = newSize;
  }

  private Node getStart() {
    return start;
  }

  private Node getEnd() {
    return end;
  }

  private void setStart(Node start) {
    this.start = start;
  }

  private void setEnd(Node newEnd) {
    this.end = newEnd;
  }
}
