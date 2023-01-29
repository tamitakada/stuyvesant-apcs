import java.util.*;

public class PigLatin {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    while (scan.hasNextLine()) {
      Scanner lineScan = new Scanner(scan.nextLine());
      while (lineScan.hasNext()) {
        String word = lineScan.next();
        System.out.print(pigLatinBest(word) + " ");
      }
      System.out.println();
    }
  }

  public static String pigLatinSimple(String s) {
    String[] vows = {"a", "e", "i", "o", "u"};
    ArrayList<String> vowels = convertArrToList(vows);
    if (vowels.contains(s.substring(0, 1).toLowerCase())) return s + "hay";
    return s.substring(1, s.length()) + s.charAt(0) + "ay";
  }

  public static String pigLatin(String s) {
    String[] digs = {"bl", "br", "ch", "ck", "cl", "cr", "dr", "fl", "fr", "gh",
    "gl", "gr", "ng", "ph", "pl", "pr", "qu", "sc", "sh", "sk", "sl", "sm",
    "sn", "sp", "st", "sw", "th", "tr", "tw", "wh", "wr"};
    ArrayList<String> digraphs = convertArrToList(digs);

    if (s.length() > 1 && digraphs.contains(s.substring(0, 2).toLowerCase())) {
      return s.substring(2, s.length()) + s.substring(0, 2) + "ay";
    }
    return pigLatinSimple(s);
  }

  public static String pigLatinBest(String s){
    if (!Character.isLetter(s.charAt(0))) return s;
    if (!Character.isLetter(s.charAt(s.length() - 1))) {
      return pigLatin(s.substring(0, s.length() - 1)) + s.charAt(s.length() - 1);
    }
    return pigLatin(s);
  }

  public static ArrayList<Character> convertArrToList(char[] data) {
    ArrayList<Character> toreturn = new ArrayList<Character>();
    for (int i = 0; i < data.length; i++) {
      toreturn.add(data[i]);
    }
    return toreturn;
  }

  public static ArrayList<String> convertArrToList(String[] data) {
    ArrayList<String> toreturn = new ArrayList<String>();
    for (int i = 0; i < data.length; i++) {
      toreturn.add(data[i]);
    }
    return toreturn;
  }
}
