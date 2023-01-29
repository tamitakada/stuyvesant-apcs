import java.util.Random;
import java.util.ArrayList;


public class Tests {

  public static void main(String[] args) {
  //  testEquals();
//    testMultiply();
  //  testDivide();
    testAdd();
    //testSubtract();
  }

  public static void testAdd() {
    ArrayList<Boolean> results = new ArrayList<Boolean>();

    RationalNumber one = new RationalNumber(11, 55);
    RationalNumber two = new RationalNumber(1080, 45);

    RationalNumber answer = one.add(two);

    results.add(answer.getNumerator() == 121);
    results.add(answer.getDenominator() == 5);
    results.add(answer.getValue() == 24.2);

    one = new RationalNumber(-27, 13);
    two = new RationalNumber(435, 27);

    answer = one.add(two);

    results.add(answer.getNumerator() == 1642);
    results.add(answer.getDenominator() == 117);

    one = new RationalNumber(-480, -480);
    two = new RationalNumber(24, 48);

    answer = one.add(two);

    results.add(answer.getNumerator() == 3);
    results.add(answer.getDenominator() == 2);
    results.add(answer.getValue() == 1.5);

    TestUtils.showResults(results, "Test Add");
  }



}
