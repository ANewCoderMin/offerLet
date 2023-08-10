package offer.uniquePaths62;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniquePaths(51, 9));;
    }
    public int uniquePaths(int m, int n) {
        int[][] cache = new int[m][n];

//        int res = get(m - 1, n - 1, cache);
//        for (int[] ints : cache) {
//            for (int anInt : ints) {
//                System.out.print(anInt + " ");
//            }
//            System.out.println();
//        }
        for (int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if (i == 0 || j == 0){
                    cache[i][j] = 1;
                    continue;
                }
                cache[i][j] = cache[i - 1][j] + cache[i][j - 1];
            }
        }
        return cache[m - 1][n - 1];
    }

    private int get(int y, int x,int[][] cache){
        if (y == 0 || x == 0){
            cache[y][x] = 1;
            return 1;
        }
        cache[y][x] = get(y - 1, x, cache) + get(y, x - 1, cache);
        return cache[y][x];
    }
}
