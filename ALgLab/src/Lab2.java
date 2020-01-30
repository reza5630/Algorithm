import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lab2 {
    public static void main(String[] args) {
        System.out.println("merge " + Arrays.toString(merge(new int[]{1, 4, 5, 8, 17}, new int[]{2, 4, 8, 11, 13, 21, 23, 25})));

        ArrayList<Integer> pain = new ArrayList<>();
        pain.add(1);pain.add(3);pain.add(9);pain.add(4);pain.add(8);pain.add(5);
        System.out.println("powerset " + powerSet(pain));
    }
/*

    //Problem 1

    int[] arrays(int n) {
        int[] arr = new int[n];             2
        for (int i = 0; i < n; ++i) {       1+ (n+1)+ n = 2n+2
            arr[i] = 1;                     2n  //this will execute n times
        }
        for (int i = 0; i < n; ++i) {       1+ (n+1)+ n = 2n+2
            for (int j = i; j < n; ++j) {   1+ (n+1)+ n = (2n+2)n = 2n+ 2n2   //this will execute n times for the outer loop
                arr[i] += arr[j] + i + j;   1+ 1+ 1+ 1+ 1+ 1+ 1 = 7n2
            }
        }
        return arr;                         1
    }

    ====================================================================
                                            T(n) = 9n2+ 8n+ 7
                                            T(n) is Θ(n2)





    //Problem 2

    Algorithm: Merge(arr1, arr2)
        Input: Two sorted integer arrays
        Output: One combined sorted integer array


        l1 <- length of arr1                        1
        l2 <- length of arr2                        1

        ans <- new Array                            0
        index <- 0                                  1

        while (l1 > 0 and l2 > 0)                   n+1

            if arr1[arr1.length - l1] > arr2[arr2.length - l2] then     2+ 1+ 2 = 5n
                ans[index] <- arr2[arr2.length - l2]            1+ 1+ 2 = 4n
                l2 <- l2 -1                                     1+ 1 = 2n
            else
                ans[index] <- arr1[arr1.length - l1]
                l1 <- l1 -1

            index <- index +1                       1+ 1 = 2n


        while l1 > 0 then                           1
            ans[index] <- arr1[arr1.length - l1]    1+ 1+ 2
            l1 <- l1 -1                             1+ 1
            index <- index +1                       1+ 1

        while l2 > 0 then                           1
            ans[index] <- arr2[arr2.length - l2]    1+ 1+ 2
            l2 <- l2 -1                             1+ 1
            index <- index +1                       1+ 1

        return ans                                  1

    ==============================================================

    From Rule-1 we can say that, T(n) is Θ(n)

    */

    static int[] merge(int[] arr1, int[] arr2) {
        int l1 = arr1.length;
        int l2 = arr2.length;
        int[] ans = new int[l1 + l2];

        int index = 0;
        while (l1 > 0 && l2 > 0) {
            if (arr1[arr1.length - l1] > arr2[arr2.length - l2]) {
                ans[index] = arr2[arr2.length - l2];
                l2--;
            } else {
                ans[index] = arr1[arr1.length - l1];
                l1--;
            }
            index++;
        }
        while (l1 > 0) {
            ans[index] = arr1[arr1.length - l1];
            l1--;
            index++;
        }
        while (l2 > 0) {
            ans[index] = arr2[arr2.length - l2];
            l2--;
            index++;
        }

        return ans;
    }

    /*




    //Problem 3
    Algorithm: RecursiveFactorial(n)
        Input: A non-negative integer n
        Output: n!
        if (n = 0 || n = 1) then                3
            return 1
        return n * recursiveFactorial(n-1)      1+ 1+ 1+ 1+ T(n-1)
  ======================================================================
                                                T(n-1) + c

    So, Master equation doesnt work for this T(n-1) term.


    Counting Self Call, we can see that recursiveFactorial is being called atleast (n-1) times incase of the worst case.
    So we can say that, T(n) is Θ(n)






    //Problem 4*/

    static List<List<Integer>> powerSet(List<Integer> x) {
        List<List<Integer>> p = new ArrayList<List<Integer>>();
        List<List<Integer>> pTemp;
        List<Integer> s = new ArrayList<Integer>();
        p.add(s);

        List t;

        while (!x.isEmpty()) {
            int f = x.remove(0);

            pTemp = new ArrayList<>();
            for (List<Integer> i : p)
                pTemp.add(new ArrayList<>(i));


            for (List<Integer> i : pTemp) {
                t = new ArrayList<Integer>(i);
                t.add(f);
                p.add(t);
            }

        }

        return p;
    }



/*    //Problem 5

    Given that,
    T(n) = T(n/2) + n       => c = 1, k = 1
                            => a = 1, b = 2
    T(1) = 1                => d = 1

    As a < b^k
    So using Master Formula we can say that, T(n) is Θ(n)


     */

}
