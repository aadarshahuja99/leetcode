class Solution { 
    public int minJumps(int[] arr) { 
        int n = arr.length;
        if (n <= 1) return 0;

        // Use ArrayList instead of HashSet for map values
        Map<Integer, List<Integer>> adj = new HashMap<>(); 
        for (int i = 0; i < n; i++) {
            adj.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.add(0);
        visited[0] = true;
        int distance = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int top = q.poll();

                if (top == n - 1) {
                    return distance;
                }

                // 1. Process same-value jumps
                if (adj.containsKey(arr[top])) {
                    for (int node : adj.get(arr[top])) {
                        if (!visited[node]) {
                            visited[node] = true;
                            q.add(node);
                        }
                    }
                    // Crucial Optimization: Remove key so we never loop it again
                    adj.remove(arr[top]); 
                }

                if (top - 1 >= 0 && !visited[top - 1]) {
                    visited[top - 1] = true;
                    q.add(top - 1);
                }

                // 3. Process Forward Jump
                if (top + 1 < n && !visited[top + 1]) {
                    visited[top + 1] = true;
                    q.add(top + 1);
                }
            }
            distance++;
        }
        return 0;
    }
}
