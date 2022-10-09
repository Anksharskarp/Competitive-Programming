/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package intermediate.coursework;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author xzou-admin
 */
public class HeapSortStructuralOutline {
    HeapandPQ hs;
    public HeapSortStructuralOutline(int size){
        hs=new HeapandPQ(10);
    }
    public HeapSortStructuralOutline(int []a){
        buildHeap(a);
        sort();
    }
    public void buildHeap(int[]a){
        hs=new HeapandPQ(a);
        //loop via the array a and insert each element into the heap
        for (int i=0;i<a.length;i++)
            hs.insert(a[i]);
    }
    public void sort(int []a){
        //while the heap is not empty, removeMin and put at the beginning of the array a 
//        int ind=0;
//        while (hs.trueSize>0){//heap is not empty
//        //remove min from heap and put back into the original array sequentially
//            int min=hs.removeMin();
//            a[ind++]=min;
//        }
        for (int i=0;i<a.length;i++)
             a[i]=hs.removeMin();
    }
    public void sort(){
        //while the heap is not empty, removeMin and put at the beginning of the array a 
//        int ind=0;
//        while (hs.trueSize>0){//heap is not empty
//        //remove min from heap and put back into the original array sequentially
//            int min=hs.removeMin();
//            a[ind++]=min;
//        }
        for (int i=0;i<hs.heap.length;i++)
             hs.removeMin();
    }
    private static void swap(int i, int j, int[] a){
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
    }
    public static void selectionSort(int[] a){
        for (int i=0;i<a.length-1;i++){
            int mi=i;
            for (int j=i+1;j<a.length;j++)
                if(a[j]<a[mi])
                    mi=j;
            if(mi!=i)
                swap(i,mi,a);
        }
    }
    public static void insertionSort(int[] a){
        for (int i=1;i<a.length;i++){
            int j=i;
            while(j>0 && a[j]<a[j-1]){
                swap(j,j-1,a);
                j--;
            }
        }
    }
    static final int MAX_V=90000;
    static final int MAX_NUM_ELE=90000;
    public static void countingSort(int []a){
        int[] counts =new int[MAX_V];
        int []b=new int[a.length];
        for (int i=0;i<a.length;i++)
            counts[a[i]]++;  //the number of elements having the same value a[i];
        for (int i=1;i<MAX_V;i++)
            counts[i]+=counts[i-1];  //number of elements having values <=i
        
        for (int i=a.length-1;i>=0;i--){
            counts[a[i]]--;
            b[counts[a[i]]]=a[i];
        }

        System.arraycopy(b, 0, a, 0, a.length);
        
    }
    static int[] ma =new int [MAX_NUM_ELE];
    private static void merger(int[] a, int fb, int fe, int se){
        int mi=0;
        int fi=fb;
        int si=fe+1;
        while (fi<=fe && si<=se)
            if(a[fi]<=a[si])
                ma[mi++]=a[fi++];
            else
                ma[mi++]=a[si++];
        while(fi<=fe)
            ma[mi++]=a[fi++];
        while (si<=se)
            ma[mi++]=a[si++];
        if (se + 1 - fb >= 0) System.arraycopy(ma, 0, a, fb, se + 1 - fb);
    }
    public static void mergeSort(int[] a, int b, int e){
        if(b>=e) return;
        int mid=b+(e-b)/2;
        mergeSort(a,b,mid);
        mergeSort(a,mid+1,e);
        merger(a,b,mid,e);
    }
    public static void main(String[] args) {
        //System.out.println("Hello World!");
        //generate random array
        int[] a =new int [MAX_NUM_ELE];  //{10, 2, 5, 3, 11, 7, 6, 9, 4,8, 2, 3,1, 10};
        
        Random ran=new Random();
        for (int i=0;i<MAX_NUM_ELE;i++)
            a[i]=ran.nextInt(MAX_V)+1;
        //
        int[] back =Arrays.copyOf(a,a.length);
        System.out.println("Begin testing heap sort ...");
        
        long stime=System.currentTimeMillis();
        HeapSortStructuralOutline hs=new HeapSortStructuralOutline(a);
        
        long etime=System.currentTimeMillis();
        System.out.println("Heap Sort takes "+(etime-stime)+" millioseconds");
        //System.out.println(Arrays.toString(a));
        
        //selectionSort(a);
        a=Arrays.copyOf(back, back.length);
        System.out.println("Begin testing merge sort ...");
        stime=System.currentTimeMillis();
        mergeSort(a,0,a.length-1);
        etime=System.currentTimeMillis();
        System.out.println("Merge Sort takes "+(etime-stime)+" milliseconds");
        
        a=Arrays.copyOf(back, back.length);
        System.out.println("Begin testing counting sort ...");
        stime=System.currentTimeMillis();
        mergeSort(a,0,a.length-1);
        etime=System.currentTimeMillis();
        System.out.println("Counting Sort takes "+(etime-stime)+" milliseconds");
        
        
         a=Arrays.copyOf(back, back.length);
        System.out.println("Begin testing insertion sort ...");
        stime=System.currentTimeMillis();
        insertionSort(a);
        etime=System.currentTimeMillis();
        System.out.println("Insertion Sort takes "+(etime-stime)+" milliseconds");
        //System.out.println(Arrays.toString(a));
        
         a=Arrays.copyOf(back, back.length);
        System.out.println("Begin testing selection sort ...");
        stime=System.currentTimeMillis();
        selectionSort(a);
        etime=System.currentTimeMillis();
        System.out.println("Selection Sort takes "+(etime-stime)+" milliseconds");
        //System.out.println(Arrays.toString(a));
        //System.out.println(Arrays.toString(a));
    }
    
