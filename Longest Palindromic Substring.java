class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n <= 1) return s;

        boolean[][] dp = new boolean[n][n];
        int start = 0, maxLength = 1;

        // Base case: Single character substrings are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Check substrings of length 2 and up
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1; // Ending index

                if (s.charAt(i) == s.charAt(j)) {
                    // Two-character string or inner substring is a palindrome
                    if (len == 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        
                        if (len > maxLength) {
                            start = i;
                            maxLength = len;
                        }
                    }
                }
            }
        }

        return s.substring(start, start + maxLength);
    }
}
