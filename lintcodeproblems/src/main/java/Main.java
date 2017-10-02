import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenj240 on 9/29/17.
 */

public class Main {

    public static void main(String[] args) throws IOException {
//        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
//        BufferedReader in = new BufferedReader(reader);
//        List<Point> list = new ArrayList<>();
//        String line;
//        while ((line = in.readLine()) != null) {
//            int numsOfPoints = Integer.parseInt(line);
//
//            for (int i=0; i < numsOfPoints; i++){
//                String pair = in.readLine();
//                String[] coordinate = pair.split(" ");
//                Point point = new Point(Integer.parseInt(coordinate[0]), Integer.parseInt(coordinate[1]));
//                list.add(point);
//            }
//            break;
//        }
        List<Point> list = new ArrayList<>();
        list.add(new Point(0,2));
        list.add(new Point(6,67));
        list.add(new Point(43,71));
        list.add(new Point(39,107));
        list.add(new Point(189,140));

        Solution solution = new Solution();
        System.out.print(solution.getClosestDistance(list));

    }

    static class Solution {
        int shortestDistance = Integer.MAX_VALUE;
        double getClosestDistance (List<Point> list){
            int size = list.size();
            for (int i =0; i<size; i++){
                for (int j =i+1; j < size; j++){
                    int x = Math.abs(list.get(i).x - list.get(j).x);
                    int y = Math.abs(list.get(i).y - list.get(j).y);
                    int distance = x*x + y*y;

                    if (shortestDistance > distance){
                        shortestDistance = distance;
                    }

                }
            }
            return Math.sqrt(shortestDistance);
        }
    }

    public static class Point {
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
