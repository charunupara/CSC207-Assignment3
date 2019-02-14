package com.mcfarevee.groceries;

public class ManyPackages implements Item {
  private Package type;
  private int count;
  
  public ManyPackages(Package type, int count) {
    this.type=type;
    this.count=count;
  }
  
 public String toString() {
  String answer= String.valueOf(this.count)+" x "+this.type.toString();
  return answer;
  }
  
  /*
   * getWeight() getPrice() 
   */
 
 public boolean equals(Object other) {
   return (other==this);
 }
}
