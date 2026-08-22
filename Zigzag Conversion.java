class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        StringBuilder result = new StringBuilder();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < s.length(); j += cycleLen) {
                // Add the main character in the vertical column
                result.append(s.charAt(j + i));
                
                // Add the intermediate character for inner rows (diagonal steps)
                int secondIndex = j + cycleLen - i;
                if (i != 0 && i != numRows - 1 && secondIndex < s.length()) {
                    result.append(s.charAt(secondIndex));
                }
            }
        }

        return result.toString();
    }
}
