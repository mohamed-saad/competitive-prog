package competitive.mit.topolocical;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TopologicalImplRecursive implements Topological {

	private Map<Character, List<Character>> adjList = new HashMap<>();
	private Set<Character> visited = new HashSet<>();
	
	private void dfs(Character node, List<Character> finishOrder) {
		if (visited.contains(node)) return;
		visited.add(node);
		List<Character> neighbours = adjList.get(node);
		if (neighbours != null) {
			for (Character n: neighbours)
				dfs(n, finishOrder);
		}
		finishOrder.add(node);
	}
	
	@Override
	public List<Character> sort(String[] edges) {
		
		Set<Character> nodes = new HashSet<>();
		for (String edge: edges) {
			String[] parts = edge.split(",");
			Character from = parts[0].charAt(0);
			Character to = parts[2].charAt(0);
			nodes.add(from);
			nodes.add(to);
			adjList.computeIfAbsent(from, k -> new LinkedList<>()).add(to);
		}
		
		List<Character> finishOrder = new LinkedList<>();
		for (Character n: nodes) 
			dfs(n, finishOrder);
		
		return finishOrder;
	}

}
