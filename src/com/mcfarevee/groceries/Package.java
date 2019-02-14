package com.mcfarevee.groceries;

public class Package implements Item{
  private String name;
 private Weight weight;
 private int price;
 
 public Package(String name, Weight weight,int price) {
   this.name=name;
   this.weight=weight;
   this.price=price;}
 
 
 public String toString() {
   String answer= (this.weight.toString())+" package of "+this.name;
   return answer;
 }
  

 public Weight getWeight() {
 return this.weight;
 }
 public int getPrice()
 {
   return this.price;
 }
 public boolean equals(Package other)
 {
   if (other.name.equals(this.name) && (other.weight.equals(this.weight)) && other.price == this.price) {
     return true;
   }
   else
   {
     return false;
   }
 }
 
}
