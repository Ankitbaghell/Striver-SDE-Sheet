// done with the help of LL method, similiar to find start node of cycle in LL
// TC = O(N) , SC = O(1)

class Solution {
    public int findDuplicate(int[] nums) {
        int fast = nums[0];
        int slow = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (fast != slow);

        fast = nums[0];
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }

        return fast;
    }
}