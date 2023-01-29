

public class Node{

  private String data;
  private Node next,prev;

  public Node(String value) {
    data = value;
    next = null;
    prev = null;
  }

  public void setData(String value) {
    data = value;
  }

  public void setNext(Node next) {
    this.next = next;
  }

  public void setPrev(Node prev) {
    this.prev = prev;
  }

  public String getData() {
    return data;
  }

  public Node getNext() {
    return next;
  }

  public Node getPrev() {
    return prev;
  }
}
