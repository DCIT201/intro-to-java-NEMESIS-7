package src;

import java.util.Scanner;
import java.util.function.Function;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("What unit of temperature would you like to convert from? \nPlease choose between Celsius and Fahrenheit: ");
        String unit = input.nextLine().trim().toLowerCase();
        boolean continueConv = true;

        while (continueConv) {
            try {
                switch (unit){
                    case "celsius":
                        System.out.println("Please enter the temperature value only (in celsius): ");
                        if(input.hasNextDouble()){
                            double celsius = input.nextDouble();
                            input.nextLine();
                            double convFahrenheit = celsiusToFahrenheit.apply(celsius);
                            System.out.println(celsius + " celsius is " + convFahrenheit +  " fahrenheit.");
                            break;
                        }
                    case "fahrenheit":
                        System.out.println("Please enter the temperature value only (in fahrenheit): ");
                        if(input.hasNextDouble()){
                            double fahrenheit = input.nextDouble();
                            input.nextLine();
                            double convCelsius = fahrenheitToCelsius.apply(fahrenheit);
                            System.out.println(fahrenheit + " fahrenheit is " + convCelsius + " celsius.");
                            break;
                        }
                    default:
                        System.out.println("Please choose between Celsius and Fahrenheit.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Please enter a valid temperature value.");
            }
            System.out.println("Would you like to continue (y/n): ");
            String choice = input.nextLine().trim().toLowerCase();
            if (choice.equals("n")) {
                continueConv = false;
                System.out.println("Thank you for using the temperature converter.");
            }
        }
        input.close();
    }
    static Function<Double, Double> celsiusToFahrenheit =
            celsiusTemp -> (celsiusTemp * 9/5 ) + 32;

    static Function<Double, Double> fahrenheitToCelsius =
            fahrenheitTemp -> (fahrenheitTemp - 32) * 5/9;
}