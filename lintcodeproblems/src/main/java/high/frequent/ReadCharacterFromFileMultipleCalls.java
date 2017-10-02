package high.frequent;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chenj240 on 9/28/17.
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 * The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
 * By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
 * Notice
 * The read function may be called multiple times.
 */

public class ReadCharacterFromFileMultipleCalls {
    /* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

    public class Solution extends Reader4 {
        Queue<Character> queue = new LinkedList<>();

        /**
         * @param buf destination buffer
         * @param n   maximum number of characters to read
         *
         * @return the number of characters read
         */
        public int read(char[] buf, int n) {
            // Write your code here

            char[] source = new char[4];
            int i = 0;
            while (i < n) {
                if (queue.isEmpty()) {
                    int length = read4(source);
                    if (length == 0) {
                        break;
                    }
                    for (int j = 0; j < length; j++) {
                        queue.add(source[j]);
                    }
                }

                while (i < n && !queue.isEmpty()) {
                    buf[i++] = queue.poll();
                }
            }
            return i;

        }
    }
}
