package leetcode.others;

import java.util.ArrayList;
import java.util.List;

public class simulation_54 {

    public static List<Integer> spiralOrder(int[][] matrix) {
        int[] dirRow = {0,1,0,-1};
        int[] dirCol = {1,0,-1,0};
        List<Integer> res = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int rowSize = matrix.length; int colSize = matrix[0].length;
        int total = rowSize*colSize;
        int row = 0; int col = 0;
        int direction = 0;
        for(int step = 0; step < total; step++){
            res.add(matrix[row][col]);
            visited[row][col]=true;
            int nextRow = row + dirRow[direction];
            int nextCol = col + dirCol[direction];
            if(nextRow<0 || nextRow>=rowSize || nextCol<0 || nextCol>=colSize || visited[nextRow][nextCol]==true){
                direction=(direction+1)%4;
            }
            row+=dirRow[direction];
            col+=dirCol[direction];
        }

        return res;
    }

    public static void main(String[] args) {
        int[][]matrix = {{1,2,3},{4,5,6},{7,8,9}};
        spiralOrder(matrix);
    }
}
