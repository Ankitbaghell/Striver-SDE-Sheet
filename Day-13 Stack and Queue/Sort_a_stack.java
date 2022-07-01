import java.util.*;
public class Solution {

    public static void sortedInsert(Stack<Integer> st , int num){
          // base case
      if(st.empty() || num > st.peek()){
          st.push(num); return;
      }
        int x = st.pop();
        sortedInsert(st,num);
        st.push(x);
    }
	public static void sortStack(Stack<Integer> st) {
		
        // base case
        if(st.empty()) return;
        if(st.size() == 1)  return;
        
        int num = st.pop();
        sortStack(st);
        if(num >= st.peek()){
            st.push(num);
        }
        else{
           sortedInsert(st,num);
        }
	}

}