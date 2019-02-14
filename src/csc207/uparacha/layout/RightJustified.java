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
    return this.width;
  }
  
  public static void main(String[] args) throws Exception { 
    PrintWriter pen = new       PrintWriter(System.out, true);

    
    TextLine tb1 = new TextLine("Hello");
    TextLine tb2 = new TextLine("World");
    TextBlock compound = new BoxedBlock(new CenteredBlock(new BoxedBlock(new CenteredBlock(new VComposition(tb1, tb2), 7)), 15));
    pen.println("ORIGINAL");
    TBUtils.print(pen, compound);
    tb2.setContents("Someone");
    pen.println("UPDATED");
    TBUtils.print(pen, compound);
    tb1.setContents("Nice to meet you,");
    pen.println("RE-UPDATED");
    TBUtils.print(pen, compound);

  }
}