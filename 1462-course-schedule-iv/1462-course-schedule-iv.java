public class Solution {
    public List<Boolean> checkIfPrerequisite(
        int numCourses,
        int[][] prerequisites,
        int[][] queries
    ) {
        int n = numCourses;
        List<Integer>[] adjList = new ArrayList[n];
        int[] indegree = new int[numCourses];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] edge : prerequisites) {
            adjList[edge[0]].add(edge[1]);
            indegree[edge[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        // Map from the node as key to the set of prerequisite nodes.
        HashSet<Integer>[] nodePrerequisites = new HashSet[n];
        for (int i = 0; i < n; i++) {
            nodePrerequisites[i] = new HashSet<>();
        }

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int adj : adjList[node]) {
                // Add node and prerequisites of the node to the prerequisites of adj
                nodePrerequisites[adj].add(node);
                for (int prereq : nodePrerequisites[node]) {
                    nodePrerequisites[adj].add(prereq);
                }
                indegree[adj]--;
                if (indegree[adj] == 0) {
                    q.offer(adj);
                }
            }
        }
        List<Boolean> answer = new ArrayList<>();
        for (int[] query : queries) {
            answer.add(
                nodePrerequisites[query[1]].contains(query[0])
            );
        }
        return answer;
    }
}