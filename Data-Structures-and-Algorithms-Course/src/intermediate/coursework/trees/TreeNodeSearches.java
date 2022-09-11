package intermediate.coursework.trees;

import java.util.Stack;

public class TreeNodeSearches {
    class TreeNode<E> {
        E element;
        TreeNode leftC;
        TreeNode rightC;
        public TreeNode(E e) {
            element = e;
            leftC = null;
            rightC = null;
        }

        public TreeNode(E e, TreeNode leftCInput, TreeNode rightCInput) {
            element = e;
            leftC = leftCInput;
            rightC = rightCInput;
        }
    }

    public static void preOrderTraversal(TreeNode n) {
        if(n == null) {
            return;
        }
        System.out.println(n.element);
        /*
        if(n.leftC != null) {
            preOrderTraversal(n.leftC);
        }
        if(n.rightC != null) {
            preOrderTraversal(n.rightC);
        }
         */
        preOrderTraversal(n.leftC);
        preOrderTraversal(n.rightC);
    }

    public static void iterativePreOrderTraversal(TreeNode n) {
        if(n == null) {
            return;
        }
        Stack<TreeNode> stn = new Stack();
        stn.push(n);
        while(!stn.isEmpty()) {
            TreeNode tn = stn.pop();
            System.out.println(tn.element);
            if(tn.rightC != null) {
                stn.push(tn.rightC);
            }
            if(tn.leftC != null) {
                stn.push(tn.leftC);
            }
        }
    }

    public static void postOrderTraversal(TreeNode n) {
        if(n == null) {
            return;
        }
        postOrderTraversal(n.leftC);
        postOrderTraversal(n.rightC);
        System.out.println(n.element);
    }

    public static void iterativePostOrderTraversal(TreeNode n) {
        if(n == null) {
            return;
        }
        Stack<TreeNode> stn = new Stack();
        Stack<Boolean> stb = new Stack();
        stn.push(n);
        stb.push(false);
        while(!stn.isEmpty()) {
            TreeNode tn = stn.pop();
            boolean tb = stb.pop();
            if(!tb) {
                //We need to push back again so that we can later pop out and print.
                stn.push(tn);
                stb.push(true);
                if(tn.rightC != null) {
                    stn.push(tn.rightC);
                    stb.push(false);
                }
                if(tn.leftC != null) {
                    stn.push(tn.leftC);
                    stb.push(false);
                }
            //System.out.println(tn.element);
            } else { //Its left and right children (from the tree) are both visited already, so we visit it
                     //(by printing the element).
                System.out.println(tn.element);
            }
        }
    }
}
