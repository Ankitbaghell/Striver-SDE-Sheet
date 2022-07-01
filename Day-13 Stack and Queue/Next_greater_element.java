class Solution {

    public int[] nextGreaterEleRight(int[] nums) {
        Stack<Integer> st = new Stack<>(); // Same as smaller element just here we are looking of greater elements
        int[] ans = new int[nums.length];
        ans[nums.length - 1] = -1;
        st.push(nums[nums.length - 1]);

        for (int i = nums.length - 2; i >= 0; i--) {
            while (!st.empty() && st.peek() <= nums[i]) {
                st.pop();
            }
            if (st.empty())
                ans[i] = -1;
            else
                ans[i] = st.peek();
            st.push(nums[i]);
        }
        return ans;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] arr = nextGreaterEleRight(nums2); // firstly find next greater element of all elements of nums2 array
        int[] res = new int[nums1.length];

        HashMap<Integer, Integer> hs = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) { // Stored the mapping of nextGreater elements
            hs.put(nums2[i], arr[i]);
        }

        for (int i = 0; i < nums1.length; i++) { // put the mapping into result array
            res[i] = hs.get(nums1[i]);
        }
        return res;
    }
}