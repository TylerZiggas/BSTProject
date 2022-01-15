package edu.umsl;

/* Created By Tyler Ziggas
Date of Creation: November 25, 2020
Date of Submission: November 2020

    This code gives the user multiple options as to what they would like to do with the binary search tree.
Options include using a test case which is listed in the project, inserting your own node, searching for a node,
deleting a node, traversing the tree (using inorder, preorder, and postorder traversal), finding the height of the
tree, finding the smallest value in the tree, and finding the largest value in the tree.
    This particular file is for executing the different options there are listed in main (with the exception
of quitting the program).  As for the selection of what to do and what numbers you would like to use, they are
input in Main.java
*/

class BinarySearchTree {
    class Node { // Define BTS Node class
        int key;
        Node left, right;

        public Node(int data){
            key = data;
            left = right = null;
        }
    }

    Node root; // BST root node

    BinarySearchTree() { // Constructor for BST, initial empty tree
        root = null;
    }

    void insert(int key)  { // Insert a node in BST
        root = insertRecursion(root, key);
    }

    Node insertRecursion(Node root, int key) { // Recursive insert function

        if (root == null) { //If tree is empty
            root = new Node(key);
            return root;
        }
        if (key < root.key) {// insert in the left subtree
            root.left = insertRecursion(root.left, key);
        } else if (key > root.key) {// insert in the right subtree
            root.right = insertRecursion(root.right, key);
        }
        return root;
    }

    boolean search(int key)  { // Search a node in BST
        root = searchRecursion(root, key);
        if (root != null) {
            return true;
        } else {
            return false;
        }
    }

    Node searchRecursion(Node root, int key) { // Recursive search function
        if (root == null) { // If root is null
            return root;
        } else if (root.key == key) { // Display if root is the key
            System.out.print(root.key + " --> ");
            return root;
        }

        if (root.key > key) { // Searching for node greater than root
            System.out.print(root.key + " --> ");
            return searchRecursion(root.left, key);
        } else { // Searching for node smaller than root
            System.out.print(root.key + " --> ");
            return searchRecursion(root.right, key);
        }
    }

    void deleteKey(int key) { // Delete a node in BST
        root = deleteRecursion(root, key);
    }

    Node deleteRecursion(Node root, int key) { // Recursive delete function

        if (root == null) { // If root is null
            return root;
        }

        if (key < root.key) {   // Traverse left subtree
            root.left = deleteRecursion(root.left, key);
        } else if (key > root.key) { // Traverse right subtree
            root.right = deleteRecursion(root.right, key);
        } else  { // node contains only one child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.key = minValue(root.right);
            root.right = deleteRecursion(root.right, root.key);
        }
        return root;
    }


    void inorder() { // Inorder traversal of BST
        inorderFunction(root);
    }

    void preorder() { // Preorder traversal of BST
        preorderFunction(root);
    }

    void postorder() { // Postorder traversal of BST
        postorderFunction(root);
    }


    void inorderFunction(Node root) { // Recursively traverse the BST
        if (root != null) {
            inorderFunction(root.left);
            System.out.print(root.key + " ");
            inorderFunction(root.right);
        }
    }

    void preorderFunction(Node root) { // Recursively traverse the BST
        if (root != null) {
            System.out.print(root.key + " ");
            preorderFunction(root.left);
            preorderFunction(root.right);
        }
    }

    void postorderFunction(Node root) { // Recursively traverse the BST
        if (root != null) {
            postorderFunction(root.left);
            postorderFunction(root.right);
            System.out.print(root.key + " ");
        }
    }

    int height() { // Find height of BST
        int depth = height(root);
        return depth;
    }

    int height(Node root)
    {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = height(root.left); // Find the depth of each subtree
            int rightHeight = height(root.right);

            if (leftHeight > rightHeight) {// Use the one with more depth
                return (leftHeight + 1);
            } else {
                return (rightHeight + 1);
            }
        }
    }

    int minValue() { // Find minimum value
        int value = minValue(root);
        return value;
    }

    int maxValue() { // Find maximum value
        int value = maxValue(root);
        return value;
    }

    int minValue(Node root)  {
        int minValue = root.key; // Initially minimum is the root
        while (root.left != null)  { // Find minimum
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }

    int maxValue(Node root)  {
        int maxValue = root.key; // Initially maximum is the root
        while (root.right != null)  { // Find maximum
            maxValue = root.right.key;
            root = root.right;
        }
        return maxValue;
    }
}