package competitive.mit.diconnected;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DisconnectedDFS implements Disconnected{

	private Map<Character, List<Character>> adjList = new HashMap<>();
	private Map<Character, Integer> visited = new HashMap<>();

	private void dfs(Character start, int color) {
		if (visited.containsKey(start)) return;
		visited.put(start, color);
		List<Character> neighbors = adjList.get(start);
		if (neighbors == null) return;
		for (Character n: neighbors) {
			dfs(n, color);
		}
	}
	
	@Override
	public  Map<Character, Integer> islands(String[] edges) {
		Set<Character> nodes = new HashSet<>();
		for (String edge: edges) {
			nodes.add(edge.charAt(0));
			nodes.add(edge.charAt(2));
			adjList.computeIfAbsent(edge.charAt(0), k -> new LinkedList<>()).add(edge.charAt(2));
		}
		
		int color = 0;
		for (Character node: nodes) {
			if (!visited.containsKey(node)) {
				dfs(node, color);
				color++;				
			}
		}
		
		return visited;
	}

}
