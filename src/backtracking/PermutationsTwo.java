package backtracking;

import java.util.*;

/**
 * @author Tao
 * @dateTime 2021/4/17 16:25
 * @projectName Algorithms
 * @fileName PermutationsTwo.java
 * @IDE: IntelliJ IDEA
 * @URL: https://leetcode-cn.com/problems/permutations-ii/
 */
public class PermutationsTwo {
    public static void main(String[] args) {
        System.out.println(new PermutationsTwo().permuteUnique(new int[]{1, 1, 2}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        Arrays.sort(nums);
        dfs(nums, result, new ArrayDeque<>(), 0, used);
        return result;
    }

    public static void dfs(int[] nums, List<List<Integer>> result,
                           Deque<Integer> path,
                           int left, boolean[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            if (!used[i]) {
                used[i] = true;
                path.addLast(nums[i]);
                dfs(nums, result, path, left + 1, used);
                path.removeLast();
                used[i] = false;
            }
        }
    }
}
