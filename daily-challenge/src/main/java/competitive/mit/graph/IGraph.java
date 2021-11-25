package competitive.mit.graph;

import java.util.List;
import java.util.Set;

public interface IGraph<K, A, W> {

	public class Node<K, A> {
		public final K id;
		public A property;
		
		public Node(K id) {
			this.id = id;
		}
	}
	
	public class Edge<N extends Node<?,?>, W> {
		public final N to;
		public final W weight;
		
		public Edge(N to, W weight) {
			this.to = to;
			this.weight = weight;
		}
	}
	
	Node<K, A> addOrGetNode(K id);
	
	void addEdge(Node<K, A> from, Node<K, A> to, W weight);
	
	List<Edge<Node<K, A>, W>> getNeighbors(Node<K, A> node);
	
	Set<K> getNodes();
	
}
