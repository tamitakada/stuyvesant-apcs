import java.util.*;


public class Utils {
  private static Random rng = new Random();

  public static void showRandomResults(ArrayList<String> info) {
    for (int i = 0; i < info.size(); i++) {
      System.out.println("Randomized tests #" + (i + 1) + ": FAIL: " + info.get(i));
    }
    if (info.size() == 0) System.out.println("Randomized tests: PASS");
  }

  public static void showResults(ArrayList<Boolean> results, String testName) {
    for (int i = 0; i < results.size(); i++) {
      if (results.get(i)) System.out.println(testName + " #" + (i + 1) + ": PASS");
      else System.out.println(testName + " #" + (i + 1) + ": FAIL");
    }
  }

  public static String[] createRandomStrArr() {
    int len = rng.nextInt(200);
    String[] toRet = new String[len];

    for (int i = 0; i < len; i++) {
      toRet[i] = createRandomString();
    }

    return toRet;
  }

  public static String createRandomString() {
    String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
    "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    String[] someSpecialChars = {"!", "@", "?", ".", ",", "#", "$", "%", "*"};

    int len = rng.nextInt(500);
    String toRet = "";
    for (int i = 0; i < len; i++) {
      int pickType = rng.nextInt(3);
      if (pickType == 0) {
        int random = rng.nextInt(someSpecialChars.length);
        toRet += someSpecialChars[random];
      } else if (pickType == 1) {
        int random = rng.nextInt(numbers.length);
        toRet += numbers[random];
      } else {
        int random = rng.nextInt(letters.length);
        int upperOrLower = rng.nextInt(2);
        if (upperOrLower == 0) toRet += letters[random].toLowerCase();
        else toRet += letters[random];
      }
    }
    return toRet;
  }

}
