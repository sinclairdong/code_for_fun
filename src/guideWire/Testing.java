package guideWire;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Testing {
  public static void main(String[] args) {
    String s = "Sun 10:00-20:00";
    Meeting m = new Testing().new Meeting(s);
    System.out.println(m);
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
      System.out.println(time[0]);
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
