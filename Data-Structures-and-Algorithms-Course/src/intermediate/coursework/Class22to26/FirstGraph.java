package intermediate.coursework.Class22to26;

import java.util.ArrayList;

//A simple program that generates a graph using the adjacency list structure of a graph (the more popular, concise,
//and efficient method of generating a graph in modern programs).
public class FirstGraph {

    //A clear advantage of declaring constants is that you don't need to manually go in and refactor each component
    //in which a certain value is used, by hand, in the event that you wish to change it.
    final static int GRAPH_SIZE = 9;
    Vertex[] graph = new Vertex[GRAPH_SIZE];
    boolean[] visited = new boolean[GRAPH_SIZE];
    //This will be used to keep track of which nodes were visited in which order (and of which precedence).
    int[] visitOrder = new int[GRAPH_SIZE];
    int order;
    int[] preNode = new int[GRAPH_SIZE];
    boolean stopRecursiveAfterFinishingPath;
    boolean stopAfterFindingCycle;

    public void createGraph() {
        Vertex A = new Vertex('A');
        Vertex B = new Vertex('B');
        Vertex C = new Vertex('C');
        Vertex D = new Vertex('D');
        Vertex E = new Vertex('E');
        Vertex F = new Vertex('F');

        Vertex X = new Vertex('X');
        Vertex Y = new Vertex('Y');
        Vertex Z = new Vertex('Z');

        graph[0] = A;
        graph[1] = B;
        graph[2] = C;
        graph[3] = D;
        graph[4] = E;
        graph[5] = F;

        graph[6] = X;
        graph[7] = Y;
        graph[8] = Z;

        X.adj.add(7);
        X.adj.add(8);
        Y.adj.add(6);
        Z.adj.add(6);

        //Here, we're only listing the index of each node to simplify the creation of a graph.
        A.adj.add(1);
        A.adj.add(2);
        A.adj.add(3);
        B.adj.add(0);
        B.adj.add(2);
        B.adj.add(4);
        C.adj.add(0);
        C.adj.add(1);
        C.adj.add(3);
        C.adj.add(4);
        C.adj.add(5);
        D.adj.add(0);
        D.adj.add(2);
        D.adj.add(5);
        E.adj.add(1);
        E.adj.add(2);
        F.adj.add(2);
        F.adj.add(3);

        /*
        A.adj.add(B);
        A.adj.add(C);
        A.adj.add(D);
        B.adj.add(A);
        B.adj.add(C);
        B.adj.add(E);
        C.adj.add(A);
        C.adj.add(B);
        C.adj.add(D);
        C.adj.add(E);
        C.adj.add(F);
        D.adj.add(A);
        D.adj.add(C);
        D.adj.add(F);
        E.adj.add(B);
        E.adj.add(C);
        F.adj.add(C);
        F.adj.add(D);
         */
    }

    //A revised, improved, and highly optimized version of the standard depth first search graph algorithm.
    //NOTE: DEPTH FIRST SEARCH CAN ONLY HELP YOU FIND A CYCLIC PATH ON THE GRAPH, NOT THE MINIMAL DISTANCE BETWEEN
    //TWO NODES ON THE GRAPH!
    public void dfs(int s) {
        if(visited[s]) {
            return;
        }
        visited[s] = true;
        visitOrder[s] = order++;
        System.out.println(graph[s].name + " in order " + order);
        for(int i : graph[s].adj) {
            if(!visited[i]) {
                System.out.println(graph[s].name + " " + graph[i].name + " is a discovered edge.");
                preNode[i] = s;
                //Subsequently, perform a complete depth-first search of i (demonstrates how this is a recursive
                //graph search algorithm.
                dfs(i);
            } else {
                if((preNode[s] != i) && (visitOrder[s] > visitOrder[i])) {
                    System.out.println(graph[s].name + " " + graph[i].name + " is a back edge.");
                }
            }
        }
    }

    //Finds a good traversal path using the core elements of a depth-first search
    //NOTE: DEPTH FIRST SEARCH CAN ONLY HELP YOU FIND A CYCLIC PATH ON THE GRAPH, NOT THE MINIMAL DISTANCE BETWEEN
    //TWO NODES ON THE GRAPH!
    public void findPathByDFS(int s, int d) {
        System.out.println(graph[s].name + " in order " + order);
        if(s == d) {
            stopRecursiveAfterFinishingPath = true;
            return;
        }

        if(stopRecursiveAfterFinishingPath) {
            return;
        }

        visited[s] = true;
        visitOrder[s] = order++;
        for(int i : graph[s].adj) {
            if(!stopRecursiveAfterFinishingPath)
            if(!visited[i]) {
                System.out.println(graph[s].name + " " + graph[i].name + " is a discovered edge.");
                preNode[i] = s;
                //Subsequently, perform a complete depth-first search of i (demonstrates how this is a recursive
                //graph search algorithm.
                findPathByDFS(i, d);
            } else {
                if((preNode[s] != i) && (visitOrder[s] > visitOrder[i])) {
                    System.out.println(graph[s].name + " " + graph[i].name + " is a back edge.");
                }
            }
        }
    }

