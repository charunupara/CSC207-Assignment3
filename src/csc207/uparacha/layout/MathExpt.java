package csc207.uparacha.layout;

import java.io.PrintWriter;
import java.math.BigInteger;

/**
 * A few simple experiments with our utilities.
 * Version 1.1 of February 2019.
 */
public class MathExpt {
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);

    BigInteger i = new BigInteger("2345");
    double bi = MathUtils.squareRoot(i);
    pen.println(bi);
    
    Float j = new Float(20.5);
    double floatTest = MathUtils.squareRoot(j);
    pen.println(floatTest);
    
    
    
    
    // Print some square roots.
  //  for (int i = 2; i < 10; i++) {
   //  double root = MathUtils.squareRoot(i);
   //   pen.println("The square root of " + i + " seems to be " + root);
   //   pen.println(root + "^2 = " + (root * root));
  //  } // for i

    // We're done. Clean up.
    pen.close();
  } // main(String[])
} // class MathExpt
