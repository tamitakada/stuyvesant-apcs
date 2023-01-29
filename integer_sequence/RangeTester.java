import java.util.Random;
import java.util.NoSuchElementException;


public class RangeTester {

  public static void main(String[] args) {
    testNext();
    testLength();
    testResetWithNext();
    testHasNextWithNext();
  }

  public static void testNext() {
    boolean[] results = new boolean[4];

    Range one = new Range(0, 13);
    results[0] = helperTestLoop(0, 13, one);

    one = new Range(-30, 21);
    results[1] = helperTestLoop(-30, 21, one);

    try {
      one.next();
      results[2] = false;
    } catch (NoSuchElementException e) {
      results[2] = true;
    }

    results[3] = true;

    for (int i = 0; i < 100; i++) {
      Random rng = new Random();

      int numOne = rng.nextInt(500);
      int numTwo = rng.nextInt(500);

      numOne = flipRandomly(numOne);
      numTwo = flipRandomly(numTwo);

      int[] sized = orderBySize(numOne, numTwo);

      Range test = new Range(sized[1], sized[0]);
      if (!helperTestLoop(sized[1], sized[0], test)) {
        results[3] = false;
        break;
      }
    }

    printResults(results, "Test next");
  }

  public static void testLength() {
    boolean[] results = new boolean[4];

    Range one = new Range(-44, -10);
    results[0] = (one.length() == 35);

    one = new Range(90, 1000);
    results[1] = (one.length() == 911);

    one = new Range(-2, 4);
    results[2] = (one.length() == 7);

    results[3] = true;

    for (int i = 0; i < 100; i++) {
      Random rng = new Random();

      int numOne = rng.nextInt(500);
      int numTwo = rng.nextInt(500);

      numOne = flipRandomly(numOne);
      numTwo = flipRandomly(numTwo);

      int[] sized = orderBySize(numOne, numTwo);

      Range test = new Range(sized[1], sized[0]);
      int count = 0;
      for (int j = sized[1]; j <= sized[0]; j++) {
        count++;
      }
      if (test.length() != count) {
        results[3] = false;
        break;
      }
    }

    printResults(results, "Test length");
  }

  private static boolean getNext(Range a) {
    try {
      a.next();
    } catch (NoSuchElementException e) {
      return false;
    }
    return true;
  }

  public static void testResetWithNext() {
    boolean[] results = new boolean[7];

    Range one = new Range(0, 2);
    results[0] = getNext(one) && getNext(one) && getNext(one);
    results[1] = !getNext(one);

    one.reset();
    results[2] = getNext(one);

    one = new Range(-73, 104);
    results[3] = getNext(one) && getNext(one) && getNext(one) & getNext(one);
    results[4] = true;
    results[5] = true;
    results[6] = true;

    int ans = -100;
    try {
      ans = one.next();
      results[4] = (ans == -69);
    } catch (NoSuchElementException e) {
      results[4] = false;
    }

    one.reset();
    try {
      ans = one.next();
      results[5] = (ans == -73);
    } catch (NoSuchElementException e) {
      results[5] = false;
    }

    try {
      ans = one.next();
      results[6] = (ans == -72);
    } catch (NoSuchElementException e) {
      results[6] = false;
    }

    printResults(results, "Test reset (with next)");
  }

  public static void testHasNextWithNext() {
    boolean[] results = new boolean[4];

    Range one = new Range(-2, 1);
    results[0] = (one.hasNext());
    results[1] = getNext(one) && getNext(one) && getNext(one) && getNext(one);
    results[2] = (!one.hasNext());

    one = new Range(15, 15);
    results[3] = (one.hasNext());

    printResults(results, "Test hasNext (with next)");
  }

  private static int flipRandomly(int a) {
    Random rng = new Random();
    int flip = rng.nextInt(1);
    if (flip == 0) return a * -1;
    return a;
  }

  private static int[] orderBySize(int a, int b) {
    int[] ints = new int[2];
    if (a > b) {
      ints[0] = a;
      ints[1] = b;
    } else {
      ints[0] = b;
      ints[1] = a;
    }
    return ints;
  }

  private static boolean helperTestLoop(int s, int b, Range r) {
    for (int i = s; i <= b; i++) {
      int ans = s - 1;
      try {
        ans = r.next();
        if (ans != i) return false;
      } catch (NoSuchElementException e) {
        return false;
      }
    }
    return true;
  }

  public static void printResults(boolean[] results, String testName) {
    for (int i = 0; i < results.length; i++) {
      char toShow = 'T';
      if (!results[i]) toShow = 'F';
      System.out.println(testName + " TEST #" + i + ": " + toShow);
    }
  }

}
