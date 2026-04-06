class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE; 
        for (int x : piles )
            max = Math.max(max, x);
        
        int left = 1; int right = max; 
        int ans = -1; 
        while (left <=right)
        {
            int mid = left + right >> 1; 
            int total = 0; 
            for (int p : piles)
                total+= (Math.ceil((double) p/mid));
            
            if (total <= h)
            {
                 right = mid - 1; 
                 ans = mid; 
            }
               
            
            if (total > h)
                left = mid + 1; 
        }


    return ans; 

    }
}
