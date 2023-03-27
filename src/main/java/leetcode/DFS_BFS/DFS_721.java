package leetcode.DFS_BFS;

import java.util.ArrayList;
import java.util.List;

public class DFS_721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int[] visited = new int[accounts.size()];
        List<List<String>> list = new ArrayList<>();
        for(int i=0; i<accounts.size(); i++){
            if(visited[i]==0){
                List<String> res = new ArrayList<>();
                DFS(res, accounts, visited, i);
                res.sort((a,b)->a.compareTo(b));
                res.add(0, accounts.get(i).get(0));
                list.add(res);
            }
        }
        return list;
    }

    private static void DFS(List<String> res, List<List<String>> accounts, int[] visited,  int curIndex){
        if(visited[curIndex]==1) return;
        List<String> curAccount = accounts.get(curIndex);
        visited[curIndex]=1;
        String name = curAccount.get(0);
        for(int i=1; i<curAccount.size(); i++){
            String email = curAccount.get(i);
            if(!res.contains(email)){
                res.add(email);
                for(int j=0; j<accounts.size(); j++){
                    if(visited[j]==0&&accounts.get(j).contains(email)){
                        DFS(res, accounts, visited, j);
                    }
                }
            }
        }
    }
}
