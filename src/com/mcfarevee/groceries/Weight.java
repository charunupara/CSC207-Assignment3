package com.mcfarevee.groceries;

public class Weight {
private Unit unit;
private int amount;

public Weight(Unit unit, int amount) {
  this.unit=unit;
  this.amount=amount;
  
}

public String toString() {
  String answer= (String.valueOf(this.amount))+ unit.abbrev();
  return answer;
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
