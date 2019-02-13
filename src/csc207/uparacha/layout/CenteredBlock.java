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
      throw new Exception("Invalid width" + width);
    } else {
      this.width = width;
    }
  } // CenteredBlock(TextBlock, int)

  public String row(int i) throws Exception{
    String result="";
    if (i >= 0 && i < this.height) {
      if(this.content.width()<=this.width) {
        int diff=( this.width-this.content.width())/2;
        for(int j=0; j<diff;j++) {
          result+=" ";
        }
        String word=(result + this.content.row(i) + result);
        return word;
      }
    }else {
      throw new Exception("Invalid row" + i);
    }
  }

  public int height() {
    return this.content.height();
  } // height()


  public int width() {
    return this.width;
  } // width()

  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);


    TextBlock block = new VComposition(new TextLine("Hello"), new TextLine("Goodbye"));
    TextBlock block2 = new CenteredBlock(block, 11);
    TBUtils.print(pen, block);
    TBUtils.print(pen, block2);

}
}