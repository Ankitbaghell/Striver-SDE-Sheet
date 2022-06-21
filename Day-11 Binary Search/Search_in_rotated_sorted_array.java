class Solution {

    public int pivot(int arr[]) {
        int start = 0;
        int end = arr.length - 1;
        int mid = (start + end) / 2;

        while (start < end) {
            if (arr[mid] >= arr[0]) {
                start = mid + 1;
            } else
                end = mid;
            mid = (start + end) / 2;
        }
        return start;
    }

    public int binarySearch(int[] arr, int key, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == key)
                return mid;
            else if (arr[mid] > key)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int pivot = pivot(nums);
        if (target >= nums[pivot] && target <= nums[nums.length - 1]) {
            return binarySearch(nums, target, pivot, nums.length - 1);
        } else
            return binarySearch(nums, target, 0, pivot - 1);
    }
}