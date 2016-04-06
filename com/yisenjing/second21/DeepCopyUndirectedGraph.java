package com.yisenjing.second21;

import java.util.*;

/**
 * Created by Yisen on 3/24/16.
 */
public class DeepCopyUndirectedGraph {

    public List<GraphNode> copy(List<GraphNode> graph) {

        if (graph.size() == 0) {
            return new ArrayList<GraphNode>();
        }

        HashMap<GraphNode, GraphNode> visited = new HashMap<GraphNode, GraphNode>();

        for (GraphNode node : graph) {
            if (!visited.containsKey(node)) {
                visited.put(node, new GraphNode(node.key));
                DFS(visited, node);
            }
        }
        return new ArrayList<GraphNode>(visited.values());
    }


    private void DFS(HashMap<GraphNode, GraphNode> visited, GraphNode theNode) {

        GraphNode copied = visited.get(theNode);

        for (GraphNode nei : theNode.neighbors) {
            if (!visited.containsKey(nei)) {            //确保不会陷入无限循环
                visited.put(nei, new GraphNode(nei.key));
                DFS(visited, nei);              //深度搜索树,
            }
            copied.neighbors.add(visited.get(nei));  //确保无论有没有存在都要加上,这是回复本来重复的现象的方法
        }



    }


}
