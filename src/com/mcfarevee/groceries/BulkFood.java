package com.mcfarevee.groceries;

public class BulkFood {
  private String name;
  private Unit unit;
  private int pricePerUnit;
  private int supply;

  public BulkFood(String name, Unit unit,  int unitPrice,int supply) {
    this.name=name;
    this.unit=unit;
    this.pricePerUnit=unitPrice;
    this.supply=supply;
    
    
  }
  
  public String toString() {
    return this.name;
      }
}
