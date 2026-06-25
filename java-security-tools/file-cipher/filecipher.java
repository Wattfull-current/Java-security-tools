/**
 * Program that encrypts and decrypts text files using a byte-level XOR cipher.
 * Program also contain some useful messages please read them as well.
 * @author Naman
 * @version 1.0
 */
import java.lang.*;
import java.util.*;
import java.io.*;
public class filecipher {
    
   public static void main (String args[])
   {
    Scanner in = new Scanner(System.in);
    System.out.println("Enter file name:");
    int key = 42; // you can use your own key too
    String filename = in.next();
    String r2="";
    in.nextLine();
     try {
/* 
 * NOTE: I used some prgram segment of getting input from a file so take it just for the understanding, because these segment do not work 
 * when we are encrypting the file. The XOR cipher works differnetly than file operation. So these two are different things which I got confused
 * and so I used them and you do not get any confusion. I have attached the part of program too, so that you may learn the concept.
 * If you do not want to encrypt and want to know how the file operation work you can use it.
 * But with care.
 */
         FileOutputStream fw = new FileOutputStream(filename); 
         //DataOutputStream dw = new DataOutputStream(fw);
         System.out.println("Enter the input in file");
         String inp = in.nextLine();
         r2=inp;
         //dw.writeUTF(inp);
         //dw.close();
         byte[] inpby = inp.getBytes();
         for(int i =0; i<inpby.length;i++)
         {
            int encryptedBytes = inpby[i]^key;
            fw.write(encryptedBytes);
         }
         fw.close();
         System.out.println();
         System.out.println("\n========================================");
         System.out.println("File encrypted and saved successfully.");
         System.out.println("========================================\n");
     } catch (IOException e) {
         System.err.println(e);// TODO: handle exception
     }
/*  Getting output for a file 
*
*
*
*
*/
/* NOTE: 
 * I used some prgram segment of getting output from a file so take it just for the understanding, because these segment do not work 
 * when we are decrypting the things. However if you do not want to decrypt and want to know how the file operation work you can use it.
 * But with care.
 */
      System.out.println();
      System.out.println("Original input   : " + r2);
      StringBuilder r1 = new StringBuilder();
     try {
        FileInputStream fin = new FileInputStream(filename);
        //DataInputStream din = new DataInputStream(fin);
        StringBuilder result = new StringBuilder();
        int byteread;
        //boolean EOF = true;
         
        while((byteread = fin.read())!= -1)
        {
            int decryptedBytes = byteread^key;
            result.append((char) decryptedBytes);
        }
        fin.close();
        r1= result;
        System.out.println("Decrypted content : " + result.toString());
        
    } 
    
    catch (IOException E1) {
        System.err.println(E1);
    }
    System.out.println("Match status      : " + (r2.equals(r1.toString()) ? "SUCCESS - matches original" : "MISMATCH - error"));
        /*while(EOF)
        {
            try {
                String st;
                st = din.readUTF();
                System.out.println(st);
            } catch (EOFException e1) {
               System.out.println("End of file"); // TODO: handle exception
               EOF = false;
            }
        }
     } catch (IOException e2) {
        System.err.println(e2);// TODO: handle exception
     }*/
    
    
   }
}
