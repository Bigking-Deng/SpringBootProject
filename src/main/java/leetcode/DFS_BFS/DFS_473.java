package leetcode.DFS_BFS;

import java.util.Arrays;

public class DFS_473 {
    public boolean makesquare(int[] matchsticks) {
        int[] edges = new int[4];
        int sum=0;
        for(int i=0; i<matchsticks.length; i++){
            sum+=matchsticks[i];
        }
        if(sum%4!=0) return false;
        Arrays.sort(matchsticks);
        if(DFS(matchsticks, 0, edges, sum/4)) return true;
        else return false;
    }

    private static boolean DFS(int[] matchsticks, int nums, int[] edge, int target){

        if(nums==matchsticks.length) return true;
        int curMatch = matchsticks[nums];
        for(int i=0; i<edge.length; i++){
            if(nums==0&&i>0) break;
            if(i>0&&edge[i]==edge[i-1]) continue;
            if(curMatch+edge[i]>target) continue;
            edge[i]+=curMatch;
            if(DFS(matchsticks, nums+1, edge, target)){
                return true;
            };
            edge[i]-=curMatch;
        }
        return false;
    }
}
