
class Solution {
    int maxLen(int arr[], int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int largest = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == 0) {
                largest = i + 1; // length
            } else {
                if (map.get(sum) != null) { // if sum already exists => mean a part of array have
                    // same sum previously, so middle subArray sum is 0
                    largest = Math.max(largest, i - map.get(sum));
                } else {
                    map.put(sum, i); // else not exists, so add to map
                }
            }
        }
        return largest;
    }
}