package leetcode.DP;

public class DP_85 {

    //此题这种方法的思想是利用DP推出每个点所能有的向上和向左最大的连续1的个数，得到这两个值后固定一条边，
    //再在这条边上遍历得到另一维的最小值然后相乘得到以此点为右下角可以得到的矩形面积，因为不像221题正方形
    //可以递推出正方形面积，这里只能先拆成两条边然后再递推边之间的关系最后还原成面积，借用了221题的DP思想
    //https://leetcode.cn/problems/maximal-rectangle/solution/java-by-msang-tel-7f51/
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length==0)
            return 0;
        int[][] dpRow=new int[matrix.length+1][matrix[0].length+1];
        int[][] dpCol=new int[matrix.length+1][matrix[0].length+1];
        int max=0;
        for (int i=1;i<=matrix.length;i++){
            for (int j=1;j<=matrix[0].length;j++){
                //状态转移
                if (matrix[i-1][j-1]=='1'){
                    dpRow[i][j]=dpRow[i][j-1]+1;
                    dpCol[i][j]=dpCol[i-1][j]+1;
                }

                int minCol=dpCol[i][j];
                //以该点为右下顶点，以行为标准向左遍历访问竖边连续长度
                //（以列为标准向上遍历访问横边连续长度也可以）
                for (int r=0;r<dpRow[i][j];r++){
                    if (dpCol[i][j-r]<minCol)
                        minCol=dpCol[i][j-r];
                    //记录保存最大值
                    if (max<minCol*(r+1))
                        max=minCol*(r+1);
                }
            }
        }
        return max;

    }

    public static void main(String[] args) {

    }
}
