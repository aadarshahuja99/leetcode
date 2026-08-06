import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Solution {
    
    // Explicitly bounded thread pool to manage network latency safely
    private final ExecutorService threadPool = Executors.newFixedThreadPool(20);

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        // 1. Extract target hostname from the initial entry URL
        String targetHostname = getHostname(startUrl);

        // 2. Thread-safe set to track visited URLs and prevent infinite loops
        Set<String> visited = ConcurrentHashMap.newKeySet();
        visited.add(startUrl);

        try {
            // 3. Kick off the recursive, non-blocking asynchronous pipeline
            crawlAsync(startUrl, targetHostname, visited, htmlParser).get();
        } catch (Exception e) {
            // In a production environment, log metrics or handle the interrupted state here
        } finally {
            // 4. Always shut down your executor to prevent thread resource leaks
            threadPool.shutdown();
        }

        // Return all successfully discovered and visited URLs
        return new ArrayList<>(visited);
    }

    /**
     * Recursive Async Task: Crawls a page, filters discovered links, 
     * and spawns new sub-tasks completely non-blockingly.
     */
    private CompletableFuture<Void> crawlAsync(String url, String targetHostname, Set<String> visited, HtmlParser htmlParser) {
        
        // Step A: Submit the heavy, slow network IO call to our worker pool
        return CompletableFuture.supplyAsync(() -> {
            // This is the blocking network call provided by the LeetCode API
            return htmlParser.getUrls(url);
        }, threadPool)
        
        // Step B: Once the network call finishes, process the results on the same thread
        .thenCompose(discoveredUrls -> {
            List<CompletableFuture<Void>> subTasks = new ArrayList<>();

            for (String nextUrl : discoveredUrls) {
                // Constraint Check: Must match the hostname AND must not be crawled already
                if (getHostname(nextUrl).equals(targetHostname) && visited.add(nextUrl)) {
                    // Fork: Recursively spawn a new asynchronous sub-pipeline for this link
                    subTasks.add(crawlAsync(nextUrl, targetHostname, visited, htmlParser));
                }
            }

            // Step C: Collective Orchestration
            // Combines all sub-tasks into a single future that finishes only when ALL sub-links are done
            return CompletableFuture.allOf(subTasks.toArray(new CompletableFuture[0]));
        })
        
        // Step D: Graceful Error Resilience
        // If an individual page fails to load (404 or timeout), skip it and don't crash the whole crawler
        .exceptionally(throwable -> {
            return null; // Recover smoothly
        });
    }

    /**
     * Helper Method: Extracts the hostname from a standard URL string
     * Input: "http://yahoo.com" -> Output: "://yahoo.com"
     */
    private String getHostname(String url) {
        // Strip the protocol prefix "http://"
        String substring = url.substring(7);
        int slashIndex = substring.indexOf('/');
        
        // If there's no trailing slash, the remainder of the string is the hostname
        return slashIndex == -1 ? substring : substring.substring(0, slashIndex);
    }
}
