package backtracking;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author Tao
 * @dateTime 2021/4/16 16:09
 * @projectName Algorithms
 * @fileName CombinationSum.java
 * @IDE: IntelliJ IDEA
 * @URL: https://leetcode-cn.com/problems/combination-sum-ii/
 */
public class CombinationSumTwo {
    public static void main(String[] args) {
        System.out.println(new CombinationSumTwo().combinationSum(new int[]{10, 1, 2, 7, 6, 1, 5}, 8).toString());
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Deque<Integer> deque = new ArrayDeque<>(100);
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, deque, result, 0, target);
        return result;
    }

    public static void dfs(int[] candidates, Deque<Integer> deque, List<List<Integer>> result, int left, int target) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(deque));
            return;
        }
        for (int i = left; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            if (i > left && candidates[i] == candidates[i - 1]) {
                continue;
            }
            deque.addLast(candidates[i]);
            dfs(candidates, deque, result, i + 1, target - candidates[i]);
            deque.removeLast();
        }
    }
}
