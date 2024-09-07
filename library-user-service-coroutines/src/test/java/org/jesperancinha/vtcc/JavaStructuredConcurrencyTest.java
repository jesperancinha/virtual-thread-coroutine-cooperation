package org.jesperancinha.vtcc;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.StructuredTaskScope;

public class JavaStructuredConcurrencyTest {

    private UserServiceJava userServiceJava = new UserServiceJava();

    @Test
    public void testJavaConcurrency() {
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            var userDeferred = scope.fork(() -> userServiceJava.fetchUser(10L));
            var postsDeferred = scope.fork(() -> userServiceJava.fetchUserPosts(10L));
            var commentsDeferred = scope.fork(() -> userServiceJava.fetchUserComments(10L));
            scope.join();
            scope.throwIfFailed();
            var processedData = userServiceJava.processUserData(
                    userDeferred.get(), postsDeferred.get(), commentsDeferred.get());
            userServiceJava.updateUI(processedData);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
