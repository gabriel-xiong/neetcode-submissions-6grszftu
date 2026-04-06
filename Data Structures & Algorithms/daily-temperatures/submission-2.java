class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int days = temperatures.length;
        Deque<int[]> stack = new ArrayDeque<>();

        int[] ans = new int[days];

        for (int i = 0; i < days; i++)
        {   
            while (!stack.isEmpty() && temperatures[i] > stack.peek()[0])
                {
                    int[] arr = stack.pop(); 
                    int index = arr[1];
                    ans[index] = i - index; 
                }

            stack.push(new int[] {temperatures[i], i});
        }

        return ans; 
        
        }
         
}
