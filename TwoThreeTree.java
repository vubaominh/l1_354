// Cre: Dr. Stuart Thiel

package Lecture5_23Tree;

import java.util.*;


public class TwoThreeTree {
	Node root;
		
	public static void main(String[] args) {
		System.out.println("***** Two Three Tree: *****");
		TwoThreeTree cay23 = new TwoThreeTree();
		cay23.add(55);
		System.out.println(cay23.root.toString());
		cay23.add(30);
		System.out.println(cay23.root);
		cay23.add(15);
		System.out.println(cay23.root);
		cay23.add(75);
		System.out.println(cay23.root);
		cay23.add(65);
		System.out.println(cay23.root);
		cay23.add(45);
		System.out.println(cay23.root);
		cay23.add(5);
		System.out.println(cay23.root);
	}
	
	
	/*
	 * This will find where there is a leaf
	 * to add this value and then keo len
	 */
	public void add(Integer val) {
		if(root == null) {root = new Node(val);	} 
		else {root = root.add(val); }
		}
	
}// end of class



//--------------------------------------------------------------
class Node {
	// 2 LLists
	List<Integer> vals = new LinkedList<Integer>();
	List<Node> children = new LinkedList<Node>();

	// Constructors:
	Node(Integer data) {vals.add(data); }
	
	Node(Integer data, Node left, Node right) {
		vals.add(data);
		children.add(left);
		children.add(right); }
	
	
	// Small Method:
	@Override
	public String toString() {return "   " + vals + " " + children; }
	
	// Big Method:
	public Node add(Integer data) {  // Special add()
		if(children.isEmpty() == true) {
			vals.add(data);
			Collections.sort(vals); }
		
		else {
			Node potentiallySplit = null;
			int i = 0;
			// Which child to add to? (the ith child): Ky la
			for(; i < vals.size() && data.compareTo(vals.get(i)) != -1; ++i) { }
			
			// Add to that child and get the returned node, which is potentially promoted
			potentiallySplit = children.get(i).add(data);
			
			// If different, promote + re-integrate: 
			if( children.get(i) != potentiallySplit) {
				// Add a new value at the ith position since something was promoted
				vals.add(i,potentiallySplit.vals.get(0));
				// Remove the old single child
				children.remove(i);
				// Add the two replacement children
				children.addAll(i, potentiallySplit.children);
			    }
		
		  }
		
		// If too big, we need to promote something, 
		// otherwise just return ourself
		return (vals.size() > 2 ? split() : this);   }

	
	//--------------------------------------
	/*
	 * This node has three vals and four children
	 * Promote the middle val to new node with the
	 * appropriate corresponding two children
	 */
	
	private Node split() {
		Node left = null;
		Node right = null;
		
		if(children.isEmpty()) {
			left = new Node(vals.get(0));
			right = new Node(vals.get(2));
			}
		
		else {
			left = new Node(vals.get(0), children.get(0), children.get(1));
			right = new Node(vals.get(2), children.get(2), children.get(3));
			}
		
		Integer toPromote = vals.get(1);
		Node newNode = new Node(toPromote, left, right);
		return newNode;
	}	
	
	
}// end of class
