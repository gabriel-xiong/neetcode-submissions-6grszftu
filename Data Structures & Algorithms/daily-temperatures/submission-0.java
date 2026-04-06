class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

       int days = temperatures.length; 

       int[] result = new int[days]; 
       Arrays.fill(result, 0);

       int[] maxes = new int[days]; 
       Deque<int[]> stack = new ArrayDeque<>(); 

       stack.push(new int[]{Integer.MAX_VALUE, -1});
       for (int i = 0; i < days; i++)
         {
            if (temperatures[i] <= stack.peek()[0])
                {
                    stack.push(new int[]{temperatures[i], i});
                }
            else 
            {   
                while (!stack.isEmpty() && stack.peek()[0] < temperatures[i])
                    {
                        int[] pair = stack.pop();
                        result[pair[1]] = i - pair[1]; 
                    }
                
                stack.push(new int[]{temperatures[i], i});
            }
         }

         return result;

         }
}
