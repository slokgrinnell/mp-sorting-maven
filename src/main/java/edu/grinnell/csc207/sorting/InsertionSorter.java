package edu.grinnell.csc207.sorting;

import java.util.Comparator;

/**
 * A sorter that implements insertion sort.
 *
 * @param <T>
 *   The type of elements sorted.
 *
 * @author Samuel A. Rebelsky
 * @author Slok
 */
public class InsertionSorter<T> implements Sorter<T> {
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
  public InsertionSorter(Comparator<? super T> comparator) {
    this.order = comparator;
  } // InsertionSorter(Comparator)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Sort an array in place using insertion sort.
   *
   * @param values
   *   an array to sort.
   */
  @Override
  public void sort(T[] values) {
    for (int i = 1; i < values.length; i++) { // for loop (outer)
      T key = values[i];
      int j = i - 1;
      while (j >= 0 && order.compare(values[j], key) > 0) { // while loop
        values[j + 1] = values[j];
        j--;
      } // while loop ends
      values[j + 1] = key;
    } // for loop (outer) ends
  } // sort(T[])
} // class InsertionSorter
