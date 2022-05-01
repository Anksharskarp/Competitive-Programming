package intermediate.coursework.Class15to18;

import java.util.*;

//Creates a binary tree that has nodes of any type (hence the usage of generics).
public class BinaryTree<E> { //Binary Tree ADT (Abstract Data Structure, meaning it applies for any type of binary tree)
    TreeNode root;

    //Creates a binary tree from a TreeNode (root).
    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    //Creates a binary tree from an element (root).
    public BinaryTree(E element) {
        root = new TreeNode(element);
    }

    //Creates a binary tree from an element (node), along with the left child element and the right child element;
    public BinaryTree(E element, E leftChildElement, E rightChildElement) {
        TreeNode leftChild = new TreeNode(leftChildElement);
        TreeNode rightChild = new TreeNode(rightChildElement);
        TreeNode node = new TreeNode(element);
        setNodeAndChildren(node, leftChild, rightChild);
    }

    //Sets the children for the root node (which has already been initialized when the class was instantiated using the
    //constructor).
    public void setRootNodeAndChildren(TreeNode leftChild, TreeNode rightChild) {
        root.leftChild = leftChild;
        root.rightChild = rightChild;
    }

    //Sets a node (not the root) and its children. The node has its children set using this method, given the value
    //of the node itself.
    public void setNodeAndChildren(TreeNode node, TreeNode leftChild, TreeNode rightChild) {
        node.leftChild = leftChild;
        node.rightChild = rightChild;
    }

    //Sets a node's parent to a specific parent (changes its parent).
    public void setNodeAndParent(TreeNode node, TreeNode parent) {
        node.parent = parent;
    }

    //Performs a preorder traversal of the binary tree.
    public void preOrderTraversal(TreeNode v) {
        //Visits itself first
        System.out.print((char) (v.element) + " ");
        //Then visits its children (left, then right).
        if(v.leftChild != null) {
            preOrderTraversal(v.leftChild);
        }
        if(v.rightChild != null) {
            preOrderTraversal(v.rightChild);
        }
    }

