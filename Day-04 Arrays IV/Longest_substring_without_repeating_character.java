class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        int left = 0, right = 0;
        int longest = 0;
        
        while(right < s.length()){
            if(map.containsKey(s.charAt(right)))
                left = Math.max(left, map.get(s.charAt(right)) + 1);     // move left
            
            map.put(s.charAt(right), right);      // updated location of character
            longest = Math.max(longest, right-left+1);
            right++;
        }
        return longest;
    }
}