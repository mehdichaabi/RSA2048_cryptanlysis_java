//# RSA2048_cryptanlysis_java
//Encryptpion java_code
package rsa_attaq;
import java.math.BigInteger;
import java.security.SecureRandom;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author frox
 */
public class rsa {
    private BigInteger n, d, e,p,q,dp;
    public BigInteger getN() {
        return n;
    }
    public BigInteger getQ() {
        return q;
    }
    public BigInteger getP() {
        return p;
    }

    public void setN(BigInteger n) {
        this.n = n;
    }

    public BigInteger getD() {
        return d;
    }
     

    public void setD(BigInteger d) {
        this.d = d;
    }

    public BigInteger getE() {
        return e;
    }

    public void setE(BigInteger e) {
        this.e = e;
    }
     public void KeyRSA(int bit1,int bit2){
         SecureRandom r = new SecureRandom();//create BigInteger r random
         p = BigInteger.probablePrime(bit1, r);
         q = BigInteger.probablePrime(bit2, r);
         n = p.multiply(q);
         BigInteger m = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
         
          
         boolean found = false;
         do {
            e = new BigInteger(bit1, r);
            if (m.gcd(e).equals(BigInteger.ONE) && e.compareTo(m) < 0) {
                found = true;
            }
         } while (!found);
         d = e.modInverse(m);
         dp =(d.mod(p.subtract(BigInteger.ONE)));
         
         
     }
     public  String encrypt(String message,BigInteger e1,BigInteger n1) {
        return (new BigInteger(message.getBytes())).modPow(e1, n1).toString();
    }
    public String decrypt(String message) {
        //return new String((new BigInteger(message)).modPow(d, n).toByteArray());
        return ((new BigInteger(message).mod(p)).modPow(dp, p.subtract(BigInteger.ONE)).toString());
    }
    public String decrypt_param(String message,BigInteger d,BigInteger n) {
        //return new String((new BigInteger(message)).modPow(d, n).toByteArray());
        return new String((new BigInteger(message)).modPow(d, n).toByteArray());
    } 
     public static void main(String[] args) throws Exception {
         rsa a=new rsa();
         String text ="afsa khayba ****** *** ** **";
         BigInteger C=new BigInteger("14416795327113130659958099397828380073307351108403177832058464227333425658505980469276491157920925545686954965419583355597677508738298728770714707294403880205164164476106326450969653578153595718414286648493963590676504977013021227654004412921360382532559192821883370966337824744600457810093264540590571643011694116516765704934909932394621959225633454269899918425161430441623772989939935038460133848325982521709092864179714779510310518112795758480444280130131770537009791368316896282776974760164342189305878532927482067446627056442192085325101870840465971498936665491868700126063265082934543022606992345619297671751847");
         BigInteger N=new BigInteger("26097671695808496244855154470989041916111880849148817271412591072244123230765772594098538808548577872277355348117467843046441132695952774759164271854739690409910863556006947342251145139443584610429103572011994941485807069637779740701247410013683357523969507313153350494603524198852341982523478559454423190058386311275204403547433869140554771473029936210606855701395664999161350064139620151252955083525950417994105058871815116607642261901193088729871629962627468679310325040100139840410970019478681155001324491440098912066904089340611682843840365157417090223605015164060963216103270949393052452592152805304697590445381");
         BigInteger e2= new BigInteger("14274587226893404013509076551000389068796554973304448436086797402302027837003262127649501635802863531962207484649058593985330801185438907139473885890836121118507661521821259307324404656948732553691528336959004908399820560702007346107021170560127713677944722516254693569152847374869688616259800907385152658679341561011142465004412290257916111860494421925503766834674656279129018111154329762745312586750057827561599172168790424071813634497881043419404335664745000569557338452768128803838411089127686248504121563937007799435653015475436331396074899531611837905599539281079329812972466478723999213304856536164366966505891");
         
         String crypt=a.encrypt(text,e2,N);
         BigInteger d=new BigInteger("3112405399826731685511088680704112393597168224103101909499006930077701710757380424438817573242066635582524265915110782516330386337303827121787800437419");
         System.out.println("le message crypter:"+crypt);
         String decrypt=a.decrypt_param(crypt,d,N);
         System.out.println("le message decrypter: "+decrypt);
         /*String s=a.getE().toString();
         BigInteger e=new BigInteger(s);
         String crypt=a.encrypt(text,e,a.getN());
         System.out.println("le message crypter:"+crypt);
         String decrypt=a.decrypt(crypt);
         System.out.println("le message decrypter: "+decrypt);*/
         
     }
}
