package guideWire;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Question2 {
  public static void main(String[] args) {
    String s = "Sun 10:00-20:00\n" + "Fri 05:00-10:00\n" + "Fri 16:30-23:50\n" + "Sat 10:00-24:00\n"
        + "Sun 01:00-04:00\n" + "Sat 02:00-06:00\n" + "Tue 03:30-18:15\n" + "Tue 19:00-20:00\n"
        + "Wed 04:25-15:14\n" + "Wed 15:14-22:40\n" + "Thu 00:00-23:59\n" + "Mon 05:00-13:00\n"
        + "Mon 15:00-21:00";
    String b =
        "Mon 01:00-23:00\nTue 01:00-23:00\nWed 01:00-23:00\nThu 01:00-23:00\nFri 01:00-23:00\nSat 01:00-23:00\nSun 01:00-21:00";
    System.out.println(new Question2().solution(s));
  }

  public int solution(String S) {
    // write your code in Java SE 8
    String[] lines = S.split("\\r?\\n");
    // use a comparator
    Comparator<Meeting> meetingComparator = new Comparator<Meeting>() {
      @Override
      public int compare(Meeting s1, Meeting s2) {
        int result = s1.week_of_day - s2.week_of_day;
        if (result == 0) {
          result = s1.start_time - s2.start_time;
        }

        return result;
      }
    };

    PriorityQueue<Meeting> q = new PriorityQueue<>(meetingComparator);
    for (int i = 0; i < lines.length; i++) {
      q.add(new Meeting(lines[i]));
    }
    if (q.isEmpty()) {
      return 24 * 60 * 7;
    }

    Meeting first = q.poll();
    Meeting first_pointer = first;
    int result = first.start_time + 24 * 60 * (first.week_of_day - 1);
    if (q.isEmpty()) {
      int before = first.start_time + 24 * 60 * (first.week_of_day - 1);
      int after = 24 * 60 - first.end_time + 24 * 60 * (7 - first.week_of_day);
      return Math.max(before, after);
    }

    while (!q.isEmpty()) {

      Meeting second = q.poll();
      int temp = findBetween(first, second);
      result = Math.max(result, temp);
      first = second;
    }
    int temp = 24 * 60 - first.end_time;
    result = Math.max(result, temp);
    return result;
  }



  private int findBetween(Meeting a, Meeting b) {
    if (a.week_of_day == b.week_of_day) {
      return b.start_time - a.end_time;
    } else {
      return 24 * 60 - a.end_time + b.start_time + 24 * 60 * (b.week_of_day - a.week_of_day - 1);
    }
  }

  private class Meeting {
    public int week_of_day;
    public int start_time;
    public int end_time;

    public Meeting(String s) {
      String[] temp = s.split(" ");
      switch (temp[0]) {
        case "Mon":
          this.week_of_day = 1;
          break;
        case "Tue":
          this.week_of_day = 2;
          break;
        case "Wed":
          this.week_of_day = 3;
          break;
        case "Thu":
          this.week_of_day = 4;
          break;
        case "Fri":
          this.week_of_day = 5;
          break;
        case "Sat":
          this.week_of_day = 6;
          break;
        case "Sun":
          this.week_of_day = 7;
          break;
        default:
          this.week_of_day = -1;
      }

      String[] time = temp[1].split("-");
      this.start_time = toMin(time[0]);
      this.end_time = toMin(time[1]);
    }

    private int toMin(String s) {
      String[] temp = s.split(":");
      return Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
    }

    @Override
    public String toString() {
      return "Meeting [week_of_day=" + week_of_day + ", start_time=" + start_time + ", end_time="
          + end_time + "]";
    }


  }
}
