package competitive.mit.mst;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Kruskal implements MinimumSpanningTree {

	private class Edge implements Comparable<Edge> {

		int to;
		int from;
		int weight;
		
		Edge(int f, int t, int w) {
			this.from = f;
			this.to = t;
			this.weight = w;
		}
		
		@Override
		public int compareTo(Edge o) {
			if (!(o instanceof Edge)) return -1;
			Edge other = (Edge)o;
			if (this.weight > other.weight) return 1;
			else if (this.weight < other.weight) return -1;
			return 0;
		}
		
		@Override
		public String toString() {
			return from + "," + weight + "," + to;
		}
		
	}
	
	private class Subset {
		int parent;
		int rank;
		
		Subset(int node) {
			parent = node;
			rank = 0;
		}
	}
	
	@Override
	public List<String> findMinimumSpanningTree(List<String> edges, int nodesCount) {
		Edge[] graph = new Edge[edges.size()];
		int i=0;
		for (String edge: edges) {
			String[] parts = edge.split(",");
			Integer from = Integer.parseInt(parts[0]);
			Integer weight = Integer.parseInt(parts[1]);
			Integer to = Integer.parseInt(parts[2]);
			graph[i++] = new Edge(from, to, weight);
		}
		
		Arrays.sort(graph);
		Subset[] subsets = new Subset[nodesCount]; 
		
		for (int n=0; n<subsets.length; n++) 
			subsets[n] = new Subset(n);
		
		List<String> mst = new LinkedList<String>();
		int connections = 0;
		for (Edge e: graph) {
			int subset1 = findSubset(subsets, e.from);
			int subset2 = findSubset(subsets, e.to);
			if (subset1 != subset2) {
				union(subsets, e.from, e.to);
				connections++;
				mst.add(e.toString());
			}
			if (connections == nodesCount-1) break;
		}
		
		return mst;
	}

	private void union(Subset[] subsets, int from, int to) {
		if(subsets[from].rank > subsets[to].rank) {
			subsets[to].parent = from;
		} else if(subsets[from].rank < subsets[to].rank) {
			subsets[from].parent = to;
		} else {
			subsets[to].parent = from;
			subsets[to].rank++;
		}
	}

	private int findSubset(Subset[] subsets, int from) {
		int parent = subsets[from].parent;
		if (parent == from) return parent;
		int parentFound = findSubset(subsets, parent);
		subsets[from].parent = parentFound;
		return parentFound;
	}

}
