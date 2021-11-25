package competitive.mit.scc;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Kosaraju implements StrongleConnectedComponents {
	
	@Override
	public List<List<Integer>> find(int nodesCount, String[] edges) {
		List<Integer>[] adjList = new List[nodesCount];
		for (int i=0; i<nodesCount; i++) 
			adjList[i] = new LinkedList<>();
		
		for (String edge: edges) {
			String pair[] = edge.split("-");
			Integer from = Integer.parseInt(pair[0]);
			Integer to = Integer.parseInt(pair[1]);
			adjList[from].add(to);
		}
		
		Deque<Integer> finishingOrder = new LinkedList<>();
		boolean[] visited = new boolean[nodesCount];
		for (int i=0; i<nodesCount; i++) {
			if (!visited[i])
				dfs(adjList, i, visited, finishingOrder);
		}
		
		List<Integer>[] adjListTranspose = new List[nodesCount];
		for (int i=0; i<nodesCount; i++) 
			adjListTranspose[i] = new LinkedList<>();
		for (int i=0; i<nodesCount; i++) {
			for (Integer n: adjList[i]) 
				adjListTranspose[n].add(i);
		}
		
		for (int i=0; i<nodesCount; i++)
			visited[i] = false;
		
		List<List<Integer>> allScc = new LinkedList<>();
		while (!finishingOrder.isEmpty()) {
			Integer f = finishingOrder.pop();
			if (!visited[f]) {
				LinkedList<Integer> scc = new LinkedList<>();
				dfs(adjListTranspose, f, visited, scc);
				allScc.add(scc);
			}
		}
		
		return allScc;
	}

	private void dfs(List<Integer>[] adjList, int i, boolean[] visited, Deque<Integer> finishingOrder) {
		visited[i] = true;
		
		for (Integer n: adjList[i]) {
			if (!visited[n]) 
				dfs(adjList, n, visited, finishingOrder);
		}
		
		finishingOrder.push(i);
	}

}
