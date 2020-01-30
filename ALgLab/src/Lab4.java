import java.util.ArrayList;
import java.util.List;

public class Lab4 {
    static int[] a = new int[]{1, 3, 9, 4, 8, 5};
    static List ans = new ArrayList();
    public static void main(String[] args) {
        System.out.println(subsetSum(new int[]{1, 3, 9, 4, 8, 5}, 19));
    }

    static boolean subsetSum(int list[], int sum)
    {
        if(list.length < 1)
            return false;
        if(list.length == 1)
            if(list[0] == sum)
                return true;
            else
                return false;

        return subset_sum_util(list, 0, sum);
    }

    static boolean subset_sum_util(int list[], int starting_index, int sum)
    {
        if (sum == 0)
            return true;
        if (list.length - starting_index == 1)
            if(list[starting_index] == sum)
                return true;
            else
                return false;

        boolean result_1 = subset_sum_util(list, starting_index + 1, sum - list[starting_index]);

        boolean result_2 = subset_sum_util(list, starting_index + 1, sum);

        return result_1 | result_2;
    }


    /*

After implementing both MergeSort and MergeSortPlus I can assume that the performance of MergeSortPlus must increase a little.
But it is very unlikely to detect the improvement. Because the the algorithm switches to InsertionSort when arraysize is less than 20.
To measure a performance improvement for only a small sized array is negligeble.

    //Problem 3

    Algorithm: MergeSortPlus(input)
        Input: Unsorted array
        Output: Sorted array

            theArray <- input
            tempStorage //new array equal to input array
            mergeSort(tempStorage, 0, input.length -1)
            return theArray

            Method mergeSort(tempStorage, lower, upper)

                if lower=upper then
                    return
                else if upper-lower > 20 then
                    mid <- (lower + upper ) /2
                    mergeSort(tempStorage, lower, mid)
                    mergeSort(tempStorage, mid+1, upper)
                else
                    t <- Copy theArray from lower to upper+1
                    temp = InsertionSort.sort(t)
                    n <- upper - lower +1
                    for j<-0 to n do
                        theArray[lower+j] <- temp[j]



     */

}