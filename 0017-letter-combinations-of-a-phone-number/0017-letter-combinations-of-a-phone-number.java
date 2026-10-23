import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();

        if (digits.length() == 0) {
            return ans;
        }

        String[] letters = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        solve(digits, 0, "", ans, letters);

        return ans;
    }

    public void solve(String digits, int index, String current,
                      List<String> ans, String[] letters) {

        if (index == digits.length()) {
            ans.add(current);
            return;
        }

        int digit = digits.charAt(index) - '0';

        String str = letters[digit];

        for (int i = 0; i < str.length(); i++) {
            solve(digits, index + 1, current + str.charAt(i),
                  ans, letters);
        }
    }
}