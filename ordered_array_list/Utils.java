import java.util.Random;
import java.util.ArrayList;


public class Utils {
  public static ArrayList<Integer> generateRandomArr() {
    Random rng = new Random();
    int len = rng.nextInt(200) + 1;
    ArrayList<Integer> stuff = new ArrayList<Integer>(len);

    for (int i = 0; i < len; i++) {
        stuff.add(rng.nextInt());
    }

    return stuff;
  }

  public static ArrayList<Integer> initIntList(int[] data) {
    ArrayList<Integer> stuff = new ArrayList<Integer>(data.length);
    for (int i = 0; i < data.length; i++) {
      stuff.add(data[i]);
    }
    return stuff;
  }

  public static void printResults(boolean[] results, String testName) {
    for (int i = 0; i < results.length; i++) {
      char toShow = 'T';
      if (!results[i]) toShow = 'F';
      System.out.println(testName + " TEST #" + i + ": " + toShow);
    }
  }
}
