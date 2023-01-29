import java.util.Random;
import java.util.ArrayList;


public class OrderedTester {

  public static void main(String[] args) {
    testCreation();
    testAdd();
    testAddWithIndex();
    testSet();
  }

  public static void testCreation() {
    boolean[] res = new boolean[4];

    NoNullArrayList<Integer> one = new OrderedArrayList<Integer>();
    res[0] = (one.toString().equals("[]"));

    int[] oneData = {1, 0, 99, -101, 2, 33, 1, 1, 22, -15, 90, -1};
    one = initInt(oneData);
    res[1] = (one.toString().equals(
        "[-101, -15, -1, 0, 1, 1, 1, 2, 22, 33, 90, 99]"
      )
    );

    String[] twoData = {"hi", "hello", " howdy", "Hola!", "100"};
    OrderedArrayList<String> two = initStr(twoData);
    res[2] = (two.toString().equals(
      "[ howdy, 100, Hola!, hello, hi]"
    ));

    String[] threeData = {"Helloo"};
    ArrayList<String> three = initStr(threeData);
    res[3] = (three.toString().equals(
      "[Helloo]"
    ));

    Utils.printResults(res, "Test constructors");
  }

  public static void testAdd() {
    boolean[] res = new boolean[6];

    OrderedArrayList<Integer> one = new OrderedArrayList<Integer>();
    int[] oneData = {1, -999, -20, 0, 213, 54};
    res[0] = true;
    for (int i = 0; i < 6; i++) {
      try {
        one.add(oneData[i]);
      } catch (IllegalArgumentException e) {
        res[0] = false;
        break;
      }
    }

    res[1] = (one.toString().equals("[-999, -20, 0, 1, 54, 213]"));

    OrderedArrayList<String> two = new OrderedArrayList<String>();
    String[] twoData = {"0.", "Hello there", "981", "penguins", "@mail", "", " "};
    res[2] = true;

    for (int i = 0; i < 7; i++) {
      try {
        res[3] = two.add(twoData[i]);
      } catch (IllegalArgumentException e) {
        res[2] = false;
        break;
      }
      if (!res[3]) {
        break;
      }
    }

    res[4] = (two.toString().equals("[,  , 0., 981, @mail, Hello there, penguins]"));

    try {
      two.add(null);
      res[5] = false;
    } catch (IllegalArgumentException e) {
      res[5] = true;
    }

    Utils.printResults(res, "Test add");
  }

  public static void testAddWithIndex() {
    boolean[] res = new boolean[6];

    OrderedArrayList<Integer> one = new OrderedArrayList<Integer>();
    int[] oneData = {1, -999, -20, 0, 213, 54};
    res[0] = true;
    for (int i = 0; i < 6; i++) {
      try {
        one.add(i, oneData[i]);
      } catch (IllegalArgumentException e) {
        res[0] = false;
        break;
      }
    }

    res[1] = (one.toString().equals("[-999, -20, 0, 1, 54, 213]"));

    OrderedArrayList<String> two = new OrderedArrayList<String>();
    String[] twoData = {"0.", "Hello there", "981", "penguins", "@mail", "", " "};
    res[2] = true;

    for (int i = 0; i < 7; i++) {
      try {
        two.add(i, twoData[i]);
      } catch (IllegalArgumentException e) {
        res[2] = false;
        break;
      }
    }

    try {
      two.add(3, "zee");
      res[3] = true;
    } catch (IllegalArgumentException e) {
      res[3] = false;
    }

    res[4] = (two.toString().equals("[,  , 0., 981, @mail, Hello there, penguins, zee]"));

    try {
      two.add(22, null);
      res[5] = false;
    } catch (IllegalArgumentException e) {
      res[5] = true;
    }

    Utils.printResults(res, "Test add with index");
  }

  public static void testSet() {
    boolean[] res = new boolean[6];

    int[] oneData = {0, -1, 0, 0, 0, -2222};
    ArrayList<Integer> one = initInt(oneData);

    int expected = 0;
    int got = -1;

    try {
      got = one.set(5, -43);
      res[0] = true;
    } catch (IllegalArgumentException e) {
      res[0] = false;
    }

    res[1] = (expected == got);
    res[2] = (one.toString().equals("[-2222, -43, -1, 0, 0, 0]"));

    try {
      one.set(2, null);
      res[3] = false;
    } catch (IllegalArgumentException e) {
      res[3] = true;
    }

    String[] twoData = {"Hello!", "goodbye", "", "919-919-9919", " he& lo& o "};
    OrderedArrayList<String> two = initStr(twoData);

    res[4] = true;

    for (int i = 0; i < twoData.length; i++) {
      try {
        two.set(i, twoData[i]);
      } catch (IllegalArgumentException e) {
        res[4] = false;
        break;
      }
    }

    res[5] = two.toString().equals("[,  he& lo& o , 919-919-9919, Hello!, goodbye]");

    Utils.printResults(res, "Test set");
  }

  private static OrderedArrayList initInt(int[] data) {
    OrderedArrayList<Integer> stuff = new OrderedArrayList<Integer>(data.length);
    for (int i = 0; i < data.length; i++) {
      try {
        stuff.add(data[i]);
      } catch (IllegalArgumentException e) {
        System.out.println(":(((((((((((((((((((((((((((((((((((((((");
      }
    }
    return stuff;
  }

  private static OrderedArrayList initStr(String[] data) {
    OrderedArrayList<String> stuff = new OrderedArrayList<String>(data.length);
    for (int i = 0; i < data.length; i++) {
      try {
        stuff.add(data[i]);
      } catch (IllegalArgumentException e) {
        System.out.println(":(((((((((((((((((((((((((((((((((((((((");
      }
    }
    return stuff;
  }

}
