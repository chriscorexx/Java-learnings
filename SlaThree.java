import java.util.Scanner;

class SlaThree {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String products[] = {
            "Keyboard", "Mouse", "Headphones",
            "Monitor", "USB Drive"
        };

        double prices[] = {800, 500, 1500, 7000, 600};

        int cart[] = new int[5];
        int choice, quantity;
        double total, discount, finalAmount;
        String payment = "";

        System.out.println("==================================");
        System.out.println("       ONLINE SHOPPING SYSTEM");
        System.out.println("==================================");

        while (true) {
            System.out.println("\n1. Item Selection");
            System.out.println("2. Payment Selection");
            System.out.println("3. Order Confirmation");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            if (choice == 1) {

                System.out.println("\n------ AVAILABLE PRODUCTS ------");

                for (int i = 0; i < products.length; i++) {
                    System.out.println((i + 1) + ". " + products[i]
                            + " - Rs." + prices[i]);
                }

                System.out.println("\n1. Add Item");
                System.out.println("2. Remove Item");
                System.out.print("Enter choice: ");

                int action = sc.nextInt();

                System.out.print("Enter product number (1-5): ");
                int productNo = sc.nextInt();

                if (productNo < 1 || productNo > 5) {
                    System.out.println("Invalid product selection!");
                    continue;
                }

                int index = productNo - 1;

                if (action == 1) {

                    System.out.print("Enter quantity: ");
                    quantity = sc.nextInt();

                    if (quantity > 0) {
                        cart[index] += quantity;
                        System.out.println("Item added successfully!");
                    } else {
                        System.out.println("Invalid quantity!");
                    }

                } else if (action == 2) {

                    if (cart[index] > 0) {
                        System.out.print("Enter quantity to remove: ");
                        quantity = sc.nextInt();

                        if (quantity > 0 && quantity <= cart[index]) {
                            cart[index] -= quantity;
                            System.out.println("Item removed successfully!");
                        } else {
                            System.out.println("Invalid quantity!");
                        }
                    } else {
                        System.out.println("Item not found in cart!");
                    }

                } else {
                    System.out.println("Invalid action!");
                }

            } else if (choice == 2) {

                System.out.println("\n------ PAYMENT METHODS ------");
                System.out.println("1. Cash on Delivery");
                System.out.println("2. UPI");
                System.out.println("3. Debit/Credit Card");

                System.out.print("Select payment method: ");
                int p = sc.nextInt();

                if (p == 1) {
                    payment = "Cash on Delivery";
                } else if (p == 2) {
                    payment = "UPI";
                } else if (p == 3) {
                    payment = "Debit/Credit Card";
                } else {
                    payment = "";
                    System.out.println("Invalid payment method!");
                    continue;
                }

                System.out.println("Payment method selected: " + payment);

            } else if (choice == 3) {

                total = 0;
                discount = 0;

                System.out.println("\n========== SHOPPING CART ==========");

                for (int i = 0; i < products.length; i++) {
                    if (cart[i] > 0) {
                        double itemTotal = prices[i] * cart[i];
                        total += itemTotal;

                        System.out.println(products[i] + " x " + cart[i]
                                + " = Rs." + itemTotal);
                    }
                }

                if (total == 0) {
                    System.out.println("Your cart is empty!");
                    continue;
                }

                if (total >= 5000) {
                    discount = total * 0.10;
                } else if (total >= 3000) {
                    discount = total * 0.05;
                }

                finalAmount = total - discount;

                System.out.println("----------------------------------");
                System.out.println("Total Amount : Rs." + total);
                System.out.println("Discount     : Rs." + discount);
                System.out.println("Final Amount : Rs." + finalAmount);

                if (payment.equals("")) {
                    System.out.println("Please select a payment method first.");
                    continue;
                }

                System.out.print("\nConfirm Order? (1-Yes / 2-No): ");
                int confirm = sc.nextInt();

                if (confirm == 1) {
                    System.out.println("\n========== ORDER CONFIRMED ==========");
                    System.out.println("Payment Method : " + payment);
                    System.out.println("Amount         : Rs." + finalAmount);
                    System.out.println("Order Status   : Successful");
                    System.out.println("Thank you for shopping!");
                    break;
                } else {
                    System.out.println("Order cancelled!");
                    break;
                }

            } else if (choice == 4) {
                System.out.println("Thank you for visiting!");
                break;

            } else {
                System.out.println("Invalid choice! Try again.");
            }
        }

        sc.close();
    }
}
