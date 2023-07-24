package leetcode.DFS_BFS;

import java.util.*;

public class DFS_37 {
    static Map<Integer, Set<Integer>> row = new HashMap<>();
    static Map<Integer, Set<Integer>> col = new HashMap<>();
    static Map<Integer, Set<Integer>> block = new HashMap<>();

    public static String[][] solveSuduku(String[][] matrix){
        String[][] cur= new String[matrix.length][matrix[0].length];
        String[][] res= new String[matrix.length][matrix[0].length];
        for(Integer num = 0; num <= 8; num++ ){
            row.put(num, new HashSet<>());
            col.put(num, new HashSet<>());
            block.put(num, new HashSet<>());
        }
        int pos = 0;
        DFS(0, matrix, cur, res);
        return res;
    }

    private static void DFS(int pos, String[][] matrix, String[][] cur, String[][] res){
        if(pos>=81){
            for(int i=0; i<matrix.length; i++){
                for(int j=0; j<matrix[0].length; j++){
                    res[i][j] = cur[i][j];
                }
            }
            return;
        }
        int x_index = pos/9;
        int y_index = pos%9;
        int x_block = x_index/3;
        int y_block = y_index/3;
        int blockNum = x_block*3+y_block;
        Set<Integer> rowSet = row.get(x_index);
        Set<Integer> colSet = col.get(y_index);
        Set<Integer> blockSet = block.get(blockNum);
        if(!matrix[x_index][y_index].equals(".")){
            Integer curNum = Integer.valueOf(matrix[x_index][y_index]);
            rowSet.add(curNum);
            colSet.add(curNum);
            blockSet.add(curNum);
            cur[x_index][y_index] = matrix[x_index][y_index];
            DFS(pos+1, matrix, cur, res);
        }else {
            for(Integer num = 1; num <= 9; num++){
                if(rowSet.contains(num) || colSet.contains(num) || blockSet.contains(num)){
                   continue;
                }
                rowSet.add(num);
                colSet.add(num);
                blockSet.add(num);
                cur[x_index][y_index] = String.valueOf(num);
                DFS(pos+1, matrix, cur, res);
                cur[x_index][y_index] = ".";
                rowSet.remove(num);
                colSet.remove(num);
                blockSet.remove(num);
                
            }
        }
       

    }
    public static void main(String[] args) {
        String[][] matrix = new String[][]{{"5","3",".",".","7",".",".",".","."},{"6",".",".","1","9","5",".",".","."},{".","9","8",".",".",".",".","6","."},{"8",".",".",".","6",".",".",".","3"},{"4",".",".","8",".","3",".",".","1"},{"7",".",".",".","2",".",".",".","6"},{".","6",".",".",".",".","2","8","."},{".",".",".","4","1","9",".",".","5"},{".",".",".",".","8",".",".","7","9"}};
        String[][] res = DFS_37.solveSuduku(matrix);
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }


//        Map<int[], String> map = new HashMap<>();
//        List<int[]> list = new ArrayList<>();
//        int[][] emp = new int[][]{{1,1},{2,2},{3,3}};
//        for(int i=0; i<emp.length; i++){
//            map.put(emp[i], "s");
//            list.add(emp[i]);
//        }
//        int[] k = new int[]{2,2};
//        Object object = new Object();
//        object.equals(new Object());
//        String s = new String();
//        s.equals("");
//        Integer e = 5;
//        Integer ee = 5;
//        boolean dd = e.equals(ee);
//        boolean exist = map.containsKey(k);
//        boolean exist1 = list.contains(k);
//        list.remove(k);
//
//
//        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4));
//        list1.remove(3);
//        list1.remove(Integer.valueOf(3));

    }
}
