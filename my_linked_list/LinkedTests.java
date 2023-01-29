import java.util.*;

public class LinkedTests {
  public static void main(String[] args) {
    testAddAndSizeWithGet();
    testAddWithIndex();
    testToString();
    testSet();
    testRemove();
    testExtend();
  }

  public static void testExtend() {
    ArrayList<Boolean> results = new ArrayList<Boolean>();

    MyLinkedList one = new MyLinkedList();

    //TEST 1
    results.add(true);

    for (int i = 0; i <= 10; i += 2) {
      try {
        one.add("" + i);
      } catch (IndexOutOfBoundsException e) {
        results.set(0, false);
        break;
      }
    }

    MyLinkedList two = new MyLinkedList();

    //TEST 2
    results.add(true);

    for (int i = 1; i <= 11; i += 2) {
      try {
        one.add("odds!" + i);
      } catch (IndexOutOfBoundsException e) {
        results.set(0, false);
        break;
      }
    }

    one.extend(two);
    String expected = "[0, 2, 4, 6, 8, 10, odds!1, odds!3, odds!5, odds!7, odds!9, odds!11]";
    //TEST 3
    results.add(one.toString().equals(expected));
    //TEST 4
    results.add(two.size() == 0);
    //TEST 5
    results.add(two.toString().equals("[]"));
    //TEST 6
    results.add(one.size() == 12);

    MyLinkedList three = new MyLinkedList();

    three.extend(one);
    //TEST 7
    results.add(three.toString().equals(expected));
    //TEST 8
    results.add(one.size() == 0);
    //TEST 9
    results.add(one.toString().equals("[]"));
    //TEST 10
    results.add(three.size() == 12);

    two.extend(one);
    //TEST 11
    results.add(two.toString().equals("[]"));
    //TEST 12
    results.add(one.toString().equals("[]"));
    //TEST 13
    results.add(one.size() == 0);
    //TEST 14
    results.add(two.size() == 0);

    try {
      one.add("startNode");
    } catch (IndexOutOfBoundsException e) {
      //TEST 15 (only if fail)
      results.add(false);
    }

    try {
      two.add("startNode2");
    } catch (IndexOutOfBoundsException e) {
      //TEST 15 or 16 (only if fail)
      results.add(false);
    }

    one.extend(two);
    //TEST 15 (provided earlier fails do not exist)
    results.add(one.toString().equals("[startNode, startNode2]"));
    //TEST 16
    results.add(two.toString().equals("[]"));
    //TEST 17
    results.add(one.size() == 2);
    //TEST 18
    results.add(two.size() == 0);

    //TEST 19: RANDOMIZED TESTS
    results.add(true);
    ArrayList<String> failInfo = new ArrayList<String>();

    for (int i = 0; i < 100; i++) {
      String[] arrData = Utils.createRandomStrArr();
      String[] arrDataTwo = Utils.createRandomStrArr();

      String[] merged = new String[arrData.length + arrDataTwo.length];

      MyLinkedList testPOne = new MyLinkedList();
      MyLinkedList testPTwo = new MyLinkedList();

      for (int j = 0; j < arrData.length; j++) {
        merged[j] = arrData[j];
        try {
          testPOne.add(arrData[j]);
        } catch (IndexOutOfBoundsException e) {
          failInfo.add("Copying array - " + Arrays.toString(arrData));
          results.set(results.size() - 1, false);
          break;
        }
      }

      if (failInfo.size() > 0) break;

      for (int j = 0; j < arrDataTwo.length; j++) {
        merged[j + arrData.length] = arrDataTwo[j];
        try {
          testPTwo.add(arrDataTwo[j]);
        } catch (IndexOutOfBoundsException e) {
          failInfo.add("Copying array - " + Arrays.toString(arrDataTwo));
          results.set(results.size() - 1, false);
          break;
        }
      }

      if (failInfo.size() > 0) break;

      testPOne.extend(testPTwo);
      if (!testPOne.toString().equals(Arrays.toString(merged))) {
        failInfo.add("Failed merge toStr");
      } else if (testPOne.size() != merged.length) {
        failInfo.add("Incorrect size of extended list");
      } else if (testPTwo.size() != 0) {
        failInfo.add("Merged list size not zero");
      } else if (!testPTwo.toString().equals("[]")) {
        failInfo.add("Failed to clear merged list");
      }

      if (failInfo.size() > 0) {
        results.set(results.size() - 1, false);
        break;
      }
    }

    Utils.showResults(results, "Test extend");
    Utils.showRandomResults(failInfo);
  }

