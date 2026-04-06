class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int num = position.length; 
        int[][] cars = new int[num][2]; 
        for (int i = 0 ; i < num; i++)
            {
                cars[i][0] = position[i];
                cars[i][1] = speed[i];
            }

        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        Deque<Double> stack = new ArrayDeque<Double>();

        stack.push((double) Integer.MIN_VALUE);

        for (int i = 0; i < num; i++)
            {
             double time = (double) (target - cars[i][0]) / (cars[i][1]);
             if (time > stack.peek())
                stack.push(time);   
            }

        return stack.size() -1; 
    }
    
}
