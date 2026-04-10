package com.govswa.dsa.trees_3;

import java.util.*;

public class BinaryTree {

    private class Node {
        private Node left;
        private int value;
        private Node right;

        public Node(Node left, int value, Node right) {
            this.left = left;
            this.value = value;
            this.right = right;
        }
    }

    private Node root;

    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private Node insertRecursive(Node t, int value) {
        if (t == null) {
            return new Node(null, value, null);
        } else {
            if (value < t.value) {
                t.left = insertRecursive(t.left, value);
            } else if (value > t.value) {
                t.right = insertRecursive(t.right, value);
            }
            return t;
        }
    }

    public void preOrder() {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        System.out.print("Pre Order: ");
        pre(root);
    }

    public void inOrder() {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        System.out.print("In Order: ");
        in(root);
    }

    public void postOrder() {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        System.out.print("Post Order: ");
        post(root);
    }

    public List<Integer> preOrderIterative() {
        List<Integer> preOrder = new ArrayList<>();
        if (root == null) {
            return preOrder;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            preOrder.add(curr.value);
            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
        }
        return preOrder;
    }

    public List<Integer> inOrderIterative() {
        List<Integer> inOrder = new ArrayList<>();
        if (root == null) {
            return inOrder;
        }
        Node curr = root;
        Stack<Node> stack = new Stack<>();
        while (true) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                curr = stack.pop();
                inOrder.add(curr.value);
                curr = curr.right;
            }
        }
        return inOrder;
    }

    public List<Integer> postOrderUsingTwoStackIterative() {
        List<Integer> postOrder = new ArrayList<>();
        if (root == null) {
            return postOrder;
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            Node curr = stack1.pop();
            stack2.push(curr);
            if (curr.left != null) stack1.push(curr.left);
            if (curr.right != null) stack1.push(curr.right);
        }
        while (!stack2.isEmpty()) {
            postOrder.add(stack2.pop().value);
        }
        return postOrder;
    }

    public List<List<Integer>> levelOrderTraversalBFSIterative() {
        List<List<Integer>> traversalResult = new ArrayList<>();
        if (root == null) {
            return traversalResult;
        }
        System.out.print("level Order Traversal BFS Iterative: ");
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                Node curr = queue.poll();
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
                list.add(curr.value);
            }
            traversalResult.add(list);
        }
        return traversalResult;
    }

    private void pre(Node t) {
        if (t != null) {
            System.out.print(t.value + " ");
            pre(t.left);
            pre(t.right);
        }
    }

    private void in(Node t) {
        if (t != null) {
            in(t.left);
            System.out.print(t.value + " ");
            in(t.right);
        }
    }

    private void post(Node t) {
        if (t != null) {
            post(t.left);
            post(t.right);
            System.out.print(t.value + " ");
        }
    }

    public int height(Node t) {
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTree binaryTrees = new BinaryTree();
        while (true) {
            System.out.println("\n1.insert, 2.preOrder, 3.inOrder, 4.postOrder, 5.levelOrderTraversalBFSIterative, " +
                    "6.preOrderIterative, 7.inOrderIterative, 8.postOrderUsingTwoStackIterative, 0.Exit");
            int ch = sc.nextInt();
            switch (ch) {
                case 1: {
                    System.out.println("Enter value wanted to insert");
                    int value = sc.nextInt();
                    binaryTrees.insert(value);
                    break;
                }
                case 2: {
                    binaryTrees.preOrder();
                    break;
                }
                case 3: {
                    binaryTrees.inOrder();
                    break;
                }
                case 4: {
                    binaryTrees.postOrder();
                    break;
                }
                case 5: {
                    List<List<Integer>> traversalResult = binaryTrees.levelOrderTraversalBFSIterative();
                    if (!traversalResult.isEmpty()) {
                        System.out.println(traversalResult);
                    } else {
                        System.out.println("Tree is empty");
                    }
                    break;
                }
                case 6: {
                    List<Integer> preOrder = binaryTrees.preOrderIterative();
                    if (!preOrder.isEmpty()) {
                        System.out.println("Pre Order Iterative: " + preOrder);
                    } else {
                        System.out.println("Tree is empty");
                    }
                    break;
                }
                case 7: {
                    List<Integer> inOrder = binaryTrees.inOrderIterative();
                    if (!inOrder.isEmpty()) {
                        System.out.println("In Order Iterative: " + inOrder);
                    } else {
                        System.out.println("Tree is empty");
                    }
                    break;
                }
                case 8: {
                    List<Integer> postOrder = binaryTrees.postOrderUsingTwoStackIterative();
                    if (!postOrder.isEmpty()) {
                        System.out.println("Post Order Using Two Stack Iterative: " + postOrder);
                    } else {
                        System.out.println("Tree is empty");
                    }
                    break;
                }
                case 0: {
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("Please choose correct option");
                    break;
                }
            }
        }
    }
}


/*
        12
       /  \
     10    14
    /  \   /  \
   8   11 13  16
* */