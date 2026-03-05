# Merge Sort

Recurrence equation:

T(n) = aT(n/2) + 

T(n) = 2T(n/2) + O(1) + O(n)

Reduced:
T(n) = 

Steps: log2(n)


O(n) = n log2(n) 


## Binary Search

T(n) = T(n/2) + O(1)

## Quick sort

Worst case O(n^2)
Average/Best O(n log2 n)

Does not require extra memory like Merge Sort

Pivot value
Randomized partition and sort to avoid worst case


# Trees

Useful for hierarchically ordered data.

* Element at the top is **root**
* Children and grandchildren
* Elements with no children – **leafs**

Root, nodes connected by edges. No cycles.

A tree t is a finite nonempty set fo elements.
One of those elements is the root. The remaining elements, if any, are partitioned into trees

For the class -- root is level 1.
Tree height = number of levels.
Node degree – how many children nodes a node has. Degree of a tree – maximum node degree.

## Binary Tree

Tree of degree two.
Children are ordered – left and right.

