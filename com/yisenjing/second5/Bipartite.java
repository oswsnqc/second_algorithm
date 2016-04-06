package com.yisenjing.second5;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.*;

/**
 * Created by Yisen on 3/3/16.
 */
public class Bipartite {

    public boolean isBipartite(List<GraphNode> graph) {

        HashMap<GraphNode, Integer> visited = new HashMap<>();

        for (GraphNode node : graph) {
            if (!BFS(node, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean BFS(GraphNode node, HashMap<GraphNode, Integer> visited) {

        if (visited.containsKey(node)) {
            return true;
        }
        Queue<GraphNode> temp = new LinkedList<>();
        temp.offer(node);
        visited.put(node, 0);

        while (!temp.isEmpty()) {
            GraphNode cur = temp.poll();
            int curGroup = visited.get(cur);
            int neiGroup = curGroup == 0 ? 1 : 0;

            for (GraphNode nei : cur.neighbors) {
                if (!visited.containsKey(nei)) {
                    temp.offer(nei);
                    visited.put(nei, neiGroup);
                } else if (visited.get(nei) != neiGroup) {
                    return false;
                }
            }
        }
        return true;
    }



}
