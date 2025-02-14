public class BinaryTreesB {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int height(Node root) {
        if(root == null) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh)+1;
    }

    public static int count(Node root) {
        if(root == null) {
            return 0;
        }

        int lc = count(root.left);
        int rc = count(root.right);
        return lc+rc+1;
    }

    public static int sum(Node root) {
        if(root == null) {
            return 0;
        }

        int ls = sum(root.left);
        int rs = sum(root.right);

        return ls + rs + root.data;
    }

    public static int diameter2(Node root) { //O(n^2)
        if(root == null) {
            return 0;
        }

        int leftDiam = diameter2(root.left);
        int leftHt = height(root.left);

        int rightDiam = diameter2(root.right);
        int rightHt = height(root.right);

        int selfDiameter = leftHt + rightHt + 1;

        return Math.max(selfDiameter, Math.max(leftDiam, rightDiam));
    }

    static class Inf {
        int diam;
        int ht;

        public Inf(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }

    public static Inf diameter(Node root) { //O(n)
        if(root == null) {
            return new Inf(0, 0);
        }
        Inf leftInfo = diameter(root.left);
        Inf rightInfo = diameter(root.right);

        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);

        int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

        return new Inf(diam, ht);
    }

    public static void inputA() {
        /*
                   1
                  / \
                 2   3
                / \  / \
               4  5  6  7
       */

       Node root = new Node(1);
       root.left = new Node(2);
       root.right = new Node(3);
       root.left.left = new Node(4);
       root.left.right = new Node(5);
       root.right.left = new Node(6);
       root.right.right  = new Node(7);

       //System.out.println(height(root));
       //System.out.println(count(root));
       //System.out.println(sum(root));
       //System.out.println(diameter2(root));
       System.out.println(diameter(root).diam);
    }

    public static void main(String[] args) {
        inputA();
    }
}