    //Performs a preorder traversal of the binary tree using a stack (non-recursive method).
    public void preOrderTraversalUsingStack(TreeNode v) {
        Stack<TreeNode> stack = new Stack();
        stack.push(v);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.element + " ");
            //NOTE: Push right child FIRST
            if(node.rightChild != null) {
                stack.push(node.rightChild);
            }
            //NOTE: Push left child SECOND
            if(node.leftChild != null) {
                stack.push(node.leftChild);
            }
        }
    }

    //Performs a postorder traversal of the binary tree.
    public void postOrderTraversal(TreeNode v) {
        //Visits its lowest left child first, then its lowest right child, before going up one node and moving on to
        //the next lowest child towards the right.
        if(v.leftChild != null) {
            postOrderTraversal(v.leftChild);
        }
        if(v.rightChild != null) {
            postOrderTraversal(v.rightChild);
        }
        System.out.print(v.element + " ");
    }

    //Performs a postorder traversal of the binary tree using a stack (non-recursive method).
    public void postOrderTraversalUsingSTack(TreeNode v) {
        //TODO: Implement the body of the method (for Class #17).
    }

    //Performs an in-order traversal of the binary tree.
    public void inOrderTraversal(TreeNode v) {
        //Visits its left child, then its right child, then visits itself.
        if(v.leftChild != null) {
            //Visits left child
            inOrderTraversal(v.leftChild);
        }
        System.out.print(v.element + " ");
        if(v.rightChild != null) {
            //Visits right child
            inOrderTraversal(v.rightChild);
        }
    }

    //Performs an in-order traversal of the binary tree using a stack (non-recursive method).
    public void inOrderTraversalUsingStack(TreeNode v) {
        //When you write the code, it is always good to have a high-level description of your algorithm. This
        //way, you have a general strategy and approach that you can take to solve a problem or create an
        //implementation of somethign. Below is the pseudocode for a non-recursive in-order traversal of a binary tree
        //(using a stack).
        /*
        StackTransfer S;
        push(v, firstTime) into stack;
        while(the stack is not empty) {
            pop S to get (s, flag);
            if(flag == firstTime) {
                push(s, secondTime) into S;
                if(s has a left child) {
                    push(left child of s, firstTime) into S;
                }
            } else { //If it is the second time
                visit s;
                if(s has a right child) {
                    push(right child, firstTime);
                }
            }
        }
         */

        Stack<StackElement> S = new Stack();

        S.push(new StackElement(v, 'F'));

        while(!S.isEmpty()) {
            StackElement stackElement = S.pop();

            if(stackElement.flag == 'F') {
                stackElement.flag = 'S';
                S.push(stackElement);
                if(stackElement.treeNode.leftChild != null) {
                    S.push(new StackElement(stackElement.treeNode.leftChild, 'F'));
                }
            } else { //If the flag == 'S' (second time)
                System.out.print(stackElement.treeNode.element + " ");

                if(stackElement.treeNode.rightChild != null) {
                    //Time to time, you might "miss" the left child because it has already been visited.
                    //Be careful about this slight logical error in your own implementations.
                    //This error has been corrected in this program.
                    S.push(new StackElement(stackElement.treeNode.rightChild, 'F'));
                }
            }
        }
    }

    public boolean isEmpty() {
        boolean empty = false;
        //TODO: Check whether there is no node (for Class #17).
        return empty;
    }

    public int size() {
        int size = 0;
        //TODO: Compute size (for Class #17).
        return size;
    }

    //Gets left child
    public TreeNode leftChild() {
        return root.leftChild;
    }

    //Gets right child
    public TreeNode rightChild() {
        return root.rightChild;
    }

    public void createExpressionTree() {
        TreeNode<String> two = new TreeNode("22");
        TreeNode<String> a = new TreeNode("10");
        TreeNode<String> one = new TreeNode("15");
        TreeNode<String> three = new TreeNode("30");
        TreeNode<String> b = new TreeNode("25");
        TreeNode<String> minus = new TreeNode("-");
        minus.leftChild = a;
        minus.rightChild = one;
        TreeNode<String> leftMul = new TreeNode("*");
        TreeNode<String> rightMul = new TreeNode("*");
        leftMul.leftChild = two;
        leftMul.rightChild = minus;
        rightMul.leftChild = three;
        rightMul.rightChild = b;
        root = new TreeNode("+");
        root.leftChild = leftMul;
        root.rightChild = rightMul;
    }

    //Recursively prints all possible expressions from the expression (decision) tree.
    public void printExpression(TreeNode v) {
        if(v.leftChild != null) {
            System.out.print("(");
            printExpression(v.leftChild);
        }
        System.out.print(v.element);
        if(v.rightChild != null) {
            printExpression(v.rightChild);
            System.out.print(")");
        }
    }

    public int evaluateExpression(TreeNode variable) {
        //Note that if v is a leaf, this should return its value.
        int leftVariable = 0;
        int rightVariable = 0;
        if(variable.leftChild == null && variable.rightChild == null) {
            return Integer.parseInt((String) variable.element);
        }
        if(variable.leftChild != null) {
            leftVariable = evaluateExpression(variable.leftChild);
        }
        if(variable.rightChild != null) {
            rightVariable = evaluateExpression(variable.rightChild);
        }
        int calculateVariable = 0;
        switch(((String) variable.element).charAt(0)) {
            case '+':
                calculateVariable = leftVariable + rightVariable;
                break;
            case '-':
                calculateVariable = leftVariable - rightVariable;
                break;
            case '*':
                calculateVariable = leftVariable * rightVariable;
                break;
            case '/':
                calculateVariable = leftVariable / rightVariable;
                break;
        }
        return calculateVariable;
    }

    //NOTE: Nonstatic methods can only be called by a class; they cannot be called as "standalone" methods. On the
    //other hand, static methods are called without a class calling it; they are "standalone" methods.
    public static void main(String[] args) {
        //When we instantiate (build) a binary tree, we must specify the type inside <E>, where the 'E' abstract data type is.
        BinaryTree binaryTree = new BinaryTree<Character>('A');
        TreeNode b = new TreeNode<Character>('B');
        TreeNode c = new TreeNode<Character>('C');
        binaryTree.setRootNodeAndChildren(b, c);
        TreeNode d = new TreeNode<Character>('D');
        TreeNode e = new TreeNode<Character>('E');
        TreeNode f = new TreeNode<Character>('F');
        TreeNode g = new TreeNode<Character>('G');
        TreeNode h = new TreeNode<Character>('H');
        TreeNode i = new TreeNode<Character>('I');
        binaryTree.setNodeAndChildren(b, d, e);
        binaryTree.setNodeAndChildren(c, f, g);
        binaryTree.setNodeAndChildren(e, h, i);

        //Performs a preorder traversal of the binary tree
        System.out.println("Preorder Traversal:");
        binaryTree.preOrderTraversal(binaryTree.root);
        System.out.println();

        //Performs a preorder traversal of the binary tree (using stack)
        System.out.println("Preorder Traversal (using stack):");
        binaryTree.preOrderTraversalUsingStack(binaryTree.root);
        System.out.println();

        //Performs a postorder traversal of the binary tree
        System.out.println("Postorder Traversal:");
        binaryTree.postOrderTraversal(binaryTree.root);
        System.out.println();

        //Performs an in-order traversal of the binary tree
        System.out.println("In-order Traversal:");
        binaryTree.inOrderTraversal(binaryTree.root);
        System.out.println();

        //Performs an in-order traversal of the binary tree (using stack)
        System.out.println("In-order Traversal (using stack):");
        binaryTree.inOrderTraversalUsingStack(binaryTree.root);
        System.out.println();

        //Instantiates a new expression tree (of type String)
        BinaryTree expressionTree = new BinaryTree<String>("+");
        expressionTree.createExpressionTree();

        //Prints the expressions in the expression tree
        expressionTree.printExpression(expressionTree.root);
        System.out.println();
        System.out.print(expressionTree.evaluateExpression(expressionTree.root));
        System.out.println();
    }
}

//We add an Abstract Data Type (ADT) so that it can take any type of parameter (for both the constructor, class
//variables, or instance variables.
class TreeNode<E> {
    E element;
    TreeNode parent;
    TreeNode leftChild;
    TreeNode rightChild;

    //Here, we overload the constructors.
    public TreeNode(E element) {
        this.element = element;
        this.parent = null;
        this.leftChild = null;
        this.rightChild = null;
    }

    //If the variable names of the constructor parameters are different from the variable names of the instance
    //variables that are being set to them, then the instance variables don't need a 'this' operator in front of them
    //when their values are being set. Otherwise, if they are the same, you need to include the 'this' operator.
    public TreeNode(E element, TreeNode parent, TreeNode leftChild, TreeNode rightChild) {
        this.element = element;
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
}

class StackElement<E> {
    TreeNode<E> treeNode;
    //Flag: 'F' : first time, 'S' : second time
    char flag;

    public StackElement(TreeNode treeNode, char flag) {
        this.treeNode = treeNode;
        this.flag = flag;
    }
}