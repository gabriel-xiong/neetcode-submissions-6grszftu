class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE; 
        for (int x : piles )
            max = Math.max(max, x);
        
        int left = 1; int right = max; int best = max; 

        while (left <= right)
            {
                int speed = left + (right - left)/2; 
                double time = 0; 
                for (int x : piles )
                    time+= Math.ceil( (double) x /speed);
                
                if (time <=h)
                    {
                        best = speed; 
                        right = speed - 1; 
                    }
                
                else 
                    left = speed+1; 
            }

    return best; 

    }
}
