// There is one meeting room in a firm. There are `n` meetings in the form of
// (S[i], F[i] where S[i] is the start time and F[i] is the finish time of meeting i).
// Find maximum meetings that can be accomodated in that meeting room.
// Also, start time of a meeting can't be same as end time of previous meeting.

// [https://www.youtube.com/watch?v=II6ziNnub1Q&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=45]

// Input: N = 6, S[] = [1, 3, 0, 5, 8, 5], F[] = [2, 4, 6, 7, 9, 9]
// Output: 1 2 4 5

// Time complexity: O(N) + O(NlogN) + O(N) = O(N), Space complexity: O(N)

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Meeting {

  int start;
  int end;
  int pos;

  Meeting(int start, int end, int pos) {
    this.start = start;
    this.end = end;
    this.pos = pos;
  }
}

class MeetingComparator implements Comparator<Meeting> {

  @Override
  public int compare(Meeting o1, Meeting o2) {
    if (o1.end < o2.end) {
      return -1;
    } else if (o1.end > o2.end) {
      return 1;
    } else if (o1.pos < o2.pos) {
      return -1;
    } else {
      return 1;
    }
  }
}

public class MaxMeeting {

  public static List<Integer> maxMeetings(int[] start, int[] end, int n) {
    ArrayList<Meeting> meet = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      meet.add(new Meeting(start[i], end[i], i + 1));
    }

    MeetingComparator mc = new MeetingComparator();
    Collections.sort(meet, mc);
    ArrayList<Integer> answer = new ArrayList<>();
    answer.add(meet.get(0).pos);
    int limit = meet.get(0).end;

    for (int i = 1; i < n; i++) {
      if (meet.get(i).start > limit) {
        limit = meet.get(i).end;
        answer.add(meet.get(i).pos);
      }
    }

    return answer;
  }
}
