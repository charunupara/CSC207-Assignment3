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
    //this.width=this.content.width();
    } else {
      this.width = width;
    }
  } // CenteredBlock(TextBlock, int)

  public String row(int i) throws Exception {
    /*
     * if (this.width < this.content.width()) { //throw new Exception("Invalid width " + width);
     * this.width=this.content.width();
     */
    
    
    String result = this.content.row(i);
    
    if (i >= 0 && i < this.height) {
      int diff = (this.width - this.content.width());
         for (int j = 0; j>= 0 && j < diff; j++) {
          if ((j % 2) == 0) {
            result = " " + result;
          }//if 
          else {
            result = result + " ";
          }//else
         }//for
      return result;
    } else
      throw new Exception("Invalid row " + i);

  }

  public int height() {
    return this.content.height();
  } // height()


  public int width() {
    return this.width;
  } // width()

  
    public static void main(String[] args) throws Exception { PrintWriter pen = new
    PrintWriter(System.out, true);
    
    /*
     * TextBlock top = new CenteredBlock(new TextLine("He"), 11); TextBlock bottom = new
     * CenteredBlock(new TextLine("Goodbye"), 11); TextBlock block = new BoxedBlock(new
     * VComposition(top,bottom)); TBUtils.print(pen, block);
     */
    

    TextLine tb1 = new TextLine("Hello");
    TextLine tb2 = new TextLine("World");
    VComposition a= new VComposition(tb1, tb2);
    CenteredBlock b= new CenteredBlock(a , 7);
    BoxedBlock c= new BoxedBlock (b);
    CenteredBlock d= new CenteredBlock(c, 15);
    
    TextBlock compound = new BoxedBlock (d);
        
    pen.println("ORIGINAL");
    pen.println(tb1.width());
    pen.println(tb2.width());
    
    pen.println(compound.width());
    TBUtils.print(pen, compound);
    pen.println(compound.width());
   // pen.println(compound.contents.width());
    tb2.setContents("Someone");
    pen.println("djashdjk");
    
    pen.println(a.width());
    
  
    
    pen.println("UPDATED");
    pen.println(tb1.width());
    pen.println(tb2.width());
    pen.println(compound.width());
    TBUtils.print(pen, compound);
    tb1.setContents("Nice to meetu,");
    pen.println(b.width());
    pen.println(a.width());
    pen.println(tb1.width());
    pen.println(tb2.width());
   // pen.println(compound.width());
    pen.println("RE-UPDATED");
    TBUtils.print(pen, compound);
    }
}
