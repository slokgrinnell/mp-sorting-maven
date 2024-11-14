package edu.grinnell.csc207.sorting;

import java.util.Comparator;

/**
 * A sorter that implements selection sort.
 *
 * @param <T>
 *   The type of elements sorted.
 *
 * @author Samuel A. Rebelsky
 * @author Slok
 */
public class SelectionSorter<T> implements Sorter<T> {
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
  public SelectionSorter(Comparator<? super T> comparator) {
    this.order = comparator;
  } // SelectionSorter(Comparator)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Sort an array in place using selection sort.
   *
   * @param values
   *   an array to sort.
   */
  @Override
  public void sort(T[] values) {
    for (int i = 0; i < values.length - 1; i++) { // for loop (outer)
      int minIndex = i;
      for (int j = i + 1; j < values.length; j++) { // for loop (inner)
        if (order.compare(values[j], values[minIndex]) < 0) {
          minIndex = j;
        } // if
      } // for loop (inner) ends
      T temp = values[minIndex];
      values[minIndex] = values[i];
      values[i] = temp;
    } // for loop (outer) ends
  } // sort(T[])
} // class SelectionSorter
