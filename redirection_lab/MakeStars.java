import java.util.*;

public class MakeStars {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    while (scan.hasNextLine()) {
      Scanner lineScan = new Scanner(scan.nextLine());
      while (lineScan.hasNext()) {
        String word = lineScan.next();
        String starredUp = "";
        for (int i = 0; i < word.length(); i++) {
          starredUp += "*";
        }
        System.out.print(starredUp + " ");
      }
      System.out.println();
    }
  }
}
