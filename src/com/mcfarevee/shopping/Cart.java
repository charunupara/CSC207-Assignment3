package com.mcfarevee.shopping;

import java.io.PrintWriter;
import java.util.ArrayList;
import com.mcfarevee.groceries.Item;
import com.mcfarevee.groceries.Weight;
import com.mcfarevee.groceries.*;

public class Cart {
  private static ArrayList<Item> cart;

  public void addItem(Item item) {
    Cart.cart.add(item);
  }// addItem
  /*
   * public void numThings() {
   * 
   * }
   */

  public static int numEntries() {
    return Cart.cart.size();
  }

  public void printContents(PrintWriter pen) {
    for (int i = 0; i < Cart.cart.size(); i++) {
      pen.println(cart.get(i).toString());
    }
  }

  /*
   * public Weight getWeight() { int totalQuant; for (int j=0; j<Cart.numEntries();i++) {
   * cart.get(i).getWeight()) } return total;
   * 
   * }
   */

  public void remove(String name) {
    boolean has = Cart.cart.contains(name);
    while (has == true) {
      has = Cart.cart.remove(name);
    }
  }

  public int numThings() {
    int numThings = Cart.numEntries();
    for (int i = 0; i < Cart.cart.size(); i++) {


      if (cart.get(i) instanceof ManyPackages) {
        numThings -= 1;
        numThings += ((ManyPackages) (cart.get(i))).getCount();
      }
    }
    return numThings;
  }

  public int getPrice() {
    int totalPrice = 0;
    for (int i = 0; i < Cart.cart.size(); i++) {
      totalPrice += (cart.get(i)).getPrice();

    }
    return totalPrice;
  }
  
  public Weight getWeight(Unit unit) {
    int total=0;
    Weight current;
    for (int i = 0; i < Cart.cart.size(); i++) {
      current=(Cart.cart.get(i)).getWeight();
      if(current.getUnit()==unit) {
    total+=  current.getAmount();
      }

    }
    return new Weight(unit, total);
    
  }
  
  public void merge() {
  /*  take first element
    check for all of the same type
    then if 
    */
    
    
    
    for(int i=0;  i < Cart.cart.size();i++) {
      Object ib= Cart.cart.get(i);
      if (ib instanceof BulkItem) {
        
        for(int j=i; j< Cart.cart.size(); i++) {
          Object current= Cart.cart.get(j);
        }
         if(ib.equals(current)){
        ((BulkItem) ib).setAmount(ib.amount+(current.getA)); 
       }
       }
      
      if (ib instanceof BulkItem) {
        for (int j=0; )
      }else if(ib instanceof Package) {
        
      } 
        
        if(ib instanceof ManyPackages) {
        
      }
      
    }//outer for
    }//merge()

}// class

