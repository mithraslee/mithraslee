package testing.lib.library;

import java.util.*;

/**
 * Created by Yun on 1/8/2017.
 */
public class Twitter {

    /** Initialize your data structure here. */
    public Twitter() {
        count = 0;
        friends = new HashMap<>();
        tweets = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        follow(userId, userId);
        TweetTime newTweet = new TweetTime(tweetId, count++);
        if (tweets.containsKey(userId)) {
            tweets.get(userId).add(newTweet);
        } else {
            TreeSet<TweetTime> newSet = new TreeSet<>((a, b) -> b.ts - a.ts);
            newSet.add(newTweet);
            tweets.put(userId, newSet);
        }
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        LinkedList<Integer> res = new LinkedList<>();
        // This containsKey check!!!
        if (!friends.containsKey(userId)) {
            return res;
        }
        PriorityQueue<TweetTime> Q = new PriorityQueue<>((a, b) -> a.ts - b.ts);
        for (int friend : friends.get(userId)) {
            // This containsKey check!!!
            if (tweets.containsKey(friend)) {
                for (TweetTime tt : tweets.get(friend)) {
                    if (Q.size() > 0 && Q.peek().ts > tt.ts && Q.size() > 10) {
                        break;
                    }
                    Q.add(tt);
                    if (Q.size() > 10) {
                        Q.poll();
                    }
                }
            }
        }
        while(!Q.isEmpty()) {
            res.addFirst(Q.poll().tweetId);
        }
        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        // This containsKey check!!!
        if (!friends.containsKey(followerId)) {
            friends.put(followerId, new HashSet<>());
        }
        if (!friends.get(followerId).contains(followeeId)) {
            friends.get(followerId).add(followeeId);
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        // This containsKey check!!!
        if (followeeId == followerId) {
            return;
        }
        if (friends.containsKey(followerId) && friends.get(followerId).contains(followeeId)) {
            friends.get(followerId).remove(followeeId);
        }
    }

    private class TweetTime {
        int tweetId;
        int ts;
        public TweetTime(int tid, int ts) {
            tweetId = tid;
            this.ts = ts;
        }
    }
    private int count;
    private HashMap<Integer, HashSet<Integer>> friends;
    private HashMap<Integer, TreeSet<TweetTime>> tweets;
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */