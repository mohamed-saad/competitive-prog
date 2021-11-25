package competitive.mit.sssp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BallmanFordDP implements ShortestPath {

	private static final int INFINIT = 1000000;
	
	private Map<String, Integer> memo = new HashMap<>();
	private int calls = 0;
	
	private class Edge {
		Character c;
		int weight;
		
		Edge(Character c, int weight) {
			this.c = c;
			this.weight = weight;
		}
	}
	
	private int shortestPath(Character from, Character to, Map<Character, List<Edge>> adj, int maxEdges) {
		if (maxEdges == -1) return INFINIT;
		String key = from + "-" + to;
		Integer m = memo.get(key);
		if (m != null) return m;
		calls++;
		if (from == to) return 0;
		List<Edge> n = adj.get(to);
		if (n == null) return INFINIT;
		int min = INFINIT;
		for (Edge e: n) {
			int path = shortestPath(from, e.c, adj, maxEdges-1) + e.weight;
			if (path < min)
				min = path;
		}
		memo.put(key, min);
		return min;
	}
	
	@Override
	public Map<Character, Integer> shortestPath(Character from, List<String> edges) {
		
		Map<Character, List<Edge>> adj = new HashMap<>();
		Set<Character> nodes = new HashSet<>();
		for (String edge: edges) {
			String[] parts = edge.split(",");
			Character f = parts[0].charAt(0); 
			Character t = parts[2].charAt(0);
			nodes.add(f);
			nodes.add(t);
			Integer w = Integer.parseInt(parts[1]);
			adj.computeIfAbsent(t, k -> new LinkedList<>()).add(new Edge(f, w));
		}
		
		Map<Character, Integer> shortestPath = new HashMap<>();
		for (Character n: nodes) {
			shortestPath.put(n, shortestPath(from, n, adj, nodes.size()-1));
		}
		
		System.out.println("Calls: " + calls);
		
		return shortestPath;
	}

}
