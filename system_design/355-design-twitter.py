class Twitter:

    def __init__(self):
        self.tweets = {}
        self.followers = {} 
        self.time = 0 

    def postTweet(self, userId: int, tweetId: int) -> None:
        
        if userId not in self.tweets:
            self.tweets[userId] = []
        self.time += 1
        self.tweets[userId].append((self.time, tweetId))

    def getNewsFeed(self, userId: int) -> List[int]:

        recent_posts = []

        if userId in self.tweets:
            recent_posts.extend(self.tweets[userId])

        if userId in self.followers:
            for followeeId in self.followers[userId]:
                if followeeId in self.tweets:
                    recent_posts.extend(self.tweets[followeeId])

        recent_posts.sort(reverse=True)

        return [tweetId for _, tweetId in recent_posts[:10]]

    def follow(self, followerId: int, followeeId: int) -> None:

        if followerId not in self.followers:
            self.followers[followerId] = set()
        self.followers[followerId].add(followeeId)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        if followerId in self.followers:
            self.followers[followerId].discard(followeeId)

        


# Your Twitter object will be instantiated and called as such:
# obj = Twitter()
# obj.postTweet(userId,tweetId)
# param_2 = obj.getNewsFeed(userId)
# obj.follow(followerId,followeeId)
# obj.unfollow(followerId,followeeId)
