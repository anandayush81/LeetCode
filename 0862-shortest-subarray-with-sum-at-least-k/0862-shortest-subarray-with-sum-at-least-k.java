// class Solution {
//     public int shortestSubarray(int[] nums, int k) {
        
//     }
// }


// import java.util.ArrayDeque;
// import java.util.Deque;

class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        Deque<Pair> dq = new ArrayDeque<>();
        long sum = 0;
        long shortest = Integer.MAX_VALUE;

        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            if (sum >= k) shortest = Math.min(shortest, i + 1);

            Pair curr = new Pair(Integer.MIN_VALUE, Integer.MIN_VALUE);
            while (!dq.isEmpty() && (sum - dq.peekFirst().second >= k)) {
                curr = dq.pollFirst();
            }
            if (curr.second != Integer.MIN_VALUE) {
                shortest = Math.min(shortest, (i - curr.first));
            }
            while (!dq.isEmpty() && sum <= dq.peekLast().second) {
                dq.pollLast();
            }
            dq.offerLast(new Pair(i, sum));
        }
        return shortest == Integer.MAX_VALUE ? -1 : (int) shortest;
    }

    static class Pair {
        int first;
        long second;

        Pair(int first, long second) {
            this.first = first;
            this.second = second;
        }
    }
}
