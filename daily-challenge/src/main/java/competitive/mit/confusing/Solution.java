package competitive.mit.confusing;

import java.util.HashMap;

public class Solution {
    int limit;
    int [] nums = new int[]{0, 1, 6, 8, 9};
    int count = 0;

    public int confusingNumberII(int N) {
        limit = N;

        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        hm.put(0, 0);
        hm.put(1, 1);
        hm.put(6, 9);
        hm.put(8, 8);
        hm.put(9, 6);

        dfs(0, 0, 1, hm);
        return count;
    }

    private void dfs(long num, long reNum, long base, HashMap<Integer, Integer> hm){
        if(num > limit){
            return;
        }

        if(num != reNum){
            count++;
            System.out.println(num + " --- " + reNum);
        }

        for(int d : nums){
            if(num == 0 && d == 0){
                continue;
            }

            dfs(num * 10 + d, hm.get(d) * base + reNum, base * 10, hm);
        }
    }
    
    public static void main(String[] args) {
		new Solution().confusingNumberII(100);
	}
}