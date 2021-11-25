package competitive.mit.topolocical;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import competitive.mit.graph.Graph;
import competitive.mit.graph.IGraph;
import competitive.mit.graph.IGraph.Edge;
import competitive.mit.graph.IGraph.Node;

public class TopologicalImpl implements Topological{

	@Override
	public List<Character> sort(String[] edges) {
		
		IGraph<Character, Boolean, Integer> graph = new Graph<>();
		
		for (String edge: edges)  {
			String[] parts = edge.split(",");
			graph.addEdge(graph.addOrGetNode(parts[0].charAt(0)), graph.addOrGetNode(parts[2].charAt(0)), Integer.parseInt(parts[1]));
		}
		
		List<Character> order = new LinkedList<>();

		Deque<Object[]> stack = new LinkedList<>();
		for (Character from: graph.getNodes()) {
			stack.push(new Object[] { graph.addOrGetNode(from), false});
			while(!stack.isEmpty()) {
				Object[] o = stack.pop();
				Node<Character, Boolean> node = (Node<Character, Boolean>) o[0];
				Boolean parent = (Boolean)o[1];
				if (parent != null && parent) {
					order.add(node.id);
					continue;
				}
				if (node.property != null && node.property) continue;
				node.property = true;
				stack.push(new Object[] { node, true } );
				for (Edge<Node<Character, Boolean>, Integer> edge: graph.getNeighbors(node)) {
					if (edge.to.property == null || !edge.to.property) 
						stack.push(new Object[] { edge.to, false });
				}
			}
		}
		
		return order;
	}

}
