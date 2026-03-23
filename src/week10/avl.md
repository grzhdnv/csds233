# AVL Trees Explained

## What is an AVL Tree?

An **AVL tree** is a self-balancing binary search tree (BST) where the heights of the left and right subtrees of any node differ by at most one. Named after inventors **A**delson-**V**elsky and **L**andis (1962), it was the first self-balancing BST to be proposed.

## Why Do We Need AVL Trees?

In a regular BST, operations like search, insert, and delete have:
- **Best case**: O(log n) - balanced tree
- **Worst case**: O(n) - completely unbalanced (degenerate tree like a linked list)

AVL trees guarantee O(log n) time complexity by maintaining balance.

## Balance Factor

The **balance factor** of a node is defined as:

```
Balance Factor = height(left subtree) - height(right subtree)
```

For an AVL tree, every node must have a balance factor of **-1, 0, or 1**:
- **BF = 1**: Left subtree is taller by 1
- **BF = 0**: Both subtrees have equal height
- **BF = -1**: Right subtree is taller by 1

If any node has |BF| > 1, the tree is unbalanced and needs rebalancing.

## Rotations

When a node becomes unbalanced after insertion or deletion, we use **rotations** to restore balance. There are four types:

### 1. Right Rotation (LL Case)

Used when the left subtree of the left child is too tall (Left-Left case).

```
        z                               y
       / \     Right Rotation          /  \
      y   T4   - - - - - - - >        x     z
     / \                             / \   / \
    x   T3                          T1  T2 T3  T4
   / \
  T1  T2
```

### 2. Left Rotation (RR Case)

Used when the right subtree of the right child is too tall (Right-Right case).

```
  z                                y
 / \     Left Rotation            /  \
T1  y   - - - - - - -  ->        z     x
   / \                          / \   / \
  T2  x                        T1 T2 T3  T4
     / \
    T3  T4
```

### 3. Left-Right Rotation (LR Case)

Used when the left subtree's right child is too tall. It's a combination:
1. Left rotation on left child
2. Right rotation on root

```
      z                            z                            x
     / \                          / \                          /  \
    y   T4    Left Rotate (y)    x   T4   Right Rotate(z)     y     z
   / \      - - - - - - - ->    / \      - - - - - - - ->   / \   / \
  T1  x                        y   T3                      T1  T2 T3  T4
     / \                      / \
    T2  T3                   T1  T2
```

### 4. Right-Left Rotation (RL Case)

Used when the right subtree's left child is too tall. It's a combination:
1. Right rotation on right child
2. Left rotation on root

```
    z                            z                            x
   / \                          / \                          /  \
  T1  y   Right Rotate (y)    T1   x      Left Rotate(z)    z     y
     / \  - - - - - - - ->       / \    - - - - - - - ->  / \   / \
    x   T4                      T2  y                    T1  T2 T3  T4
   / \                              / \
  T2  T3                           T3  T4
```

## Double Rotations in Detail

Double rotations are needed when the imbalance is caused by a node in the "inner" subtree (left child's right subtree or right child's left subtree). A single rotation won't fix the imbalance.

### Left-Right (LR) Double Rotation - Detailed Walkthrough

**When**: Left subtree is heavier (BF > 1) AND the new node was inserted into the RIGHT subtree of the LEFT child.

**Problem**: The left child has a right-heavy subtree.

**Step-by-step example:**

```
Initial tree (after inserting 35):
        50                          Balance Factors:
       /                            50: BF = 2 (unbalanced!)
      30                            30: BF = -1
       \
       40
```

**Step 1: Left rotate on left child (30)**

```
        50
       /
      40
     /
    30
```

**Step 2: Right rotate on root (50)**

```
      40
     /  \
    30   50
```

**Result**: Tree is now balanced!

### Right-Left (RL) Double Rotation - Detailed Walkthrough

**When**: Right subtree is heavier (BF < -1) AND the new node was inserted into the LEFT subtree of the RIGHT child.

**Problem**: The right child has a left-heavy subtree.

**Step-by-step example:**

