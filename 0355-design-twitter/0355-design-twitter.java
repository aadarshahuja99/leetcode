class Twitter {
    HashMap<Integer,HashSet<Integer>> followeeMap;
    HashMap<Integer, ArrayList<Integer>> tweetMap;
    public Twitter() {
        followeeMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!tweetMap.containsKey(userId))
        {
            tweetMap.put(userId, new ArrayList<>());
        }
        tweetMap.get(userId).add(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> {
            return b[0] - a[0];
        });
        var followees = followeeMap.getOrDefault(userId, new HashSet<>());
        followees.add(userId);
        for(int followee : followees)
        {
            var tweets = tweetMap.getOrDefault(followee, new ArrayList<>());
            if(tweets.size() == 0)
            {
                continue;
            }
            minHeap.add(new int[] { tweets.get(tweets.size() - 1), followee, tweets.size()-1 });
        }
        int k = 10;
        while(k-- > 0 && minHeap.size() > 0)
        {
            int[] top = minHeap.poll();
            int tweetId = top[0];
            int followee = top[1];
            int index = top[2];
            ans.add(tweetId);
            if(index - 1 >= 0)
            {
                minHeap.add(new int[] { tweetMap.get(followee).get(index-1), followee, index-1 });
            }
        }
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!followeeMap.containsKey(followerId))
        {
            followeeMap.put(followerId, new HashSet<>());
        }
        followeeMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!followeeMap.containsKey(followerId))
        {
            return;
        }
        followeeMap.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */