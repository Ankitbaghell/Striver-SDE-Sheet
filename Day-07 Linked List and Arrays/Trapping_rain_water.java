
// two pointer approach
class Solution {
    public int trap(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int storedWater = 0;

        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) // no water will store, update the leftMax
                    leftMax = height[left];
                else // space for water trap => water will stored
                    storedWater += leftMax - height[left];
                left++;
            }

            else { // if(height[left] > height[right])
                if (height[right] >= rightMax) // same as above
                    rightMax = height[right];
                else
                    storedWater += rightMax - height[right];
                right--;
            }
        }

        return storedWater;
    }
}