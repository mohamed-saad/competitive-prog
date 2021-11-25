package competitive.leetcode.easy.array;

public class ValidSudoku {

	private boolean validSquare(char[][] board, int fromRow, int fromCol) {
		boolean[] nums = new boolean[9];
		for (int r = fromRow; r < fromRow + 3; r++) {
			for (int c = fromCol; c < fromCol + 3; c++) {
				if (board[r][c] != '.') {
					int index = board[r][c] - '1';
					if (nums[index])
						return false; // exists before
					nums[index] = true;
				}
			}
		}
		return true;
	}

	public boolean isValidSudoku(char[][] board) {
		boolean[][] numsC = new boolean[9][9];
		boolean[] numsR = new boolean[9];
		for (int r=0; r<9; r++) {
			for (int c=0; c<9; c++) {
				if (board[r][c] != '.') {
					int index = board[r][c] - '1';
					if (numsC[c][index] || numsR[index])
						return false; // exists before
					numsC[c][index] = true;
					numsR[index] = true;
				}
			}
			 for (int i=0; i<9; i++) numsR[i] = false;
		}
		for (int r=0; r<9; r+=3)
			for (int c=0; c<9; c+=3)
				if (!validSquare(board, r, c)) return false;
		return true;
	 }

	public static void main(String[] args) {
		char[][] board = new char[][] { 
//			{ '5', '3', '.', '.', '7', '.', '.', '.', '.' },
//			{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, 
//			{ '.', '9', '8', '.', '.', '.', '.', '6', '.' },
//			{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, 
//			{ '4', '.', '.', '8', '.', '3', '.', '.', '1' },
//			{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, 
//			{ '.', '6', '.', '.', '.', '.', '2', '8', '.' },
//			{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, 
//			{ '.', '.', '.', '.', '8', '.', '.', '7', '9' } 
			
			{ '8', '3', '.', '.', '7', '.', '.', '.', '.' }, 
			{ '6', '.', '.', '1', '9', '5', '.', '.', '.' },
			{ '.', '9', '8', '.', '.', '.', '.', '6', '.' }, 
			{ '8', '.', '.', '.', '6', '.', '.', '.', '3' },
			{ '4', '.', '.', '8', '.', '3', '.', '.', '1' }, 
			{ '7', '.', '.', '.', '2', '.', '.', '.', '6' },
			{ '.', '6', '.', '.', '.', '.', '2', '8', '.' }, 
			{ '.', '.', '.', '4', '1', '9', '.', '.', '5' },
			{ '.', '.', '.', '.', '8', '.', '.', '7', '9' }
		};
		
		System.out.println(new ValidSudoku().isValidSudoku(board));
	}
}
