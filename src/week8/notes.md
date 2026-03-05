# Binary tree

## Traversals

* Depth first
  * Pre-order: root, left st, right st
    * Circle from root to the left
  * Post-order: left, right, root
  * In-order: left, root, right
* Breadth-first
  * Level-order: top to bottom, left to right

It is possible to recreate a binary tree with preorder and inorder traversal.

## Binary Search Tree

In-order traversal for sorted list. O(n)
Search. O(log n) if tree us balanced, O(height) -- worst case O(n). log2(n+1) <= height <= n.

Search and insert time -- O(height)