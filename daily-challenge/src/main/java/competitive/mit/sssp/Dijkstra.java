package competitive.mit.sssp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import competitive.mit.graph.Graph;
import competitive.mit.graph.IGraph;
import competitive.mit.graph.IGraph.Edge;
import competitive.mit.graph.IGraph.Node;

public class Dijkstra implements ShortestPath {

	@Override
	public Map<Character, Integer> shortestPath(Character from, List<String> edges) {
		
		IGraph<Character, Boolean, Integer> graph = new Graph<>();
		for (String edge: edges) {
			String[] parts = edge.split(",");
			graph.addEdge(graph.addOrGetNode(parts[0].charAt(0)), graph.addOrGetNode(parts[2].charAt(0)), Integer.parseInt(parts[1]));
		}

		Map<Character, Integer> shortestPath = new HashMap<>();
		shortestPath.put(from, 0);
		
		Set<Character> processing = new HashSet<>();
		processing.add(from);
		
		while(!processing.isEmpty()) {
			Node<Character, Boolean> nearest = graph.addOrGetNode(findNearest(processing, shortestPath));
			processing.remove(nearest.id);
			Integer spn = shortestPath.get(nearest.id);
			for (Edge<Node<Character, Boolean>, Integer> edge: graph.getNeighbors(nearest)) {
				if (edge.to.property != null && edge.to.property) continue;
				Integer sp = shortestPath.get(edge.to.id);
				if (sp == null || spn + edge.weight < sp) {
					shortestPath.put(edge.to.id, spn + edge.weight);
					processing.add(edge.to.id);
				}
			}
			nearest.property = true;
		}
		
		return shortestPath;
	}

	private Character findNearest(Set<Character> processing, Map<Character, Integer> shortestPath) {
		int nearest = Integer.MAX_VALUE;
		Character nodeId = null;
		for (Character c: processing) {
			Integer p = shortestPath.get(c);
			if (p != null && p < nearest) {
				nearest = p;
				nodeId = c;
			}
		}
		return nodeId;
	}

}
