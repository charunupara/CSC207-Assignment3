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
    this.height = this.content.height();
  } // TruncatedBlock(TextBlock, int)

  /**
   * Get the ith row of the block.
   */
  public String row(int i) throws Exception {
    String result = "";
    if (i >= 0 && i < this.height) {
      result = (this.content.row(i)).substring(0, (width));
      return result;
    } else {
      throw new Exception("Invalid row" + i);
    }

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
    return this.width;
  } // width()

  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);


    TextBlock block = new VComposition(new TextLine("Hello"), new TextLine("Goodbye"));
    TextBlock block2 = new TruncatedBlock(block, 3);
    TBUtils.print(pen, block);
    TBUtils.print(pen, block2);
    
    
    TextLine tb1 = new TextLine("Hello");
    TextLine tb2 = new TextLine("World");
    TextBlock compound = new BoxedBlock (new BoxedBlock (new VComposition(tb1, tb2)));
    pen.println("ORIGINAL");
    TBUtils.print(pen, compound);
    tb2.setContents("Someone");
    pen.println("UPDATED");
    TBUtils.print(pen, compound);
    tb1.setContents("Nice to meet you,");
    pen.println("RE-UPDATED");
    TBUtils.print(pen, compound);
  }
} // class TruncatedBlock


