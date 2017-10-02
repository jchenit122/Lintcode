package com.example.二分法;

/**
 * Created by chenj240 on 8/9/17.
 * The array is so big so that you can not get the length of the whole array directly
 * 倍增法
 */

public class SearchInABigSortedArray {


    /**
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     *
     * @return : An integer which is the index of the target number
     */
    private static int searchBigSortedArray(ArrayReader reader, int target) {
        // write your code here

        int end = 1;
        while (reader.get(end - 1) < target) {
            end = (end) * 2;
        }

        int start = 0;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (reader.get(mid) < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (reader.get(start) == target) {
            return start;
        }

        if (reader.get(end) == target) {
            return end;
        }

        return -1;
    }

    private class ArrayReader {
        // get the number at index, return -1 if index is less than zero.
        public int get(int index) {
            return 0;
        }
    }
}
