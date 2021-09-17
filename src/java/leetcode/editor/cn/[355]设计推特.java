package leetcode.editor.cn;//设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个
//功能： 
//
// 
// postTweet(userId, tweetId): 创建一条新的推文 
// getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
// 
// follow(followerId, followeeId): 关注一个用户 
// unfollow(followerId, followeeId): 取消关注一个用户 
// 
//
// 示例: 
//
// 
//Twitter twitter = new Twitter();
//
//// 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
//twitter.postTweet(1, 5);
//
//// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
//twitter.getNewsFeed(1);
//
//// 用户1关注了用户2.
//twitter.follow(1, 2);
//
//// 用户2发送了一个新推文 (推文id = 6).
//twitter.postTweet(2, 6);
//
//// 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
//// 推文id6应当在推文id5之前，因为它是在5之后发送的.
//twitter.getNewsFeed(1);
//
//// 用户1取消关注了用户2.
//twitter.unfollow(1, 2);
//
//// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
//// 因为用户1已经不再关注用户2.
//twitter.getNewsFeed(1);
// 
// Related Topics 设计 哈希表 链表 堆（优先队列） 
// 👍 251 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Twitter {
    private static Map<Integer, User> userMap = new HashMap<>();
    private static int timestamp = 0;
    static class User {
        int userId;
        Twitt twittHead;
        List<Integer> followeeIdList;

        public User(int userId){
            this.userId = userId;
            followeeIdList = new ArrayList<>();
        }
        public Twitt getTwittHead(){
            return twittHead;
        }
        public int getUserId(){
            return userId;
        }
        public List<Integer> getFolloweeIdList(){
            return followeeIdList;
        }

        public void follow(int followeeId){
            followeeIdList.add(followeeId);
        }
        public void unfollow(int followeeId){
            followeeIdList.remove(followeeId);
        }
        public void setTwittHead(Twitt twittHead){
            this.twittHead = twittHead;
        }
    }
    static class Twitt{
        int time;
        int tweetId;
        Twitt next;
        public Twitt(int twittId, int time){
            this.tweetId = twittId;
            this.time = time;
        }
        public int getTime(){
            return time;
        }
        public int getTweetId(){
            return tweetId;
        }
        public Twitt getNext(){
            return next;
        }
    }

    /** Initialize your data structure here. */
    public Twitter() {

    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        User user = userMap.get(userId);
        if(user == null){
            user = new User(userId);
            userMap.put(userId, user);
        }
        Twitt twitt = new Twitt(tweetId, timestamp++);
        twitt.next = user.getTwittHead();
        user.setTwittHead(twitt);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        User user = userMap.get(userId);
        List<Integer> followeeIds = user.getFolloweeIdList();
        followeeIds.add(userId);
        PriorityQueue<Twitt> queue = new PriorityQueue<Twitt>(followeeIds.size(), (t1, t2)->t2.time-t1.time);
        for(Integer followeeId: followeeIds){
            Twitt twitt = userMap.getOrDefault(followeeId, new User(0)).getTwittHead();
            if(twitt == null){
                continue;
            }
            queue.add(twitt);
        }

        int i = 1;
        List<Integer> resultList = new ArrayList<>();
        while(!queue.isEmpty() && i <= 10){
            Twitt poll = queue.poll();
            resultList.add(poll.getTweetId());
            if (poll.next != null){
                queue.add(poll.next);
            }
        }

        return resultList;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        User follower = userMap.get(followerId);
        User followee = userMap.get(followeeId);
        if(follower == null){
            follower = new User(followerId);
            userMap.put(followerId, follower);
        }
        if(followee == null){
            followee = new User(followeeId);
            userMap.put(followeeId, followee);
        }
        follower.follow(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        User user = userMap.get(followerId);
        if(user == null){
            user = new User(followerId);
            userMap.put(followerId, user);
        }
        user.unfollow(followeeId);
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
//leetcode submit region end(Prohibit modification and deletion)
