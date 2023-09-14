package leetcode.DFS_BFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DFS_51 {
    static Set<Integer> rowSet = new HashSet<>();
    static Set<Integer> colSet = new HashSet<>();
    static List<List<String>> res = new ArrayList<>();
    public static List<List<String>> solveNQueens(int n) {
        boolean[][] matrix = new boolean[n][n];
        DFS(matrix, n, 0);
        return res;
    }

    public static void DFS(boolean[][] matrix, int remainQ, int pos){
        if(remainQ==0){
            List<String> list = new ArrayList<>();
            for(int i=0; i<matrix.length; i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<matrix[0].length; j++){
                    if(matrix[i][j]==true) sb.append("Q");
                    else sb.append(".");
                }
                list.add(sb.toString());
            }
            res.add(list);
            return;
        }
        if(pos>=matrix.length*matrix.length) return;
        for(int i=pos; i<matrix.length*matrix.length; i++){
            int row=i/matrix.length;
            int col=i%matrix.length;
            if(isValid(matrix, row, col)){
                matrix[row][col]=true;
                rowSet.add(row);
                colSet.add(col);
                DFS(matrix, remainQ-1, i+1);
                rowSet.remove(row);
                colSet.remove(col);
                matrix[row][col]=false;
            }
        }

    }

    public static boolean isValid(boolean[][] matrix, int row, int col){
        if(rowSet.contains(row)||colSet.contains(col)) return false;
        int newRow = row; int newCol = col;
        //判断45度和135度只需判断row小于当前的各自，大于的格子一定还空着还没填）
        while(newRow>=0&&newRow<matrix.length&&newCol>=0&&newCol<matrix[0].length){
            if(matrix[newRow][newCol]==true) return false;
            newRow--; newCol--;
        }
        newRow = row; newCol = col;
        while(newRow>=0&&newRow<matrix.length&&newCol>=0&&newCol<matrix[0].length){
            if(matrix[newRow][newCol]==true) return false;
            newRow--; newCol++;
        }
        return true;
    }

    public static void main(String[] args) {
//        solveNQueens(4);
//        solveNQueens(1);
        solveNQueens(8);
        solveNQueens(2);
    }
}
