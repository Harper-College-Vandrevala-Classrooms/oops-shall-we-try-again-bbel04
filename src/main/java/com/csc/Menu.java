package com.csc;

import java.util.Scanner;
public class Menu {
    public Integer validation(String prompt, String errorMessage, Integer lowerBound, Integer upperBound, Scanner in) { //take in prompt, error message, lower and upper bounds, and scanner object as arguments
        int inputInt; //store user input

        if ((lowerBound == null || upperBound == null) || lowerBound <= upperBound) {
            while (true) {  //will execute until valid user input is entered
                System.out.print(prompt + "(Enter \"exit\" to exit menu): ");   

                if (in.hasNext()) {      //check if user input is an integer
                    String input = in.next();   

                    if (input.equalsIgnoreCase("exit")) { //exit Menu 
                        System.out.println("Menu Exited");
                        return null;
                    }

                    //refactor if-else into try catch to accomodate exit
                    try {  //try to parse int from string input
                        inputInt = Integer.parseInt(input);  
                        //validate int
                        if ((lowerBound == null || lowerBound <= inputInt) && (upperBound == null || inputInt <= upperBound)) { //check if inputInt is within bounds
                            System.out.print("Input is valid ");
                            return inputInt;  
                        } else {
                            System.out.println(errorMessage);
                        }
                    } catch (NumberFormatException e) {  //if no int can be parsed, error
                        System.out.println(errorMessage);
                    }
                } 
            }
        } else {
            System.out.println("Invalid bounds passed");
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);   

        Menu menu = new Menu();

        System.out.println(menu.validation("Enter an integer from 0 to 5. ", "The input you entered is invalid. Try again.", 0, 5, scanner));  //test 1: check valid integer from 0 to 5
        System.out.println(menu.validation("Enter an integer from -10 to 10. ", "The input you entered is invalid. Try again.", -10, 10, scanner));   //test 2: check valid integer from -10 to 10
        System.out.println(menu.validation("Enter an integer. ", "Invalid input type", null, null, scanner));    //test 3: check valid integer without bounds
        System.out.println(menu.validation("Enter an integer between -5 and -8. ", "The integer you entered is invalid.", -5, -8, scanner)); //test 4: test when invalid bounds are passed
        
        scanner.close();
    }
}