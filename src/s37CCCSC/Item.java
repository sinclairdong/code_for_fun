package s37CCCSC;

public class Item {
  private int cost;
  private String name;
  private int msrp;
  private int Quantity;
  private double profitCostRatio;

  public Item(String name, int cost, int msrp, int quantity) {
    super();
    this.cost = cost;
    this.name = name;
    this.msrp = msrp;
    Quantity = quantity;
  }

  public int getCost() {
    return cost;
  }

  public void setCost(int cost) {
    this.cost = cost;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getMsrp() {
    return msrp;
  }

  public void setMsrp(int msrp) {
    this.msrp = msrp;
  }

  public int getQuantity() {
    return Quantity;
  }

  public void setQuantity(int quantity) {
    Quantity = quantity;
  }

  public double getProfitCostRatio() {
    return profitCostRatio;
  }

  public void setProfitCostRatio(double profitCostRatio) {
    this.profitCostRatio = profitCostRatio;
  }

}
