public class ArrayOps {

  public static int sum(int[] arr) {
      int sum = 0;
      for (int i = 0; i < arr.length; i++) {
        sum += arr[i];
      }
      return sum;
  }

  public static int largest(int[] arr) {
      int largest = arr[0];
      for (int i = 0; i < arr.length; i++) {
        if (arr[i] > largest) largest = arr[i];
      }
      return largest;
  }

  public static int[] sumRows(int[][] matrix) {
    int[] sums = new int[matrix.length];
    for (int i = 0; i < matrix.length; i++) {
      sums[i] = sum(matrix[i]);
    }
    return sums;
  }

  public static int[] largestInRows(int[][] matrix) {
    int[] largests = new int[matrix.length];
    for (int i = 0; i < matrix.length; i++) {
      largests[i] = largest(matrix[i]);
    }
    return largests;
  }

  public static int sum(int[][] arr) {
      int sum = 0;
      for (int i = 0; i < arr.length; i++) {
        sum += sum(arr[i]);
      }
      return sum;
  }

  public static int[] sumCols(int[][] matrix) {
    if (matrix.length == 0) return new int[0];
    int[] sum = new int[matrix[0].length];
    for (int i = 0; i < matrix.length; i++) {
      for(int j = 0; j < matrix[i].length; j++) {
        sum[j] = sum[j] + matrix[i][j];
      }
    }
    return sum;
  }

  public static boolean isRowMagic(int[][] matrix) {
    int[] result = sumRows(matrix);
    for (int i = 0; i < result.length; i++) {
      if (result[i] != result[0]) return false;
    }
    return true;
  }

  public static boolean isColMagic(int[][] matrix) {
    int[] result = sumCols(matrix);
    for (int i = 0; i < result.length; i++) {
      if (result[i] != result[0]) return false;
    }
    return true;
  }

  public static boolean isLocationMagic(int[][] matrix, int row, int col) {
    return (sumRows(matrix)[row] == sumCols(matrix)[col]);
  }

}
