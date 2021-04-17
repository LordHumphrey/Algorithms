package backtracking;

import java.util.*;

/**
 * @author Tao
 * @dateTime 2021/4/17 15:38
 * @projectName Algorithms
 * @fileName Permutations.java
 * @IDE: IntelliJ IDEA
 * @URL: https://leetcode-cn.com/problems/permutations/
 */
public class Permutations {
    public static void main(String[] args) {
        System.out.println(new Permutations().permute(new int[]{1, 2, 3}).toString());
    }

    public List<List<Integer>> permute(int[] nums) {
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
