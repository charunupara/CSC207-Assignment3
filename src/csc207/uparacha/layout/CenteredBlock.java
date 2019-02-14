package csc207.uparacha.layout;

import java.io.PrintWriter;


public class CenteredBlock implements TextBlock {
  private TextBlock content;
  private int width;
  private int height;


  public CenteredBlock(TextBlock tb, int width) throws Exception {
    this.content = tb;
    this.height = this.content.height();

    if (width < this.content.width()) {
      throw new Exception("Invalid width " + width);
    } else {
      this.width = width;
    }
  } // CenteredBlock(TextBlock, int)

  public String row(int i) throws Exception {
    String result = this.content.row(i);
    if (i >= 0 && i < this.height) {
      int diff = (this.width - this.content.width());
      for (int j = 0; j < diff; j++) {
        if((j%2)==0) {
        result=" "+ result;}
        else {
          result= result +" ";
        }
      }
        return result;
      }else throw new Exception("Invalid row " + i);
    
    }

  public int height() {
    return this.content.height();
  } // height()


  public int width() {
    return this.width;
  } // width()

  
    public static void main(String[] args) throws Exception { PrintWriter pen = new
    PrintWriter(System.out, true);
    
    TextBlock top = new CenteredBlock(new TextLine("He"), 11);
    TextBlock bottom = new CenteredBlock(new TextLine("Goodbye"), 11);
    TextBlock block = new BoxedBlock(new VComposition(top,bottom));
    TBUtils.print(pen, block);
    
    /*TextLine tb1 = new TextLine("Hell"); TextLine tb2 = new TextLine("World"); TextBlock compound
    = new BoxedBlock(new CenteredBlock(new BoxedBlock(new CenteredBlock(new VComposition(tb1, tb2),
    7)), 15)); pen.println("ORIGINAL"); TBUtils.print(pen, compound); tb2.setContents("Someone");
    pen.println("UPDATED"); TBUtils.print(pen, compound); tb1.setContents("Nice to meet you,");
    pen.println("RE-UPDATED"); TBUtils.print(pen, compound);
    
    TextBlock top = new CenteredBlock(new TextLine("Hello"), 11); TextBlock bottom = new
    CenteredBlock(new TextLine("Goodbye"), 11); TextBlock block = new BoxedBlock(new
    VComposition(top,bottom)); TBUtils.print(pen, block);
    
    TextBlock block5 = new VComposition((new TextLine("Hello")), new TextLine("Goodbye"));
    TextBlock block2 = new BoxedBlock(new CenteredBlock(block5, 11)); TBUtils.print(pen, block2); }*/
    }
}
