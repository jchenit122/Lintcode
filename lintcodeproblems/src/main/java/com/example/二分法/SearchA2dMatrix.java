package com.example.二分法;

import java.util.ArrayList;

/**
 * Created by chenj240 on 8/8/17.
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 */

public class SearchA2dMatrix {

    public static void main(String[] args) {

        int[][] matrix = new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(searchMatrix(matrix, 2));
        System.out.println(searchMatrix(matrix, 3));
        System.out.println(searchMatrix(matrix, 50));
        System.out.println(searchMatrix(matrix, 51));
        System.out.println(searchMatrix(matrix, 0));
    }

    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     *
     * @return a boolean, indicate whether matrix contains target
     */
    private static boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int startX = 0, endX = matrix.length - 1;
        int xPoint = 0;
        while (startX + 1 < endX) {
            int mid = startX + (endX - startX) / 2;
            if (matrix[mid][0] > target) {
                endX = mid;
            } else if (matrix[mid][0] < target) {
                startX = mid;
            } else {
                return true;
            }
        }

        if (matrix[endX][0] < target) {
            xPoint = endX;
        } else {
            xPoint = startX;
        }

        int startY = 0, endY = matrix[xPoint].length - 1;
        while (startY + 1 < endY) {
            int mid = startY + (endY - startY) / 2;
            if (matrix[xPoint][mid] > target) {
                endY = mid;
            } else if (matrix[xPoint][mid] < target) {
                startY = mid;
            } else {
                return true;
            }
        }
        if (matrix[xPoint][startY] == target) {
            return true;
        }
        if (matrix[xPoint][endY] == target) {
            return true;
        }

        return false;
    }
}
