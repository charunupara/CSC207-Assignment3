package csc207.uparacha.layout;

import java.io.PrintWriter;

public class TruncatedBlock implements TextBlock {
  private TextBlock content;
  private int width;
  private int height;

  /**
   * Create a new truncated block of the specified width.
   */
  public TruncatedBlock(TextBlock tb, int width) {
    this.content = tb;
    this.width = width;
    
  } // TruncatedBlock(TextBlock, int)

  /**
   * Get the ith row of the block.
   */
  public String row(int i) throws Exception {
    String result = new String();
    int h = this.content.height();
    
    if (i < this.height && i >= 0) {
      for (int j = 0; j < this.width; j++) {
        result += this.content.row(i).charAt(j);
      }
    String thisRow = this.content.row(i);
    
    
    } else {
      System.err.println("Invalid row number.");
    }
    return result;
  } // row(int)

  /**
   * Determine how many rows are in the block.
   */
  public int height() {
    return this.content.height();
  } // height()

  /**
   * Determine how many columns are in the block.
   */
  public int width() {
    return this.content.width();
  } // width()

  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);

    
    TextBlock block = new VComposition(new TextLine("Hello"), new TextLine("Goodbye"));
    TextBlock block2 = new TruncatedBlock(block, 3);
    TBUtils.print(pen, block);
    TBUtils.print(pen, block2);
  }
} // class TruncatedBlock


