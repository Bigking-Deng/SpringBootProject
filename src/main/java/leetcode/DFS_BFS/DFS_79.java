package leetcode.DFS_BFS;

public class DFS_79 {
    static int[] dir1={1,-1,0,0};
    static int[] dir2={0,0,1,-1};
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(hasWord(board, visited, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    public boolean hasWord(char[][] board, boolean[][] visited, String word, int i, int j, int matchPos){
        if(matchPos==word.length()){
            return true;
        }
        if(i<0||i>=board.length||j<0||j>=board[0].length||matchPos>word.length()) return false;
        if(board[i][j]!=word.charAt(matchPos)||visited[i][j]==true) return false;
        visited[i][j]=true;
        for(int index=0; index<4; index++){
            if(hasWord(board, visited, word, i+dir1[index], j+dir2[index], matchPos+1)){
                return true;
            }
        }
        visited[i][j]=false;
        return false;
    }
}
