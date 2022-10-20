import java.util.Random;
import java.util.Scanner;

class Game{
    int systemnum;
    int usernum;
    int noofguess;

    //Generate random number in between 1 to 100
    //and save as system number
    Game(){
        Random random = new Random();
        this.systemnum = random.nextInt(100) + 1;
    }


    //Create the function which takes proper user input upto 10 attempts
    public boolean takeUserInput(){
//        System.out.println("system generated number is " + systemnum);
        if(noofguess < 10){
            System.out.println("\nRound " + (noofguess+1) + " Starts..... Guess the number : ");
            Scanner sc = new Scanner(System.in);
            usernum = sc.nextInt();
            noofguess++;
            return false;
        }
        else {
            System.out.println("\n---------- No. of attempts finished !!! Try Again... -----------");
        }
        return true;
    }

    //Cheak whether the number entered by user is correct or not
    public boolean isCorrectGuess(){
//        System.out.println();

        //number is correct
        if(systemnum == usernum){
            System.out.println("******************* Congratulations *******************\n");
            System.out.println("You guess the correct number : " + systemnum + "       no. of attempts = " + noofguess + "\n");

            //According to number of guess Display score
            switch (noofguess){
                case 1:
                    System.out.println("------------------ Your score is 100/100 ------------------");
                    break;
                case 2:
                    System.out.println("------------------ Your score is 90/100 ------------------");
                    break;
                case 3:
                    System.out.println("------------------ Your score is 80/100 ------------------");
                    break;
                case 4:
                    System.out.println("------------------ Your score is 70/100 ------------------");
                    break;
                case 5:
                    System.out.println("------------------ Your score is 60/100 ------------------");
                    break;
                case 6:
                    System.out.println("------------------ Your score is 50/100 ------------------");
                    break;
                case 7:
                    System.out.println("------------------ Your score is 40/100 ------------------");
                    break;
                case 8:
                    System.out.println("------------------ Your score is 30/100 ------------------");
                    break;
                case 9:
                    System.out.println("------------------ Your score is 20/100 ------------------");
                    break;
                case 10:
                    System.out.println("------------------ Your score is 10/100 ------------------");
                    break;
            }
            System.out.println();
            return true;
        }

        //if entered number is greater than 100
        else if(usernum > 100){
            System.out.println("Hint :::::: Number is between 1 to 100");
        }

        //if entered number is high
        else if (noofguess < 10 && usernum > systemnum){
            if(usernum-systemnum > 10){
                System.out.println("Hint :::::: Too HIGH");
            }
            else{
                System.out.println("Hint :::::: Little HIGH");
            }
        }

        //if entered number is low
        else if (noofguess < 10 && usernum < systemnum){
            if(systemnum-usernum > 10){
                System.out.println("Hint :::::: Too LOW");
            }
            else{
                System.out.println("Hint :::::: Little LOW");
            }
        }
        return false;
    }
}


class NumberGuesssingGame {

    //Take proper input
    public static int takeIntInput(int limit){
        int input = 0;
        boolean flag = false;

        while (flag==false){
            try{
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
//                System.out.println(input);
                flag = true;

                if(flag && input>limit || input<1){
                    System.out.println("Choose the number between 1 to "+limit);
                    flag = false;
                }
            }
            catch (Exception e){
                System.out.println("Enter only integer value");
                flag = false;
            }
        }
        return input;
    }


    //main function

    public static void main(String[] args){
        System.out.println("You have only 10 Attempts to guess the number\n******** BEST OF LUCK ********\n");


        // input for start the game
        System.out.println("1 : Start the game \n2 : Exit");
        System.out.println("Enter your choice : ");

        int choice = takeIntInput(2);

        int nextRound = 1;

        if(choice == 1){
            //System.out.println("choice is 1");

            //Next Round
            while (nextRound==1){
                Game g = new Game();
                boolean isMatched = false;
                boolean isLimitCross = false;

                while (isMatched == false && isLimitCross == false){
                    isLimitCross = g.takeUserInput();
                    isMatched = g.isCorrectGuess();
                }

                //Play again
                System.out.println("Do you want to play again ?\n1 : YES\n2 : NO");
                System.out.println("Enter your choice : ");
                nextRound = takeIntInput(2);

                if(nextRound != 1){
                    System.exit(0);
                }
            }
        }
        else {
            System.exit(0);
        }
    }
}