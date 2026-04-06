class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        Arrays.sort(hand); 
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: hand)
        {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int start = 0; 
        if (hand.length % groupSize !=0)
            return false; 
        
        int numHands = hand.length / groupSize; 
        while (numHands > 0)
        {
            for (int i = hand[start]; i < hand[start] + groupSize; i++)
            {
                if (!map.containsKey(i) || map.get(i) <= 0)
                    return false; 
                map.put(i, map.get(i) - 1);
            }

            while (start < hand.length && map.get(hand[start]) <=0)
                start++; 
            numHands--; 
        }

        return true; 
    }
}
