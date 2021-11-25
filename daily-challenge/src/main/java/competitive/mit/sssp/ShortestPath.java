package competitive.mit.sssp;

import java.util.List;
import java.util.Map;

public interface ShortestPath {
	
	Map<Character, Integer> shortestPath(Character from, List<String> edges);

}
