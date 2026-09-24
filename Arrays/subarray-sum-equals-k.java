problem statement:Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
A subarray is a contiguous non-empty sequence of elements within an array.
Problem link:https://leetcode.com/problems/subarray-sum-equals-k/description/
Approach: Prefix sum + HashMap to track seen sums
Complexity:
Time: O(n) — single pass through the array, hash map operations are O(1) on average.
Space: O(n) — in the worst case, all prefix sums are distinct, so the map can hold up to n entries.

  Solution:
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, count = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            count += map.getOrDefault(sum - k, 0);   // has this gap been seen before?
            map.put(sum, map.getOrDefault(sum, 0) + 1);   // record current prefix sum
        }
        return count;
    }
}
