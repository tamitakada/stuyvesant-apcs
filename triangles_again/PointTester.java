import java.util.Random;


public class PointTester {

  public static void main(String[] args) {
    System.out.println(testPointCreation());
    System.out.println(testDistance());
    System.out.println(testEquals());
  }

  public static Point createPoint() {
    Random rng = new Random();
    Point toReturn = new Point(rng.nextDouble(), rng.nextDouble());
    return toReturn;
  }

  public static boolean testPointCreation() {
    Point one = new Point(1, 2);
    Point two = new Point(0, 0);
    Point three = new Point(-98, -24);
    Point four = new Point(-10, 7);
    Point five = four;

    Point[] points = new Point[] {
      one, two, three, four, five
    };

    int[] xVals = new int[] {
      1, 0, -98, -10, -10
    };

    int[] yVals = new int[] {
      2, 0, -24, 7, 7
    };

    for (int i = 0; i < 5; i++) {
      if ((points[i].getX() != xVals[i]) ||
          (points[i].getY() != yVals[i])) return false;
    }

    for (int i = 0; i < 100; i++) {
      Random rng = new Random();
      int x = rng.nextInt();
      int y = rng.nextInt();
      Point newPoint = new Point(x, y);

      if ((newPoint.getX() != x) || (newPoint.getY() != y)) return false;
    }

    return true;
  }

  public static boolean testDistance() {
    Point one = new Point(0, 0);
    Point two = new Point(99, 0);
    Point three = new Point(0, -25);
    Point four = new Point(-10, 7);
    Point five = four;

    Point[] points = new Point[] {
      two, three, four
    };

    double[] expected = new double[] {
      99, 25, Math.sqrt(149)
    };

    for (int i = 0; i < 3; i++) {
      if (one.distanceTo(points[i]) != expected[i]) return false;
    }

    if (four.distanceTo(five) != 0) return false;

    for (int i = 0; i < 100; i++) {
      Point newOne = createPoint();
      Point newTwo = createPoint();

      double result = Math.sqrt(
        (Math.pow(newOne.getX() - newTwo.getX(), 2)) +
        (Math.pow(newOne.getY() - newTwo.getY(), 2))
      );

      if (newOne.distanceTo(newTwo) != result) return false;
    }

    return true;
  }

  public static boolean testEquals() {
    Point one = new Point(0, 0);
    Point two = new Point(99, 0);
    Point three = new Point(0, -25);
    Point four = new Point(-10, 7);
    Point five = one;
    Point six = new Point(0, 0);

    Point[] points = new Point[] {
      one, two, three, four, five, six
    };

    boolean[] expected = new boolean[] {
      true, false, false, false, true, true
    };

    for (int i = 0; i < 6; i++) {
      if (one.equals(points[i]) != expected[i]) return false;
    }

    return true;
  }

}
