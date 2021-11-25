package competitive.mit.bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import competitive.mit.graph.Graph;
import competitive.mit.graph.IGraph;
import competitive.mit.graph.IGraph.Edge;
import competitive.mit.graph.IGraph.Node;

public class BFSImpl implements BFS{

	@Override
	public List<Character> bfs(Character from, String[] edges) {
		IGraph<Character, Boolean, Integer> graph = new Graph<>();
		
		for (String edge: edges) {
			String[] parts = edge.split(",");
			graph.addEdge(
					graph.addOrGetNode(parts[0].charAt(0)), 
					graph.addOrGetNode(parts[2].charAt(0)), 
					Integer.parseInt(parts[1]));
		}
		
		Queue<Node<Character, Boolean>> queue = new LinkedList<>();
		queue.offer(graph.addOrGetNode(from));
		List<Character> order = new LinkedList<>();
		while(!queue.isEmpty()) {
			Node<Character, Boolean> node = queue.poll();
			if (node.property != null && node.property) continue;
			order.add(node.id);
			node.property = true;
			for (Edge<Node<Character, Boolean>, Integer> edge: graph.getNeighbors(node)) {
				if (edge.to.property == null)
					queue.add(edge.to);
			}
		}
		
		return order;
	}

}
