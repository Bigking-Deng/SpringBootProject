package leetcode.DP;

public class DP_62_63 {
    public static int uniquePaths(int m, int n) {

        int[][] pathNum = new int[m][n];
        for(int i = 0; i<m; i++){
            pathNum[i][0] = 1;
        }
        for(int j =0; j<n; j++){
            pathNum[0][j] = 1;
        }
        for(int i = 1; i<m; i++){
            for(int j = 1; j<n; j++){
                pathNum[i][j] = pathNum[i-1][j] + pathNum[i][j-1];
            }
        }
        return pathNum[m-1][n-1];
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] pathNum = new int[m][n];
        for(int i = 0; i<m; i++){
            if(obstacleGrid[i][0]==1){
                break;
            }
            pathNum[i][0] = 1;
        }
        for(int j =0; j<n; j++){
            if(obstacleGrid[0][j]==1){
                break;
            }
            pathNum[0][j] = 1;
        }
        for(int i = 1; i<m; i++){
            for(int j = 1; j<n; j++){
                if(obstacleGrid[i][j]==1){
                    pathNum[i][j] = 0;
                }else{
                    pathNum[i][j] = pathNum[i-1][j] + pathNum[i][j-1];
                }

            }
        }
        return pathNum[m-1][n-1];
    }
}
