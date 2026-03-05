import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        ExpenseDAO dao = new ExpenseDAO();

        while(true){

            System.out.println("\n===== Expense Tracker =====");

            System.out.println("1 Add Expense");
            System.out.println("2 View Expenses");
            System.out.println("3 Exit");

            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if(choice==1){

                System.out.print("Enter title: ");
                String title = sc.nextLine();

                System.out.print("Enter amount: ");
                double amount = sc.nextDouble();
                sc.nextLine();

                System.out.print("Enter category: ");
                String category = sc.nextLine();

                System.out.print("Enter date (YYYY-MM-DD): ");
                String date = sc.nextLine();

                Expense expense = new Expense(title,amount,category,date);

                dao.addExpense(expense);

            }

            else if(choice==2){

                dao.viewExpenses();

            }

            else if(choice==3){

                System.out.println("Program Ended");

                break;

            }

        }

    }

}