package s37CCCSC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Scheduler {
  public List<String> schedule(Item[] items, int budget) {
    initializeRatio(items);
    Arrays.sort(items, new SortbyRatio());

    List<String> result = new ArrayList<>();
    int counter = 0;
    while (budget > 0 && counter < items.length) {
      int total_cost = items[counter].getCost() * items[counter].getQuantity();
      if (total_cost < budget) {
        budget -= total_cost;
        result.add(items[counter].getName() + ":   " + items[counter].getQuantity());
        items[counter].setQuantity(0);
      } else if (budget > items[counter].getCost()) {
        int number = budget / items[counter].getCost();
        budget -= number * items[counter].getCost();
        result.add(items[counter].getName() + ":   " + number);
      }
      counter++;
    }
    return result;
  }

  private void initializeRatio(Item[] item) {
    for (int i = 0; i < item.length; i++) {
      item[i]
          .setProfitCostRatio((double) (item[i].getMsrp() - item[i].getCost()) / item[i].getCost());
    }
  }

  class SortbyRatio implements Comparator<Item> {
    // Used for sorting in ascending order of
    // roll number
    public int compare(Item a, Item b) {
      int result = 0;
      if (a.getProfitCostRatio() > b.getProfitCostRatio()) {
        result = -1;
      } else if (a.getProfitCostRatio() < b.getProfitCostRatio()) {
        result = 1;
      } else if (a.getProfitCostRatio() == b.getProfitCostRatio()) {
        if (a.getCost() > b.getCost()) {
          result = -1;
        } else if (a.getCost() < b.getCost()) {
          result = 1;
        }
      }
      return result;
    }
  }

  public static void main(String[] args) {
    Item[] a = new Item[4];
    a[0] = new Item("A", 40, 100, 30);
    a[1] = new Item("B", 100, 240, 200);
    a[2] = new Item("C", 20, 80, 500);
    a[3] = new Item("D", 25, 75, 200);
    List<String> aa = new Scheduler().schedule(a, 16000);
    for (int i = 0; i < aa.size(); i++) {
      System.out.println(aa.get(i));
    }
  }
}
