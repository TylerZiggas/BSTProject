package edu.umsl;
import java.util.InputMismatchException;
import java.util.Scanner;

/* Created By Tyler Ziggas
Date of Creation: November 25, 2020
Date of Submission: November 2020

    This code gives the user multiple options as to what they would like to do with the binary search tree.
Options include using a test case which is listed in the project, inserting your own node, searching for a node,
deleting a node, traversing the tree (using inorder, preorder, and postorder traversal), finding the height of the
tree, finding the smallest value in the tree, and finding the largest value in the tree.
    This particular file is meant for getting the users input and validating it to make sure that it is
something that the program can do before executing it in BinarySearchTree.java
*/

class Main{
    public static void menuSelect() { // Menu select for choices with the binary tree
        System.out.println("Please choose what you would like to do with the Binary Tree");
        System.out.println("0) Test Case for Project");
        System.out.println("1) Insert a Node");
        System.out.println("2) Search for a Node");
        System.out.println("3) Delete a Node");
        System.out.println("4) Do Traversals for the Binary Tree");
        System.out.println("5) Find the Height of the Binary Tree");
        System.out.println("6) Find the Smallest Key in the Binary Tree");
        System.out.println("7) Find the Largest Key in the Binary Tree");
        System.out.println("-1) Quit");
    }


    public static int optionSelect(int choice) { // Make sure the option is within the specified numbers
        do {
            choice = getNumber(choice);
            if (choice < -1 || choice > 7) {
                System.out.println("That is not a choice, please check the options you may choose again.");
            }
        } while (choice < -1 || choice > 7);
        return choice;
    }

    public static int getNumber(int choice) { // Make sure the option is a number
        boolean retry;
        do {
            try {
                retry = false;
                Scanner input = new Scanner(System.in);
                choice = input.nextInt();

            } catch (InputMismatchException ex) {
                System.out.println("Please input a number."); // Make sure it is a number
                retry = true;
            }
        } while (retry);
        return choice;
    }

    public static int executeChoice(int choice) { // Need to call for a number input in certain cases
        if (choice == 1) {
            System.out.println("Please input a number you would like to insert.");
            int nodeNumber = getNumber(choice);
            return nodeNumber;
        } else if (choice == 2) {
            System.out.println("Please input a number you would like to search for.");
            int nodeNumber = getNumber(choice);
            return nodeNumber;
        } else if (choice == 3) {
            System.out.println("Please input a number you would like to delete.");
            int nodeNumber = getNumber(choice);
            return nodeNumber;
        } else {
            return 0;
        }
    }

    public static void main(String[] args)  {
        BinarySearchTree bst = new BinarySearchTree();
        int choice = 0;

        do {
            menuSelect();
            choice = optionSelect(choice);
            if (choice == -1) {
                break;
            } else {
                int nodeNumber = executeChoice(choice);
                if (choice == 0){ // Automatically creates the case needed for the project
                    bst.insert(30);
                    bst.insert(10);
                    bst.insert(45);
                    bst.insert(38);
                    bst.insert(20);
                    bst.insert(50);
                    bst.insert(25);
                    bst.insert(33);
                    bst.insert(8);
                    bst.insert(12);
                }else if (choice == 1) {
                    bst.insert(nodeNumber); // Insert any number entered
                } else if (choice == 2) {
                    boolean search = bst.search(nodeNumber); // Search for any number entered
                    System.out.println("\n" + nodeNumber + " result of search: " + search);
                } else if (choice == 3) {
                    bst.deleteKey(nodeNumber); // Delete any number entered
                } else if (choice == 4) { // Do all three traversals
                    System.out.print("\nInorder Traversal: ");
                    bst.inorder();
                    System.out.print("\nPreorder Traversal: ");
                    bst.preorder();
                    System.out.print("\nPostorder Traversal: ");
                    bst.postorder();
                    System.out.println("\n");
                } else if (choice == 5) { // Find the height of the tree
                    int height = bst.height();
                    System.out.print("\nThe Height of the Binary Tree: " + height + "\n");
                } else if (choice == 6) { // Find the minimum value
                    int minimum = bst.minValue();
                    System.out.print("\nThe Minimum Value of the Binary Tree: " + minimum + "\n");
                } else if (choice == 7) { // Find the maximum value
                    int maximum = bst.maxValue();
                    System.out.print("\nThe Maximum Value of the Binary Tree: " + maximum + "\n");
                }
            }
        } while (choice != -1);
    }
}
