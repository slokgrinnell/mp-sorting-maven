package edu.grinnell.csc207.sorting;

import edu.grinnell.csc207.util.ArrayUtils;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * Tests of Sorter objects. Please do not use this class directly.
 * Rather, you should subclass it and initialize stringSorter and
 * intSorter in a static @BeforeAll method.
 *
 * @author Slok Rajbhandari
 * @author Samuel A. Rebelsky
 */
public class TestSorter {

  // +---------+-----------------------------------------------------
  // | Globals |
  // +---------+

  /**
   * The sorter we use to sort arrays of strings.
   */
  static Sorter<String> stringSorter = null;

  /**
   * The sorter we use to sort arrays of integers.
   */
  static Sorter<Integer> intSorter = null;

  // +-----------+---------------------------------------------------
  // | Utilities |
  // +-----------+

  /**
   * Given a sorted array and a permutation of the array, sort the
   * permutation and assert that it equals the original.
   *
   * @param <T>
   *   The type of values in the array.
   * @param sorted
   *   The sorted array.
   * @param perm
   *   The permuted sorted array.
   * @param sorter
   *   The thing to use to sort.
   */
  public <T> void assertSorts(T[] sorted, T[] perm, Sorter<? super T> sorter) {
    T[] tmp = perm.clone();
    sorter.sort(perm);
    assertArrayEquals(sorted, perm,
      () -> String.format("sort(%s) yields %s rather than %s",
          Arrays.toString(tmp), 
          Arrays.toString(perm), 
          Arrays.toString(sorted)));
  } // assertSorts

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  /**
   * A fake test. I've forgotten why I've included this here. Probably
   * just to make sure that some test succeeds.
   */
  @Test
  public void fakeTest() {
    assertTrue(true);
  } // fakeTest()

  /**
   * Ensure that an array that is already in order gets sorted correctly.
   */
  @Test
  public void orderedStringTest() {
    if (null == stringSorter) {
      return;
    } // if
    String[] original = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    String[] expected = original.clone();
    assertSorts(expected, original, stringSorter);
  } // orderedStringTest

  /**
   * Ensure that an array that is ordered backwards gets sorted correctly.
   */
  @Test
  public void reverseOrderedStringTest() {
    if (null == stringSorter) {
      return;
    } // if
    String[] original = { "foxtrot", "delta", "charlie", "bravo", "alpha" };
    String[] expected = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    assertSorts(expected, original, stringSorter);
  } // reverseOrderedStringTest

  /**
   * Ensure that a randomly permuted version of a moderate-sized
   * array sorts correctly.
   */
  @Test 
  public void permutedIntegersTest() { 
    int SIZE = 100; 
    if (null == intSorter) { 
      return; 
    } // if
    Integer[] original = new Integer[SIZE];
    for (int i = 0; i < SIZE; i++) {
      original[i] = i;
    } // for
    Integer[] expected = original.clone();
    ArrayUtils.permute(original);
    assertSorts(expected, original, intSorter);
  } // permutedIntegersTest

  /**
   * Ensure that sorting an empty array works as expected.
   */
  @Test
  public void emptyArrayTest() {
    if (null == intSorter) {
      return;
    } // if
    Integer[] original = {};
    Integer[] expected = {};
    assertSorts(expected, original, intSorter);
  } // emptyArrayTest

  /**
   * Ensure that sorting a single-element array works as expected.
   */
  @Test
  public void singleElementArrayTest() {
    if (null == intSorter) {
      return;
    } // if
    Integer[] original = {42};
    Integer[] expected = {42};
    assertSorts(expected, original, intSorter);
  } // singleElementArrayTest

  /**
   * Ensure that an array with duplicate elements sorts correctly.
   */
  @Test
  public void arrayWithDuplicatesTest() {
    if (null == intSorter) {
      return;
    } // if
    Integer[] original = {5, 3, 8, 3, 9, 1, 1, 8};
    Integer[] expected = {1, 1, 3, 3, 5, 8, 8, 9};
    assertSorts(expected, original, intSorter);
  } // arrayWithDuplicatesTest

