import java.util.Random;


public class RationalTester {

  public static void main(String[] args) {
    testCreationAndGets();
    testReciprocals();
    testEquals();
    testString();
    testMultiply();
    testDivide();
    testAdd();
    testSubtract();
  }

  public static void testCreationAndGets() {
    boolean[] testResults = new boolean[16];

    RationalNumber one = new RationalNumber(0, 1);
    RationalNumber two = new RationalNumber(1, 0);

    testResults[0] = (one.getValue() == 0);
    testResults[1] = (two.getValue() == 0);

    testResults[2] = (one.getNumerator() == 0);
    testResults[3] = (one.getDenominator() == 1);

    testResults[4] = (one.getNumerator() == 0);
    testResults[5] = (two.getDenominator() == 1);

    one = new RationalNumber(5, -2);
    two = new RationalNumber(-0, -100);

    testResults[6] = (one.getValue() == -2.5);
    testResults[7] = (two.getValue() == 0.0);

    testResults[8] = (one.getNumerator() == 5);
    testResults[9] = (one.getDenominator() == -2);

    testResults[10] = (two.getNumerator() == 0);
    testResults[11] = (two.getDenominator() == -100);

    one = new RationalNumber(325, 455);
    two = new RationalNumber(21, -7);

    testResults[12] = (one.getNumerator() == 5);
    testResults[13] = (one.getDenominator() == 7);

    testResults[14] = (two.getNumerator() == -3);
    testResults[15] = (two.getDenominator() == 1);

    printResults(testResults, "Test Creation & Gets");
  }

  public static void testReciprocals() {
    boolean[] testResults = new boolean[5];

    RationalNumber one = new RationalNumber(0, 1);
    RationalNumber two = new RationalNumber(1, 0);

    testResults[0] = (one.reciprocal().getValue() == 0);
    testResults[1] = (two.reciprocal().getValue() == 0);

    one = new RationalNumber(5, -2);
    two = new RationalNumber(-0, -100);

    testResults[2] = (one.reciprocal().getValue() == -0.4);
    testResults[3] = (two.reciprocal().getValue() == 0);

    for (int i = 0; i < 100; i++) {
      Random rng = new Random();
      int first = rng.nextInt();
      int second = rng.nextInt();
      RationalNumber ratNum = new RationalNumber(first, second);

      double expected = 0.0;
      if (first != 0) expected = (Double.valueOf(second) / Double.valueOf(first));

      if (ratNum.reciprocal().getValue() != expected) {
        testResults[4] = false;
        break;
      } else if (i == 99) {
        testResults[4] = true;
      }
    }

    printResults(testResults, "Test Reciprocals");
  }

  public static void testEquals() {
    boolean[] testResults = new boolean[5];

    RationalNumber one = new RationalNumber(0, 1);
    RationalNumber two = new RationalNumber(1, 0);

    testResults[0] = one.equals(two);

    one = new RationalNumber(5, -2);
    two = new RationalNumber(-0, -100);

    testResults[1] = !one.equals(two);

    one = new RationalNumber(8, -4);
    two = new RationalNumber(8, -4);

    testResults[2] = one.equals(two);

    two = new RationalNumber(4, -2);

    testResults[3] = !one.equals(two);

    for (int i = 0; i < 100; i++) {
      Random rng = new Random();

      int first = rng.nextInt(10) + 1;
      int second = rng.nextInt(10) + 1;

      int third = rng.nextInt(10) + 1;
      int fourth = rng.nextInt(10) + 1;

      RationalNumber ratNum = new RationalNumber(first, second);
      RationalNumber ratNumTwo = new RationalNumber(third, fourth);

      boolean expected = ((first == third) && (second == fourth));

      if (ratNum.equals(ratNumTwo) != expected) {
        testResults[4] = false;
        break;
      } else if (i == 99) {
        testResults[4] = true;
      }
    }

    printResults(testResults, "Test Equals");
  }

  public static void testString() {
    boolean[] testResults = new boolean[7];

    RationalNumber one = new RationalNumber(0, 1);
    RationalNumber two = new RationalNumber(1, 0);

    testResults[0] = one.toString().equals("0");
    testResults[1] = two.toString().equals("0");

    one = new RationalNumber(5, -2);
    two = new RationalNumber(-0, -100);

    testResults[2] = one.toString().equals("5/-2");
    testResults[3] = two.toString().equals("0");

    one = new RationalNumber(-99, 1);
    two = new RationalNumber(4, 3);

    testResults[4] = one.toString().equals("-99");
    testResults[5] = two.toString().equals("4/3");

    one = new RationalNumber(-100, -55);

    testResults[6] = one.toString().equals("20/11");

    printResults(testResults, "Test toString");
  }

