import java.util.Random;
import java.util.Arrays;


public class Tester {

  public static ArrayOps arrayOps = new ArrayOps();
  public static Random rng = new Random();

  public static int[] testOne = new int[] {
    1, 2, 3, 4
  };
  public static int[] testTwo = new int[] {
    -10, 0, 33, 1218, -9, -12345
  };
  public static int[] testThree = new int[8];
  public static int[] testFour = new int[0];

  public static int[][] testFive = new int[][] {
    {0, 1, 2, 3, 4},
    {5, 6, 7, 8, 9, 10, 11, 12},
    {-1, -2, -5, 2},
    {-80}
  };
  public static int[][] testSix = new int[4][4];
  public static int[][] testSeven = new int[0][0];
  public static int[][] testEight = new int[][] {
    {1, -2, 3, -5},
    {-6, -33, 100, -4},
    {3, -10, 0, 19}
  };
  public static int[][] testNine = new int[][] {
    {1, 5, 3},
    {3, -10, 16},
    {9, 1000, -1000}
  };

  public static void main(String[] args) {
    System.out.println(testSum());
    System.out.println(testLargest());
    System.out.println(testSumRows());
    System.out.println(testLargestInRows());
    System.out.println(testSum2D());
    System.out.println(testRowMagic());
    System.out.println(testColMagic());
    System.out.println(testLocationMagic());
  }

  public static boolean testSum() {
    if (arrayOps.sum(testOne) != (1 + 2 + 3 + 4)) return false;
    if (arrayOps.sum(testTwo) != (-10 + 33 + 1218 - 9 - 12345)) return false;
    if (arrayOps.sum(testThree) != 0) return false;
    if (arrayOps.sum(testFour) != 0) return false;

    for (int i = 0; i < 100; i++) {
      int[] test = createNewArray();

      int sum = 0;
      for (int j = 0; j < test.length; j++) {
        sum += test[j];
      }

      if (arrayOps.sum(test) != sum) return false;
    }

    return true;
  }

  public static boolean testLargest() {
    if (arrayOps.largest(testOne) != 4) return false;
    if (arrayOps.largest(testTwo) != 1218) return false;
    if (arrayOps.largest(testThree) != 0) return false;

    for (int i = 0; i < 100; i++) {
      int[] test = createNewArray();

      int largest = test[0];
      for (int j = 0; j < test.length; j++) {
        if (test[j] > largest) largest = test[j];
      }

      if (arrayOps.largest(test) != largest) return false;
    }

    return true;
  }

  public static boolean testSumRows() {
    int[] fiveResult = arrayOps.sumRows(testFive);
    if (fiveResult[0] != 10) return false;
    if (fiveResult[1] != 68) return false;
    if (fiveResult[2] != -6) return false;
    if (fiveResult[3] != -80) return false;

    for (int i = 0; i < testSix.length; i++) {
      if (arrayOps.sumRows(testSix)[i] != 0) return false;
    }

    for (int i = 0; i < 100; i++) {
      int[][] test = createNew2DArray();
      int[] result = arrayOps.sumRows(test);

      for (int j = 0; j < test.length; j++) {
        if (result[j] != arrayOps.sum(test[j])) return false;
      }
    }

    return true;
  }

  public static boolean testLargestInRows() {
    int[] fiveResult = arrayOps.largestInRows(testFive);
    if (fiveResult[0] != 4) return false;
    if (fiveResult[1] != 12) return false;
    if (fiveResult[2] != 2) return false;
    if (fiveResult[3] != -80) return false;

    for (int i = 0; i < testSix.length; i++) {
      if (arrayOps.largestInRows(testSix)[i] != 0) return false;
    }

    for (int i = 0; i < 100; i++) {
      int[][] test = createNew2DArray();
      int[] result = arrayOps.largestInRows(test);

      for (int j = 0; j < test.length; j++) {
        if (result[j] != arrayOps.largest(test[j])) return false;
      }
    }

    return true;
  }

  public static boolean testSum2D() {
    if (arrayOps.sum(testFive) != -8) return false;
    if (arrayOps.sum(testSix) != 0) return false;
    if (arrayOps.sum(testSeven) != 0) return false;

    for (int i = 0; i < 100; i++) {
      int[][] test = createNew2DArray();

      int sum = 0;
      for (int j = 0; j < test.length; j++) {
        sum += arrayOps.sum(test[j]);
      }

      if (sum != arrayOps.sum(test)) return false;
    }

    return true;
  }

