package edu.grinnell.csc207.sorting;

import java.util.Comparator;
import java.util.Random;

/**
 * A sorter that implements quicksort.
 *
 * @param <T>
 *   The type of elements sorted.
 *
 * @author Samuel A. Rebelsky
 * @author Slok
 */
public class Quicksorter<T> implements Sorter<T> {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The way in which elements are ordered.
   */
  private final Comparator<? super T> order;
  /**
   * Random number generator for selecting pivot elements.
   */
  private final Random random = new Random();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter using a particular comparator.
   *
   * @param comparator
   *   The order in which elements in the array should be ordered after sorting.
   */
  public Quicksorter(Comparator<? super T> comparator) {
    this.order = comparator;
  } // Quicksorter(Comparator)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Sort an array in place using quicksort.
   *
   * @param values
   *   an array to sort.
   */
  @Override
  public void sort(T[] values) {
    quicksort(values, 0, values.length - 1);
  } // sort(T[])

  /**
   * Recursive quicksort implementation.
   *
   * @param array
   *   the array to sort.
   * @param low
   *   the starting index.
   * @param high
   *   the ending index.
   */
  private void quicksort(T[] array, int low, int high) {
    if (low < high) {
      int pivotIndex = partition(array, low, high);
      quicksort(array, low, pivotIndex - 1);
      quicksort(array, pivotIndex, high);
    } // if
  } // quicksort(T[], int, int)

  /**
   * Partitions the array around a pivot.
   *
   * @param array
   *   the array to partition.
   * @param low
   *   the starting index for the partition.
   * @param high
   *   the ending index for the partition.
   * @return
   *   the index where the pivot element is placed.
   */
  private int partition(T[] array, int low, int high) {
    T pivot = array[low + random.nextInt(high - low + 1)];
    int left = low;
    int right = high;
    while (left <= right) { // while loop
      while (left <= right && order.compare(array[left], pivot) < 0) { // while loop
        left++;
      } // while loop ends
      while (left <= right && order.compare(array[right], pivot) > 0) { // while loop
        right--;
      } // while loop ends
      if (left <= right) {
        swap(array, left, right);
        left++;
        right--;
      } // if
    } // while loop ends
    return left;
  } // partition(T[], int, int)

  /**
   * Swaps two elements in the array.
   *
   * @param array
   *   the array containing the elements.
   * @param i
   *   the index of the first element.
   * @param j
   *   the index of the second element.
   */
  private void swap(T[] array, int i, int j) {
    T temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  } // swap(T[], int, int)
} // class Quicksorter
