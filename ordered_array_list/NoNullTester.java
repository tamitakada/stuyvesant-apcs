import java.util.Random;
import java.util.ArrayList;


public class NoNullTester {

  public static void main(String[] args) {
    testCreation();
    testAdd();
    testAddWithIndex();
    testSet();
  }

  public static void testCreation() {
    boolean[] res = new boolean[3];

    NoNullArrayList<Integer> one = new NoNullArrayList<Integer>();
    res[0] = (one.toString().equals("[]"));

    int[] oneData = {1, 0, 99, -101, 2, 33, 1, 1, 22, -15, 90, -1};
    one = initIntArray(oneData);
    res[1] = (one.toString().equals(
        "[1, 0, 99, -101, 2, 33, 1, 1, 22, -15, 90, -1]"
      )
    );

    String[] twoData = {"hi", "hello", " howdy", "Hola!", "100"};
    NoNullArrayList<String> two = initStringArray(twoData);
    res[2] = (two.toString().equals(
      "[hi, hello,  howdy, Hola!, 100]"
    ));

    Utils.printResults(res, "Test constructors");
  }

  public static void testAdd() {
    boolean[] res = new boolean[4];

    int[] oneData = {-2, 3, -1, 1000};
    ArrayList<Integer> one = initIntArray(oneData);

    boolean result = true;

    try {
      result = one.add(-4545);
      res[0] = true;
    } catch (IllegalArgumentException e) {
      res[0] = false;
    }

    res[1] = result;

    try {
      one.add(null);
      res[2] = false;
    } catch (IllegalArgumentException e) {
      res[2] = true;
    }

    res[3] = true;
    for (int i = 0; i < 100; i++) {
      Random rng = new Random();
      int test = rng.nextInt();

      NoNullArrayList<Integer> testArr = new NoNullArrayList<Integer>();
      try {
        testArr.add(test);
      } catch (IllegalArgumentException e) {
        res[3] = false;
        break;
      }
    }

    Utils.printResults(res, "Test add");
  }

  public static void testAddWithIndex() {
    boolean[] res = new boolean[4];

    int[] oneData = {99, 2012223, -320948234};
    ArrayList<Integer> one = initIntArray(oneData);

    try {
      one.add(0, 0);
      res[0] = true;
    } catch (IllegalArgumentException e) {
      res[0] = false;
    }

    try {
      one.add(2, null);
      res[1] = false;
    } catch (IllegalArgumentException e) {
      res[1] = true;
    }

    try {
      one.add(2323, null);
      res[2] = false;
    } catch (IllegalArgumentException e) {
      res[2] = true;
    }

    res[3] = true;
    for (int i = 0; i < 100; i++) {
      Random rng = new Random();
      int test = rng.nextInt();

      NoNullArrayList<Integer> testArr = generateRandomArr();
      try {
        testArr.add(rng.nextInt(testArr.size()), test);
      } catch (IllegalArgumentException e) {
        res[3] = false;
        break;
      }
    }

    Utils.printResults(res, "Test add with index");
  }

  public static void testSet() {
    boolean[] res = new boolean[6];

    int[] oneData = {-1, 0, 0, 0, 0, -2222};
    ArrayList<Integer> one = initIntArray(oneData);

    int expected = -2222;
    int got = 0;

    try {
      got = one.set(5, 0);
      res[0] = true;
    } catch (IllegalArgumentException e) {
      res[0] = false;
    }

    res[1] = (expected == got);

    try {
      one.set(2, null);
      res[2] = false;
    } catch (IllegalArgumentException e) {
      res[2] = true;
    }

    try {
      one.set(2323, null);
      res[3] = false;
    } catch (IllegalArgumentException e) {
      res[3] = true;
    }

    res[4] = true;
    res[5] = true;
    for (int i = 0; i < 100; i++) {
      Random rng = new Random();
      int test = rng.nextInt();

      NoNullArrayList<Integer> testArr = generateRandomArr();
      int index = rng.nextInt(testArr.size());
      int ans = testArr.get(index);
      int result = expected + 1;
      try {
        result = testArr.set(index, test);
      } catch (IllegalArgumentException e) {
        res[4] = false;
        res[5] = false;
        break;
      }

      if (ans != result) {
        res[5] = false;
        break;
      }
    }

    Utils.printResults(res, "Test set");
  }

  private static NoNullArrayList<Integer> generateRandomArr() {
    Random rng = new Random();
    int len = rng.nextInt(200) + 1;
    NoNullArrayList<Integer> stuff = new NoNullArrayList<Integer>(len);

    for (int i = 0; i < len; i++) {
      try {
        stuff.add(rng.nextInt());
      } catch (IllegalArgumentException e) {
        System.out.println(":(((((((((((((((((((((((((((((((((((((((");
      }
    }

    return stuff;
  }

  private static NoNullArrayList<String> initStringArray(String[] data) {
    NoNullArrayList<String> stuff = new NoNullArrayList<String>(data.length);
    for (int i = 0; i < data.length; i++) {
      stuff.add(data[i]);
    }
    return stuff;
  }

  private static NoNullArrayList<Integer> initIntArray(int[] data) {
    NoNullArrayList<Integer> stuff = new NoNullArrayList<Integer>(data.length);
    for (int i = 0; i < data.length; i++) {
      stuff.add(data[i]);
    }
    return stuff;
  }

}
