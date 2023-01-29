import java.util.Random;


public class RealTester {

  public static void main(String[] args) {
    testEquals();
    testAdd();
    testMultiply();
    testDivide();
    testSubtract();
    testCompare();
  }

  public static void testEquals() {
    boolean[] testResults = new boolean[7];

    RealNumber one = new RealNumber(0);
    RealNumber two = new RealNumber(0);

    testResults[0] = one.equals(two);

    one = new RealNumber(-33);
    two = new RealNumber(1.222);

    testResults[1] = !one.equals(two);

    one = new RealNumber(0.0000002);
    two = new RealNumber(0.0000008);

    testResults[2] = !one.equals(two);

    one = new RealNumber(0.8455);
    two = new RealNumber(0.8455549);

    testResults[3] = !one.equals(two);

    one = new RealNumber(0.84555);
    two = new RealNumber(0.8455549);

    testResults[4] = one.equals(two);

    one = new RealNumber(-7823.0);
    two = new RealNumber(-7823.00000000000001);

    testResults[5] = one.equals(two);

    one = new RationalNumber(4, 10);
    two = new RealNumber(0.4);

    testResults[6] = one.equals(two);

    printResults(testResults, "Test Equals");
  }

  public static void testAdd() {
    boolean[] testResults = new boolean[4];

    RealNumber one = new RealNumber(0);
    RealNumber two = null;

    testResults[0] = (one.add(two) == null);

    one = new RealNumber(1212.222);
    two = new RealNumber(-943.00000001);
    testResults[1] = (one.add(two).getValue() == 269.22199999);

    one = new RealNumber(-0.04);
    two = new RealNumber(-0.001);

    testResults[2] = (one.add(two).getValue() == -0.041);

    for (int i = 0; i < 100; i++) {
      Random rng = new Random();
      double first = rng.nextDouble();
      double second = rng.nextDouble();

      RealNumber three = new RealNumber(first);
      RealNumber four = new RealNumber(second);

      if ((first + second) != (three.add(four).getValue())) {
        testResults[3] = false;
        break;
      } else if (i == 99) {
        testResults[3] = true;
      }
    }

    printResults(testResults, "Test Add");
  }

  public static void testMultiply() {
    boolean[] testResults = new boolean[4];

    RealNumber one = new RealNumber(0);
    RealNumber two = null;

    testResults[0] = (one.multiply(two) == null);

    one = new RealNumber(1212.222);
    two = new RealNumber(-943.001);

    testResults[1] = (one.multiply(two).getValue() == -1143126.558222);

    one = new RealNumber(-0.04);
    two = new RealNumber(-0.001);

    testResults[2] = (one.multiply(two).getValue() == 0.00004);

    for (int i = 0; i < 100; i++) {
      Random rng = new Random();
      double first = rng.nextDouble();
      double second = rng.nextDouble();

      RealNumber three = new RealNumber(first);
      RealNumber four = new RealNumber(second);

      if ((first * second) != (three.multiply(four).getValue())) {
        testResults[3] = false;
        break;
      } else if (i == 99) {
        testResults[3] = true;
      }
    }

    printResults(testResults, "Test Multiply");
  }

  public static void testDivide() {
    boolean[] testResults = new boolean[5];

    RealNumber one = new RealNumber(0);
    RealNumber two = null;

    testResults[0] = (one.divide(two) == null);

    one = new RealNumber(1212.222);
    two = new RealNumber(0);

    testResults[1] = (one.divide(two) == null);

    one = new RealNumber(0);
    two = new RealNumber(-0.022101);

    testResults[2] = (one.divide(two).getValue() == 0.0);

    one = new RealNumber(-102);
    two = new RealNumber(-5.432);
    testResults[3] = (one.divide(two).getValue() == 18.777614138438878);

    for (int i = 0; i < 100; i++) {
      Random rng = new Random();
      double first = rng.nextDouble() + 1;
      double second = rng.nextDouble() + 1;

      RealNumber three = new RealNumber(first);
      RealNumber four = new RealNumber(second);

      if ((first / second) != (three.divide(four).getValue())) {
        testResults[4] = false;
        break;
      } else if (i == 99) {
        testResults[4] = true;
      }
    }

    printResults(testResults, "Test Divide");
  }

  public static void testSubtract() {
    boolean[] testResults = new boolean[5];

    RealNumber one = new RealNumber(0);
    RealNumber two = null;

    testResults[0] = (one.subtract(two) == null);

    one = new RealNumber(1212.222);
    two = new RealNumber(0);

    testResults[1] = (one.subtract(two).getValue() == 1212.222);

    one = new RealNumber(-4.5);
    two = new RealNumber(-0.022101);

    testResults[2] = (one.subtract(two).getValue() == -4.477899);

    one = new RealNumber(-102);
    two = new RealNumber(5.432);
    testResults[3] = (one.subtract(two).getValue() == -107.432);

    for (int i = 0; i < 100; i++) {
      Random rng = new Random();
      double first = rng.nextDouble();
      double second = rng.nextDouble();

      RealNumber three = new RealNumber(first);
      RealNumber four = new RealNumber(second);

      if ((first - second) != (three.subtract(four).getValue())) {
        testResults[4] = false;
        break;
      } else if (i == 99) {
        testResults[4] = true;
      }
    }

    printResults(testResults, "Test Subtract");
  }

  public static void testCompare() {
    boolean[] results = new boolean[4];

    RealNumber one = new RealNumber(0);
    RealNumber two = new RationalNumber(1, 0);

    results[0] = (one.compareTo(two) == 0);

    one = new RealNumber(-123929.123123);
    two = new RealNumber(883);

    results[1] = (one.compareTo(two) < 0);

    one = new RationalNumber(90, 23);
    two = new RealNumber(2.11);

    results[2] = (one.compareTo(two) > 0);

    results[3] = true;

    for (int i = 0; i < 100; i++) {
      Random rng = new Random();
      double num = rng.nextDouble();
      double numTwo = rng.nextDouble();

      RealNumber testOne = new RealNumber(num);
      RealNumber testTwo = new RealNumber(numTwo);

      int expected = 1;

      if (num == numTwo) expected = 0;
      else if (num < numTwo) expected = -1;

      if (testOne.compareTo(testTwo) != expected) {
        results[3] = false;
        break;
      }
    }

    printResults(results, "Test compare");
  }

  public static void printResults(boolean[] results, String testName) {
    for (int i = 0; i < results.length; i++) {
      char toShow = 'T';
      if (!results[i]) toShow = 'F';
      System.out.println(testName + " TEST #" + i + ": " + toShow);
    }
  }
}
