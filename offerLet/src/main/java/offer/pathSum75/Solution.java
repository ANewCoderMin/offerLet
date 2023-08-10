package offer.pathSum75;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        // [10,5,-3,3,2,null,11,3,-2,null,1]
        TreeNode root = new TreeNode(10 ,new TreeNode(5 ,new TreeNode(3 ,new TreeNode(3 ,null, null), new TreeNode(-2 ,null, null)), new TreeNode(2 ,null, new TreeNode(1 ,null, null))), new TreeNode(-3 ,null, new TreeNode(11 ,null, null)));
        solution.pathSum(root, 8);
    }

    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }
        int count = rootSum(root, targetSum);

        count += pathSum(root.left, targetSum);
        count += pathSum(root.right, targetSum);
        return count;
    }

    private int rootSum(TreeNode node, int target){
        int result = 0;
        if (node == null){
            return 0;
        }
        // 当前节点在当前层处理完，之前用的屙屎target==0判断，这个会到下一层去判断，结果会翻倍
        if (target == node.val){
            result++;
        }
        result += rootSum(node.left, target - node.val);
        result += rootSum(node.right, target - node.val);
        return  result;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
