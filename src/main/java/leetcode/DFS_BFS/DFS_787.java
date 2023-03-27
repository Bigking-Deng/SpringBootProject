package leetcode.DFS_BFS;

import java.util.*;

public class DFS_787 {
    static int minPrice;
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        minPrice=Integer.MAX_VALUE;
        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int[] flight: flights){
            if(!map.containsKey(flight[0])) map.put(flight[0], new ArrayList<>());
            List<int[]> list = map.get(flight[0]);
            list.add(new int[]{flight[1], flight[2]});
        }
        DFS(map, new ArrayList<>(), 0, src, dst, 0, k);
        if(minPrice==Integer.MAX_VALUE) return -1;
        return minPrice;
    }

    private static void DFS(Map<Integer, List<int[]>> map, List<Integer> path, int num, int currentCity, int target, int cost, int k){
        if(num>k+1) return;
        if(num<=k+1&&currentCity==target){
            minPrice=Math.min(minPrice, cost);
        }
        path.add(currentCity);
        List<int[]> list = map.getOrDefault(currentCity, new ArrayList<>());
        for(int[] dest:list){
            if(!path.contains(dest[0])&&cost+dest[1]<minPrice){
                DFS(map, path, num+1, dest[0], target, cost+dest[1], k);
            }
        }
        path.remove(path.size()-1);
    }

//    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K)
//    {
//        Map<Integer,List<int[]>> map=new HashMap<>();
//        for(int[] i:flights)
//        {
//            map.putIfAbsent(i[0],new ArrayList<>());
//            map.get(i[0]).add(new int[]{i[1],i[2]});
//        }
//        int step=0;
//        Queue<int[]> q=new LinkedList<>();
//        q.offer(new int[]{src,0});
//        int ans=Integer.MAX_VALUE;
//        while(!q.isEmpty())
//        {
//            int size=q.size();
//            for(int i=0;i<size;i++)
//            {
//                int[] curr=q.poll();
//                if(curr[0]==dst)
//                    ans=Math.min(ans,curr[1]);
//                if(!map.containsKey(curr[0]))
//                    continue;
//                for(int[] f:map.get(curr[0]))
//                {
//                    if(curr[1]+f[1]>ans)      //Pruning
//                        continue;
//                    q.offer(new int[]{f[0],curr[1]+f[1]});
//                }
//            }
//            if(step++>K)
//                break;
//        }
//        return ans==Integer.MAX_VALUE?-1:ans;
//    }

    public static void main(String[] args) {
        findCheapestPrice(4, new int[][]{{0,1,100}, {1,2,100}, {2,0,100}, {1,3,600}, {2,3,200}}, 0, 3, 1);
    }
}
