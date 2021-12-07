package competitive.leetcode.med.array;

import java.util.Arrays;

public class NonOverlappingIntervals2 {
	
	private static final int START = 0;
	private static final int END = 1;
	
	private static final int INFINITY = 1_000_000;
//	
//	private static Map<String, Integer> memo; 
//	int sol = INFINITY;
//			
	private boolean overlapped(int[][] intervals, boolean[] elements) {
		int[] prev = null;
		for (int i=0; i<intervals.length; i++) {
			if (elements[i]) continue;
			if (prev == null) {
				prev = intervals[i];
			} else {
				if (prev[END] > intervals[i][START]) return true;
				prev = intervals[i];
			}
		}
		return false;
	}
//
//    private int eraseOverlapIntervals(int d, int[][] intervals, boolean[] elements) {
//    	if (d > sol) return INFINITY;
//
//    	String key = Arrays.toString(elements);
//    	Integer m = memo.get(key);
//    	if (m != null) return m;
//
//    	if (!overlapped(intervals, elements)) return 0;
//
//    	int min = INFINITY;
//    	for (int index=0; index<intervals.length; index++) {
//    		if (elements[index]) continue;
//    		
//        	elements[index] = true;
//        	int dropped = 1 + eraseOverlapIntervals(d+1, intervals, elements);
//        	elements[index] = false;
//        	
//        	if (dropped < min)
//        		min = dropped;
//    	}
//    	
//    	System.out.println(sol + "\t" + min + "\t" + key);
//    	
//    	memo.put(key, min);
//    	
//    	if (min + d < sol) {
//    		sol = min + d;
//    	}
//    	
//    	return min;
//    }
//
//    private void filterNonOverlapped(int[][] intervals, boolean[] elements) {
//    	for (int i=0; i<intervals.length-1; i++) {
//			int[] current = intervals[i];
//			int[] next = intervals[i+1];
//			if (current[END] <= next[START]) elements[i] = true;    		
//    	}
//    }

    public int eraseOverlapIntervals(int[][] intervals) {
    	Arrays.sort(intervals, (o1, o2) -> {
    		if (o1[START] > o2[START]) return 1;
    		else if (o1[START] < o2[START]) return -1;
    		return 0;
    	});
    	
    	int[][] intersections = new int[intervals.length][2];
    	for (int i=0; i<intersections.length; i++) 
    		intersections[i][0] = i;
    	
    	for (int i=0; i<intervals.length; i++) {
    		for (int j=i+1; j<intervals.length; j++) {
        		if (intervals[i][END] > intervals[j][START]) {
        			intersections[i][1]++;
        			intersections[j][1]++;
        		}
        	}
    	}
    	
    	Arrays.sort(intersections, (o1, o2) -> o2[1]-o1[1]);
    	
    	boolean[] mask = new boolean[intervals.length];
    	int dropped = 0;
    	
		for (int i=0; overlapped(intervals, mask) && i<intersections.length; i++) {
			mask[intersections[i][0]] = true;
			dropped++;
		}
    	
    	return dropped;
    }
    
    public static void main(String[] args) {
    	int M = 25;
    	int[][] a = new int[M][2];
    	for (int i=0; i<M; i++) {
    		a[i] = new int[] {i,M};
    	}
    	
    	int[][][] tests = {
			a,
    		new int[][] {{-25322,-4602},{-35630,-28832},{-33802,29009},{13393,24550},{-10655,16361},{-2835,10053},{-2290,17156},{1236,14847},{-45022,-1296},{-34574,-1993},{-14129,15626},{3010,14502},{42403,45946},{-22117,13380},{7337,33635},{-38153,27794},{47640,49108},{40578,46264},{-38497,-13790},{-7530,4977},{-29009,43543},{-49069,32526},{21409,43622},{-28569,16493},{-28301,34058}},
			new int[][] {{-52,31},{-73,-26},{82,97},{-65,-11},{-62,-49},{95,99},{58,95},{-31,49},{66,98},{-63,2},{30,47},{-40,-26}},
	    	new int[][] {{1,2},{2,3},{3,4},{1,3}},
	    	new int[][] {{1,2},{2,3},{3,4},{1,3},{2,5}},
	    	new int[][] {{1,2},{1,2},{1,2}},
	    	new int[][] {{1,2},{2,3}},
	    	new int[][] {{1,2}},
	    	new int[][] {{1,10},{2,9},{3,8},{4,7},{5,6}},
    	};
    	for (int[][] intervals: tests) {
    		long start = System.currentTimeMillis();
    		int solution = new NonOverlappingIntervals2().eraseOverlapIntervals(intervals);
    		long end = System.currentTimeMillis();
    		System.out.println(solution + "\t" + (end - start) + "\t" + Arrays.deepToString(intervals));
    	}
	}
}
