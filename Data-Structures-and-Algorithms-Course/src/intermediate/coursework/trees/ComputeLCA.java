package intermediate.coursework.trees;

public class ComputeLCA {
    public static void main(String[] args) {

    }

    /*
    // Computes the lowest common ancestor. If a is an ancestor of b, return to a.
    public static int lca(int a, int b) {
        int beforeLCAfromA;
        int beforeLCAfromB;
        boolean swapped = false;
        if(d[a] < d[b]) {
            int t = a;
            a = b;
            b = t;
            swapped = true;
        }

        //Go to a's ancestor, until its depth is less than the depth of b
        //Its ancestor then becomes the new 'a'
        for(int j = LOGN - 1; j >= 0; j--) {
            if(p[a][j] >= 0 && b >= 0 && d[p[a][j]] >= d[b]) {
                beforeLCAfromA = a;
                a = p[a][j];
            }
        }

        //Go to b's ancestor, until its depth is less than the depth of a.
        //Its ancestor then becomes the new 'b'
        for(int j = LOGN - 1; j >= 0; j--) {
            if(p[b][j] >= 0 && a >= 0 && d[p[b][j]] >= d[a]) {
                beforeLCAfromB = b;
                b = p[b][j];
            }
        }

        //Go to a and b's ancestor in parallel
        for(int j = LOGN - 1; j >= 0; j--) {
            if(p[a][j] != p[b][j]) {
                beforeLCAfromA = a;
                beforeLCAfromB = b;
                a = p[a][j];
                b = p[b][j];
            }
        }

        if(a == b) {
            return a;
        } else {
            return p[a][0];
        }
    }
    */
}
