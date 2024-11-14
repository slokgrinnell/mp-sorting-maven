# mp-sorting-maven

An exploration of sorting in Java.

Authors

* Slok Rajbhandari
* Samuel A. Rebelsky (starter code)

Acknowledgements

* _Forthcoming_.

This code may be found at <https://github.com/slokgrinnell/mp-sorting-maven>. The original code may be found at <https://github.com/Grinnell-CSC207/mp-sorting-maven>.

Description of custom sorting algorithm
---------------------------------------
 The algorithm uses hybridSort to recursively divide the array, and for small subarrays (less than INSERTION_SORT_THRESHOLD), it switches to Insertion Sort, which is faster on small datasets due to lower overhead. Larger subarrays use merge to merge sorted subarrays which ensures efficient handling of larger datasets.

Notes on using Copilot (or other AI)
------------------------------------

I was looking for the best sorting algorithm and I was asking ChatGPT for giving me some options, it gave me a option for why not use insertion sort for smaller arrays and then larger subarrays use merge to merge sorted subarrays. Then I started to research more on this and just came across this github page https://github.com/Ry3nG/Hybrid-Sort-based-on-Insertion-Sort-and-Merge-Sort , I did not see any code but just the image that explained it and started to write the code for my personal sort.

_This section is optional_