```
Initial tree (after inserting 45):
    40                              Balance Factors:
      \                              40: BF = -2 (unbalanced!)
      50                             50: BF = 1
      /
     45
```

**Step 1: Right rotate on right child (50)**

```
    40
      \
      45
        \
        50
```

**Step 2: Left rotate on root (40)**

```
      45
     /  \
    40   50
```

**Result**: Tree is now balanced!

### Why Double Rotation Works

```
Consider the LR case:

        z (BF=2)           After left rotation          After right rotation
       / \                 on y (left child):           on z (root):
      y   T4                      z                           
     / \                          / \                        x
    T1  x                        x   T4                     / \
       / \                      / \                        y   z
      T2 T3                    y   T3                     /|   |\
                              / \                        T1 T2 T3 T4
                             T1  T2

The "x" node (left child's right child) becomes the new root of this subtree,
with y as its left child and z as its right child.
```

### Decision Tree for Rotations

```
Get balance factor of node:
│
├── BF > 1 (left-heavy)
│   │
│   ├── BF of left child >= 0  →  RIGHT rotation (LL case)
│   │
│   └── BF of left child < 0   →  LEFT-RIGHT rotation (LR case)
│
└── BF < -1 (right-heavy)
    │
    ├── BF of right child <= 0 →  LEFT rotation (RR case)
    │
    └── BF of right child > 0  →  RIGHT-LEFT rotation (RL case)
```

## Insertion in AVL Tree

1. Perform standard BST insertion
2. Update height of current node
3. Get balance factor
4. If unbalanced, there are 4 cases:
   - **LL Case**: Right rotation
   - **RR Case**: Left rotation
   - **LR Case**: Left rotation on left child, then right rotation
   - **RL Case**: Right rotation on right child, then left rotation

### Pseudocode

```
insert(root, key):
    // Step 1: Standard BST insertion
    if root == null:
        return new Node(key)
    
    if key < root.key:
        root.left = insert(root.left, key)
    else if key > root.key:
        root.right = insert(root.right, key)
    else:
        return root  // Duplicate keys not allowed
    
    // Step 2: Update height
    root.height = 1 + max(height(root.left), height(root.right))
    
    // Step 3: Get balance factor
    balance = getBalance(root)
    
    // Step 4: Balance if needed
    
    // LL Case
    if balance > 1 and key < root.left.key:
        return rightRotate(root)
    
    // RR Case
    if balance < -1 and key > root.right.key:
        return leftRotate(root)
    
    // LR Case
    if balance > 1 and key > root.left.key:
        root.left = leftRotate(root.left)
        return rightRotate(root)
    
    // RL Case
    if balance < -1 and key < root.right.key:
        root.right = rightRotate(root.right)
        return leftRotate(root)
    
    return root
```

## Deletion in AVL Tree

1. Perform standard BST deletion
2. Update height of current node
3. Get balance factor
4. If unbalanced, perform appropriate rotations (similar to insertion, but must check all four cases)

## Time Complexity

| Operation | Average Case | Worst Case |
|-----------|--------------|------------|
| Search    | O(log n)     | O(log n)   |
| Insert    | O(log n)     | O(log n)   |
| Delete    | O(log n)     | O(log n)   |
| Space     | O(n)         | O(n)       |

## AVL vs Regular BST

| Aspect         | Regular BST | AVL Tree |
|----------------|-------------|----------|
| Balance        | Not guaranteed | Always balanced |
| Search (worst) | O(n)        | O(log n) |
| Insert         | O(n) worst  | O(log n) guaranteed |
| Extra overhead | None        | Height tracking + rotations |

## When to Use AVL Trees

- **Good for read-heavy applications**: Guaranteed O(log n) search
- **When you need predictable performance**: No worst-case O(n) scenarios
- **Frequent lookups**: The balance ensures optimal search times

## Alternatives

- **Red-Black Trees**: Less strict balancing, fewer rotations on insert/delete
- **B-Trees**: Better for disk-based storage and databases
- **Splay Trees**: Self-adjusting, good for locality of reference