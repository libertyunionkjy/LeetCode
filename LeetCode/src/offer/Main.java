package offer;

import offer.FindNumberIn2DArray;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {};
        int target = 30;
        FindNumberIn2DArray solution = new FindNumberIn2DArray();
        System.out.println(solution.findNumberIn2DArray(matrix,target));
        //System.out.println("行数:"+matrix.length);
    }
}
