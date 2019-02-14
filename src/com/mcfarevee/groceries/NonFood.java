package com.mcfarevee.groceries;

public class NonFood implements Item {
  private String name;
  private Weight weight;
  private int price;


  public NonFood(String name, Weight weight, int price) {
    this.name = name;
    this.weight = weight;
    this.price = price;
  }

  public String toString() {
    return this.name;
  }

  public Weight getWeight() {
    return this.weight;
  }

  public int getPrice() {
    return this.price;
  }

  public boolean equals(Object other) {
   NonFood othernf = (NonFood) other;
      if ((this.name.equals(othernf.name)) && (this.weight.equals(othernf.weight))
          && (this.price == othernf.price)) {
        return true;
      }
      else {
        return false;
      }
    
    }
  }