    public void findCycleByDFS(int s) {
        System.out.println(graph[s].name + " in order " + order);
        if(stopAfterFindingCycle) {
            return;
        }
        visited[s] = true;
        visitOrder[s] = order++;
        for(int i : graph[s].adj) {
            if(!stopAfterFindingCycle)
                if(!visited[i]) {
                    System.out.println(graph[s].name + " " + graph[i].name + " is a discovered edge.");
                    preNode[i] = s;
                    //Subsequently, perform a complete depth-first search of i (demonstrates how this is a recursive
                    //graph search algorithm.
                    findCycleByDFS(i);
                } else if((preNode[s] != i) && (visitOrder[s] > visitOrder[i])) {
                    System.out.println(graph[s].name + " " + graph[i].name + " is a back edge, we did in fact find a cycle: ");
                    System.out.print(graph[s].name + " ");
                    int back = s;
                    while(back != i) {
                        back = preNode[back];
                        System.out.print(graph[back].name + " ");
                    }
                    System.out.println();
                    stopAfterFindingCycle = true;
                    return;
                }
        }
    }

    //Performs a depth-first search of the graph starting from a given Vertex.
    //NOTE: DEPTH FIRST SEARCH CAN ONLY HELP YOU FIND A CYCLIC PATH ON THE GRAPH, NOT THE MINIMAL DISTANCE BETWEEN
    //TWO NODES ON THE GRAPH!
    public void depreciatedDFS(int s) {
        if (visited[s]) {
            return;
        }
        visited[s] = true;
        System.out.println(graph[s].name);
        for (int i : graph[s].adj) {
            if (preNode[s] != i) {
                preNode[i] = s;
                if (!visited[i]) {
                    System.out.println(graph[s].name + " " + graph[i].name + " is a discovered edge.");
                    dfs(i);
                } else if (s != 0) {
                    System.out.println(graph[s].name + " " + graph[i].name + " is a back edge.");
                }
            }
        }
    }

    //Original code for the depth-first search graph traversal (revised version shown above)
    /*
    //NOTE: DEPTH FIRST SEARCH CAN ONLY HELP YOU FIND A CYCLIC PATH ON THE GRAPH, NOT THE MINIMAL DISTANCE BETWEEN
    //TWO NODES ON THE GRAPH!
    public void dfs(Vertex s) {
        s.visited = true;
        System.out.println(s.name);
        for (Vertex v : s.adj) {
            if (!v.visited) {
                v.preNode = s.index;
                System.out.println(s.name + " " + v.name + " is a discovery edge.");
                dfs(v);
            } else if(v.preNode != s.index) //if(v.prenode != s.index)
                System.out.println(v.name + " " + s.name + " is a back edge");
        }
    }
     */

    /*
    public void show() {
        for (Vertex v : graph) {
            System.out.print(v.name + " has the following neighbors: ");
            for (Vertex v1 : v.adj)
                System.out.print(v1.name + " ");
            System.out.println();
        }
    }
     */

    public static void main(String[] args) {
        FirstGraph fg = new FirstGraph();
        fg.createGraph();
        for(int i = 0; i < fg.GRAPH_SIZE; i++) {
            fg.preNode[i] = -1;
        }
        //fg.show();

        //fg.dfs(0);
        //fg.dfs(2);
        fg.stopRecursiveAfterFinishingPath = false;
        //fg.findPathByDFS(1, 5);
        //fg.show();
        fg.findCycleByDFS(4);

        /*
        for(int i = 0; i < fg.GRAPH_SIZE; i++) {
            //If that area has not yet been visited, perform a depth-first search of the area.
            if(!fg.visited[i]) {
                System.out.println("A new connected component from " + fg.graph[i].name);
                fg.order = 0;
                fg.dfs(i);
            }
        }
         */

        //fg.dfs(0);
        //fg.visited=new boolean[fg.graph.length];
        //for (int i=0;i<fg.graph.length;i++)
            //fg.visited[i]=false;
    }

    class Vertex {
        char name;
        ArrayList<Integer> adj;
        public Vertex(char name) {
            this.name = name;
            adj = new ArrayList();
        }
    }

    /*
    class Vertex {
        char name;
        int index;
        ArrayList<Vertex> adj;
        boolean visited;
        int preNode;

        public Vertex(char name, int index) {
            this.name = name;
            adj = new ArrayList();
            visited = false;
            this.index = index;
            preNode = -1;
        }
    }
     */
}