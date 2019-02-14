package com.mcfarevee.groceries;

public class BulkItem implements Item{
  private BulkFood food;
  private Unit unit;
  private int amount;



  public BulkItem(BulkFood food, Unit unit, int quantity) {
    this.food=food;
    this.unit=unit;
    this.amount=quantity;
  }
  
  public String toString() {
    String answer= String.valueOf(this.amount); 

    return answer;

  }
  public String getWeight() {
    String weight= String.valueOf(this.amount) +unit;
    return weight;
  }


  getPrice()
  
  public boolean equals() {

}
