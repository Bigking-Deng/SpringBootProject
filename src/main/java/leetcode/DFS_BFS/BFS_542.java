package leetcode.DFS_BFS;

import java.util.*;

public class BFS_542 {
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int[][] updateMatrix(int[][] mat) {
        int[][] res = new int[mat.length][mat[0].length];
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j]==0) res[i][j]=0;
                else res[i][j]=findMinOne(mat, i, j);
            }
        }
        return res;
    }

    private static int findMinOne(int[][] mat, int x, int y){
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(x+" "+y);
        q.offer(String.valueOf(x+" "+y));
        int step = 0;
        while(!q.isEmpty()){
            step++;
            int size = q.size();
            for(int ct=0; ct<size; ct++){
                String cur = q.poll();
                int curX = Integer.valueOf(cur.split(" ")[0]);
                int curY = Integer.valueOf(cur.split(" ")[1]);
                for(int i=0; i<=3; i++){
                    int nextX = curX+dirs[i][0];
                    int nextY = curY+dirs[i][1];
                    if(nextX>=0&&nextX<mat.length&&nextY>=0&&nextY<mat[0].length&&!visited.contains(nextX+" "+nextY)){
                        if(mat[nextX][nextY]==0){
                            return step;
                        }
                        q.offer(String.valueOf(nextX+" "+nextY));
                        visited.add(nextX+" "+nextY);
                    }
                }
            }
        }
        return step;
    }





            public int[][] updateMatrix2(int[][] matrix) {
                int m = matrix.length, n = matrix[0].length;
                int[][] dist = new int[m][n];
                boolean[][] seen = new boolean[m][n];
                Queue<int[]> queue = new LinkedList<int[]>();
                // 将所有的 0 添加进初始队列中
                for (int i = 0; i < m; ++i) {
                    for (int j = 0; j < n; ++j) {
                        if (matrix[i][j] == 0) {
                            queue.offer(new int[]{i, j});
                            seen[i][j] = true;
                        }
                    }
                }

                // 广度优先搜索
                while (!queue.isEmpty()) {
                    int[] cell = queue.poll();
                    int i = cell[0], j = cell[1];
                    for (int d = 0; d < 4; ++d) {
                        int ni = i + dirs[d][0];
                        int nj = j + dirs[d][1];
                        if (ni >= 0 && ni < m && nj >= 0 && nj < n && !seen[ni][nj]) {
                            dist[ni][nj] = dist[i][j] + 1;
                            queue.offer(new int[]{ni, nj});
                            seen[ni][nj] = true;
                        }
                    }
                }

                return dist;
            }


  
}


