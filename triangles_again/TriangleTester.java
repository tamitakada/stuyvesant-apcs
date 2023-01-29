import java.util.Random;
import java.text.DecimalFormat;
import java.math.RoundingMode;


public class TriangleTester {

  public static void main(String[] args) {
    System.out.println(testTriangleCreation());
    System.out.println(testPerimeter());
    System.out.println(testArea());
    System.out.println(testClassify());
    System.out.println(testSetVertex());
  }

  public static Point[] createPoints() {
    Random rng = new Random();
    Point[] toReturn = new Point[3];

    for (int i = 0; i < 3; i++) {
      Point newPoint = new Point(rng.nextDouble(), rng.nextDouble());
      toReturn[i] = newPoint;
    }

    return toReturn;
  }

  public static boolean testTriangleCreation() {
    Triangle one = new Triangle(0, 0, 0, 10, 15, 0);
    Triangle two = new Triangle(-98, 3434, 99.212, -0.11, 122, -0.426);
    Triangle three = new Triangle(11.2, -2.2, -12, 100, -4.4, -900);

    if (!(one.toString().equals("v1(0.0, 0.0) v2(0.0, 10.0) v3(15.0, 0.0)"))) return false;
    if (!(two.toString().equals("v1(-98.0, 3434.0) v2(99.212, -0.11) v3(122.0, -0.426)"))) return false;
    if (!(three.toString().equals("v1(11.2, -2.2) v2(-12.0, 100.0) v3(-4.4, -900.0)"))) return false;

    for (int i = 0; i < 100; i++) {
      Point[] points = createPoints();
      Triangle newTriangle = new Triangle(points[0], points[1], points[2]);

      String result = "";
      result += "v1(" + points[0].getX() + ", " + points[0].getY() + ") ";
      result += "v2(" + points[1].getX() + ", " + points[1].getY() + ") ";
      result += "v3(" + points[2].getX() + ", " + points[2].getY() + ")";

      if (!(newTriangle.toString().equals(result))) return false;
    }

    return true;
  }

  public static boolean testPerimeter() {
    Triangle one = new Triangle(0, 0, 0, 1, 1, 0);
    Triangle two = one;

    if (one.getPerimeter() != (Math.sqrt(2) + 2)) return false;
    if (two.getPerimeter() != (Math.sqrt(2) + 2)) return false;

    for (int i = 0; i < 100; i++) {
      Point[] points = createPoints();
      Triangle newTriangle = new Triangle(points[0], points[1], points[2]);

      double legOne = points[0].distanceTo(points[1]);
      double legTwo = points[0].distanceTo(points[2]);
      double legThree = points[1].distanceTo(points[2]);

      double perimeter = legOne + legTwo + legThree;

      if (newTriangle.getPerimeter() != perimeter) return false;
    }

    return true;
  }

  public static boolean testArea() {
    Triangle one = new Triangle(0, 0, 0, 1, 1, 0);
    Triangle two = one;
    Triangle three = new Triangle(-5, 10, -5, -10, 2, -10);

    Triangle[] tests = new Triangle[] {
      one, two, three
    };

    double[] expected = new double[] {
      0.5, 0.5, 70
    };

    for (int i = 0; i < 3; i++) {
      double area = tests[i].getArea();

      DecimalFormat decForm = new DecimalFormat("#.#");
      decForm.setRoundingMode(RoundingMode.CEILING);
      double formattedArea = Double.parseDouble(decForm.format(area));

      if (formattedArea != expected[i]) return false;
    }

    for (int i = 0; i < 100; i++) {
      Point[] points = createPoints();
      Triangle newTriangle = new Triangle(points[0], points[1], points[2]);

      double legOne = points[0].distanceTo(points[1]);
      double legTwo = points[0].distanceTo(points[2]);
      double legThree = points[1].distanceTo(points[2]);

      double semiperimeter = newTriangle.getPerimeter() / 2;
      double area = Math.sqrt(
        semiperimeter *
        (semiperimeter - legOne) *
        (semiperimeter - legTwo) *
        (semiperimeter - legThree)
      );

      if (newTriangle.getArea() != area) return false;
    }

    return true;
  }

  public static boolean testClassify() {
    Triangle one = new Triangle(0, 0, 0, 1, 1, 0);
    Triangle two = one;
    Triangle three = new Triangle(-5, 10, -5, -10, 2, -10);
    Triangle four = new Triangle(0, 0, 0, 6, 3, (3 + Math.sqrt(3)));

    Triangle[] tests = new Triangle[] {
      one, two, three, four
    };

    String[] expected = new String[] {
      "isosceles", "isosceles", "scalene", "equilateral"
    };

    for (int i = 0; i < 3; i++) {
      if (tests[i].classify() != expected[i]) return false;
    }

    for (int i = 0; i < 100; i++) {
      Point[] points = createPoints();
      Triangle newTriangle = new Triangle(points[0], points[1], points[2]);

      double legOne = points[0].distanceTo(points[1]);
      double legTwo = points[0].distanceTo(points[2]);
      double legThree = points[1].distanceTo(points[2]);

      String result = "scalene";
      if ((legOne == legTwo) && (legOne == legThree)) result = "equilateral";
      else if ((legOne == legTwo) || (legOne == legThree) || (legTwo == legThree)) result = "isosceles";

      if (newTriangle.classify() != result) return false;
    }

    return true;
  }

  public static boolean testSetVertex() {
    Triangle one = new Triangle(0, 0, 0, 10, 15, 0);

    Point newOne = new Point(-5.22, 1.3);
    one.setVertex(0, newOne);
    if (!(one.toString().equals("v1(-5.22, 1.3) v2(0.0, 10.0) v3(15.0, 0.0)"))) return false;

    Point newTwo = new Point(9, 10);
    one.setVertex(1, newTwo);
    if (!(one.toString().equals("v1(-5.22, 1.3) v2(9.0, 10.0) v3(15.0, 0.0)"))) return false;

    Point newThree = new Point(12.444, 90);
    one.setVertex(2, newThree);
    if (!(one.toString().equals("v1(-5.22, 1.3) v2(9.0, 10.0) v3(12.444, 90.0)"))) return false;

    for (int i = 0; i < 100; i++) {
      Point[] points = createPoints();
      Triangle newTriangle = new Triangle(points[0], points[1], points[2]);

      Random rng = new Random();
      double newX = rng.nextDouble();
      double newY = rng.nextDouble();

      Point newPoint = new Point(newX, newY);

      newTriangle.setVertex(1, newPoint);

      String result = "";
      result += "v1(" + points[0].getX() + ", " + points[0].getY() + ") ";
      result += "v2(" + newX + ", " + newY + ") ";
      result += "v3(" + points[2].getX() + ", " + points[2].getY() + ")";

      if (!(newTriangle.toString().equals(result))) return false;
    }

    return true;
  }

}