  public static void testRemove() {
    ArrayList<Boolean> results = new ArrayList<Boolean>();

    MyLinkedList one = new MyLinkedList();

    for (int i = 0; i <= 20; i += 2) {
      try {
        one.add("" + i);
      } catch (IndexOutOfBoundsException e) {
        results.add(false);
        break;
      }
    }

    for (int i = 0; i < 5; i++) {
      try {
        one.set(i, "" + i);
      } catch (IndexOutOfBoundsException e) {
        results.add(false);
        break;
      }
    }

    results.add(one.toString().equals("[0, 1, 2, 3, 4, 10, 12, 14, 16, 18, 20]"));
    String[] expected = {"0", "1", "2", "3", "4", "10", "12", "14", "16", "18", "20"};

    for (int i = one.size() - 1; i >= 0; i--) {
      try {
        results.add(one.remove(i).equals(expected[i]));
      } catch (IndexOutOfBoundsException e) {
        results.add(false);
      }
    }

    results.add(one.toString().equals("[]"));

    try {
      one.remove(0);
      results.add(false);
    } catch (IndexOutOfBoundsException e) {
      results.add(true);
    }

    results.add(true);
    ArrayList<String> failInfo = new ArrayList<String>();

    for (int i = 0; i < 100; i++) {
      String[] arrData = Utils.createRandomStrArr();
      while (arrData.length == 0) {
        arrData = Utils.createRandomStrArr();
      }

      ArrayList<String> data = new ArrayList<String>(arrData.length);

      for (int q = 0; q < arrData.length; q++) {
        data.add(arrData[q]);
      }

      MyLinkedList test = new MyLinkedList();

      for (int j = 0; j < data.size(); j++) {
        try {
          test.add(arrData[j]);
        } catch (IndexOutOfBoundsException e) {
          failInfo.add("Copying array - " + data);
          results.set(results.size() - 1, false);
          break;
        }
      }

      if (failInfo.size() > 0) break;

      Random rng = new Random();
      int randomIndex = rng.nextInt(data.size());

      try {
        String removed = test.remove(randomIndex);
        if (!removed.equals(data.remove(randomIndex))) {
          results.set(results.size() - 1, false);
          failInfo.add("Return from remove - index - " + randomIndex + " from " + test);
        }
      } catch (IndexOutOfBoundsException e) {
        failInfo.add("Removing item - " + randomIndex + " from " + test);
        results.set(results.size() - 1, false);
      }

      if (failInfo.size() > 0) break;

      if (!test.toString().equals(data.toString())) {
        failInfo.add("Str form - " + randomIndex + " test-" + test + "\n\nORIGINAL\n\n" + Arrays.toString(arrData) + "\n\nLIST FORM\n\n" + data);
        results.set(results.size() - 1, false);
      }

      if (failInfo.size() > 0) break;
    }

    Utils.showResults(results, "Test remove");
    Utils.showRandomResults(failInfo);
  }

  public static void testAddAndSizeWithGet() {
    ArrayList<Boolean> results = new ArrayList<Boolean>();

    MyLinkedList one = new MyLinkedList();

    results.add(one.size() == 0);
    results.add(one.add("Hello world!!"));
    results.add(one.size() == 1);

    try {
      String res = one.get(0);
      results.add(res.equals("Hello world!!"));
    } catch (IndexOutOfBoundsException e) {
      results.add(false);
    }

    results.add(one.add("##hello"));
    results.add(one.size() == 2);

    try {
      String res = one.get(1);
      results.add(res.equals("##hello"));
    } catch (IndexOutOfBoundsException e) {
      results.add(false);
    }

    results.add(one.add("Hello world!!"));

    String[] linkedContents = {"Hello world!!", "##hello", "Hello world!!"};

    for (int i = 0; i < 3; i++) {
      try {
        String res = one.get(i);
        results.add(res.equals(linkedContents[i]));
      } catch (IndexOutOfBoundsException e) {
        results.add(false);
      }
    }

    Utils.showResults(results, "Test add/size/get");
  }

