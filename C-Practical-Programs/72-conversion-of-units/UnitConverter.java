import java.util.Scanner;

public class UnitConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Distance Conversion");
            System.out.println("2. Weight Conversion");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    distanceConversion();
                    break;
                case 2:
                    weightConversion();
                    break;
                case 3:
                    System.out.println("Exiting the Unit Converter. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void distanceConversion() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nDistance Conversion:");

        System.out.print("Enter distance in meters: ");
        double meters = scanner.nextDouble();

        
        double feetConversion = 3.28084;
        double milesConversion = 0.000621371;

        
        double feet = meters * feetConversion;
        double miles = meters * milesConversion;

        System.out.println("Converted distance:");
        System.out.println("Feet: " + feet);
        System.out.println("Miles: " + miles);
    }

    private static void weightConversion() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWeight Conversion:");

        System.out.print("Enter weight in kilograms: ");
        double kilograms = scanner.nextDouble();

        
        double poundsConversion = 2.20462;

        
        double pounds = kilograms * poundsConversion;

        System.out.println("Converted weight:");
        System.out.println("Pounds: " + pounds);
    }
}
