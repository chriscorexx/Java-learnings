class InvalidAgeException extends Exception {
    InvalidAgeException(String msg) {
        super(msg);
    }
}

class PracticalSixteen {
    public static void main(String[] args) {

        // Inbuilt Exception
        try {
            int a = 10 / 0;
        }
        catch (ArithmeticException e) {
            System.out.println("Inbuilt Exception: " + e);
        }
        finally {
            System.out.println("Inbuilt Exception Finally Block");
        }

        // User Defined Exception
        try {
            int age = 16;

            if (age < 18) {
                throw new InvalidAgeException("Age must be 18 or above");
            }

            System.out.println("Eligible to vote");
        }
        catch (InvalidAgeException e) {
            System.out.println("User Defined Exception: " + e.getMessage());
        }
        finally {
            System.out.println("User Defined Exception Finally Block");
        }
    }
}