  public static void testAddWithIndex() {
    ArrayList<Boolean> results = new ArrayList<Boolean>();

    MyLinkedList one = new MyLinkedList();
    String[] oneData = {"dogs", "?cats?", "Guinea pigs", " RATS! "};

    for (int i = 0; i < oneData.length; i++) {
      try {
        results.add(one.add(i, oneData[i]));
      } catch (IndexOutOfBoundsException e) {
        results.add(false);
      }
    }

    for (int i = 0; i < oneData.length; i++) {
      try {
        results.add(one.get(i).equals(oneData[i]));
      } catch (IndexOutOfBoundsException e) {
        results.add(false);
      }
    }

    try {
      results.add(one.add(3, "mice"));
    } catch (IndexOutOfBoundsException e) {
      results.add(false);
    }

    try {
      results.add(one.add(2, "Snakes"));
    } catch (IndexOutOfBoundsException e) {
      results.add(false);
    }

    try {
      results.add(one.add(0, "dogs"));
    } catch (IndexOutOfBoundsException e) {
      results.add(false);
    }

    oneData = new String[]{"dogs", "dogs", "?cats?", "Snakes", "Guinea pigs", "mice", " RATS! "};

    for (int i = 0; i < oneData.length; i++) {
      boolean res = true;
      try {
        res = one.get(i).equals(oneData[i]);
      } catch (IndexOutOfBoundsException e) {
        res = false;
      }

      if (!res) {
        results.add(false);
        break;
      } else if (i == oneData.length - 1) {
        results.add(true);
      }
    }

    try {
      one.add(-2, "ahasda");
      results.add(false);
    } catch (IndexOutOfBoundsException e) {
      results.add(true);
    }

    try {
      one.add(19, "Yay");
      results.add(false);
    } catch (IndexOutOfBoundsException e) {
      results.add(true);
    }

    Utils.showResults(results, "Test add w/ index");
  }

  public static void testToString() {
    ArrayList<Boolean> results = new ArrayList<Boolean>();

    MyLinkedList one = new MyLinkedList();
    String[] oneData = {"Fusili", "penne", "farfalle", "linguini"};

    results.add(true);

    for (int i = 0; i < oneData.length; i++) {
      try {
        one.add(oneData[i]);
      } catch (IndexOutOfBoundsException e) {
        results.set(0, false);
        break;
      }
    }

    results.add(one.toString().equals("[Fusili, penne, farfalle, linguini]"));

    try {
      results.add(one.add(1, "ziti"));
    } catch (IndexOutOfBoundsException e) {
      results.add(false);
    }

    try {
      results.add(one.add(3, "rigatoni"));
    } catch (IndexOutOfBoundsException e) {
      results.add(false);
    }

    results.add(one.toString().equals("[Fusili, ziti, penne, rigatoni, farfalle, linguini]"));

    MyLinkedList two = new MyLinkedList();
    results.add(two.toString().equals("[]"));

    two.add("pasta!");
    results.add(two.toString().equals("[pasta!]"));

    ArrayList<String> failInfo = new ArrayList<String>();

    for (int i = 0; i < 100; i++) {
      String[] test = Utils.createRandomStrArr();
      MyLinkedList testList = new MyLinkedList();

      for (int j = 0; j < test.length; j++) {
        try {
          testList.add(test[j]);
        } catch (IndexOutOfBoundsException e) {
          failInfo.add("Array - " + Arrays.toString(test));
          break;
        }
      }

      if (failInfo.size() > 0) {
        results.add(false);
        break;
      } else if (!Arrays.toString(test).equals(testList.toString())) {
        failInfo.add("To String fail -" + Arrays.toString(test));
        results.add(false);
        break;
      } else if (i == 99) results.add(true);
    }

    Utils.showResults(results, "Test to string");
    Utils.showRandomResults(failInfo);
  }

  public static void testSet() {
    ArrayList<Boolean> results = new ArrayList<Boolean>();

    MyLinkedList one = new MyLinkedList();
    String[] oneData = {"Fusili", "penne", "farfalle", "linguini"};

    results.add(true);

    for (int i = 0; i < oneData.length; i++) {
      try {
        one.add(oneData[i]);
      } catch (IndexOutOfBoundsException e) {
        results.set(0, false);
        break;
      }
    }

    try {
      results.add(one.set(1, "ziti").equals("penne"));
    } catch (IndexOutOfBoundsException e) {
      results.add(false);
    }

    try {
      results.add(one.set(3, "rigatoni").equals("linguini"));
    } catch (IndexOutOfBoundsException e) {
      results.add(false);
    }

    try {
      one.set(10, "tagliatelle");
      results.add(false);
    } catch (IndexOutOfBoundsException e) {
      results.add(true);
    }

    try {
      one.set(-1, "spaghetti");
      results.add(false);
    } catch (IndexOutOfBoundsException e) {
      results.add(true);
    }

    try {
      results.add(one.set(4, "angel hair").equals(""));
    } catch (IndexOutOfBoundsException e) {
      results.add(false);
    }

    results.add(one.toString().equals("[Fusili, ziti, farfalle, rigatoni, angel hair]"));

    MyLinkedList two = new MyLinkedList();

    try {
      two.set(1, "marinara");
      results.add(false);
    } catch (IndexOutOfBoundsException e) {
      results.add(true);
    }

    try {
      results.add(two.set(0, "lasagna").equals(""));
    } catch (IndexOutOfBoundsException e) {
      results.add(false);
    }

    results.add(two.toString().equals("[lasagna]"));

    Utils.showResults(results, "Test set");
  }

}
