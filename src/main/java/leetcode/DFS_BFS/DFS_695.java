package leetcode.DFS_BFS;

import javax.management.Query;
import java.util.LinkedList;
import java.util.Queue;

public class DFS_695 {
    static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public static int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int [][]visited = new int[grid.length][grid[0].length];

        for(int i=0; i< grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1&&visited[i][j]==0){
                    int count = BFS(grid, visited, i, j, 0);
                    max=Math.max(max, count);
                }
            }
        }
        return max;
    }

    private static int BFS(int[][] grid, int[][] visited, int x, int y, int count){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y]=1;
        count++;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size;i++){
                int[] cur = q.poll();
                for(int k=0; k<4; k++){
                    int nextX = cur[0]+dirs[k][0];
                    int nextY = cur[1]+dirs[k][1];
                    if(nextX>=0&&nextX<grid.length&&nextY>=0&&nextY<grid[0].length&&visited[nextX][nextY]==0){
                        if(grid[nextX][nextY]==1){
                            q.offer(new int[]{nextX, nextY});
                            count++;
                            visited[nextX][nextY]=1;
                        }

                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
       int maxNum =  maxAreaOfIsland(new int[][]{{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}});
    }
}
