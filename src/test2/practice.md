1. **Recursion**
    - Define a recursive problem.
      - Answer: A problem that can be decomposed into smaller instances of the same problem, ultimately reaching a base case that can be solved directly.
    - Demonstrate the ability to read a recursive function.
    - Write a recursive function to solve a problem.
      - ```java
        int factorial(int n) {
            if (n <= 1) 
                return 1; 
            return n * factorial(n - 1);
        }
        ```

2. **Algorithms**
    - Explain/demonstrate how the following algorithms work:
        - Merge Sort
          - Answer: A divide-and-conquer algorithm that recursively splits the list in half until single-element sublists are reached. These are then merged back together in sorted order using extra memory (O(n)).
        - Quick Sort
          - Answer: A divide-and-conquer algorithm that selects a "pivot" element and partitions the array into two sub-arrays: elements less than the pivot and elements greater than the pivot. This process is then recursively applied to the sub-arrays.
        - Linear Search
          - Answer: A simple search algorithm that starts at the beginning of the list and checks each element sequentially until the target value is found or the end of the list is reached.
        - Binary Search
          - Answer: A search algorithm for sorted lists that repeatedly divides the search interval in half. It compares the target value to the middle element, then continues the search in the left or right half based on the comparison.
    - Provide asymptotic analysis for the recursive algorithms mentioned above.
        - Answer: 
          - Merge Sort: O(n log n) (best, average, and worst case)
          - Quick Sort: Average case O(n log n), Worst case O(n²) (if pivot selection is poor)
          - Linear Search: O(n)
          - Binary Search: O(log n)

3. **Tree Data Structures**
    - Define and illustrate the following terms:
        - Tree, root, leaf, subtree
          - Answer: A tree is a hierarchical structure with a root node and children nodes. The root is the top-most node (no parent). Leaves are nodes with no children. A subtree consists of a node and all its descendants.
        - Parent, child, ancestors, descendants, siblings
          - Answer: A parent is the immediate predecessor of a node; a child is the immediate successor. Ancestors are all nodes on the path from the root to the node; descendants are all nodes reachable from the node. Siblings are nodes that share the same parent.
        - Height, depth, degree
          - Answer: 
            - **Depth**: The number of edges from the root to the node. The root's depth is 0.
            - **Height**: The number of edges on the longest path from the node to a leaf. The tree's height is the height of the root.
            - **Degree**: The number of children a node has.
        - Binary tree, complete binary tree, full binary tree
          - Answer: 
            - **Binary tree**: A tree where each node has at most 2 children.
            - **Complete binary tree**: A binary tree where every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible.
            - **Full binary tree**: A binary tree where every node has either 0 or 2 children (no node has only one child).
    - Derive a formula for the maximum nodes in a binary tree of height *h*.
      - Answer: 
        - **Logic**: Each level *i* of a binary tree can hold at most $2^i$ nodes. To find the maximum total nodes, we sum the capacities of all levels from the root to the height *h*.
        - **If root height is 0**: Sum is $2^0 + 2^1 + ... + 2^h = 2^{h+1} - 1$.
        - **If root height is 1**: Sum is $2^0 + 2^1 + ... + 2^{h-1} = 2^h - 1$.
    - Derive a formula for the minimum and maximum height of a binary tree with *n* nodes.
      - Answer: 
        - **Maximum height logic**: To maximize height, we place only one node at each level (a "skewed" tree or linked list).
          - **Formula**: $n - 1$ (if root=0) or $n$ (if root=1).
        - **Minimum height logic**: To minimize height, we must pack the tree as densely as possible (a complete binary tree). Since a tree of height *h* can hold up to $\approx 2^h$ nodes, the height will be proportional to the logarithm of the number of nodes.
          - **Formula**: $\lfloor \log_2 n \rfloor$ (if root=0) or $\lceil \log_2(n+1) \rceil$ (if root=1).
    - Define tree traversals:
        - Preorder
          - Answer: Visit the root, then recursively visit the left subtree, then the right subtree (Root, L, R).
        - Level order
          - Answer: Visit nodes level-by-level, from top to bottom and left to right (Breadth-First).
        - Postorder
          - Answer: Recursively visit the left subtree, then the right subtree, then the root (L, R, Root).
        - Inorder
          - Answer: Recursively visit the left subtree, visit the root, then visit the right subtree (L, Root, R).

