package org.jesperancinha.vtcc;

import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.List;

import static java.lang.Thread.sleep;

public class UserServiceJava {

    private static Logger logger = LoggerFactory.getLogger(UserServiceJava.class);

    public User fetchUser(Long userId) throws InterruptedException {
        sleep(1000);
        return new User(userId, "John Doe");
    }

    public List<Post> fetchUserPosts(Long userId) throws InterruptedException {
        sleep(1000);
        return List.of(new Post("Post 1"), new Post("Post 2"));
    }

    public List<Comment> fetchUserComments(Long userId) throws InterruptedException {
        sleep(1000);
        return List.of(new Comment("Comment 1"), new Comment("Comment 2"));
    }

    ProcessedData processUserData(User user, List<Post> posts, List<Comment> comments) {
        return new ProcessedData(user, posts, comments);
    }

    void updateUI(ProcessedData processedData) {
        logger.info(() -> STR."This is the data \{processedData}");
    }

    private void handleError(Exception e) {
        logger.error(e, () -> "An error has occurred!");
    }

}
