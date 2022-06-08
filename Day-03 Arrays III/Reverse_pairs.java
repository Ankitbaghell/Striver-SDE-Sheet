import java.util.ArrayList;

// similar to count inversion by merge sort

class Solution {
    int merge(int[] nums, int low, int mid, int high) {
        int invCount = 0;
        int i;
        int j = mid + 1;
        for (i = low; i <= mid; i++) {
            while (j <= high && nums[i] > (2 * (long) nums[j])) { // reverse pair possible
                j++;
            }
            invCount += (j - (mid + 1));
        }

        ArrayList<Integer> temp = new ArrayList<>(); // merging arrays
        i = low;
        j = mid + 1;
        while (i <= mid && j <= high) {
            if (nums[i] <= nums[j])
                temp.add(nums[i++]);
            else
                temp.add(nums[j++]);
        }

        while (i <= mid)
            temp.add(nums[i++]);

        while (j <= high)
            temp.add(nums[j++]);

        for (int x = low; x <= high; x++) {
            nums[x] = temp.get(x - low);
        }

        return invCount;
    }

    int mergeSort(int[] nums, int low, int high) {
        if (low >= high)
            return 0; // only one element
        int mid = (low + high) / 2;
        int invCount = mergeSort(nums, low, mid);
        invCount += mergeSort(nums, mid + 1, high);
        invCount += merge(nums, low, mid, high);
        return invCount;
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

}