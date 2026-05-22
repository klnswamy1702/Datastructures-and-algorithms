class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        /* Declare an array to store the count of 
        distinct subsequences for each character in t*/
        int[] prev = new int[m + 1];

        // Initialize the count for an empty string 
        prev[0] = 1;

        // Iterate through s and t to calculate counts
        for (int i = 1; i <= n; i++) {
            /* Iterate in reverse direction to
            avoid overwriting values prematurely*/
            for (int j = m; j >= 1; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    /* If the characters match, consider two options:
                    either leave one character in s and t or leave 
                    one character in s and continue matching t*/
                    prev[j] = (prev[j - 1] + prev[j]);
                }
                /* No need for an else statement since we
                can simply leave the previous count as is*/
            }
        }

        /* The value at prev[m] contains
        the count of distinct subsequences*/
        return prev[m];
        
    }
}