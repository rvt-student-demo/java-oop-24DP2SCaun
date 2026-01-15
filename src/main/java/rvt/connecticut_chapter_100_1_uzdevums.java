package rvt;

import java.util.Scanner;

public class connecticut_chapter_100_1_uzdevums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while(true) {
            System.out.print("Enter the numerator ");
            String input = scanner.nextLine();
            
            if (input.isEmpty()) {
                continue;
            }

            if (input.toLowerCase(). charAt(0) == 'q') {
                break;
            } try {
                int numerator = Integer.parseInt(input);

                System.out.print("Enter the divisor:");
                String divisorInput = scanner.nextLine();
                int divisor = Integer.parseInt(divisorInput);

                if (divisor == 0) {
                    System.out.println("You can't divide"+ numerator +" by zero");
                } else {
                    int result = numerator / divisor;
                    System.out.println(numerator + " /" + divisor + " is " + result);
                }

            } catch (NumberFormatException e) {
                System.out.println("You entered bad data");
                System.out.println("Please try again.");
        }

        System.out.println();
    }

    scanner.close();
}

}