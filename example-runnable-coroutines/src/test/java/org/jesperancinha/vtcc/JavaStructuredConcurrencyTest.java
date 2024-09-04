package org.jesperancinha.vtcc;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.StructuredTaskScope;

public class JavaStructuredConcurrencyTest {

    private UserViewModelJava userViewModelJava = new UserViewModelJava();

    @Test
    public void testJavaConcurrency() {
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            var userDeferred = scope.fork(() -> userViewModelJava.fetchUser(10L));
            var postsDeferred = scope.fork(() -> userViewModelJava.fetchUserPosts(10L));
            var commentsDeferred = scope.fork(() -> userViewModelJava.fetchUserComments(10L));
            scope.join();
            scope.throwIfFailed();
            var processedData = userViewModelJava.processUserData(
                    userDeferred.get(), postsDeferred.get(), commentsDeferred.get());
            userViewModelJava.updateUI(processedData);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
