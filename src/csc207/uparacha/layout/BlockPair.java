package csc207.uparacha.layout;

import java.io.PrintWriter;

public class BlockPair implements TextBlock {
  private TextBlock content;
  private int width;
  private int height;
  
  /**
   * Create a new truncated block of the specified width.
   */
  public BlockPair(TextBlock tb) {
    this.content = tb;
    this.width = 2*this.content.width();
    this.height = this.content.height();
  } // BlockPairk(TextBlock, int)

  public String row(int i) throws Exception {
    if (i >= 0 && i < this.height) {
      String result=this.content.row(i);
      return result+result;
    } else {
      throw new Exception("Invalid row" + i);
    }
  }
  public int height() {
    return this.height;
  } // height()
  
  public int width() {
    return this.width;
  } // width()
  
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);


    TextBlock block = new VComposition(new TextLine("Hello"), new TextLine("Goodbye"));
    TextBlock block2 = new BlockPair(block);
    TBUtils.print(pen, block);
    TBUtils.print(pen, block2);
  }
  
}
