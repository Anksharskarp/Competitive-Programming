package intermediate.coursework.queues;

import java.util.ArrayList;
import java.util.LinkedList;

public class AbstractQueue<E> {
    LinkedList<E> q;
    public AbstractQueue() {
        q = new LinkedList();
    }

    public void enqueueData(E e) {
        q.add(e);
    }

    public E dequeueData() {
        if(q.size() == 0) {
            return null;
        }
        return q.remove();
    }
    public boolean isEmpty() {
        return q.size() == 0;
    }
    public int size() {
        return q.size();
    }

    //TODO: Implement this regex expression for the homework assignment of the class on 5/7/2022.
    public static int evaluateExpression(String exp) {
        //"41 - 3 * 20 + 71"
        //Assume that between the numbers and the operators there is at least one blank.
        String[] terms = exp.split(" ");
        for(int i = 0; i < terms.length; i++) {
            System.out.println(terms[i]);
        }
        StackHelper<Integer> operands = new StackHelper();
        StackHelper<String> operators = new StackHelper();
        //Go through each term of the expression and process it.
        for(int i = 0; i < terms.length; i++) {
            switch(terms[i].charAt(0)) {
                case '+':
                case '-':
                case '*':
                case '/':
                case '%':
                case '(':
                case ')':
                default:
                    operands.push(Integer.parseInt(terms[i]));
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        evaluateExpression("41 - 3 * ( 20 + 71 )");
    }
}

class StackHelper<E> {
    ArrayList<E> s = new ArrayList();
    int tp = 0;

    public StackHelper() {
        tp = 0;
        s = new ArrayList();
    }

    public boolean isEmpty() {
        return tp == 0;
    }

    public int size() {
        return tp;
    }

    public void push(E e) {
        s.add(e);
        tp++;
    }

    public E pop() {
        if (tp == 0)
            return null;
        tp--;
        return s.remove(tp);
    }

    public E getTop() {
        if (tp == 0)
            return null;
        return s.get(tp - 1);
    }
}