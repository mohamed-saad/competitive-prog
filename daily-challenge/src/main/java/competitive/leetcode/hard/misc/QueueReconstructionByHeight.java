package competitive.leetcode.hard.misc;

import java.util.Arrays;
import java.util.PriorityQueue;

public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a1, a2) -> a1[0] - a2[0]);
        for (int[] p: people)
        	queue.add(p);
        int[][] positions = new int[people.length][];
        while (!queue.isEmpty()) {
        	int[] shortest = queue.remove();
        	int position = shortest[1];
        	for (int i=0; i<positions.length; i++) {
        		if (positions[i] == null || positions[i][0] == shortest[0]){ // empty position
        			if (position == 0) {
        				positions[i] = shortest;
        				break;
        			}
        			position--;
        		}
        	}
        }
        return positions;
    }
    
    public static void main(String[] args) {
		System.out.println(Arrays.deepToString(new QueueReconstructionByHeight().reconstructQueue(new int[][] {{7,0}} )));
	}
}
