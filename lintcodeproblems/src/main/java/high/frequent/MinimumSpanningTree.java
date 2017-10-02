package high.frequent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenj240 on 9/28/17.
 * Given a list of Connections, which is the Connection class (the city name at both ends of the edge and a cost between them), find some edges,
 * connect all the cities and spend the least amount.
 * Return the connects if can connect all the cities, otherwise return empty list.
 * Notice
 * Return the connections sorted by the cost, or sorted city1 name if their cost is same, or sorted city2 if their city1 name is also same.
 * Example
 * Gievn the connections = ["Acity","Bcity",1], ["Acity","Ccity",2], ["Bcity","Ccity",3]
 * Return ["Acity","Bcity",1], ["Acity","Ccity",2]
 */

public class MinimumSpanningTree {
    public static void main(String[] args) {
        Connection a = new Connection("Acity", "Bcity", 1);
        Connection b = new Connection("Acity", "Ccity", 2);
        Connection c = new Connection("Bcity", "Ccity", 3);

        List<Connection> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);

        Solution solution = new MinimumSpanningTree().new Solution();
        for (Connection connection : solution.lowestCost(list)) {
            System.out.println(connection.city1 + " " + connection.city2 + " " + connection.cost);
        }

    }

    public class Solution {
        /**
         * @param connections given a list of connections include two cities and cost
         *
         * @return a list of connections from results
         */
        public List<Connection> lowestCost(List<Connection> connections) {
            // Write your code here
            int n = 0;
            List<Connection> result = new ArrayList<>();
            UFS ufs = new UFS(connections.size() * 2);
            Comparator<Connection> comparator = new Comparator<Connection>() {
                @Override
                public int compare(Connection t1, Connection t2) {
                    if (t1.cost != t2.cost) {
                        return t1.cost - t2.cost;
                    }
                    if (t1.city1.equals(t2.city1)) {
                        return t1.city2.compareTo(t2.city2);
                    }
                    return t1.city1.compareTo(t2.city1);
                }
            };

            Collections.sort(connections, comparator);

            Map<String, Integer> cityMap = new HashMap<>();

            for (Connection connection : connections) {
                if (!cityMap.containsKey(connection.city1)) {
                    cityMap.put(connection.city1, ++n);
                }
                if (!cityMap.containsKey(connection.city2)) {
                    cityMap.put(connection.city2, ++n);
                }
                int cityA = cityMap.get(connection.city1);
                int cityB = cityMap.get(connection.city2);

                if (ufs.find(cityA) != ufs.find(cityB)) {
                    result.add(connection);
                    ufs.union(cityA, cityB);
                }

            }

            if (result.size() != cityMap.size() - 1) {
                return new ArrayList<>();
            }

            return result;

        }

        class UFS {
            int[] f;

            UFS(int n) {
                f = new int[n];
                for (int i = 0; i < n; i++) {
                    f[i] = -1;
                }
            }

            int find(int num) {
                if (f[num] < 0) {
                    return num;
                }
                f[num] = find(f[num]);
                return f[num];
            }

            void union(int a, int b) {
                a = find(a);
                b = find(b);
                if (f[a] < f[b]) {
                    f[a] += f[b];
                    f[b] = a;
                } else {
                    f[b] += f[a];
                    f[a] = b;
                }
            }
        }
    }
}
