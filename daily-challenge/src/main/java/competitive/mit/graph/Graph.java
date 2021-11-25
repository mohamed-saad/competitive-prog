package competitive.mit.graph;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Graph<K, A, W> implements IGraph<K, A, W> {
	
	private Map<K, Node<K,A>> keysToNodes = new HashMap<>();
	private Map<Node<K,A>, List<Edge<Node<K,A>, W>>> adjList = new HashMap<>();

	@Override
	public IGraph.Node<K, A> addOrGetNode(K id) {
		return keysToNodes.computeIfAbsent(id, i -> new Node<>(i));
	}

	@Override
	public void addEdge(IGraph.Node<K, A> from, Node<K, A> to, W weight) {
		adjList.computeIfAbsent(from, f -> new LinkedList<>()).add(new Edge<>(to, weight));		
	}

	@Override
	public List<IGraph.Edge<IGraph.Node<K, A>, W>> getNeighbors(IGraph.Node<K, A> node) {
		return adjList.getOrDefault(node, Collections.emptyList());
	}

	@Override
	public Set<K> getNodes() {
		return keysToNodes.keySet();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (Entry<Node<K, A>, List<Edge<Node<K, A>, W>>> entry: adjList.entrySet()) {
			for (Edge<Node<K, A>, W> e: entry.getValue()) {
				builder.append(entry.getKey().id)
					.append("---(").append(e.weight).append(")---->")
					.append(e.to.id).append("\n");
			}
		}
		return builder.toString();
	}

	
}
