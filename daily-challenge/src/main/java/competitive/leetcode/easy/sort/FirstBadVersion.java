package competitive.leetcode.easy.sort;

public class FirstBadVersion {
	
	private final int badVersion;
	private int countAPI = 0;
	public FirstBadVersion(int badVersion) {
		this.badVersion = badVersion;
	}

	boolean isBadVersion(int version) {
		countAPI++;
		return version >= badVersion;
	}
	
    public int firstBadVersion(int n) {
    	int from = 1;
    	int to = n;
    	int lastBad = n;
        while (from < to) {
        	int mid = from + (to-from)/2;
        	if (isBadVersion(mid)) {
        		to = mid;
        		lastBad = mid;
        	} else {
        		from = mid + 1;
        	}
        }
        return lastBad;
    }
    

    public static void main(String[] args) {
//    	for (int i=1; i<10; i++) {
//    		for (int b=1; b<=i; b++) {
//    	    	FirstBadVersion v = new FirstBadVersion(b);
//    			if(v.firstBadVersion(i) != b)
//    				System.out.println(b + " in " + i);
//    		}
//    	}
    	
    	FirstBadVersion version = new FirstBadVersion(1);
    	System.out.println(version.firstBadVersion(3));
    	System.out.println(version.countAPI);
	}
}
