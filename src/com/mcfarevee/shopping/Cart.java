package com.mcfarevee.shopping;

import java.io.PrintWriter;
import java.util.ArrayList;
import com.mcfarevee.groceries.*;
import com.mcfarevee.groceries.Package;

public class Cart {
  private ArrayList<Item> cart;
  
  public Cart() {
    this.cart = new ArrayList<Item>();
  }

  public void addItem(Item item) {
    this.cart.add(item);
  }// addItem
  

  public  int numEntries() {
    return this.cart.size();
  }

  public  void printContents(PrintWriter pen) {
    for (int i = 0; i < this.cart.size(); i++) {
      pen.println(cart.get(i).toString());
    }
  }

  /*
   * public Weight getWeight() { int totalQuant; for (int j=0; j<Cart.numEntries();i++) {
   * cart.get(i).getWeight()) } return total;
   * 
   * }
   */

  public  void remove(String name) {
    boolean has = this.cart.contains(name);
    while (has == true) {
      has = this.cart.remove(name);
    }
  }

  public  int numThings() {
    int numThings = this.numEntries();
    for (int i = 0; i < this.cart.size(); i++) {


      if (cart.get(i) instanceof ManyPackages) {
        numThings -= 1;
        numThings += ((ManyPackages) (cart.get(i))).getCount();
      }
    }
    return numThings;
  }

  public  int getPrice() {
    int totalPrice = 0;
    for (int i = 0; i < this.cart.size(); i++) {
      totalPrice += (cart.get(i)).getPrice();

    }
    return totalPrice;
  }

  public  Weight getWeight(Unit unit) {
    int total = 0;
    Weight current;
    for (int i = 0; i < this.cart.size(); i++) {
      current = (this.cart.get(i)).getWeight();
      if (current.getUnit() == unit) {
        total += current.getAmount();
      }

    }
    return new Weight(unit, total);

  }

  public  void merge() {
    /*
     * take first element check for all of the same type then if
     */

    for (int i = 0; i < this.cart.size(); i++) {
      Object current = this.cart.get(i);

      if (current instanceof BulkItem) {

        BulkItem curBI = (BulkItem) current;

        for (int j = (i + 1); j < this.cart.size(); j++) {

          Object other = this.cart.get(j);

          if (curBI.equals(other)) {
            curBI.setAmount((curBI.getAmount()) + (((BulkItem) other).getAmount()));
            this.cart.set(i, curBI);
            this.cart.remove(j);
            /*
             * Item last = this.cart.get((this.cart.size() - 1)); this.cart.set(j, last);
             * this.cart.trimToSize();
             */

          } // if equals
        }
      } else if (current instanceof Package) {
        Package curP = (Package) current;

        for (int j = (i + 1); j < this.cart.size(); j++) {

          Object other = this.cart.get(j);

          if (curP.equals(other)) {
            ManyPackages newMP = new ManyPackages(curP, 2);
            this.cart.set(i, newMP);
            /*
             * Item last = this.cart.get((this.cart.size() - 1)); this.cart.set(j, last);
             * this.cart.trimToSize();
             */
            this.cart.remove(j);
          }
        }
      }

    }

    for (int i = 0; i < this.cart.size(); i++) {
      Object current = this.cart.get(i);

      if (current instanceof ManyPackages) {
        ManyPackages curMP = (ManyPackages) current;

        for (int j = (i + 1); j < this.cart.size(); j++) {
          Object other = this.cart.get(j);
          if ((curMP.getType()).equals(((ManyPackages) other).getType())) {
            curMP.setCount(curMP.getCount() + ((ManyPackages) other).getCount());
            this.cart.set(i, curMP);
            this.cart.remove(j);
            /*if(j!=((this.cart.size())- 1)) {
            Item last = this.cart.get((this.cart.size())- 1);
            this.cart.set(j, last);
            this.cart.trimToSize();*/
            //}
          }
        }
      }
    }
  }



}// class

