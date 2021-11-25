package competitive.leetcode.med.backtrack;

public class WordSearch {

	char[][] board;
	boolean[][] visited;
	String word;
	int rows;
	int cols;
	private boolean search(int r, int c, int start) {
		if (start == word.length()) return true;
		if (r<0 || r==rows || c<0 || c==cols) return false;
		if (visited[r][c]) return false;
		if (start >= word.length() || board[r][c] != word.charAt(start)) return false;
		visited[r][c] = true;
		boolean result =
			search(r-1, c, start+1) ||
			search(r+1, c, start+1) ||
			search(r, c-1, start+1) ||
			search(r, c+1, start+1);
		visited[r][c] = false;
		return result;
	}
	
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.rows = this.board.length;
        this.cols = this.board[0].length;
        this.visited = new boolean[rows][cols];
        for (int r=0; r<rows; r++)
        	for (int c=0; c<cols; c++) {
        		if (search(r, c, 0)) return true;
        	}
        return false;
    }
    
    public static void main(String[] args) {
    	char[][] board = new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
    	String word = "ABCB";
		System.out.println(new WordSearch().exist(board, word));
	}
}
