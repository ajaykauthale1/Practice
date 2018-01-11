package graph;

public class NoOfIslands {
	static int max = 0;
	public static void main(String args[]) {
		// using DFS
		int M[][]= 
			{   {1, 1, 0, 0, 0},
		        {0, 1, 0, 0, 1},
		        {1, 0, 0, 1, 1},
		        {0, 0, 0, 0, 0},
		        {1, 0, 1, 0, 1}
		    };
		
		boolean visited[][] = new boolean[M.length][M[0].length];
		
		int islandCnt = 0;
		int sizeCnt = 0;
		
		for(int i = 0; i < M.length; i++) {
			for(int j = 0; j < M[0].length; j++) {
				if(M[i][j] == 1 && visited[i][j] == false) {
					sizeCnt = 0;
					dfs(M, i, j, visited, sizeCnt);
					islandCnt++;
				}
			}
		}
		
		System.out.println("Total Islands: "+islandCnt+" Maximum Size:"+max);

	}

	public static boolean safeToTraverse(int[][] mat, int row, int col, boolean visited[][]) {
		return row >= 0 && col >= 0 && row < mat.length 
				&& col < mat[0].length && mat[row][col] == 1 && !visited[row][col];
	}
	
	// using DFS
	public static void dfs(int[][] mat, int row, int col, boolean visited[][], int maxIsland) {
		// positions
		int r[] = {-1, 0, 1, -1, 1, -1, 0, 1};
		int c[] = {-1, -1, -1, 0, 0, 1, 1, 1};
		// make node visited
		visited[row][col] = true;
		maxIsland++;
		
		// traverse all up, down, left, right and diagonal
		for(int i = 0; i < 8; ++i) {
			if(safeToTraverse(mat, row+r[i], col+c[i], visited)) {
				dfs(mat, row+r[i], col+c[i], visited, maxIsland);
			}
		}
		
		if(max < maxIsland) {
			max = maxIsland;
		}
	}
}
