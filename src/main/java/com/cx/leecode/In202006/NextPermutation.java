package com.cx.leecode.In202006;

import java.util.Arrays;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        for (int i = len - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                int j = find(nums, i - 1, nums[i - 1], len);
                swap(nums, i - 1, j);
                resert(nums, i, len);
                return;
            }
        }
        Arrays.sort(nums);
    }

    public void resert(int[] nums, int start, int len) {
        int l = start + (len - start) / 2;
        for (int i = start; i < l; i++) {
            swap(nums, i, len - i + start - 1);
        }
    }

    public int find(int[] nums, int start, int x, int len) {
        for (int i = len - 1; i > start; i--) {
            if (nums[i] > x) {
                return i;
            }
        }
        return start;
    }

    public void swap(int[] nums, int i, int j) {
        int swap = nums[i];
        nums[i] = nums[j];
        nums[j] = swap;
    }

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        int[] numx = new int[]{1, 2, 3};
        nextPermutation.nextPermutation(numx);
        System.out.println(Arrays.toString(numx));

        numx = new int[]{1, 1, 5};
        nextPermutation.nextPermutation(numx);
        System.out.println(Arrays.toString(numx));

        numx = new int[]{3, 2, 1};
        nextPermutation.nextPermutation(numx);
        System.out.println(Arrays.toString(numx));

        numx = new int[]{2, 3, 1};
        nextPermutation.nextPermutation(numx);
        System.out.println(Arrays.toString(numx));

        numx = new int[]{1, 3, 2};
        nextPermutation.nextPermutation(numx);
        System.out.println(Arrays.toString(numx));

        numx = new int[]{4, 2, 0, 2, 3, 2, 0};
        nextPermutation.nextPermutation(numx);
        System.out.println(Arrays.toString(numx));

    }
}
