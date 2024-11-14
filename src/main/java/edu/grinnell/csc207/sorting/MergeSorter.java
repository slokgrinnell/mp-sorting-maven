package edu.grinnell.csc207.sorting;

import java.util.Comparator;

/**
 * A sorter that implements merge sort.
 *
 * @param <T>
 *   The type of elements sorted.
 *
 * @author Samuel A. Rebelsky
 * @author Slok
 */
public class MergeSorter<T> implements Sorter<T> {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The way in which elements are ordered.
   */
  private final Comparator<? super T> order;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter using a particular comparator.
   *
   * @param comparator
   *   The order in which elements in the array should be ordered after sorting.
   */
  public MergeSorter(Comparator<? super T> comparator) {
    this.order = comparator;
  } // MergeSorter(Comparator)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Sort an array in place using merge sort.
   *
   * @param values
   *   an array to sort.
   */
  @Override
  public void sort(T[] values) {
    if (values.length > 1) {
      T[] aux = values.clone();
      mergeSort(values, aux, 0, values.length - 1);
    } // if
  } // sort(T[])

  /**
   * Recursive merge sort implementation.
   *
   * @param values
   *   the array to be sorted.
   * @param aux
   *   an auxiliary array used for merging.
   * @param left
   *   the left boundary for sorting.
   * @param right
   *   the right boundary for sorting.
   */
  private void mergeSort(T[] values, T[] aux, int left, int right) {
    if (left < right) {
      int mid = (left + right) / 2;
      mergeSort(values, aux, left, mid);
      mergeSort(values, aux, mid + 1, right);
      merge(values, aux, left, mid, right);
    } // if
  } // mergeSort(T[], T[], int, int)

  /**
   * Merges two halves of the array.
   *
   * @param values
   *   the main array to hold sorted elements.
   * @param aux
   *   the auxiliary array used for comparison.
   * @param left
   *   the start index of the left subarray.
   * @param mid
   *   the end index of the left subarray.
   * @param right
   *   the end index of the right subarray.
   */
  private void merge(T[] values, T[] aux, int left, int mid, int right) {
    for (int i = left; i <= right; i++) { // for loop
      aux[i] = values[i];
    } // for loop ends
    int i = left;
    int j = mid + 1;
    int k = left;
    while (i <= mid && j <= right) { // while loop
      if (order.compare(aux[i], aux[j]) <= 0) {
        values[k++] = aux[i++];
      } else {
        values[k++] = aux[j++];
      }
    } // while loop ends
    while (i <= mid) { // while loop
      values[k++] = aux[i++];
    } // while loop ends
  } // merge(T[], T[], int, int, int)
} // class MergeSorter
