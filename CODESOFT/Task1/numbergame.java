import java.util.Random;
import java.util.Scanner;

public class numbergame{
    public static void main(String[] args) {
        int score=0;
        int played=1;
        Scanner sc=new Scanner(System.in);
        boolean g=true;
        
        while(g){
            Random r=new Random();
        int rnum=r.nextInt(9)+1;
        
        int attempts=5;

        while(attempts>=1){
            System.out.println("Guess the number between 1 to 10. You have "+attempts+" attempts remaining out of 5");
            int guess=sc.nextInt();
            if(rnum==guess){
                int a=5-attempts+1;
                System.out.println("Super! You have guessed number within "+a+" attempt");
                score++;
                break;
            }
            if(rnum>guess){
                System.out.println("Your guess is too low");
               
            }
            if(rnum<guess){
                System.out.println("Your guess is too high");
            }
            attempts--;
            
        }
        if( attempts==0){
            System.out.println("Sorry You were not able to guess the number within 5 attempts");

        }
        System.out.println("Do you like to play one more round if yes enter y|Y else n|N");
        char s=sc.next().charAt(0);
        if(s=='y'|| s=='Y'){
            played++;
            g=true;
        }
        else{
            g=false;
        }

        }

        System.out.println("You have scored "+score+" out of "+played+" games played");
        

        


       
        
    }
}