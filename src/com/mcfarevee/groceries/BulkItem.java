package com.mcfarevee.groceries;





public class BulkItem implements Item {

  private BulkFood food;
  private Unit unit;
  private int amount;



  public BulkItem(BulkFood food, Unit unit, int quantity) {
    this.food = food;
    this.unit = unit;
    this.amount = quantity;
  }


  /*
   * public String toString() { String answer= String.valueOf(this.amount);
   * 
   * return answer;
   * 
   * } public String getWeight() { String weight= String.valueOf(this.amount) +unit; return weight;
   * }
   */

  public String toString() {
    String answer =
        String.valueOf(this.amount) + this.unit.toString() + " of " + this.food.toString();
    return answer;
  }

  public int getPrice() {
    int price = (this.amount) * (this.food.getPricePerUnit());
    return price;
  }

  public Weight getWeight() {
    return new Weight(this.unit, this.amount);
  }


  public boolean equals(Object other) {
    if (other instanceof BulkItem) {
      BulkItem otherbi = (BulkItem) other;
      if ((this.food.equals(otherbi.food)) && (this.unit.equals(otherbi.unit))
          && (this.amount == otherbi.amount)) {
        return true;
      } else
        return false;
    } else
      return false;
  }

  public void setAmount(int amount) {
    this.amount= amount;
  }

  public int getAmount() {
    return this.amount;
  }

  public static void main(String[] args) {

    BulkFood bf = new BulkFood("khana", Unit.OUNCE, 50, 4);
    BulkItem item = new BulkItem(bf, Unit.OUNCE, 6);
    BulkItem item2 = new BulkItem(bf, Unit.OUNCE, 3);
    System.out.print(item2.getWeight());
  }
}
