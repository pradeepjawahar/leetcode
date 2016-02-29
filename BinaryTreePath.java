import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
public class BinaryTreePath {
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<String>();
        if (root != null) searchBT(root, "", answer);
        return answer;
    }
    private static void searchBT(TreeNode root, String path, List<String> answer) {
        if (root.left == null && root.right == null) answer.add(path + root.val);
        if (root.left != null) searchBT(root.left, path + root.val + "->", answer);
        if (root.right != null) searchBT(root.right, path + root.val + "->", answer);
    }
    static class TreeNode {
 
    int val;
    TreeNode left, right;
 
    TreeNode(int item) {
        val = item;
        left = right = null;
    }
  }
     public static void main(String args[]) {
        BinaryTreePath tree = new BinaryTreePath();
      
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(2);
        printList(binaryTreePaths(root));
        //tree.printPaths(root);
    }
    public static void printList(List<String> array) {
        for (String path : array) {
          System.out.println(path);
        }
      
    }
    public static void bfs(TreeNode root) {
      List<List<String>> answer = new ArrayList<>();
      if (root == null)
          return answer;
      List<Pair> queue = new LinkedList<>();
      if (root != null) {
          queue.add(Pair.makePair(root,0));
      }
      while (queue.size() > 0 ) {
          
      } 
    }
    static class Pair {
        TreeNode node;
        int level;
        public static Pair makePair(TreeNode node, int level) {
            Pair pair = new Pair();
            pair.node = node;
            pair.level = level;
            return pair;
        }
    }
}
