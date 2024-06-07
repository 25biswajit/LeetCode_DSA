class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        boolean[] visited = new boolean[n];

        Map<Integer, List<Integer>> adjList = new HashMap();
        //build Adjacency List
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(isConnected[i][j] == 1){
                    adjList.putIfAbsent(i, new ArrayList<>());
                    adjList.get(i).add(j);
                }
            }
        }
        // Moving row wise
        for(int i = 0; i < n; i++) {
            if(!visited[i]){
                dfs(i, adjList, visited);
                count++;
            }
        }

        return count;
    }

    public void dfs(int i, Map<Integer, List<Integer>> adjList, boolean[] visited){
        visited[i] = true;
        for(int x : adjList.get(i)){
            if(!visited[x]){
                dfs(x, adjList, visited);
            }
        }
    }

    public void dfs_(int currentNode, int[][] isConnected, boolean[] visited){
        int n = isConnected.length;
        visited[currentNode] = true;

        // Moving col wise & checking Are they connected
        for(int j = 0; j < n; j++){
            if(isConnected[currentNode][j] == 1 && !visited[j]){
                dfs_(j, isConnected, visited);
            }
        }
    }
}