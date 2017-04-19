package com.robert.dsal.advance.queens8;

public class EightQueen {

	int[] cloumnForRow = { 0, 0, 0, 0, 0, 0, 0, 0 };
	
	int totalResult = 0;

	boolean sameColumn(int col1, int col2) {
		return col1 == col2;
	}

	boolean onDiagonoal(int row1, int col1, int row2, int col2) {
		return Math.abs(row1 - row2) == Math.abs(col1 - col2);
	}

	void putQueen(int row) {
		if (row == 8) {
			totalResult++;
			printBoard();
			return;
		}
		
		for(int col = 0 ; col<8; col++) {
			cloumnForRow[row] = col;
			if(checkBoard(row))
				putQueen(row + 1);
		}
	}

	private boolean checkBoard(int row) {
		for(int i = 0; i < row; i++)
		{
			if(sameColumn(cloumnForRow[i], cloumnForRow[row]) 
					|| onDiagonoal(i, cloumnForRow[i], row,  cloumnForRow[row]))
				return false;
		}
		return true;
	}

	private void printBoard() {
	    System.out.println(" _ _ _ _ _ _ _ _");
		for (int row = 0; row < 8; row++) {
			int col = cloumnForRow[row];
			
			for(int i = 0; i<8; i++)
			{
				if(i != col)
					System.out.print("|_");
				else
					System.out.print("|*");
			}
				
			System.out.println("|");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
	    
	    //TODO Not Done
		EightQueen queen = new EightQueen();
		queen.putQueen(0);
		System.out.println(queen.totalResult);
	}
}
