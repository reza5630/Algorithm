import java.util.*;

public class Lab1 {
    public static void main(String[] args) {
        System.out.println("gcd " + gcd(12, 42) + " " + gcd(7, 9));
        System.out.println("secondSmallest " + secondSmallest(new int[]{1, 4, 2, 3}) + " " + secondSmallest(new int[]{3, 3, 4, 7}) /*+ " " + secondSmallest(new int[]{9})*/);
        System.out.println("subsetSum " + Arrays.toString(subsetSum(new int[]{1, 3, 9, 4, 8, 5}, 21)) + " " + Arrays.toString(subsetSum(new int[]{1, 3, 9}, 5)) + " " + Arrays.toString(subsetSum(new int[]{1, 3, 9, 4, 8, 5}, 0)));
    }

    //Problem 4
    static int gcd(int m, int n) {
        if (m < n)
            for (int i = m; i > 1; i--)
                if (m % i == 0 && n % i == 0)
                    return i;


        for (int i = n; i > 1; i--)
            if (m % i == 0 && n % i == 0)
                return i;

        return 1;
    }

    //Problem 5
    static int secondSmallest(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Input array too small");
        }
        //implement
        List<Integer> list = new ArrayList<>();
        for (int t : arr) {
            // Add each element into the list
            list.add(t);
        }
        Collections.sort(list);
        return list.get(1);
    }

    //Problem 6
    static int[] subsetSum(int[] arr, int k) {

        // local class
        class LocalClass {
            int[] ans = new int[]{};

            void combinationUtil(int data[], int start,
                                 int end, int sum) {
                // Current combination is ready to be printed, print it
                //System.out.println(Arrays.toString(data)+" sum "+sum);
                if (ans.length > 0) return;
                if (sum == k) {
                    ans = Arrays.copyOf(data, start);
                    return;
                } else if (sum < k) {

                    for (int i = start; i < end; i++) {
                        int temp = data[start];
                        data[start] = data[i];
                        data[i] = temp;
                        combinationUtil(data, start + 1, end, sum + data[start]);
                    }
                }
            }
        }

        LocalClass lc = new LocalClass();
        lc.combinationUtil(arr.clone(), 0, arr.length, 0);
        return lc.ans;
    }

}
