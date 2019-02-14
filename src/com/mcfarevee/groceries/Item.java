package com.mcfarevee.groceries;

public interface Item {

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+


  public Weight getWeight();

  public int getPrice();

  public String toString();

  public boolean equals(Object other);
}
