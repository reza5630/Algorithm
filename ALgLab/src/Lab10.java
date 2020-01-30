public class Lab10 {
    private int[][] distance;
    String s1 = "regular";
    String s2 = "ruler";

    public static void main(String[] args) {
        Lab10 lol = new Lab10();
//        System.out.println("edit distance " + lol.computeED());
        System.out.println("Sub Sequence " + lol.computeSubsequence());
    }

    int computeSubsequence() {
        distance = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++)
            for (int j = 0; j <= s2.length(); j++)
                distance[i][j] = -1;
        return recursionSubSequenceDP(s1.length(), s2.length());
    }

/*    int computeED() {
        distance = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++)
            for (int j = 0; j <= s2.length(); j++)
                distance[i][j] = -1;
        return recursionEDDP(s1.length(), s2.length());
    }*/

    int recursionSubSequenceDP(int i, int j) {
        if (i == 0) return 0;
        else if (j == 0) return 0;
        if (distance[i - 1][j - 1] < 0) distance[i - 1][j - 1] = recursionSubSequenceDP(i - 1, j - 1);
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            distance[i][j] = 1 + distance[i - 1][j - 1];
        } else {
            if (distance[i - 1][j] < 0) distance[i - 1][j] = recursionSubSequenceDP(i - 1, j);
            if (distance[i][j - 1] < 0) distance[i][j - 1] = recursionSubSequenceDP(i, j - 1);

            distance[i][j] = getMax(distance[i - 1][j], distance[i][j - 1], distance[i - 1][j - 1]);
        }
        return distance[i][j];
    }

    int recursionEDDP(int i, int j) {
        if (i == 0) return j;
        else if (j == 0) return i;
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            if (distance[i][j] < 0) distance[i][j] = recursionEDDP(i - 1, j - 1);
        } else {
            if (distance[i - 1][j] < 0) distance[i - 1][j] = recursionEDDP(i - 1, j);
            if (distance[i][j - 1] < 0) distance[i][j - 1] = recursionEDDP(i, j - 1);
            if (distance[i - 1][j - 1] < 0) distance[i - 1][j - 1] = recursionEDDP(i - 1, j - 1);

            distance[i][j] = 1 + getMin(distance[i - 1][j], distance[i][j - 1], distance[i - 1][j - 1]);
        }
        return distance[i][j];
    }

    int recursionED(int i, int j) {
        if (i == 0) return j;
        else if (j == 0) return i;
        if (s1.charAt(i - 1) == s2.charAt(j - 1))
            return recursionED(i - 1, j - 1);
        else {
            return 1 + getMin(recursionED(i - 1, j), recursionED(i, j - 1), recursionED(i - 1, j - 1));
        }
    }


    int getMin(int x, int y, int z) {
        int ans = -1;
        if (x < y) ans = x;
        else ans = y;
        if (z < ans) ans = z;
        return ans;
    }

    int getMax(int x, int y, int z) {
        int ans = -1;
        if (x < y) ans = y;
        else ans = x;
        if (z > ans) ans = z;
        return ans;
    }
}
