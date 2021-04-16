package backtracking;

import org.apache.commons.lang.time.StopWatch;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Tao
 * @dateTime 2021/4/16 16:09
 * @projectName Algorithms
 * @fileName CombinationSum.java
 * @IDE: IntelliJ IDEA
 * @URL: https://leetcode-cn.com/problems/combination-sum/
 */
public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7).toString());
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Deque<Integer> deque = new ArrayDeque<>(100);
        List<List<Integer>> result = new ArrayList<>();
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
            deque.addLast(candidates[i]);
            dfs(candidates, deque, result, i, target - candidates[i]);
            deque.removeLast();
        }
    }
}
