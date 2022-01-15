package edu.umsl;

/* Created By Tyler Ziggas
Date of Creation: November 25, 2020
Date of Submission: November 2020

    This code creates multiple binary search trees, one with 100 nodes, one with 500 nodes, and one
with 1000 nodes.  For each of these the program will also create a specific number of trees, making 5 trees of each of
those, 10 trees of each of those, and 15 trees of each of those.  This makes for a total of 9 combinations we are looking at
and our end goal is to calculate the average height of those trees with those specific number of nodes.  For example,
looking at the 5 trees with 100 nodes each, and seeing what the average height of those trees are.
*/

public class RandomBinarySearchTrees {
    class Node { // Define BTS Node class
        int key;
        Node left, right;

        public Node(int data){
            key = data;
            left = right = null;
        }
    }

    Node root; // BST root node

    RandomBinarySearchTrees() { // Constructor for BST, initial empty tree
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
        if (key <= root.key) {// insert in the left subtree
            root.left = insertRecursion(root.left, key);
        } else if (key > root.key) {// insert in the right subtree
            root.right = insertRecursion(root.right, key);
        }
        return root;
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

    public static void main(String[] args) {
        int N[] = {100, 500, 1000}; // Create size of arrays for nodes
        int t[] = {5, 10, 15}; // Create size of arrays for trees

        System.out.println("For this experiment, we will be adding duplicates to the left side of the tree.\n");
        for (int numNodes : N) {
            for (int numTrees : t) {
                double totalHeight = 0;
                for (int i = 0; i < numTrees; i++) { // Creating the new trees
                    RandomBinarySearchTrees rbst = new RandomBinarySearchTrees();
                    for (int k = 0; k < numNodes; k++) { // Creating the random numbers for nodes
                        rbst.insert((int) (Math.random() * (500 - 1)) + 1);
                    }
                    totalHeight += rbst.height(); // Adding up all the height
                }
                double avgHeight = totalHeight / numTrees; // Calculating the average
                System.out.println("For N=" + numNodes + " nodes and t=" + numTrees + " trees, the average height is " + avgHeight);
            }
        }
    }
}