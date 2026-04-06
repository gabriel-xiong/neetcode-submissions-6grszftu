class Solution {
    public boolean isPalindrome(String s) {
        int left = 0; int right = s.length()-1; 
        s = s.toLowerCase();
        while (left < s.length() && right >=0)
        {
            char c1 = s.charAt(left); char c2 = s.charAt(right);
            if (!Character.isLetterOrDigit(c1))
                {
                    left++;
                    continue; 
                }
            if (!Character.isLetterOrDigit(c2))
                {
                    right--;
                    continue; 
                }
            if (c1!=c2)
                {
                    System.out.println(c1);
                    System.out.println(c2);
                    return false; 
                }
                
            left++;
            right--;
        }
        return true; 
    }
}
