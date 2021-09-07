package solution;

import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        Scanner userInput = new Scanner(System.in);
        String userInputString;

        while(true){
            System.out.println("Please type a number to be converted. Typing a roman numeral " +
                    "will result in an arabic numeral, and vis versa.");
            System.out.println("if you would like to finish, press your \"Enter\" key.");
            userInputString = userInput.nextLine();
            if(userInputString.equals("")){
                System.out.println("Alright. Thanks for using the program!");
                break;
            }

            int temp = 0;
            boolean isInt;
            RomanNumeral numeral;

            try {
                temp = Integer.parseInt(userInputString);
                isInt = true;
            }catch (NumberFormatException e){
                isInt = false;
            }

            if(isInt){
                try {
                    numeral = new RomanNumeral(temp);
                    System.out.println("You entered an arabic numeral.");
                    System.out.println("Your input number was "+ temp + ", which is the same as " + numeral.toString());
                } catch (NumberFormatException e){
                    System.out.println(e.getMessage());
                }

            }else{
                try{
                    numeral = new RomanNumeral(userInputString);
                    System.out.println("You entered an arabic numeral.");
                    System.out.println("Your input number was "+ userInputString + ", which is the same as " + numeral.toInt());
                }catch (NumberFormatException e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
