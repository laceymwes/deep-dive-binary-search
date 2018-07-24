package edu.cnm.deepdive;

import static edu.cnm.deepdive.Search.linearSearch;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {

  public static void main(String[] args) {
    Random rng = new Random();
    int[] needles = IntStream.generate(() -> rng.nextInt()).limit(1_000).toArray();
    int[] haystack = IntStream.generate(() -> rng.nextInt()).limit(10_000).toArray();
    long start = System.currentTimeMillis();
    for (int needle : needles) {
      linearSearch(haystack, needle);
    }
    System.out.printf("Linear search time for %,d needles in a haystack of size %,d = %.2f%n",
        needles.length, haystack.length, (System.currentTimeMillis() - start) / 1000d);
    start = System.currentTimeMillis();
    Arrays.sort(haystack);
    System.out.printf("Sort time for %,d needles in a haystack of size %,d = %.2f%n",
        needles.length, haystack.length, (System.currentTimeMillis() - start) / 1000d);
    start = System.currentTimeMillis();
    for (int needle : needles) {
      Search.binarySearch(haystack, needle);
    }
    System.out.printf("Binary Search time for %,d needles in a haystack of size %,d = %.2f%n",
        needles.length, haystack.length, (System.currentTimeMillis() - start) / 1000d);
  }
}
