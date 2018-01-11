package graph;

public class InfectedComputers {
	public static void main(String args[]) {
		// using DFS
		int M[][]= 
			{ {0,0,0,0,0,0,0,0},
			  {0,1,0,1,0,0,0,0},
			  {0,0,0,1,0,0,0,0},
			  {0,1,0,0,1,0,0,0},
			  {0,0,0,1,0,0,1,0},
			  {0,0,0,0,1,0,0,0},
			  {0,0,0,0,1,0,0,1},
			  {0,1,0,0,0,0,0,0}
		    };
		
		// to maintain visited computers which are not infected i.e. 0
		boolean visited[][] = new boolean[M.length][M[0].length];
		
		// visit all healthy computers
		for(int i = 0; i < M.length; i++) {
			for(int j = 0; j < M[0].length; j++) {
				// if computer is infected do nothing
				if(M[i][j] == 1) {
					continue;
				} else {
				// if computer is not infected do DFS to check if it can be infected
					dfs(M, i, j, visited);
				}
			}
		}
		
		// print result
		for(int i = 0; i < M.length; i++) {
			for(int j = 0; j < M[0].length; j++) {
				System.out.print(M[i][j]);
			}
			System.out.println();
		}
		

	}

	// method to check whether computer is infected
	public static boolean isInfected(int[][] mat, int row, int col) {
		return row >= 0 && col >= 0 && row < mat.length 
				&& col < mat[0].length && mat[row][col] == 1;
	}
	
	// using DFS
	public static void dfs(int[][] mat, int row, int col, boolean visited[][]) {
		// positions (0,-1), (0,1), (1,0) and (-1,0) which represents vertical and horizontal adjacent comps
		int r[] = {0, 0, 1, -1};
		int c[] = {-1, 1, 0, 0};
		
		// constant to store adjacent infected comps
		int infectCnt = 0;
		// traverse all up, down, left, right
		for(int i = 0; i < 4; ++i) {
			if(isInfected(mat, row+r[i], col+c[i])) {
				infectCnt++;
			}
		}
		
		// if more than 2 neighbors infected then infect current comp and do DFS on all its adjacent comps
		if(infectCnt >= 2) {
			mat[row][col] = 1;
			visited[row][col] = true;
			for(int i = 0; i < 4; ++i) {
				int newRow = row+r[i];
				int newCol = col+c[i];
				if(newRow >= 0 && newCol >= 0 && newRow < mat.length 
						&& newCol < mat[0].length && mat[newRow][newCol] == 0 && !visited[newRow][newCol])
				dfs(mat, newRow, newCol, visited);
			}
		}
	}
}
