package leetcode.DFS_BFS;

import java.util.HashMap;
import java.util.Map;

public class DFS_329 {
    static Map<Integer, Integer> map = new HashMap<>();
    static int totalMax = 0;
    static int[] rowStep={-1,1,0,0}; static int[] colStep={0,0,-1,1};
    public static int longestIncreasingPath(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for(int i =0; i<matrix.length; i++){
            for(int j =0; j<matrix[0].length; j++){
                longestPathFrom(matrix, visited, i, j, Integer.MIN_VALUE);
            }
        }
        return totalMax;
    }

    public static int longestPathFrom(int[][] matrix, boolean[][] visited, int row, int col, int prev){
        if( (row<0 || row>= matrix.length || col<0 || col>=matrix[0].length) || matrix[row][col]<=prev || visited[row][col]) return 0;
        if(map.containsKey(row*matrix[0].length+col)){
            return map.get(row*matrix[0].length+col);
        }
        int curMax = 0;
        visited[row][col]=true;
        for(int i=0; i<4; i++){
            int count = longestPathFrom(matrix, visited, row+rowStep[i], col+colStep[i], matrix[row][col]);
            curMax = Math.max(curMax, count);
        }
        map.put(row*matrix[0].length+col, 1+curMax);
        if(1+curMax>totalMax) totalMax=1+curMax;
        visited[row][col]=false;
        return 1+curMax;
    }

    public static void main(String[] args) {
        int[][]matrix = {{9,9,4},{6,6,8},{2,1,1}};
        int[][]matrix1 = {{3,4,5},{3,2,6},{2,2,1}};
        longestIncreasingPath(matrix1);
    }
}