  /**
   * Ensure that an array with negative numbers sorts correctly.
   */
  @Test
  public void arrayWithNegativeNumbersTest() {
    if (null == intSorter) {
      return;
    } // if
    Integer[] original = {-5, -1, -3, -4, -2};
    Integer[] expected = {-5, -4, -3, -2, -1};
    assertSorts(expected, original, intSorter);
  } // arrayWithNegativeNumbersTest

  /**
   * Ensure that an array with alternating high and low values sorts correctly.
   */
  @Test
  public void alternatingHighLowValuesTest() {
    if (null == intSorter) {
      return;
    } // if
    Integer[] original = {100, 1, 90, 2, 80, 3, 70, 4, 60, 5};
    Integer[] expected = {1, 2, 3, 4, 5, 60, 70, 80, 90, 100};
    assertSorts(expected, original, intSorter);
  } // alternatingHighLowValuesTest

  /**
   * Ensure that an array with all elements equal sorts correctly.
   */
  @Test
  public void arrayWithAllEqualElementsTest() {
    if (null == intSorter) {
      return;
    } // if
    Integer[] original = {42, 42, 42, 42, 42};
    Integer[] expected = {42, 42, 42, 42, 42};
    assertSorts(expected, original, intSorter);
  } // arrayWithAllEqualElementsTest

  /**
   * Ensure that an array with very large numbers sorts correctly.
   */
  @Test
  public void arrayWithLargeNumbersTest() {
    if (null == intSorter) {
      return;
    } // if
    Integer[] original = {Integer.MAX_VALUE, Integer.MIN_VALUE, 0, 999999999, -999999999};
    Integer[] expected = {Integer.MIN_VALUE, -999999999, 0, 999999999, Integer.MAX_VALUE};
    assertSorts(expected, original, intSorter);
  } // arrayWithLargeNumbersTest

  /**
   * Ensure that an array with both negative and positive numbers sorts correctly.
   */
  @Test
  public void arrayWithMixedPositiveNegativeTest() {
    if (null == intSorter) {
      return;
    } // if
    Integer[] original = {-10, 0, 5, -3, 2, -8, 7, -1};
    Integer[] expected = {-10, -8, -3, -1, 0, 2, 5, 7};
    assertSorts(expected, original, intSorter);
  } // arrayWithMixedPositiveNegativeTest

    /**
   * Ensure that RajbhandariSlokSort correctly handles an array that is already sorted.
   */
  @Test
  public void testAlreadySortedArrayRajbhandariSlokSort() {
    if (null == intSorter || !(intSorter instanceof RajbhandariSlokSort)) {
      return;
    } // if
    Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8};
    Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
    assertSorts(expected, array, intSorter);
  } // testAlreadySortedArrayRajbhandariSlokSort

  /**
   * Ensure that RajbhandariSlokSort correctly handles an array that is reverse sorted.
   */
  @Test
  public void testReverseSortedArrayRajbhandariSlokSort() {
    if (null == intSorter || !(intSorter instanceof RajbhandariSlokSort)) {
      return;
    } // if
    Integer[] array = {9, 7, 5, 3, 1};
    Integer[] expected = {1, 3, 5, 7, 9};
    assertSorts(expected, array, intSorter);
  } // testReverseSortedArrayRajbhandariSlokSort

  /**
   * Ensure that RajbhandariSlokSort correctly handles a randomly ordered array.
   */
  @Test
  public void testRandomArrayRajbhandariSlokSort() {
    if (null == intSorter || !(intSorter instanceof RajbhandariSlokSort)) {
      return;
    } // if
    Integer[] array = {21, 87, 17, 78, 47, 48, 96, 91, 41, 37};
    Integer[] expected = {17, 21, 37, 41, 47, 48, 78, 87, 91, 96};
    assertSorts(expected, array, intSorter);
  } // testRandomArrayRajbhandariSlokSort

  /**
   * Ensure that RajbhandariSlokSort correctly handles an array with duplicate values.
   */
  @Test
  public void testArrayWithDuplicatesRajbhandariSlokSort() {
    if (null == intSorter || !(intSorter instanceof RajbhandariSlokSort)) {
      return;
    } // if
    Integer[] array = {5, 3, 8, 3, 9, 1, 1, 8};
    Integer[] expected = {1, 1, 3, 3, 5, 8, 8, 9};
    assertSorts(expected, array, intSorter);
  } // testArrayWithDuplicatesRajbhandariSlokSort

} // class TestSorter
