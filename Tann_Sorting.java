import java.util.Random;
import java.util.Arrays;
public class Tann_Sorting {
    public static void main() {
        Random rand = new Random();
        int[] a = new int[100000];
        fillArray(a);
        //printArray(a);
        long START_TIME = System.currentTimeMillis();  
        //QuickSort(a, 0, a.length);
        InsertionSort(a);
        //printArray(a);
        verifyArray(a);
        long END_TIME = System.currentTimeMillis();
        System.out.println(END_TIME - START_TIME + "ms");
    }

    public static void fillArray(int[] a) {
        Random rand = new Random();
        for (int i = 0; i<a.length; i++) {
            a[i] = i;
        }

    }

    public static void printArray(int[] a) {
        System.out.print("[ ");
        for (int i = 0; i <a.length; i++) {
            if (i < a.length-1) System.out.print(a[i] + ","+ " ");
            else System.out.print(a[i] + " ");
        }
        System.out.println("]");
    }

    public static void QuickSort(int[]a, int start, int end) {
        if (end-start <= 1) {
            return;
        }
        int pivot = a[end-1];
        int wall = start;
        int pp = 0;
        for (int i = start; i < end; i++) {
            if (a[i] <= pivot) {
                pp = a[wall];
                a[wall] = a[i];
                a[i] = pp;
                wall++;
            }

        }
       QuickSort(a, wall, end);
       QuickSort(a, start, wall-1);
        //pivot goes to final place
    }

    public static int[] merge (int []a, int[] b) {
        int aa = 0;
        int bb = 0;
        int cc = 0;
        int[] c = new int[a.length+b.length];

        while ((aa < a.length) && (bb < b.length)) {
            if (a[aa] >= b[bb]) {
                c[cc] = b[bb];
                cc++;
                bb++;
            }
            else {
                c[cc] = a[aa];
                cc++;
                aa++;
            }
        }
        while (bb < b.length) {
            c[cc] = b[bb];
            cc++;
            bb++;
        }
        while (aa < a.length) {
            c[cc] = a[aa];
            cc++;
            aa++;
        }

        return c;
    }

    public static int[]  MergeSort (int[] a) {
        if (a.length <= 1) {
            return a;
        }
        else {
            int[] b = new int[a.length/2];
            int[] c = new int[a.length-b.length];
            for (int i = 0; i < b.length; i++) {
                b[i] = a[i];
            }
            for (int i = 0; i < c.length; i++) {
                c[i] = a[a.length-i-1];
            }
            a = merge(MergeSort(b), MergeSort(c));
            printArray(a);
            return a;
        }
    }

    public static void verifyArray(int[] a) {
        boolean order = true;
        for (int i = 0; i<a.length-1; i++ ) {
            if (a[i] > a[i+1]) {
                order = false;
                break;
            }
        }
        System.out.println(order);
    }

    public static void swap (int [] a, int i, int j) {
        int temp = a [i];
        a [i] = a [j];
        a [j] = temp;
    }

    public static void SelectionSort(int[] a) {

        for (int i=0; i<a.length-1; i++) {
            for (int j=i+1; j<a.length; j++) {
                if (a[i] > a[j]) {
                    swap(a,j,i);
                }
            }
        }
    }

    public static void InsertionSort(int[] a) {
        for (int i = 1; i<a.length; i++) {
            int x = a[i];
            int j = i-1;
            while ((j>=0) && (a[j] > x)) {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = x;
        }
    }

    private static boolean order(int[] a) {
        boolean order = true;
        for (int i = 0; i<a.length-1; i++ ) {
            if (a[i] > a[i+1]) {
                order = false;
                break;
            }
        }
        return order;
    }

    public static void BogoSort (int[] a) {
        int r = 0;
        while (!order(a)) {
            Random rand = new Random();
            for (int i = 0; i<a.length; i++) {
                r = rand.nextInt(a.length);
                swap(a,i,r);

            }
        }
    }

    public static void BubbleSort(int[] a) {
        for(int i=0; i < a.length; i++){  
            for(int j=1; j < a.length-i; j++){  
                if(a[j-1] > a[j]){  
                    swap(a,j,j-1);
                }  
            }  
        }  
    }
}