class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>(); 
        List<String> curr = new ArrayList<>();
        backtrack(ans, curr, 0, 0, s);
        return ans; 
    }

    private void backtrack(List<List<String>> ans, List<String> curr,
    int i, int j, String s)
    {
        if (j >= s.length())
            {if (i==j)
                ans.add(new ArrayList<>(curr));
            return; 
            }

        if (isPalindrome(s.substring(i, j+1)))
            {   curr.add(s.substring(i, j+1));
                backtrack(ans, curr, j+1, j+1,s);
                curr.remove(curr.size() -1);
            }
        
        backtrack(ans,curr, i, j+1, s);

    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false; // Characters do not match, not a palindrome
            }
            left++;
            right--;
        }
        return true; // All characters matched, it's a palindrome
    }
}
