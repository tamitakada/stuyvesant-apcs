public class Triangle {

  private Point v1, v2, v3;

  public Triangle(Point a, Point b, Point c) {
    v1 = a;
    v2 = b;
    v3 = c;
  }

  public Triangle(double x1, double y1,double x2, double y2,double x3, double y3) {
    Point a = new Point(x1, y1);
    Point b = new Point(x2, y2);
    Point c = new Point(x3, y3);

    v1 = a;
    v2 = b;
    v3 = c;
  }

  public double getPerimeter() {
    double legOne = v1.distanceTo(v2);
    double legTwo = v1.distanceTo(v3);
    double legThree = v2.distanceTo(v3);

    return (legOne + legTwo + legThree);
  }

  public double getArea() {
    double legOne = v1.distanceTo(v2);
    double legTwo = v1.distanceTo(v3);
    double legThree = v2.distanceTo(v3);

    double semiperimeter = getPerimeter() / 2;
    double area = Math.sqrt(
      semiperimeter *
      (semiperimeter - legOne) *
      (semiperimeter - legTwo) *
      (semiperimeter - legThree)
    );
    return area;
  }

  public String classify() {
    double legOne = v1.distanceTo(v2);
    double legTwo = v1.distanceTo(v3);
    double legThree = v2.distanceTo(v3);

    if ((legOne == legTwo) && (legOne == legThree)) return "equilateral";
    else if ((legOne == legTwo) || (legOne == legThree) || (legTwo == legThree)) return "isosceles";
    else return "scalene";
  }

  public String toString() {
    String toReturn = "";
    toReturn += "v1(" + v1.getX() + ", " + v1.getY() + ") ";
    toReturn += "v2(" + v2.getX() + ", " + v2.getY() + ") ";
    toReturn += "v3(" + v3.getX() + ", " + v3.getY() + ")";

    return toReturn;
  }

  public void setVertex(int index, Point newP) {
    switch (index) {
      case 0:
        v1 = newP;
        break;
      case 1:
        v2 = newP;
        break;
      case 2:
        v3 = newP;
        break;
    };
  }

}