    class HeapandPQ{//assume using an array
        int[]heap;
        int trueSize=0;
        public HeapandPQ(int size){
            heap=new int[size];
        }
        public HeapandPQ(int []a){
            heap=a;
            trueSize=0;
        }
        public int size(){
            return trueSize;
        }
        public boolean isEmpty(){
            return trueSize==0;
        }
        private void swap(int i,int j){
            int t=heap[i];
            heap[i]=heap[j];
            heap[j]=t;
        }
        private void upHeap(int ind){
            while(ind>0){
                int p=(ind-1)/2;//parent
                if(heap[ind]>=heap[p]) break;
                swap(ind,p);
                ind=p; //go up
            }
        }
        public void insert(int a){
            if(trueSize==heap.length) {
                System.out.println("The allocated heap size exceeded! No insertion");
                return;
            }
            heap[trueSize++]=a; //replace trueSize++ by ++trueSize, is it OK?
            //it does not work. 
            //trueSize++;  which is exactly same as ++trueSize;
            //heap[trueSize++]=a;  ==> heap[trueSize]=a; trueSize=+1;
            //heap[++trueSize]=a; ==> trueSize+=1; heap[trueSize]=a;
            upHeap(trueSize-1);
            
        }
         public void insertWithIndex(int i){
            if(trueSize==heap.length) {
                System.out.println("The allocated heap size exceeded! No insertion");
                return;
            }
            trueSize++;
            //heap[trueSize++]=a; //replace trueSize++ by ++trueSize, is it OK?
            //it does not work. 
            //trueSize++;  which is exactly same as ++trueSize;
            //heap[trueSize++]=a;  ==> heap[trueSize]=a; trueSize=+1;
            //heap[++trueSize]=a; ==> trueSize+=1; heap[trueSize]=a;
            upHeap(trueSize-1);
            
        }
        public int min(){
            if(trueSize==0)  return Integer.MIN_VALUE;
            return heap[0];
        }
        private void downHeap(int ind){
            int lc=ind*2+1;
            while (lc<trueSize){
                int sci=lc;
                int rc=ind*2+2;
                if(rc<trueSize)//right child exists
                    if(heap[lc]>heap[rc])
                        sci=rc;
                if(heap[sci]>=heap[ind]) break;
                swap(ind,sci);
                ind=sci;  //go down
                lc=ind*2+1;
            }
        }
        public int removeMin(){
            if(trueSize==0)  return Integer.MIN_VALUE;
            int min=heap[0];
            swap(0,trueSize-1);
            trueSize--; //means remove the last one
            downHeap(0);
            return min;
        }
    }
}
