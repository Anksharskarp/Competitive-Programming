package intermediate.coursework.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

class TreeLowestCommonAncestor {
    //an nlog(n) algorithm to compute lowest common ancestor of any two nodes in a tree
    //this one also provide topEdge function.
    ArrayList<Integer>[] edges;//=new ArrayList[MAXN];
    int[][] p;//=new int[MAXN][20];
    int LOGN;
    int[] d;//=new long[MAXN];
    int N;
    int beforeLCAfromA;
    int beforeLCAfromB;

    public TreeLowestCommonAncestor(ArrayList<Integer>[] edges) {
        this.edges = edges;
        N = edges.length;
        LOGN = (int) (Math.log10(N) / Math.log10(2)) + 1;
        p = new int[N][LOGN];
        d = new int[N];
        precompute();

    }

    private void dfs(int i, int par, int depth) {   //this recursive does not work, implement and using the new one with stack
        p[i][0] = par;
        d[i] = depth;
        Stack<TreeLowestCommonAncestor.ForStack> stack = new Stack<TreeLowestCommonAncestor.ForStack>();
        stack.push(new ForStack(i, par, depth));
        while (!stack.isEmpty()) {
            ForStack fs = stack.pop();
            p[fs.node][0] = fs.par;
            d[fs.node] = fs.value;
            for (int j : edges[fs.node])
                if (j != fs.par) {
                    stack.push(new ForStack(j, fs.node, fs.value + 1));
                }
        }
    }


    private void precompute() {
        dfs(0, -1, 0);   //simply compute the depth and its parent of each node.
                /*p[i][j]:  for node i, its 2^j's ancestor.
                Ex. j=0: 2^0=1, i.e., its first ancestor, that is its parent.
                j=1: 2^1=2, its second upward ancestor, that is its grandparent.
                j=2: 2^2=4: its forth upward sncestor, that is its grandparent's grandparent.
                this way, the depth of its upward ancestors can be 2^{log(N)} generations.
                */
        // initialize as -1
        for (int i = 0; i < N; i++)
            for (int j = 0; j < LOGN; j++)
                p[i][i] = -1;

        //initialize all p[i][0] to their parent:
        //for (int i=0;i<N;i++) p[i][0]= their parent;

        //for each j, compute i's 2^j ancestor
        //which is its 2^{j-1}'s ancestor's 2^{j-1}'s ancestor
        for (int j = 1; j < LOGN; j++)
            for (int i = 0; i < N; i++)
                if (p[i][j - 1] == -1)
                    p[i][j] = -1;
                else
                    p[i][j] = p[p[i][j - 1]][j - 1];
    }

    int lca(int a, int b) {   //   compute lowest common ancesor.  If a is an ancesor of b, then return a.
        boolean swapped = false;
        if (d[a] < d[b]) {
            int t = a;
            a = b;
            b = t;
            swapped = true;
        }
        //go to a's ancestor, until its depth is less than the depth of b
        //its ancestor becomes new a
        for (int j = LOGN - 1; j >= 0; j--)
            if (p[a][j] >= 0 && b >= 0 && d[p[a][j]] >= d[b]) {
                beforeLCAfromA = a;
                a = p[a][j];
            }
        //go to b's ancestor, until its depth is less than the depth of a
        //its ancestor becomes new b
        for (int j = LOGN - 1; j >= 0; j--)
            if (p[b][j] >= 0 && a >= 0 && d[p[b][j]] >= d[a]) {
                beforeLCAfromB = b;
                b = p[b][j];
            }
        //go to a and b's ancestor in parallel
        for (int j = LOGN - 1; j >= 0; j--)
            if (p[a][j] != p[b][j]) {
                beforeLCAfromA = a;
                beforeLCAfromB = b;
                a = p[a][j];
                b = p[b][j];
            }
//            if (a==b)
//                return a;
//            else
//                return p[a][0];
//        }

        if (a == b) {
            if (swapped) {
                int t = beforeLCAfromA;
                beforeLCAfromA = beforeLCAfromB;
                beforeLCAfromB = t;
            }
            return a;
        }
        beforeLCAfromA = a;
        beforeLCAfromB = b;
        if (swapped) {
            int t = beforeLCAfromA;
            beforeLCAfromA = beforeLCAfromB;
            beforeLCAfromB = t;
        }
        return p[a][0];

    }

    int getBeforeLCAFromA() {
        return beforeLCAfromA;
    }

    int getBeforeLCAFromB() {
        return beforeLCAfromB;
    }

    int topEdge(int top, int bot) {   //compute the closest node connecting to node top among the path from bot to top.
        if (top == bot)
            return -1;
        for (int j = LOGN - 1; j >= 0; j--)
            if (p[bot][j] >= 0 && d[p[bot][j]] > d[top])
                bot = p[bot][j];
        return bot;
    }

    class ForStack {
        int node;
        int par;
        int value;

        public ForStack(int n, int par, int v) {
            node = n;
            this.par = par;
            value = v;
        }
    }
}


class TarjanLowestCommonAncestor {
    //this is O(n) algorithm to compute the ancestors of pairs of nodes in a tree, assume that the pairs for their LCA have been given already,
    //this one does not provide topEdge function.
    DisjointSets ds;
    ArrayList<Integer>[] children;   //this is in fact, the tree its self.  Each tree node uses a arrayList to list its neighbors.
    ArrayList<Integer>[] pairs;      //the size of pairs is same as the tree size.  If there is no given pair for a node, its arrayList is an empty list.
    int[] ancestor;
    boolean[] visited;
    HashMap<String, Integer> pairAncestor;

