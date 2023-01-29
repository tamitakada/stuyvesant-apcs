import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class Tests {
  public static void main(String[] args) {
    testSort();
    testSortRandomized();
    testSelectSort();
    testSelectRandomized();
    testInsertSort();
    testInsertRandomized();
  }

  public static void testSort() {
    ArrayList<Boolean> results = new ArrayList<Boolean>();

    int[] one = {0, 1, 2, 3, 6, 1000, 93801823};
    Sorts.bubbleSort(one);
    results.add(Arrays.toString(one).equals("[0, 1, 2, 3, 6, 1000, 93801823]"));

    int[] two = {12, -444, 12938, 10, 3, -22, -3, 99, 99, 0};
    Sorts.bubbleSort(two);
    results.add(Arrays.toString(two).equals("[-444, -22, -3, 0, 3, 10, 12, 99, 99, 12938]"));

    int[] three = {6, 1, 3, 2, 4, 5};
    Sorts.bubbleSort(three);
    results.add(Arrays.toString(three).equals("[1, 2, 3, 4, 5, 6]"));

    int[] four = {-2, -4, -4, -4, -2323, -77676, -999999};
    Sorts.bubbleSort(four);
    results.add(Arrays.toString(four).equals("[-999999, -77676, -2323, -4, -4, -4, -2]"));

    int[] five = {5, 1, 12, -5, 16};
    Sorts.bubbleSort(five);
    results.add(Arrays.toString(five).equals("[-5, 1, 5, 12, 16]"));

    showResults(results, "Test Bubble Sort");
  }

  public static void testSortRandomized() {
    ArrayList<String> failInfo = new ArrayList<String>();

    for (int i = 0; i < 50; i++) {
      int[] test = createRandomIntArr();
      Sorts.bubbleSort(test);
      String mySort = Arrays.toString(test);
      Arrays.sort(test);
      if (!mySort.equals(Arrays.toString(test))) {
        failInfo.add(mySort);
      }
    }

    showRandomResults(failInfo);
  }

  public static void testSelectSort() {
    ArrayList<Boolean> results = new ArrayList<Boolean>();

    int[] one = {0, 1, 2, 3, 6, 1000, 93801823};
    Sorts.selectionSort(one);
    results.add(Arrays.toString(one).equals("[0, 1, 2, 3, 6, 1000, 93801823]"));

    int[] two = {12, -444, 12938, 10, 3, -22, -3, 99, 99, 0};
    Sorts.selectionSort(two);
    results.add(Arrays.toString(two).equals("[-444, -22, -3, 0, 3, 10, 12, 99, 99, 12938]"));

    int[] three = {6, 1, 3, 2, 4, 5};
    Sorts.selectionSort(three);
    results.add(Arrays.toString(three).equals("[1, 2, 3, 4, 5, 6]"));

    int[] four = {-2, -4, -4, -4, -2323, -77676, -999999};
    Sorts.selectionSort(four);
    results.add(Arrays.toString(four).equals("[-999999, -77676, -2323, -4, -4, -4, -2]"));

    int[] five = {5, 1, 12, -5, 16};
    Sorts.selectionSort(five);
    results.add(Arrays.toString(five).equals("[-5, 1, 5, 12, 16]"));

    showResults(results, "Test Selection Sort");
  }

  public static void testSelectRandomized() {
    ArrayList<String> failInfo = new ArrayList<String>();

    for (int i = 0; i < 50; i++) {
      int[] test = createRandomIntArr();
      Sorts.selectionSort(test);
      String mySort = Arrays.toString(test);
      Arrays.sort(test);
      if (!mySort.equals(Arrays.toString(test))) {
        failInfo.add(mySort);
      }
    }

    showRandomResults(failInfo);
  }

  public static void testInsertSort() {
    ArrayList<Boolean> results = new ArrayList<Boolean>();

    int[] one = {0, 1, 2, 3, 6, 1000, 93801823};
    Sorts.insertionSort(one);
    results.add(Arrays.toString(one).equals("[0, 1, 2, 3, 6, 1000, 93801823]"));

    int[] two = {12, -444, 12938, 10, 3, -22, -3, 99, 99, 0};
    Sorts.insertionSort(two);
    results.add(Arrays.toString(two).equals("[-444, -22, -3, 0, 3, 10, 12, 99, 99, 12938]"));

    int[] three = {6, 1, 3, 2, 4, 5};
    Sorts.insertionSort(three);
    results.add(Arrays.toString(three).equals("[1, 2, 3, 4, 5, 6]"));

    int[] four = {-2, -4, -4, -4, -2323, -77676, -999999};
    Sorts.insertionSort(four);
    results.add(Arrays.toString(four).equals("[-999999, -77676, -2323, -4, -4, -4, -2]"));

    int[] five = {5, 1, 12, -5, 16};
    Sorts.insertionSort(five);
    results.add(Arrays.toString(five).equals("[-5, 1, 5, 12, 16]"));

    showResults(results, "Test Insertion Sort");
  }

  public static void testInsertRandomized() {
    ArrayList<String> failInfo = new ArrayList<String>();

    for (int i = 0; i < 50; i++) {
      int[] test = createRandomIntArr();
      Sorts.insertionSort(test);
      String mySort = Arrays.toString(test);
      Arrays.sort(test);
      if (!mySort.equals(Arrays.toString(test))) {
        failInfo.add(mySort);
      }
    }

    showRandomResults(failInfo);
  }

  private static int[] createRandomIntArr() {
    Random rng = new Random();
    int len = rng.nextInt(10000);
    int[] arr = new int[len];
    for (int i = 0; i < len; i++) {
      arr[i] = rng.nextInt();
    }
    return arr;
  }

  private static void showRandomResults(ArrayList<String> info) {
    for (int i = 0; i < info.size(); i++) {
      System.out.println("Randomized tests #" + (i + 1) + ": FAIL: Array-" + info.get(i));
    }
    if (info.size() == 0) System.out.println("Randomized tests: PASS");
  }

  private static void showResults(ArrayList<Boolean> results, String testName) {
    for (int i = 0; i < results.size(); i++) {
      if (results.get(i)) System.out.println(testName + " #" + (i + 1) + ": PASS");
      else System.out.println(testName + " #" + (i + 1) + ": FAIL");
    }
  }
}
