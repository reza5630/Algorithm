package lab3.sortroutines;

import lab3.runtime.Sorter;

import java.text.DecimalFormat;
import java.text.NumberFormat;


public class MergeSort extends Sorter {
    final int ARRAY_SIZE = 33;
    final int MAX_VAL = 1000;
    int[] theArray;


    //public sorter
    public int[] sort(int[] input){
        int n = input.length;
        int[] tempStorage = new int[n];
        theArray = input;
        mergeSort(tempStorage,0,n-1);
        return theArray;
    }

    void mergeSort(int[] tempStorage, int lower, int upper) {
        if(lower==upper){
            return;
        }

        else {
            int mid = (lower+upper)/2;
            mergeSort(tempStorage,lower,mid);  //sort left half
            mergeSort(tempStorage,mid+1, upper); //sort right half
            merge(tempStorage,lower,mid+1,upper); //merge them
        }
    }

    /** Merges the ranges [lower, mid] and [midPlusOne,upper] in place */
    private void merge(int[] tempStorage, int lower, int midPlusOne, int upper) {
        int pos = 0; //tempStorage index
        int i = lower;
        int j = midPlusOne;
        int n = upper - lower + 1; //total number of elements to rearrange

        //view the range [lower,upper] as two arrays
        //[lower, mid], [midPlusOne,upper] to be merged

        while(i < midPlusOne && j <= upper){
            if(theArray[i] <= theArray[j])
                tempStorage[pos++] = theArray[i++];
            else
                tempStorage[pos++] = theArray[j++];

        }
        while(i < midPlusOne) {
            tempStorage[pos++] = theArray[i++];
        }
        while(j <= upper){
            tempStorage[pos++] = theArray[j++];
        }
        //replace the range [lower,upper] in theArray with
        //the range [0,n-1] just created in tempStorage
        for(j=0; j<n; ++j) {
            theArray[lower+j] = tempStorage[j];
        }

    }

    //set up routines
    public static void main(String[] args){
        long start = System.currentTimeMillis();

        MergeSort ms = new MergeSort();
        //ms.testMerge();
        int[] arr = {1,4,2,5,6,1,7,9,0,12,43,55,13,22,54,32,66,77,44,123,42,78,65,34,98,67,68,99,80,57,58,91,61,71,81,50};
        int[] returnArr = ms.sort(arr);
        for (int i : returnArr) {
            System.out.print(i + " ");
        }


        long end = System.currentTimeMillis();
        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.print("\nExecution time is " + formatter.format((end - start) / 1000d) + " seconds");

    }


}
