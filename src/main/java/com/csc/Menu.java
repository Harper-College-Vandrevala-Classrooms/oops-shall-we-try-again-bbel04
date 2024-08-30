package com.csc;

import java.util.Scanner;

public class Menu {
    public int validation(String prompt, String errorMessage, Integer lowerBound, Integer upperBound, Scanner in) { //take in prompt, error message, lower and upper bounds, and scanner object as arguments
        int inputInt; //store user input
        
        while (true) {  //infinite loop will execute until valid user input is entered
            System.out.print(prompt);   //output prompt

            if (in.hasNextInt()) {      //check if user input is an integer
                inputInt = in.nextInt();   //set inputInt to user input

                if ((lowerBound == null || lowerBound <= inputInt) && (upperBound == null || inputInt <= upperBound)) { //check if inputInt is within bounds
                    System.out.print("Input is valid ");
                    break;  //break out of loop
                }
                else {   //print error message if out of bounds
                    System.out.println(errorMessage);
                }
            }
            else {  //if scanner does not detect an Integer, notify user of invalid input type
                System.out.println(errorMessage); 
                in.next();   //consume input to avoid infinite loop
            }
        }
        return inputInt;  //return value of input if it is valid
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);   

        Menu menu = new Menu();

        System.out.println(menu.validation("Enter an integer from 0 to 5: ", "The input you entered is invalid. Try again.", 0, 5, scanner));  //test 1: check valid integer from 0 to 5
        System.out.println(menu.validation("Enter an integer from -10 to 10: ", "The input you entered is invalid. Try again.", -10, 10, scanner));   //test 2: check valid integer from -10 to 10
        System.out.println(menu.validation("Enter an integer: ", "Invalid input type", null, null, scanner));    //test 3: check valid integer without bounds
        
        scanner.close();
    }
}