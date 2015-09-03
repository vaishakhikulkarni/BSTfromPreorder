//Vaishakhi Kulkarni
//vpk140230
//package DAY1;

import java.util.LinkedList;
import java.util.Scanner;

import BSTnode;

public class Assignment3_d1 {

	public static <E extends Comparable<? super E>> BSTnode<E> buildBST(
			LinkedList<E> List) {

		if (List.size() == 0) // if size is zero return null
			return null;

		// Root element is at the start of the list in preorder traversal
		BSTnode<E> root = new BSTnode<E>(List.get(0));

		// Create two list to store left and right side
		LinkedList<E> list1 = new LinkedList<E>();
		LinkedList<E> list2 = new LinkedList<E>();

		int i;
		// Store the elements in two list as per the values less than and
		// greater than root element value
		for (i = 1; i < List.size(); i++) {
			if (root.data.compareTo(List.get(i)) >= 0)
				list1.add(List.get(i));
			else
				list2.add(List.get(i));
		}

		root.left = buildBST(list1); // move left side

		root.right = buildBST(list2); // move right side

		return root;

	}

	// Inorder traversal to check the data
	public static void inorder(BSTnode<Integer> root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print("  " + root.data);
		inorder(root.right);
	}

	public static void main(String args[]) {
		System.out.println("*****Build BST FROM ITS PREORDER TRAVERSAL*****");
		System.out.println(" ");

		// Create a LinkedList
		LinkedList<Integer> list = new LinkedList<Integer>();

		//Enter the size of the LinkedList
		System.out.println("Enter the size of the Linked List");
		System.out.println(" ");

		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();

		//Enter the elements in Preorder
		System.out.println("Enter the elements in Preorder");
		System.out.println(" ");

		int i = 0;
		while (i != size) {
			list.add(scan.nextInt());
			i++;
		}
		scan.close();
		// Constructing tree from linked list
		System.out.println("Inorder traversal");
		//Call the function to create Binary search tree
		BSTnode<Integer> rootlist = buildBST(list);
		//To display the inorder traversal for verification
		inorder(rootlist);
	}
}
