package competitive.mit.bridge;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Tarjan implements Bridge {

	int timeCounter = 0;
	
	@Override
	public List<String> find(int nodesCount, List<String> edges) {
	
		// build graph
		List<Integer>[] adjList = new List[nodesCount];
		for (int i=0; i<nodesCount; i++) {
			adjList[i] = new LinkedList<>();
		}
		
		for (String e: edges){ 
			String[] pair = e.split("-");
			Integer from = Integer.parseInt(pair[0]);
			Integer to = Integer.parseInt(pair[1]);
			adjList[from].add(to);
			adjList[to].add(from);
		}
		
		boolean[] visited = new boolean[nodesCount];
		List<String> bridges = new LinkedList<>();
		int[] low = new int[nodesCount];
		int[] discovery = new int[nodesCount];
		int[] parent = new int[nodesCount];
		for (int i=0; i<nodesCount; i++) parent[i] = -1;
		
		for (int i=0; i<nodesCount; i++) {
			if (!visited[i])
				dfs(adjList, i, visited, low, discovery, parent, bridges);
		}
		
		System.out.println("low " + Arrays.toString(low));
		System.out.println("dis " + Arrays.toString(discovery));
		
		return bridges;
	}

	private void dfs(List<Integer>[] adjList, int node, 
			boolean[] visited, int[] low, int[] discovery, int[] parent,
			List<String> bridges) {
		
		visited[node] = true;
		
		discovery[node] = timeCounter;
		low[node] = timeCounter;
		
		timeCounter++;

		for (Integer child: adjList[node]) {
			if (!visited[child]) {
				parent[child] = node;
				dfs(adjList, child, visited, low, discovery, parent, bridges);
				low[node] = Math.min(low[child], low[node]);
				
				if (low[child] > discovery[node])
                    bridges.add(child+"-"+node);
			} else if (child != parent[node]) {
				low[node] = Math.min(low[child], low[node]);
			}
		}
		
	}

}
