package LeetCode.Main501_1000;

import java.util.*;

public class Main0815 {
    public static int numBusesToDestination(int[][] routes, int source, int target) {
        // 特别地，起点和终点相同时，我们可以直接返回 0。
        if (source == target) {
            return 0;
        }
        /*
        构建图：
             由于求解的目标是最少乘坐的公交车数量，对于同一辆公交车，乘客可以在其路线中的任意车站间无代价地移动，
             于是我们可以把公交路线当作点。如果两条公交路线有相同车站，则可以在这两条路线间换乘公交车，
             那么这两条公交路线之间可视作有一条长度为 1 的边。这样建出的图包含的点数即为公交路线的数量，记作 n。
         构建图的具体方法：
             我们遍历所有公交路线，记录每一个车站属于哪些公交路线。然后我们遍历每一个车站，
             如果有多条公交路线经过该点，则在这些公交路线之间连边。
         */
        //构建的无向图
        boolean[][] edges = new boolean[routes.length][routes.length];
        //key存储的是站点编号，value存储的是那些线路经过该站点
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int site : routes[i]) {
                List<Integer> list = map.getOrDefault(site, new ArrayList<>());
                for (int route : list)
                    edges[i][route] = edges[route][i] = true;
                list.add(i);
                map.put(site, list);
            }
        }
        /*
        注意到原本的起点车站和终点车站可能同时位于多条公交路线上，
        因此在新图上可能有多个起点和终点。对于这种情况，我们初始可以同时入队多个点
         */
        int[] dis = new int[edges.length];
        Queue<Integer> queue = new LinkedList<>();
        for (int route : map.getOrDefault(source, new ArrayList<>())) {
            queue.add(route);
            dis[route] = 1;
        }
        /*
        完成了建图后，我们需要先明确新的图的起点和终点，然后使用广度优先搜索，
        计算出的起点和终点的最短路径，从而得到最少换乘次数。
         */
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int x = 0; x < edges.length; x++) {
                if (edges[cur][x] && dis[x] == 0) {
                    dis[x] = 1 + dis[cur];
                    queue.add(x);
                }
            }
        }
        int ret = Integer.MAX_VALUE;
        for (int bus : map.getOrDefault(target, new ArrayList<>()))
            if (dis[bus] != 0)
                ret = Math.min(ret, dis[bus]);
        return ret == Integer.MAX_VALUE ? -1 : ret;
    }

    public static void main(String[] args) {
        System.out.println(numBusesToDestination(new int[][]{{1, 2, 7}, {3, 6, 7}}, 1, 6));
    }
}
