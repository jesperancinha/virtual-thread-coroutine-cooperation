package org.jesperancinha.vtcc;

import org.jesperancinha.vtcc.userservice.Comment;
import org.jesperancinha.vtcc.userservice.Post;
import org.jesperancinha.vtcc.userservice.ProcessedData;
import org.jesperancinha.vtcc.userservice.User;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.atomic.AtomicReference;

import static java.lang.Thread.sleep;

public class UserServiceJVTJava {

    private static Logger logger = LoggerFactory.getLogger(UserServiceJVTJava.class);
    private AtomicReference<Set<ProcessedData>> dummySystem = new AtomicReference(new HashSet());

    public Set<ProcessedData> getAllUsers() {
        return dummySystem.get();
    }

    public void loadUserData(Long userId) {
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            var userDeferred = scope.fork(() -> fetchUser(userId));
            var postsDeferred = scope.fork(() -> fetchUserPosts(userId));
            var commentsDeferred = scope.fork(() -> fetchUserComments(userId));
            scope.join();
            scope.throwIfFailed();
            var processedData = processUserData(
                    userDeferred.get(), postsDeferred.get(), commentsDeferred.get());
            updateUI(processedData);
            logger.info(() -> "Complete!");
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

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
        dummySystem.get().add(processedData);
    }

    private void handleError(Exception e) {
        logger.error(e, () -> "An error has occurred!");
    }

}
