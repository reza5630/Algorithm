public class Lab3 {
    public static void main(String[] args) {
    }
/*
    //Problem 1
    A. Will Goofy’s sorting procedure work at all? Explain
        This algorithm will work. This is like finding permutation. As if we are looking for certain sequence from given array.
        However, as size of n will get larger, the worst case for this algorithm will increase expotentially.

    B. What is a best case for GoofySort?
        The best case scenario will be if the gvien array is already in sorted order.

    C. What is the running time in the best case?
        Best Case runtime Θ(n).

    D. What is the worst-case running time?
        Worst Case runtime Θ(infinity).

    E. Is the algorithm inversion-bound?
        For unsorted array, number of inversion is n(n-1)/2. Suppose our array size is n=3.
        So, numOfInversion = 3
            numOfComparision = 2
        Therefore, there are typically more inversions than comparisons proving that it is not inversion-bound.


    //Problem 2

    Algorithm: SortingAlg(arr)
        Input: An unsorted array of {0,1,2}
        Output: An sorted array

        count0 <- 0
        count1 <- 0
        count2 <- 0

        for i <- 0 to i <- arr.length then
            if(arr[i]=0)
                count0 <- count0 +1
            else if(arr[i]=1)
                count1 <- count1 +1
            else
                count2 <- count2 +1

        count <- 0
        for i <- 0 to i <- count0 then
            arr[count] <- 0
            count <- count + 1

        for i <- 0 to i <- count1 then
            arr[count] <- 1
            count <- count + 1

        for i <- 0 to i <- count2 then
            arr[count] <- 2
            count <- count + 1

        return arr

   ==================================================
   The above algorithm doesnt contain any nested loop, recursive call nor uses any data structure.
   So, SortingAlg works in Θ(n).







   //Problem 3
   What are the results? Are the results what you expected? Explain why the running times turned out the way they did?

    Output for my program is
    68 ms -> InsertionSort
    168 ms -> SelectionSort
    700 ms -> BubbleSort2
    745 ms -> BubbleSort1
    771 ms -> BubbleSort

    This shows because of the improvement in checking(BubbleSort1) if the input is already sorted or not will help with some extra looping.
    Also for BubbleSort2, we are adding one more improvement. That is, after every outer loop iteration, Max value in the existing array gets sorted.
    So for every outer loop iteration we can leave one element for checking, as it is already sorted.
    It might not seem useful, but shows really good result when considered for larger input size.



   //Problem 4
    Algorithm: SortingAlg(arr, n)
        Input: A sorted array of {0,1}
        Output: number of Zeroes and Ones

        notFound <- true
        m <- n/2

        while notFound=true then
            if arr[m] = 0 and arr[m+1]=0 then
                m <- (n-m)/2
            else if arr[m] = 1 and arr[m+1] = 1 then
                m <- m/2
            else
                notFound<-false


        numberOfZeroes <- m+1
        numberOfOnes <- n-m-1

  =========================================================

    This Algorithm works on binary search. As we already know binary search Time complexity is Θ(logn).
    So, for given solution has T(n) is o(n).
 */

}
