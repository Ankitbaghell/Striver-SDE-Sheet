class Solution {
    public String reverseWords(String s) {
        String result = "";
        int i=0;
        int n =  s.length();
        while(i < n){
            while(i < n && s.charAt(i) == ' '){
                i++;
            }
            
            if(i >= n)
                break;
            
            int j = i+1;
            while(j < n && s.charAt(j) != ' '){
                j++;
            }
            
            result = s.substring(i,j) +" " + result;
            i = j+1;
        }
        
        return result.substring(0,result.length()-1);
    }
}