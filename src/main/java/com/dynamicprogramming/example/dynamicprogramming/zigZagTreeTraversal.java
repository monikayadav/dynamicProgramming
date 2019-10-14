package com.dynamicprogramming.example.dynamicprogramming;

import java.util.Stack;

class Node {
	int data;
	Node leftChild;
	Node rightChild;

	Node(int data) {
		this.data = data;
	}
}

class BinaryTree {
	Node rootNode;

	void printZigZagTraversal() {

		if (rootNode == null) {
			return;
		}
		boolean leftToRight = true;
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		s1.push(rootNode);
		while (!s1.isEmpty()) {
			Node node = s1.pop();
			System.out.println(node.data);
			if (leftToRight) {
				if (node.leftChild != null)
					s2.push(node.leftChild);
				if (node.rightChild != null)
					s2.push(node.rightChild);
			} else {
				if (node.rightChild != null)
					s2.push(node.rightChild);
				if (node.leftChild != null)
					s2.push(node.leftChild);
			}
			if (s1.isEmpty()) {
				s1 = s2;
				s2 = new Stack<>();
				leftToRight = !leftToRight;
			}
		}

	}
}

public class ZigZagTreeTraversal {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.rootNode = new Node(1);
		tree.rootNode.leftChild = new Node(2);
		tree.rootNode.rightChild = new Node(3);
		tree.rootNode.leftChild.leftChild = new Node(7);
		tree.rootNode.leftChild.rightChild = new Node(6);
		tree.rootNode.rightChild.leftChild = new Node(5);
		tree.rootNode.rightChild.rightChild = new Node(4);

		System.out.println("ZigZag Order traversal of binary tree is");
		tree.printZigZagTraversal();
	}
}