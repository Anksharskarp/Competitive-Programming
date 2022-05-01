package intermediate.coursework.Class7;

import java.util.Stack;

public class StackDemo {
    public static int evaluateExpression(String expression) {
        Stack<Integer> operandS = new Stack();
        Stack<Character> operatorS = new Stack();
        //Two stacks: one: int stack operandS and the other is operatorS;
        /*
        while(expression is not completely processed)
           get its current character (either a number or an operator);
           if (number) {
           push into operandS;
           } else {
            //Operator
            chat toPop = peek the top operator in operatorS;

            while(current operator < toPop) {
                pop the operator from operatorS and two numbers from operandS
                compute the result and push the result into operandS;
            }
            push current operator into operators
        }

        while(!operatorS.isEmpty()) {
            pop the operator from the operatorS and pop two numbers from the operandS;
            do the computation and push the result into operandS;
        }
        return the value in the operandS;
         */
        return 0;
    }

    public static void main(String[] args) {
        Stack<Character> tagBalancer = new Stack();
        String tagS = "(5 + 4){[(9)][]}";
        boolean balanced = true;

        //Check whether the tags are balanced
        for(int i = 0; i < tagS.length(); i++) {
            char c = tagS.charAt(i);
            if(c == '(' || c == '[' || c == '{') { //Open tag
                tagBalancer.push(c);
            } else if (c == ')' || c == ']' || c == '}') { //Close tag
                char tc = tagBalancer.pop();
                if(!(tc == '(' && c == ')' || tc == '[' && c == ']' || tc == '{' && c == '}')) {
                    //System.out.println("Not balanced");
                    balanced = false;
                    break;
                }
            } //else, not tag, ignore it.
        }
        if(balanced && tagBalancer.empty()) {
            System.out.println("Balanced");
        } else {
            System.out.println("Not balanced");
        }
    }
}
