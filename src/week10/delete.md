# Binary Search Tree (BST) Deletion Explained

Deletion from a BST is more complex than insertion or search because we need to maintain the BST property after removing a node. There are **three cases** to handle:

## Case 1: Node is a Leaf (No Children)
This is the simplest case. Just remove the node by setting its parent's pointer to null.

```
    50              50
   /  \    →      /  \
  30   70        30   70
 / \    \
10  40   80      10  40
```
Deleting 80: simply remove it.

## Case 2: Node Has One Child
Replace the node with its only child. The child takes the node's place.

```
    50              50
   /  \    →      /  \
  30   70        30   80
      /            (70 removed, 80 takes its place)
     80
```
Deleting 70: 80 moves up to replace 70.

## Case 3: Node Has Two Children (Most Complex)
This requires two steps:
1. Find either the **in-order predecessor** (largest value in left subtree) OR the **in-order successor** (smallest value in right subtree)
2. Copy that node's key/value to the node being deleted
3. Delete the predecessor/successor node (which will have at most one child)

```
    50              50
   /  \    →      /  \
  30   70        30   70
 / \   / \      / \   / 
10 40 60  80   10 40 60  (80 replaced 75, then old 80 removed)
       /
      75

Or using predecessor (max of left subtree):
    50              50
   /  \    →      /  \
  30   70        40   70
 / \   / \      /    / \
10 40 60  80   10   60  80
```

## Algorithm Pseudocode

```
delete(root, key):
    if root is null:
        return null
    
    if key < root.key:
        root.left = delete(root.left, key)
    else if key > root.key:
        root.right = delete(root.right, key)
    else:
        // Found node to delete
        
        // Case 1: No children (leaf)
        if root.left == null and root.right == null:
            return null
        
        // Case 2: One child
        if root.left == null:
            return root.right
        if root.right == null:
            return root.left
        
        // Case 3: Two children
        successor = getMin(root.right)  // or getMax(root.left)
        root.key = successor.key
        root.value = successor.value
        root.right = delete(root.right, successor.key)
    
    return root
```

## Time Complexity
- **Average case**: O(log n) - height of a balanced tree
- **Worst case**: O(n) - tree is completely unbalanced (like a linked list)