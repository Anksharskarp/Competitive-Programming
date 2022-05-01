package intermediate.coursework.Class11to12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GUISorts extends JFrame implements ActionListener {
    JButton Insertion = new JButton("Insertion Sort");
    JButton Heap = new JButton("Heap Sort");
    JButton Bubble = new JButton("Bubble Sort");
    JButton Select = new JButton("Select Sort");
    JButton Quick = new JButton("Quick Sort");
    JButton Merge = new JButton("Merge Sort");
    JButton Reset = new JButton("Reset");
    TextField txt = new TextField(10);
    TextField NoE = new TextField(10);
    TextField Comparisons = new TextField(10);
    TextField Swaps = new TextField(10);
    int BoxLength = 35;
    int BoxScale = 20;
    int BoxHeight = 20;
    int Timer = 600;
    int COM = 0;
    int SWAP = 0;
    int H;
    int N = 20;
    int[] L = new int[N];
    JPanel NumberPanel = new JPanel();
    JPanel NumberPanelLeft = new JPanel();
    JPanel NumberPanelRight = new JPanel();
    JButton[] JB = new JButton[N];
    JButton[] IJB = new JButton[N];
    JFrame BigFrame;
    JLabel Text = new JLabel("Working Place");

    public GUISorts() {
        BigFrame = new JFrame("GUI Sorts");
        BigFrame.setSize(1000, N * 40);
        BigFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BigFrame.setResizable(true);
        BigFrame.setVisible(true);
        BigFrame.setLayout(new BorderLayout());

        JPanel HeadPanel = new JPanel();
        JPanel LabelPanel = new JPanel();
        LabelPanel.setBackground(Color.CYAN);
        HeadPanel.setBackground(Color.CYAN);
        NumberPanel.setBackground(Color.GREEN);
        NumberPanelRight.setBackground(Color.CYAN);
        NumberPanelLeft.setBackground(Color.CYAN);
        HeadPanel.setLayout(new FlowLayout());
        LabelPanel.setLayout(new FlowLayout());
        NumberPanel.setLayout(new GridLayout(1, 1));
        NumberPanelLeft.setLayout(new BoxLayout(NumberPanelLeft, BoxLayout.Y_AXIS));
        NumberPanelRight.setLayout(new BoxLayout(NumberPanelRight, BoxLayout.Y_AXIS));

        NoE.setText("10");
        N = Integer.parseInt(NoE.getText());
        H = N;

        NumberPanelLeft.add(new JLabel("Real Array"));
        NumberPanelRight.add(Text);

        Initialize(false, true);
        Initialize(false, false);

        BigFrame.add(HeadPanel, BorderLayout.NORTH);
        BigFrame.add(NumberPanel, BorderLayout.CENTER);
        BigFrame.add(LabelPanel, BorderLayout.SOUTH);

        NumberPanel.add(NumberPanelLeft);
        NumberPanel.add(NumberPanelRight);

        Insertion.addActionListener(this);
        Bubble.addActionListener(this);
        Select.addActionListener(this);
        Quick.addActionListener(this);
        Heap.addActionListener(this);
        Merge.addActionListener(this);
        Reset.addActionListener(this);

        HeadPanel.add(Merge);
        HeadPanel.add(Heap);
        HeadPanel.add(Quick);
        HeadPanel.add(Insertion);
        HeadPanel.add(Bubble);
        HeadPanel.add(Select);
        HeadPanel.add(Reset);

        LabelPanel.add(new JLabel("Number of Numbers:"));
        LabelPanel.add(NoE);
        LabelPanel.add(new JLabel("   "));
        LabelPanel.add(new JLabel("# of Comparisons:"));
        LabelPanel.add(Comparisons);
        LabelPanel.add(new JLabel("   "));
        LabelPanel.add(new JLabel("# of Swaps:"));
        LabelPanel.add(Swaps);
        LabelPanel.add(new JLabel("   "));
        LabelPanel.add(new JLabel("Wait Time(MS):"));
        LabelPanel.add(txt);


        Comparisons.setText("0");
        Swaps.setText("0");
        txt.setText("100");
    }

    public static void main(String[] args) {
        GUISorts S = new GUISorts();
        int[] a = {3, 6, 1, 7, 9, 2, 4, 10, 9};
        In_place_QuickSort(0, a.length - 1, a);
        for (int j : a) System.out.println(j);
    }

    public static void swap(int i, int j, int[] a) {
        int T = a[i];
        a[i] = a[j];
        a[j] = T;
    }

    public static void In_place_QuickSort(int b, int e, int[] a) {
        if (b >= e)//base condition
            return;
        int i = b;  //a[i] is pivot.
        int j = e;
        //repeat until the pivot is in correct position.
        System.out.println("e=" + b + " e=" + e);
        while (i < j) {
            //  continue reduce j until a[j]<a[i] //go to left
            while (i < j && a[i] < a[j]) j--;
            if (i == j) break;
            swap(i, j, a); //  so, a[j] (originally a[i]) becomes pivot
            i++;
            //continue to increase i until a[i]>a[j] // go to right
            while (i < j && a[i] < a[j]) i++;
            if (i < j)
                swap(i, j, a);// aa[i] becomes pivot again
            j--;
        }
        //recursive call the left part
        // if(b<i-1)
        In_place_QuickSort(b, i - 1, a);

        //recursive call the right part
        //if(i+1<e)
        In_place_QuickSort(i + 1, e, a);

    }

    public void InitializeTT(boolean T) {
        if (T) {
            for (int J = H - 1; J >= 0; J--) {
                NumberPanelLeft.remove(JB[J]);
                NumberPanelRight.remove(IJB[J]);
            }
            NumberPanelLeft.repaint();
            NumberPanelRight.repaint();
        }
        N = Integer.parseInt(NoE.getText());
        L = new int[N];
        JB = new JButton[N];
        boolean[] O = new boolean[N];
        for (int I = 0; I < N; I++)
            O[I] = false;
        Random Rand = new Random();
        int C;
        for (int I = 0; I < N; I++) {
            int R = Rand.nextInt(N);
            while (O[R])
                R = Rand.nextInt(N);
            C = R + 1;
            O[R] = true;
            L[I] = C;
            JB[I] = new JButton(Integer.toString(C));
            IJB[I] = new JButton(Integer.toString(C));
            NumberPanelLeft.add(JB[I]);
            NumberPanelRight.add(IJB[I]);
            JB[I].setVisible(false);//set invisible first
            IJB[I].setVisible(false);
            JB[I].setEnabled(false);
            IJB[I].setEnabled(false);
            JB[I].setBackground(Color.YELLOW);
            JB[I].setMaximumSize(new Dimension(BoxLength + L[I] * BoxScale, BoxHeight));
            IJB[I].setMaximumSize(new Dimension(BoxLength + L[I] * BoxScale, BoxHeight));
            JB[I].setVisible(true);//then set visible to make it appear immediately
            IJB[I].setVisible(true);
            IJB[I].setVisible(false);
        }
        H = N;
    }

    public void Initialize(boolean T, boolean initialJB) {
        if (T) {
            for (int J = H - 1; J >= 0; J--) {
                if (initialJB)
                    NumberPanelLeft.remove(JB[J]);
                else
                    NumberPanelRight.remove(IJB[J]);
            }
            if (initialJB)
                NumberPanelLeft.repaint();
            else
                NumberPanelRight.repaint();
        }
        N = Integer.parseInt(NoE.getText());
        if (initialJB) {
            L = new int[N];
            JB = new JButton[N];
        } else
            IJB = new JButton[N];
        boolean[] O = new boolean[N];
        for (int I = 0; I < N; I++)
            O[I] = false;
        Random Rand = new Random();
        int C;
        for (int I = 0; I < N; I++) {
            if (initialJB) {
                int R = Rand.nextInt(N);
                while (O[R])
                    R = Rand.nextInt(N);
                C = R + 1;
                O[R] = true;
                L[I] = C;
            }
            if (initialJB) {
                JB[I] = new JButton(Integer.toString(L[I]));
                NumberPanelLeft.add(JB[I]);
                JB[I].setVisible(false);//set invisible first
                JB[I].setEnabled(false);
                JB[I].setBackground(Color.YELLOW);
                JB[I].setMaximumSize(new Dimension(BoxLength + L[I] * BoxScale, BoxHeight));
                JB[I].setVisible(true);//then set visible to make it appear immediately
            } else {
                IJB[I] = new JButton(Integer.toString(L[I]));
                NumberPanelRight.add(IJB[I]);
                IJB[I].setVisible(false);
                IJB[I].setEnabled(false);
                IJB[I].setBackground(Color.YELLOW);
                IJB[I].setMaximumSize(new Dimension(BoxLength + L[I] * BoxScale, BoxHeight));
                IJB[I].setVisible(true);
                NumberPanelRight.paintImmediately(IJB[I].getBounds());
                NumberPanelRight.repaint();
//                IJB[I].setVisible(false);
            }
        }
        if (!initialJB)
            NumberPanelRight.repaint();
        H = N;
    }

    public void Resize(boolean JBTF) {
        for (int I = 0; I < N; I++) {
            if (JBTF) {
                JB[I].setMaximumSize(new Dimension(BoxLength + L[I] * BoxScale, BoxHeight));
                NumberPanelLeft.repaint();
            } else {
                IJB[I].setMaximumSize(new Dimension(BoxLength + L[I] * BoxScale, BoxHeight));
                NumberPanelRight.repaint();
            }
        }
    }

    public void Resize() {
        for (int I = 0; I < N; I++) {
            JB[I].setMaximumSize(new Dimension(BoxLength + L[I] * BoxScale, BoxHeight));
            IJB[I].setMaximumSize(new Dimension(BoxLength + L[I] * BoxScale, BoxHeight));
        }
        NumberPanelLeft.repaint();
        NumberPanelRight.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //first set all to invisible
        for (int I = 0; I < N; I++) {
            IJB[I].setVisible(false);
            NumberPanelRight.paintImmediately(IJB[I].getBounds());
        }
        Timer = Integer.parseInt(txt.getText());
        Comparisons.setText("0");
        Swaps.setText("0");
        N = Integer.parseInt(NoE.getText());
        if (e.getSource() == Reset) {
            Initialize(true, true);
            Initialize(true, false);
            return;
        }
        Text.setText("Swap Area");
        NumberPanelRight.paintImmediately(Text.getBounds());
        if (e.getSource() == Insertion)
            for (int I = 1; I < N; I++) {
                int J = I;
                while (J > 0 && QuestionMarks(J - 1, J, ">")) {
                    Swap(J - 1, J);
                    J--;
                }
            }
        if (e.getSource() == Bubble) {
//            for(int I=0;I<N-2;I++)
//                for(int J=0;J<N-1;J++)
//                    if(QuestionMarks(J,J+1,">"))
//                        Swap(J,J+1);
//            if(QuestionMarks(0,1,">"))
//                Swap(0,1);
            for (int I = 0; I < N - 1; I++)
                for (int J = N - 1; J > I; J--)
                    if (QuestionMarks(J - 1, J, ">"))
                        Swap(J - 1, J);
        }
        if (e.getSource() == Select)
            for (int I = 0; I < N; I++) {
                int MI = N - 1;
                int J = I;
                while (J < N) {
                    if (QuestionMarks(MI, J, ">"))
                        MI = J;
                    J++;
                }
                Swap(MI, I);
            }
        if (e.getSource() == Quick)
            QuickSort(0, L.length - 1);
        if (e.getSource() == Heap) {
            HeapSort();
        }
        if (e.getSource() == Merge) {
            Text.setText("Merged Area");
            NumberPanelRight.paintImmediately(Text.getBounds());
            MergeSort(0, L.length, L);
        }
        COM = 0;
        SWAP = 0;
        Ending();
    }

    public void MergeSortStuff(int I, int[] A, int S) {
        JB[I].setVisible(false);
        IJB[S].setText(Integer.toString(A[I]));
        IJB[S].setSize(new Dimension(BoxLength + A[I] * BoxScale, BoxHeight));
        IJB[S].setVisible(true);
        NumberPanelRight.paintImmediately(IJB[S].getBounds());
        NumberPanelLeft.paintImmediately(JB[I].getBounds());
        try {
            Thread.sleep(Timer);
        } catch (InterruptedException IE) {
            IE.printStackTrace();
        }
    }

    public void Merge(int B, int M, int E, int[] A) {
        //JB[0].setVisible(false);
        IJB[0].setVisible(false);
        int[] F = new int[E - B + 1];
        int P = B, Q = M, R = 0;
        while (P < M && Q < E) {//Continue putting in elements in sorted order until one list ends
            while (Q < E && P < M && QuestionMarks(P, Q, "<=")) {//continue putting elements from one sorted list into the main large list until the list has put all the values into the main list or the index from the other list has a value that is smaller than the current value we are comparing in this list
                MergeSortStuff(P, A, B + R);
                F[R++] = A[P++];
            }
            while (Q < E && P < M && QuestionMarks(Q, P, "<=")) {//it is the same thing as the previous while, except with the second list.
                MergeSortStuff(Q, A, B + R);
                F[R++] = A[Q++];
            }
        }
        while (P < M) {// we will definitely have one that is not completed at the end. so we put all the remaining into our large list because the other one is already finished But if the list this while is referring to has already finished, then we will never do this while in the first place because the index would already be at the end of the list.
            MergeSortStuff(P, A, B + R);
            F[R++] = A[P++];
        }
        while (Q < E) {// same as the last one, except with the other list. but if we did the previous while, that means the list this while is referring to has already finished because you will only have one that is larger than the other, not both at the same time
            MergeSortStuff(Q, A, B + R);
            F[R++] = A[Q++];
        }
        int I = 0;
        for (int J = B; J < E; J++)
            A[J] = F[I++];
        for (int Z = B; Z < E; Z++) {
            JB[Z].setVisible(true);
            IJB[Z].setVisible(false);
            NumberPanelRight.paintImmediately(IJB[Z].getBounds());
            JB[Z].setText(Integer.toString(A[Z]));
            JB[Z].setSize(new Dimension(BoxLength + A[Z] * BoxScale, BoxHeight));
            NumberPanelLeft.paintImmediately(JB[Z].getBounds());
        }
    }

    public void MergeSort(int B, int E, int[] A) {
        if (B >= E - 1)
            return;

        int M = (E + B) / 2;
        MergeSort(B, M, A);
        MergeSort(M, E, A);
        Merge(B, M, E, A);
    }

    public void Ending() {
        N = Integer.parseInt(NoE.getText());
        Resize();
        for (int I = 0; I < N; I++) {
            JB[I].setBackground(Color.GREEN);
            JB[I].setVisible(true);
            NumberPanelLeft.paintImmediately(JB[I].getBounds());
        }
        Text.setText("Working Place");
        NumberPanelRight.paintImmediately(Text.getBounds());
    }

    public void HeapSort() {
        BuildHeap();
        int I;
        for (I = 0; I < L.length - 2; I++) {
            Swap(0, L.length - 1 - I);
            Heapify(0, L.length - 1 - (I + 1));
        }
        //the last swap
        Swap(0, 1);
    }

    public void Heapify(int I, int E) {
        /*
        I: the index of the element to heapify
        E: the ending/last element's index in array C, i.e., the #number of elements in A for further sorting.
        C: array, which is from 0 to
        */
        boolean base = true;
        int KI = I;
        if (I * 2 + 2 >= E + 1) {//one kid
            if (QuestionMarks(2 * I + 1, I, ">")) {
                Swap(I, 2 * I + 1);
                KI = 2 * I + 1;
                base = false;
            }
        } else if (QuestionMarks(2 * I + 1, I, ">") || QuestionMarks(2 * I + 2, I, ">")) {
            if (L[2 * I + 2] <= L[2 * I + 1]) {//left larger or equal
                Swap(I, 2 * I + 1);
                KI = 2 * I + 1;
            } else {//right larger
                Swap(I, 2 * I + 2);
                KI = 2 * I + 2;
            }
            base = false;
        }
        if (!base && 2 * KI + 1 < E + 1)
            Heapify(KI, E);
    }

    public void BuildHeap() {
        for (int I = (L.length - 1) / 2; I >= 0; I--)
            Heapify(I, L.length - 1);
    }

    public void Swap(int I, int J) {
        int T = L[I];
        L[I] = L[J];
        L[J] = T;
        SWAP++;
        Swaps.setText(Integer.toString(SWAP));
        JButtonSwitch2(I, J);
    }

    public boolean QuestionMarks(int I, int J, String WKC) {
        JB[I].setText(L[I] + "?");
        JB[J].setText(L[J] + "?");
        NumberPanelLeft.paintImmediately(JB[I].getBounds());
        NumberPanelLeft.paintImmediately(JB[J].getBounds());
        try {
            Thread.sleep(Timer);
        } catch(InterruptedException IE) {
        }
        JB[I].setText(L[I] + "");
        JB[J].setText(L[J] + "");
        NumberPanelLeft.paintImmediately(JB[I].getBounds());
        NumberPanelLeft.paintImmediately(JB[J].getBounds());
        COM++;
        Comparisons.setText(Integer.toString(COM));
        if (WKC.equals(">"))
            return L[I] > L[J];
        else
            return L[I] <= L[J];

    }

    public void JButtonSwitch1(int I, int J) {
        JB[I].setVisible(false);
        NumberPanelLeft.paintImmediately(JB[I].getBounds());
        JB[I].setText(Integer.toString(L[I]));
        JB[I].setSize(new Dimension(BoxLength + L[I] * BoxScale, BoxHeight));
        JB[I].setBackground(Color.GREEN);
        JB[I].setVisible(true);
        NumberPanelLeft.paintImmediately(JB[I].getBounds());
        try {
            Thread.sleep(Timer);
        } catch(InterruptedException ex) {
        }
        JB[J].setVisible(false);
        NumberPanelLeft.paintImmediately(JB[J].getBounds());
        JB[J].setText(Integer.toString(L[J]));
        JB[J].setSize(new Dimension(BoxLength + L[J] * BoxScale, BoxHeight));
        JB[J].setBackground(Color.GREEN);
        JB[J].setVisible(true);
        NumberPanelLeft.paintImmediately(JB[J].getBounds());
        try {
            Thread.sleep(Timer);
        } catch (InterruptedException ex) {
        }
        JB[I].setBackground(Color.YELLOW);
        JB[J].setBackground(Color.YELLOW);
        NumberPanelLeft.paintImmediately(JB[I].getBounds());
        NumberPanelLeft.paintImmediately(JB[J].getBounds());
        try {
            Thread.sleep(Timer);
        } catch (InterruptedException ex) {
        }
        {
            {
                {
                    {
                    }
                }
            }
        }
    }

    public void JButtonSwitch2(int I, int J) {
        //put JB[I] to Place in right Panel
        int Place = N / 2;
        IJB[Place].setVisible(false);
        NumberPanelRight.paintImmediately(IJB[Place].getBounds());
        IJB[Place].setText(Integer.toString(L[J]));
        IJB[Place].setSize(new Dimension(BoxLength + L[J] * BoxScale, BoxHeight));
        IJB[Place].setBackground(Color.GREEN);
        IJB[Place].setVisible(true);
        NumberPanelRight.paintImmediately(IJB[Place].getBounds());
        try {
            Thread.sleep(Timer);
        } catch (InterruptedException ex) {
        }
        //Make JB[I] look like JB[J]
        JB[I].setVisible(false);
        NumberPanelLeft.paintImmediately(JB[I].getBounds());
        JB[I].setText(Integer.toString(L[I]));
        JB[I].setSize(new Dimension(BoxLength + L[I] * BoxScale, BoxHeight));
        JB[I].setBackground(Color.GREEN);
        JB[I].setVisible(true);
        NumberPanelLeft.paintImmediately(JB[I].getBounds());
        try {
            Thread.sleep(Timer);
        } catch (InterruptedException ex) {
        }
        //Make JB[J] look like IJB[Place]
        JB[J].setVisible(false);
        NumberPanelLeft.paintImmediately(JB[J].getBounds());
        JB[J].setText(IJB[Place].getText());
        JB[J].setSize(IJB[Place].getSize());
        JB[J].setBackground(Color.GREEN);
        JB[J].setVisible(true);
        NumberPanelLeft.paintImmediately(JB[J].getBounds());
        try {
            Thread.sleep(Timer);
        } catch (InterruptedException ex) {
        }
        JB[I].setBackground(Color.YELLOW);
        JB[J].setBackground(Color.YELLOW);
        NumberPanelLeft.paintImmediately(JB[I].getBounds());
        NumberPanelLeft.paintImmediately(JB[J].getBounds());
        IJB[Place].setVisible(false);
        NumberPanelRight.paintImmediately(IJB[Place].getBounds());
        try {
            Thread.sleep(Timer);
        } catch (InterruptedException ex) {
        }
    }

    public void QuickSort(int I, int J) {
        int SI = I;
        int SJ = J;
        int S = 0;
        if (I == J || J + 1 == I)
            return;
        else
            while (I < J) {
                while (J > I && QuestionMarks(I, J, "<="))
                    J--;
                if (I == J)
                    break;
                Swap(I, J);
                I++;
                while (I < J && QuestionMarks(I, J, "<="))
                    I++;
                if (I == J)
                    break;
                Swap(I, J);
                J--;
            }
        QuickSort(SI, I - 1);
        QuickSort(I + 1, SJ);
    }
}

