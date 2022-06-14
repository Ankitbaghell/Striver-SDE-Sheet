class Solution {
    static List<Integer> minCoins(int amount) {
        int[] currency = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
        int n = currency.length;
        List<Integer> ans = new ArrayList<>();

        for (int i = n - 1; i >= 0; i--) {
            while (amount >= currency[i]) {
                amount -= currency[i];
                ans.add(currency[i]);
            }
        }
        return ans;
    }
}