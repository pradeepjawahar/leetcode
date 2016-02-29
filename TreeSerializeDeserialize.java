public class TreeSerializeDeserialize {
    // Serialize
    public String serialize(Node root) {
        if (root == null) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        preOrder(root, sb);
        return sb.toString();
    }

    private void  preOrder(Node root, StringBuffer sb) {
        if (root == null) {
            sb.append(",null");
            return;
        }
        sb.append("," + root.value);
        preOrder(root.left, sb);
        preOrder(root.right, sb);
    }
    // Desrialize
    pubic Node desrialize(String data) {
        if (data == null) {
            return null;
        String[] arr = data.split(",");
        int preOrderPrefix = 0;
        return deserializeHelper(data, preOrderPrefix);

    }
    private int longestConsecutive(Node root) {
        return root == null ? 0 : Math.max(traverse(root.left, 1, root.value), traverse(root.right, 1, root.value));
    }
    private int traverse(Node root, int count, int value) {
        if (root == null) 
            return 0;
        count =  (root.value - value) == 1 ? count + 1 : 1;
        return Math.max(count, Math.max(traverse(root.left, count, root.value),traverse(root.right, count, root.value)));
    }
    public Node deserializeHelper(int[] treeData, int preOrderIndex) {
        Node root = new Node(Integer.parseInt(treeData[preOrderIndex]);
        preOrderIndex++;
        if (treeData[preOrderIndex] == null) {
            root.left = null;
        } else {
            root.left = deserializeHelper(treeData, preFix);
        }
        preOrderIndex++;
        if (treeData[preOrderIndex] == null) {
            root.right = null;
        } else {
            root.right = deserializeHelper(treeData, preFix);
        }
        return root; 
    }

    class Node {

        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    
    }
}
