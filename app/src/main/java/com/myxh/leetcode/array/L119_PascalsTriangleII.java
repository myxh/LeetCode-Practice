package com.myxh.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 *
 * Note that the row index starts from 0.
 *
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 3
 * Output: [1,3,3,1]
 */
public class L119_PascalsTriangleII {

    public static void main(String[] args) {
        List<Integer> list = getRow(28);
        for (Integer integer : list) {
            System.out.print(integer + ",");
        }
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Pascal's Triangle II.
     * Memory Usage: 33.7 MB, less than 31.31% of Java online submissions for Pascal's Triangle II.
     */
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>(rowIndex + 1);
        for (int i = 0; i <= rowIndex; i++) {
            if (i == 0 || i == rowIndex) {
                result.add(1);
            } else {
                if (i <= (rowIndex + 1) / 2) {
                    //此处需注意int溢出，行/项从0计数，杨辉三角的当前项 = 上一项 * 剩余项数 / 当前项数，eg: 第3行第2项 = 3 * (3 - 2 + 1) / 2
                    int item = (int) ((result.get(i - 1) * (rowIndex - i + 1L)) / i);
                    result.add(item);
                } else {
                    result.add(result.get(rowIndex - i));
                }
            }
        }
        return result;
    }

}