    public TarjanLowestCommonAncestor(ArrayList<Integer>[] children, ArrayList<Integer>[] pairs) {
        ds = new DisjointSets(children.length);
        this.children = children;
        this.pairs = pairs;
        ancestor = new int[children.length];
        visited = new boolean[children.length];
        pairAncestor = new HashMap<String, Integer>();
    }

    public int returnAncestor(int a, int b) {
        String ps;
        if (a < b)
            ps = a + " " + b;
        else
            ps = b + " " + a;
        return pairAncestor.get(ps);
    }

    public void TarjanOLCA(int node, int parent) {
        ds.make_Set(node);
        ancestor[node] = node;
        for (int v : children[node])
            if (v != parent) {
                TarjanOLCA(v, node);
                ds.union(node, v);
                ancestor[ds.find_set(node)] = node;
            }
        visited[node] = true;
        for (int v : pairs[node])
            if (visited[v]) {
                String ps;
                if (node < v)
                    ps = node + " " + v;
                else
                    ps = v + " " + node;
                pairAncestor.put(ps, ancestor[ds.find_set(v)]);
            }
//        //MakeSet(u);
//         //u.ancestor := u;
//     for each v in u.children do
//         TarjanOLCA(v);
//         Union(u,v);
//         Find(u).ancestor := u;
//     u.color := black;
//     for each v such that {u,v} in P do
//         if v.color == black
//             print "Tarjan's Lowest Common Ancestor of " + u +
//                   " and " + v + " is " + Find(v).ancestor + ".";

    }

    public void TarjanOLCA_Non_recursive(int node, int parent) {
        //note:  this non recursive one will be better and can avoid stack overflow.
        ds.make_Set(node);
        ancestor[node] = node;
        Stack<CP> stack = new Stack();
        stack.push(new CP(node, parent, false));
        while (!stack.isEmpty()) {
            CP cp = stack.pop();
            node = cp.child;
            if (!cp.in) {
                cp.in = true;
                stack.push(cp);
                for (int v : children[node])
                    if (v != cp.parent) {
                        //TarjanOLCA(v,node);
                        stack.push(new CP(v, node, false));
                        ds.make_Set(v);
                        ancestor[v] = v;
                    }
            } else {
                visited[node] = true;
                for (int v : pairs[node])
                    if (visited[v]) {
                        String ps;
                        if (node < v)
                            ps = node + " " + v;
                        else
                            ps = v + " " + node;
                        pairAncestor.put(ps, ancestor[ds.find_set(v)]);
                    }
                if (cp.parent != -1) {
                    ds.union(node, cp.parent);
                    ancestor[ds.find_set(node)] = cp.parent;//node;
                }

            }
        }
    }

    class CP {
        int child, parent;
        boolean in;

        public CP(int c, int p, boolean in) {
            child = c;
            parent = p;
            this.in = in;
        }
    }
}

class DisjointSets {
    //disjoint set, more efficient, using union by rank along with path compression
    // there are more functions in this one.
    //parentRank is an internal class used in this class.
    parentRank[] disjointSets = null;
    //private List<Integer> disjointSet;
    int numSets = 0;

    public DisjointSets(int maxNumber) {
        //just initialize the size
        //disjointSet=new ArrayList<Integer>();
        disjointSets = new parentRank[maxNumber];
    }

    public DisjointSets(int maxNumber, boolean createSets) {
        //in addition initialize, also create all single size sets.
        //  disjointSet=new ArrayList<Integer>();
        disjointSets = new parentRank[maxNumber];
        //numSets=maxNumber;
        if (createSets)
            for (int i = 0; i < maxNumber; i++)
                make_Set(i);
    }

    public void make_Set(int x) {
        parentRank pr = new parentRank(x, 0, 1);   //initialize, x is itsself parent, rank 0, and size 1.
        //disjointSet.add(new Integer(x));
        disjointSets[x] = pr;
        numSets++;
    }

    public void union(int x, int y) {
        int rx = find_set(x);
        int ry = find_set(y);
        if (rx != ry)
            link(rx, ry);
    }

    private void link(int x, int y) {
        //link the short depth set to the larger depth set
        if (disjointSets[x].rank > disjointSets[y].rank) {
            disjointSets[y].parent = x;
            disjointSets[x].size = disjointSets[x].size + disjointSets[y].size;
            //remove set y
            //disjointSet.remove(new Integer(y));
            numSets--;
        } else {
            disjointSets[x].parent = y;
            disjointSets[y].size = disjointSets[y].size + disjointSets[x].size;
            if (disjointSets[x].rank == disjointSets[y].rank)
                disjointSets[y].rank++;
            // remove set x;
            //disjointSet.remove(new Integer(x));
            numSets--;
        }
    }

    public int find_set(int x) {
        parentRank pr = disjointSets[x];
        if (x != pr.parent)
            pr.parent = find_set(pr.parent);
        return pr.parent;
    }

    public int numberOfSets() { //how many sets or connected components.
        return numSets;//disjointSet.size();
    }

    public int sizeOfOneSet(int x) {// the size of this set, or this connected componennt
        int rt = find_set(x);
        return disjointSets[rt].size;
    }

    class parentRank {
        int parent;
        int rank;
        int size;

        public parentRank(int parent, int rank, int size) {
            this.parent = parent;
            this.rank = rank;
            this.size = size;
        }
    }
}