4. **Binary Search Trees (BST)**
    - Define the requirements for the BST data structure.
      - Answer: A binary tree where for every node:
        - All elements in the **left** subtree are **strictly smaller** than the node's value.
        - All elements in the **right** subtree are **strictly larger** than the node's value.
    - Determine if given trees are BSTs.
    - Construct a BST given a set of values to be inserted.
    - Describe an algorithm for finding the smallest and largest elements in a BST.
      - Answer: 
        - **Smallest**: Start at the root and repeatedly move to the **left child** until no more left children exist. The final node is the minimum.
        - **Largest**: Start at the root and repeatedly move to the **right child** until no more right children exist. The final node is the maximum.
    - Write an implementation of the `min` or `max` function for a BST.
      - ```java
        int min(BSTNode node) {
            if (node.leftChild() == null)
                return node.value();
            return min(node.leftChild()); // Must return recursive call
        }

        int max(BSTNode node) {
            if (node.rightChild() == null)
                return node.value();
            return max(node.rightChild());
        }
        ```
    - Demonstrate an algorithm for insertion into and removal from a BST.
      - Answer: 
        - **Insertion**: Compare value to current node. If smaller, go left; if larger, go right. Repeat until you find a null spot where the node can be added.
        - **Removal**: Three cases:
          1. **Node is a leaf**: Simply delete it.
          2. **Node has one child**: Replace the node with its child.
          3. **Node has two children**: Find the **inorder successor** (smallest in right subtree) or **inorder predecessor** (largest in left subtree), replace the node's value with it, then delete that successor/predecessor node.
    - Write an implementation of the `insertion` and `find` functions for a BST.
      - ```java
        BSTNode find(BSTNode node, int element) {
            if (node == null || node.value() == element)
                return node;
            if (element < node.value())
                return find(node.leftChild(), element);
            return find(node.rightChild(), element);
        }
        
        BSTNode insert(BSTNode node, int element) {
            if (node == null)
                return new BSTNode(element); // Create new node in empty spot
            
            if (element < node.value())
                node.setLeftChild(insert(node.leftChild(), element));
            else if (element > node.value())
                node.setRightChild(insert(node.rightChild(), element));
            
            return node; // Return the (potentially updated) node
        }
        ```
    - Describe an algorithm for enumerating elements in a BST in ascending order.
      - Answer: Perform an **inorder traversal** (Left, Root, Right). Since the left subtree is always smaller and the right is always larger, this visits nodes in their natural sorted order.

5. **AVL Trees**
    - Define the characteristics of an AVL tree.
      - Answer: An AVL tree is a **self-balancing Binary Search Tree**. Its key characteristic is the **Balance Condition**: for every node, the heights of its left and right subtrees differ by **at most 1** ($|height(left) - height(right)| \le 1$).
    - Compare and contrast AVL and BSTs in terms of complexity (insertion, deletion, searches).
      - | Operation     | BST (Average) | BST (Worst) | AVL (Worst)     |
        |:--------------|:--------------|:------------|:----------------|
        | **Search**    | $O(\log n)$   | $O(n)$      | **$O(\log n)$** |
        | **Insertion** | $O(\log n)$   | $O(n)$      | **$O(\log n)$** |
        | **Deletion**  | $O(\log n)$   | $O(n)$      | **$O(\log n)$** |
        - *Key difference*: AVL trees guarantee logarithmic time for all operations by maintaining balance, whereas a BST can become "skewed" (like a linked list) and degrade to linear time.
    - Define rotation types for AVL insertions and their circumstances:
        - No rotation
          - Answer: The node is already balanced ($BF \in \{-1, 0, 1\}$).
        - Simple left rotation (RR Case)
          - Answer: Occurs when a node is **right-heavy** and its **right child is also right-heavy** (or balanced). The right child becomes the new root of the subtree.
        - Simple right rotation (LL Case)
          - Answer: Occurs when a node is **left-heavy** and its **left child is also left-heavy** (or balanced). The left child becomes the new root of the subtree.
        - Right-left rotation (RL Case)
          - Answer: Occurs when a node is **right-heavy** but its **right child is left-heavy**. You first perform a right rotation on the right child, then a left rotation on the node itself.
        - Left-right rotation (LR Case)
          - Answer: Occurs when a node is **left-heavy** but its **left child is right-heavy**. You first perform a left rotation on the left child, then a right rotation on the node itself.
    - Demonstrate AVL insertion requiring each rotation type.
      - Answer: 
        - **LL (Right Rotate)**: Insert `1, 2, 3` in reverse order (`3, 2, 1`). Node `3` becomes imbalanced.
        - **RR (Left Rotate)**: Insert `1, 2, 3`. Node `1` becomes imbalanced.
        - **LR (Left-Right)**: Insert `3, 1, 2`. Node `3` is left-heavy, `1` is right-heavy.
        - **RL (Right-Left)**: Insert `1, 3, 2`. Node `1` is right-heavy, `3` is left-heavy.
    - Identify the nodes involved in rotations and the resulting tree structure.
      - Answer: The "pivot" is the child of the imbalanced node that moves up to replace it. In double rotations (LR/RL), the "grandchild" eventually becomes the new root of the subtree.
    - Calculate the balance factor for each node in an AVL tree.
      - Answer: **$BF(node) = height(left\_subtree) - height(right\_subtree)$**. (Note: some conventions use $right - left$; just be consistent).