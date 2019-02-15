package com.mcfarevee.groceries;

public class Weight {
private Unit unit;
private int amount;

public Weight(Unit unit, int amount) {
  this.unit=unit;
  this.amount=amount;
  
}

public int getAmount() {
  return this.amount;
}

public Unit getUnit() {
  return this.unit;
}

public String toString() {
  String answer= (String.valueOf(this.amount))+ " " + unit.abbrev();
  return answer;
}
public boolean equals(Weight other) {
  if((this.getUnit().equals(other.getUnit()))&& (this.amount==other.amount)) {
    return true;
  }else return false;
}
  /*
   * public static merge() {
   * 
   * } public static remove(String name) {
   * 
   * }
   * 
   * public static int getPrice() {\
   * 
   * }
   */

//print contents on a printwriter
}
