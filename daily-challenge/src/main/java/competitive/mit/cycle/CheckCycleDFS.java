package competitive.mit.cycle;

import java.util.LinkedList;
import java.util.List;

public class CheckCycleDFS implements CheckCycle {

	private List<Integer>[] adjList;
	
	private boolean dfs(int node, boolean[] visited, boolean[] seen) {
		if (visited[node]) return false;
		if (seen[node]) return true;
		visited[node] = true;
		seen[node] = true;
		for (Integer n: adjList[node]) {
			if (dfs(n, visited, seen)) return true;
		}
		seen[node] = false;
		return false;
	}
	
	
	@Override
	public boolean hasCycle(String[] edges, int nodesCount) {
		
		adjList = new List[nodesCount];
		for (int i=0; i<nodesCount; i++)
			adjList[i] = new LinkedList<Integer>();
		
		for(String e: edges) {
			String[] pair = e.split("-");
			adjList[Integer.parseInt(pair[0])].add(Integer.parseInt(pair[1]));
			adjList[Integer.parseInt(pair[1])].add(Integer.parseInt(pair[0]));
		}

		boolean[] visited = new boolean[nodesCount];
		boolean[] seen = new boolean[nodesCount];

		for (int i=0; i<nodesCount; i++) {
			if (!visited[i] && dfs(i, visited, seen)) return true;
		}
		
		return false;
	}
	
	
}
