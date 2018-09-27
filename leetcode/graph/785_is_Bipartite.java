class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        //BFS
        //0 no color, 1 red, 2 blue
        for(int i = 0; i < graph.length; i++) {
            //可以加graph[i].lengh != 0来排除空节点
            if (visited[i] == 0) {
                visited[i] = 1;
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int k = 0;
                    k++;
                    System.out.printf("%d", k);
                    int CurrentNode = queue.poll();
                    for (int n : graph[CurrentNode]) {
                        if (visited[n] == 0) {
                            visited[n] = (visited[CurrentNode] == 1) ? 2 : 1;
                            queue.offer(n);
                        }
                        else {
                            if(visited [n] == visited[CurrentNode]) 
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        //DFS
        //-1 no color, 0 red, 1 blue
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        
        for (int i = 0; i < n; i++) {
            //color[i] == -1确保了没轮到的时候不会返回错误
            if (color[i] == -1 && !validColor(graph, color, 0, i)) {
                return false;
            }
        }
        return true;
    }
    public boolean validColor(int[][] graph, int[] color, int CurrentColor, int CurrentNode) {
        if (color[CurrentNode] != -1) {
            return color[CurrentNode] == CurrentColor;
        }
        color[CurrentNode] = CurrentColor;
        for (int next : graph[CurrentNode]) {
            if (!validColor(graph, color, 1 - CurrentColor, next)) {
                return false;
            }
        }
        return true;
    }
    
}
