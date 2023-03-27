package leetcode.DFS_BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DFS_638 {
    static int max;
    public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        max = Integer.MAX_VALUE;
        int length = price.size();
        shoppingDFS2(price, special, needs, length, 0);
//        for(List<Integer> curPackage:special){
//            shoppingDFS(price, special, needs, curPackage, length, 0);
//        }
        return max;
    }

    private static void shoppingDFS(List<Integer> price, List<List<Integer>> special, List<Integer> needs, List<Integer> currentPackage, int length, int curPrice){
        int oldPrice = curPrice;
        for(int j=0; j<length; j++){
            curPrice+=needs.get(j)*price.get(j);
        }
        max=Math.min(max, curPrice);
        for(int i=0; i<length; i++){
            if(needs.get(i)<currentPackage.get(i)){
                return;
            }
        }
        for(int i=0; i<length; i++){
            needs.set(i, needs.get(i)-currentPackage.get(i));
        }
        oldPrice = oldPrice + currentPackage.get(length);
        for(List<Integer> curPackage:special){
            shoppingDFS(price, special, needs, curPackage, length, oldPrice);
        }
        for(int i=0; i<length; i++){
            needs.set(i, needs.get(i)+currentPackage.get(i));
        }

    }


    private static void shoppingDFS2(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int length, int curPrice){
        int flag=0;
        int oldPrice = curPrice;
        for(int j=0; j<length; j++){
            curPrice+=needs.get(j)*price.get(j);
        }
        max=Math.min(max, curPrice);
        for(List<Integer> curPackage:special){
            flag=0;
            for(int i=0; i<length; i++){
                if(needs.get(i)<curPackage.get(i)){
                   flag=1;
                   break;
                }
            }
            if(flag==1) continue;

            for(int i=0; i<length; i++){
                needs.set(i, needs.get(i)-curPackage.get(i));
            }
            shoppingDFS2(price, special, needs, length, oldPrice+curPackage.get(length));
            for(int i=0; i<length; i++){
                needs.set(i, needs.get(i)+curPackage.get(i));
            }
        }
    }

    public static void main(String[] args) {
        shoppingOffers(Arrays.asList(2, 5), Arrays.asList(Arrays.asList(3,0,5), Arrays.asList(1, 2, 10)),Arrays.asList(3,2));
    }
}
