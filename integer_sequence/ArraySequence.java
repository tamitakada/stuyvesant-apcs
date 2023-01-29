import java.util.NoSuchElementException;


public class ArraySequence implements IntegerSequence{
  private int currentIndex;
  private int[] data;

  public ArraySequence(int [] other){
    currentIndex = 0;
    data = new int[other.length];
    for (int i = 0; i < other.length; i++) {
      data[i] = other[i];
    }
  }

  public ArraySequence(IntegerSequence otherseq){
    currentIndex = 0;
    otherseq.reset();
    data = new int[otherseq.length()];
    int count = 0;
    while (otherseq.hasNext()) {
      try {
        data[count] = otherseq.next();
      } catch (NoSuchElementException e) {
        System.out.println("error!");
        break;
      }
      count++;
    }
    otherseq.reset();
  }

  public void reset(){
    currentIndex = 0;
  }
  public int length(){
    return data.length;
  }
  public boolean hasNext(){
    return currentIndex < data.length;
  }

  public int next() throws NoSuchElementException {
    if (currentIndex == data.length) throw new NoSuchElementException("You've reached the end.");
    else {
      currentIndex++;
      return data[currentIndex - 1];
    }
  }

}
