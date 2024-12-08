package src;

import java.util.Scanner;
import java.util.function.Function;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //scanner for user input
        boolean continueConv = true; //flag to control the main loop for repeated conversions

        while (continueConv) {
            try {
                //prompt the user to choose the unit of temperature to convert from
                System.out.println("What unit of temperature would you like to convert from? \nPlease choose between Celsius and Fahrenheit: ");
                String unit = input.nextLine().trim().toLowerCase(); // Read and normalize the user input

                switch (unit) {
                    case "celsius": //user wants to convert from Celsius to Fahrenheit
                        System.out.println("Please enter the temperature value only (in celsius): ");
                        if (input.hasNextDouble()) { //validate that the input is a number
                            double celsius = input.nextDouble(); //read the temperature value
                            input.nextLine(); // Consume the leftover newline
                            double convFahrenheit = celsiusToFahrenheit.apply(celsius); //convert celsius to fahrenheit
                            System.out.println(celsius + " celsius is " + convFahrenheit + " fahrenheit."); //display result
                        } else {
                            throw new IllegalArgumentException(); //handle invalid input
                        }
                        break;

                    case "fahrenheit": //user wants to convert from Fahrenheit to Celsius
                        System.out.println("Please enter the temperature value only (in fahrenheit): ");
                        if (input.hasNextDouble()) { //validate that the input is a number
                            double fahrenheit = input.nextDouble(); //read the temperature value
                            input.nextLine(); //consume the leftover newline
                            double convCelsius = fahrenheitToCelsius.apply(fahrenheit); //convert fahrenheit to Celsius
                            System.out.println(fahrenheit + " fahrenheit is " + convCelsius + " celsius."); //display result
                        }
                        break;

                    default: //handle invalid unit input
                        System.out.println("Please choose between Celsius and Fahrenheit.");
                }
            } catch (IllegalArgumentException e) {
                //handle exceptions for invalid temperature inputs
                System.out.println("Please enter a valid temperature value.");
                input.nextLine(); //clear invalid input
            }

            //ask the user if they want to continue
            System.out.println("Would you like to continue? (y/n): ");
            String choice = input.nextLine().trim().toLowerCase(); //read and normalize user input
            if (choice.equals("n")) { //end the program if the user inputs anything but 'y'
                continueConv = false; //update the loop control flag
                System.out.println("Thank you for using the temperature converter.");
            }
        }

        input.close(); //close the Scanner to release resources
    }

    //lambda function to convert Celsius to Fahrenheit
    static Function<Double, Double> celsiusToFahrenheit =
            celsiusTemp -> (celsiusTemp * 9 / 5) + 32;

    //lambda function to convert Fahrenheit to Celsius
    static Function<Double, Double> fahrenheitToCelsius =
            fahrenheitTemp -> (fahrenheitTemp - 32) * 5 / 9;
}
