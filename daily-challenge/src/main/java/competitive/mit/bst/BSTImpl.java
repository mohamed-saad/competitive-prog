package competitive.mit.bst;

import java.util.LinkedList;
import java.util.List;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	private Node<T> root;

	@Override
	public void add(T v) {
		if (root == null) {
			root = new Node<T>(v);
		} else {
			Node<T> parent = null;
			Node<T> itr = root;
			boolean left = true;
			while (itr != null) {
				if (v.compareTo(itr.value) > 0) {
					parent = itr;
					itr = itr.right;
					left = false;
				} else if (v.compareTo(itr.value) < 0) {
					parent = itr;
					itr = itr.left;
					left = true;
				} else {
					return; // already exist
				}
			}
			if (left) parent.left = new Node<T>(v);
			else parent.right = new Node<T>(v);
		}
	}

	@Override
	public void remove(T v) {
		Node<T> parent = null;
		Node<T> itr = root;
		boolean left = true;
		while (itr != null) {
			if (v.compareTo(itr.value) == 0) { // found node
				if (itr.left == null && itr.right == null) { // no children
					if (parent == null)  
						root = null; 
					else if (left) 
						parent.left = null;
					else 
						parent.right = null;
				} else if (itr.left == null) { // single child at right
					if (parent == null)  
						root = itr.right; 
					else if (left) 
						parent.left = itr.right;
					else 
						parent.right = itr.right;
				} else if (itr.right == null) { // single child at left
					if (parent == null)  
						root = itr.left; 
					else if (left) 
						parent.left = itr.left;
					else 
						parent.right = itr.left;
				} else { // two children
					
					// left most in right sub-tree
					Node<T> parent2 = itr.right;
					Node<T> itr2 = parent2.left;
					while (itr2.left != null) {
						parent2 = itr2;
						itr2 = itr2.left;
					}

					parent2.left = itr2.right;
					
					if (parent == null)  
						root = itr2;
					else if (left) 
						parent.left = itr2;
					else 
						parent.right = itr2; 
					
					itr2.left = itr.left;
					itr2.right = itr.right;
				}
				return;
			} else if (v.compareTo(itr.value) > 0) {
				parent = itr;
				itr = itr.right;
				left = false;
			} else {
				parent = itr;
				itr = itr.left;
				left = true;
			}
		}
	}
	
	private void inOrder(List<T> traversal, Node<T> node) {
		if (node == null) return;
		inOrder(traversal, node.left);
		traversal.add(node.value);
		inOrder(traversal, node.right);
	}


	@Override
	public List<T> inOrder() {
		List<T> traversal = new LinkedList<>();
		inOrder(traversal, root);
		return traversal;
	}

	@Override
	public List<T> preOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> postOrder() {
		// TODO Auto-generated method stub
		return null;
	}

}
