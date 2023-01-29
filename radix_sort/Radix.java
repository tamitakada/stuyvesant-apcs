import java.util.*;


public class Radix {
  public static int nth(int n, int col) {
    String val = ("" + Math.abs(n));
    int index = val.length() - 1 - col;
    return Integer.valueOf(val.substring(index, index + 1));
  }

  public static int length(int n) {
    return String.valueOf(Math.abs(n)).length();
  }

  public static void merge(SortableLinkedList original, SortableLinkedList[] buckets) {
    for (int i = 0; i < buckets.length; i++) {
      original.extend(buckets[i]);
    }
  }

  public static void radixSortSimple(SortableLinkedList data) {
    SortableLinkedList[] buckets = new SortableLinkedList[10];

    for (int i = 0; i < 10; i++) {
      buckets[i] = new SortableLinkedList();
    }

    int maxLen = 1;

    while (data.size() > 0) {
      int item = data.remove(0);
      if (length(item) > maxLen) maxLen = length(item);
      buckets[nth(item, 0)].add(item);
    }

    merge(data, buckets);

    for (int i = 1; i <= maxLen; i++) {
      while (data.size() > 0) {
        int item = data.remove(0);
        if (length(item) <= i) buckets[0].add(item);
        else buckets[nth(item, i)].add(item);
      }

      merge(data, buckets);
    }
  }

  public static void radixSort(SortableLinkedList data) {
    SortableLinkedList[] buckets = new SortableLinkedList[10];
    SortableLinkedList[] negativeBuckets = new SortableLinkedList[10];

    for (int i = 0; i < 10; i++) {
      buckets[i] = new SortableLinkedList();
      negativeBuckets[i] = new SortableLinkedList();
    }

    int maxLen = 1;

    while (data.size() > 0) {
      int item = data.remove(0);
      if (length(item) > maxLen) maxLen = length(item);
      if (item < 0) negativeBuckets[9 - nth(item, 0)].add(item);
      else buckets[nth(item, 0)].add(item);
    }

    merge(data, negativeBuckets);
    merge(data, buckets);

    for (int i = 1; i <= maxLen; i++) {
      while (data.size() > 0) {
        int item = data.remove(0);
        if (length(item) <= i) {
          if (item < 0) negativeBuckets[9].add(item);
          else buckets[0].add(item);
        } else {
          if (item < 0) negativeBuckets[9 - nth(item, i)].add(item);
          else buckets[nth(item, i)].add(item);
        }
      }
      merge(data, negativeBuckets);
      merge(data, buckets);
    }
  }

}
