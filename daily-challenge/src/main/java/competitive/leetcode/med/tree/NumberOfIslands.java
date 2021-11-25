package competitive.leetcode.med.tree;

import java.util.HashSet;
import java.util.Set;

public class NumberOfIslands {
	
	private static class SubSet {
		int rank;
		SubSet parent;
		SubSet() {
			this.parent = this;
		}
		void union(SubSet other) {
			SubSet myParent = this.findParent();
			SubSet otherParent = other.findParent();
			if (myParent == otherParent) return;
			
			if (myParent.rank > otherParent.rank) {
				otherParent.parent = myParent;
			} else if (myParent.rank < otherParent.rank) {
				myParent.parent = otherParent;
			} else {
				otherParent.parent = myParent;
				myParent.rank++;
			}
		}
		
		SubSet findParent() {
			if (this.parent == this) return this;
			this.parent = this.parent.findParent();
			return this.parent;
		}
	}
	
    public int numIslands(char[][] grid) {
    	int rows = grid.length;
    	int cols = grid[0].length;
        SubSet[][] islands = new SubSet[rows][cols];
        
        for (int r=0; r<rows; r++) {
        	for (int c=0; c<cols; c++) {
        		if (grid[r][c] == '1') {
        			islands[r][c] = new SubSet();
        			if (r>0 && islands[r-1][c] != null) {
        				islands[r-1][c].union(islands[r][c]);
        			}
        			if (c>0 && islands[r][c-1] != null) {
        				islands[r][c-1].union(islands[r][c]);
        			}
        		}
        	}
        }
        
        Set<SubSet> superIslands = new HashSet<>();
        for (int r=0; r<rows; r++) {
        	for (int c=0; c<cols; c++) {
        		if (islands[r][c] != null) {
        			superIslands.add(islands[r][c].findParent());
        		}
        	}
        }
        
        return superIslands.size();
    }
    
    public static void main(String[] args) {
    	char[][] matrix = new char[][] {
    		 {'1','1','1','1','0'},
    		 {'1','1','0','1','0'},
    		 {'1','1','0','0','0'},
    		 {'0','0','0','0','0'}
    	};
//    	char[][] matrix = new char[][] {
//    		  {'1','1','0','0','0'},
//    		  {'1','1','0','0','0'},
//    		  {'0','0','1','0','0'},
//    		  {'0','0','0','1','1'}
//    	};
//    	char[][] matrix = new char[][] {
//    		{'1','1','1'},
//    		{'0','1','0'},
//    		{'1','1','1'}
//		};
		System.out.println(new NumberOfIslands().numIslands(matrix));
	}
}
