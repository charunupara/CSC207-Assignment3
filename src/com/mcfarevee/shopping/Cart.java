package com.mcfarevee.shopping;

import java.io.PrintWriter;
import java.util.ArrayList;
import com.mcfarevee.groceries.*;
import com.mcfarevee.groceries.Package;

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
      Object current= Cart.cart.get(i);
            
      if (current instanceof BulkItem) {  
      
        BulkItem curBI = (BulkItem) current;

        for(int j=(i+1); j< Cart.cart.size(); i++) {
        
          Object other= Cart.cart.get(j);
          
          if(curBI.equals(other)){
        curBI.setAmount((curBI.getAmount()) +(((BulkItem) other).getAmount())); 
        Cart.cart.set(i,curBI);
        Item last= Cart.cart.get((Cart.cart.size()-1));
        Cart.cart.set(j,last);
        Cart.cart.trimToSize();
        
      }//if  equals
        }
      }else if(current instanceof Package) {
        Package curP = (Package) current;

        for(int j=(i+1); j< Cart.cart.size(); i++) {
        
          Object other= Cart.cart.get(j);
          
          if(curP.equals(other)){
        ManyPackages newMP= new ManyPackages( curP, 2);
        Cart.cart.set(i,newMP);
        Item last= Cart.cart.get((Cart.cart.size()-1));
        Cart.cart.set(j,last);
        Cart.cart.trimToSize();
      }
        }
      }
      
    }
    
    for(int i=0;  i < Cart.cart.size();i++) {
      Object current= Cart.cart.get(i);
      
      if (current instanceof ManyPackages) {  
        ManyPackages curMP = (ManyPackages) current;
        
        for(int j=(i+1); j< Cart.cart.size(); i++) {
          Object other= Cart.cart.get(j);
          if((curMP.getType()).equals(((ManyPackages)other).getType())) {
            curMP.setCount(curMP.getCount()+((ManyPackages)other).getCount());
            Cart.cart.set(i,curMP);
            Item last= Cart.cart.get((Cart.cart.size()-1));
            Cart.cart.set(j,last);
            Cart.cart.trimToSize();
          }
    }}}}
      


}// class

