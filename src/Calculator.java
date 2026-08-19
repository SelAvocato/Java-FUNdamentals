import java.util.Scanner;

public class Calculator {
    Scanner scanner = new Scanner(System.in);
    double total = 0;

    public void calculate() {
        System.out.println("---------------Calculator----------------\n" +
                "Press 'Enter' without a number to exit");
        try {
            System.out.print("Enter number: ");
            String firstValStr = scanner.nextLine();
            if (firstValStr.trim().isEmpty()) {
                exit();
                return;
            }
            double firstNum = Double.parseDouble(firstValStr);
            total += firstNum;
        } catch (Exception e){
            System.out.println("Invalid input");
            scanner.close();
            return;
        }

        while (true) {
            try {
                System.out.print("1. Addition  2. Subtraction  3. Multiplication  4. Division  5. Exit\nOperation: ");
                int operation = scanner.nextInt();
                scanner.nextLine();
                if (operation == 5) {
                    exit();
                    break;
                }

                System.out.print("Enter number: ");
                String loopValStr = scanner.nextLine();
                if (loopValStr.trim().isEmpty()) {
                    exit();
                    break;
                }

                double loopNum = Double.parseDouble(loopValStr);
                switch (operation) {
                    case 1 -> add(loopNum);
                    case 2 -> subtract(loopNum);
                    case 3 -> multiply(loopNum);
                    case 4 -> divide(loopNum);
                }
            } catch (IllegalArgumentException e) {
                System.out.println("You can't divide by zero");
            } catch (Exception e) {
                System.out.println("Invalid input");
                scanner.close();
                break;
            }
            System.out.println("Total: " + total);
        }
    }

    public void add(double num) {
        total += num;
    }

    public void subtract(double num) {
        total -= num;
    }

    public void multiply(double num) {
        total *= num;
    }

    public void divide(double num) {
        if (num == 0) {
            throw new IllegalArgumentException();
        }
        total /= num;
    }

    public void exit() {
        System.out.println("Goodbye");
        scanner.close();
    }
}
