package competitive.mit.sssp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import competitive.mit.graph.Graph;
import competitive.mit.graph.IGraph;
import competitive.mit.graph.IGraph.Edge;
import competitive.mit.graph.IGraph.Node;

public class DAGRelaxation implements ShortestPath {

	@Override
	public Map<Character, Integer> shortestPath(Character from, List<String> edges) {
		
		IGraph<Character, Boolean, Integer> graph = new Graph<>();
		for (String edge: edges) {
			String[] parts = edge.split(",");
			graph.addEdge(graph.addOrGetNode(parts[0].charAt(0)), graph.addOrGetNode(parts[2].charAt(0)), Integer.parseInt(parts[1]));
		}
		
		Map<Character, Integer> shortestDistance = new HashMap<Character, Integer>();
		for (Character node: graph.getNodes())
			shortestDistance.put(node, Integer.MAX_VALUE);
		
		shortestDistance.put(from, 0);
		
		for (Character node: graph.getNodes()) {
			int shortestEstimate = shortestDistance.get(node);
			for (Edge<Node<Character, Boolean>, Integer> edge : graph.getNeighbors(graph.addOrGetNode(node))) {
				int shortestEstimateToNeighbor = shortestDistance.get(edge.to.id);
				if (shortestEstimateToNeighbor == Integer.MAX_VALUE || 
						shortestEstimateToNeighbor > shortestEstimate + edge.weight) {
					shortestDistance.put(edge.to.id, shortestEstimate + edge.weight);
				}
			}
		}
		
		return shortestDistance;
	}

}
