class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int days = temperatures.length;
        int[] ans = new int[days];

        Deque<int[]> stack = new ArrayDeque<>();

        stack.push(new int[] {Integer.MAX_VALUE, -1});

        for (int i = 0; i < temperatures.length; i++)
        {
            while (temperatures[i] > stack.peek()[0])
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