  public static boolean testColSum() {
    int[] result = arrayOps.sumCols(testFive);
    if (!(Arrays.toString(result).equals("[-2, -45, 103, 10]"))) return false;
    if (!(Arrays.toString(arrayOps.sumCols(testSix)).equals("[0, 0, 0, 0]"))) return false;

    for (int i = 0; i < 100; i++) {
      int[][] test = createRectangle();

      int[] sum = new int[test[0].length];
      for (int a = 0; a < test.length; a++) {
        for(int j = 0; j < test[a].length; j++) {
          sum[j] = sum[j] + test[a][j];
        }
      }

      int[] resultTwo = arrayOps.sumCols(test);
      if (!(Arrays.toString(resultTwo).equals(
        Arrays.toString(arrayOps.sumCols(test))
      ))) return false;
    }

    return true;
  }

  public static boolean testRowMagic() {
    if (!arrayOps.isRowMagic(testSix)) return false;
    if (!arrayOps.isRowMagic(testSeven)) return false;
    if (arrayOps.isRowMagic(testEight)) return false;
    if (!arrayOps.isRowMagic(testNine)) return false;

    for (int i = 0; i < 100; i++) {
      int[][] test = createRectangle();

      int[] result = arrayOps.sumRows(test);
      boolean magic = true;
      for (int j = 0; j < result.length; j++) {
        if (result[j] != result[0]) magic = false;
      }

      if (magic != arrayOps.isRowMagic(test)) return false;
    }

    return true;
  }

  public static boolean testColMagic() {
    int[][] testTen = new int[][] {
      {2, 2, 40},
      {10, 3, -44},
      {-2, 5, 14}
    };
    if (!arrayOps.isColMagic(testSix)) return false;
    if (!arrayOps.isColMagic(testSeven)) return false;
    if (arrayOps.isColMagic(testEight)) return false;
    if (arrayOps.isColMagic(testNine)) return false;
    if (!arrayOps.isColMagic(testTen)) return false;

    for (int i = 0; i < 100; i++) {
      int[][] test = createRectangle();

      int[] result = arrayOps.sumCols(test);
      boolean magic = true;
      for (int j = 0; j < result.length; j++) {
        if (result[j] != result[0]) magic = false;
      }

      if (magic != arrayOps.isColMagic(test)) return false;
    }

    return true;
  }

  public static boolean testLocationMagic() {
    int[][] testEleven = new int[][] {
      {0, 2, 6, -5, 1},
      {-16, 3, 9, 10, 1},
      {20, 11, -888, -90, 0}
    };

    if (!arrayOps.isLocationMagic(testSix, 3, 2)) return false;
    if (arrayOps.isLocationMagic(testEight, 0, 2)) return false;
    if (arrayOps.isLocationMagic(testNine, 2, 2)) return false;
    if (!arrayOps.isLocationMagic(testEleven, 0, 0)) return false;

    for (int i = 0; i < 100; i++) {
      int[][] test = createRectangle();
      int row = rng.nextInt(test.length);
      int col = rng.nextInt(test[0].length);
      boolean result = (arrayOps.sumRows(test)[row] == arrayOps.sumCols(test)[col]);
      if (result != arrayOps.isLocationMagic(test, row, col)) return false;
    }

    return true;
  }

  public static int[] createNewArray() {
    int[] newArray = new int[rng.nextInt(101) + 1];

    for (int i = 0; i < newArray.length; i++) {
      newArray[i] = rng.nextInt();
    }

    return newArray;
  }

  public static int[][] createNew2DArray() {
    int rows = rng.nextInt(101) + 1;
    int[][] toReturn = new int[rows][];

    for (int i = 0; i < rows; i++) {
      toReturn[i] = createNewArray();
    }

    return toReturn;
  }

  public static int[][] createRectangle() {
    int rows = rng.nextInt(101) + 1;
    int cols = rng.nextInt(101) + 1;
    int[][] toReturn = new int[rows][cols];

    for (int i = 0; i < rows; i++) {
      int[] newArray = new int[cols];

      for (int j = 0; j < newArray.length; j++) {
        newArray[j] = rng.nextInt();
      }

      toReturn[i] = newArray;
    }

    return toReturn;
  }

}
