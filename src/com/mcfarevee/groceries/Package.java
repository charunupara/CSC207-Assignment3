package com.mcfarevee.groceries;

public class Package implements Item {
  private String name;
  private Weight weight;
  private int price;

  public Package(String name, Weight weight, int price) {
    this.name = name;
    this.weight = weight;
    this.price = price;
  }


  public String toString() {
    String answer = (this.weight.toString()) + " package of " + this.name;
    return answer;
  }


  public Weight getWeight() {
    return this.weight;
  }

  public int getPrice() {
    return this.price;
  }
  
  /*
   * public String getName() { return this.name; }
   */
  public boolean equals(Object other) {
    Package otherp = (Package) other;
    if (otherp.name.equals(this.name) && (otherp.weight.equals(this.weight))
        && (otherp.price == this.price)) {
      return true;
    } else {
      return false;
    }
  }
  


}
