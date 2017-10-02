package high.frequent;


/**
 * Created by chenj240 on 9/27/17.
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 * Example
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1 // return 1.00000
 * m.next(10) = (1 + 10) / 2 // return 5.50000
 * m.next(3) = (1 + 10 + 3) / 3 // return 4.66667
 * m.next(5) = (10 + 3 + 5) / 3 // return 6.00000
 */

public class SlidingWindowAverageFromDataStream {
    public static void main(String[] args) {
        MovingAverage movingAverage = new SlidingWindowAverageFromDataStream().new MovingAverage(3);
        System.out.println(movingAverage.next(1));
        System.out.println(movingAverage.next(10));
        System.out.println(movingAverage.next(3));
        System.out.println(movingAverage.next(5));

    }

    public class MovingAverage {
        int size, index;
        double[] sum;

        /*
        * @param size: An integer
        */
        public MovingAverage(int size) {
            // do intialization if necessary
            sum = new double[size + 1];
            this.size = size;
            index = 0;
        }

        private int mod(int index) {
            return index % (size + 1);
        }

        /*
         * @param val: An integer
         * @return:
         */
        public double next(int val) {
            // write your code here
            index++;
            sum[mod(index)] = sum[mod(index - 1)] + val;
            if (index - size >= 0) {
                return (sum[mod(index)] - sum[mod(index - size)]) / size;
            } else {
                return sum[index] / index;
            }
        }
    }
}
