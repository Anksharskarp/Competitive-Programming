package intermediate.coursework.stacks;

import java.util.ArrayList;

class StackExample<E> {
    ArrayList<E> s = new ArrayList();
    int tp = 0;

    public StackExample() {
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

    public static void main(String[] args) {
        StackExample<String> os = new StackExample();
        os.push("William");
        System.out.println("size = " + os.size());
        os.push("Matthew");
        os.push("Xindi");
        System.out.println("size = " + os.size());
        System.out.println(os.pop());
        System.out.println("size = " + os.size());
        System.out.println(os.pop());
        os.push("Lina");
        os.push("Kevin");
        os.push("Viswa");
        System.out.println("size = " + os.size());
        System.out.println(os.pop());
        System.out.println("size = " + os.size());
        System.out.println(os.getTop());
        System.out.println("size = " + os.size());
    }
}
