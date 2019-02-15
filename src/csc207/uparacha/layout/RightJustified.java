package csc207.uparacha.layout;

import java.io.PrintWriter;

public class RightJustified implements TextBlock {
  private TextBlock content;
  private int width;
  private int height;

  
  public RightJustified(TextBlock tb, int width) throws Exception {
    this.content = tb;
    this.height= this.content.height();
    
    if (width < this.content.width()) {
      throw new Exception("Invalid width " + width);
    } else {
      this.width = width;
    }
    

}
  
  
  public String row(int i) throws Exception{
    String result = "";
    if (i >= 0 && i < this.height) {
      int diff = (this.width - this.content.width());
      for (int j = 0; j < diff; j++) {
        result+=" ";
      }
        String word = (this.content.row(i))+ result;
        return word;
      }else throw new Exception("Invalid row " + i);
  }
    
   

  /**
   * Determine how many rows are in the block.
   */
  public int height() {
    return this.content.height();
  }

  /**
   * Determine how many columns are in the block.
   */
  public int width() {
    return Math.max(this.width, this.content.width());
  }
  
  /*
   * public static void main(String[] args) throws Exception { PrintWriter pen = new
   * PrintWriter(System.out, true);
   * 
   * 
   * 
   * }
   */
}
