package competitive.mit.bst;

import java.util.List;

public interface BST<T extends Comparable<T>> {

	public class Node<T> {
		T value;
		Node<T> left;
		Node<T> right;
		
		public Node(T v) {
			value = v;
		}
	}
	
	void add(T v);
	
	void remove(T v);
	
	List<T> inOrder();
	
	List<T> preOrder();
	
	List<T> postOrder();
	
}
