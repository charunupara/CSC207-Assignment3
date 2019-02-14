package com.mcfarevee.groceries;

public class ManyPackages implements Item {
  private Package type;
  private int count;

  public ManyPackages(Package type, int count) {
    this.type = type;
    this.count = count;
  }

  public String toString() {
    String answer = String.valueOf(this.count) + " x " + this.type.toString();
    return answer;
  }

  public Weight getWeight() {

    int newAmount = this.count * (this.type.getWeight().getAmount());
    Weight newWeight = new Weight(this.type.getWeight().getUnit(), newAmount);
    return newWeight;

  }

  public int getPrice() {
    return this.count * this.type.getPrice();
  }

  public boolean equals(Object other) {
    return (other == this);
  }
}
