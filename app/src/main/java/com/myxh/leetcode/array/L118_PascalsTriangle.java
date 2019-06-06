package com.myxh.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class L118_PascalsTriangle {

    public static void main(String[] args) {
        for (List<Integer> list : generate(5)) {
            System.out.print("[");
            for (Integer integer : list) {
                System.out.print(integer+",");
            }
            System.out.println("]");
        }
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Pascal's Triangle.
     * Memory Usage: 33.9 MB, less than 29.97% of Java online submissions for Pascal's Triangle.
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            List<Integer> items = new ArrayList<>(i + 1);
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    items.add(1);
                } else {
                    int sum = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
                    items.add(sum);
                }
            }
            result.add(items);
        }
        return result;
    }
}
