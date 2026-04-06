class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];

        for (int i = 0; i <= n; i++)
            ans[i] = getOnes(i);

        return ans; 
    }

    static int getOnes(int n)
    {   int count = 0; 
        for (int i = 0; i < 32; i++)
            if ((n >> i & 1) != 0)
                count++;
        return count; 
    }
}
