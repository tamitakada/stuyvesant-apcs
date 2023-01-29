public class Demo{

  public static void main(String[]args){
    System.out.println(testRemDuplicates());
    System.out.println(testOverlap());
    System.out.println(testEquals());
    System.out.println(testZip());
  }

  public static boolean testRemDuplicates() {
    SuperArray one = new SuperArray();
    String[] oneData = new String[] {
      "one", "two", "two", "aksjdasd ", " two", "two"
    };
    one = addData(oneData);

    removeDuplicates(one);
    if (!one.toString().equals("[one, two, aksjdasd ,  two]")) return false;

    one.add("one");
    removeDuplicates(one);
    if (!one.toString().equals("[one, two, aksjdasd ,  two]")) return false;

    return true;
  }

  public static boolean testOverlap() {
    String[] oneData = new String[] {
      "one", "two", " 3 ", "FOUR", "f i v e", "6.0000 0"
    };
    SuperArray one = addData(oneData);

    String[] twoData = new String[] {
      "one", "2", "THREEEE", "f i v e", " 3 "
    };
    SuperArray two = addData(twoData);

    SuperArray overlap = findOverlap(one, two);
    if (!overlap.toString().equals("[one, f i v e,  3 ]")) return false;

    return true;
  }

  public static boolean testEquals() {
    String[] oneData = new String[] {
      "one", "two", " 3 ", "FOUR", "f i v e", "6.0000 0"
    };
    SuperArray one = addData(oneData);

    String[] twoData = new String[] {
      "one", "2", "THREEEE", "f i v e", " 3 "
    };
    SuperArray two = addData(twoData);

    if (one.equals(two)) return false;

    one.clear();
    two.clear();

    oneData = new String[] {
      "one", "two", "3", "4.00", "FI VE", ""
    };

    twoData = new String[] {
      "one", "two", "3", "4.00", "FI VE", ""
    };

    one = addData(oneData);
    two = addData(twoData);

    if (!one.equals(two)) return false;

    SuperArray three = new SuperArray();
    SuperArray four = new SuperArray(100);

    if (two.equals(three)) return false;
    if (two.equals(four)) return false;
    if (!three.equals(four)) return false;

    return true;
  }

  public static boolean testZip() {
    SuperArray a = new SuperArray();
    SuperArray b = new SuperArray(100);

    if (!zip(a, b).toString().equals("[]")) return false;

    String[] aData = new String[] {
      " 1", "TWO!", "", "11", " th r ee", "TWO!"
    };
    a = addData(aData);

    String[] bData = new String[] {
      "one", "two", "threeeeee", "44444"
    };
    b = addData(bData);

    if (!zip(a, b).toString().equals(
      "[ 1, one, TWO!, two, , threeeeee, 11, 44444,  th r ee, TWO!]")) return false;

    aData = new String[] {
      "a","b","c","d","e","f"
    };
    a = addData(aData);

    bData = new String[] {
      "0","1","2","3"
    };
    b = addData(bData);

    if (!zip(a, b).toString().equals("[a, 0, b, 1, c, 2, d, 3, e, f]")) return false;

    b = new SuperArray();
    if (!zip(a, b).toString().equals(a.toString())) return false;

    return true;
  }

  public static void removeDuplicates(SuperArray s) {
    for (int i = s.size() - 1; i >= 0; i--) {
      if (s.indexOf(s.get(i)) != i) s.remove(i);
    }
  }

  public static SuperArray findOverlap(SuperArray a, SuperArray b) {
    SuperArray cloneA = a;
    SuperArray cloneB = b;
    removeDuplicates(cloneA);
    removeDuplicates(cloneB);

    SuperArray larger = cloneA;
    SuperArray smaller = cloneB;
    if (cloneB.size() > cloneA.size()) {
      larger = cloneB;
      smaller = cloneA;
    }

    SuperArray overlap = new SuperArray(smaller.size());

    for (int i = 0; i < smaller.size(); i++) {
      if (larger.contains(smaller.get(i))) {
        overlap.add(smaller.get(i));
      }
    }

    return overlap;
  }

  public static SuperArray zip(SuperArray a, SuperArray b){
    SuperArray larger = a;
    SuperArray smaller = b;
    if (b.size() > a.size()) {
      larger = b;
      smaller = a;
    }

    SuperArray merged = new SuperArray(larger.size());

    for (int i = 0; i < larger.size(); i++) {
      if (i < a.size()) merged.add(a.get(i));
      if (i < b.size()) merged.add(b.get(i));
    }

    return merged;
  }

  public static SuperArray addData(String[] data) {
    SuperArray newArr = new SuperArray(data.length);
    for (int i = 0; i < data.length; i++) {
      newArr.add(data[i]);
    }
    return newArr;
  }

}
