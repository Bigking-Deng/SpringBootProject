package leetcode.DFS_BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DFS_210 {
//    public int[] findOrder(int numCourses, int[][] prerequisites) {
//        // build graph & init graph
//        List<List<Integer>> graph = buildGraph(numCourses, prerequisites);
//
//        // start w/ any node
//        boolean[] visited = new boolean[numCourses];
//        boolean[] onPath = new boolean[numCourses];
//
//        List<Integer> order = new ArrayList<>();
//
//        for (int i = 0; i < numCourses; i++) {
//            if (visited[i]) continue;
//            boolean cycle = dfs(i, graph, visited, onPath, order);
//            if (cycle) return new int[0];
//        }
//
//        // list to int[]
//        int[] res = new int[order.size()];
//        for (int i = 0; i < res.length; i++) {
//            res[i] = order.get(i);
//        }
//        return res;
//    }
//
//    private List<List<Integer>> buildGraph(int numCourses, int[][] prerequisites) {
//        List<List<Integer>> graph = new ArrayList<>();
//        for (int i = 0; i < numCourses; i++) {
//            graph.add(new ArrayList<>());
//        }
//
//        for (int[] preq : prerequisites) {
//            graph.get(preq[1]).add(preq[0]);
//        }
//        return graph;
//    }
//
//    private boolean dfs(int course, List<List<Integer>> graph, boolean[] visited, boolean[] onPath, List<Integer> order) {
//        if (visited[course]) return false; // node visited
//        visited[course] = true;
//        onPath[course] = true;
//
//        for (int neighbor : graph.get(course)) {
//            if (onPath[neighbor]) return true; // cycle detected
//            boolean cycle = dfs(neighbor, graph, visited, onPath, order);
//            if (cycle) return true;
//        }
//
//        order.add(0, course);
//        // remove from onPath
//        onPath[course] = false;
//
//        return false;
//    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses<=0) return new int[]{};
        int[] result=new int[numCourses];
        Map<Integer, List<Integer>> courseMap = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        int[] visited = new int[numCourses];
        for(int i=0; i<prerequisites.length; i++){
            int[] curPairs = prerequisites[i];
            if(!courseMap.containsKey(curPairs[1])){
                courseMap.put(curPairs[1], new ArrayList<Integer>());
            }
            List<Integer> tmp  = courseMap.get(curPairs[1]);
            tmp.add(curPairs[0]);
            courseMap.put(curPairs[1], tmp);
        }
        for(int course=0; course<numCourses; course++){
            if(!courseTravel(courseMap, new ArrayList<>(), res, visited, course)) return new int[]{};
        }
        for(int i=0; i<numCourses; i++){
            result[i]=res.get(i);
        }
        return result;
    }

    private static boolean courseTravel(Map<Integer, List<Integer>> courseMap, List<Integer> curPath, List<Integer> res, int[] visited, int course){
        if(curPath.contains(course)) return false;
        if(visited[course]==1) return true;
        visited[course]=1;
        curPath.add(course);
        List<Integer> neighbours = courseMap.getOrDefault(course, new ArrayList<>());
        for(int nei:neighbours){
            if(!courseTravel(courseMap, curPath, res, visited, nei)){
                return false;
            }
        }
        res.add(0, course);
        curPath.remove(curPath.size()-1);
        return true;
    }

    public static void main(String[] args) {
        findOrder(3, new int[][]{{0,1}});
    }
}
