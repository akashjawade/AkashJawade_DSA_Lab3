//Find a pair in Binary Search Tree for a given sum

package com.greatlearning.lab3_Question2;

import java.util.HashSet;
import java.util.Scanner;

class FindSumPair {

	static class Node {
		int nodeData;
		Node leftNode, rightNode;
	}

	static Node NewNode(int nodeData)
	{
		Node temp = new Node();
		temp.nodeData = nodeData;
		temp.leftNode = null;
		temp.rightNode = null;

		return temp;
	}
	
	// node insertion implementation.
	public Node insert(Node root, int key)
	{
		if (root == null)
			return NewNode(key);
		if (key < root.nodeData)
			root.leftNode = insert(root.leftNode, key);
		else
			root.rightNode = insert(root.rightNode, key);
		return root;
	}

	public boolean findpairUtil(Node root, int sum,
			HashSet<Integer> set){
       if(root == null){
		   return false;
	   }

	   if(findpairUtil(root.leftNode, sum, set)){
		   return true;
	   }
	   //check if the sum - root.nodeData
	   if(set.contains(sum - root.nodeData)){
		   System.out.println("Pain is found "+ (sum - root.nodeData) + ", "+ root.nodeData);
		   return true;
	   }
	   else {
		   set.add(root.nodeData);
		   return findpairUtil(root.rightNode, sum, set);
	   }
	}

	public void findPairWithGivenSum(Node root, int sum){
		HashSet<Integer> set = new HashSet<>();
		if(!findpairUtil(root, sum, set)){
			System.out.println("Pairs do not exists");
		}
	}

	// Driver code
	public static void main(String[] args)
	{		
		Node root = null;
		Scanner sc=new Scanner(System.in);
		
		FindSumPair bst = new FindSumPair();
		root = bst.insert(root, 40);
		root = bst.insert(root, 20);
		root = bst.insert(root, 60);
		root = bst.insert(root, 10);
		root = bst.insert(root, 30);
		root = bst.insert(root, 50);
		root = bst.insert(root, 70);
		
		System.out.print("Enter number : ");
		int sum = sc.nextInt();
		bst.findPairWithGivenSum(root, sum);
		
		sc.close();
	}
}

