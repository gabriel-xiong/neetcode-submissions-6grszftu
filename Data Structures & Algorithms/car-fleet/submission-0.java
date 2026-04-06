class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int cars = position.length; 
        int[][] allCars = new int[cars][2];
        for (int i = 0; i<cars; i++)
        {
            allCars[i][0] = position[i];
            allCars[i][1] = speed[i];
        }

        Arrays.sort(allCars, (a, b) -> Integer.compare(b[0], a[0]));

        Deque<Double> stack = new ArrayDeque<Double>();
        
        stack.push(-1000.0);

        for (int i = 0 ; i < cars; i++)
        {
            int pos = allCars[i][0];
            int pace = allCars[i][1]; 

            double time = (double) (target - pos)/pace;

            if (time > stack.peek())
                stack.push(time);
        }

        int count = 0; 

        while (!stack.isEmpty())
        {
            stack.pop();
            count++;
        }

        return count-1; 

    }
}
