package leetcode.DFS_BFS;

import java.util.*;

public class BFS_127 {

        public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Queue<String> q = new ArrayDeque<>();
            Set<String> visited = new HashSet<>();
            Set<String> wordSet = new HashSet<>(wordList);
            if(!wordSet.contains(endWord)) return 0;
            int step = 0;
            q.add(beginWord);
            visited.add(beginWord);
            while(!q.isEmpty()){
                int size = q.size();
                step++;
                for(int s=0; s<size; s++){
                    String cur = q.poll();
                    for(int i=0; i<cur.length(); i++){
                        for(char c='a'; c<='z'; c++){
                            if(c==cur.charAt(i)) continue;
                            String next = cur.substring(0,i)+c+cur.substring(i+1);
                            if(next.equals(endWord)) return step+1;
                            if(!visited.contains(next)&&wordSet.contains(next)){
                                q.offer(next);
                                visited.add(next);
                            }
                        }
                    }
                }

            }
            return 0;
        }

    public static void main(String[] args) {
        ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log"));
        //hit->hot->dot->dog->cog
    }
}
