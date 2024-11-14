package edu.grinnell.csc207.sorting;

import java.util.Comparator;

/**
 * A custom hybrid sorting algorithm that adapts based on input characteristics.
 *
 * This algorithm combines Merge Sort for larger subarrays and switches to Insertion
 * Sort for smaller subarrays, optimizing performance based on array size.
 *
 * @param <T>
 *   The type of elements sorted.
 *
 * Author: Slok Rajbhandari
 */
public class RajbhandariSlokSort<T> implements Sorter<T> {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The way in which elements are ordered.
   */
  private final Comparator<? super T> order;

  /**
   * Threshold size for switching to Insertion Sort.
   */
  private static final int INSERTION_SORT_THRESHOLD = 10;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter using a particular comparator.
   *
   * @param comparator
   *   The order in which elements in the array should be ordered after sorting.
   */
  public RajbhandariSlokSort(Comparator<? super T> comparator) {
    this.order = comparator;
  } // RajbhandariSlokSort(Comparator)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Sort an array in place using the custom hybrid algorithm.
   *
   * @param values
   *   an array to sort.
   */
  @Override
  public void sort(T[] values) {
    hybridSort(values, 0, values.length - 1);
  } // sort(T[])

  /**
   * Hybrid sorting algorithm that switches between Merge Sort and Insertion Sort.
   *
   * @param values
   *   the array to sort.
   * @param left
   *   the starting index.
   * @param right
   *   the ending index.
   */
  private void hybridSort(T[] values, int left, int right) {
    if (right - left < INSERTION_SORT_THRESHOLD) { // if size below threshold
      insertionSort(values, left, right);
    } else { // else use merge sort
      int mid = (left + right) / 2;
      hybridSort(values, left, mid);
      hybridSort(values, mid + 1, right);
      merge(values, left, mid, right);
    } // if-else
  } // hybridSort(T[], int, int)

  /**
   * Insertion Sort algorithm for sorting small subarrays.
   *
   * @param values
   *   the array to sort.
   * @param left
   *   the starting index.
   * @param right
   *   the ending index.
   */
  private void insertionSort(T[] values, int left, int right) {
    for (int i = left + 1; i <= right; i++) { // for loop
      T key = values[i];
      int j = i - 1;
      while (j >= left && order.compare(values[j], key) > 0) { // while loop
        values[j + 1] = values[j];
        j--;
      } // while loop ends
      values[j + 1] = key;
    } // for loop ends
  } // insertionSort(T[], int, int)

  /**
   * Merges two sorted halves of the array.
   *
   * @param values
   *   the array to merge in place.
   * @param left
   *   the starting index of the first half.
   * @param mid
   *   the ending index of the first half.
   * @param right
   *   the ending index of the second half.
   */
  private void merge(T[] values, int left, int mid, int right) {
    T[] aux = values.clone();
    int i = left;
    int j = mid + 1;
    int k = left;

    while (i <= mid && j <= right) { // while loop
      if (order.compare(aux[i], aux[j]) <= 0) {
        values[k++] = aux[i++];
      } else {
        values[k++] = aux[j++];
      } // if loop end
    } // while loop ends
    while (i <= mid) { // while loop
      values[k++] = aux[i++];
    } // while loop ends
  } // merge(T[], int, int, int)
} // class RajbhandariSlokSort
