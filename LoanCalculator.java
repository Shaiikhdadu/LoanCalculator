import java.util.Scanner;

public class LoanCalculator {

    public static void calculateLoan(int accountNumber, int salary, int accountBalance, 
                                     String loanType, int loanAmountExpected, int customerEmiExpected) {

        int eligibleLoanAmount = 0;
        int bankEmiExpected = 0;

        // Validate account number and balance requirements
        if (String.valueOf(accountNumber).length() != 4 || String.valueOf(accountNumber).charAt(0) != '1') {
            System.out.println("Invalid account number");
            return;
        }
        
        if (accountBalance < 100000) {
            System.out.println("Insufficient account balance");
            return;
        }

        // Determine eligible loan amount and EMI based on salary and loan type
        if (salary > 75000 && loanType.equalsIgnoreCase("Business")) {
            eligibleLoanAmount = 7500000;
            bankEmiExpected = 84;
        } else if (salary > 50000 && loanType.equalsIgnoreCase("House")) {
            eligibleLoanAmount = 6000000;
            bankEmiExpected = 60;
        } else if (salary > 25000 && loanType.equalsIgnoreCase("Car")) {
            eligibleLoanAmount = 500000;
            bankEmiExpected = 36;
        } else {
            System.out.println("Invalid loan type or salary");
            return;
        }

        // Check if requested loan amount and EMIs are within eligibility
        if (loanAmountExpected <= eligibleLoanAmount && customerEmiExpected <= bankEmiExpected) {
            System.out.println("Account number: " + accountNumber);
            System.out.println("The customer can avail the amount of Rs. " + eligibleLoanAmount);
            System.out.println("Eligible EMIs : " + bankEmiExpected);
            System.out.println("Requested loan amount: " + loanAmountExpected);
            System.out.println("Requested EMI's: " + customerEmiExpected);
        } else {
            System.out.println("The customer is not eligible for the loan");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("account_number: ");
        int accountNumber = scanner.nextInt();
        
        System.out.print("salary: ");
        int salary = scanner.nextInt();
        
        System.out.print("account_balance: ");
        int accountBalance = scanner.nextInt();
        
        scanner.nextLine();  // Consume newline left-over
        System.out.print("loan_type: ");
        String loanType = scanner.nextLine();
        
        System.out.print("loan_amount_expected: ");
        int loanAmountExpected = scanner.nextInt();
        
        System.out.print("customer_emi_expected: ");
        int customerEmiExpected = scanner.nextInt();

        // Function call
        calculateLoan(accountNumber, salary, accountBalance, loanType, loanAmountExpected, customerEmiExpected);

        scanner.close();
    }
}
