package csc207.uparacha.layout;

import java.io.PrintWriter;

public class Grid implements TextBlock{
  private int width;
  private int height;
  private char ch;

  public Grid(int width, int height, char ch) {
    this.width = width;
    this.height = height;
    this.ch = ch;
  }

  /**
   * Get one row from the block.
   * 
   * @pre i < this.height()
   * @exception Exception if the row number is invalid.
   */
  public String row(int i) throws Exception {
    String result = new String();
    if (i >= 0 && i < this.height) {
      for (int j = 0; j < this.width; j++) {
        result += ch;
      }
    } else {
      System.err.println("Invalid row number.");
    }

    return result;
  }


  /**
   * Determine how many rows are in the block.
   */
  public int height() {
    return this.height;
  }

  /**
   * Determine how many columns are in the block.
   */
  public int width() {
    return this.width;
  }

  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);
    
    TBUtils.print(pen,  new BoxedBlock (new Grid (7, 3, '*')));

  }
}
