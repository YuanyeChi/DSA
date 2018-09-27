class UndirectedGraphNode {
     int label;
     List<UndirectedGraphNode> neighbors;
     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};
//DFS
    private HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node);
    }
    public UndirectedGraphNode clone(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(clone.label, clone);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            clone.neighbors.add(clone(neighbor));
        }
        return clone;           
    }
}
//BFS
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode root) {
        if (root == null) return null;
        UndirectedGraphNode newNode = new UndirectedGraphNode(root.label);
        HashMap<Integer, UndirectedGraphNode> map = new HashMap();
        map.put(newNode.label, newNode);
        
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(root);        
        
        while(!queue.isEmpty()) {
            UndirectedGraphNode node = queue.poll();
            for (UndirectedGraphNode neighbor : node.neighbors) {
                if(!map.containsKey(neighbor.label)){
                    map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                    queue.add(neighbor);
                }
                map.get(node.label).neighbors.add(map.get(neighbor.label));
            }   
        }
        return newNode;
    }
}
