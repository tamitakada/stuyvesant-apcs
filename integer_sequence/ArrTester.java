import java.util.Random;
import java.util.NoSuchElementException;


public class ArrTester {
  public static void main(String[] args) {
    testFirstInit();
    testSecondInit();
  }

  public static void testFirstInit() {
    boolean[] results = new boolean[4];

    int[] one = new int[] {
      0, 1212, -93, 23, 74, 2, 900, -111, 53, 44
    };

    ArraySequence arrOne = new ArraySequence(one);
    results[0] = (arrOne.length() == 10);
    results[1] = helperTestLoop(arrOne, one);

    int[] two = {1,3,5,0,-1,3,9};

    ArraySequence arrTwo = new ArraySequence(two);
    results[2] = (arrTwo.length() == 7);
    results[3] = helperTestLoop(arrTwo, two);

    printResults(results, "Test first constructor");
  }

  public static void testSecondInit() {
    boolean[] results = new boolean[11];

    int[] one = new int[] {
      0, 1212, -93, 23, 74, 2, 900, -111, 53, 44
    };

    ArraySequence arrOne = new ArraySequence(one);
    ArraySequence testOne = new ArraySequence(arrOne);
    results[0] = helperTestLoop(testOne, one);
    results[1] = (testOne.length() == 10);

    Range two = new Range(1, 12);
    results[2] = getNext(two) && getNext(two);

    results[4] = true;

    try {
      int next = two.next();
      results[3] = (next == 3);
    } catch (NoSuchElementException e) {
      results[4] = false;
    }

    ArraySequence testTwo = new ArraySequence(two);
    results[5] = (testTwo.length() == 12);
    int[] twoExpected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    results[6] = helperTestLoop(testTwo, twoExpected);

    results[8] = true;
    try {
      int next = two.next();
      results[7] = (next == 1);
    } catch (NoSuchElementException e) {
      results[8] = false;
    }

    ArraySequence testThree = new ArraySequence(
      new ArraySequence(new Range(3, 4))
    );
    results[9] = (testThree.length() == 2);
    int[] threeExpected = {3, 4};
    results[10] = (helperTestLoop(testThree, threeExpected));

    printResults(results, "Test second constructor");
  }

  private static boolean getNext(IntegerSequence a) {
    try {
      a.next();
    } catch (NoSuchElementException e) {
      return false;
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

  private static boolean helperTestLoop(ArraySequence r, int[] expected) {
    for (int i = 0; i < r.length(); i++) {
      try {
        int got = r.next();
        if (expected[i] != got) return false;
      } catch (NoSuchElementException e) {
        return false;
      }
    }
    return true;
  }
}