  public static void testMultiply() {
    boolean[] testResults = new boolean[5];

    RationalNumber one = new RationalNumber(0, 1);
    RationalNumber two = new RationalNumber(1, 0);

    testResults[0] = (one.multiply(two).getValue() == 0);

    one = new RationalNumber(5, -2);
    two = new RationalNumber(10, 20);

    RationalNumber result = one.multiply(two);
    testResults[1] = (result.getValue() == -1.25);
    testResults[2] = (result.getNumerator() == 5);
    testResults[3] = (result.getDenominator() == -4);

    one = new RationalNumber(3, 19);
    two = new RationalNumber(0, 43);

    testResults[4] = (one.multiply(two).getValue() == 0);

    printResults(testResults, "Test multiply");
  }

  public static void testDivide() {
    boolean[] testResults = new boolean[5];

    RationalNumber one = new RationalNumber(0, 1);
    RationalNumber two = new RationalNumber(1, 0);

    testResults[0] = (one.divide(two).getValue() == 0);

    one = new RationalNumber(5, -2);
    two = new RationalNumber(4, 10);

    RationalNumber result = one.divide(two);
    testResults[1] = (result.getValue() == -6.25);
    testResults[2] = (result.getNumerator() == 25);
    testResults[3] = (result.getDenominator() == -4);

    one = new RationalNumber(63, 2);
    two = new RationalNumber(77, 0);

    testResults[4] = (one.divide(two).getValue() == 0);

    printResults(testResults, "Test divide");
  }

  public static void testAdd() {
    boolean[] testResults = new boolean[6];

    RationalNumber one = new RationalNumber(0, 1);
    RationalNumber two = new RationalNumber(1, 0);

    testResults[0] = (one.add(two).getValue() == 0);

    one = new RationalNumber(5, -2);
    two = new RationalNumber(4, 10);

    RationalNumber result = one.add(two);
    testResults[1] = (result.getValue() == -2.1);
    testResults[2] = (result.getNumerator() == 21);
    testResults[3] = (result.getDenominator() == -10);

    one = new RationalNumber(63, 2);
    two = new RationalNumber(77, 1);

    testResults[4] = (one.add(two).getValue() == 108.5);

    for (int i = 0; i < 100; i++) {
      Random rng = new Random();

      int first = rng.nextInt(50) + 1;
      int second = rng.nextInt(50) + 1;
      RationalNumber ratNum = new RationalNumber(first, second);

      int third = rng.nextInt(50) + 1;
      int fourth = rng.nextInt(50) + 1;
      RationalNumber ratNumTwo = new RationalNumber(third, fourth);

      RationalNumber ratAns = new RationalNumber(
        ((first * fourth) + (third * second)),
        (second * fourth)
      );

      if (ratNum.add(ratNumTwo).getValue() != ratAns.getValue()) {
        testResults[5] = false;
        break;
      } else if (i == 99) {
        testResults[5] = true;
      }
    }

    printResults(testResults, "Test add");
  }

  public static void testSubtract() {
    boolean[] testResults = new boolean[6];

    RationalNumber one = new RationalNumber(0, 1);
    RationalNumber two = new RationalNumber(1, 0);

    testResults[0] = (one.subtract(two).getValue() == 0);

    one = new RationalNumber(5, -2);
    two = new RationalNumber(4, 10);

    RationalNumber result = one.subtract(two);
    testResults[1] = (result.getValue() == -2.9);
    testResults[2] = (result.getNumerator() == 29);
    testResults[3] = (result.getDenominator() == -10);

    one = new RationalNumber(63, 2);
    two = new RationalNumber(77, 1);

    testResults[4] = (one.subtract(two).getValue() == -45.5);

    for (int i = 0; i < 100; i++) {
      Random rng = new Random();

      int first = rng.nextInt(50) + 1;
      int second = rng.nextInt(50) + 1;
      RationalNumber ratNum = new RationalNumber(first, second);

      int third = rng.nextInt(50) + 1;
      int fourth = rng.nextInt(50) + 1;
      RationalNumber ratNumTwo = new RationalNumber(third, fourth);

      RationalNumber ratAns = new RationalNumber(
        ((first * fourth) - (third * second)),
        (second * fourth)
      );

      if (ratNum.subtract(ratNumTwo).getValue() != ratAns.getValue()) {
        testResults[5] = false;
        break;
      } else if (i == 99) {
        testResults[5] = true;
      }
    }

    printResults(testResults, "Test subtract");
  }

  public static void printResults(boolean[] results, String testName) {
    for (int i = 0; i < results.length; i++) {
      char toShow = 'T';
      if (!results[i]) toShow = 'F';
      System.out.println(testName + " TEST #" + i + ": " + toShow);
    }
  }
}
