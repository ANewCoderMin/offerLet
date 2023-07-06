package offer;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Min
 * @create 2021-05-09 21:16
 */
public class AllSolution {

    /**
     * 剑指 Offer 12. 矩阵中的路径
     * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
     *
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[i].length;j++){
                if(dfsExist(board,i,j,words,0)) return true;
            }
        }
        return false;
    }
    public boolean dfsExist(char[][] board,int i,int j,char[] words,int k){
        if (i<0 || i>=board.length || j<0 || j>=board[0].length ||  words[k]!= board[i][j]) return false;
        board[i][j] = '\0';
        if(words.length-1 == k) return true;
        boolean response = (dfsExist(board,i+1,j,words,k+1) || dfsExist(board,i,j+1,words,k+1) ||
                dfsExist(board,i-1,j,words,k+1) || dfsExist(board,i,j-1,words,k+1));
        board[i][j] = words[k];
        return response;
    }

    /**
     * @author Min
     * @date 2021/5/12  21:41
     * @param
     * @return int
     *地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
     * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
     * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
     * 请问该机器人能够到达多少个格子？
     *
     */
    public int movingCount(int m,int n,int k){
        boolean[][] vis = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{0, 0});
        int count = 1;
        // 向右和向下的数组
        int[] right = new int[]{1, 0};
        int[] down = new int[]{0,1};
        vis[0][0] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for(int i = 0; i<2 ; ++i){
                int x = right[i] + current[0];
                int y = down[i] + current[1];
                if(x<0 || x>=m || y<0 || y>=n || vis[x][y] || getModuleOperation(x,y)>k) continue;
                queue.offer(new int[]{x,y});
                vis[x][y] = true;
                count++;
            }

        }

        return count;
    }
    private int getModuleOperation(int x,int y){
        int sum = 0;
        while(x != 0){
            sum += x%10;
            x /= 10;
        }
        while(y != 0){
            sum += y%10;
            y /= 10;
        }
        return sum;
    }

    /**
     * @author Min
     * @date 2021/5/13  22:02
     * @param
     * @param n
     * @return int
     * 剪绳子1
     */
    public int cuttingRope(int n) {
        if(n <=3) return n-1;
        int a = n/3,b = n%3;
        if(b == 0)return (int)Math.pow(3,a);
        if(b == 1)return (int)Math.pow(3,a-1) * 4;
        return (int)Math.pow(3,a) * 2;
    }

    /**
     * @author Min
     * @date 2021/5/13  22:25
     * @param
     * @param S
     * @return java.lang.String[]
     * 有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。
     * 经典回溯
     */
    Set<String> set = new HashSet<>();
    boolean[] booleans;
    public String[] permutation(String S) {
        booleans = new boolean[S.length()];
        StringBuilder builder = new StringBuilder();
        dfsPermutation(S,builder);
        return set.toArray(new String[set.size()]);
    }
    private void dfsPermutation(String S,StringBuilder stringBuilder){
        if (stringBuilder.length() == S.length()) {
            set.add(stringBuilder.toString());
            return;
        }
        for(int i=0;i<S.length();i++){
            if(booleans[i]) continue;
            stringBuilder.append(S.charAt(i));
            booleans[i] = true;
            dfsPermutation(S,stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            booleans[i] = false;
        }
    }

    public static void main(String[] args) {
        AllSolution allSolution = new AllSolution();
        System.out.println(Arrays.toString(allSolution.permutation("qqe")));
        Executors.newSingleThreadExecutor();
    }

}
