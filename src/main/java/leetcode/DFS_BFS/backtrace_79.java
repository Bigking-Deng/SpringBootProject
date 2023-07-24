package leetcode.DFS_BFS;

public class backtrace_79 {
    public static final int[] dir1 = {1,-1,0,0};
    public static final int[] dir2 = {0,0,-1,1};

    private static boolean isExist(char[][] board, String word){
        int index = 0;
        boolean [][] flag = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(startWith(i, j, board, word, index, flag)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean startWith(int row, int col, char[][] board, String word, int index, boolean[][] flag){
        if(index == word.length()){
            return true;
        }
        if(board[row][col]==word.toLowerCase().charAt(index)&& flag[row][col] == false){
            flag[row][col] = true;
            for(int k = 0; k<=3; k++){
                if((row+dir1[k]>=0&&row+dir1[k]<board.length)&&(col+dir2[k]>=0&&col+dir2[k]<board[0].length)){
                    if(startWith(row+dir1[k], col+dir2[k], board, word, index+1, flag)){
                        return true;
                    }

                }
            }
            flag[row][col] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        char [][]board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        boolean res = isExist(board, "ABCB");
    }
}
