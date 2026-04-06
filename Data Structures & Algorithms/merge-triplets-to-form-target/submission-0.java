class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] valid = new boolean[triplets.length];
        Arrays.fill(valid, true);
        for (int i = 0; i < triplets.length; i++)
        {
            if (triplets[i][0] > target[0] || triplets[i][1] > target[1]
            || triplets[i][2] > target[2])
                valid[i] = false; 
        }
        
        boolean match1 = false; boolean match2 = false; boolean match3 = false; 
        for (int i = 0; i < triplets.length; i++)
        {
            if (valid[i])
            {
                if (triplets[i][0] == target[0])
                    match1 = true; 
                if (triplets[i][1] == target[1])
                    match2 = true; 
                if (triplets[i][2] == target[2])
                    match3 = true; 
            }
        }

        return match1 && match2 && match3; 
    }
}
