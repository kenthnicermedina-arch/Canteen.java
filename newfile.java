import java.util.Scanner;

public class Canteen {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        String[] menuNames = {"Burger", "Pizza", "Pasta", "Sandwich", "Milk Tea"};
        double[] menuPrices = {80.00, 120.00, 100.00, 70.00, 90.00};
        
        int totalItems = 0;
        double totalBeforeDiscount = 0.0;
        double totalDiscount = 0.0;
        
        boolean ordering = true;
        
        while (ordering) {
            System.out.println("\n===== MENU =====");
            for (int i = 0; i < menuNames.length; i++) {
                System.out.printf("%d. %s - $%.2f%n", (i+1), menuNames[i], menuPrices[i]);
            }
            
            System.out.print("Enter item number: ");
            int itemNum = input.nextInt();
            
            System.out.print("Enter quantity: ");
            int qty = input.nextInt();
            
            System.out.print("Are you a student? (Y/N): ");
            char isStudent = input.next().toUpperCase().charAt(0);
            
            boolean valid = true;
            if (itemNum < 1 || itemNum > 5) valid = false;
            if (qty < 1 || qty > 10) valid = false;
            
            if (!valid) {
                System.out.println("Invalid order! Please enter a valid item and quantity.");
                System.out.print("Do you want to order again? (Y/N): ");
                char againInvalid = input.next().toUpperCase().charAt(0);
                if (againInvalid != 'Y') ordering = false;
                continue;
            }
            
            double priceEach = menuPrices[itemNum - 1];
            double subTotal = priceEach * qty;
            
            double discPercent = 0.0;
            if (isStudent == 'Y') discPercent += 0.10;
            if (subTotal >= 500) discPercent += 0.05;
            
            double discountAmt = subTotal * discPercent;
            double orderTotal = subTotal - discountAmt;
            
            System.out.printf("Subtotal: $%.2f%n", subTotal);
            System.out.printf("Discount: $%.2f%n", discountAmt);
            System.out.printf("Order total: $%.2f%n", orderTotal);
            
            totalItems += qty;
            totalBeforeDiscount += subTotal;
            totalDiscount += discountAmt;
            
            System.out.print("Do you want to order again? (Y/N): ");
            char again = input.next().toUpperCase().charAt(0);
            if (again != 'Y') {
                ordering = false;
            }
        }
        
        double finalAmount = totalBeforeDiscount - totalDiscount;
        System.out.println("\n===== ORDER SUMMARY =====");
        System.out.println("Total items: " + totalItems);
        System.out.printf("Total before discount: $%.2f%n", totalBeforeDiscount);
        System.out.printf("Total discount: $%.2f%n", totalDiscount);
        System.out.printf("Final amount: $%.2f%n", finalAmount);
        System.out.println("Thank you for ordering!");
        
        input.close();
    }
}
