package rsa_attaq;
import java.math.BigDecimal;
import java.math.BigInteger;
public class Fraction {
    
  public BigInteger numerator;
  public BigInteger denominator;

  //prend en parametre deux entier 
  public Fraction(BigInteger paramBigInteger1, BigInteger paramBigInteger2){

	
    BigInteger localBigInteger = gcd(paramBigInteger1, paramBigInteger2);
    
    this.numerator = paramBigInteger1.divide(localBigInteger);
    this.denominator = paramBigInteger2.divide(localBigInteger);
  }
  //entier + fraction
  public Fraction(BigInteger paramBigInteger, Fraction paramFraction) {
	    this.numerator = paramBigInteger.multiply(paramFraction.denominator);
	    this.denominator = paramFraction.numerator;
	    BigInteger localBigInteger = gcd(this.numerator, this.denominator);
	    this.numerator = this.numerator.divide(localBigInteger);
	    this.denominator = this.denominator.divide(localBigInteger);
  }
  
  
  public BigInteger floor() {
    BigDecimal localBigDecimal1 = new BigDecimal(this.numerator);
    BigDecimal localBigDecimal2 = new BigDecimal(this.denominator);
    //Retourne un BigDecimal égal à this / val. La division s'arrête
    //lorsque le nombre de chiffres significatifs spécifiés par mc est atteint, ou lorsqu'un quotient exact est trouvé. 
    //mc peut modifier le mode d'arrondi.
    return localBigDecimal1.divide(localBigDecimal2, 3).toBigInteger();
  }
  
  public Fraction remainder(){
	  BigInteger floor = this.floor();
	  BigInteger numeratorNew = this.numerator.subtract(floor.multiply(this.denominator));
	  BigInteger denominatorNew = this.denominator;
	  return new Fraction(numeratorNew, denominatorNew);
  }

  public static BigInteger gcd(BigInteger paramBigInteger1, BigInteger paramBigInteger2) {
    return paramBigInteger1.gcd(paramBigInteger2);
  }
}
    

