package competitive.mit.articulation;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Tarjan implements ArticulationPoint {

	int timeCounter = 0;
	
	@Override
	public List<Integer> find(int nodesCount, List<String> edges) {
	
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
		List<Integer> ap = new LinkedList<>();
		int[] low = new int[nodesCount];
		int[] discovery = new int[nodesCount];
		int[] parent = new int[nodesCount];
		for (int i=0; i<nodesCount; i++) parent[i] = -1;
		
		for (int i=0; i<nodesCount; i++) {
			if (!visited[i])
				dfs(adjList, i, visited, low, discovery, parent, ap);
		}
		
		System.out.println("low " + Arrays.toString(low));
		System.out.println("dis " + Arrays.toString(discovery));
		
		return ap;
	}

	private void dfs(List<Integer>[] adjList, int node, 
			boolean[] visited, int[] low, int[] discovery, int[] parent,
			List<Integer> ap) {
		
		visited[node] = true;
		
		discovery[node] = timeCounter;
		low[node] = timeCounter;
		
		timeCounter++;

		int children = 0;
		for (Integer child: adjList[node]) {
			if (!visited[child]) {
				parent[child] = node;
				dfs(adjList, child, visited, low, discovery, parent, ap);
				low[node] = Math.min(low[child], low[node]);
				children++;
				if (parent[node] != -1 && low[child] >= discovery[node])
                    ap.add(node);
			} else if (child != parent[node]) {
				low[node] = Math.min(low[child], low[node]);
			}
		}
		
		if (parent[node] == -1 && children > 1)
			ap.add(node);
	}

}
