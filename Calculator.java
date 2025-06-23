import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean trueInput = true;

        while (trueInput) {
            System.out.print("Enter first number: ");
            double num1 = sc.nextDouble();
            System.out.print("Enter second number: ");
            double num2 = sc.nextDouble();

            int choice = 0;
            boolean validChoice = false;

            while (!validChoice) {
                System.out.println("Select operation:");
                System.out.println("1. Addition");
                System.out.println("2. Subtraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");

                choice = sc.nextInt();

                if (choice >= 1 && choice <= 4) {
                    validChoice = true;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            }

            double result = 0;

            switch (choice) {
                case 1:
                    result = add(num1, num2);
                    break;
                case 2:
                    result = subtract(num1, num2);
                    break;
                case 3:
                    result = multiply(num1, num2);
                    break;
                case 4:
                    try {
                        result = divide(num1, num2);
                    } 
                    catch (ArithmeticException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                    break;
            }

            System.out.printf("The result is: %.2f%n", result);

            System.out.print("Do you want to perform another calculation? (yes/no): ");
            String again = sc.next();
            trueInput = again.equalsIgnoreCase("yes") || again.equalsIgnoreCase("y");
        }

        System.out.println("Calculator exited.");
        sc.close();
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Error: Division by zero is not allowed.");
        }
        return a / b;
    }
}
