package leetcode.DFS_BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DFS_207 {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> courseMap = new HashMap<>();
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
        for(int courseNum=0; courseNum<numCourses; courseNum++){
            if(!courseTraversal(new ArrayList<>(), courseNum, courseMap, visited))
                return false;
        }
        return true;
    }

    private static boolean courseTraversal(List<Integer> list, int course, Map<Integer, List<Integer>> courseMap, int[] visited){
        if(list.contains(course)) return false;
        if(visited[course]==1) return true;
        list.add(course);
        List<Integer> nextCourse = courseMap.getOrDefault(course, new ArrayList<>());
        for(int cor:nextCourse){
            if(!courseTraversal(list, cor, courseMap,visited))
                return false;
        }
        list.remove(list.size()-1);
        visited[course]=1;
        return true;
    }

    public static void main(String[] args) {
        canFinish(2,
                new int [][]{{1,0}});
    }
}
