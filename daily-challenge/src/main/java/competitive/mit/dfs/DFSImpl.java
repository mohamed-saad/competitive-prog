package competitive.mit.dfs;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import competitive.mit.graph.Graph;
import competitive.mit.graph.IGraph;
import competitive.mit.graph.IGraph.Edge;
import competitive.mit.graph.IGraph.Node;

public class DFSImpl implements DFS {

	@Override
	public List<Character> dfs(Character from, String[] edges) {
		IGraph<Character, Boolean, Integer> graph = new Graph<>();
		for (String edge: edges) {
			String[] parts = edge.split(",");
			graph.addEdge(graph.addOrGetNode(parts[0].charAt(0)), graph.addOrGetNode(parts[2].charAt(0)), Integer.parseInt(parts[1]));
		}
		
		Deque<Node<Character, Boolean>> stack = new LinkedList<>();
		stack.push(graph.addOrGetNode(from));
		List<Character> order = new LinkedList<>();
		while(!stack.isEmpty()) {
			Node<Character, Boolean> node = stack.pop();
			if (node.property != null && node.property) continue;
			node.property = true;
			order.add(node.id);
			for (Edge<Node<Character, Boolean>, Integer> edge: graph.getNeighbors(node))
				if (edge.to.property == null)
					stack.push(edge.to);
		}
		
		return order;
	}

}
