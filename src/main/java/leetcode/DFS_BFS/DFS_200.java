package leetcode.DFS_BFS;

public class DFS_200 {
    static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {
        int [][]visited = new int[grid.length][grid[0].length];
        int num = 0;
        for(int i=0; i< grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]=='1'&&visited[i][j]==0){
                    DFS(grid, i, j, visited);
                    num++;
                }
            }
        }
        return num;
    }

    private static void DFS(char[][] grid, int x, int y, int[][] visited){
        if(x<0||x>=grid.length||y<0||y>=grid[0].length){
            return;
        }
        if(grid[x][y]=='1'&&visited[x][y]==0){
            visited[x][y]=1;
            for(int i=0;i<4;i++){
                DFS(grid, x+dirs[i][0], y+dirs[i][1], visited);
            }
        }
    }
}
