import java.util.*;

public class PigTests {

  public static void main(String[] args) {
    testPigSimple();
    testPigRegular();
    testPigBest();
  }

  public static void testPigSimple() {
    ArrayList<Boolean> results = new ArrayList<Boolean>();

    String one = "catscatscats";
    results.add(PigLatin.pigLatinSimple(one).equals("atscatscatscay"));

    one = "aaron";
    results.add(PigLatin.pigLatinSimple(one).equals("aaronhay"));

    one = "pie";
    results.add(PigLatin.pigLatinSimple(one).equals("iepay"));

    one = "elephants hm ";
    results.add(PigLatin.pigLatinSimple(one).equals("elephants hm hay"));

    one = "david";
    results.add(PigLatin.pigLatinSimple(one).equals("avidday"));

    one = "mock";
    results.add(PigLatin.pigLatinSimple(one).equals("ockmay"));

    showResults(results, "Test simple pig latin");
  }

  public static void testPigRegular() {
    ArrayList<Boolean> results = new ArrayList<Boolean>();

    String one = "catscatscats";
    results.add(PigLatin.pigLatin(one).equals("atscatscatscay"));

    one = "aaron";
    results.add(PigLatin.pigLatin(one).equals("aaronhay"));

    one = "pie";
    results.add(PigLatin.pigLatin(one).equals("iepay"));

    one = "elephants hm ";
    results.add(PigLatin.pigLatin(one).equals("elephants hm hay"));

    one = "david";
    results.add(PigLatin.pigLatin(one).equals("avidday"));

    one = "mock";
    results.add(PigLatin.pigLatin(one).equals("ockmay"));

    one = "the";
    results.add(PigLatin.pigLatin(one).equals("ethay"));

    one = "check";
    results.add(PigLatin.pigLatin(one).equals("eckchay"));

    one = "skee";
    results.add(PigLatin.pigLatin(one).equals("eeskay"));

    one = "emu";
    results.add(PigLatin.pigLatin(one).equals("emuhay"));

    one = "grade";
    results.add(PigLatin.pigLatin(one).equals("adegray"));

    one = "m";
    results.add(PigLatin.pigLatin(one).equals("may"));

    showResults(results, "Test pig latin");
  }

  public static void testPigBest() {
    ArrayList<Boolean> results = new ArrayList<Boolean>();

    String one = "**##$%catsca88**tscats";
    results.add(PigLatin.pigLatinBest(one).equals("**##$%catsca88**tscats"));

    one = "o0000o99";
    results.add(PigLatin.pigLatinBest(one).equals("o0000o9hay9"));

    one = "5m";
    results.add(PigLatin.pigLatinBest(one).equals("5m"));

    one = "x";
    results.add(PigLatin.pigLatinBest(one).equals("xay"));

    one = "HAYisGood?!";
    results.add(PigLatin.pigLatinBest(one).equals("AYisGood?Hay!"));

    one = "Under construction!";
    results.add(PigLatin.pigLatinBest(one).equals("Under constructionhay!"));

    showResults(results, "Test best pig latin");
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
