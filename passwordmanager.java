/**
 * Paasword manager aim to check strength, poolsize, entropy
 * @author Naman
 * @version 1.0
 */
import java.util.*;
public class passwordmanager
{
    String password="";
    int attempt=0;
    int poolsize=0;
    int a=0,b=0,c=0,d=0;
    int two =0 , one =0, three=0, four =0;
    void input() // to take input
    {
     Scanner in = new Scanner(System.in); 
     System.out.println("Enter the password");
     password = in.nextLine();
     condition();
    }
    
    void commonpassword() //to check whether the input password match with the common one
    {
        int u =0;
        String[] common = { "password", "123456", "123456789", "12345678", "12345",
        "qwerty", "abc123", "password1", "password123", "iloveyou",
       "admin", "welcome", "letmein", "monkey", "dragon",
      "football", "1234567890", "111111", "123123", "qwerty123",
      "1q2w3e4r", "sunshine", "princess", "trustno1", "000000",
      "qwertyuiop", "starwars", "freedom", "whatever", "shadow",
      "michael", "jennifer", "computer", "superman", "hunter",
      "buster", "soccer", "harley", "ranger", "cookie",
      "asdfgh", "zxcvbn", "michelle", "charlie", "andrew",
      "matthew", "jordan23", "ashley", "amanda", "tigger"};
        for (int i =0; i<common.length;i++)
        {
           if(password.equalsIgnoreCase(common[i]))
           {
            System.out.println("\u001B[31m WARNING! \u001B[0m This password appears in common leaked password lists! \n Try again");
            u=1;
            break;
           }
        }
        if(u==0)
        
        {
            if(password.length()>=8&&four==1)
              System.out.println("Password strength: Strong");
            else if(password.length()>=8 && three==1)
             System.out.println("Password strength: Moderate");
            else if(password.length()>=8 && two==1)
             System.out.println("Password strength: Weak");
            else if(password.length()>=8 && one==1)
             System.out.println("Password strength:Very weak");
            else if(password.length()>4 && password.length()<8 && (one==1|| two==1) )
             System.out.println("Password strength: Very Weak");
             else if(password.length()>4 && password.length()<8 && (three==1|| four==1) )
             System.out.println("Password strength: Moderate");
            else if ( password.length()<=4)
                System.out.println("Password strength: Very Weak");
            System.out.println("Poolsize ="+poolsize);
            double entropy = 8 * Math.log(2*poolsize);
            System.out.println("Entropy ="+entropy);
        }
           
    }
    void condition()
    {
        if(password.length()>=1&& password.length()<=15)
        {
            int i;
            for( i =0;i<password.length();i++)
            {
                char ch = password.charAt(i);
                if(Character.isUpperCase(ch))
                a=1;
                if(Character.isLowerCase(ch))
                b=1;
                if(Character.isDigit(ch))
                c=1;
                if(ch==35||ch==36||ch==38||ch==64)
                d=1;
                if(ch==32)
                {
                  System.out.println("\u001B[31m WARNING! \u001B[0m You have entered the wrong password. TRY AGAIN");
                  attempt++;
                  input();
                }
            } 
              int A = 26;
              int B=26;
              int D = 32;
              int C = 10;
            if(a==0&&d==1&&b==1&&c==1)
            {   
                poolsize = D+B+C;;
                three=1;
                System.out.println( "\u001B[31m WARNING! \u001B[0m Password should Contain at least one Uppercase Letter.");
            }
            if(a==1&&d==1&&b==0&&c==1)
            {
                poolsize = A+C+D;
                three=1;
               System.out.println("\u001B[31m WARNING! \u001B[0m Password should Contain at least one Lowercase Letter.");
            }
            if(a==1&&d==1&&b==1&&c==0)
            {
                poolsize = A+B+D;
                three=1;
                System.out.println("\u001B[31m WARNING! \u001B[0m Password should Contain at least one numeric digit. ");
            }
            if(a==1&&d==0&&b==1&&c==1)
            {
                poolsize = A+B+C;
                three=1;
                System.out.println("\u001B[31m WARNING! \u001B[0m Password should Contain at least one special Character. ");
            }
            else if (a==0&&b==0&&d==1&&c==1)
            {
                System.out.println( "\u001B[31m WARNING! \u001B[0m Password should both Contain at least one Uppercase  and LowerCase Letter. ");
                poolsize = D+C;
                two=1;
            }
            else if (a==0&&c==0&&d==1&&b==1)
            {
                System.out.println( "\u001B[31m WARNING! \u001B[0m Password should both Contain at least one Uppercase Letter and a numeric digit. ");
                poolsize = D+B;
                two=1;
            }
            else if (a==0&&d==0&&b==1&&c==1)
            {
                System.out.println( "\u001B[31m WARNING! \u001B[0m Password should both Contain at least one Uppercase Letter and a Special Character.");
                poolsize = B+C;
                two=1;
            }
            else if (b==0&&c==0&&a==1&&d==1)
            {
                System.out.println( "\u001B[31m WARNING! \u001B[0m Password should both Contain at least one LowerCase Letter and a numeric digit. ");
                poolsize = D+A;
                two=1;
            }
            else if (d==0&&b==0&&a==1&&c==1)
            {
                System.out.println( "\u001B[31m WARNING! \u001B[0m Password should both Contain at least  one LowerCase Letter and a Special Character. ");
                poolsize = A+C;
                two=1;
            }
            else if (d==0&&c==0&&a==1&&b==1)
            {
                System.out.println( "\u001B[31m WARNING! \u001B[0m Password should both Contain at least one numeric digit and a Special Character. ");
                poolsize = A+B;
                two=1;
            }
            else if(a==1&&b==0&&c==0&&d==0)
            {
                System.out.println( "\u001B[31m WARNING! \u001B[0m Password should Contain at least one Lowercase Letter, Numeric digit and special character. ");
                poolsize = A;
                one =1;
            }
            else if(a==0&&b==1&&c==0&&d==0)
            {
                System.out.println( "\u001B[31m WARNING! \u001B[0m Password should Contain at least one Uppercase Letter, Numeric digit and special character.");
                poolsize = B;
                one =1;
            }
            else if(a==0&&b==0&&c==1&&d==0)
            {
                System.out.println( "\u001B[31m WARNING! \u001B[0m Password should Contain at least one Lowercase Letter, Uppercase letter and special character.");
                poolsize = C;
                one =1;
            }
            else if(a==0&&b==0&&c==0&&d==1)
            {
                System.out.println( "\u001B[31m WARNING! \u001B[0m Password should Contain at least one Lowercase Letter, Numeric digit and Uppercase letter. ");
                poolsize = D;
                one =1;
            }
            
            if(a==1&&b==1&&c==1&&d==1)
            {
                poolsize = A+B+C+D;
                four = 1;
            }
            commonpassword();
        }
        else if(password.length()>15)
        {
            System.out.println("\u001B[31m WARNING! \u001B[0m Password should not be greater than 15 characters. TRY AGAIN");
            attempt++;
            input();
        }
    }
    public static void main (String args[])
    {
        System.out.println("Welcome to password manager");
        System.out.println(" A strong password is a said when:");
        System.out.printf("%5s-%1s", "#", "It must be at least 8 characters long and should not exceed 15 characters\n");
        System.out.printf("%5s-%1s", "#", "Must contain a Lowercase letter\n");
        System.out.printf("%5s-%1s", "#", "Must contain a Uppercase letter\n");
        System.out.printf("%5s-%1s", "#", "Must contain a Numeric digit\n");
        System.out.printf("%5s-%1s", "#", "Must contain a Special character (&,$,#,@)\n");
        System.out.printf("%5s-%1s", "#", "Not in a small list of common/leaked passwords \n");
        passwordmanager ob = new passwordmanager();
        ob.input();
        
    }
}