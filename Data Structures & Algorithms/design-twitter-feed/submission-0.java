class Twitter {
    Map<Integer, Set<Integer>> follows = new HashMap<>();
    Map<Integer, List<int[]>> tweets = new HashMap<>();  
    int timestamp = 0;

    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new int[]{timestamp++, tweetId}); 
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>(); 
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        
        Set<Integer> news = new HashSet<Integer>(); 
        news.add(userId); 
        news.addAll(follows.getOrDefault(userId, new HashSet<Integer>()));

        for (int id: news)
        {
            for (int[] x : tweets.getOrDefault(id, new ArrayList<int[]>()))
                {   System.out.println("id " +  id + Arrays.toString(x));
                    pq.offer(x);
                    if (pq.size() > 10)
                        pq.poll(); 
                }
        }
        while (!pq.isEmpty())
            feed.add(pq.poll()[1]);

         Collections.reverse(feed); 
         return feed; 
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        follows.putIfAbsent(followerId, new HashSet<>());
        follows.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (follows.containsKey(followerId)) {
            follows.get(followerId).remove(followeeId);
        }
    }
}
