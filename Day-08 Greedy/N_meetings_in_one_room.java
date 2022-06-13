import java.util.*;

class Meeting{
    int start;
    int end;
    int meetingNo;
    
    Meeting(int s, int e, int m){
        start = s;
        end = e;
        meetingNo = m;
    }
}

public class Solution {
    public static List<Integer> maximumMeetings(int[] start, int[] end) {        
       ArrayList<Meeting> meeting = new ArrayList<>();
        for(int i=0; i<start.length; i++){
            meeting.add(new Meeting(start[i], end[i], i+1));
        }
        
        Collections.sort(meeting, (a,b)->(a.end != b.end ? a.end - b.end : a.meetingNo - b.meetingNo));
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(meeting.get(0).meetingNo);
        int limit = meeting.get(0).end;
        
        for(int i=1; i<start.length; i++){
            if(meeting.get(i).start > limit){
                limit = meeting.get(i).end;
                ans.add(meeting.get(i).meetingNo);
            }
        }
         return ans;                
    }
}